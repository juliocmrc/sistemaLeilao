package br.edu.ifg.models;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ifg.entidades.*;

public class ModelTableLeilao extends AbstractTableModel {
	
	private String[] cabecalho = { "ITEM", "VALOR", "SITUAÇÃO" };
	private List<Leilao> leiloes;

	public ModelTableLeilao(List<Leilao> leiloes) {
		super();
		this.leiloes = leiloes;
	}

	public String[] getCabecalho() {
		return cabecalho;
	}

	public void setCabecalho(String[] cabecalho) {
		this.cabecalho = cabecalho;
	}

	public List<Leilao> getLeiloes() {
		return leiloes;
	}

	public void setLeiloes(List<Leilao> leiloes) {
		this.leiloes = leiloes;
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

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.leiloes.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Leilao leilao = this.leiloes.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return leilao.getItem();
		case 1:
			return leilao.getPrecoInicial();
		case 2:
			return leilao.getSituacao();
		default:
			return null;
		}
	}
}