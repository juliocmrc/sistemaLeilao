package br.edu.ifg.view;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.table.DefaultTableModel;

import br.edu.ifg.database.ManageLance;
import br.edu.ifg.database.ManagePessoa;
import br.edu.ifg.entidades.Lance;
import br.edu.ifg.entidades.Pessoa;
import br.edu.ifg.models.ModelTableLanceItem;
import br.edu.ifg.models.ModelTableLancePessoa;

public class LanceGUI extends JFrame {
	private JFrame frame;
	private JPanel container;
	private JTextField fieldValorLance;
	private JLabel labelValorLance;
	private JLabel labelItemLance;
	private JLabel labelPrecoItem;
	private JButton btnSalva;
	private JButton btnCancela;
	private JTable tablePessoa;
	private JTable tableLance;

	private final String TITULO = "Lances";
	private final String LABEL_VALOR = "Valor do lance: ";
	private final String LABEL_SALVAR = "Salvar";
	private final String LABEL_CANCELAR = "Cancelar";
	private String labelValorInicial = "Valor inicial do lance: R$";
	private String labelItem = "Item a ser leiloado: ";
	private String itemLeiloado;
	private String precoItemLeiloado;

	private List<Pessoa> pessoasAdicionadas = ManagePessoa.listaPessoas();
	private ModelTableLancePessoa modelPessoa = new ModelTableLancePessoa(pessoasAdicionadas);

	private List<Lance> lancesAdicionados = ManageLance.listaLances();
	private ModelTableLanceItem modelLance = new ModelTableLanceItem(pessoasAdicionadas, lancesAdicionados);

	public LanceGUI(String itemLeiloado, String precoItemLeiloado) {
		frame = this;
		frame.setTitle(TITULO);

		this.itemLeiloado = itemLeiloado;
		this.precoItemLeiloado = precoItemLeiloado;
		
		init();
		inicializaLance();

		setVisible(true);

	}

	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 1000, 420);
		this.setResizable(false);

		container = new JPanel();
		container.setLayout(null);

		add(container);

	}

	public void inicializaLance() {
		
		labelItem += itemLeiloado;
		
		labelItemLance = new JLabel(labelItem);
		labelItemLance.setBounds(307, 20, 200, 25);

		labelValorInicial += precoItemLeiloado;
		
		labelPrecoItem = new JLabel(labelValorInicial);
		labelPrecoItem.setBounds(577, 20, 200, 25);

		labelValorLance = new JLabel(LABEL_VALOR);
		labelValorLance.setBounds(400, 100, 100, 25);

		fieldValorLance = new JTextField();
		fieldValorLance.setBounds(400, 120, 200, 25);

		btnSalva = new JButton(LABEL_SALVAR);
		btnSalva.setBackground(Color.white);
		btnSalva.setForeground(Color.black);
		btnSalva.setBounds(400, 145, 100, 20);

		btnCancela = new JButton(LABEL_CANCELAR);
		btnCancela.setBackground(Color.white);
		btnCancela.setForeground(Color.black);
		btnCancela.setBounds(500, 145, 100, 20);

		tablePessoa = new JTable(modelPessoa);
		tablePessoa.setBorder(BorderFactory.createLineBorder(Color.black));
		JScrollPane scrollPane = new JScrollPane(tablePessoa);
		scrollPane.setBounds(28, 75, 325, 300);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.black));

		tableLance = new JTable(modelLance);
		tableLance.setBorder(BorderFactory.createLineBorder(Color.black));
		JScrollPane scrollPane2 = new JScrollPane(tableLance);
		scrollPane2.setBounds(647, 75, 325, 300);
		scrollPane2.setBorder(BorderFactory.createLineBorder(Color.black));

		container.add(labelItemLance);
		container.add(labelPrecoItem);
		container.add(fieldValorLance);
		container.add(labelValorLance);
		container.add(btnCancela);
		container.add(btnSalva);
		container.add(scrollPane);
		container.add(scrollPane2);
		
		btnSalva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Adiciona dados
				try {
					Double.parseDouble(fieldValorLance.getText());
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "O campo deve conter somente valores numéricos e/ou ponto para casas decimais!!");
					return;
				}
				
				String cpf = tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 0).toString();
				String nomePessoa = tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 1).toString();
				String nomeProduto = tableLance.getValueAt(tableLance.getSelectedRow(), 0).toString();
				
				Lance lance = new Lance(nomePessoa,cpf,nomeProduto,Double.parseDouble(fieldValorLance.getText()));
				
				if(ManageLance.insereLance(lance)) {
					System.out.println("Lance efetuado com sucesso!!");
					
					modelLance.setLances(ManageLance.listaLances());
					modelLance.fireTableDataChanged();
					
					fieldValorLance.setText("");
				
				}else {
					System.out.println("Erro ao efetuar Lance");
				
				}
				
			}
		});
		
		btnCancela.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Cancela Ação
				
				fieldValorLance.setText("");
				
			}
		});
	}

	public static void main(String[] args) {
		new LanceGUI("","");
		
	}
}
