package lige.grupo18.pr4.vista;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import lige.grupo18.pr4.control.Controlador;
import lige.grupo18.pr4.modelo.eventos.EventoError;
import lige.grupo18.pr4.modelo.eventos.EventoFinalizarPartida;
import lige.grupo18.pr4.modelo.eventos.EventoHabitacionPulsada;
import lige.grupo18.pr4.modelo.eventos.EventoIr;
import lige.grupo18.pr4.modelo.eventos.EventoObjetoCogido;
import lige.grupo18.pr4.modelo.eventos.EventoObjetoSoltado;
import lige.grupo18.pr4.modelo.eventos.EventoObjetoUsado;
import lige.grupo18.pr4.modelo.eventos.EventoPartidaIniciada;
import lige.grupo18.pr4.modelo.eventos.Evento;
import lige.grupo18.pr4.vista.gui.PanelAccionesJugador;
import lige.grupo18.pr4.vista.gui.PanelInformacionJugador;
import lige.grupo18.pr4.vista.gui.PanelMapaHabitaciones;
import lige.grupo18.pr4.vista.gui.Menu;

@SuppressWarnings("serial")
/**
 * Clase principal para la interfaz grafica de la aventura gráfica
 * @author Grupo18
 *
 */
public class Vista extends JFrame implements Observer{

	private Controlador _controlador;
	private PanelMapaHabitaciones _panelMapaHabitaciones;
	private PanelInformacionJugador _panelInfoJugador;
	private PanelAccionesJugador _panelAccionesJugador;
	private JSplitPane _panelSplitAccionesJugador;
	
	/**
	 * Constructor parametrizado
	 * @param controlador 
	 */
	public Vista(Controlador controlador){
		super("Aventura Gráfica");
		_controlador= controlador;
		inicializar();
	}
	
	/**
	 * Metodo inicializar donde se inicializan los componentes
	 */
	public void inicializar(){
		//Asignamos un contenedor de tipo BorderLayout
		setLayout(new BorderLayout());
		
		//Añadimos una barra de menu
		setJMenuBar(new Menu(_controlador));
		
		//Terminamos de configurar el JFrame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(900,650);
		this.setLocation(350,150);
		this.setResizable(false);
	}

