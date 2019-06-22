package uiMain;

//import java.util.*;
import gestorAplicacion.usuarios.*;
import gestorAplicacion.Centro.*;

public class VerNotas extends OpcionDeMenu {
	public void ejecutar() {
		for(Curso c : ((Estudiante) UsIn).getCurso()) {
			System.out.print(c.getNombreCurso() + ": ");
			System.out.println(((Estudiante) UsIn).getNotas(c.getNombreCurso()));
		}
	}

	public String toString() {
		return "Mis notas";
	}
}
