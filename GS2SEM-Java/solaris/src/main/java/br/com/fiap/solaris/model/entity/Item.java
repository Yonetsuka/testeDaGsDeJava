package br.com.fiap.solaris.model.entity;

import br.com.fiap.solaris.model.dto.RequisicaoNovoPedido;
import jakarta.persistence.*;


import java.math.BigDecimal;

@Entity(name = "Item")
@Table(name = "item")
public class Item{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoProduto;
    private String nomeProduto;
    private BigDecimal valor;
    private String urlProduto;
    private String urlImagem;
    private String descricao;

    public Long getCodigoProduto(){
        return codigoProduto;
    }
    public String getNomeProduto(){
        return nomeProduto;
    }
    public BigDecimal getValor(){
        return valor;
    }
    public String getUrlProduto(){
        return urlProduto;
    }
    public String getUrlImagem(){
        return urlImagem;
    }
    public String getDescricao(){
        return descricao;
    }

    public void setCodigoProduto(Long codigoProduto){
        this.codigoProduto = codigoProduto;
    }
    public void setNomeProduto(String nome){
        this.nomeProduto = nome;
    }
    public void setValor(BigDecimal valor){
        this.valor = valor;
    }
    public void setUrlProduto(String urlProduto){
        this.urlProduto = urlProduto;
    }
    public void setUrlImagem(String urlImagem){
        this.urlImagem = urlImagem;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public Item(){}

    public Item(RequisicaoNovoPedido requisicao){
        this.nomeProduto = requisicao.nomeProduto();
        this.urlProduto = requisicao.urlProduto();
        this.urlImagem = requisicao.urlImagem();
        this.descricao = requisicao.descricao();
    }
}
