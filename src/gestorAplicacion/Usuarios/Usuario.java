package gestorAplicacion.Usuarios;

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

	public String getNombre() {
		return nombre;
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

	public void setNombre(String name) {
		nombre = name;
	}
	
	public void setCedula(String id) {
		cedula = Long.parseLong(id);
	}
	
	public void setCorreo(String mail) {
		correo = mail;
	}
	
	public void setContrasena(String pass) {
		contrasena = pass;
	}

}