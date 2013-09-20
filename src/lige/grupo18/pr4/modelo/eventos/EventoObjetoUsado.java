package lige.grupo18.pr4.modelo.eventos;

import lige.grupo18.pr4.EnumeradorEventos;
import lige.grupo18.pr4.modelo.Inventario;

/**
 * Clase que contiene el evento de usar los objetos del jugador
 * @author grupo18
 *
 */
public class EventoObjetoUsado implements Evento{
	
	//Variables privadas
	private Inventario _inventarioJugador;
	private int _vida;
	private int _puntuacion;
	private String _mensaje;
	
	/**
	 * Contructor parametrizado
	 * @param inventario inventario
	 * @param vida vida
	 * @param puntuacion puntuacion
	 * @param mensaje mensaje
	 */
	public EventoObjetoUsado(Inventario inventario,int vida,int puntuacion,String mensaje)
	{
		_inventarioJugador=inventario;
		_vida=vida;
		_puntuacion=puntuacion;
		_mensaje=mensaje;
	}

	/**
	 * Accedente del mensaje
	 * @return mensaje
	 */
	public String getMensaje()
	{
		return _mensaje;
	}
	/**
	 * Accedente de la vida
	 * @return vida
	 */
	public int getVida()
	{
		return _vida;
	}
	/**
	 * Accedente de la puntuacion
	 * @return puntuacion
	 */
	public int getPuntuacion()
	{
		return _puntuacion;
	}
	/**
	 * Accedente del inventario
	 * @return inventario
	 */
	public Inventario getInventario()
	{
		return _inventarioJugador;
	}
	/**
	 * Metodo que devuelve el enumerado del evento de la clase
	 */
	public EnumeradorEventos getTipo() {
		
		return EnumeradorEventos.EventoUsarObjeto;
	}
	

}
