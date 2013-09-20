package lige.grupo18.pr4.modelo;

import lige.grupo18.pr4.Directions;

/**
 * Clase que define una puerta que conecta entre dos habitaciones
 * @author grupo18
 * @version 1.0
 */
public class Door {
	
	//Atributos de Door
	private Room _habitacionOrigen;
	private Directions _posicion;
	private Room _habitacionDestino;
	private boolean _abierta;
	
	/**
	 * Constructor por defecto de la clase Door
	 */
	Door(){
		_habitacionOrigen= new Room();
		_posicion=Directions.NONE;
		_habitacionDestino=new Room();
		_abierta=false;
	}
	
	/**
	 * Constructor con parametros de la clase Door
	 * @param origen Recibe la habitacion origen de la puerta
	 * @param destino Recibe la habitaci�n destino de la puerta
	 * @param pos Posici�n de la puerta respecto de la habitaci�n origen
	 */
	public Door(Room origen, Directions pos, Room destino, boolean abierta){
		_habitacionOrigen = origen;		
		_posicion = pos;
		_habitacionDestino = destino;
		_abierta = abierta;
	}
	/**
	 * M�todo que devuelve por string toda la informaci�n de una puerta
	 * @return Devuelve un string con los datos de la puerta
	 */
	public String toString()
	{
		String estado = "Cerrada";
		if(this._abierta)
				estado = "Abierta";
		String puerta= "Habitaci�n de origen: "+this._habitacionOrigen.getDescripcion()+"\nPosici�n de la puerta: "+this._posicion+"\nHabitaci�n  de destino: "+this._habitacionDestino.getDescripcion()+"\nEstado de la puerta: "+estado;
		return puerta;
	}
	
	/**
	 *  M�todo que comprueba si la puerta pertenece a la habitaci�n pasada por par�metro
	 * @param habitacion Habitacion a comprobar
	 * @param direccion Direcci�n a comprobar
	 * @return true si la puerta pertenece a la habitaci�n false en caso de que no
	 */
	public boolean isInRoom(Room habitacion, Directions direccion){
		
		boolean esta=false;
		
		//Comprobamos que coincida con la habitaci�n origen
		if(habitacion == this._habitacionOrigen && direccion == this._posicion ){
			esta = true;
		}//Sino probamos que coincida con la habitacion destino cambiando la direcci�n
		else if(habitacion == this._habitacionDestino && direccion == this._posicion.opposite()){			
			esta = true;
		}
		return esta;
	}	

	/**
	 * M�todo que devuelve la siguiente habitaci�n con la que
		comunica la puerta si es que la puerta se encuentra en la habitaci�n pasada como
		par�metro.
	 * @param habitacion Habitaci�n a comprobar
	 * @return Devuelve la habitaci�n siguiente con la que conecta la puerta o null si la puerta 
	 * no pertenece a la habitacion pasada por parametro 
	 */
	public Room nextRoom (Room habitacion){
		//Si la habitaci�n coincide con la de origen de la puerta devolvemos la habitaci�n destino
		if(habitacion == this._habitacionOrigen)
			return this._habitacionDestino;
		else if(habitacion == this._habitacionDestino)
			//Si la habitaci�n coincide con la de destino de la puerta devolvemos la habitaci�n origen
			return this._habitacionOrigen;
		else
			//Sino se encuentra devolvemos null
			return null;
		
	}
	/**
	 * M�todo que indica si la puerta esta abierta o cerrada
	 * @return Devuelve un booleano indicandolo
	 */
	public boolean isOpen()
	{
		return _abierta;
	}
	
	/**
	 * M�todo que abre y cierra la puerta
	 */
	public void abrirCerrarPuerta()
	{
		if(_abierta)
			_abierta=false;
		else
			_abierta=true;	
	}
	/**
	 * M�todo que indica si la habitaci�n pasada por parametro es alguna de las habitaciones que comunican la puerta
	 * @param habitacion Habitacion a comprobar
	 * @return Devuelve booleano
	 */
	public Boolean isInRoom(Room habitacion)
	{
		if(habitacion.equals(_habitacionOrigen) || habitacion.equals(_habitacionDestino))
			return true;
		else 
			return false;
		
	}

	/**
	 * M�todo main que prueba el funcionamiento de la clase
	 * @param args Array de argumentos de main
	 */
	/*public static void main(String[] args){
		
		Room habA=new Room("Esta es la primera habitaci�n",false);
		Room habB=new Room("Esta es la segunda habitaci�n",true);
		
		Door puertaA = new Door(habA,Directions.ESTE,habB);
		
		//Pruebo el funcionamiento de la clase con la puertaA
		System.out.println(puertaA.toString());
		
		//Caso que se ha de cumplir
		System.out.println(puertaA.isInRoom(habA,Directions.ESTE));
		
		Room hab =new Room();
		//caso que no se ha de cumplir
		System.out.println(puertaA.isInRoom(hab,Directions.ESTE));
		
		
		//caso que se ha de cumplir
		System.out.println(puertaA.isInRoom(habB,Directions.OESTE));
		
	
		
		//Pruebo e funcionamiento de la clase y sus metodos con la puertaB
		Room habC=new Room("Esta es la primera habitaci�n",false);
		Room habD=new Room("Esta es la segunda habitaci�n",true);
		
		Door puertaB=new Door(habC,Directions.SUR,habD);
		//Deber�a imprimir null
		System.out.println(puertaB.nextRoom(habA));
		//Deberia imprimir D 
		System.out.println(puertaB.nextRoom(habC));
		
		
	}*/
	
}
