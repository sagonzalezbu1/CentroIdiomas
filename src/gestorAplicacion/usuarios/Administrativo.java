package gestorAplicacion.usuarios;

import gestorAplicacion.Centro.*;
import java.util.*;

public class Administrativo extends Usuario{
    //private ArrayList <Solicitud> misSolicitudes;
    private static final String codigo = "123456";  
    
    public Administrativo(String name, long cedula, String correo, String clave) {
        super(name,cedula,correo,clave);
        Archivo.add(cedula, clave);
        Archivo.add(this);
    }
    public String toString() {
        return("Nombre: " + super.nombre +"\nCedula: " + super.cedula);
    }
    public String getCodigo(String code){
        return codigo;
    }
}