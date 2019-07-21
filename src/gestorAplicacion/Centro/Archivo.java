package gestorAplicacion.Centro;

import java.util.*;

import gestorAplicacion.Usuarios.*;

abstract public class Archivo {
	static private ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
	static private ArrayList<Docente> listaDocentes = new ArrayList<Docente>();
	static private ArrayList<Administrativo> listaAdministrativos = new ArrayList<Administrativo>();
	static private ArrayList<Curso> listaCursos = new ArrayList<Curso>();
	static private HashMap<String, ArrayList<Solicitud>> solicitudes = new HashMap<>();
	static private Administrador a1 = new Administrador("Jaime Guzman", 123, "admin@cdi.com", "123");

	static public void add(Administrativo a) {
		listaAdministrativos.add(a);
	}

	static public void add(Curso c) {
		listaCursos.add(c);
	}

	static public void add(Docente d) {
		listaDocentes.add(d);
	}

	static public void add(Estudiante e) {
		listaEstudiantes.add(e);
	}

	// busca por cedula a las personas y por nombre a los cursos
	static public Administrativo buscarAdministrativo(long admin) {
		for (Administrativo x : listaAdministrativos) {
			if (x.getCedula() == admin) {
				return x;
			}
		}
		return null;
	}

	static public Docente buscarDocente(long docen) {
		for (Docente x : listaDocentes) {
			if (x.getCedula() == docen) {
				return x;
			}
		}
		return null;
	}

	static public Curso buscarCurso(String curso) {
		for (Curso x : listaCursos) {
			if (x.getNombreCurso().equals(curso)) {
				return x;
			}
		}
		return null;
	}

	static public Estudiante buscarEstudiante(long estud) {
		for (Estudiante x : listaEstudiantes) {
			if (x.getCedula() == estud) {
				return x;
			}
		}
		return null;
	}

	static public Usuario buscarUsuario(long id) {
		Usuario u = buscarAdministrativo(id);
		if (u == null) {
			u = buscarDocente(id);
			if (u == null) {
				u = buscarEstudiante(id);
			}
		}
		return u;
	}

	static public Curso CursoDisponibilidad(String tipo) {
		ArrayList<Curso> Cursos = getCursos();
		for (Curso c : Cursos) {
			if (c.getTipo().equals(tipo) && c.getCuposDisponibles() > 0) {
				return c;
			}
		}
		return null;
	}

	static public Administrador getAdministrador() {
		return a1;
	}

	static public ArrayList<Administrativo> getAdministrativos() {
		return listaAdministrativos;
	}

	static public ArrayList<Curso> getCursos() {
		return listaCursos;
	}

	static public ArrayList<Docente> getDocentes() {
		return listaDocentes;
	}

	static public ArrayList<Estudiante> getEstudiantes() {
		return listaEstudiantes;
	}

	static public HashMap<String, ArrayList<Solicitud>> getSolicitudes() {
		return solicitudes;
	}

	static public void removeCurso(String nombre) {
		Iterator<Curso> I = listaCursos.iterator();
		while (I.hasNext()) {
			Curso x = I.next();
			if (x.getNombreCurso().equals(nombre)) {
				listaCursos.remove(x);
				break;
			}
		}
	}

	static public void removeSolicitud(String tipo, Solicitud s) {
		(solicitudes.get(tipo)).remove(s);
		if (solicitudes.get(tipo).isEmpty()) {
			solicitudes.remove(tipo);
		}
	}

	static public String verAdministrativos() {
		String ver = "";
		for (Administrativo x : listaAdministrativos) {
			ver += "\n";
			ver += x.toString() + "\n";
		}
		return "\nAdministrativos:\n" + ver;
	}

	static public String verCursos() {
		String ver = "";
		for (Curso x : listaCursos) {
			ver += "\n";
			ver += x.toString() + "\n";
		}
		if (ver.equals("")) {
			return "\nNo hay cursos disponibles\n";
		} else {
			return "\nCursos:\n" + ver;
		}
	}

	static public String verDocentes() {
		String ver = "";
		for (Docente x : listaDocentes) {
			ver += "\n";
			ver += x.toString() + "\n";
		}
		return "\nDocentes:\n" + ver;
	}

	static public String verSolicitudes() {
		String ver = "";
		for (String x : solicitudes.keySet()) {
			ver += "\n";
			ver += x + "\n";
		}
		return "\nSolicitudes:\n" + ver;
	}

	static public String verEstudiantes() {
		String ver = "";
		for (Estudiante x : listaEstudiantes) {
			ver += "\n";
			ver += x.toString() + "\n";
		}
		return "\nEstudiantes:\n" + ver;
	}

	static public String verEstudiantesCurso(String curso) {
		String ver = "";
		for (Estudiante x : Archivo.buscarCurso(curso).getEstudiantes()) {
			ver += "\n";
			ver += x.toString() + "\n";
		}
		if (Archivo.buscarCurso(curso).getEstudiantes().isEmpty()) {
			return "\nEste curso no tiene estudiantes.\n";
		} else {
			return "\nEstudiantes de " + Archivo.buscarCurso(curso).getNombreCurso() + ":\n" + ver;
		}
	}
}