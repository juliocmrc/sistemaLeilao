package br.edu.ifg.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifg.entidades.Lance;
import br.edu.ifg.validacoes.ValidaCPF;

public class ManageLance {

	public static List<Lance> listaLances() {
		String sql = "SELECT * FROM lances";
		ArrayList<Lance> listaLances = new ArrayList<>();

		try {
			PreparedStatement ps = Database.createConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				listaLances.add(new Lance(rs.getString("cpf"), rs.getString("pessoa"), rs.getString("item"),
						rs.getDouble("valor")));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return listaLances;
	}

	public static boolean insereLance(Lance lance) {
		String sql = "INSERT INTO lances(cpf, pessoa, item, valor) VALUES (?,?,?,?)";

		try {
			PreparedStatement ps = Database.createConnection().prepareStatement(sql);

			ps.setString(1, lance.getPessoaCpf());
			ps.setString(2, lance.getPessoaNome());
			ps.setString(3, lance.getItemNome());
			ps.setDouble(4, lance.getItemValor());
			ps.execute();

			return true;

		} catch (Exception e) {

			System.out.println(e.getMessage());

			return false;

		}

	}

	public static boolean removeLance(String cpf) {
		String sql = "DELETE FROM lances WHERE cpf = ? ";

		try {
			PreparedStatement ps = Database.createConnection().prepareStatement(sql);

			ps.setString(1, cpf);
			ps.executeUpdate();

			return true;

		} catch (Exception e) {
			System.out.println("Erro ao remover lance!!");

			System.out.println(e.getMessage());

			return false;

		}

	}

	public static boolean editaLance(Lance lance, String cpf) {
		String sql = "UPDATE lances SET pessoa = ?, item = ?, valor = ? WHERE cpf = ? ";

		try {
			PreparedStatement ps = Database.createConnection().prepareStatement(sql);

			ps.setString(1, lance.getPessoaNome());
			ps.setString(2, lance.getItemNome());
			ps.setDouble(3, lance.getItemValor());
			ps.setString(4, cpf);
			ps.execute();

			System.out.println(ps);

			return true;

		} catch (Exception e) {
			System.out.println("Erro ao editar lance!!");

			return false;

		}

	}
}
