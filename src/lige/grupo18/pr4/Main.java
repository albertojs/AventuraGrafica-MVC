package lige.grupo18.pr4;

import lige.grupo18.pr4.control.Controlador;
import lige.grupo18.pr4.modelo.*;
import lige.grupo18.pr4.vista.UIConsola;
import lige.grupo18.pr4.vista.Vista;

/**
 * Clase que contiene el método main de entrada al programa. 
 * Es la responsable de crear las habitaciones del juego y las puertas que 
 * comunican dichas habitaciones. 
 * @author grupo18
 * @version 1.0
 */
public class Main {

	/**
	 * Método de entrada a la ejecución de juego
	 * @param args Posibles argumentos que puede recibir la ejecución
	 */
	public static void main(String[] args)
	{
		Game modelo = new Game();
		Controlador controlador = new Controlador(modelo);
		Vista vista = new Vista(controlador);
		
		modelo.addObserver(vista);
		

		if(args.length == 1)
		{
			if(args[0].equals("-c"))
			{
				UIConsola vista2=new UIConsola();
				modelo.addObserver(vista2);
			}
		}
		
	}
}
