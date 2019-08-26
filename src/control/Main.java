package control;

import java.util.*;
import BaseDatos.*;
import modelo.Centro.*;
import modelo.Usuarios.*;
import vista.ventanaLogin;
import vista.ventanaUsuario;

/*Esta es la clase principal del programa, donde se ejecuta lo primordial para su
 * funcionamiento*/
public class Main {
	//Se agregan las funcionalidades "principales" de los menús de los usuarios al HashMap general
	public static HashMap<String, String> funcionalidades = new HashMap<String,String>() {
		{
			put("Calificar", "Calificar");
			put("CrearCurso", "CrearCurso");
			put("VerCursos", "VerCursos");
			put("FinalizeCurso", "FinalizeCurso");
			put("Matricular","Matricular");
			put("Registrar","Registrar");
			put("ResponderSolicitudes","ResponderSolicitudes");
			put("SolicitarCupo", "SolicitarCupo");
			put("VerAdministrativos", "VerAdministrativos");
			put("VerCertificados", "VerCertificados");
			put("VerDocentes","VerDocentes");
			put("VerTodosLosEstudiantes","VerTodosLosEstudiantes");
			put("VerHorario", "VerHorario");
			put("VerSolicitudes", "VerSolicitudes");
			put("VerNotas", "VerNotas");
			put("CerrarSesion", "CerrarSesion");
			put("VerEstudiantesCurso","VerEstudiantesCurso");
			put("HacerSugerencia", "HacerSugerencia");
			put("VerSugerencias", "VerSugerencias");
			put("PromedioCurso","PromedioCurso");
		}
	};
	//Se crea un Invitado, usuario al que se ingresará siempre que se ejecute el programa
	public static Usuario user = new Invitado();
	public static ventanaLogin ventanaLogin = new ventanaLogin();
	public static ventanaUsuario ventanaUsuario = new ventanaUsuario();

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
		
				
	}
}