package uiMain;

import java.util.*;
import BaseDatos.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

public class Main {
	// Funcionalidades de los men�s
	public static HashMap<String, OpcionDeMenu> funcionalidades = new HashMap<String, OpcionDeMenu>() {
		{
			put("Calificar", new Calificar());
			put("CrearCurso", new CrearCurso());
			put("VerCursos", new VerCursos());
			put("FinalizeCurso", new FinalizeCurso());
			put("Matricular", new Matricular());
			put("Registrar", new Registrar());
			put("ResponderSolicitudes", new ResponderSolicitudes());
			put("SolicitarCupo", new SolicitarCupo());
			put("VerAdministrativos", new VerAdministrativos());
			put("VerCertificados", new VerCertificados());
			put("VerDocentes", new VerDocentes());
			put("VerTodosLosEstudiantes", new VerTodosLosEstudiantes());
			put("VerHorario", new VerHorario());
			put("VerSolicitudes", new VerSolicitudes());
			put("VerNotas", new VerNotas());
			put("CerrarSesion", new CerrarSesion());
			put("VerEstudiantesCurso", new VerEstudiantesCurso());
			put("HacerSugerencia", new HacerSugerencia());
			put("VerSugerencias", new VerSugerencias());
			put("PromedioCurso", new PromedioCurso());
		}
	};
	// Usuario por defecto, al que se ingresar� siempre que se ejecute el programa
	public static Usuario user = new Invitado();

	// Inicio del programa
	public static void main(String[] args) {
		// Siempre que se inicie el porgrama se cargar�n los datos de los archivos de
		// texto a �ste
		Data.cargarDocentes();
		Data.cargarCursos();
		Data.cargarEstudiantes();
		Data.cargarAdministrativos();
		Data.cargarSolicitudes();
		Data.cargarSugerencias();
		// Ejecuci�n completa, ejecuta el men� acorde al tipo de usuario
		try {
			while (true) {
				user.getMenu().lanzarMenu();
			}
		} catch (Exception ex) {
			System.out.println("\nHubo algun error en la escritura.\n");

		}
	}
}