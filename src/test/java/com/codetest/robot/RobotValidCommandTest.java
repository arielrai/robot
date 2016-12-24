package com.codetest.robot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.codetest.robot.rest.RobotResponse;

/**
 * Testa comandos válidos ao robô
 * @author Ariel Rai Rodrigues (arielrairodrigues@gmail.com)
 *
 */
@RunWith(JUnit4.class)
public class RobotValidCommandTest extends RobotTestCase {

	/**
	 * Método responsável por testar os controles de orientação do robô
	 */
	@Test
	public void testOrientation() {
		RobotResponse northEast = executeCommand("R");
		assertEquals("E", northEast.getOrientacao());

		RobotResponse northWest = executeCommand("L");
		assertEquals("W", northWest.getOrientacao());

		RobotResponse northSouthLeft = executeCommand("LL");
		assertEquals("S", northSouthLeft.getOrientacao());

		RobotResponse northSouthRight = executeCommand("RR");
		assertEquals("S", northSouthRight.getOrientacao());
		
		RobotResponse northSouthWestRight = executeCommand("RRR");
		assertEquals("W", northSouthWestRight.getOrientacao());
		
		RobotResponse northSouthEastLeft = executeCommand("LLL");
		assertEquals("E", northSouthEastLeft.getOrientacao());
	}

	/**
	 * Método responsável por testar toda a movimentação do robô
	 */
	@Test
	public void testMoviment() {
		RobotResponse firstMovement = executeCommand("MMRMMRMM");
		assertEquals(new RobotResponse(2, 0, "S"), firstMovement);

		RobotResponse secondMovement = executeCommand("MML");
		assertEquals(new RobotResponse(0, 2, "W"), secondMovement);

		RobotResponse thirdMovement = executeCommand("MMLMMRR");
		assertEquals(new RobotResponse(-2, 2, "E"), thirdMovement);

		RobotResponse fourthMovement = executeCommand("RRLLLMMLM");
		assertEquals(new RobotResponse(-2, -1, "S"), fourthMovement);
	}
	
}
