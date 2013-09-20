package lige.grupo18.pr4.modelo.items;

import lige.grupo18.pr4.modelo.jugador.Player;
import lige.grupo18.pr4.modelo.Room;

/**
 * Clase que define un Item de tipo consumible
 * @author grupo18
 * @version 1.0
 * @see ItemConsumible
 * @see Item
 */
public class Comida extends ItemConsumible {

	private int _vida;
	
	
	/**
	 * Constructor con parametros de Comida
	 * @param id Identificador
	 * @param descripcion Descripción del Item
	 * @param vida Cantidad de vida que suma o resta
	 * @param cantidad Número de veces que puede ser usado el Item
	 */
	public Comida(String id, String descripcion, int vida, int cantidad)
	{
		super(id,descripcion);
		_vida=vida;
		_cantidad=cantidad;
	}
	
	/**
	 * Método que obtiene el número de veces que puede ser usado el Item 
	 * @return Devuelve la cantidad
	 */
	public int getCantidad()
	{
		return _cantidad;
	}
	/**
	 * Método que ejecuta la función del Item
	 * @param who Objeto de tipo Player
	 * @param where Objeto de tipo Room
	 */
	public String use(Player who,Room where)
	{
		String mensaje="";
		//Si el Item puede ser usado lo ejecutamos
		if(canBeUsed())
		{
			//Aumentamos o disminuimos la vida
			who.increaseLife(_vida);
			//Reducimos la cantidad
			_cantidad=_cantidad-1;
			
			mensaje ="Se usó "+_id;
			
			//Si la cantidad es 0 eliminamos el Item del inventario del jugador
			if(_cantidad==0)
			{
				who.removeItem(_id);
				mensaje="Se usó "+_id+" y ha sido borrado de tu inventario.";
			}
		}
		
		return mensaje;
	}
	/**
	 * Método que devuelve la información del Item.
	 * @return Devuelve un String con la información.
	 */
	public String toString() {
		
		return "\n--Objeto["+_id+"] = "+_descripcion+" // "+_cantidad;		
		
	}
	/**
	 * Metodo que obtiene la descripción de la comida
	 * @return descripción
	 */
	public String getDescripcion()
	{
		return _descripcion+" // "+_cantidad;
	}
}
