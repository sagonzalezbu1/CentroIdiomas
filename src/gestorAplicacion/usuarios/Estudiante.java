package gestorAplicacion.usuarios;

import java.util.*;
import gestorAplicacion.Centro.*;
import uiMain.MenuDeConsola;

public class Estudiante extends Usuario {
	private String estado = "Inactivo";
	private ArrayList<Certificado> misCertificados = new ArrayList<Certificado>();
	private ArrayList<Solicitud> misSolicitudes = new ArrayList<Solicitud>();
	private ArrayList<Curso> misCursos = new ArrayList<Curso>();
	private HashMap<String, ArrayList<Float>> misNotas = new HashMap<>();

	public Estudiante(String name, long cedula, String correo, String clave) {
		super(name, cedula, correo, clave);
		Archivo.add(cedula, clave);
		Archivo.add(this);
	}

	public String miHorario() {
		String aux = "";
		for (Curso x : misCursos) {
			aux += x + "\n";
			aux += "\n";
		}
		return aux;
	}

	public String getEstado() {
		return estado;
	}

	// 0 para matricular, 1 para finalizar
	public void setEstado(int status) {
		if (status == 0) {
			estado = "Activo";
		}
	}

	public void setEstado(String mater, int status) {
		if (status == 1) {
			if (misCursos.size() > 1) {
				estado = "Activo";
			} else {
				float aux = this.getNota(mater);
				if (aux >= 3.0) {
					estado = "Egresado";
				} else {
					estado = "Inactivo";
				}
			}
		}
	}

	public float getNota(String nombreM) {
		ArrayList<Float> prom = misNotas.get(nombreM);
		float def = 0;
		for (float x : prom) {
			def += x;
		}
		def = def / prom.size();
		return def;
	}

	public void addCurso(Curso course) {
		misCursos.add(course);
	}

	public void removeCurso(String nombreCurso) {
		for (Curso x : misCursos) {
			if (x.getNombreCurso().equals(nombreCurso)) {
				misCursos.remove(x);
			}
		}
	}

	public void addCertificado(Certificado certify) {
		misCertificados.add(certify);
	}

	public void calificar(String name, float grade) {
		ArrayList<Float> itemsList = misNotas.get(name);
		itemsList.add(grade);
	}
	
	public void solicitar(String type) {
		Solicitud s = new Solicitud(type);
		misSolicitudes.add(s);
		s.solicitar(type, this);
	}

	public void removeSolicitud(Solicitud soli) {
		misSolicitudes.remove(soli);
	}
	
	public String verSolicitudes() {
		String aux = "";
		for (Solicitud x : misSolicitudes) {
			aux += x + ", ";
		}
		return aux;
	}
	public String verCertificados() {
		String aux = "";
		for (Certificado x : misCertificados) {
			aux += x.getNombre() + "\n";
		}
		return aux;
	}
	
	public String toString() {
		return ("Nombre: " + super.nombre + "\nCedula: " + super.cedula);
	}
}