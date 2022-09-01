	package br.edu.ifg.entidades;

import java.util.ArrayList;
import java.util.List;

public class Leilao {

	private String item;
	private Double precoInicial;
	private Situacao situacao;
	private List<Lance> lances;

	public Leilao(String string, double d, String string2, int i) {
	}
	
	public Leilao() {
		
	}
	
	public Leilao(String item, Double precoInicial, Situacao situacao) {
		super();
		this.item = item;
		this.precoInicial = precoInicial;
		this.situacao = situacao;
		
	}

	/**
	 * @return the item
	 */
	public String getItem() {
		return item;
	}

	/**
	 * @param item
	 *            the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}

	/**
	 * @return the precoInicial
	 */
	public Double getPrecoInicial() {
		return precoInicial;
	}

	/**
	 * @param precoInicial
	 *            the precoInicial to set
	 */
	public void setPrecoInicial(Double precoInicial) {
		this.precoInicial = precoInicial;
	}

	/**
	 * @return the situacao
	 */
	public Situacao getSituacao() {
		return situacao;
	}

	/**
	 * @param situacao
	 *            the situacao to set
	 */
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	/**
	 * @return the lances
	 */
	public List<Lance> getLances() {
		return lances;
	}

	/**
	 * @param lances
	 *            the lances to set
	 */
	public void efetuaLance(Lance lance) {
		if(this.lances ==null){
			this.lances = new ArrayList<Lance>();
		}
		this.lances.add(lance);
	}
	
	public static void main(String[] args) {
		
	}

}
