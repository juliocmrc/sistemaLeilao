package br.edu.ifg.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainMenu extends JFrame {

	private JMenuBar menuBar;
	private JMenu menuCadastro;
	private JMenuItem pessoaCadastro;
	private JMenuItem leilaoCadastro;

	public MainMenu() {
		init();
	}

	private void init() {

		setBounds(0, 0, 1000, 500);
		setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setSize(1000, 20);
		menuBar.setLocation(0, 0);

		menuCadastro = new JMenu("Cadastros");

		pessoaCadastro = new JMenuItem("Cadastro de pessoa");

		leilaoCadastro = new JMenuItem("Cadastro de leilão");

		menuBar.add(menuCadastro);
		menuCadastro.add(pessoaCadastro);
		menuCadastro.add(leilaoCadastro);

		pessoaCadastro.addActionListener(cadastroPessoaMenuActionListener());

		leilaoCadastro.addActionListener(cadastroLeilaoMenuActionListener());

		add(menuBar);

		setVisible(true);

	}

	private ActionListener cadastroLeilaoMenuActionListener() {

		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new LeilaoGUI();

			}
		};
	}

	private ActionListener cadastroPessoaMenuActionListener() {

		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PessoaGUI();

			}
		};
	}

	public static void main(String[] args) {
		new MainMenu();

	}

}
