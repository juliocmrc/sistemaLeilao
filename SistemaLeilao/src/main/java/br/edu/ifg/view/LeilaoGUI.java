package br.edu.ifg.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.edu.ifg.database.ManageLeilao;
import br.edu.ifg.entidades.*;
import br.edu.ifg.models.ModelTableLeilao;

public class LeilaoGUI extends JFrame {
	private JFrame frame;
	private JPanel container;
	private JTextField fieldPreco;
	private JLabel labelPreco;
	private JTextField fieldItem;
	private JLabel labelItem;
	private JTextField fieldSituacao;
	private JLabel labelSituacao;
	private JButton btnAdiciona;
	private JButton btnDelete;
	private JButton btnEdit;
	private JButton btnLeiloar;
	private JTable table;

	private final String TITULO = "Leiloes";
	private final String LABEL_ITEM = "Item";
	private final String LABEL_PRECO = "Preco";
	private final String LABEL_SITUACAO = "Situacao";
	private final String LABEL_ADICIONA = "Adicionar";
	private final String LABEL_EDITA = "Editar";
	private final String LABEL_EXCLUI = "Excluir";
	private final String LABEL_LEILOAR = "Leiloar";

	private List<Leilao> leiloesAdicionados = ManageLeilao.listaLeiloes();
	private ModelTableLeilao modelLeilao = new ModelTableLeilao(leiloesAdicionados);

	public LeilaoGUI() {
		frame = this;
		frame.setTitle(TITULO);
		init();

		inicializaLeilao();
		setVisible(true);
	}

	public void init() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 1000, 500);
		this.setResizable(false);

		container = new JPanel();
		container.setLayout(null);

		add(container);

	}

	private void inicializaLeilao() {
		container.setBorder(new TitledBorder("Dados dos itens"));

		fieldItem = new JTextField();
		fieldItem.setBounds(55, 30, 900, 25);
		labelItem = new JLabel(LABEL_ITEM);
		labelItem.setBounds(3, 30, 100, 25);

		fieldPreco = new JTextField();
		fieldPreco.setBounds(55, 60, 900, 25);
		labelPreco = new JLabel(LABEL_PRECO);
		labelPreco.setBounds(3, 60, 100, 25);

		fieldSituacao = new JTextField();
		fieldSituacao.setBounds(55, 90, 900, 25);
		labelSituacao = new JLabel(LABEL_SITUACAO);
		labelSituacao.setBounds(3, 90, 100, 25);

		btnAdiciona = new JButton(LABEL_ADICIONA);
		btnAdiciona.setBackground(Color.white);
		btnAdiciona.setBounds(230, 150, 150, 25);

		btnEdit = new JButton(LABEL_EDITA);
		btnEdit.setBackground(Color.white);
		btnEdit.setBounds(420, 150, 150, 25);

		btnLeiloar = new JButton(LABEL_LEILOAR);
		btnLeiloar.setBackground(Color.white);
		btnLeiloar.setBounds(420, 180, 150, 25);

		btnDelete = new JButton(LABEL_EXCLUI);
		btnDelete.setBackground(Color.white);
		btnDelete.setBounds(610, 150, 100, 25);
		btnDelete.setEnabled(false);

		table = new JTable(modelLeilao);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 220, 992, 250);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.black));

		container.add(scrollPane);
		container.add(fieldItem);
		container.add(labelItem);
		container.add(fieldPreco);
		container.add(labelPreco);
		container.add(fieldSituacao);
		container.add(labelSituacao);
		container.add(btnAdiciona);
		container.add(btnEdit);
		container.add(btnDelete);
		container.add(btnLeiloar);

		btnAdiciona.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Adicionar dados

				if (fieldItem.getText().trim().isEmpty() || fieldPreco.getText().trim().isEmpty()
						|| fieldSituacao.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar em branco!!");
				} else {
					try {
						Double.parseDouble(fieldPreco.getText());
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "O campo deve conter somente valores num�ricos e/ou ponto para casas decimais!!");
						return;
					}
					Leilao leilao = new Leilao(fieldItem.getText(), Double.parseDouble(fieldPreco.getText()),
							Situacao.valueOf(fieldSituacao.getText()));

					if (ManageLeilao.insereLeilao(leilao)) {
						System.out.println("Leilao adicionado sem erros!!");

						modelLeilao.setLeiloes(ManageLeilao.listaLeiloes());
						modelLeilao.fireTableDataChanged();

						fieldItem.setText("");
						fieldPreco.setText("");
						fieldSituacao.setText("");

					} else {
						System.out.println("Erro ao adicionar Leilao!!");

					}
				}

				btnDelete.setEnabled(false);

			}
		});

		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Edita dados

				if (fieldItem.getText().trim().isEmpty() || fieldPreco.getText().trim().isEmpty()
						|| fieldSituacao.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar em branco!!");
				} else {
					try {
						Double.parseDouble(fieldPreco.getText());
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "O campo deve conter somente valores num�ricos e/ou ponto para casas decimais!!");
						return;
					}
					
					Situacao situacao;
					if (fieldSituacao.getText().equals("ABERTO")) {
						situacao = Situacao.ABERTO;

					} else if (fieldSituacao.getText().equals("FECHADO")) {
						situacao = Situacao.FECHADO;

					} else {
						situacao = Situacao.LIQUIDADO;

					}

					Leilao leilao = new Leilao(fieldItem.getText(), Double.parseDouble(fieldPreco.getText()), situacao);

					if (ManageLeilao.editaLeilao(leilao, table.getValueAt(table.getSelectedRow(), 0).toString())) {
						System.out.println("Dados editados sucesso");

						modelLeilao.setLeiloes(ManageLeilao.listaLeiloes());
						modelLeilao.fireTableDataChanged();

						fieldItem.setText("");
						fieldPreco.setText("");
						fieldSituacao.setText("");

					} else {
						System.out.println("Erro ao atualizar os dados do leilao!!");

					}
				}
				btnDelete.setEnabled(false);

			}
		});

		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Exclui dados
				String item = "";
				if (fieldItem.getText().isEmpty()) {
					item = table.getValueAt(table.getSelectedRow(), 0).toString();
				} else {
					item = fieldItem.getText();
				}

				if (ManageLeilao.removeLeilao(item)) {
					System.out.println("Leilao excluido com sucesso!!");
					modelLeilao.setLeiloes(ManageLeilao.listaLeiloes());
					modelLeilao.fireTableDataChanged();

					fieldItem.setText("");
					fieldPreco.setText("");
					fieldSituacao.setText("");

				}

				btnDelete.setEnabled(false);

			}
		});

		btnLeiloar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (btnDelete.isEnabled() && fieldSituacao.getText().equals("ABERTO")) {
					new LanceGUI(table.getValueAt(table.getSelectedRow(), 0).toString(),
							table.getValueAt(table.getSelectedRow(), 1).toString());
				}else {
					JOptionPane.showMessageDialog(scrollPane, "Apenas produtos em situação ABERTO podem ser leiloados!!!");
				}
			}
		});

		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				fieldItem.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				fieldPreco.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				fieldSituacao.setText(table.getValueAt(table.getSelectedRow(), 2).toString());

				btnDelete.setEnabled(true);

			}
		});
	}

	public static void main(String[] args) {
		new LeilaoGUI();
	}

}
