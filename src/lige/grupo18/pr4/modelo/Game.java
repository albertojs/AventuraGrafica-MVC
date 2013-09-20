package lige.grupo18.pr4.modelo;

import java.util.ArrayList;
import java.util.Observable;

import lige.grupo18.pr4.Directions;
import lige.grupo18.pr4.VerbCommands;
import lige.grupo18.pr4.modelo.jugador.*;
import lige.grupo18.pr4.modelo.commands.Command;
import lige.grupo18.pr4.modelo.eventos.*;
import lige.grupo18.pr4.modelo.items.Comida;
import lige.grupo18.pr4.modelo.items.Item;
import lige.grupo18.pr4.modelo.items.Llave;
import lige.grupo18.pr4.modelo.items.ObjetoValor;

/**
 * Clase que se encarga de la ejecución del juego. Contiene el mapa 
 * de puertas y la habitación en la que se encuentra actualmente 
 * el usuario
 * @version 2.0
 * @author grupo18
 * @see VerbCommands
 * 
 */ 
public class Game extends Observable{

	//Atributos de Game
	private Map _mapa;
	private Room _habitacionActual;
	private Player _jugador;
	
	/**
	 *  Constructor por defecto de Game
	 */
	public Game()
	{
		_mapa=new Map();
		_habitacionActual= new Room();
		_jugador=new Player();
	}
	/**
	 * Constructor con parámetros de Game
	 * @param mapa Parámetro que contiene el mapa de puertas del juego
	 * @param hab Parámetro que contiene la habitación actual en la que se encuentra el usuario
	 */
	public Game(Map mapa,Room hab)
	{
		this._mapa=mapa;
		this._habitacionActual=hab;
		_jugador=new Player();
	}
	
	/**
	 * Metodo que devuelve la habitacion en la que estamos.
	 * @return Habitacion
	 */
	public Room getHabitacionActual(){
		return _habitacionActual;
	}
	
	/**
	 * Metodo que devuelve el mapa del juego
	 * @return Mapa
	 */
	public Map getMapa(){
		return _mapa;
	}
	
	/**
	 * Metodo que devuelve el jugador que esta interactuando en el juego
	 * @return Jugador
	 */
	public Player getJugador(){
		return _jugador;
	}
	
	/**
	 * Metodo que cambia la habitacion actual
	 * @param habitacion habitacion que deseamos que sea la nueva habitacion actual
	 */
	public void setHabitacionActual(Room habitacion){
		_habitacionActual = habitacion;
		_jugador.decreaseLife(5);
	}
	
	public void setMapa(Map mapa)
	{
		_mapa=mapa;
	}
	/**
	 * Metodo que me devuelve la puerta que hay en esa direccion
	 * @param direccion direccion en la que apuntaria la puerta
	 * @return Puerta
	 */
	public Door findDoor(Directions direccion)
	{
		return _mapa.findDoor(_habitacionActual, direccion);
	}
	
	/**
	 * Metodo que me devuelve el item de la habitacion
	 * @param id identificador del item
	 * @return Item
	 */
	public Item findRoomItem(String id)
	{
		return _habitacionActual.findItem(id);
	}
	
	/**
	 * Metodo que me va a añadir un item al jugador
	 * @param objeto item que se va a añadir a la lista de objetos del jugador
	 * @return true o false dependiendo si se ha añadido
	 */
	public boolean addItemToPlayer(Item objeto)
	{
		 return _jugador.addItem(objeto);
	}
	
	/**
	 * Metodo que quita un item de la habitacion actual
	 * @param id identificador del item a quitar
	 * @return true o false dependiendo si se ha quitado  
	 */
	public boolean removeRoomItem(String id)
	{
		return _habitacionActual.removeItem(id);
	}
	
	/**
	 * Obtiene la descripcion de la habitacion actual y sus objetos
	 * @return descripcion
	 */
	public String getRoomDescription()
	{
		return _habitacionActual.toString();
	}
	
