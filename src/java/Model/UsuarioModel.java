package Model;

import DAO.EscolaridadeDAO;
import DAO.MatchDAO;
import DAO.UsuarioDAO;
import Entities.Arquivo;
import Entities.Escolaridade;
import Entities.Interesse;
import Entities.Match;
import Entities.Usuario;
import Util.Retorno;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;

public class UsuarioModel {

    public Retorno<String, Usuario> adicionarUsuario(String nome, String data, String email, String instituicao, String senha, String confsenha, String idEscolaridade, Arquivo fotoperfil) {
        Retorno retorno = new Retorno();
        UsuarioDAO dao = new UsuarioDAO();
        if ("".equals(nome) || "".equals(data) || "".equals(senha) || "".equals(confsenha) || "".equals(email) || idEscolaridade.equals("0")) {
            retorno.setValor(null);
            retorno.setChave("Preencha todos os campos!");
        } else {
            if (fotoperfil == null) {
                retorno.setValor(null);
                retorno.setChave("Selecione uma foto de perfil");
            } else {
                if (!senha.equals(confsenha)) {
                    retorno.setValor(null);
                    retorno.setChave("As senhas não coincidem!");
                } else {
                    Usuario u = dao.buscarPorEmail(email);
                    if (u != null) {
                        retorno.setValor(null);
                        retorno.setChave("Email cadastrado");
                    } else {
                        u = new Usuario();
                        u.setNome(nome);
                        //Transformar data de String para date
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            Date date = formatter.parse(data);
                            u.setData_de_nascimento(date);
                        } catch (ParseException e) {
                            u.setData_de_nascimento(new Date());
                        }
                        u.setEmail(email);
                        u.setSenha(senha);
                        u.setInstituicao(instituicao);
                        //Transformar id escolaridade para o objeto
                        EscolaridadeDAO escDao = new EscolaridadeDAO();
                        Escolaridade escolaridade = escDao.get(Integer.parseInt(idEscolaridade));
                        u.setIdEscolaridade(escolaridade);
                        u.setBiografia("");
                        u.setFoto_de_perfil(fotoperfil);
                        u = dao.flushcreate(u);
                        retorno.setValor(u);
                        retorno.setChave("Cadastrado com sucesso;");
                    }
                }

            }
        }
        return retorno;
    }

    public List<Usuario> getMatches(Usuario u) {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        MatchDAO dao = new MatchDAO();
        List<Match> matches = dao.findAll();
        for (Match match : matches) {
            if (match.getUsuario_um().getIdUsuario() == u.getIdUsuario()) {
                usuarios.add(match.getUsuario_dois());
            } else if (match.getUsuario_dois().getIdUsuario() == u.getIdUsuario()) {
                usuarios.add(match.getUsuario_um());
            }
        }
        return usuarios;
    }

    public String checarMatch(int id1, int id2) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = this.getByID(id1);
        Usuario c = dao.getComFetch(id2);
        boolean retorno = false;
        for (Usuario x : c.getCurtidas()) {
            if (x.getIdUsuario() == u.getIdUsuario()) {
                retorno = true;
                break;
            }
        }

        if (retorno) {
            MatchModel model = new MatchModel();
            model.adicionarMatch(u, c);
            return "match";

        } else {
            return "like";

        }

    }

    public String curtir(int idUsuario, int idUsuarioCurtido) {
        UsuarioDAO dao = new UsuarioDAO();
        dao.curtir(idUsuario, idUsuarioCurtido);

        return checarMatch(idUsuario, idUsuarioCurtido);
    }

    public List<Usuario> getUsuarios() {
        UsuarioDAO dao = new UsuarioDAO();
        List lista = dao.findAll();
        return lista;

    }

    public Retorno<Usuario, String> entrar(String email, String senha) {
        Retorno retorno = new Retorno();

        if ("".equals(email) || "".equals(senha)) {
            retorno.setValor("Preencha todos os campos!");
            retorno.setChave(null);
        } else {
            UsuarioDAO dao = new UsuarioDAO();
            Usuario u = dao.buscarPorEmail(email);
            if (u == null) {
                retorno.setValor("Email ou senha incorretos!");
                retorno.setChave(null);
            } else {
                if (u.getSenha().equals(senha)) {
                    retorno.setChave(u);
                    retorno.setValor("Entro");
                } else {
                    retorno.setChave(null);
                    retorno.setValor("Email ou senha incorretos!");
                }

            }
        }
        return retorno;
    }

    public Usuario getByID(int id) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = dao.get(id);
        return u;
    }

    public Retorno<String, Usuario> posCadastro(Usuario u, String curriculo, List<Interesse> Lista) {
        Retorno retorno = new Retorno();
        UsuarioDAO dao = new UsuarioDAO();
        if ("".equals(curriculo)) {
            retorno.setValor(null);
            retorno.setChave("Preencha todos os campos!");
        } else {
            if (Lista.isEmpty()) {
                retorno.setChave("Selecione algum interesse");
            } else {
                u.setBiografia(curriculo);
                u.setInteresses(Lista);
                u = dao.flushupdate(u);
                retorno.setValor(u);
                retorno.setChave("Cadastrado com sucesso;");

            }

        }
        return retorno;
    }

    /*
    public List<Usuario> getPerfis(Usuario u) {
        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> lista = new ArrayList<Usuario>();
        List<Usuario> usuarios = dao.findAll();
        boolean adicionou;
        for (Usuario us : usuarios) {
            if (us.getIdUsuario() != u.getIdUsuario()) {
                adicionou = false;
                for (Interesse i : us.getInteresses()) {
                    if (!adicionou) {
                        for (Interesse j : u.getInteresses()) {
                            if (j.getId() == i.getId()) {
                                lista.add(us);
                                adicionou = true;

                            }
                        }
                    }

                }
            }
        }
        return lista;
    }
     */
    public List<Usuario> getPerfis(Usuario a) {
        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> lista = new ArrayList<Usuario>();
        List<Usuario> usuarios = dao.findAll();
        Usuario u = dao.getComFetch(a.getIdUsuario());
        for (Usuario us : usuarios) {
            if (us.getIdUsuario() != u.getIdUsuario()) {
                if (listaDeslike(u, us) || listaLike(u, us)) {
                    //Não adicionar
                } else if (interesseComum(u, us)) {
                    lista.add(us);
                }
            }
        }
        return lista;
    }

    public Retorno<Boolean, String> adicionarLike(Usuario u, Usuario l) {
        Retorno<Boolean, String> retorno = new Retorno<>();
        retorno.setChave(true);

        return retorno;
    }

    //Funções Auxiliares
    private boolean listaDeslike(Usuario u, Usuario d) {
        boolean retorno = false;
        for (Usuario i : u.getDescurtirdas()) {
            if (d.getIdUsuario() == i.getIdUsuario()) {
                retorno = true;
            }
        }
        return retorno;
    }

    private boolean listaLike(Usuario u, Usuario l) {
        boolean retorno = false;
        for (Usuario i : u.getCurtidas()) {
            if (l.getIdUsuario() == i.getIdUsuario()) {
                retorno = true;
            }
        }
        return retorno;
    }

    private boolean interesseComum(Usuario u, Usuario i) {
        boolean retorno = false;
        for (Interesse x : u.getInteresses()) {
            for (Interesse y : i.getInteresses()) {
                if (x.getId() == y.getId()) {
                    retorno = true;
                    break;
                }
            }
        }
        return retorno;
    }

    public void atualizar(Usuario u) {
        UsuarioDAO dao = new UsuarioDAO();
        dao.update(u);

    }
}

/*
//Apagar
                for(Interesse x : us.getInteresses()){
                    System.out.println(x.getDescricao());
                    System.out.println(x.getId());
                }
                //até aqui
                for(Interesse i : u.getInteresses()){
                    if(us.getInteresses().contains(i)){
                        lista.add(us);
                        break;
                    }
                }
 */
