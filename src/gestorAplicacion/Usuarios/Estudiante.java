package gestorAplicacion.Usuarios;

import java.util.*;
import uiMain.*;
import gestorAplicacion.Centro.*;

public class Estudiante extends Usuario implements Horario {
	private String estado = "Inactivo";
	private ArrayList<Certificado> misCertificados = new ArrayList<Certificado>();
	private ArrayList<Solicitud> misSolicitudes = new ArrayList<Solicitud>();
	private ArrayList<Curso> misCursos = new ArrayList<Curso>();
	private HashMap<String, ArrayList<Float>> misNotas = new HashMap<>();

	// Constructor para creacion de objeto
	public Estudiante(String name, long cedula, String correo, String clave) {
		super(name, cedula, correo, clave);
		// Menu por defecto
		getMenu().anadirOpcion(Main.funcionalidades.get("VerCursos"));
		getMenu().anadirOpcion(Main.funcionalidades.get("Matricular"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerCertificados"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerMisSolicitudes"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerHorario"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerNotas"));
		getMenu().anadirOpcion(Main.funcionalidades.get("SolicitarCupo"));
		getMenu().anadirOpcion(Main.funcionalidades.get("CerrarSesion"));

		Archivo.add(this);

	}

	// Constructor para carga de archivos
	public Estudiante(long cedula, String name, String correo, String clave) {
		super(name, cedula, correo, clave);
		Archivo.add(this);
		// Menu editado
	}

	// Añadir certificado a lista de certicifados del estudiante
	public void addCertificado(Certificado certify) {
		misCertificados.add(certify);
	}

	// Añadir curso a lista de cursos y al hashmap de notas
	public void addCurso(Curso course) {
		misCursos.add(course);
		misNotas.put(course.getNombreCurso(), new ArrayList());
	}

	// Añadir una nota al estudiante (Uso exclusivo en carga de archivos)
	public void addNota(Curso course, float grade) {
		misNotas.get(course.getNombreCurso()).add(grade);
	}

	// Calificar al estudiante
	public void calificar(String name, float grade) {
		ArrayList<Float> itemsList = misNotas.get(name);
		itemsList.add(grade);
	}

	// Lista de mis cursos
	public ArrayList<Curso> getCurso() {
		return misCursos;
	}

	// Saber definitiva del estudiante en cierto curso
	public float getDefinitiva(String name) {
		ArrayList<Float> prom = misNotas.get(name);
		float def = 0;
		for (Float x : prom) {
			def += x;
		}
		if (prom.size() == 0) {
			return 0;
		} else {
			def /= prom.size();
			return def;
		}
	}

	// Estado del estudiante
	public String getEstado() {
		return estado;
	}

	// Lista de certificados del estudiante
	public ArrayList<Certificado> getCertificados() {
		return misCertificados;
	}
	
	public  ArrayList<Solicitud> getSolicitudes(){
		return misSolicitudes;
	}
	
	// Hashmap de notas del estudiante
	public HashMap<String, ArrayList<Float>> getNotas() {
		return misNotas;
	}

	// Ver notas del estudiante con formato correcto
	public String verNotas(String nombreM) {
		ArrayList<Float> prom = misNotas.get(nombreM);
		String list = " ";
		for (Float x : prom) {
			list += x + "  ";
		}
		list += "  Nota acumulada: " + this.getDefinitiva(nombreM);
		return list;
	}

	// Ver horario del estudiante con formato correcto
	public String miHorario() {
		String aux = "";
		for (Curso x : misCursos) {
			aux += x + "\n";
			aux += "\n";
		}
		if (aux.equals("")) {
			return "Este estudiante aun no tiene horario";
		} else {
			return aux;
		}
	}

	// Eliminar curso de lista de cursos del estudiante
	public void removeCurso(String nombreCurso) {
		Curso y = null;
		for (Curso x : misCursos) {
			if (x.getNombreCurso().equals(nombreCurso)) {
				y=x;
				break;
			}
		}
		misCursos.remove(y);
	}

	// Eliminar solicitud de lista de solicitudes del estudiante
	public void removeSolicitud(String tipo) {
		for (Solicitud s : misSolicitudes) {
			if ((s.getTipo()).equals(tipo)) {
				misSolicitudes.remove(s);
				return;
			}
		}
	}

	// Cambiar estado del estudiante (0 para matricular curso, 1 para finalizar
	// curso)
	public void setEstado(int status) {
		if (status == 0) {
			estado = "Activo";
		}
	}

	// Cambiar estado del estudiante (0 para matricular curso, 1 para finalizar
	// curso)
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

	// Solicitar cupo a un curso
	public void solicitar(String type) {
		Solicitud s = new Solicitud(type, this);
		misSolicitudes.add(s);
	}

	// toString del estudiante
	public String toString() {
		return ("Nombre: " + super.getNombre() + "\nCedula: " + super.getCedula());
	}

	// Ver certificados del estudiante con formato correcto
	public String verCertificados() {
		String aux = "";
		for (Certificado x : misCertificados) {
			aux += x + "\n";
		}
		return aux;

	}

	// Ver solicitudes del estudiante con formato correcto
	public String verSolicitudes() {
		String aux = "";
		for (Solicitud x : misSolicitudes) {
			aux += x + ",";
		}
		if (!aux.equals("")) {
			aux = aux.substring(0, aux.length() - 1);
		}
		return aux;
	}
}