	/**
	 * Muestra los items de la habitacion
	 * @return cadena con los items
	 */
	public String showRoomItems()
	{
		return _habitacionActual.showItems();
	}
	/**
	 * Muestra la informacion del jugador
	 * @return informacion del jugador
	 */
	public String showPlayer()
	{
		return _jugador.showInfo();
	}
	
	/**
	 * Devuelve la siguiente habitacion que hay a una puerta
	 * @param puerta puerta que vamos a pasar
	 * @return Habitacion
	 */
	public Room nextRoom(Door puerta)
	{
		return puerta.nextRoom(_habitacionActual);
	}
	
	/**
	 * Mira si el jugador tiene ese identificador en su lista de items
	 * @param id identificador a buscar
	 * @return Item
	 */
	public Item findPlayerItem(String id)
	{
		return _jugador.findItem(id);
	}
	
	/**
	 * Quita el item de la lista de items del jugador
	 * @param id identificador a quitar
	 * @return Devuelve true si se ha realizado con exito
	 */
	public boolean removePlayerItem(String id)
	{
		return _jugador.removeItem(id);
	}
	
	/**
	 * Añade item a la habitacion
	 * @param objeto item a añadir
	 * @return Devuelve true si se ha añadido con exito
	 */
	public boolean addItemToRoom(Item objeto)
	{
		 return _habitacionActual.addItem(objeto);
	}
	
