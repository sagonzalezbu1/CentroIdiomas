package gestorAplicacion.Centro;

import gestorAplicacion.Usuarios.*;

public class Sugerencia {
	private Usuario usuario;
	private String mensaje;

	public Sugerencia(Usuario u, String s) {
		usuario = u;
		mensaje = s;
		Archivo.add(this);
	}
	
	public Usuario getUsuario(){
		return usuario;
	}
	
	public String getMensaje(){
			return mensaje;
	}
	
	public String toString() {
		return "El Usuario " + usuario.getNombre() + " con cedula " + usuario.getCedula()
				+ " ha hecho la siguiente sugerencia: " + mensaje;
	}

}
