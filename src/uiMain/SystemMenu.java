package uiMain;

import gestorAplicacion.Usuarios.*;
import gestorAplicacion.Centro.*;

public class SystemMenu extends OpcionDeMenu {
	public void ejecutar() {
		System.out.println(((Administrador) Main.user).SystemMenu());
	}

	public String toString() {
		return "Funcionalidades del sistema";
	}

}
