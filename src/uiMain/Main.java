package uiMain;

import java.util.*;
import BaseDatos.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

/*Esta es la clase principal del programa, donde se ejecuta lo primordial para su
 * funcionamiento*/
public class Main {
	//Se agregan las funcionalidades "principales" de los menús de los usuarios al HashMap general
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
	//Se crea un Invitado, usuario al que se ingresará siempre que se ejecute el programa
	public static Usuario user = new Invitado();

	//Inicio del programa
	public static void main(String[] args) {
		/* Siempre que se inicie el porgrama se cargarán los datos de los archivos de 
		 * texto a éste*/
		Data.cargarDocentes();
		Data.cargarCursos();
		Data.cargarEstudiantes();
		Data.cargarAdministrativos();
		Data.cargarSolicitudes();
		Data.cargarSugerencias();

		/*Ejecución del menú de (inicialmente) Invitado y luego de 
		diferentes usuarios a lo largo del programa*/
		
		while (true) {
			user.getMenu().lanzarMenu();
		}
		
	}
}