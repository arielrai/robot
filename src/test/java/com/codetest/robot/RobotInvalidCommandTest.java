package com.codetest.robot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Classe responsável por executar teste de comandos inválidas ao robô
 * @author Ariel Rai Rodrigues (arielrairodrigues@gmail.com)
 *
 */
@RunWith(JUnit4.class)
public class RobotInvalidCommandTest extends RobotTestCase {

	/**
	 * Método responsável por testar um comando inválido
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidCommand() {
		executeCommand("AAA");
	}

	/**
	 * Método responsável por testar uma posição inválida
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidPosition() {
		executeCommand("MMMMMMMMMMMMMMMMMMMMMMM");
	}

}
