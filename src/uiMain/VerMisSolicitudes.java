package uiMain;
import gestorAplicacion.usuarios.*;

public class VerMisSolicitudes extends OpcionDeMenu{
	public void ejecutar() {
		((Estudiante)UsIn).verSolicitudes();
	}
	public String toString(){
		return "Solicitudes Pendientes";
	}
}
