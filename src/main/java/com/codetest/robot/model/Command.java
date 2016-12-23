package com.codetest.robot.model;

/**
 * Enum de comandos disponíveis para o robô da nasa
 * @author Ariel Rai Rodrigues (arielrairodrigues@gmail.com)	
 *
 */
public enum Command {

	R(true), L(true), M(false);

	private boolean orientation;

	/**
	 * Contrutor padrão do comando
	 * @param orientation - informa se é um comando de orientação
	 */
	private Command(boolean orientation) {
		this.orientation = orientation;
	}
	
	/**
	 * Informa se é um comando de orientação do robô
	 * @return <code>true</code> caso seja um comando de orientação
	 */
	public boolean isOrientation() {
		return orientation;
	}
	
	/**
	 * Informa se é o comando "direita"
	 * @param command - o comando que será verificado
	 * @return <code>true</code> caso seja o comando da direita
	 */
	public static boolean isRight(Command command) {
		return command.equals(R);
	}
	
}
