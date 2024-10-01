package br.ufpb.wendel.dcx.projetoproduto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdutoGUI extends JFrame {
    public ProdutoGUI() {
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
        JButton btnRemover = new JButton("Remover Produto"); // Novo botão

        btnAdicionar.addActionListener(e -> mostrarOpcao("Adicionar Produto"));
        btnPesquisar.addActionListener(e -> mostrarOpcao("Pesquisar Produto"));
        btnRemover.addActionListener(e -> mostrarOpcao("Remover Produto")); // Ação para o novo botão

        painelCentral.add(btnAdicionar);
        painelCentral.add(btnPesquisar);
        painelCentral.add(btnRemover); // Adicionado aqui

        return painelCentral;
    }

    private void mostrarOpcao(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }
}
