package br.edu.ifg.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifg.entidades.Pessoa;
import br.edu.ifg.entidades.Situacao;
import br.edu.ifg.validacoes.ValidaCPF;

public class ManagePessoa {
	public static List<Pessoa> listaPessoas() {
		String sql = "SELECT * FROM pessoas";
		ArrayList<Pessoa> listaPessoas = new ArrayList<>();

		try {
			PreparedStatement ps = Database.createConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				char sexo;

				if (rs.getString("sexo").equals("M")) {
					sexo = 'M';

				} else {
					sexo = 'F';

				}
				listaPessoas.add(new Pessoa(rs.getString("cpf"), rs.getString(2), rs.getString(3)));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return listaPessoas;
	}

	public static boolean inserePessoa(Pessoa pessoa) {
		String sql = "INSERT INTO pessoas(cpf, nome, sexo) VALUES (?,?,?)";
		
		if(ValidaCPF.isCPF(pessoa.getCpf()) == true){
			try {
				PreparedStatement ps = Database.createConnection().prepareStatement(sql);

				ps.setString(1, pessoa.getCpf());
				ps.setString(2, pessoa.getNome());
				ps.setString(3, pessoa.getSexo());
				ps.execute();
				return true;

			} catch (Exception e) {
				

				System.out.println(e.getMessage());

				return false;

			}
		}else {
			System.out.println("Insira um CPF Válido!!");
			return false;
		}
		

	}

	public static boolean removePessoa(String cpf) {
		String sql = "DELETE FROM pessoas WHERE cpf = ? ";

		try {
			PreparedStatement ps = Database.createConnection().prepareStatement(sql);

			ps.setString(1, cpf);
			ps.executeUpdate();

			return true;

		} catch (Exception e) {
			System.out.println("Erro ao remover pessoa!!");

			System.out.println(e.getMessage());

			return false;

		}

	}

	public static boolean editaPessoa(Pessoa pessoa, String cpf) {
		String sql = "UPDATE pessoas SET nome = ?, sexo = ? WHERE cpf = ? ";

		try {
			PreparedStatement ps = Database.createConnection().prepareStatement(sql);

			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getSexo().toString());
			ps.setString(3, cpf);
			ps.execute();

			System.out.println(ps);

			return true;

		} catch (Exception e) {
			System.out.println("Erro ao editar pessoa!!");

			return false;

		}

	}

}
