package com.codetest.robot;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.TestSuite;

/**
 * Agrupador dos testes do robô
 * @author Ariel Rai Rodrigues (arielrairodrigues@gmail.com)	
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ RobotValidCommandTest.class, RobotInvalidCommandTest.class })
public class RobotTest extends TestSuite {

}
