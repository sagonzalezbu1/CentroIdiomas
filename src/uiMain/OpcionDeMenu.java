package uiMain;
import java.util.Scanner;
import gestorAplicacion.usuarios.*;

public abstract class OpcionDeMenu {
	public static Usuario UsIn = null;
	public abstract void ejecutar();
    public abstract String toString();
    public static void volverMenu() {
    	Scanner e= new Scanner( System.in);
    	if( UsIn == null) {
			Invitado.getMenu().lanzarMenu();
			int op=e.nextInt();
			Invitado.getMenu().ejecutarOpcion(op);
		}else if(UsIn instanceof Estudiante) {
			((Estudiante) UsIn).getMenu().lanzarMenu();
			int op=e.nextInt();
			((Estudiante) UsIn).getMenu().ejecutarOpcion(op);
		}else if (UsIn instanceof Docente) {
			((Docente) UsIn).getMenu().lanzarMenu();
			int op=e.nextInt();
			((Docente) UsIn).getMenu().ejecutarOpcion(op);
		}else {
			((Administrativo) UsIn).getMenu().lanzarMenu();
			int op=e.nextInt();
			((Administrativo) UsIn).getMenu().ejecutarOpcion(op);
		}
    }
}
