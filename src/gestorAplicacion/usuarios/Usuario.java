package gestorAplicacion.usuarios;

import uiMain.*;

public abstract class Usuario {
	private String nombre;
	private long cedula;
	private String correo;
	private String contrasena;
	private MenuDeConsola menu = new MenuDeConsola();

	public Usuario(String name, long id, String email, String password) {
		nombre = name;
		cedula = id;
		correo = email;
		contrasena = password;
	}

	public long getCedula() {
		return cedula;
	}

	public String getContrasena() {
		return contrasena;
	}

	public String getCorreo() {
		return correo;
	}

	public MenuDeConsola getMenu() {
		return menu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setContrasena(String pass) {
		contrasena = pass;
	}

}