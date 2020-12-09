package br.projeto.api.springapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "username", nullable = false)
    private String username;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "senha", nullable = false)
    private String senha;

    // public Users(Long id, String nome, String username, String senha) {
    //     this.id = id;
    //     this.nome = nome;
    //     this.username = username;
    //     this.senha = senha;
    // }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(long id) {
        this.id = id;
    }
}