package lige.grupo18.pr4.modelo;

import java.util.*;

import lige.grupo18.pr4.modelo.items.Item;

/**
 * Clase que describe una habitación del juego incluyendo una descripción de este y si es una salida o no
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
	 * @param descripcion Descripción de la habitacion
	 * @param salida Indica si la habitación es una salida o no
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
	 * Método get del atributo descripción
	 * @return Devuelve la descripción de la habitación
	 */
	public String getDescripcion()
	{
		return this._descripcion;
	}
	
	/**
	 * Método get del atributo salida
	 * @return Devuelve si la habitación es una salida o no
	 */
	public boolean getSalida()
	{
		return this._salida;
	}
	
	/**
	 * 
	 * @return devuelve el array con los objetos que hay en la habitación
	 */
	public ArrayList<Item> getObjetos()
	{
		return _objetos.getObjetos();
	}
	
	/**
	 * Método set del atributo descripción
	 * @param descripcion Contiene la descripción de la habitación
	 */
	public void setDescripcion(String descripcion)
	{
		this._descripcion=descripcion;
	}
	/**
	 * Método set del atributo salida
	 * @param salida Contiene si la habitación es una salida o no
	 */
	public void setSalida(boolean salida)
	{
		this._salida=salida;
	}
	/**
	 * Método que muesta los items de la habitación
	 * @return Devuelve un String con la descripción de los Items de la habitación
	 */
	public String showItems()
	{		
		if(_objetos.isEmpty())
			return "Este lugar no contiene ningún objeto.";
		else
		{
			return "Este lugar contiene los siguientes objetos: "+ _objetos.toString();
			
		}
	}
	
	/**
	 * Método que elimina un Item de la habitación
	 * @param id Identificador del Item a eliminar
	 * @return Devuelve true si se ha eliminado con exito
	 */
	public boolean removeItem(String id)
	{
		return _objetos.removeItem(id);
	}
	
	/**
	 * Método que añade un objeto al inventario de la habitación
	 * @param objeto Objeto a añadir
	 * @return Devuelve true si se ha añadido con exito
	 */
	public boolean addItem(Item objeto)
	{
		return _objetos.addItem(objeto);
	}
	
	/**
	 * Método que busca un Item en el inventario de la habitación
	 * @param id Identificador del Item
	 * @return Devuelve el item y null si no lo encuentra
	 */
	public Item findItem(String id)
	{
		return _objetos.findItem(id);
	}
	/**
	 * Método que muestra toda la información relacionada con la habitación
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
