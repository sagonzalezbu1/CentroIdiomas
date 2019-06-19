package uiMain;
import java.util.*;

public class MenuDeConsola {
    Scanner entry = new Scanner(System.in);
    private ArrayList<OpcionDeMenu> Menu = new ArrayList<OpcionDeMenu>();
    
    public void anadirOpcion(OpcionDeMenu option){
        Menu.add(option);
    }
    public void eliminarOpcion(OpcionDeMenu option){
        System.out.println("¿Que opcion desea eliminar del menú?");
        int i = entry.nextInt();
        Menu.remove(i);
    }
    public void lanzarMenu(){
        for (OpcionDeMenu x : Menu) {
            System.out.println(x);
        }
    }
}