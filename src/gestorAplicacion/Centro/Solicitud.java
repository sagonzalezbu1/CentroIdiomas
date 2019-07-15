package gestorAplicacion.Centro;

import java.util.ArrayList;

import gestorAplicacion.Usuarios.Estudiante;

public class Solicitud {
	private Estudiante estu;
	private String tipo;

	public Solicitud(String tipo, Estudiante e) {
		this.tipo = tipo;
		estu= e;
		if (Archivo.getSolicitudes().containsKey(tipo)) {
			(Archivo.getSolicitudes().get(tipo)).add(this);
		} else {
			Archivo.getSolicitudes().put(tipo, new ArrayList<>());
			(Archivo.getSolicitudes().get(tipo)).add(this);
		}
	}
	
	public Estudiante getEstudiante() {
		return estu;
	}

	public String getTipo() {
		return tipo;
	}

	public String toString() {
		return tipo;
	}
}