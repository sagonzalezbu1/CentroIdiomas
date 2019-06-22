package uiMain;
import gestorAplicacion.Centro.*;
import gestorAplicacion.usuarios.*;
import java.util.*;

public class SolicitarCupo extends OpcionDeMenu{
	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		System.out.println("¿De que materia va a solicitar cupo?");
		String aux = entry.next();
		((Estudiante)UsIn).solicitar(aux);
	}
	public String toString(){
		return "Solicitar Cupo";
	}

}