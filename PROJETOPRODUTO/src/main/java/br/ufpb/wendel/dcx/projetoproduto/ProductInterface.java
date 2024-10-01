package br.ufpb.wendel.dcx.projetoproduto;

import java.util.List;

public interface ProductInterface {

    public void CadastraProduto(String nome, TipoProduto tipo, String descricao) throws ProdutoExistenteException;
    public void removerProduto(String descricao);
    public List<Produto> pesquisarProduto(String nome);
}
