package gestorAplicacion.Usuarios;

import java.util.*;
import uiMain.MenuDeConsola;
import gestorAplicacion.Centro.*;

public class Estudiante extends Usuario {
	private String estado = "Inactivo";
	private ArrayList<Certificado> misCertificados = new ArrayList<Certificado>();
	private ArrayList<Solicitud> misSolicitudes = new ArrayList<Solicitud>();
	private ArrayList<Curso> misCursos = new ArrayList<Curso>();
	private HashMap<String, ArrayList<Float>> misNotas = new HashMap<>();
	
	//Constructor para creacion de objeto
	public Estudiante(String name, long cedula, String correo, String clave) {
		super(name, cedula, correo, clave);
		Archivo.add(cedula, clave);
		Archivo.add(this);
		//Menu por defecto
	}
	
	//Constructor para carga de archivos
	public Estudiante(long cedula, String name, String correo, String clave) {
		super(name, cedula, correo, clave);
		Archivo.add(cedula, clave);
		Archivo.add(this);
		//Menu editado
	}

	public void addCertificado(Certificado certify) {
		misCertificados.add(certify);
	}

	public void addCurso(Curso course) {
		misCursos.add(course);
	}

	public void calificar(String name, float grade) {
		ArrayList<Float> itemsList = misNotas.get(name);
		itemsList.add(grade);
	}

	public ArrayList<Curso> getCurso() {
		return misCursos;
	}

	public float getDefinitiva(String name) {
		ArrayList<Float> prom = misNotas.get(name);
		float def = 0;
		for (Float x : prom) {
			def += x;
		}
		def /= misNotas.size();
		return def;
	}

	public String getEstado() {
		return estado;
	}

	public String getNotas(String nombreM) {
		ArrayList<Float> prom = misNotas.get(nombreM);
		String list = " ";
		for (Float x : prom) {
			list += x + "  ";
		}
		list += "  Definitiva: " + this.getDefinitiva(nombreM);
		return list;
	}

	public String miHorario() {
		String aux = "";
		for (Curso x : misCursos) {
			aux += x + "\n";
			aux += "\n";
		}
		return aux;
	}

	public void removeCurso(String nombreCurso) {
		for (Curso x : misCursos) {
			if (x.getNombreCurso().equals(nombreCurso)) {
				misCursos.remove(x);
			}
		}
	}

	public void removeSolicitud(String tipo) {
		for(Solicitud s: misSolicitudes) {
			if((s.getTipo()).equals(tipo)) {
				misSolicitudes.remove(s);
				return;
			}
		}
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
				float aux = this.getDefinitiva(mater);
				if (aux >= 3.0) {
					estado = "Egresado";
				} else {
					estado = "Inactivo";
				}
			}
		}
	}

	public void solicitar(String type) {
		Solicitud s = new Solicitud(type,this);
		misSolicitudes.add(s);
	}

	public String toString() {
		return ("Nombre: " + super.getNombre() + "\nCedula: " + super.getCedula());
	}

	public String verCertificados() {
		String aux = "";
		for (Certificado x : misCertificados) {
			aux += x + "\n";
		}
		if (aux.equals("")) {
			return "Este estudiante aun no tiene certificados";
		} else {
			return aux;
		}

	}

	public String verSolicitudes() {
		String aux = "";
		for (Solicitud x : misSolicitudes) {
			aux += x + ",";
		}
		return aux;
	}
}