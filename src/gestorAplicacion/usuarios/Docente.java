package gestorAplicacion.usuarios;
import java.util.*;
import gestorAplicacion.Centro.*; 

public class Docente extends Usuario{
    private ArrayList <Curso> misCursos;
    private int codigo;  
    
    public Docente(String name, long cedula, String correo, String clave, Departamento dpto){
        super(name,cedula,correo,clave);
        dpto.add(cedula, clave);
        dpto.add(this);
    }
    
    public String miHorario(){
        String aux = "";
        for (Curso x:misCursos){
            aux += "Nombre: " + x.getNombreCurso() + "\n" + "Horario: " + x.getHorarioCurso() + "\n";
        }
        return aux;
    }
    public void removeCurso(String nombreCurso){
        for (Curso x : misCursos){
            if(x.getNombreCurso().equals(nombreCurso)){
                misCursos.remove(x);
            }
        }
    }
    public void addCurso(Curso course){
        misCursos.add(course);
    }
    public String toString(){
        return("Nombre: " + super.nombre +"\nCedula: " + super.cedula);
    }
    public int getCodigo(int code){
        return codigo;
    }
}