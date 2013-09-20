package lige.grupo18.pr4.modelo.eventos;

import lige.grupo18.pr4.EnumeradorEventos;

/**
 * Clase que contiene el evento error
 * @author grupo18
 *
 */
public class EventoError implements Evento{
	private String _error;
	
	/**
	 * Mutador de la clase
	 * @param error error
	 */
	public EventoError(String error)
	{
		_error=error;
	}
	
	/**
	 * Accedente de la clase
	 * @return error
	 */
	public String getError()
	{
		return _error;
	}

	/**
	 * Metodo que devuelve el enumera del tipo de evento
	 */
	public EnumeradorEventos getTipo() {
		return EnumeradorEventos.EventoError;
	}
}
