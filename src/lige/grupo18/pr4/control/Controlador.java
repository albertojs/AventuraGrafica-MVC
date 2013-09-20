package lige.grupo18.pr4.control;

import lige.grupo18.pr4.Directions;
import lige.grupo18.pr4.modelo.Game;
import lige.grupo18.pr4.modelo.Room;
import lige.grupo18.pr4.modelo.commands.CommandCoger;
import lige.grupo18.pr4.modelo.commands.CommandIr;
import lige.grupo18.pr4.modelo.commands.CommandSoltar;
import lige.grupo18.pr4.modelo.commands.CommandUsar;

/**
 * Clase controlador que determina las modificaciones que hay que hacer 
 * en el modelo cuando se iteracciona con la vista
 * @author grupo18
 *
 */
public class Controlador {

	//Atributos privados
	private Game _modelo;
	
	/**
	 * Contructor parametrizado
	 * @param modelo
	 */
	public Controlador(Game modelo)
	{
		_modelo=modelo;
	}
	/**
	 * Metodo que solicita iniciar la partida
	 */
	public void solicitarIniciarPartida()
	{
		_modelo.iniciarPartida();
	}
	/**
	 * Metodo que solicita coger un item
	 * @param idItem
	 */
	public void solicitarCogerItem(String idItem)
	{
		CommandCoger comando=new CommandCoger(idItem,_modelo);
		_modelo.accionUsuario(comando);
	}
	/**
	 * Metodo que solicita soltar un item
	 * @param idItem
	 */
	public void solicitarSoltarItem(String idItem)
	{
		CommandSoltar comando=new CommandSoltar(idItem,_modelo);
		_modelo.accionUsuario(comando);
	}
	/**
	 * Metodo que solicita usar un item del inventario
	 * @param idItem
	 */
	public void solicitarUsarItem(String idItem)
	{
		CommandUsar comando=new CommandUsar(idItem,_modelo);
		_modelo.accionUsuario(comando);
	}
	/**
	 * Metodo que solicita ir a una dirección
	 * @param direccion
	 */
	public void solicitarIr(Directions direccion){
		CommandIr command = new CommandIr(direccion,_modelo);
		_modelo.accionUsuario(command);
	}
	/**
	 * Metodo que solicita al pulsar una habitación del mapa
	 * @param habitacion
	 */
	public void solicitarPulsarBotonHabitacion(Room habitacion){
		_modelo.pulsaHabitacion(habitacion);
	}
}
