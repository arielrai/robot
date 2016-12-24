package com.codetest.robot.i18n;

import java.util.ResourceBundle;

/**
 * Classe responsável por carregar os resources da aplicação
 * @author Ariel Rai Rodrigues (arielrairodrigues@gmail.com)	
 *
 */
public class RobotResources {

	private static ResourceBundle bundle;

	/**
	 * Retorna a mensagem para chave especificada
	 * @param key - chave que será buscada a mensagem
	 * @return uma {@link String} com a mensagem 
	 */
	public static String getMessage(String key){
		if (bundle == null) {
			synchronized (RobotResources.class) {
				if (bundle == null) {
					bundle = ResourceBundle.getBundle("robot");
				}
			}
		}
		return bundle.getString(key);
	}
}
