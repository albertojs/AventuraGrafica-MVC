package lige.grupo18.pr4.modelo.items;

import lige.grupo18.pr4.modelo.jugador.Player;
import lige.grupo18.pr4.modelo.Door;
import lige.grupo18.pr4.modelo.Room;

/**
 * Clase que contiene la informacion de uso de la llave
 * @author grupo18
 * @version 2.0
 * @see ItemPersistente
 * @see Item
 */
public class Llave extends ItemPersistente{
		
	private Door _puerta;
	
	/**
	 * Contructir parametrizado
	 * @param id identificador del item
	 * @param descripcion descripcion del objeto
	 * @param puerta puerta que abirirá
	 */
	public Llave(String id,String descripcion,Door puerta)
	{
		super(id,descripcion);
		_puerta=puerta;
	}
	
	/**
	 * Metodo que usa la llave para abir una puerta
	 * @param who jugador que usa la llave
	 * @param where habitacion en la que se usa la llave
	 */
	public String use(Player who,Room where)
	{
		
			if(_puerta.isInRoom(where))
			{
				//Si la puerta está en la habitación actual la abrimos o cerramos
				_puerta.abrirCerrarPuerta();
				//UIConsola.printText("Algo ha cambiado...");
				return "Se usó "+_id;
			}
			else
				return "Creo que te estás equivocando de lugar para usar esta llave";
				//Si la puerta que abre la llave esta en otra habitación, lo indicamos.
				//UIConsola.printText("Creo que te estás equivocando de lugar para usar esta llave");
	}
	

}
