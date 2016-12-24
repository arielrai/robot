package com.codetest.robot.model;

import javax.enterprise.context.RequestScoped;

import com.codetest.robot.i18n.RobotResources;
import com.codetest.robot.rest.RobotResponse;

/**
 * Representa o robô <br>
 * Todos os controles do robô são enviados para essa classe
 *  
 * @author Ariel Rai Rodrigues (arielrairodrigues@gmail.com)
 *
 */
@RequestScoped
public class Robot {

	private boolean field[][]; //Campo pelo qual o robô pode se movimentar 
	private Orientation currentOrientation = Orientation.NORTH; //Orientação inical do robô
	private int halfX = 0;
	private int halfY = 0;

	public Robot() {
		field = new boolean[5][5]; // inicialização 5x5
		if (field.length % 2 == 0 || field[0].length % 2 == 0) { // Deve ser ímpar
			throw new IllegalArgumentException(
					RobotResources.getMessage("campo.tamanho.invalido"));
		}
		findMiddle(); // necessário para se encontrar o meio 0x0
		field[halfX][halfY] = true; // seta o valor inicial em 0x0
	}

	/**
	 * Método responsável por encontrar a posição 0x0 na matriz
	 */
	private void findMiddle() {
		halfX = field.length / 2;
		halfY = field[0].length / 2;
	}

	/**
	 * Informa método responsável por controlar o robô e retornar sua posição final
	 * @param command - o comando que será executado pelo robô
	 */
	public RobotResponse control(String command) {
		char[] commandArray = command.toCharArray();
		for (int i = 0; i < commandArray.length; i++) {
			char c = commandArray[i];
			String partialCommand = String.valueOf(c);
			if(Command.L.name().equals(partialCommand) || Command.R.name().equals(partialCommand)) {
				currentOrientation = Orientation.nextOrientation(currentOrientation, Command.valueOf(partialCommand));
			}else if (Command.M.name().equals(partialCommand)) {
				RobotResponse robotPosition = getCurrentPosition();
				switch (currentOrientation) {
				case EAST:
					move(robotPosition.getX() + 1, robotPosition.getY(), robotPosition.getX(), robotPosition.getY());
					break;
				case WEST:
					move(robotPosition.getX() - 1, robotPosition.getY(), robotPosition.getX(), robotPosition.getY());
					break;
				case NORTH:
					move(robotPosition.getX(), robotPosition.getY() + 1, robotPosition.getX(), robotPosition.getY());
					break;
				case SOUTH:
					move(robotPosition.getX(), robotPosition.getY() - 1, robotPosition.getX(), robotPosition.getY());
					break;
				}
			}else{
				throw new IllegalArgumentException(
						RobotResources.getMessage("comando.invalido"));
			}
		}
		//Retorna a posição final do robô
		return getCurrentPosition();
	}
	
	/**
	 * Método responsável por verificar a posição atual do robô
	 * @return uma {@link RobotResponse} com a posição atual do robô
	 */
	private RobotResponse getCurrentPosition() {
		for (int x = 0; x < field.length; x++) {
			for (int y = 0; y < field[x].length; y++) {
				if (field[x][y]) {
					return new RobotResponse(x - halfX, y - halfY, currentOrientation.getInitial());
				}
			}
		}
		return new RobotResponse(0, 0, currentOrientation.getInitial());
	}

	/**
	 * Método reponsável por movimentar o robô
	 * @param x - a posição atual x
	 * @param y - a posição atual y
	 * @param previousX - a posição anterior x
	 * @param previousY - a posição anterior y
	 */
	public void move(int x, int y, int previousX , int previousY) {
		try {
			field[x + halfX][y + halfY] = true;
			field[previousX + halfX][previousY + halfY] = false;
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalArgumentException(
					RobotResources.getMessage("posicao.invalida"));
		}
	}
}
