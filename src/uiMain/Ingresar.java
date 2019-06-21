package uiMain;

import java.util.*;
import gestorAplicacion.usuarios.*;

public class Ingresar extends OpcionDeMenu {

	public void ejecutar() {
		while (UsIn == null) {
			Scanner entry = new Scanner(System.in);
			System.out.println("Ingrese su cedula :");
			long cc = entry.nextInt();
			System.out.println("Ingrese su contrase�a :");
			String pass = entry.next();
			UsIn = Invitado.ingresar(cc, pass);
			if (UsIn == null) {
				System.out.println("Su usuario o contrase�a son invalidos. Ingrese los de nuevo.");
			}
		}
	}
}
