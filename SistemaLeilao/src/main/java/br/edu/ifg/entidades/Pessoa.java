package br.edu.ifg.entidades;

import java.util.Date;

public class Pessoa {

	private String cpf;
	private String nome;
	private String sexo;
	private Date dataNascimento;

	public Pessoa() {

	}

	public Pessoa(String cpf, String nome, String sexo) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf
	 *            the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo
	 *            the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
