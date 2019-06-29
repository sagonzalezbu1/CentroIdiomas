
package uiMain;

import java.util.*;
import BaseDatos.*;
import gestorAplicacion.usuarios.*;

public class Main {
	public static Usuario user= new Invitado();
	public static HashMap<String, OpcionDeMenu> funcionalidades = new HashMap<String, OpcionDeMenu>();
	
	public static void main(String[] args) {
		funcionalidades.put("AddFuncionalidad", new AddFuncionalidad());
		funcionalidades.put("Calificar", new Calificar());
		funcionalidades.put("CrearCurso", new CrearCurso());
		funcionalidades.put("CursosDisponibles", new CursosDisponibles());
		funcionalidades.put("FinalizeCurso", new FinalizeCurso());
		funcionalidades.put("Ingresar", new Ingresar());
		funcionalidades.put("Matricular", new Matricular());
		funcionalidades.put("Registrar", new Registrar());
		funcionalidades.put("RemoveFuncionalidad", new RemoveFuncionalidad());
		funcionalidades.put("ResponderSolicitudes", new ResponderSolicitudes());
		funcionalidades.put("SolicitarCupo", new SolicitarCupo());
		funcionalidades.put("VerAdministradores", new VerAdministradores());
		funcionalidades.put("VerCertificados", new VerCertificados());
		funcionalidades.put("VerDocentes", new VerDocentes());
		funcionalidades.put("VerEstudiantes", new VerEstudiantes());
		funcionalidades.put("VerHorario", new VerHorario());
		funcionalidades.put("VerMisSolicitudes", new VerMisSolicitudes());
		funcionalidades.put("VerNotas", new VerNotas());
		funcionalidades.put("Cerrar", new Cerrar());		
		Data.cargarEstudiantes();
		Data.cargarDocentes();
		Data.cargarAdministrativos();
		
		while(true) {
			user.getMenu().lanzarMenu();
		}
	}
}
