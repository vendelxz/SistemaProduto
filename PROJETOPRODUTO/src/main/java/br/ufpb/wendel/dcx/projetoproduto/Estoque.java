package br.ufpb.wendel.dcx.projetoproduto;

public class Estoque {
    private Produto produto;
    private int quantidade;

    public Estoque(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;

    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
       if(quantidade < 0){
           throw new IllegalArgumentException("Quantidade menor que 0");
       }

        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

}
