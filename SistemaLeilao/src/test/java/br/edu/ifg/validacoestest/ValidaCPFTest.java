package br.edu.ifg.validacoestest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ifg.validacoes.ValidaCPF;

class ValidaCPFTest {

	@Test
	void testPrintCPF() {
		assertEquals("988.377.150-99", ValidaCPF.imprimeCPF("98837715099"));
	}
	
	@Test
	void testValidCPF() {
		assertEquals(true, ValidaCPF.isCPF("98837715099"));
	}
	
	@Test
	void testInvalidCPF() {
		assertEquals(false, ValidaCPF.isCPF("12345678997"));
	}
	
	@Test
	void testIfSecondToLastNumberIsRight() {
		assertFalse(ValidaCPF.isCPF("98837715009"));
	}
	
	@Test
	void testIfLastNumberIsRight() {
		assertFalse(ValidaCPF.isCPF("98837715090"));
	}
	
	@Test
	void testIfCPFHasLessThanElevenCaracter() {
		assertFalse(ValidaCPF.isCPF("9883771509"));
	}
	
	@Test
	void testIfCPFHasMoreThanElevenCaracter() {
		assertFalse(ValidaCPF.isCPF("988377150999"));
	}
	
	@Test
	void testIfCPFHasIsComposedByOnlyNumber1() {
		assertFalse(ValidaCPF.isCPF("11111111111"));
	}
	
	@Test
	void testIfCPFHasIsComposedByOnlyNumber2() {
		assertFalse(ValidaCPF.isCPF("22222222222"));
	}
	
	@Test
	void testIfCPFHasIsComposedByOnlyNumber3() {
		assertFalse(ValidaCPF.isCPF("33333333333"));
	}
	
	@Test
	void testIfCPFHasIsComposedByOnlyNumber4() {
		assertFalse(ValidaCPF.isCPF("44444444444"));
	}
	
	@Test
	void testIfCPFHasIsComposedByOnlyNumber5() {
		assertFalse(ValidaCPF.isCPF("55555555555"));
	}

	@Test
	void testIfCPFHasIsComposedByOnlyNumber6() {
		assertFalse(ValidaCPF.isCPF("66666666666"));
	}

	@Test
	void testIfCPFHasIsComposedByOnlyNumber7() {
		assertFalse(ValidaCPF.isCPF("77777777777"));
	}

	@Test
	void testIfCPFHasIsComposedByOnlyNumber8() {
		assertFalse(ValidaCPF.isCPF("88888888888"));
	}

	@Test
	void testIfCPFHasIsComposedByOnlyNumber9() {
		assertFalse(ValidaCPF.isCPF("99999999999"));
	}

	@Test
	void testIfCPFHasIsComposedByOnlyNumber0() {
		assertFalse(ValidaCPF.isCPF("00000000000"));
	}
	

}
