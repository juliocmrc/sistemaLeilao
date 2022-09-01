package br.edu.ifg.databasetest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import br.edu.ifg.database.ManageLance;
import br.edu.ifg.entidades.Lance;

class ManageLanceTest {

	@Test
	void testListLance() {	
		var lance = new Lance();
		assertEquals(true, ManageLance.listaLances().add(lance));
	}
	
	@Test
	void testRemoveLance(){
		assertEquals(true, ManageLance.removeLance("12345678997"));
	}
	
	@Test
	void testInsertLance(){
		var lance = new Lance("Juliana Cruz", "12345678997", "PS5", 4200.00);
		assertEquals(true, ManageLance.insereLance(lance));
	}
}
