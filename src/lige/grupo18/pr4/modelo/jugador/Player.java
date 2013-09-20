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
	 * @param puntuacion Puntuación inicial
	 */
	public Player (int vida, int puntuacion)
	{
		_vida = vida;
		_puntuacion = puntuacion;
		_inventario = new Inventario();
	}
	
	/**
	 * Método get que obtiene la vida
	 * @return Devuelve la vida del jugador
	 */
	public int getVida ()
	{
		return _vida;
	}
	
	/**
	 * Método que devuelve el inventario de Items del jugador
	 * @return Devuelve el Inventario del jugador
	 */
	public Inventario getInventario()
	{
		return _inventario;
	}
	
	/**
	 * Método get que devuelve la puntuación
	 * @return Devuelve la puntuación
	 */
	public int getPuntuacion()
	{
		return _puntuacion;		
	}
	
	/**
	 * Método que busca un Item del inventario
	 * @param id Identificador del Item
	 * @return Devuelve el Item y null si no lo encuentra
	 */
	public Item findItem (String id)
	{
		return _inventario.findItem(id);
	}
	
	/**
	 * Método que añade un nuevo Item al inventario
	 * @param objeto Item a añadir
	 * @return Devuelve true si se ha añadido con exito
	 */
	public boolean addItem(Item objeto)
	{
		return _inventario.addItem(objeto); 
	}
	
	/**
	 * Método que elimina un Item del inventario
	 * @param id Identificador del Item a eliminar
	 * @return Devuelve true si se ha eliminado correctamente
	 */
	public boolean removeItem(String id)
	{
		return _inventario.removeItem(id);
	}
	
	/**
	 * Método que decrementa la vida del jugador
	 * @param valor Cantidad a decrementar
	 */
	public void decreaseLife(int  valor)
	{
		_vida=_vida - valor;
	
	}
	
	/**
	 * Método que incrementa la vida del jugador
	 * @param valor Cantidad a incrementar
	 */
	public void increaseLife(int valor)
	{
		_vida=_vida + valor;
	
	}
	
	/**
	 * Método que gestiona si el jugador aún esta vivo
	 * @return Devuelve true si sigue vivo
	 */
	public boolean isAlive()
	{
		return _vida>0;
	}
	
	/**
	 * Método que devuelve la información del jugador
	 * @return Devuelve un String con la información
	 */
	public String showInfo()
	{
		return "VIDA = "+_vida+" , PUNTUACIÓN = "+_puntuacion;
	}
	
	/**
	 * Método que incrementa la puntuación del jugador
	 * @param valor Cantidad a incrementar
	 */
	public void increaseScore(int valor)
	{
		_puntuacion=_puntuacion+valor;
	}
	
	/**
	 * Método que muestra un Item del jugador
	 * @param id Identificador del Item a mostrar
	 * @return Devuelve un String con la información
	 */
	public String showItem(String id)
	{	
		return _inventario.showItem(id);
	}
	
	/**
	 * Método que muestra los Items del inventario del jugador
	 * @return Devuelve un String con toda la información
	 */
	public String showItems()
	{
		if(_inventario.isEmpty())
			return "Eres pobre, no tienes ningún objeto (aun).";
		else
		{
			return "Mis objetos son:"+ _inventario.toString();
			
		}
	}
}
