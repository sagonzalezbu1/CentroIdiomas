package uiMain;

public class Registrar extends OpcionDeMenu {
	
	String nombre="Registrar";
	MenuDeConsola m= new MenuDeConsola(new RegistrarEstudiante(),new RegistrarDocente(),new RegistrarAdministrativo());

	public void ejecutar() {
		m.lanzarMenu();
	}
	
	public String toString() {
		return "Registrar";
	}
}