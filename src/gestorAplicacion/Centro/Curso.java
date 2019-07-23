package gestorAplicacion.Centro;

import java.util.*;

import gestorAplicacion.Usuarios.*;

public class Curso {
	final String nombre;
	private String tipo;
	private String horario;
	private Docente docente;
	private int cupos = 10;
	private ArrayList<Estudiante> alumnos = new ArrayList<Estudiante>();

	public Curso(String name, String tipo, String horario, Docente docente) {
		nombre = name;
		this.horario = horario;
		this.docente = docente;
		this.tipo = tipo;
		Archivo.add(this);
	}

	// termina el curso y da certificados a quienes lo merezcan.
	public void finalizeCurso() {
		while (alumnos.size() > 0) {
			Estudiante x = alumnos.get(0);
			alumnos.remove(0);
			float nota = x.getDefinitiva(nombre);
			if (nota >= 3) {
				x.setEstado(nombre, 1);
				x.addCertificado(new Certificado(tipo, x, docente, nota));
			}
			x.removeCurso(nombre);
			
		}
		docente.removeCurso(nombre);
		Archivo.removeCurso(nombre);
	}

	public int getCupos() {
		return cupos;
	}

	public int getCuposDisponibles() {
		return cupos - alumnos.size();
	}

	public ArrayList<Estudiante> getEstudiantes() {
		return alumnos;
	}

	public Docente getDocente() {
		return docente;
	}

	public String getHorarioCurso() {
		return horario;
	}

	public String getNombreCurso() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public boolean matricular(Estudiante e) {
		if (cupos - alumnos.size() > 0) {
			alumnos.add(e);
			e.addCurso(this);
			e.setEstado(0);

			return true;
		} else {
			return false;

		}
	}

	public String toString() {
		return "Nombre: " + nombre + "\nHorario: " + horario + "\nProfesor: " + docente.getNombre()
				+ "\nCupos disponibles: " + (cupos - alumnos.size());
	}

	public String verEstudiantes() {
		String ver = "";
		for (Estudiante x : alumnos) {
			ver += x.toString() + "\n";
		}
		return ver;
	}
	
	public void finalize() {
		System.out.println("\nEl curso "+nombre+" ha sido borrado del sistema.\n");
	}
}
