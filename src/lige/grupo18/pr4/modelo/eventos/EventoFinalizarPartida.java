package lige.grupo18.pr4.modelo.eventos;

import lige.grupo18.pr4.EnumeradorEventos;

/**
 * Clase que contiene el evento de partida finalizada
 * @author grupo18
 *
 */
public class EventoFinalizarPartida implements Evento{
	
	//Variables privadas
	private int _puntuacion;
	private int _vida;
	private boolean _ganado;
	
	/**
	 * Contructor parametrizado
	 * @param puntuacion puntuacion
	 * @param vida vida
	 * @param ganado ganado
	 */
	public EventoFinalizarPartida(int puntuacion, int vida, boolean ganado){
		this._puntuacion = puntuacion;
		this._vida = vida;
		this._ganado = ganado;
	}
	
	/**
	 * Metodo que obtiene el enumerado del evento de la clase
	 */
	public EnumeradorEventos getTipo() {
		return EnumeradorEventos.EventoFinalizarPartida;
	}

	/**
	 * Accedente de la variable ganado
	 * @return Devuelve boolean
	 */
	public boolean getGanado(){
		return _ganado;
	}
	
	/**
	 * Accedente de la variable puntación
	 * @return Devuelve un entero
	 */
	public int getPuntuacion(){
		return _puntuacion;
	}
	
	/**
	 * Accedente de la variable vida 
	 * @return Devuelve un entero
	 */
	public int getVida(){
		return _vida;
	}
}
