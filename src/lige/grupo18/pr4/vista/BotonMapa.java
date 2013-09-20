package lige.grupo18.pr4.vista;

import javax.swing.JButton;

import lige.grupo18.pr4.modelo.Room;

@SuppressWarnings("serial")
/**
 * Clase que hereda de JButton, lo que hacemos es a�adirle mas funcionalidad a un boton
 * @author grupo 18
 *
 */
public class BotonMapa extends JButton {

	//Variables privadas
	private int _x;
	private int _y;
	private boolean _activa;
	private boolean _visitada;
	private Room _habitacion;
	
	/**
	 * Contructor parametrizado
	 * @param x posicion x en el mapa
	 * @param y posicion y en el mapa
	 * @param activa indica si es la posici�n activa
	 * @param visitada indica si se ha visitado la habitaci�n
	 * @param habitacion indica la habitaci�n que contiene el boton
	 */
	public BotonMapa(int x, int y, boolean activa, boolean visitada,Room habitacion){
		_x = x;
		_y = y;
		_activa = activa;
		_visitada = visitada;
		_habitacion = habitacion;
	}
	
	/**
	 * Accedente que devuelve la posici�n x
	 * @return posicion x en el mapa
	 */
	public int getCoordenadaX(){
		return _x;
	}
	
	/**
	 * Accedente que devuelve la posici�n y 
	 * @return posici�n y en el mapa
	 */
	public int getCoordenadaY(){
		return _y;
	}
	
	/**
	 * Accedente que devuelve si la habitaci�n ha sido visitada
	 * @return booleano si es vistada
	 */
	public boolean getVisitada(){
		return _visitada;
	}
	/**
	 * Accedente que devuelve si la habitaci�n es la activa
	 * @return booleano si es la activa
	 */
	public boolean getActiva()
	{
		return _activa;
	}
	/**
	 * Accedente que me devulve la habitaci�n
	 * @return habitaci�n que contiene el boton
	 */
	public Room getRoom()
	{
		return _habitacion;
	}
	/**
	 * Mutador que establece la habitaci�n del boton
	 * @param habi habitaci�n
	 */
	public void setHabitacion(Room habi){
		_habitacion = habi;
	}
	
	/**
	 * Mutador que establece q se visita una habitacion
	 * @param visit visitada
	 */
	public void setVisitada(boolean visit){
		_visitada = visit;
	}
	
	/**
	 * Mutador que establece si es la habitaci�n activa
	 * @param active 
	 */
	public void setActiva(boolean active){
		_activa = active;
	}
}
