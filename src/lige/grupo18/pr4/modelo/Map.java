package lige.grupo18.pr4.modelo;

import java.util.ArrayList;

import lige.grupo18.pr4.Directions;

/**
 * Clase que representa el mapa y guarda todas las puertas del juego.
 * @author grupo18
 * @version 2.0
 */
public class Map {

	//vector de puertas
	private ArrayList<Door> _vectorPuertas;
	
	/**
	 * Constructor por defecto de Map
	 */
	public Map()
	{
		_vectorPuertas=null;
	}
	
	/**
	 * Método que devuelve el vector de puertas del mapa
	 * @return Devuelve el vector de puertas, atributo de la clase
	 */
	public ArrayList<Door> getDoors()
	{
		return _vectorPuertas;
	}
	
	/**
	 * Método que establece un vector de puertas al atributo de la clase 
	 * @param vectorPuertas Contiene un vector de puertas
	 */
	public void setDoors(ArrayList<Door> vectorPuertas)
	{
		this._vectorPuertas=vectorPuertas;
	}
	/**
	 * Método que busca una puerta en el vector de puertas
	 * @param habActual Recibe la habitación a buscar
	 * @param direccion Recibe la direccion en la cual buscar la puerta
	 * @return Devuelve un objeto Door si se encuentra y null si no.
	 */
	public Door findDoor(Room habActual,Directions direccion)
	{
		boolean puertaEncontrada=false;
		int i=0;
		Door puerta=null;
		
		while(!puertaEncontrada && i<_vectorPuertas.size())
		{
			if(_vectorPuertas.get(i).isInRoom(habActual,direccion))
			{
				//Si se encuentra una puerta en esa dirección se obtiene kla puerta para devolverla
				puertaEncontrada=true;
				puerta=_vectorPuertas.get(i);
			}
			else
				i++;
		}
		
		return puerta;
	}
	
}
