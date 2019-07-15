package uiMain;
import java.util.Scanner;
import gestorAplicacion.Centro.Archivo;
import gestorAplicacion.Usuarios.*;
public class VerCertificados extends OpcionDeMenu{
	private String nombre="VerCertificados";
	public String getNombre() {
		return nombre;
	}
	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		if(Main.user instanceof Estudiante) {
			System.out.println(((Estudiante)Main.user).verCertificados());
		}
		else if(Main.user instanceof Docente) {
			System.out.println("Introduzca el ID del estudiante del que quiere ver los certificados");
			long ID = entry.nextLong();
			for(Estudiante x:Archivo.getEstudiantes()) {
				if(x.getCedula()==ID) {
					System.out.println(x.verCertificados());
				}
			}
		}
		else if(Main.user instanceof Administrativo) {
			System.out.println("Introduzca el ID del estudiante del que quiere ver los certificados");
			long ID = entry.nextLong();
			for(Estudiante x:Archivo.getEstudiantes()) {
				if(x.getCedula()==ID) {
					System.out.println(x.verCertificados());
				}
			}
		}	
	}
	public String toString() {
		return "Mis Certificados";
	}
}
