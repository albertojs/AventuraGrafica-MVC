package lige.grupo18.pr4.modelo.items;

/**
 * Clase abstracta de los items persistentes
 * @author grupo18
 * @version 2.0
 */
public abstract class ItemPersistente extends Item{

	/**
	 * Constructor parametrizado
	 * @param id identificador del objeto
	 * @param descripcion descripcion del objeto
	 */
	public ItemPersistente(String id, String descripcion) {
		super(id,descripcion);
	}
	
	/**
	 * Metodo que dice si puede ser usado un item
	 * @return Devuelve true
	 */
	public boolean canBeUsed()
	{
		return true;
	}
}
