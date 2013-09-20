package lige.grupo18.pr4.modelo.eventos;

import lige.grupo18.pr4.EnumeradorEventos;

/**
 * Clase padre de la que heredan el resto de eventos
 * @author grupo18
 *
 */
public interface Evento {
	public abstract EnumeradorEventos getTipo();
}
