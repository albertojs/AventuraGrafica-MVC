package lige.grupo18.pr4.vista.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.*;

import lige.grupo18.pr4.control.Controlador;


/** Clase Menu que extiende la clase JMenuBar y gestiona la configuracion de la barra de menu
	@author Grupo18
	@version 1.0
	@see BufferedReader
	@see FileReader
	*/
@SuppressWarnings("serial")
public class Menu extends JMenuBar {
	
	private Controlador _controlador;
	
	/** 
	 * Método constructor por defecto de la clase GuiMenu
	 */	
	public Menu(Controlador controlador){
		//Llamamos al constructor padre
		super();
		this._controlador = controlador;
		//Inicializamos
		inicializar();
	}
	/**
	 * Metodo donde se inicializan los componentes
	 */
	private void inicializar(){
		//Creamos el menu principal
		JMenu menuOpciones = new JMenu("File");
		menuOpciones.setToolTipText("Que cosas puedes hacer");
		this.add(menuOpciones);
		
		//Creamos un submenu para las instrucciones
		JMenuItem empezar = new JMenuItem("Empezar");
		empezar.setToolTipText("Pulsa si quieres empezar el juego");
		empezar.addActionListener(new OyenteMenu());
		menuOpciones.add(empezar);
				
		//Creamos un submenu para las instrucciones
		JMenuItem instrucciones = new JMenuItem("Instrucciones");
		instrucciones.setToolTipText("Muestra una breve explicación de la funcionalidad");
		instrucciones.addActionListener(new OyenteMenu());
		menuOpciones.add(instrucciones);
		
		//Creamos un submenu para salir
		JMenuItem salir = new JMenuItem("Salir");
		salir.setToolTipText("Para salir de la aplicación");
		salir.addActionListener(new OyenteMenu());
		menuOpciones.add(salir);
	}
	
	/** 
	 * Clase OyenteMenu que implementa ActionListener 
	 * para gestionar lo que hacer cuando se pulsa en un submenu
	*/
	class OyenteMenu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if("Empezar".equals(e.getActionCommand()))
				_controlador.solicitarIniciarPartida();
			else if("Instrucciones".equals(e.getActionCommand()))
				//Si hemos pulsado en Instrucciones...
				generarMensajeInstrucciones();
			else{
				//Si hemos pulsado en salir preguntamos si queremos salir
				int salir = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
				if (salir == JOptionPane.YES_OPTION)
				     System.exit(0);
			}
		}
	}
	
	/**
	 * Método para generar las instrucciones del juego
	 */
	private void generarMensajeInstrucciones(){
		JDialog ventana=new JDialog();
		ventana.setAlwaysOnTop(true);
		ventana.setVisible(true);
		ventana.setSize(900,650);
		ventana.setLayout(new FlowLayout());
		ventana.add(new VentanaMenuHerramientas());
		ventana.setTitle("Herramientas");
		ventana.setLocation(350,150);	
	}
}

