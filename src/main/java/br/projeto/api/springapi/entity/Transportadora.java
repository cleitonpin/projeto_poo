package br.projeto.api.springapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.json.JSONArray;

@Entity
@Table(name = "transportadora")
public class Transportadora {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "empresa_atual", nullable = false)
    private String empresa_atual;

    @Column(name = "ctes_por_mes", nullable = false)
    private Integer ctes_por_mes;

    @Column(name= "tipo_empresa", nullable = false)
    private String tipo_empresa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmpresa_atual() {
        return empresa_atual;
    }

    public void setEmpresa_atual(String empresaAtual) {
        this.empresa_atual = empresaAtual;
    }

    public Integer getCtes_por_mes() {
        return ctes_por_mes;
    }

    public void setCtes_por_mes(Integer ctes_por_mes) {
        this.ctes_por_mes = ctes_por_mes;
    }

    public String getTipo_empresa() {
        return tipo_empresa;
    }

    public void setTipo_empresa(String tipo_empresa) {
        this.tipo_empresa = tipo_empresa;
    }

  
    
}
