package gestorAplicacion.Usuarios;

import uiMain.*;

/*Esta clase permite la recopilación de atributos y métodos comunes para sus clases hijas.
 * Es abstracta ya que no se debe ni puede crear una instancia directa de tipo Usuario, 
 * sino instancias de sus subclases*/
public abstract class Usuario {
	private String nombre;
	private long cedula;
	private String correo;
	private String contrasena;
	private MenuDeConsola menu = new MenuDeConsola();

	/*Constructor que inicializa los atributos con valores entregados por el usuario,
	 * que son nombre, cédula, correo y contraseña*/
	public Usuario(String name, long id, String email, String password) {
		nombre = name;
		cedula = id;
		correo = email;
		contrasena = password;
	}

	/*Getter del nombre, retorna un String correspondiente al nombre del usuario.
	* No recibe parámetros*/
	public String getNombre() {
		return nombre;
	}
	
	/*Getter de la cedula, retorna un long correspondiente a la cedula del usuario.
	* No recibe parámetros*/
	public long getCedula() {
		return cedula;
	}
	
	/*Getter de la contraseña, retorna un String correspondiente a la contraseña del usuario.
	* No recibe parámetros*/
	public String getContrasena() {
		return contrasena;
	}
	
	/*Getter del correo, retorna un String correspondiente al correo del usuario.
	* No recibe parámetros*/
	public String getCorreo() {
		return correo;
	}

	/*Getter del menú, retorna un objeto de tipo MenuDeConsola correspondiente al menu del usuario.
	* No recibe parámetros*/
	public MenuDeConsola getMenu() {
		return menu;
	}
	
	/*Setter del nombre, asigna el nombre al objeto.
	* Recibe como parámetro un String equivalente al nombre.
	* No devuelve nada*/
	public void setNombre(String name) {
		nombre = name;
	}
	
	/*Setter de la cédula, asigna la cédula al usuario.
	* Recibe como parámetro un String equivalente a la cédula, casteándola a long.
	* No devuelve nada*/
	public void setCedula(String id) {
		cedula = Long.parseLong(id);
	}
	
	/*Setter del correo, asigna el correo al usuario.
	* Recibe como parámetro un String equivalente al correo.
	* No devuelve nada*/
	public void setCorreo(String mail) {
		correo = mail;
	}
	
	/*Setter de la contraseña, asigna la contraseña al usuario.
	* Recibe como parámetro un String equivalente a la contraseña.
	* No devuelve nada*/
	public void setContrasena(String pass) {
		contrasena = pass;
	}
}