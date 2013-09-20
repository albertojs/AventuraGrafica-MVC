package lige.grupo18.pr4.modelo;

import java.util.ArrayList;

import lige.grupo18.pr4.modelo.items.Item;

/**
 * Clase que define una coleccion de objetos
 * @author grupo18
 * @version 2.0
 */
public class Inventario {

	private ArrayList<Item> _objetos;
	
	/**
	 * Constructor por defecto
	 */
	public Inventario()
	{
		_objetos= new ArrayList<Item>();
	}
	
	/**
	 * M�todo get que obtiene el ArrayList de elementos.
	 * @return Devuelve el array de elementos.
	 */
	public ArrayList<Item> getObjetos()
	{
		return _objetos;
	}
	
	/**
	 * M�todo que comprueba si el array esta vac�o.
	 * @return Devuelve true si esta vac�o, false si no lo esta.
	 */
	public boolean isEmpty()
	{
		return _objetos.size()==0;
	}
	
	/**
	 * M�todo que busca un elemento del array a traves de su ID.
	 * @param id Identificador del elemento a buscar.
	 * @return Devuelve el Item encontrado y null si no lo encuentra.
	 */
	public Item findItem (String id)
	{
		Item objeto=null;
		int indice=getIndex(id);
		
		if(indice!=-1)
			objeto=_objetos.get(indice);
		
		return objeto;
	}
	
	/**
	 * M�todo que a�ade un nuevo Item al inventario.
	 * @param objeto Item a a�adir.
	 * @return Devuelve true si el objeto se ha a�adido con exito.
	 */
	public boolean addItem(Item objeto)
	{
		Item objetoAux=this.findItem(objeto.getId());
		boolean repetido=false;
		
		//Si el Item no exist�a antes lo agrego al inventario
		if(objetoAux==null)
			_objetos.add(objeto);
		else 
			repetido=true;
		
		return repetido; 
	}
	
	/**
	 * M�todo que elimina un Item del inventario
	 * @param id Identificador del Item a eliminar.
	 * @return Devuelve true si se ha eliminado con exito.
	 */
	public boolean removeItem(String id)
	{
		int indice=getIndex(id);
		
		if(indice!=-1)
		{
			_objetos.remove(indice);
			return true;
		}
		else
			return false;
				
		
	}
	/**
	 * M�todo que muestra un elemento del inventario.
	 * @param id Identificador del elemento a mostrar.
	 * @return devuelve un String con la descripcion.
	 */
	public String showItem(String id)
	{
		String cadena="";
		
		//Si el inventario no esta vacio buscamos el elemento
		if(!isEmpty())
		{
			Item objeto=findItem(id);
			//Si el elemento no es nulo lo mostramos
			if(objeto!=null)
				cadena=cadena+objeto.toString();
			else
				cadena="No hay <<"+id+">> en tu inventario.";
		}
		else
			cadena="Eres pobre, no tienes ning�n objeto (aun).";
		
		return cadena;
	}
	
	/**
	 * M�todo que nuestra todos los elementos del inventario.
	 * @return Devuelve un String con la descripci�n de todos los Items.
	 */
	public String toString()
	{
		String cadena="";
		
		if(!isEmpty())
		{			
			int i=0;
			
			//Vamos recorriendo el array mostrando los Items
			while(i<_objetos.size())
			{
				Item objeto=_objetos.get(i);
				cadena=cadena+objeto.toString();
				i++;
			}
		}
		
		return cadena;
	}
	/**
	 * M�todo que obtiene el �ndice de un objeto del inventario a trav�s de su ID
	 * @param id Identificador del objeto
	 * @return Devuelve el �ndice
	 */
	private int getIndex(String id)
	{
		int i = 0;
		boolean encontrado = false;
		//Recorro el while hasta que se encuentre el Item o se llegue al final
		while (i < _objetos.size() && !encontrado)
		{
			Item objetoAux=_objetos.get(i);
			if(objetoAux.getId().toUpperCase().equals(id.toUpperCase()))
				encontrado=true;
			else 
				i++;
		}
		
		if(encontrado)
			return i;
		else 
			return -1;
	}
	/**
	 * Metodo que devuelve el tama�o del invnetario
	 * @return tama�o
	 */
	public int getSize()
	{
		return _objetos.size();
	}
	/**
	 * Metodo que devuelve el elemento i del la lista
	 * @param i posicion
	 * @return Item
	 */
	public Item getItem(int i)
	{
		return _objetos.get(i);
	}
}

