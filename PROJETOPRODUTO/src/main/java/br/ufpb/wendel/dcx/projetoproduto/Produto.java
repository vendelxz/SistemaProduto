package br.ufpb.wendel.dcx.projetoproduto;

import java.util.Objects;

public class Produto {
    private String nome;
    private TipoProduto tipo;
    private String descricao;

    public Produto(String nome, TipoProduto tipo, String descricao){
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
    }
    public Produto(){
        this("",TipoProduto.INVALIDO,"");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome) && tipo == produto.tipo && Objects.equals(descricao, produto.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, tipo, descricao);
    }
    public String toString(){
        return "[Nome do produto: "+this.nome+" , Tipo do produto: "+this.tipo+" , e sua descrição: "+this.descricao+" ]";
    }
}
