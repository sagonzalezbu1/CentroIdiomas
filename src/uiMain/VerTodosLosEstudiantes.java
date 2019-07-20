package uiMain;

import gestorAplicacion.Centro.Archivo;

public class VerTodosLosEstudiantes extends OpcionDeMenu {
	private String nombre = "VerTodosLosEstudiantes";

	public String getNombre() {
		return nombre;
	}

	public void ejecutar() {
		if (Archivo.verEstudiantes().equals("")) {
			System.out.println("No hay estudiantes registrados.\n");
		} else {
			System.out.println(Archivo.verEstudiantes());
		}
	}

	public String toString() {
		return "Ver todos los estudiantes";
	}
}
