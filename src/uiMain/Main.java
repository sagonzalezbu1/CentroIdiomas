package uiMain;

import java.util.*;
import BaseDatos.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

public class Main {
	//Funcionalidades de los men�s
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
	//Usuario por defecto, al que se ingresar� siempre que se ejecute el programa
	public static Usuario user = new Invitado();
	
	//Inicio del programa
	public static void main(String[] args) {
		//Siempre que se inicie el porgrama se cargar�n los datos de los archivos de texto a �ste
		Data.cargarDocentes();
		Data.cargarEstudiantes();
		Data.cargarCursos();
		Data.cargarAdministrativos();
		Data.cargarSolicitudes();
		//Ejecuci�n completa, ejecuta el men� acorde al tipo de usuario
		while (true) {
			user.getMenu().lanzarMenu();
		}
	}
}