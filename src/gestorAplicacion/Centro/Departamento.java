package gestorAplicacion.Centro;
import java.util.*;
import gestorAplicacion.usuarios.*;


public class Departamento {
     private ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
     private ArrayList<Docente> listaDocentes = new ArrayList<Docente>();
     private ArrayList<Administrativo> listaAdministrativos = new ArrayList<Administrativo>();
     private ArrayList<Curso> listaCursos = new ArrayList<Curso>();
     private HashMap<Long, String> Usuarios= new HashMap<>();
     
     public String verEstudiantes() {
        String ver = "";
        for (Estudiante x : listaEstudiantes) {
            ver = ver + x.toString() + "\n";
        }
        return ver;
    }

     public String verDocentes() {
        String ver = "";
        for (Docente x : listaDocentes) {
            ver = ver + x.toString() + "\n";
        }
        return ver;
    }

     public String verAdministrativos() {
        String ver = "";
        for (Administrativo x : listaAdministrativos) {
            ver = ver + x.toString() + "\n";
        }
        return ver;
    }

     public String verCursos() {
        String ver = "";
        for (Curso x : listaCursos) {
            ver = ver + x.toString() + "\n";
        }
        return ver;
    }

     public void add(Estudiante e) {
        listaEstudiantes.add(e);
    }

     public void add(Docente d) {
        listaDocentes.add(d);
    }

     public void add(Administrativo a) {
        listaAdministrativos.add(a);
    }
     public void add(Curso c) {
        listaCursos.add(c);
    }
     public void add(long cc, String pass) {
    	 Usuarios.put(cc,pass);
     }
     public ArrayList<Curso> getCursos(){
        return listaCursos;
    }
     public ArrayList<Docente> getDocentes(){
        return listaDocentes;
    }
     public void removeCurso(String nombre) {
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