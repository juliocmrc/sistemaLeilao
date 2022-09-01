package br.edu.ifg.databasetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ifg.database.ManagePessoa;
import br.edu.ifg.entidades.Pessoa;

class ManagePessoaTest {
	
	Pessoa pessoa = new Pessoa("98837715099", "Juliana Cruz", "F");
	
	@Test
	void testListPeople() {
		var pessoa = new Pessoa();
		assertEquals(true, ManagePessoa.listaPessoas().add(pessoa));
	}

	@Test
	void testRemovePerson() {
		assertEquals(true, ManagePessoa.removePessoa("12345678997"));
	}

	@Test
	void testInsertPersonWithInvalidCPF() {
		var pessoa = new Pessoa("12345678997", "Juliana Cruz", "F");
		assertFalse(ManagePessoa.inserePessoa(pessoa));
	}
	
	@Test
	void testInsertPersonWithValidCPF() {
		
		assertEquals(true, ManagePessoa.inserePessoa(pessoa));
	}
	
	@Test
	void testEditPerson() {
		assertEquals(true, ManagePessoa.editaPessoa(pessoa, pessoa.getCpf()));
	}
	
}
