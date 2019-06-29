package uiMain;

import java.util.Scanner;

import gestorAplicacion.Centro.Archivo;
import gestorAplicacion.usuarios.Usuario;

public class AddFuncionalidad extends OpcionDeMenu {
	public void ejecutar() {
		Scanner e = new Scanner(System.in);
		System.out.println("Ingrese la cedula del usuario al que desea agregar una funcionalidad: ");
		int cc = e.nextInt();
		Usuario y = null;
		for (Usuario x : Archivo.getEstudiantes()) {
			if (x.getCedula() == cc) {
				y = x;
			}
		}
		for (Usuario x : Archivo.getDocentes()) {
			if (x.getCedula() == cc) {
				y = x;
			}
		}
		for (Usuario x : Archivo.getAdministrativos()) {
			if (x.getCedula() == cc) {
				y = x;
			}
		}
		if (y != null) {
			//y.getMenu().
		} else {
			System.out.println("El usuario no esta registrado");
		}
	}

	public String toString() {
		return "Agregar funcionalidad";
	}

}
