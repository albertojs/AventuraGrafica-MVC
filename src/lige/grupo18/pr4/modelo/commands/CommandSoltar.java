package lige.grupo18.pr4.modelo.commands;

import lige.grupo18.pr4.modelo.Game;
import lige.grupo18.pr4.modelo.eventos.Evento;
import lige.grupo18.pr4.modelo.eventos.EventoObjetoSoltado;
import lige.grupo18.pr4.modelo.items.Item;

/**
 * Clase que implementa el comando soltar. Suelta un item en la habitacion que este, este item debe de estar en la lista de items del jugador
 * @author grupo18
 * @version 2.0
 * @see Command
 */
public class CommandSoltar implements Command{

	//Atributos del comando soltar
	private String _id;
	private Game _juego;
	
	/**
	 * Contructor parametrizado
	 * @param id identificador del objeto
	 * @param juego juego
	 */
	public CommandSoltar(String id, Game juego)
	{
		_id=id;
		_juego = juego;
	}
	
	/**
	 * Comprueba que el comando es válido
	 * @return devuelve si esta bien construido.
	 */
	public boolean isValid() {
		
		return _id!="";
	}
	
	/**
	 * Metodo que ejecuta el comando soltar 
	 */
	public Evento execute() {
		
		Evento evento;
		Item objeto=_juego.findPlayerItem(_id);
			
			
		//Si no e snulo lo agrego a la habitacion y lo elimino del inventario del jugador
		_juego.addItemToRoom(objeto);
		_juego.removePlayerItem(_id);
		evento = (Evento) new EventoObjetoSoltado(_juego.getHabitacionActual(),_juego.getInventarioJugador());
		
		return evento;
	}
	/**
	 * Método que devuelve la ayuda del comando
	 * @return Devuelve String
	 */
	public static String getHelp()
	{
		return "SOLTAR <<id>>";
	}
}
