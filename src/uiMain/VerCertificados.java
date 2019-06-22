package uiMain;
import gestorAplicacion.usuarios.*;
public class VerCertificados extends OpcionDeMenu{
	public void ejecutar() {
		((Estudiante)UsIn).verCertificados();
	}
	public String toString() {
		return "Certificados Pendientes";
	}
}
