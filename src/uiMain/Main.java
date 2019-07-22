package uiMain;

import java.util.*;
import BaseDatos.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

public class Main {
	//Funcionalidades de los menús
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
		}
	};
	//Usuario por defecto, al que se ingresará siempre que se ejecute el programa
	public static Usuario user = new Invitado();
	
	//Inicio del programa
	public static void main(String[] args) {
		//Siempre que se inicie el porgrama se cargarán los datos de los archivos de texto a éste
		Data.cargarDocentes();
		Data.cargarCursos();
		Data.cargarEstudiantes();
		Data.cargarAdministrativos();
		Data.cargarSolicitudes();
		Data.cargarSugerencias();
		//Ejecución completa, ejecuta el menú acorde al tipo de usuario
		while (true) {
			user.getMenu().lanzarMenu();
		}
	}
}