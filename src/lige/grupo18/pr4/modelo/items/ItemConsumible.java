package lige.grupo18.pr4.modelo.items;

/**
 * Clase abstracta de los items consumibles
 * @author grupo18
 * @version 2.0
 */
public abstract class ItemConsumible extends Item{

	protected int _cantidad;
	
	/**
	 * Constructor parametrizado
	 * @param id identificador del objeto
	 * @param descripcion descripcion del objeto
	 */
	public ItemConsumible(String id, String descripcion) {
		super(id,descripcion);
	}
	/**
	 * Método que indica si el Item puede ser usado o no.
	 * @return Devuelve un booleando,true si puede seguir usandose el Item.
	 */
	public boolean canBeUsed()
	{
		if(_cantidad>0)
			return true;
		else
			return false;
	}

}
