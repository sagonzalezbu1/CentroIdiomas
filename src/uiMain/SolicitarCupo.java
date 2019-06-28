package uiMain;
import gestorAplicacion.Centro.*;
import gestorAplicacion.usuarios.*;
import java.util.*;

public class SolicitarCupo extends OpcionDeMenu{
	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		if(Main.user instanceof Estudiante) {
			System.out.println("Ingrese la materia a la cual va a solicitar el cupo: ");
			String aux = entry.next();
			((Estudiante)Main.user).solicitar(aux);
			return;
		}
		else if(Main.user instanceof Docente) {
			System.out.println("Ingrese el ID del estudiante al que va a solicitarle cupo: ");
			long aux1 = entry.nextLong();
			System.out.println("Ingrese la materia a la cual va a solicitar el cupo: ");
			String aux2 = entry.next();
			for(Estudiante x : Archivo.getEstudiantes()) {
				if(x.getCedula()==aux1) {
					x.solicitar(aux2);
					return;
				}
			}
			
		}
		else if(Main.user instanceof Administrativo) {
			System.out.println("Ingrese el ID del estudiante al que va a solicitarle cupo: ");
			long aux1 = entry.nextLong();
			System.out.println("Ingrese la materia a la cual va a solicitar el cupo: ");
			String aux2 = entry.next();
			for(Estudiante x : Archivo.getEstudiantes()) {
				if(x.getCedula()==aux1) {
					x.solicitar(aux2);
					return;
				}
			}
			
		}
		System.out.println("Estudiante no encontrado");
	}
	public String toString(){
		return "Solicitar Cupo";
	}

}