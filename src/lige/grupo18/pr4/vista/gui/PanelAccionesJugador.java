package lige.grupo18.pr4.vista.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import lige.grupo18.pr4.Directions;
import lige.grupo18.pr4.control.Controlador;
import lige.grupo18.pr4.modelo.items.Item;


/** Clase PanelAccionesJugador que extiende la clase JSplitPanel y tiene los botones con las acciones
	@author Grupo18
	@version 1.0
	@see GridLayout
	@see ActionEvent
	@see TitledBorder
	@see ActionListener
	*/
@SuppressWarnings("serial")
public class PanelAccionesJugador extends JPanel {

	
	private JComboBox<String> _direcciones;
	private JComboBox<String> _comboIdItem;
	private PanelInformacionJugador _panelInfoJugador;
	private Controlador _controlador;
	
	/** 
	 * Método constructor por defecto de la clase GuiAcciones
	 */
	public PanelAccionesJugador(Controlador controlador, PanelInformacionJugador infoJugador){
		//Llamamos al constructor padre
		super();
		_controlador = controlador;
		_panelInfoJugador = infoJugador;
		//Inicializamos
		inicializar(infoJugador);
	}

	/**
	 * Metodo que inicializa los conmponentes
	 * @param infoJugador
	 */
	private void inicializar(PanelInformacionJugador infoJugador){
				
		//Creamos el panel que guardara las acciones
		this.setLayout(new GridLayout(3,2,2,2));
		TitledBorder titulo = BorderFactory.createTitledBorder("Acciones");
		titulo.setTitleColor(Color.blue);
		this.setBorder(titulo);
		
		//Creamos un listener para cuando pulsemos en los botones
		OyenteBotones oyente = new OyenteBotones();
		
		//Creamos los botones
		JButton botonIr=new JButton("Ir");
		botonIr.addActionListener(oyente);
		botonIr.setToolTipText("Para que te muevas en la direccion que elijas");
		
		JButton botonCoger = new JButton("Coger");
		botonCoger.addActionListener(oyente);
		botonCoger.setToolTipText("Para coger el item que elijas");
	
		JButton botonUsar = new JButton("Usar");
		botonUsar.setToolTipText("Para usar el item que elijas");
		botonUsar.addActionListener(oyente);
	
		JButton botonSoltar = new JButton("Soltar");
		botonSoltar.setToolTipText("Para soltar el item que elijas");
		botonSoltar.addActionListener(oyente);
		
		_direcciones = new JComboBox<String>();
		
		_direcciones.addItem("NORTE");
		_direcciones.addItem("SUR");
		_direcciones.addItem("ESTE");
		_direcciones.addItem("OESTE");
		
		_comboIdItem = new JComboBox<String>();
		
		//Añadimos botones y combos al panel
		this.add(botonIr);
		this.add(_direcciones);
		this.add(botonCoger);
		this.add(_comboIdItem);
		this.add(botonUsar);
		this.add(botonSoltar);	
		
	}
	/**
	 * Metodo que me carga en un componente un arrayList de items
	 * @param items lista de items
	 */
	public void cargarComboItems(ArrayList<Item> items)
	{
		_comboIdItem.removeAllItems();
		
		for (int i=0;i< items.size();i++)
		{
			_comboIdItem.addItem(items.get(i).getId());
		}
	}
	
	/** 
	 * Clase OyenteListener que implementa ActionListener 
	 * para gestionar lo que hacer cuando se pulsa un boton de accion
	*/
	class OyenteBotones implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			//Boton IR
			String accion=e.getActionCommand();
			if("Ir".equals(accion))
			{
				//JOptionPane.showMessageDialog(getParent(), "Has seleccionado Ir al "+_direcciones.getSelectedItem().toString(), "Mensaje",JOptionPane.INFORMATION_MESSAGE);
				//Miramos en que direccion
				String direccion = _direcciones.getItemAt(_direcciones.getSelectedIndex());
				Directions directions = null;
				switch(direccion){
					case "NORTE":
						directions = Directions.NORTE;
						break;
					case "SUR":
						directions = Directions.SUR;
						break;
					case "OESTE":
						directions = Directions.OESTE;
						break;
					case "ESTE":
						directions = Directions.ESTE;
						break;
				}
				_controlador.solicitarIr(directions);
			}
			//Boton Coger
			else if("Coger".equals(accion))
			{
				if(_comboIdItem.getItemCount()==0)
					JOptionPane.showMessageDialog(getParent(), "No hay ningún objeto para coger", "Mensaje",JOptionPane.WARNING_MESSAGE);
				else
					_controlador.solicitarCogerItem(_comboIdItem.getSelectedItem().toString());
					//JOptionPane.showMessageDialog(getParent(), "Has seleccionado Coger el objeto "+_comboIdItem.getSelectedItem(), "Mensaje",JOptionPane.INFORMATION_MESSAGE);
			}
			//Boton Usar
			else if("Usar".equals(accion))
			{
				if(_panelInfoJugador.getSelectedItem()==null || _panelInfoJugador.getSelectedItem().equals(""))
					JOptionPane.showMessageDialog(getParent(), "Debes seleccionar algún objeto del inventario", "Mensaje",JOptionPane.WARNING_MESSAGE);
				else
					_controlador.solicitarUsarItem(_panelInfoJugador.getSelectedItem().toString());
					//JOptionPane.showMessageDialog(getParent(), "Has seleccionado Usar el objeto "+_panelInfoJugador.getSelectedItem(), "Mensaje",JOptionPane.INFORMATION_MESSAGE);
			}
			//Boton Soltar
			else if("Soltar".equals(accion))
			{
				if(_panelInfoJugador.getSelectedItem()==null || _panelInfoJugador.getSelectedItem().equals(""))
					JOptionPane.showMessageDialog(getParent(), "Debes seleccionar algún objeto del inventario", "Mensaje",JOptionPane.WARNING_MESSAGE);
				else
					_controlador.solicitarSoltarItem(_panelInfoJugador.getSelectedItem());
					//JOptionPane.showMessageDialog(getParent(), "Has seleccionado Soltar el objeto "+_panelInfoJugador.getSelectedItem(), "Mensaje",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	}
}

