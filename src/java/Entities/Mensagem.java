package Entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "mensagem")
public class Mensagem {

    private int id;
    private Usuario remetente;
    private Usuario destinatario;
    private String texto;
    private Date data;

    public Mensagem(Usuario remetente, Usuario destinatario, String texto, Date data) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.texto = texto;
        this.data = data;
    }

    public Mensagem() {
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
    @JoinColumn(name = "id_remetente", nullable = false)
    public Usuario getRemetente() {
        return remetente;
    }

    public void setRemetente(Usuario remetente) {
        this.remetente = remetente;
    }

    @ManyToOne
    @JoinColumn(name = "id_destinatario", nullable = false)
    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    @Lob
    @Column(nullable = false, length = 256)
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
