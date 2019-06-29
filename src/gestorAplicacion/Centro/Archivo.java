package gestorAplicacion.Centro;

import java.util.*;

import gestorAplicacion.Usuarios.*;

abstract public class Archivo {
	static private ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
	static private ArrayList<Docente> listaDocentes = new ArrayList<Docente>();
	static private ArrayList<Administrativo> listaAdministrativos = new ArrayList<Administrativo>();
	static private ArrayList<Curso> listaCursos = new ArrayList<Curso>();
	static private HashMap<Long, String> Usuarios = new HashMap<>();
	static private HashMap<String, ArrayList<Estudiante>> solicitudes = new HashMap<>();
	static private Administrador a1 = new Administrador("Jaime Guzman", 0000, "admin@cdi.com", "123");

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

	static public void add(long cc, String pass) {
		Usuarios.put(cc, pass);
	}

	static public Administrativo buscarAdministrativo(String admin) {
		for (Administrativo x : listaAdministrativos) {
			if (x.getNombre().equals(admin)) {
				return x;
			}
		}
		return null;
	}
	
	static public Docente buscarDocente(String docen) {
		for (Docente x : listaDocentes) {
			if (x.getNombre().equals(docen)) {
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
	
	static public Estudiante buscarEstudiante(String estud) {
		for (Estudiante x : listaEstudiantes) {
			if (x.getNombre().equals(estud)) {
				return x;
			}
		}
		return null;
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

	static public HashMap<String, ArrayList<Estudiante>> getSolicitudes() {
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

	static public void removeSolicitud(String tipo, Estudiante e) {
		(solicitudes.get(tipo)).remove(e);
	}

	static public String verAdministrativos() {
		String ver = "";
		for (Administrativo x : listaAdministrativos) {
			ver = ver + x.toString() + "\n";
		}
		return ver;
	}

	static public String verCursos() {
		String ver = "";
		for (Curso x : listaCursos) {
			ver = ver + x.toString() + "\n";
		}
		return ver;
	}

	static public String verDocentes() {
		String ver = "";
		for (Docente x : listaDocentes) {
			ver = ver + x.toString() + "\n";
		}
		return ver;
	}

	static public String verEstudiantes() {
		String ver = "";
		for (Estudiante x : listaEstudiantes) {
			ver = ver + x.toString() + "\n";
		}
		return ver;
	}

}