package lige.grupo18.pr4.modelo.jugador;

import lige.grupo18.pr4.modelo.Inventario;
import lige.grupo18.pr4.modelo.items.Item;

/**
 * Clase que define un jugador para el juego
 * @author grupo18
 * @version 1.0
 */
public class Player {
	
	//Atributos de Player
	private int _vida;
	private int _puntuacion;
	private Inventario _inventario;
	
	/**
	 * Constructor por defecto de Player
	 */
	public Player()
	{
		_vida = 100;
		_puntuacion = 0;
		_inventario = new Inventario();
	}
	
	/**
	 * Constructor con parametros de Player
	 * @param vida Cantidad de vida inicial
	 * @param puntuacion Puntuaci�n inicial
	 */
	public Player (int vida, int puntuacion)
	{
		_vida = vida;
		_puntuacion = puntuacion;
		_inventario = new Inventario();
	}
	
	/**
	 * M�todo get que obtiene la vida
	 * @return Devuelve la vida del jugador
	 */
	public int getVida ()
	{
		return _vida;
	}
	
	/**
	 * M�todo que devuelve el inventario de Items del jugador
	 * @return Devuelve el Inventario del jugador
	 */
	public Inventario getInventario()
	{
		return _inventario;
	}
	
	/**
	 * M�todo get que devuelve la puntuaci�n
	 * @return Devuelve la puntuaci�n
	 */
	public int getPuntuacion()
	{
		return _puntuacion;		
	}
	
	/**
	 * M�todo que busca un Item del inventario
	 * @param id Identificador del Item
	 * @return Devuelve el Item y null si no lo encuentra
	 */
	public Item findItem (String id)
	{
		return _inventario.findItem(id);
	}
	
	/**
	 * M�todo que a�ade un nuevo Item al inventario
	 * @param objeto Item a a�adir
	 * @return Devuelve true si se ha a�adido con exito
	 */
	public boolean addItem(Item objeto)
	{
		return _inventario.addItem(objeto); 
	}
	
	/**
	 * M�todo que elimina un Item del inventario
	 * @param id Identificador del Item a eliminar
	 * @return Devuelve true si se ha eliminado correctamente
	 */
	public boolean removeItem(String id)
	{
		return _inventario.removeItem(id);
	}
	
	/**
	 * M�todo que decrementa la vida del jugador
	 * @param valor Cantidad a decrementar
	 */
	public void decreaseLife(int  valor)
	{
		_vida=_vida - valor;
	
	}
	
	/**
	 * M�todo que incrementa la vida del jugador
	 * @param valor Cantidad a incrementar
	 */
	public void increaseLife(int valor)
	{
		_vida=_vida + valor;
	
	}
	
	/**
	 * M�todo que gestiona si el jugador a�n esta vivo
	 * @return Devuelve true si sigue vivo
	 */
	public boolean isAlive()
	{
		return _vida>0;
	}
	
	/**
	 * M�todo que devuelve la informaci�n del jugador
	 * @return Devuelve un String con la informaci�n
	 */
	public String showInfo()
	{
		return "VIDA = "+_vida+" , PUNTUACI�N = "+_puntuacion;
	}
	
	/**
	 * M�todo que incrementa la puntuaci�n del jugador
	 * @param valor Cantidad a incrementar
	 */
	public void increaseScore(int valor)
	{
		_puntuacion=_puntuacion+valor;
	}
	
	/**
	 * M�todo que muestra un Item del jugador
	 * @param id Identificador del Item a mostrar
	 * @return Devuelve un String con la informaci�n
	 */
	public String showItem(String id)
	{	
		return _inventario.showItem(id);
	}
	
	/**
	 * M�todo que muestra los Items del inventario del jugador
	 * @return Devuelve un String con toda la informaci�n
	 */
	public String showItems()
	{
		if(_inventario.isEmpty())
			return "Eres pobre, no tienes ning�n objeto (aun).";
		else
		{
			return "Mis objetos son:"+ _inventario.toString();
			
		}
	}
}