	/**
	 * Método que se encarga de crear un vector de habitaciones
	 * @return Devuelve el vector de habitaciones creado
	 */
	public static Room[] createRooms()
	{

		//Creo los Inventarios de objetos que iran colocados dentro de cada habitación
		Inventario invent=new Inventario();
		
		//Creo el vector de habitaciones
		Room[] vectorHabitaciones=null;
		//Prueba 1: 4 Habitaciones y una salida
		/*vectorHabitaciones= new Room[4];
		vectorHabitaciones[0]=new Room("Estas en la habitación de tu amigo y van a llegar sus padres, \nsabes que no les va a hacer gracia que estrellarais su coche ayer,\nlo mejor es que salgas rapido de casa.",false,invent1);
		vectorHabitaciones[1]=new Room("Estas situado en el pasillo de la casa.",false,invent2);
		vectorHabitaciones[2]=new Room("Estas situado en el hall de la casa.",false,invent3);
		vectorHabitaciones[3]=new Room("Estas situado en las escaleras del portal de la casa,\nya puedes irte, al menos hoy no te llevaras la bronca de sus padres\npero no podrás escaparte eternamente.",true,invent4);*/
		
		
		//Prueba 2: 10 habitaciones y 3 salidas
		vectorHabitaciones= new Room[10];
		vectorHabitaciones[0]=new Room("Anfiteatro","Estas en el segundo anfiteatro del Santiago Bernabeu,\nnecesitas encontrar una salida ya sea la puerta de entrada al estadio,\na través del museo de trofeos o la salida a través del restaurante",false,invent);
		vectorHabitaciones[1]=new Room("Baños","Has entrado a los baños, creo que por aqui no saldrás nunca",false,invent);
		vectorHabitaciones[2]=new Room("Restaurante","Has entrado al restaurante del estadio, la salida a la calle no debe andar lejos",false,invent);
		vectorHabitaciones[3]=new Room("Calle","Has salido a la calle por el restaurante, perfecto!",true,invent);
		vectorHabitaciones[4]=new Room("Vestuario","Has entrado a los vesturarios del Real Madrid, un lugar bonito pero por aqui no saldrás a la calle...",false,invent);
		vectorHabitaciones[5]=new Room("Calle","Has salido a la Castellana, perfecto!",true,invent);
		vectorHabitaciones[6]=new Room("Sala Trofeos","Has entrado a la sala de trofeos, la salida no deber andar lejos",false,invent);
		vectorHabitaciones[7]=new Room("Calle","Ya estas en la calle, perfecto!",true,invent);
		vectorHabitaciones[8]=new Room("Pasillo","Has entrado a uno de los pasillos dentro del estadio",false,invent);
		vectorHabitaciones[9]=new Room("Vestuario","Estas en el vestuario visitante,hoy jugó el Barsa así que no creo que seas muy bien recibido...",false,invent);
		
		return vectorHabitaciones;
		
	}
	/**
	 * Método que se encarga de añadir añade las puertas del juego en el mapa
	 * @param m Mapa en el que se van a añadir las puertas
	 * @param r Vector de habitaciones donde se insertan las conexiones de las puertas
	 */
	public static void insertDoors(Map m , Room[] r)
	{
		//Creo el vector de puertas donde voy a insertar las habitaciones
		
		//Prueba 1: 3 puertas
		/*ArrayList<Door>vectorPuertas= new  ArrayList<Door>();
		vectorPuertas.add(new Door(r[0],Directions.ESTE,r[1],false));
		vectorPuertas.add(new Door(r[1],Directions.SUR,r[2],false));
		vectorPuertas.add(new Door(r[2],Directions.OESTE,r[3],true));
		insertItems(vectorPuertas,r);*/
		
		
		//Prueba 2: 9 puertas
		ArrayList<Door>vectorPuertas= new  ArrayList<Door>();
		vectorPuertas.add(new Door(r[0],Directions.SUR,r[5],true));
		vectorPuertas.add(new Door(r[0],Directions.NORTE,r[8],false));
		vectorPuertas.add(new Door(r[8],Directions.ESTE,r[4],false));
		vectorPuertas.add(new Door(r[8],Directions.OESTE,r[9],false));
		vectorPuertas.add(new Door(r[8],Directions.NORTE,r[6],true));
		vectorPuertas.add(new Door(r[6],Directions.ESTE,r[7],true));
		vectorPuertas.add(new Door(r[6],Directions.NORTE,r[1],true));
		vectorPuertas.add(new Door(r[6],Directions.OESTE,r[2],false));
		vectorPuertas.add(new Door(r[2],Directions.OESTE,r[3],true));
		insertItems(vectorPuertas,r);
		
		
		m.setDoors(vectorPuertas);
	}
	/**
	 * Método que se encarga de insertar los items en las habitaciones
	 * @param vectorPuertas Vector de las puertas
	 * @param r Vector de habitaciones
	 */
	public static void insertItems(ArrayList<Door>vectorPuertas,Room[] r)
	{
	

		Inventario invent1=new Inventario();
		Inventario invent2=new Inventario();
		Inventario invent3=new Inventario();
		Inventario invent4=new Inventario();
		Inventario invent5=new Inventario();
		Inventario invent6=new Inventario();
		//Inventario invent7=new Inventario();
		//Inventario invent8=new Inventario();
		//Inventario invent9=new Inventario();
		
		//PRUEBA1
		/*Comida com=new Comida("Caramelo","Has encontrado un caramelo que te dara 10 puntos de energía",10,1);
		Comida com2=new Comida("Agua","Botella de agua que te dara 5 puntos de energía durante varios tragos",5,5);
		Llave llave=new Llave("key1","Llave que abre la puerta de la habitación de tu amigo",vectorPuertas.get(0));
		invent1.addItem(com);
		invent1.addItem(com2);
		invent1.addItem(llave);
		
		ObjetoValor valor=new ObjetoValor("Medalla","Medalla de oro que te dara 150 puntos",150);
		Llave llave2=new Llave("key2","Llave que abre la puerta del pasillo ",vectorPuertas.get(1));
		invent2.addItem(valor);
		invent2.addItem(llave2);
		
		r[0].setObjetos(invent1);
		r[1].setObjetos(invent2);*/
		
		
		//PRUEBA2
		Comida com=new Comida("Caramelo","Has encontrado un caramelo que te dara 10 puntos de energía",10,1);
		Comida com2=new Comida("Agua","Botella de agua que te dara 5 puntos de energía durante varios tragos",5,5);
		Llave llave=new Llave("key1","Llave que abre la puerta hacia un pasillo del Bernabeu al norte",vectorPuertas.get(1));
		invent1.addItem(com);
		invent1.addItem(com2);
		invent1.addItem(llave);
		
		ObjetoValor valor=new ObjetoValor("billete","A alguién se le ha caido un billete, te dará 200 puntos",200);
		Llave llave2=new Llave("key2","Llave que abre los vesturarios locales",vectorPuertas.get(2));
		Llave llave3=new Llave("key3","Llave que abre los vestuarios visitantes",vectorPuertas.get(3));
		invent2.addItem(valor);
		invent2.addItem(llave2);
		invent2.addItem(llave3);
		
		ObjetoValor valor2=new ObjetoValor("camiseta","Camiseta de CR7,seguro que esto vale al menos 1000 puntos",1000);
		invent3.addItem(valor2);
		
		ObjetoValor valor3=new ObjetoValor("botas","Botas de Messi,seguro que esto vale al menos 750 puntos",750);
		invent4.addItem(valor3);
		
		Llave llave4=new Llave("key4","Llave que abre la puerta al restaurante",vectorPuertas.get(7));
		ObjetoValor valor4=new ObjetoValor("trofeo","Trofeo de la champions del 2000,seguro que esto vale al menos 1500 puntos",1500);
		invent5.addItem(llave4);
		invent5.addItem(valor4);
		
		Comida com3=new Comida("sandwich","Has encontrado un sandwich que no tiene demasiada buena pinta",-15,1);
		invent6.addItem(com3);
		
		
		r[0].setObjetos(invent1);
		r[8].setObjetos(invent2);
		r[4].setObjetos(invent3);
		r[9].setObjetos(invent4);
		r[6].setObjetos(invent5);
		r[1].setObjetos(invent6);
	}
	/**
	 * Metodo que devuelve el intentario del jugador
	 * @return inventario
	 */
	public Inventario getInventarioJugador()
	{
		return _jugador.getInventario();
	}
	/**
	 * Metodo que devuelve la vida del jugador
	 * @return vida
	 */
	public int getVidaJugador()
	{
		return _jugador.getVida();
	}
	/**
	 * Metodo que devuelve la puntuacion
	 * @return puntuacion
	 */
	public int getPuntuacionJugador()
	{
		return _jugador.getPuntuacion();
	}
	/** Método que nos dice si la habitacion es salida o no
	 * @return True si la habitacion con la que llamamos es salida. False en caso contrario
	 */
	public boolean esSalidaHabitacion(){
		return _habitacionActual.getSalida();
	}
	/**
	 * Metodo que inicia la partida
	 */
	public void iniciarPartida()
	{
		//Creo habitaciones
		Room[] vectorHabitaciones = createRooms();
		Map mapa = new Map();
		//Creo puertas e inserto habitaciones para formar el mapa
		insertDoors(mapa, vectorHabitaciones);
		
		this.setMapa(mapa);
		this.setHabitacionActual(vectorHabitaciones[0]);
		_jugador=new Player();
		
		
		EventoPartidaIniciada evento=new EventoPartidaIniciada(_jugador.getVida(),_jugador.getPuntuacion(),_habitacionActual,_jugador.getInventario());
		this.setChanged();
		this.notifyObservers(evento);
	}
	/**
	 * Metodo que ejecuta el comando y se lo notifica al observer
	 * @param comando
	 */
	public void accionUsuario(Command comando)
	{
		Evento evento = comando.execute();
		this.setChanged();
		this.notifyObservers(evento);
	}
	/**
	 * Metodo que crea el evento y se lo notifica al observer
	 * @param habitacion
	 */
	public void pulsaHabitacion(Room habitacion){
		this.setChanged();
		this.notifyObservers(new EventoHabitacionPulsada(habitacion));
	}
	
}
