package br.ufpb.wendel.dcx.projetoproduto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class ProdutoGUI extends JFrame {
    private SistemaProduto sistemaProduto;
    public ProdutoGUI() {
        sistemaProduto = new SistemaProduto();

        // Configurações do JFrame
        setTitle("Sistema de Produtos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null); // Centraliza na tela
        setLayout(new BorderLayout());

        // Cria e adiciona a barra de menu
        setJMenuBar(criarMenu());

        // Cria e adiciona o painel central
        JPanel painelCentral = criarPainelCentral();
        add(painelCentral, BorderLayout.CENTER);

        // Torna o JFrame visível
        setVisible(true);
    }

    private JMenuBar criarMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArq = new JMenu("Produtos");
        menuBar.add(menuArq);

        // Cria itens de menu
        JMenuItem menuItemAdicionar = new JMenuItem("Adicionar");
        JMenuItem menuItemPesquisar = new JMenuItem("Pesquisar");
        JMenuItem menuItemRemover = new JMenuItem("Remover");
        JMenuItem menuItemSair = new JMenuItem("Sair");

        // Adiciona ações aos itens de menu
        menuItemAdicionar.addActionListener(e -> mostrarOpcao("Adicionar Produto"));
        menuItemPesquisar.addActionListener(e -> mostrarOpcao("Pesquisar Produto"));
        menuItemRemover.addActionListener(e -> mostrarOpcao("Remover Produto"));
        menuItemSair.addActionListener(e -> System.exit(0));

        // Adiciona os itens ao menu
        menuArq.add(menuItemAdicionar);
        menuArq.add(menuItemPesquisar);
        menuArq.add(menuItemRemover); // Adicionado aqui
        menuArq.addSeparator();
        menuArq.add(menuItemSair);

        return menuBar;
    }

    private JPanel criarPainelCentral() {
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new GridBagLayout());

        // Cria botões no centro
        JButton btnAdicionar = new JButton("Adicionar Produto");
        JButton btnPesquisar = new JButton("Pesquisar Produto");
        JButton btnRemover = new JButton("Remover Produto");

        btnAdicionar.addActionListener(e -> adicionarProduto());
        btnPesquisar.addActionListener(e -> pesquisarProduto());
        btnRemover.addActionListener(e -> removerProduto());

        painelCentral.add(btnAdicionar);
        painelCentral.add(btnPesquisar);
        painelCentral.add(btnRemover);

        return painelCentral;
    }

    private void adicionarProduto() {
        // Exibe um diálogo para adicionar produto
        JTextField nomeField = new JTextField(10);
        JTextField descricaoField = new JTextField(10);
        String[] tipos = {"DIVERSOS", "MATERIAIS", "TECNOLOGICOS"};
        JComboBox<String> tipoComboBox = new JComboBox<>(tipos);

        JPanel painel = new JPanel();
        painel.add(new JLabel("Nome:"));
        painel.add(nomeField);
        painel.add(new JLabel("Tipo:"));
        painel.add(tipoComboBox);
        painel.add(new JLabel("Descrição:"));
        painel.add(descricaoField);

        int result = JOptionPane.showConfirmDialog(this, painel, "Adicionar Produto", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String nome = nomeField.getText();
            TipoProduto tipo = TipoProduto.valueOf((String) tipoComboBox.getSelectedItem());
            String descricao = descricaoField.getText();
            try {
                sistemaProduto.CadastraProduto(nome, tipo, descricao);
                mostrarOpcao("Produto adicionado com sucesso!");
            } catch (ProdutoExistenteException e) {
                mostrarOpcao(e.getMessage());
            }
        }
    }

    private void pesquisarProduto() {
        String nome = JOptionPane.showInputDialog(this, "Digite o nome do produto:");
        if (nome != null && !nome.trim().isEmpty()) {
            List<Produto> produtosEncontrados = sistemaProduto.pesquisarProduto(nome);
            if (produtosEncontrados.isEmpty()) {
                mostrarOpcao("Nenhum produto encontrado com o nome: " + nome);
            } else {
                StringBuilder sb = new StringBuilder("Produtos encontrados:\n");
                for (Produto p : produtosEncontrados) {
                    sb.append("Nome: ").append(p.getNome()).append(", Descrição: ").append(p.getDescricao()).append("\n");
                }
                mostrarOpcao(sb.toString());
            }
        }
    }


    private void removerProduto() {
        // Exibe um diálogo para remover produto
        String descricao = JOptionPane.showInputDialog(this, "Digite a descrição do produto a ser removido:");
        if (descricao != null && !descricao.trim().isEmpty()) {
            sistemaProduto.removerProduto(descricao);
            mostrarOpcao("Produto removido com sucesso!");
        } else {
            mostrarOpcao("Descrição não pode ser vazia.");
        }
    }

    private void mostrarOpcao(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }
}
