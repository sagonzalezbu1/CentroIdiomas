package gestorAplicacion.Centro;

import gestorAplicacion.usuarios.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import gestorAplicacion.usuarios.Estudiante;
import uiMain.AceptarSolicitud;
import uiMain.CrearCurso;
import uiMain.RechazarSolicitud;

public class Solicitud {

	Scanner entry = new Scanner(System.in);
	static private HashMap<String, ArrayList<Estudiante>> solicitudes = new HashMap<>();
	private String tipo;

	public Solicitud(String tipo) {
		this.tipo = tipo;
	}

	private Curso disponibilidad() {
		ArrayList<Curso> Cursos = Archivo.getCursos();
		for (Curso c : Cursos) {
			if (c.getTipo().equals(tipo) && c.getCuposDisponibles() > 0) {
				return c;
			}
		}
		return null;
	}

	public static String solicitudes() {
		String im = "";
		for (String key : solicitudes.keySet()) {
			im += key + "\n";
		}
		return im;
	}

	public void aceptarSolicitud() {
		Curso x = disponibilidad();
		// ArrayList<Estudiante> e = solicitudes.get(tipo);
		int per = 0;
		// aceptar solicitudes sin que haya cupos disponibles
		if (x == null) {
			CrearCurso cc = new CrearCurso();
			// Se ejecuta la opcion de menu Crear un curso.
			cc.ejecutar();
			Curso nuevo = disponibilidad();
			String im = "";
			int cont = 0;
			for (Estudiante d : solicitudes.get(tipo)) {
				im += cont + " " + d.toString();
				cont++;
			}
			int posicion = AceptarSolicitud.CC(im);
			Estudiante aceptar = (solicitudes.get(tipo)).get(posicion);
			aceptar.removeSolicitud(this);
			nuevo.matricular(aceptar);
			(solicitudes.get(tipo)).remove(posicion);
		}
		// aceptar solicitudes si hay cupos disponibles
		else {
			String im = "";
			int cont = 0;
			for (Estudiante d : solicitudes.get(tipo)) {
				im += cont + " " + d.toString();
				cont++;
			}
			int posicion = AceptarSolicitud.CC(im);
			Estudiante aceptar = (solicitudes.get(tipo)).get(posicion);
			aceptar.removeSolicitud(this);
			x.matricular(aceptar);
			(solicitudes.get(tipo)).remove(posicion);
		}
	}

	public void rechazarSolicitud() {
		String im = "";
		int cont = 0;
		for (Estudiante d : solicitudes.get(tipo)) {
			im += cont + " " + d.toString();
			cont++;
		}
		int posicion = RechazarSolicitud.CC(im);
		Estudiante aceptar = (solicitudes.get(tipo)).get(posicion);
		aceptar.removeSolicitud(this);
		(solicitudes.get(tipo)).remove(posicion);
	}

	public void solicitar(String tipo, Estudiante e) {
		if (solicitudes.containsKey(tipo)) {
			(solicitudes.get(tipo)).add(e);
		} else {
			solicitudes.put(tipo, new ArrayList<>());
			(solicitudes.get(tipo)).add(e);
		}
	}

	public String toString() {
		return tipo;
	}
}