package lige.grupo18.pr4.modelo.eventos;

import java.util.ArrayList;

import lige.grupo18.pr4.Directions;
import lige.grupo18.pr4.EnumeradorEventos;
import lige.grupo18.pr4.modelo.Room;
import lige.grupo18.pr4.modelo.items.Item;

/**
 * Clase que contiene el evento de ir
 * @author Guillermo de Pablos
 *
 */
public class EventoIr implements Evento {

	//Variables privadas
	private Room _habitacion;
	private int _vida;
	private Directions _direccion;
	
	/**
	 * Contructor parametrizado
	 * @param room habitacion
	 * @param life vida
	 * @param directions direccion
	 */
	public EventoIr(Room room, int life, Directions directions){
		_habitacion = room;
		_vida = life;
		_direccion = directions;
	}
	
	/**
	 * Accedente de la vida
	 * @return vida
	 */
	public int getVida(){
		return _vida;
	}
	
	/**
	 * Accedente de la habitacion
	 * @return habitacion
	 */
	public Room getHabitacion(){
		return _habitacion;
	}
	
	/**
	 * Accedente de la dirección
	 * @return direccion
	 */
	public Directions getDireccion(){
		return _direccion;
	}
	
	@Override
	/**
	 * Metodo que obtiene el tipo de evento de la clase
	 */
	public EnumeradorEventos getTipo() {
		return EnumeradorEventos.EventoIr;
	}

	/**
	 * Metodo que obtiene los objetos que hay en una habitacion
	 * @return inventario de objetos
	 */
	public ArrayList<Item> getInventarioHabitacion(){
		return _habitacion.getObjetos();
	}
	
	/**
	 * Metodo que obtiene la descripcion de la habitacion
	 * @return Devuelve String
	 */
	public String getDescripcion(){
		return _habitacion.toString();
	}
}
