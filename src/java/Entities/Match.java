package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matchu")
public class Match {

    private int id;
    private Usuario usuario_um;
    private Usuario usuario_dois;

    public Match(Usuario usuario_um, Usuario usuario_dois) {
        this.usuario_um = usuario_um;
        this.usuario_dois = usuario_dois;
    }

    public Match() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "id_usuario_um")
    public Usuario getUsuario_um() {
        return usuario_um;
    }

    public void setUsuario_um(Usuario usuario_um) {
        this.usuario_um = usuario_um;
    }

    @ManyToOne
    @JoinColumn(name = "id_usuario_dois")
    public Usuario getUsuario_dois() {
        return usuario_dois;
    }

    public void setUsuario_dois(Usuario usuario_dois) {
        this.usuario_dois = usuario_dois;
    }

}
