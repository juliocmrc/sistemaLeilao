package br.edu.ifg.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifg.entidades.Leilao;
import br.edu.ifg.entidades.Situacao;

public class ManageLeilao {
	public static List<Leilao> listaLeiloes() {
		String sql = "SELECT * from leiloes";
		ArrayList<Leilao> listaLeiloes = new ArrayList<>();

		try {
			PreparedStatement ps = Database.createConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Situacao situacao;
				
				if (rs.getString("situacao").equals("ABERTO")) {
					situacao = Situacao.ABERTO;
					
				}else if(rs.getString("situacao").equals("FECHADO")){
					situacao = Situacao.FECHADO;
				}else {
					situacao = Situacao.LIQUIDADO;
				}
				listaLeiloes.add(new Leilao(rs.getString("item"), rs.getDouble("precoinicial"), situacao));

			}
		} catch (Exception e) {
			// Erro
			e.printStackTrace();

		}
		return listaLeiloes;

	}
	
	public static boolean insereLeilao(Leilao leilao) {
		String sql = "INSERT INTO leiloes(item, precoinicial, situacao) VALUES (?,?,?)";

		try {
			PreparedStatement ps = Database.createConnection().prepareStatement(sql);

			ps.setString(1, leilao.getItem());
			ps.setDouble(2, leilao.getPrecoInicial());
			ps.setString(3, leilao.getSituacao().toString());
			ps.execute();

			return true;

		} catch (Exception e) {
			System.out.println("Erro ao adicionar leilao!!");

			System.out.println(e.getMessage());

			return false;

		}

	}

	public static boolean removeLeilao(String item) {
		String sql = "DELETE FROM leiloes where item = ? ";
		
		try {
			PreparedStatement ps = Database.createConnection().prepareStatement(sql);
			
			ps.setString(1, item);
			ps.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			System.out.println("Erro ao remover leilao do banco de dados!!");
			
			return false;
			
		}
		
	}
	
	
	public static boolean editaLeilao(Leilao leilao, String item ) {
		String sql = "UPDATE leiloes SET precoinicial = ? , situacao = ? WHERE item = ? ";
		try {
			PreparedStatement ps = Database.createConnection().prepareStatement(sql);
			
			ps.setDouble(1, leilao.getPrecoInicial());
			ps.setString(2, leilao.getSituacao().toString());
			ps.setString(3, item);
			ps.execute();
			
			System.out.println(ps);
			
			return true;			
			
		} catch (Exception e) {
			System.out.println("Erro ao editar leilao!!");
			
			return false;
		}
		
	}
	
	public static void main (String[] args) {
		
	}
	
}
