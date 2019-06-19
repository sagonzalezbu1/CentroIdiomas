package gestorAplicacion.Centro;
import java.util.*;
import gestorAplicacion.usuarios.*;


public class Departamento {
    static private ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
    static private ArrayList<Docente> listaDocentes = new ArrayList<Docente>();
    static private ArrayList<Administrativo> listaAdministrativos = new ArrayList<Administrativo>();
    static private ArrayList<Curso> listaCursos = new ArrayList<Curso>();

    static public String verEstudiantes() {
        String ver = "";
        for (Estudiante x : listaEstudiantes) {
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

    static public void addEstudiante(Estudiante e) {
        listaEstudiantes.add(e);
    }

    static public void addDocente(Docente d) {
        listaDocentes.add(d);
    }

    static public void addAdminitrativo(Administrativo a) {
        listaAdministrativos.add(a);
    }

    static public void addCurso(Curso c) {
        listaCursos.add(c);
    }
    static public ArrayList<Curso> getCursos(){
        return listaCursos;
    }
    static public ArrayList<Docente> getDocentes(){
        return listaDocentes;
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

}