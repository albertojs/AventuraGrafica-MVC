package lige.grupo18.pr4.modelo.commands;

import lige.grupo18.pr4.modelo.Game;
import lige.grupo18.pr4.modelo.eventos.Evento;
import lige.grupo18.pr4.modelo.eventos.EventoError;
import lige.grupo18.pr4.modelo.eventos.EventoObjetoCogido;
import lige.grupo18.pr4.modelo.items.Item;

/**
 * Clase que implementa las operaciones del objeto coger. Recoge objetos mediante un identificador de las habitaciones
 * @author grupo18
 * @version 2.0
 * @see Command
 */
public class CommandCoger implements Command{

	//Atributo que necesita el comando coger
	private String _id;
	private Game _juego;
	
	/**
	 * Contructor parametrizado
	 * @param id identificador del objeto a coger
	 * @param juego juego
	 */
	public CommandCoger(String id,Game juego)
	{		
		_juego=juego;
		_id = id;
	}
	
	/**
	 * Comprueba que el comando es válido
	 * @return devuelve si esta bien construido.
	 */
	public boolean isValid() {
		
		return _id != "";
	}

	/**
	 * Metodo que ejecuta el comando coger 
	 */
	public Evento execute() {
				
		Item objeto=_juego.findRoomItem(_id);		
		Evento evento;
		
		//Si el objeto no es nulo lo intentamos añadir al inventario del jugador
		boolean repetido=_juego.addItemToPlayer(objeto);
		if (repetido)
			evento = (Evento) new EventoError("Ya tienes otro "+_id+" en tu inventario.");
		else
		{
			_juego.removeRoomItem(_id);
			evento = (Evento) new EventoObjetoCogido(_juego.getHabitacionActual(),_juego.getInventarioJugador());
		}
		
		return evento;
	}
	/**
	 * Método que devuelve la ayuda del comando
	 * @return Devuelve String
	 */
	public static String getHelp()
	{
		return "COGER <<id>>";
	}

}
