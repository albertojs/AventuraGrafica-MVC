package lige.grupo18.pr4.modelo;

import java.util.*;

import lige.grupo18.pr4.modelo.items.Item;

/**
 * Clase que describe una habitaci�n del juego incluyendo una descripci�n de este y si es una salida o no
 * @version 2.0
 * @author grupo18
 * 
 */
public class Room {
	
	//Atributos de Room
	private String _nombre;
	private String _descripcion;
	private boolean _salida;	
	private Inventario _objetos;
	
	/**
	 * Contructor por defecto de Room
	 */
	public Room()
	{
		_nombre="";
		_descripcion="";
		_salida = false;
		_objetos = new Inventario();
	}
	/**
	 * Constructor con parametros de Room
	 * @param descripcion Descripci�n de la habitacion
	 * @param salida Indica si la habitaci�n es una salida o no
	 */
	public Room(String nombre,String descripcion,boolean salida, Inventario objetos)
	{
		_nombre=nombre;
		_descripcion = descripcion;
		_salida = salida;
		_objetos = new Inventario();
		
	}
	/**
	 * Accedente que obtiene el nombre
	 * @return nombre
	 */
	public String getNombre()
	{
		return _nombre;
	}
	/**
	 * Mutador que establece los objetos
	 * @param objetos
	 */
	public void setObjetos(Inventario objetos)
	{
		_objetos=objetos;
	}
	/**
	 * M�todo get del atributo descripci�n
	 * @return Devuelve la descripci�n de la habitaci�n
	 */
	public String getDescripcion()
	{
		return this._descripcion;
	}
	
	/**
	 * M�todo get del atributo salida
	 * @return Devuelve si la habitaci�n es una salida o no
	 */
	public boolean getSalida()
	{
		return this._salida;
	}
	
	/**
	 * 
	 * @return devuelve el array con los objetos que hay en la habitaci�n
	 */
	public ArrayList<Item> getObjetos()
	{
		return _objetos.getObjetos();
	}
	
	/**
	 * M�todo set del atributo descripci�n
	 * @param descripcion Contiene la descripci�n de la habitaci�n
	 */
	public void setDescripcion(String descripcion)
	{
		this._descripcion=descripcion;
	}
	/**
	 * M�todo set del atributo salida
	 * @param salida Contiene si la habitaci�n es una salida o no
	 */
	public void setSalida(boolean salida)
	{
		this._salida=salida;
	}
	/**
	 * M�todo que muesta los items de la habitaci�n
	 * @return Devuelve un String con la descripci�n de los Items de la habitaci�n
	 */
	public String showItems()
	{		
		if(_objetos.isEmpty())
			return "Este lugar no contiene ning�n objeto.";
		else
		{
			return "Este lugar contiene los siguientes objetos: "+ _objetos.toString();
			
		}
	}
	
	/**
	 * M�todo que elimina un Item de la habitaci�n
	 * @param id Identificador del Item a eliminar
	 * @return Devuelve true si se ha eliminado con exito
	 */
	public boolean removeItem(String id)
	{
		return _objetos.removeItem(id);
	}
	
	/**
	 * M�todo que a�ade un objeto al inventario de la habitaci�n
	 * @param objeto Objeto a a�adir
	 * @return Devuelve true si se ha a�adido con exito
	 */
	public boolean addItem(Item objeto)
	{
		return _objetos.addItem(objeto);
	}
	
	/**
	 * M�todo que busca un Item en el inventario de la habitaci�n
	 * @param id Identificador del Item
	 * @return Devuelve el item y null si no lo encuentra
	 */
	public Item findItem(String id)
	{
		return _objetos.findItem(id);
	}
	/**
	 * M�todo que muestra toda la informaci�n relacionada con la habitaci�n
	 */
	public String toString()
	{
		String cadena="";
		cadena=cadena+getDescripcion()+"\n"+showItems();
		return cadena;
	}
	/**
	 * Metodo que devulve el inventario
	 * @return inventario
	 */
	public Inventario getInventario()
	{
		return _objetos;
	}
	
}
