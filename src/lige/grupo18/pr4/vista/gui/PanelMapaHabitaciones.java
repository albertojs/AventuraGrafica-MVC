package lige.grupo18.pr4.vista.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import lige.grupo18.pr4.Directions;
import lige.grupo18.pr4.control.Controlador;
import lige.grupo18.pr4.modelo.Room;
import lige.grupo18.pr4.vista.BotonMapa;

/** Clase PanelMapaHabitaciones que extiende la clase JPanel y guarda el mapa con las habitaciones
	@author Grupo18
	@version 1.0
	@see ActionEvent
	@see TitledBorder
	@see ActionListener
	*/
@SuppressWarnings("serial")
public class PanelMapaHabitaciones extends JPanel {
	
	private JTextArea _areaDescripcion;
	private Controlador _controlador;
	private Room _habitacionActual;
	private int _x;
	private int _y;
	private BotonMapa[][] _tablaBotones;
	
	/** Método constructor por defecto de la clase GuiMapa
	 */
	public PanelMapaHabitaciones(Controlador controlador, Room habitacionActual){
		super();
		_controlador = controlador;
		_habitacionActual = habitacionActual;
		_x = 5;
		_y = 5;
		_tablaBotones = new BotonMapa[11][11];
		//Inicializamos
		inicializar();			
	}

	/**
	 * Método para generar el panel con los botones las habitaciones
	 */
	private void inicializar(){
		//Asignamos un contenedor de tipo BorderLayout
		this.setLayout(new BorderLayout());
		//Creamos un panel para los botones de las habitaciones
		JPanel panelBotonesHabitaciones = new JPanel();
		panelBotonesHabitaciones.setLayout(new GridLayout(11,11,1,1));
		TitledBorder titulo = BorderFactory.createTitledBorder("Acciones");
		titulo.setTitleColor(Color.blue);
		panelBotonesHabitaciones.setBorder(titulo);
		//Creamos un listener que sera el encargado de gestionar cuando se pulsa un boton
		OyenteMapa oyenteListener = new OyenteMapa();

		Dimension dimension = new Dimension(40,20);
		//Creamos los botones
		for(int i = 0; i < 11; i++)
			for(int j = 0; j < 11; j++){
				if((i==5)&&(j==5)){
					_tablaBotones[i][j] = new BotonMapa(i,j,true,true,_habitacionActual);
					_tablaBotones[i][j].setBackground(Color.green);
					_tablaBotones[i][j].setText(_habitacionActual.getNombre());
				}
				else
				{
					_tablaBotones[i][j] = new BotonMapa(i,j,false,false,null);
				}
				_tablaBotones[i][j].setPreferredSize(dimension);
				_tablaBotones[i][j].addActionListener(oyenteListener);
				_tablaBotones[i][j].setToolTipText("Habitacion");
				panelBotonesHabitaciones.add(_tablaBotones[i][j]);
			}
		panelBotonesHabitaciones.setVisible(true);
		this.add(panelBotonesHabitaciones,BorderLayout.NORTH);
		
		//Creamos un panel que contendra el area donde se guarda la info de cada habitacion
		JPanel panelHabitaciones = new JPanel();
		panelHabitaciones.setLayout(new BorderLayout());
		
		titulo = BorderFactory.createTitledBorder("Habitación");
		titulo.setTitleColor(Color.blue);
		panelHabitaciones.setBorder(titulo);
		
		//Area que muestra la información de cada habitacion
		_areaDescripcion = new JTextArea(50,100);
		_areaDescripcion.setEditable(false);
		_areaDescripcion.setToolTipText("Objetos de la habitacion actual");
		_areaDescripcion.setText(_habitacionActual.toString());
		JScrollPane scrollPane = new JScrollPane(_areaDescripcion); 
		panelHabitaciones.add(scrollPane);
		
		this.add(panelHabitaciones,BorderLayout.CENTER);
	}
	
	/** Clase OyenteListener que implementa ActionListener 
	 * para gestionar lo que hacer cuando se pulsa en una habitacion
	*/
	class OyenteMapa implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() instanceof BotonMapa){
				_areaDescripcion.setText("");
				BotonMapa boton = (BotonMapa)e.getSource();
				if(boton.getVisitada())
					_controlador.solicitarPulsarBotonHabitacion(boton.getRoom());
			}
		}
	}
	
	public void setTexto(String habitacion){
		_areaDescripcion.setText(habitacion);
	}
	/**
	 * Metodo que actualida el estado de donde se encuentra el jugador(boton)
	 * @param habitacion
	 * @param direccion
	 */
	public void updateState(Room habitacion, Directions direccion){
		
		int xNuevo = _x;
		int yNuevo = _y;
		
		//Miramos a la direccion que marca y sumamos dependiendo a la direccion a la que vaya
		switch(direccion.toString()){
		case "NORTE":
			xNuevo--;
			break;
		case "SUR":
			xNuevo++;
			break;
		case "ESTE":
			yNuevo++;
			break;
		case "OESTE":
			yNuevo--;
			break;
		}
		
		//Modificamos la habitacion en la direccion a la que vamos
		_tablaBotones[xNuevo][yNuevo].setVisitada(true);
		_tablaBotones[xNuevo][yNuevo].setActiva(true);
		_tablaBotones[xNuevo][yNuevo].setText(habitacion.getNombre());
		_tablaBotones[xNuevo][yNuevo].setBackground(Color.green);
		_tablaBotones[xNuevo][yNuevo].setHabitacion(habitacion);
		
		//Establecemos las propiedades en la habitacion q estabamos
		_tablaBotones[_x][_y].setBackground(Color.gray);
		_tablaBotones[_x][_y].setActiva(false);
		
		//Actualizamos las variables con el nuevo destino
		_x = xNuevo;
		_y = yNuevo;
		
		//Metemos la descripcion de la nueva direccion al panel
		_areaDescripcion.setText(habitacion.toString());
		
		this.repaint();
	}
	
}

