package com.codetest.robot.model;

/**
 * Enum de orientação que o robô pode assumir
 * @author Ariel Rai Rodrigues (arielrairodrigues@gmail.com)	
 *
 */
public enum Orientation {

	NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");
	
	private String initial;
	
	/**
	 * Construtor padrão da orientação
	 * @param initial - informa a inicial da orientação 
	 */
	private Orientation(String initial){
		this.initial = initial;
	}

	/**
	 * Retorna a inicial da orientação
	 * @return uma {@link String} com a inicial da orientação
	 */
	public String getInitial() {
		return initial;
	}
	
	/**
	 * Retorna a próxima orientação a partir da orientação atual e do comando enviado 
	 * @param currentOrientation - a  orientação atual do robô
	 * @param command - o comando enviado ao robô
	 * @return a nova orientação do robô
	 */
	public static Orientation nextOrientation(Orientation currentOrientation, Command command){
		switch (currentOrientation) {
		case NORTH:
			if (Command.isRight(command)) {
				return Orientation.EAST;
			} else{
				return Orientation.WEST;
			}
		case EAST:
			if (Command.isRight(command)) {
				return Orientation.SOUTH;
			} else{
				return Orientation.NORTH;
			}
		case SOUTH:
			if (Command.isRight(command)) {
				return Orientation.WEST;
			} else{
				return Orientation.EAST;
			}
		case WEST:
			if (Command.isRight(command)) {
				return Orientation.NORTH;
			} else{
				return Orientation.SOUTH;
			}
		}
		return currentOrientation;
	}
}
