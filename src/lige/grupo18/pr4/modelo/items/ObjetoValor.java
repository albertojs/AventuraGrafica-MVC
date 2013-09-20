package lige.grupo18.pr4.modelo.items;

import lige.grupo18.pr4.modelo.jugador.Player;
import lige.grupo18.pr4.modelo.Room;

/**
 * Clase que tiene la funcionalidad de los items consumibles
 * @author grupo18
 * @version 2.0
 * @see ItemConsumible
 * @see Item
 */
public class ObjetoValor extends ItemConsumible{

	private int _puntos;
	
	/**
	 * Constructor parametrizado
	 * @param id identificador del item
	 * @param descripcion descripcion del item
	 * @param puntos puntos del item
	 */
	public ObjetoValor(String id,String descripcion,int puntos)
	{
		super(id,descripcion);
		_puntos=puntos;
	}
	
	/**
	 * Metodo que mira a ver si puede ser usado
	 * @return Devuelve true
	 */
	public boolean canBeUsed()
	{
		return true;
	}
	
	/**
	 * Metodo que usa el item en un jugador
	 * @param who jugador que usa el item
	 * @param where habitacion donde se usa el objeto
	 */
	public String use(Player who,Room where)
	{
		String mensaje="";
		
		who.increaseScore(_puntos);
		//Eliminamos el objetos despues se usarse
		who.removeItem(_id);
	
		mensaje="Se usó "+_id+" y ha sido borrado de tu inventario.";
		
		return mensaje;
	}
}
