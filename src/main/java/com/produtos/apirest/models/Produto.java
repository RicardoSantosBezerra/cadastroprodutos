package com.produtos.apirest.models;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

//Definido nome da tabela para não ser criada pelo JPA com o mesmo nome da Classe "Entity irá definir a
// tabela como uma entidade no banco de dados e Table que essa entidade será uma tabela". A classe
//referencia a tabela e os atributos/variáveis serão a representação das colunas
@Entity
@Table(name="TB_PRODUTO")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    //Anotação para criar Id como identity
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;

    private BigDecimal quantidade;

    private BigDecimal valor;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
