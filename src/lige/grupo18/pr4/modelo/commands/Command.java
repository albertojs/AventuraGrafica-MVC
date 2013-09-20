package lige.grupo18.pr4.modelo.commands;

import lige.grupo18.pr4.modelo.eventos.Evento;

/**
 * Interface que gestionara los comandos disponibles del juego
 * @author grupo18
 * @version 2.0
 */
public interface Command {
	public boolean isValid();
	public Evento execute();
}
