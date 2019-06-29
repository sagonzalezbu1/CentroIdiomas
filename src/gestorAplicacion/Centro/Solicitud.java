package gestorAplicacion.Centro;

import java.util.ArrayList;

import gestorAplicacion.Usuarios.Estudiante;

public class Solicitud {
	private String tipo;

	public Solicitud(String tipo, Estudiante e) {
		this.tipo = tipo;
		if (Archivo.getSolicitudes().containsKey(tipo)) {
			(Archivo.getSolicitudes().get(tipo)).add(e);
		} else {
			Archivo.getSolicitudes().put(tipo, new ArrayList<>());
			(Archivo.getSolicitudes().get(tipo)).add(e);
		}
	}

	public String getTipo() {
		return tipo;
	}

	public String toString() {
		return tipo;
	}
}