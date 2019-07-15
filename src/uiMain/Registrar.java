package uiMain;

public class Registrar extends OpcionDeMenu {
	
	private String nombre="Registrar";
	public String getNombre() {
		return nombre;
	}
	MenuDeConsola m= new MenuDeConsola(new RegistrarEstudiante(),new RegistrarDocente(),new RegistrarAdministrativo());

	public void ejecutar() {
		m.lanzarMenu();
	}
	
	public String toString() {
		return "Registrar";
	}
}