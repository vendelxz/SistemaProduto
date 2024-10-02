package br.ufpb.wendel.dcx.projetoproduto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaProduto implements ProductInterface {
    private Map<String, Produto> produtos = new HashMap<>();

    @Override
    public void CadastraProduto(String nome, TipoProduto tipo, String descricao) throws ProdutoExistenteException {
    for(Produto p: produtos.values()){
        if (p.getDescricao().equals(descricao)){
            throw new  ProdutoExistenteException("O produto já existe");
        }
    }
        Produto p1 = new Produto(nome, tipo, descricao);
        produtos.put(descricao, p1);


    }

    @Override
    public void removerProduto(String descricao) {
        for(Produto p: produtos.values()){
            if(p.getDescricao().equals(descricao)){
                produtos.remove(descricao);
            }
        }

    }

    @Override
    public List<Produto> pesquisarProduto(String nome) {
        List<Produto> achados = new ArrayList<>();
        for (Produto p: produtos.values()){
            if (p.getNome().equals(nome)){
                achados.add(p);
            }
        } return achados;
    }
}
