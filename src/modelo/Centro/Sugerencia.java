package modelo.Centro;

import java.util.ArrayList;

import BaseDatos.Archivo;
import defecto.Main;
import modelo.Usuarios.*;

/*Esta clase permite crear objetos de tipo sugerencia. Las sugerencias inicialmente pueden ser hechas por docentes y estudiantes, estan van dirigidas a los 
  administrativos. Tienen el usuario que las realiza y un String (mensaje) que contenga cosas que se deben mejorar del sistema*/
public class Sugerencia {
	
	static private ArrayList<Sugerencia> listaSugerencias = new ArrayList<Sugerencia>();
	
	private Usuario usuario;
	private String mensaje;

	/*Constructor de sugerencia, Contiene al usuario que la realiza y un String con el mensaje deseado. Las sugerencias se agregan automaticamente a 
	  archivo cuando son creadas*/
	public Sugerencia(Usuario usuario, String sugerencia) {
		this.usuario = usuario;
		mensaje = sugerencia;
		Sugerencia.add(this);
	}
	
	static public void add(Sugerencia s) {
		listaSugerencias.add(s);
	}
	
	//Metodo que retorna el usuario que realizo la sugerencia. No recibe ningun parametro
	public Usuario getUsuario(){
		return usuario;
	}
	
	//Metodo que retorna el String con el mensaje de la sugerencia. No recibe ningun parametro
	public String getMensaje(){
			return mensaje;
	}
	
	/*Metodo toString. Retorna un String con formato correcto que contiene el nombre y cedula del usuario que realizo la sugerencia, acompañado del mensaje
	  que este dejo*/
	public String toString() {
		return "El Usuario " + usuario.getNombre() + " con cedula " + usuario.getCedula()+ " ha hecho la siguiente sugerencia: " + mensaje;
	}
	
	static public String hacerSugerencia(Usuario usuario , String sugerencia) {
		new Sugerencia(usuario ,sugerencia);
		return "Su sugerencia fue enviada con exito.";
	}

}
