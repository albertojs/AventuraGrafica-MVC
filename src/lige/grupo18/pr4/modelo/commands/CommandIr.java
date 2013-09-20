package lige.grupo18.pr4.modelo.commands;

import lige.grupo18.pr4.Directions;
import lige.grupo18.pr4.modelo.Door;
import lige.grupo18.pr4.modelo.Game;
import lige.grupo18.pr4.modelo.eventos.Evento;
import lige.grupo18.pr4.modelo.eventos.EventoError;
import lige.grupo18.pr4.modelo.eventos.EventoFinalizarPartida;
import lige.grupo18.pr4.modelo.eventos.EventoIr;

/**
 * Clase que contiene las operaciones del comando ir. Comando de acción que permite al jugador navegar entre habitaciones.
 * @author grupo18
 * @version 2.0
 * @see Command
 */
public class CommandIr implements Command{

	//Atributos que necesita el comando ir
	private Directions _direccion;
	private Game _juego;
	
	/**
	 * Constructor parametrizado
	 * @param direccion direccion a la que desea ir
	 * @param juego juego en el que contiene las habitaciones, puertas, etc.
	 */
	public CommandIr(Directions direccion, Game juego)
	{	
		_direccion=direccion;
		_juego=juego;
	}
	
	/**
	 * Comprueba que el comando es válido
	 * @return devuelve si esta bien construido.
	 */
	public boolean isValid() {
		
		return  _direccion!=Directions.NONE;
	}
	
	/**
	 * Metodo que ejecuta el comando
	 */
	public Evento execute() {
		
		Door puerta=null;
		Evento evento;	
		
		//Busco en el mapa de puertas una posible puerta en la dirección indicada
		puerta=_juego.findDoor(_direccion);
		
		if(puerta==null)
			//Si no encuentra ninguna puerta en esa dirección mostramos el mensaje avisandolo
			evento = new EventoError("No hay puerta en dirección "+_direccion.toString());
		else if(!puerta.isOpen())
			//Si hay puerta pero está cerrada se indica
			evento = new EventoError("Hay una puerta en dirección "+ _direccion.toString()+ ", pero está cerrada.");
		else
		{	
			//Si se encuentra la puerta pasamos a la siguiente habitación,reducimos la vida del jugador y mostramos su descripción por la pantalla y sus objetos
			_juego.setHabitacionActual(_juego.nextRoom(puerta));
			
			if(_juego.esSalidaHabitacion())
				evento = new EventoFinalizarPartida(_juego.getPuntuacionJugador(),_juego.getVidaJugador(),true);
			else if(_juego.getVidaJugador()<=0)
				evento = new EventoFinalizarPartida(_juego.getPuntuacionJugador(),_juego.getVidaJugador(),false);
			else
				evento = new EventoIr(_juego.getHabitacionActual(),_juego.getVidaJugador(),_direccion);
		}
		//return false;
		return evento;
	}
	/**
	 * Método que devuelve la ayuda del comando
	 * @return Devuelve String
	 */
	public static String getHelp()
	{
		return "IR {NORTE | SUR | ESTE | OESTE}";
	}

	
}
