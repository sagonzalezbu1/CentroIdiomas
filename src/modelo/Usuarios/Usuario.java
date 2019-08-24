package modelo.Usuarios;
import java.util.*;
import control.*;

/*Esta clase permite la recopilaci�n de atributos y m�todos comunes para sus clases hijas.
 * Es abstracta ya que no se debe ni puede crear una instancia directa de tipo Usuario, 
 * sino instancias de sus subclases*/
public abstract class Usuario {
	private String nombre;
	private long cedula;
	private String correo;
	private String contrasena;
	private ArrayList<String> Procesos = new ArrayList<String>();

	/*Constructor que inicializa los atributos con valores entregados por el usuario,
	 * que son nombre, c�dula, correo y contrase�a*/
	public Usuario(String name, long id, String email, String password) {
		nombre = name;
		cedula = id;
		correo = email;
		contrasena = password;
	}

	/*Getter del nombre, retorna un String correspondiente al nombre del usuario.
	* No recibe par�metros*/
	public String getNombre() {
		return nombre;
	}
	
	/*Getter de la cedula, retorna un long correspondiente a la cedula del usuario.
	* No recibe par�metros*/
	public long getCedula() {
		return cedula;
	}
	
	/*Getter de la contrase�a, retorna un String correspondiente a la contrase�a del usuario.
	* No recibe par�metros*/
	public String getContrasena() {
		return contrasena;
	}
	
	/*Getter del correo, retorna un String correspondiente al correo del usuario.
	* No recibe par�metros*/
	public String getCorreo() {
		return correo;
	}

	/*Getter del men�, retorna un objeto de tipo MenuDeConsola correspondiente al menu del usuario.
	* No recibe par�metros*/
	/*public MenuDeConsola getMenu() {
		return menu;
	}*/
	
	public 	ArrayList<String> getProcesos(){
		return Procesos;
	}
	
	/*Setter del nombre, asigna el nombre al objeto.
	* Recibe como par�metro un String equivalente al nombre.
	* No devuelve nada*/
	public void setNombre(String name) {
		nombre = name;
	}
	
	/*Setter de la c�dula, asigna la c�dula al usuario.
	* Recibe como par�metro un String equivalente a la c�dula, caste�ndola a long.
	* No devuelve nada*/
	public void setCedula(String id) {
		cedula = Long.parseLong(id);
	}
	
	/*Setter del correo, asigna el correo al usuario.
	* Recibe como par�metro un String equivalente al correo.
	* No devuelve nada*/
	public void setCorreo(String mail) {
		correo = mail;
	}
	
	/*Setter de la contrase�a, asigna la contrase�a al usuario.
	* Recibe como par�metro un String equivalente a la contrase�a.
	* No devuelve nada*/
	public void setContrasena(String pass) {
		contrasena = pass;
	}
}