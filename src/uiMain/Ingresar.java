package uiMain;
import java.util.*;

import gestorAplicacion.usuarios.*;
import gestorAplicacion.Centro.*;
public class Ingresar extends OpcionMenu{
	public void ejecutar() {
		Scanner entry= new Scanner(System.in);
		System.out.println("Ingrese su cedula :");
		long cc= entry.nextInt();
		System.out.println("Ingrese su contrase�a :");
		String pass= entry.next();
	}
}
