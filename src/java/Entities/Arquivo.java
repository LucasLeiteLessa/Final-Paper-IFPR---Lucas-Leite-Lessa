/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author lucas
 */

@Entity
public class Arquivo {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String nome;
    String contentType;

    public Arquivo(int id, String nome, String contentType) {
        this.id = id;
        this.nome = nome;
        this.contentType = contentType;
    }

    public Arquivo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    
    

}
