package br.com.guedes.jwt.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Championships {

    @Id
    private String id;
    private String nome;

    public Championships() {}

    public Championships(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
