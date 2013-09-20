package lige.grupo18.pr4.vista.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import lige.grupo18.pr4.modelo.Inventario;
import lige.grupo18.pr4.modelo.items.Item;

/** Clase PanelInformacionJugador que extiende la clase JPanel y guarda la información de un jugador.
	@author Grupo18
	@version 1.0
	@see BorderLayout
	@see FlowLayout
	@see TitledBorder
	*/
@SuppressWarnings("serial")
public class PanelInformacionJugador extends JPanel {

	//Tabla que guarda los items del jugador
	private JTable _tabla;
	private TablaInventario _tablaInv;
	
	private JLabel _lblVida;
	private JLabel _lblPuntuacion;
	
	/** Método constructor por defecto de la clase GuiInfoJugador
	 */
	public PanelInformacionJugador(){
		//Llamamos al constructor padre
		super();
		//Inicializamos
		inicializar();
	}
	
	/**
	 * Metodo que inicializa los componentes
	 */
	private void inicializar(){
		//Asignamos un contenedor de tipo BorderLayout
		this.setLayout(new BorderLayout());
		TitledBorder titulo = BorderFactory.createTitledBorder("Información del jugador");
		titulo.setTitleColor(Color.blue);
		this.setBorder(titulo);
		
		JPanel panel = new JPanel(new FlowLayout(1,10,0));
		
		//Creamos un label con la informacion del jugador. Se ira actualizando con la partida.
		JLabel lbl1 = new JLabel("Vida:");
		_lblVida= new JLabel();
		JLabel lbl2 = new JLabel("Puntuación:");
		_lblPuntuacion = new JLabel();
		
		//Le doy algunas propiedades
		_lblVida.setForeground(Color.orange);
		_lblPuntuacion.setForeground(Color.orange);
		
		_tablaInv = new TablaInventario();
		
		//inicializarTabla();
		_tabla = new JTable(_tablaInv);
		
		_tabla.setGridColor(Color.WHITE);
		_tabla.setSelectionForeground(Color.WHITE);
		_tabla.setPreferredScrollableViewportSize(new Dimension(500, 400));
		_tabla.setColumnSelectionAllowed(false);
		
		panel.add(lbl1);
		panel.add(_lblVida);
		panel.add(lbl2);
		panel.add(_lblPuntuacion);
		
		this.add(panel,BorderLayout.NORTH);
		
		
		JScrollPane scroll = new JScrollPane(_tabla);
		scroll.setPreferredSize(_tabla.getSize());
		this.add(scroll,BorderLayout.CENTER);
	}
	
	/** Metodo getItem que devuelve el identificador de la fila que este seleccionada
	 * @return String con el identificador.
	*/
	public String getSelectedItem()
	{
		//Si no ha elemento seleccionado en la tabla devolvemos null
		if(_tabla.getSelectedRow()==-1)
			return null;
		else
			return _tablaInv.getValueAt(this._tabla.getSelectedRow(),0);
			
	}
	
	/**
	 * Meotodo que estable la vida del jugador
	 * @param vida vida
	 */
	public void setVida(int vida)
	{
		_lblVida.setText(""+vida);
	}
	/**
	 * Metodo que establece la puntuación
	 * @param puntuacion puntuación
	 */
	public void setPuntuacion(int puntuacion)
	{
		_lblPuntuacion.setText(""+puntuacion);	
	}
	
	/**
	 * Metodo para cargar el inventario del jugador en la tabla
	 * @param inventario inventario del jugador
	 */
	public void cargarTablaInventario(Inventario inventario)
	{
		_tablaInv.removeAll();		
		_tablaInv.inicializa(inventario);
		_tablaInv.fireTableDataChanged();
		_tabla.repaint();
		
	}
	
	/**
	 * Clase que hereda de abstractTableModel, la cual contiene el inventario en
	 * la Tabla
	 * @author grupo18
	 *
	 */
	private class TablaInventario extends AbstractTableModel{
		/**
		 * Serialization version number
		 */
		private static final long serialVersionUID = 1L;

		//COLUMNAS Y ELEMENTOS DEL JUGADOR
		final String[] _columnNames = { "Identificador", "Descripción" };
		final ArrayList<Item> _dato = new ArrayList<Item>();
		
		/**
		 * Constructor por defecto de la clase
		 */
		public TablaInventario(){
			super();
		}
		
		/**
		 * Metodo que inicializa/actualiza la tabla
		 * @param inventario 
		 */
		public void inicializa(Inventario inventario){

			int longitud = inventario.getSize();
			for(int i=0;i<longitud;i++){
				_dato.add(inventario.getItem(i));
			}
		}
		
		/**
		 * Devuelve el numero de columnas del modelo
		 */
		public int getColumnCount() {
			return _columnNames.length;
		}
		
		/**
		 * Devuelve el numero de filas
		 */
		public int getRowCount() {
			return _dato.size();
		}

		/**
		 * Devuelve el nombre de la columna dada
		 */
		public String getColumnName(int col) {
			return _columnNames[col];
		}

		/**
		 * Devuelve el valor en la fila y columna dadas
		 * @return String devuelve el String correspondiente del id o descripcion
		 */
		public String getValueAt(int row,int col) {
			String valor = "";
		
			if (row > -1){ 
				if (col == 0) {
					valor = _dato.get(row).getId();
				} else if (col == 1) {
					valor = _dato.get(row).getDescripcion();
				}
			}

			return valor;
		}
		
		/**
		 * Elimina toda la tabla eliminandolos del arrayList
		 */
		public void removeAll() {
			//_dato.removeAllElements();
			_dato.removeAll(_dato);
		}

		/**
		 * Añade un elemento a la tabla
		 * @param value
		 * @param index
		 */
		@SuppressWarnings("unused")
		public void setValueAt(Item value, int index) {

			_dato.add(index, value);
		}
		
		
	}
	
	
}
