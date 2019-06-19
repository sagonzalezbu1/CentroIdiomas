package gestorAplicacion.usuarios;
import gestorAplicacion.Centro.Solicitud;
import java.util.*;

public class Administrativo extends Usuario{
    private ArrayList <Solicitud> misSolicitudes;
    private static final int codigo = 123456;  
    
    Administrativo(String name, long cedula, String correo, String clave){
        super(name,cedula,correo,clave);
    }
    public String toString(){
        return("Nombre: " + super.nombre +"Cedula: " + super.cedula);
    }
    public int getCodigo(int code){
        return codigo;
    }
}