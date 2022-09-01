package br.edu.ifg.entidades;

public class Lance {

	private String pessoaNome;
	private String pessoaCpf;
	private String itemNome;
	private double itemValor;

	public Lance() {

	}

	public Lance(String pessoaNome, String pessoaCpf, String itemNome, double itemValor) {
		super();
		this.pessoaNome = pessoaNome;
		this.pessoaCpf = pessoaCpf;
		this.itemNome = itemNome;
		this.itemValor = itemValor;
	}

	public String getPessoaNome() {
		return pessoaNome;
	}

	public void setPessoaNome(String pessoaNome) {
		this.pessoaNome = pessoaNome;
	}

	public String getPessoaCpf() {
		return pessoaCpf;
	}

	public void setPessoaCpf(String pessoaCpf) {
		this.pessoaCpf = pessoaCpf;
	}

	public String getItemNome() {
		return itemNome;
	}

	public void setItemNome(String itemNome) {
		this.itemNome = itemNome;
	}

	public double getItemValor() {
		return itemValor;
	}

	public void setItemValor(double itemValor) {
		this.itemValor = itemValor;
	}

}
