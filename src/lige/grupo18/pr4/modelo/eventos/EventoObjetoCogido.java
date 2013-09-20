package lige.grupo18.pr4.modelo.eventos;

import java.util.ArrayList;
import lige.grupo18.pr4.EnumeradorEventos;
import lige.grupo18.pr4.modelo.Inventario;
import lige.grupo18.pr4.modelo.Room;
import lige.grupo18.pr4.modelo.items.Item;

/**
 * Clase que contiene el evento de coger objeto
 * @author grupo18
 *
 */
public class EventoObjetoCogido implements Evento{

	//Variables privadas
	private Room _habitacionActual;
	private Inventario _inventarioJugador;
	
	/**
	 * Contructor parametrizado
	 * @param habitacion habitacion
	 * @param inventario inventario
	 */
	public EventoObjetoCogido(Room habitacion,Inventario inventario)
	{
		_habitacionActual=habitacion;
		_inventarioJugador=inventario;
	}
	/**
	 * Accedente de habitacion
	 * @return habitacion
	 */
	public Room getRoom()
	{
		return _habitacionActual;
	}
	/**
	 * Accedente de inventario
	 * @return inventario
	 */
	public Inventario getInventarioJugador()
	{
		return _inventarioJugador;
	}
	/**
	 * Metodo que devuelve la descripcion de la habitacion
	 * @return descripcion
	 */
	public String getDescripcionHabitacion()
	{
		return _habitacionActual.toString();
	}
	/**
	 * Metodo que devuelve los objetos de la habitacion actual
	 * @return items
	 */
	public ArrayList<Item> getItems()
	{
		return _habitacionActual.getObjetos();
	}
	/**
	 * Metodo que devuelve el tipo de evento de la clase
	 */
	public EnumeradorEventos getTipo() {
		
		return EnumeradorEventos.EventoObjetoCogido;
	}
	/**
	 * Metodo que devuelve el inventario del jugador
	 * @return Devuelve String
	 */
	public String showPlayerItems()
	{
		return _inventarioJugador.toString();
	}
}
