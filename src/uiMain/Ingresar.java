package uiMain;
import java.util.*;


public class Ingresar extends OpcionDeMenu{
	public void ejecutar() {
		Scanner entry= new Scanner(System.in);
		System.out.println("Ingrese su cedula :");
		long cc= entry.nextInt();
		System.out.println("Ingrese su contrase�a :");
		String pass= entry.next();
	}
}
