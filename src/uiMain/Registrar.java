package uiMain;

public class Registrar extends OpcionDeMenu {

	MenuDeConsola m= new MenuDeConsola(new RegistrarEstudiante(),new RegistrarDocente(),new RegistrarAdministrativo());
	
	public void ejecutar() {
		m.lanzarMenu();
	}
	
	public String toString() {
		return "Registrar";
	}
}