package uiMain;
import java.util.*;

public class MenuDeConsola {
    Scanner entry = new Scanner(System.in);
    private ArrayList<OpcionDeMenu> Menu = new ArrayList<OpcionDeMenu>();
    
    public void anadirOpcion(OpcionDeMenu option){
        Menu.add(option);
    }
    public void eliminarOpcion(){
        System.out.println("¿Que opcion desea eliminar del menu?");
        int i = entry.nextInt();
        Menu.remove(i);
    }
    public void lanzarMenu(){
        int cont = 0;
        for (OpcionDeMenu x : Menu) {
            System.out.println(cont + ". " + x);
            cont++;
        }
        int op= entry.nextInt();
        ejecutarOpcion(op);
    }
    private void ejecutarOpcion(int op) {
    	Menu.get(op).ejecutar();
    }
}