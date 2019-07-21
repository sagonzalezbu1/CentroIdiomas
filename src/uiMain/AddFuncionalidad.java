package uiMain;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.Centro.Archivo;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Usuario;

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
		if (y != null ) {
			System.out.println(Archivo.getAdministrador().SystemMenu());
			System.out.println("Ingrese la funcionalidad que quiere agregar: ");
			String option = e.next();
			ArrayList<OpcionDeMenu> menu= y.getMenu().getList();
			for(OpcionDeMenu op: menu) {
				if(op.getNombre().equals(option)) {
					System.out.println("La opcion de menu ya esta disponible para ese usuario.\n");
					return;
				}
			}
			if(Main.funcionalidades.get(option)!=null) {
				y.getMenu().anadirOpcion(Main.funcionalidades.get(option));
				System.out.println("Se ha añadido la opcion sactisfactoriamente.\n");
			}
			else {
				System.out.println("Opcion invalida.\n");
			}
			
		} else {
			System.out.println("El usuario no esta registrado.\n");
		}
	}

	public String toString() {
		return "Agregar funcionalidad";
	}

}
