package com.codetest.robot.rest;

/**
 * Representa uma resposta de posição atual do robô
 * @author Ariel Rai Rodrigues (arielrairodrigues@gmail.com)	
 *
 */
public class RobotResponse {

	private int x;
	private int y;
	private String orientacao;
	
	public RobotResponse(int x, int y, String orientacao) {
		super();
		this.x = x;
		this.y = y;
		this.orientacao = orientacao;
	}

	public String getOrientacao() {
		return orientacao;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof RobotResponse)) {
			return false;
		}
		RobotResponse robotResponse = (RobotResponse)obj;
		return x == robotResponse.x && y == robotResponse.y && orientacao.equals(robotResponse.orientacao);
	}
}
