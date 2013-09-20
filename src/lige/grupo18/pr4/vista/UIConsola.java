package lige.grupo18.pr4.vista;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import lige.grupo18.pr4.modelo.eventos.Evento;
import lige.grupo18.pr4.modelo.eventos.EventoError;
import lige.grupo18.pr4.modelo.eventos.EventoFinalizarPartida;
import lige.grupo18.pr4.modelo.eventos.EventoHabitacionPulsada;
import lige.grupo18.pr4.modelo.eventos.EventoIr;
import lige.grupo18.pr4.modelo.eventos.EventoObjetoCogido;
import lige.grupo18.pr4.modelo.eventos.EventoObjetoSoltado;
import lige.grupo18.pr4.modelo.eventos.EventoObjetoUsado;
import lige.grupo18.pr4.modelo.eventos.EventoPartidaIniciada;



/** Clase UIConsola encargada de solicitar y comunicar datos al usuario.
	@author Grupo17
	@version 1.0
	@see Scanner
*/
public class UIConsola implements Observer{
	
	//Atributo Scanner para leer cadenas
	private static Scanner scanner = new Scanner(System.in);
	
	/** M�todo askCommand que solicita un comando y devuelve la cadena introducida por el usuario
		@return scanner con el comando introducido
	 */
	public static String askCommand(){
		scanner.useDelimiter("\n");
		//Mostramos el prompt (>)...
		System.out.print("\n\t>");
		//...y capturamos la cadena, y la devolvemos.
		return scanner.next().toString();
	}
	
	/** M�todo printText que recibe una cadena y la muestra por pantalla
		@param cadena String con la cadena a mostrar
	 */
	public static void printText(String cadena){
		System.out.print(cadena);
	}
	
	/** M�todo showError que recibe un error en una cadena y lo muestra por pantalla
		@param error String con el error a mostrar
	 */
	public static void showError(String error){
		System.out.print(error);
	}

	@Override
	/**
	 * Update metodo que actualiza la consola
	 * @param modelo modelo de datos
	 * @param objeto objeto que se actualiza
	 */
	public void update(Observable modelo, Object objeto) {
		Evento evento;
		evento = (Evento)objeto;
		switch(evento.getTipo()){
			case EventoPartidaIniciada:
				procesarIniciarPartida(evento);
				break;
			case EventoError:
				procesarError(evento);
				break;
			case EventoObjetoCogido:
				procesarObjetoCogido(evento);
				break;
			case EventoObjetoSoltado:
				procesarObjetoSoltado(evento);
				break;
			case EventoUsarObjeto:
				procesarObjetoUsado(evento);
				break;
			case EventoIr:
				procesarIr(evento);
				break;
			case EventoHabitacionPulsada:
				procesarHabitacionPulsada(evento);
				break;
			case EventoFinalizarPartida:
				procesarTerminar(evento);
			default:
				break;
		}
	}
	/**
	 * Metodo que se invoca cuando termina la partida y muestra las opciones del jugador
	 * @param evento evento correspondiente a esta acci�n de terminar una partida
	 */
	public void procesarTerminar(Evento evento){
		
		EventoFinalizarPartida eventoFinalizarPartida = (EventoFinalizarPartida)evento;
		
		String mensaje ="\n\nPartida terminada.";
		mensaje += "Vida: " + eventoFinalizarPartida.getVida()+ ", Puntos: " + eventoFinalizarPartida.getPuntuacion();
		
		if(eventoFinalizarPartida.getGanado())
			mensaje += " Has ganado. ";
		else
			mensaje += " Has perdido. ";
		printText(mensaje);
		
	}
	/**
	 * Metodo que se ejecuta al pulsar una habitaci�n del mapa
	 * @param eventoPulsarHabitacion evento correspondiente a esta acci�n de pulsar una habitaci�n
	 */
	public void procesarHabitacionPulsada(Evento eventoPulsarHabitacion){
		
		EventoHabitacionPulsada eventoHabitacionPulsada = (EventoHabitacionPulsada)eventoPulsarHabitacion;
		
		String mensaje = "\n\nSe ha pulsado una habitaci�n:" + eventoHabitacionPulsada.getDescripcion();
		printText(mensaje);
	}
	/**
	 * Metodo que interactua con el jugador al ir de una habitaci�n a otra
	 * @param evento evento correspondiente a esta acci�n de ir a una direcci�n
	 */
	public void procesarIr(Evento evento){
		
		EventoIr eventoIr = (EventoIr)evento;
		String mensaje = "\n\nMoviendonos hacia el " +eventoIr.getDireccion()+"\n"; 
		mensaje += eventoIr.getDescripcion();
		mensaje += "\nVida: " +	eventoIr.getVida();
		printText(mensaje);
		
	}
	/**
	 * Metodo que ejecuta cuando el jugador usa los objetos
	 * @param evento evento correspondiente a esta acci�n de usar un objeto
	 */
	public void procesarObjetoUsado(Evento evento)
	{
		EventoObjetoUsado eventoObjetoUsado= (EventoObjetoUsado) evento;
		
		String mensaje ="\n\n"+eventoObjetoUsado.getMensaje()+"\n";
		mensaje += "Vida: " + eventoObjetoUsado.getVida();
		mensaje += ", Puntuaci�n: " + eventoObjetoUsado.getPuntuacion();
		printText(mensaje);
		
		
	}
	/**
	 * Metodo que se ejecuta cuando el usuario coge un objeto
	 * @param evento evento correspondiente a esta acci�n de coger un objeto
	 */
	public void procesarObjetoCogido(Evento evento)
	{
		EventoObjetoCogido eventoObjetoCogido=(EventoObjetoCogido)evento;
		
		String mensaje = "\n\nSe ha cogido un objeto de la habitacion: \n";
		mensaje += eventoObjetoCogido.showPlayerItems();
		printText(mensaje);
		
	}
	/**
	 * Metodo que se ejecuta cuando el jugador suelta un objeto
	 * @param evento evento correspondiente a esta acci�n soltar un objeto
	 */
	public void procesarObjetoSoltado(Evento evento)
	{
		EventoObjetoSoltado eventoObjetoSoltado=(EventoObjetoSoltado)evento;
		
		String mensaje = "\n\nSe ha soltado un objeto de la habitacion: \n";
		mensaje += eventoObjetoSoltado.showPlayerItems();
		printText(mensaje);
	}
	/**
	 * metodo que pinta el tablero cuando un usuario da a empezar
	 * @param eventoInicial evento correspondiente a esta acci�n de iniciar la partida
	 */
	public void procesarIniciarPartida(Evento eventoInicial)
	{
					
		EventoPartidaIniciada eventoPartidaIniciada=(EventoPartidaIniciada)eventoInicial;
		
		String mensaje ="Se inici� la partida.\n";
		mensaje += "Vida: " + eventoPartidaIniciada.getVida();
		mensaje += ". Puntuacion: " + eventoPartidaIniciada.getPuntuacion();
		mensaje += "\n\n" + eventoPartidaIniciada.getHabitacionActual().toString();
		printText(mensaje);
		
	}
	/**
	 * Metodo que se ejecuta cuando sucede un error
	 * @param eventoError evento correspondiente a esta acci�n de error
	 */
	public void procesarError(Evento eventoError){
		
		EventoError evento=(EventoError) eventoError;
		String mensaje ="\n\nError: " + evento.getError();
		showError(mensaje);
	}
		
	
	
}
