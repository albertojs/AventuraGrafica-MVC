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
	 * @param descripcion Descripci�n del Item
	 * @param vida Cantidad de vida que suma o resta
	 * @param cantidad N�mero de veces que puede ser usado el Item
	 */
	public Comida(String id, String descripcion, int vida, int cantidad)
	{
		super(id,descripcion);
		_vida=vida;
		_cantidad=cantidad;
	}
	
	/**
	 * M�todo que obtiene el n�mero de veces que puede ser usado el Item 
	 * @return Devuelve la cantidad
	 */
	public int getCantidad()
	{
		return _cantidad;
	}
	/**
	 * M�todo que ejecuta la funci�n del Item
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
			
			mensaje ="Se us� "+_id;
			
			//Si la cantidad es 0 eliminamos el Item del inventario del jugador
			if(_cantidad==0)
			{
				who.removeItem(_id);
				mensaje="Se us� "+_id+" y ha sido borrado de tu inventario.";
			}
		}
		
		return mensaje;
	}
	/**
	 * M�todo que devuelve la informaci�n del Item.
	 * @return Devuelve un String con la informaci�n.
	 */
	public String toString() {
		
		return "\n--Objeto["+_id+"] = "+_descripcion+" // "+_cantidad;		
		
	}
	/**
	 * Metodo que obtiene la descripci�n de la comida
	 * @return descripci�n
	 */
	public String getDescripcion()
	{
		return _descripcion+" // "+_cantidad;
	}
}
