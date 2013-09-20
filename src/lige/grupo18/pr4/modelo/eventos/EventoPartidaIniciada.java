package lige.grupo18.pr4.modelo.eventos;

import java.util.ArrayList;

import lige.grupo18.pr4.EnumeradorEventos;
import lige.grupo18.pr4.modelo.Inventario;
import lige.grupo18.pr4.modelo.Room;
import lige.grupo18.pr4.modelo.items.Item;

/**
 * Clase que contiene el evento de iniciar la partida
 * @author grupo18
 *
 */
public class EventoPartidaIniciada implements Evento{

	//Variables privadas
	private int _vida;
	private int _puntuacion;
	private Room _habitacionActual;
	private Inventario _inventarioJugador;
	
	/**
	 * Contructor parametrizado
	 * @param vida vida
	 * @param puntuacion puntuacion
	 * @param habitacionActual habitacion actual
	 * @param inventario inventario
	 */
	public EventoPartidaIniciada(int vida, int puntuacion, Room habitacionActual, Inventario inventario)
	{
		_vida=vida;
		_puntuacion=puntuacion;
		_habitacionActual=habitacionActual;
		_inventarioJugador=inventario;
	}
	/**
	 * Accedente de la vida
	 * @return vida
	 */
	public int getVida()
	{
		return _vida;
	}
	/**
	 * Accedente de la puntuacion
	 * @return puntuacion
	 */
	public int getPuntuacion()
	{
		return _puntuacion;
	}
	/**
	 * Accedente de la habitacion
	 * @return habitacion
	 */
	public Room getHabitacionActual()
	{
		return _habitacionActual;
	}
	/**
	 * Accedente del inventario
	 * @return inventario
	 */
	public Inventario getInventario()
	{
		return _inventarioJugador;
	}
	/**
	 * Metodo que devuelve el enumerado del tipo de evento
	 */
	public EnumeradorEventos getTipo() {
			return EnumeradorEventos.EventoPartidaIniciada;
		
	}
	/**
	 * Metodo que devuelve la lista de objetos de la habitación
	 * @return lista de items
	 */
	public ArrayList<Item> getItems()
	{
		return _habitacionActual.getObjetos();
	}

}
