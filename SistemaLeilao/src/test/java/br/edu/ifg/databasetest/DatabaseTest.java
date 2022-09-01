package br.edu.ifg.databasetest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import br.edu.ifg.database.Database;

class DatabaseTest {

	@Test
	void testIfConnectionThrowsSQLException(){
		assertThrows(SQLException.class, () -> Database.createConnection());
	}

}
