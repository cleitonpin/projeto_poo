package br.projeto.api.springapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "empresa_transporte")
public class EmpresaTransporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transportadora_id", referencedColumnName = "id")
    private Transportadora transportadora;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ambiente_id", referencedColumnName = "id")
    private Ambiente ambiente;

    @Column(name = "nome_social", nullable = true)
    private String nomeSocial;

    @Column(name = "sigla", nullable = true)
    private String sigla;

    @Column(name = "nome_fantasia", nullable = true)
    private String nomeFantasia;

    @Column(name = "cnpj", nullable = true)
    private String cnpj;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "endereco", nullable = true)
    private String endereco;

    @Column(name = "pais", nullable = true)
    private String pais;

    @Column(name = "uf", nullable = true)
    private String uf;

    @Column(name = "municipio", nullable = true)
    private String municipio;

    @Column(name = "bairro", nullable = true)
    private String bairro;
    
    @Column(name = "complemento", nullable = true)
    private String complemento;

    @Column(name = "logradouro", nullable = true)
    private String logradouro;

    @Column(name = "numero", nullable = true)
    private Integer numero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cidade getPais() {
        return cidade;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}