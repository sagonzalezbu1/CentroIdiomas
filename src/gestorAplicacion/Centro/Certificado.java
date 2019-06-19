package gestorAplicacion.Centro;

public class Certificado {
	final private String nombre;
    final private String alumno;
    final private float nota;
    final private Docente docente;

    Certificado(String name, String alumno, Docente docente, float nota) {
        nombre = name;
        this.alumno = alumno;
        this.docente = docente;
        this.nota = nota;
    }

    public String toString() {
        return "El estudiante " + alumno + " ha aprobado el curso de " + nombre + " con una nota de " + nota + " \n con el profesor " + docente.getNombre();
    }

}
