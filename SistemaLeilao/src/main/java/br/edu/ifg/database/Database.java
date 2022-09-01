package br.edu.ifg.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private static final String DBURL = "jdbc:postgresql://localhost:5432/SistemaLeilao";
	private static final String PASS = "postgres";
	private static final String SENHA = "22042003";
	private static Connection connect;

	// inicio da conex�o com bd
	public static Connection createConnection() throws SQLException {
		if (connect == null) {
			connect = DriverManager.getConnection(DBURL, PASS, SENHA);
			System.out.println("Conex�o OK!");

		}
		return connect;
	}

}