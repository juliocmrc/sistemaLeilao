 package br.edu.ifg.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ifg.entidades.Lance;
import br.edu.ifg.entidades.Pessoa;

public class ModelTableLanceItem extends AbstractTableModel{
	
	private String[] cabecalho = { "CPF", "NOME", "LANCE"};
	private List<Pessoa> pessoas = new ArrayList<>();
	private List<Lance> lances = new ArrayList<>();

	public ModelTableLanceItem(List<Pessoa> pessoasAdicionadas, List<Lance> lancesAdicionados) {
		super();
		this.pessoas = pessoasAdicionadas;
		this.lances = lancesAdicionados;
	}

	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return cabecalho[column];
	}

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
	
	public List<Lance> getLeiloes() {
		return lances;
	}

	public void setLeiloes(List<Lance> leiloes) {
		this.lances = leiloes;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.lances.size();
	}

	public List<Lance> getLances() {
		return lances;
	}

	public void setLances(List<Lance> lances) {
		this.lances = lances;
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Pessoa pessoa = this.pessoas.get(rowIndex);
		Lance lance = this.lances.get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			return pessoa.getCpf();
		case 1:
			return pessoa.getNome();
		case 2:
			return lance.getItemValor();
		default:
			return null;
		}
	}

}

