package gestorAplicacion.Centro;
import java.util.*;

public class Curso {
	//No olvidar poner el GC para verificar si sí se borra el curso;
    final String nombre;
    private String tipo;
    private String horario;
    private Docente docente;
    private int cupos = 10;
    private ArrayList<Estudiante> alumnos = new ArrayList<Estudiante>();

    public Curso(String name, String horario, Docente docente, String tipo) {
        nombre = name;
        this.horario = horario;
        this.docente = docente;
        this.tipo = tipo;
    }

    public Curso(String name, String horario, Docente docente, String tipo, ArrayList<Estudiante> est) {
        nombre = name;
        this.horario = horario;
        this.docente = docente;
        this.tipo = tipo;
        for (Estudiante x : est) {
            alumnos.add(x);
        }
    }

    //
    public void matricular(Estudiante e) {
        if (cupos - alumnos.size() > 0) {
            alumnos.add(e);
            e.addCurso(this);
            e.setEstado(0);
        }else{
            System.out.println("No hay cupos");
            
        }
    }

    //
    public String toString() {
        return "Nombre: " + nombre + "\n Horario: " + horario + "\n Profesor: " + docente + "\n Cupos disponibles: " + (cupos - alumnos.size());
    }

    //cambar la cant de cupos en el curso
    public void setCupos(int n) {
        cupos += n;
    }

    public String verEstudiantes() {
        String ver = "";
        for (Estudiante x : alumnos) {
            ver += x.toString() + "\n";
        }
        return ver;
    }

    //terminar un curso
    public void finalizeCurso() {
        Departamento.removeCurso(nombre);
        for (Estudiante x : alumnos) {
            float nota = x.getNota(nombre);
            if (nota >= 3) {
                x.setEstado(nombre, 1);
                x.addCertificado(new Certificado(tipo, x.getNombre(), docente, nota));
            }
            x.removeCurso(nombre);
        }
        docente.removeCurso(nombre);
    }

    public String getNombreCurso() {
        return nombre;
    }

    public String getHorarioCurso() {
        return horario;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCupos() {
        return cupos;
    }

    public int getCuposDisponibles() {
        return cupos - alumnos.size();
    }
}
