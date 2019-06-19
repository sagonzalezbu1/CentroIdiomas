package gestorAplicacion.usuarios;

import gestorAplicacion.Centro.*;
import java.util.*;

public class Administrativo extends Usuario{
    private ArrayList <Solicitud> misSolicitudes;
    private static final int codigo = 123456;  
    
    public Administrativo(String name, long cedula, String correo, String clave,Departamento dpto){
        super(name,cedula,correo,clave);
        dpto.add(this);
    }
    public String toString(){
        return("Nombre: " + super.nombre +"\nCedula: " + super.cedula);
    }
    public int getCodigo(int code){
        return codigo;
    }
}