package br.edu.ifg.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.edu.ifg.database.ManagePessoa;
import br.edu.ifg.entidades.Pessoa;
import br.edu.ifg.models.*;

public class PessoaGUI extends JFrame {

	private JFrame frame;
	private JPanel container;
	private JTextField fieldCpf;
	private JLabel labelCpf;
	private JTextField fieldNome;
	private JLabel labelNome;
	private JRadioButton rdBtnSexoF;
	private JRadioButton rdBtnSexoM;
	private ButtonGroup groupSexo;
	private JLabel labelSexo;

	private JButton btnSalvar;
	private JButton btnDelete;
	private JButton btnEditar;

	private JTable table;

	private final String TITULO = "Pessoa";
	private final String TITULO_BORDA = "Dados de cadastro";
	private final String LABEL_CPF = "Cpf:";
	private final String LABEL_NOME = "Nome:";
	private final String LABEL_SEXO = "Sexo:";
	private final String LABEL_ADICIONA = "Adicionar";
	private final String LABEL_EDITA = "Editar";
	private final String LABEL_EXCLUI = "Excluir";

	private List<Pessoa> pessoasAdicionadas = ManagePessoa.listaPessoas();
	private ModelTablePessoa modelPessoa = new ModelTablePessoa(pessoasAdicionadas);
	private String sexo;

	public PessoaGUI() {
		frame = this;
		frame.setTitle(TITULO);

		init();

		inicializaPessoa();
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

	private void inicializaPessoa() {

		container.setBorder(new TitledBorder(TITULO_BORDA));

		fieldCpf = new JTextField();
		fieldCpf.setBounds(50, 30, 700, 25);
		labelCpf = new JLabel(LABEL_CPF);
		labelCpf.setBounds(1, 30, 100, 25);

		fieldNome = new JTextField();
		fieldNome.setBounds(50, 60, 700, 25);
		labelNome = new JLabel(LABEL_NOME);
		labelNome.setBounds(1, 60, 100, 25);

		rdBtnSexoM = new JRadioButton("M");
		rdBtnSexoM.setBounds(805, 60, 40, 20);
		rdBtnSexoM.setSelected(true);

		rdBtnSexoF = new JRadioButton("F");
		rdBtnSexoF.setBounds(850, 60, 40, 20);

		labelSexo = new JLabel(LABEL_SEXO);
		labelSexo.setBounds(800, 40, 80, 20);
		groupSexo = new ButtonGroup();
		groupSexo.add(rdBtnSexoM);
		groupSexo.add(rdBtnSexoF);

		btnSalvar = new JButton(LABEL_ADICIONA);
		btnSalvar.setBackground(Color.white);
		btnSalvar.setBounds(230, 150, 150, 25);

		btnDelete = new JButton(LABEL_EXCLUI);
		btnDelete.setBackground(Color.white);
		btnDelete.setBounds(610, 150, 150, 25);
		btnDelete.setEnabled(false);

		btnEditar = new JButton(LABEL_EDITA);
		btnEditar.setBackground(Color.white);
		btnEditar.setBounds(420, 150, 150, 25);

		table = new JTable(modelPessoa);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(1, 220, 992, 250);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.black));

		container.add(scrollPane);

		container.add(fieldCpf);
		container.add(fieldNome);
		container.add(labelCpf);
		container.add(labelNome);
		container.add(labelSexo);
		container.add(rdBtnSexoF);
		container.add(rdBtnSexoM);
		container.add(btnSalvar);
		container.add(btnDelete);
		container.add(btnEditar);

		if (rdBtnSexoF.isSelected()) {
			sexo = "F";

		} else if(rdBtnSexoM.isSelected()) {
				sexo = "M";
			} else {
				JOptionPane.showMessageDialog(null, "Selecione um sexo");
			
		}


		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Adicionar dados
				
								
				try {
					Double.parseDouble(fieldCpf.getText());
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "O campo deve conter somente valores num�ricos!!");
					return;
				}
				
				if (fieldCpf.getText().trim().isEmpty() || fieldNome.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar em branco!!");
				} else {
					Pessoa pessoa = new Pessoa(fieldCpf.getText(), fieldNome.getText(), sexo);

					if (ManagePessoa.inserePessoa(pessoa)) {
						System.out.println("Pessoa adicionada sem erros!!");

						modelPessoa.setPessoas(ManagePessoa.listaPessoas());
						modelPessoa.fireTableDataChanged();

						fieldCpf.setText("");
						fieldNome.setText("");
						rdBtnSexoM.setSelected(true);

					}
				}

				btnDelete.setEnabled(false);

			}

		});

		btnEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Edita dados

				try {
					Double.parseDouble(fieldCpf.getText());
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "O campo deve conter somente valores num�ricos!!");
					return;
				}
				
				if (fieldCpf.getText().trim().isEmpty() || fieldNome.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar em branco!!");
				} else {
					Pessoa pessoa = new Pessoa(fieldCpf.getText(), fieldNome.getText(), sexo);
					if (ManagePessoa.editaPessoa(pessoa, table.getValueAt(table.getSelectedRow(), 0).toString())) {
						System.out.println("Dados editados sucesso");

						modelPessoa.setPessoas(ManagePessoa.listaPessoas());
						modelPessoa.fireTableDataChanged();

						fieldCpf.setText("");
						fieldNome.setText("");
						rdBtnSexoM.setSelected(true);

					} else {
						System.out.println("Erro ao atualizar os dados da pessoa!!");

					}

				}

				btnDelete.setEnabled(false);

			}
		});

		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Remove dados

				String cpf = "";
				if (fieldCpf.getText().isEmpty()) {
					cpf = table.getValueAt(table.getSelectedRow(), 0).toString();
				} else {
					cpf = fieldCpf.getText();
				}

				if (ManagePessoa.removePessoa(cpf)) {
					System.out.println("Pessoa excluida com sucesso!!");
					modelPessoa.setPessoas(ManagePessoa.listaPessoas());
					modelPessoa.fireTableDataChanged();

					fieldCpf.setText("");
					fieldNome.setText("");
					rdBtnSexoM.setSelected(true);

				}

				btnDelete.setEnabled(false);

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
				fieldCpf.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				fieldNome.setText(table.getValueAt(table.getSelectedRow(), 1).toString());

				btnDelete.setEnabled(true);

			}
		});
	}

	public static void main(String[] args) {
		new PessoaGUI();

	}

}
