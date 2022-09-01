package br.edu.ifg.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ifg.entidades.Leilao;
import br.edu.ifg.entidades.Pessoa;

public class ModelTablePessoa extends AbstractTableModel{
	
	private String[] cabecalho = { "CPF", "NOME", "SEXO" };
	private List<Pessoa> pessoas = new ArrayList<>();

	public ModelTablePessoa(List<Pessoa> pessoas) {
		super();
		this.pessoas = pessoas;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return cabecalho[column];
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return cabecalho.length;
	}

	public String[] getCabecalho() {
		return cabecalho;
	}

	public void setCabecalho(String[] cabecalho) {
		this.cabecalho = cabecalho;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.pessoas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Pessoa pessoa = this.pessoas.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return pessoa.getCpf();
		case 1:
			return pessoa.getNome();
		case 2:
			return pessoa.getSexo()
					;
		default:
			return null;
		}
	}
}
