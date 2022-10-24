package Entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint (columnNames = {"email"}))
public class Usuario {

    private int idUsuario;
    private String nome;
    private String email;
    private Date data_de_nascimento;
    private String senha;
    private Arquivo foto_de_perfil;
    private String instituicao;
    private String biografia;
    private Escolaridade idEscolaridade;
    private List<Interesse> interesses;
    private List<Usuario> curtidas;
    private List<Usuario> descurtirdas;
        

    public Usuario(String nome, String email, Date data_de_nascimento, String senha, Escolaridade idEscolaridade) {
        this.nome = nome;
        this.email = email;
        this.data_de_nascimento = data_de_nascimento;
        this.senha = senha;
        this.idEscolaridade = idEscolaridade;
        this.curtidas = new ArrayList<Usuario>();
        this.descurtirdas = new ArrayList<Usuario>();
    }

    public Usuario(String nome, String email, Date data_de_nascimento, String senha, String foto_de_perfil, String instituicao, String biografia, Escolaridade idEscolaridade) {
        this.nome = nome;
        this.email = email;
        this.data_de_nascimento = data_de_nascimento;
        this.senha = senha;
        this.instituicao = instituicao;
        this.biografia = biografia;
        this.idEscolaridade = idEscolaridade;
        this.curtidas = new ArrayList<Usuario>();
        this.descurtirdas = new ArrayList<Usuario>();
    }

    public Usuario() {
        this.curtidas = new ArrayList<Usuario>();
        this.descurtirdas = new ArrayList<Usuario>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Basic
    @Column(nullable = false, length = 100)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(nullable = false, length = 45, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getData_de_nascimento() {
        return data_de_nascimento;
    }

    public void setData_de_nascimento(Date data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }

    @Basic
    @Column(nullable = false, length = 16)
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "imagem_id")
    public Arquivo getFoto_de_perfil() {
        return foto_de_perfil;
    }

    public void setFoto_de_perfil(Arquivo foto_de_perfil) {
        this.foto_de_perfil = foto_de_perfil;
    }

    

    @Basic
    @Column(nullable = true, length = 128)
    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    @Basic
    @Column(nullable = true, length = 256)
    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    @ManyToOne
    @JoinColumn(name = "id_escolaridade", nullable = false)
    public Escolaridade getIdEscolaridade() {
        return idEscolaridade;
    }

    public void setIdEscolaridade(Escolaridade idEscolaridade) {
        this.idEscolaridade = idEscolaridade;
    }

    @ManyToMany
    @JoinTable(name = "Usuario_has_interesse", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "interesse_id"))
    public List<Interesse> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<Interesse> interesses) {
        this.interesses = interesses;
    }

    @Override
    public String toString() {
        return this.email;
    }
    
    @OneToMany (cascade = CascadeType.ALL)
    @JoinTable(name = "curtidas", joinColumns = @JoinColumn(name = "usuario_id"))
    public List<Usuario> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<Usuario> curtidas) {
        this.curtidas = curtidas;
    }

    @OneToMany (cascade = CascadeType.ALL)
    @JoinTable(name = "descurtidas", joinColumns = @JoinColumn(name = "usuario_id"))
    public List<Usuario> getDescurtirdas() {
        return descurtirdas;
    }

    public void setDescurtirdas(List<Usuario> descurtirdas) {
        this.descurtirdas = descurtirdas;
    }
    
    
}
