package uiMain;

import java.util.*;

public class MenuDeConsola {
    Scanner entry = new Scanner(System.in);
    private ArrayList<OpcionDeMenu> Menu = new ArrayList<OpcionDeMenu>();
    
    public MenuDeConsola() {
    }
    
    public MenuDeConsola(RegistrarEstudiante RegistrarEstudiante , RegistrarDocente RegistrarDocente, RegistrarAdministrativo RegistrarAdministrativo) {
    	Menu.add(RegistrarEstudiante);
    	Menu.add(RegistrarDocente);
    	Menu.add(RegistrarAdministrativo);
    }
    //M�todos para que el administrador agregue o elimine opciones a los usuarios
    public void anadirOpcion(OpcionDeMenu option){
        Menu.add(option);
    }
    public void eliminarOpcion() {
    	int cont = 0;
        for (OpcionDeMenu x : Menu) {
            System.out.println(cont + ". " + x);
            cont++;
        }
        System.out.println("Ingrese el n�mero de la opci�n que desea eliminar del men�: ");
        int i = entry.nextInt();
        Menu.remove(i);
    }
    //Ejecuci�n de los men�s
    public void lanzarMenu(){
        int cont = 0;
        for (OpcionDeMenu x : Menu) {
            System.out.println(cont + ". " + x);
            cont++;
        }
        System.out.println("\nIngrese el n�mero de la opci�n que desea ejecutar: ");
        int op= entry.nextInt();
        ejecutarOpcion(op);
    }
    //Ejecuci�n de las opciones
    private void ejecutarOpcion(int op) {
    	Menu.get(op).ejecutar();
    }
    public ArrayList<OpcionDeMenu> getList(){
    	return Menu;
    }
}