	/**
	 * Update metodo que actualiza la vista
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
	 * @param evento evento correspondiente a esta acción de terminar una partida
	 */
	public void procesarTerminar(Evento evento){
		
		EventoFinalizarPartida eventoFinalizarPartida = (EventoFinalizarPartida)evento;
		
		if(eventoFinalizarPartida.getGanado())
			JOptionPane.showMessageDialog(this, "Has conseguido salir. Vida: " + eventoFinalizarPartida.getVida()+" Puntos: " + eventoFinalizarPartida.getPuntuacion(),"Victoria!!",JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(this, "Has perdido. Vida: " + eventoFinalizarPartida.getVida()+" Puntos: " + eventoFinalizarPartida.getPuntuacion(),"Derrota!!",JOptionPane.INFORMATION_MESSAGE);

		
		
		if(_panelInfoJugador!=null)
			_panelInfoJugador.removeAll();
		if(_panelMapaHabitaciones!=null) 
			_panelMapaHabitaciones.removeAll();
		if(_panelAccionesJugador!=null) 
			_panelAccionesJugador.removeAll();
		if(_panelSplitAccionesJugador!=null)
			_panelSplitAccionesJugador.removeAll();
		
		pack();
		setSize(900,650);
		setLocation(350,150);
	}
	/**
	 * Metodo que se ejecuta al pulsar una habitación del mapa
	 * @param eventoPulsarHabitacion evento correspondiente a esta acción de pulsar una habitación
	 */
	public void procesarHabitacionPulsada(Evento eventoPulsarHabitacion){
		
		EventoHabitacionPulsada eventoHabitacionPulsada = (EventoHabitacionPulsada)eventoPulsarHabitacion;
		_panelMapaHabitaciones.setTexto(eventoHabitacionPulsada.getDescripcion());
	}
	/**
	 * Metodo que interactua con el jugador al ir de una habitación a otra
	 * @param evento evento correspondiente a esta acción de ir a una dirección
	 */
	public void procesarIr(Evento evento){
		
		EventoIr eventoIr = (EventoIr)evento;
		
		_panelInfoJugador.setVida(eventoIr.getVida());
		_panelMapaHabitaciones.updateState(eventoIr.getHabitacion(),eventoIr.getDireccion());
		_panelAccionesJugador.cargarComboItems(eventoIr.getInventarioHabitacion());
	}
	/**
	 * Metodo que ejecuta cuando el jugador usa los objetos
	 * @param evento evento correspondiente a esta acción de usar un objeto
	 */
	public void procesarObjetoUsado(Evento evento)
	{
		EventoObjetoUsado eventoObjetoUsado= (EventoObjetoUsado) evento;
		
		_panelInfoJugador.setVida(eventoObjetoUsado.getVida());
		_panelInfoJugador.setPuntuacion(eventoObjetoUsado.getPuntuacion());
		_panelInfoJugador.cargarTablaInventario(eventoObjetoUsado.getInventario());
		
		JOptionPane.showMessageDialog(this,eventoObjetoUsado.getMensaje(),"Mensaje",JOptionPane.INFORMATION_MESSAGE);
	}
	/**
	 * Metodo que se ejecuta cuando el usuario coge un objeto
	 * @param evento evento correspondiente a esta acción de coger un objeto
	 */
	public void procesarObjetoCogido(Evento evento)
	{
		EventoObjetoCogido eventoObjetoCogido=(EventoObjetoCogido)evento;
		
		_panelMapaHabitaciones.setTexto(eventoObjetoCogido.getDescripcionHabitacion());
		_panelAccionesJugador.cargarComboItems(eventoObjetoCogido.getItems());
		_panelInfoJugador.cargarTablaInventario(eventoObjetoCogido.getInventarioJugador());
	}
	/**
	 * Metodo que se ejecuta cuando el jugador suelta un objeto
	 * @param evento evento correspondiente a esta acción soltar un objeto
	 */
	public void procesarObjetoSoltado(Evento evento)
	{
		EventoObjetoSoltado eventoObjetoSoltado=(EventoObjetoSoltado)evento;
		
		_panelMapaHabitaciones.setTexto(eventoObjetoSoltado.getDescripcionHabitacion());
		_panelAccionesJugador.cargarComboItems(eventoObjetoSoltado.getItems());
		_panelInfoJugador.cargarTablaInventario(eventoObjetoSoltado.getInventarioJugador());
	}
	/**
	 * metodo que pinta el tablero cuando un usuario da a empezar
	 * @param eventoInicial evento correspondiente a esta acción de iniciar la partida
	 */
	public void procesarIniciarPartida(Evento eventoInicial)
	{
		pack();
		setSize(900,650);
		setLocation(350,150);
		
		EventoPartidaIniciada eventoPartidaIniciada=(EventoPartidaIniciada)eventoInicial;

		//Creamos un JSplitPanel y lo configuramos
		_panelSplitAccionesJugador = new JSplitPane();
		_panelSplitAccionesJugador.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		_panelSplitAccionesJugador.setResizeWeight(0.5);
		_panelSplitAccionesJugador.setVisible(true);
		_panelSplitAccionesJugador.setSize(10,30);
		_panelSplitAccionesJugador.setDividerLocation(280);
				
		//Añadimos las acciones a la izquierda y la información del jugador a la derecha
		_panelInfoJugador = new PanelInformacionJugador();
		_panelInfoJugador.setVida(eventoPartidaIniciada.getVida());
		_panelInfoJugador.setPuntuacion(eventoPartidaIniciada.getPuntuacion());
		
		_panelAccionesJugador=new PanelAccionesJugador(_controlador,_panelInfoJugador);
		_panelSplitAccionesJugador.setLeftComponent(_panelAccionesJugador);
		_panelSplitAccionesJugador.setRightComponent(_panelInfoJugador);
				
		_panelAccionesJugador.cargarComboItems(eventoPartidaIniciada.getItems());
		//Añadimos el JSplitPane
		add(_panelSplitAccionesJugador,BorderLayout.NORTH);
				
		//Y añadimos otro panel para el mapa
		_panelMapaHabitaciones = new PanelMapaHabitaciones(_controlador,eventoPartidaIniciada.getHabitacionActual());
		add(_panelMapaHabitaciones,BorderLayout.CENTER);
		setVisible(true);
		

	}
	/**
	 * Metodo que se ejecuta cuando sucede un error
	 * @param eventoError evento correspondiente a esta acción de error
	 */
	public void procesarError(Evento eventoError){
		EventoError evento=(EventoError) eventoError;
		
		JOptionPane.showMessageDialog(getParent(), evento.getError(), "Mensaje",JOptionPane.WARNING_MESSAGE);
	}
}
