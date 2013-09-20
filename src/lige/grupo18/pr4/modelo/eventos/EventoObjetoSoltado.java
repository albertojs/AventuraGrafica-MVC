package lige.grupo18.pr4.modelo.eventos;

import java.util.ArrayList;
import lige.grupo18.pr4.EnumeradorEventos;
import lige.grupo18.pr4.modelo.Inventario;
import lige.grupo18.pr4.modelo.Room;
import lige.grupo18.pr4.modelo.items.Item;

/**
 * Clase que contiene el evento de soltar un objeto
 * @author grupo18
 *
 */
public class EventoObjetoSoltado implements Evento{
	
	//Variables privadas
	private Room _habitacionActual;
	private Inventario _inventarioJugador;
	
	/**
	 * Constructor parametrizado 
	 * @param habitacion habitacion
	 * @param inventario inventarioo
	 */
	public EventoObjetoSoltado(Room habitacion,Inventario inventario)
	{
		_habitacionActual=habitacion;
		_inventarioJugador=inventario;
	}
	/**
	 * Accedente de la habitacion
	 * @return habitacion
	 */
	public Room getRoom()
	{
		return _habitacionActual;
	}
	/**
	 * Accedente del inventario
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
	 * Metodo que devuelve una lista con los objetos
	 * @return items
	 */
	public ArrayList<Item> getItems()
	{
		return _habitacionActual.getObjetos();
	}
	/**
	 * Metodo que devuelve el enumerado del evento de la clase
	 */
	public EnumeradorEventos getTipo() {
		
		return EnumeradorEventos.EventoObjetoSoltado;
	}
	/**
	 * Metodo que devuelve una cadena con los items del jugador
	 * @return inventario
	 */
	public String showPlayerItems()
	{
		return _inventarioJugador.toString();
	}
}
