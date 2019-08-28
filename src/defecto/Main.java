package defecto;



import java.util.*;
import BaseDatos.*;
import modelo.Centro.*;
import modelo.Usuarios.*;
import vista.ventanaLogin;
import vista.ventanaUsuario;

/*Esta es la clase principal del programa, donde se ejecuta lo primordial para su
 * funcionamiento*/
public class Main {
	//Se agregan las funcionalidades "principales" de los men�s de los usuarios al HashMap general
	public static HashMap<String, String> funcionalidades = new HashMap<String,String>() {
		{
			put("Calificar", "Calificar");
			put("CrearCurso", "CrearCurso");
			put("VerCursos", "VerCursos");
			put("FinalizeCurso", "FinalizeCurso");
			put("MatricularEstudiante","MatricularEstudiante");
			put("RegistrarEstudiante","RegistrarEstudiante");
			put("RegistrarDocente","RegistrarDocente");
			put("RegistrarAdministrativo","RegistrarAdministrativo");
			put("ResponderSolicitudes","ResponderSolicitudes");
			put("SolicitarCupo", "SolicitarCupo");
			put("SolicitarCupoEstudiante", "SolicitarCupoEstudiante");
			put("VerAdministrativos", "VerAdministrativos");
			put("VerCertificadosEstudiante", "VerCertificadosEstudiante");
			put("VerCertificados", "VerCertificados");
			put("VerDocentes","VerDocentes");
			put("VerTodosLosEstudiantes","VerTodosLosEstudiantes");
			put("VerHorarioDocente", "VerHorarioDocente");
			put("VerHorarioEstudiante", "VerHorarioEstudiante");
			put("VerSolicitudesEstudiante", "VerSolicitudesEstudiante");
			put("VerSolicitudes", "VerSolicitudes");
			put("VerNotasEstudiante", "VerNotasEstudiante");
			put("VerNotas", "VerNotas");
			put("VerEstudiantesCurso","VerEstudiantesCurso");
			put("HacerSugerencia", "HacerSugerencia");
			put("VerSugerencias", "VerSugerencias");
			put("PromedioCurso","PromedioCurso");
			put("Matricular","Matricular");
			put("VerHorario","VerHorario");
			put("SystemMenu","SystemMenu");
			put("VerMenuUsuario","VerMenuUsuario");
		}
	};
	//Se crea un Invitado, usuario al que se ingresar� siempre que se ejecute el programa
	public static Usuario user = new Invitado();
	public static ventanaLogin ventanaLogin = new ventanaLogin();
	public static ventanaUsuario ventanaUsuario = new ventanaUsuario();
	public static Administrador admin = new Administrador();
	public static Data data = new Data();


	//Inicio del programa
	public static void main(String[] args) {
		/* Siempre que se inicie el porgrama se cargar�n los datos de los archivos de 
		 * texto a �ste*/
		data.cargarDocentes();
		data.cargarCursos();
		data.cargarEstudiantes();
		data.cargarAdministrativos();
		data.cargarSolicitudes();
		data.cargarSugerencias();
		

		/*Ejecuci�n del men� de (inicialmente) Invitado y luego de 
		diferentes usuarios a lo largo del programa*/
		
				
	}
}