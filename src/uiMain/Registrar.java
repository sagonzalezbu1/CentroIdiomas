package uiMain;

public class Registrar extends OpcionDeMenu {
	
	private String nombre="Registrar";
	public String getNombre() {
		return nombre;
	}
	
	//Submen�
	MenuDeConsola m = new MenuDeConsola(new RegistrarEstudiante(),new RegistrarDocente(),new RegistrarAdministrativo());
	
	//Ejecuci�n del submen�
	public void ejecutar() {
		m.lanzarMenu();
	}
	
	public String toString() {
		return "Registrar";
	}
}