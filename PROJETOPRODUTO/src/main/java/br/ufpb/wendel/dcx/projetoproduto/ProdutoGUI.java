package br.ufpb.wendel.dcx.projetoproduto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdutoGUI {
    public ProdutoGUI() {
        // Cria o JFrame
        JFrame box = new JFrame();
        box.setTitle("Sistema de Produtos");
        box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        box.setSize(500, 500);
        box.setLayout(new BorderLayout());

        // Cria a barra de menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArq = new JMenu("Produtos");
        menuBar.add(menuArq);

        // Cria itens de menu
        JMenuItem menuItemAdicionar = new JMenuItem("Adicionar");
        JMenuItem menuItemPesquisar = new JMenuItem("Pesquisar");
        JMenuItem menuItemSair = new JMenuItem("Sair");

        // Adiciona ações aos itens de menu
        menuItemAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarOpcao("Adicionar Produto");
            }
        });

        menuItemPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarOpcao("Pesquisar Produto");
            }
        });

        menuItemSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Adiciona os itens ao menu
        menuArq.add(menuItemAdicionar);
        menuArq.add(menuItemPesquisar);
        menuArq.addSeparator();
        menuArq.add(menuItemSair);

        // Adiciona a barra de menu ao JFrame
        box.setJMenuBar(menuBar);

        // Cria um painel central
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new GridBagLayout());

        // Cria botões no centro
        JButton btnAdicionar = new JButton("Adicionar Produto");
        JButton btnPesquisar = new JButton("Pesquisar Produto");

        btnAdicionar.addActionListener(e -> mostrarOpcao("Adicionar Produto"));
        btnPesquisar.addActionListener(e -> mostrarOpcao("Pesquisar Produto"));

        painelCentral.add(btnAdicionar);
        painelCentral.add(btnPesquisar);

        // Adiciona o painel central ao JFrame
        box.add(painelCentral, BorderLayout.CENTER);

        // Torna o JFrame visível
        box.setVisible(true);
    }

    private void mostrarOpcao(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
