package com.codetest.robot;

import com.codetest.robot.model.Robot;
import com.codetest.robot.rest.RobotResponse;

import junit.framework.TestCase;

/**
 * Classe abstrata para implementações de testes do robô
 * @author Ariel Rai Rodrigues (arielrairodrigues@gmail.com)	
 *
 */
public abstract class RobotTestCase extends TestCase {

	/**
	 * Executa um comando no robô
	 * @param command - o comando que deve ser executado no robô
	 * @return um {@link RobotResponse}
	 */
	protected RobotResponse executeCommand(String command) {
		Robot robot = new Robot();
		return robot.control(command);
	}
}
