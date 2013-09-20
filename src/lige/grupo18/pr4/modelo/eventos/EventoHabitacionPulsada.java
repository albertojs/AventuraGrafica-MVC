package lige.grupo18.pr4.modelo.eventos;

import lige.grupo18.pr4.EnumeradorEventos;
import lige.grupo18.pr4.modelo.Room;

/**
 * Clase que tiene el evento de la habitación que se pulsa
 * @author grupo18
 *
 */
public class EventoHabitacionPulsada implements Evento {

	//Variable privada
	private Room _habitacion;
	
	/**
	 * Constructor parametrizado
	 * @param habitacion
	 */
	public EventoHabitacionPulsada(Room habitacion){
		_habitacion = habitacion;
	}
	@Override
	/**
	 * Obtiene el tipo de evento
	 */
	public EnumeradorEventos getTipo() {
		return EnumeradorEventos.EventoHabitacionPulsada;
	}
	
	/**
	 * Accedente de la habitacion
	 * @return habitacion
	 */
	public Room getHabitacion(){
		//return habitacion.mostrar();
		return _habitacion;
	}

	/**
	 * Accedente de la descripción
	 * @return descripción
	 */
	public String getDescripcion(){
		return _habitacion.toString();
	}
}