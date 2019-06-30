
package uiMain;

import java.util.*;
import BaseDatos.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

public class Main {

	public static HashMap<String, OpcionDeMenu> funcionalidades = new HashMap<String, OpcionDeMenu>() {
		{
			put("AddFuncionalidad", new AddFuncionalidad());
			put("Calificar", new Calificar());
			put("CrearCurso", new CrearCurso());
			put("CursosDisponibles", new CursosDisponibles());
			put("FinalizeCurso", new FinalizeCurso());
			put("Ingresar", new Ingresar());
			put("Matricular", new Matricular());
			put("Registrar", new Registrar());
			put("RemoveFuncionalidad", new RemoveFuncionalidad());
			put("ResponderSolicitudes", new ResponderSolicitudes());
			put("SolicitarCupo", new SolicitarCupo());
			put("VerAdministradores", new VerAdministrativos());
			put("VerCertificados", new VerCertificados());
			put("VerDocentes", new VerDocentes());
			put("VerEstudiantes", new VerEstudiantes());
			put("VerHorario", new VerHorario());
			put("VerMisSolicitudes", new VerMisSolicitudes());
			put("VerNotas", new VerNotas());
			put("Cerrar", new Cerrar());
			put("UserMenu", new UserMenu());
			put("SystemMenu", new SystemMenu());
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
