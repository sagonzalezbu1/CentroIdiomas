
package uiMain;

import java.util.*;
import BaseDatos.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

public class Main {

	public static HashMap<String, OpcionDeMenu> funcionalidades = new HashMap<String, OpcionDeMenu>() {
		{
			
			put("Calificar", new Calificar());
			put("CrearCurso", new CrearCurso());
			put("CursosDisponibles", new CursosDisponibles());
			put("FinalizeCurso", new FinalizeCurso());
			put("Matricular", new Matricular());
			put("Registrar", new Registrar());
			put("ResponderSolicitudes", new ResponderSolicitudes());
			put("SolicitarCupo", new SolicitarCupo());
			put("VerAdministrativos", new VerAdministrativos());
			put("VerCertificados", new VerCertificados());
			put("VerDocentes", new VerDocentes());
			put("VerEstudiantes", new VerEstudiantes());
			put("VerHorario", new VerHorario());
			put("VerMisSolicitudes", new VerMisSolicitudes());
			put("VerNotas", new VerNotas());
		}
	};
	public static Usuario user = new Invitado();

	public static void main(String[] args) {

		Data.cargarEstudiantes();
		Data.cargarDocentes();
		Data.cargarAdministrativos();

		while (true) {
			user.getMenu().lanzarMenu();
		}
	}
}
