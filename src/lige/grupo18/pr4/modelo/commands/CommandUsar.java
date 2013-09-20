package lige.grupo18.pr4.modelo.commands;

import lige.grupo18.pr4.modelo.Game;
import lige.grupo18.pr4.modelo.eventos.Evento;
import lige.grupo18.pr4.modelo.eventos.EventoFinalizarPartida;
import lige.grupo18.pr4.modelo.eventos.EventoObjetoUsado;
import lige.grupo18.pr4.modelo.items.Item;

/**
 * Clase que implementa el comando usar. Permite al usuario usar el objeto con identificador id de su inventario de objetos
 * @author grupo18
 * @version 2.0
 * @see Command
 */
public class CommandUsar implements Command{

	//Atributos necesarios del comando usar
	private String _id;
	private Game _juego;
	
	/**
	 * Contructor parametrizado
	 * @param id identifador del objeto a usar
	 * @param juego juego
	 */
	public CommandUsar(String id, Game juego)
	{
		_id=id;
		_juego = juego;
	}
	
	/**
	 * Comprueba que el comando es válido
	 * @return devuelve si esta bien construido.
	 */
	public boolean isValid() {
		
			return  _id != "";
	}

	/**
	 * Metodo que ejecuta el comando
	 */
	public Evento execute() {
		
		Evento evento;
		Item objeto=_juego.findPlayerItem(_id);
			
		//Si el item no es null entonces lo usamos
		String mensaje =objeto.use(_juego.getJugador(),_juego.getHabitacionActual());
		
		if(_juego.getVidaJugador()<=0)
			evento = new EventoFinalizarPartida(_juego.getPuntuacionJugador(),_juego.getVidaJugador(),false);
		else
			evento= new EventoObjetoUsado(_juego.getInventarioJugador(),_juego.getVidaJugador(),_juego.getPuntuacionJugador(),mensaje);

		return evento;
	}
	/**
	 * Método que devuelve la ayuda del comando
	 * @return Devuelve String
	 */
	public static String getHelp()
	{
		return "USAR <<id>>";
	}

}
