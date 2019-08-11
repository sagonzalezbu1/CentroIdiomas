package gestorAplicacion.Usuarios;

import BaseDatos.Archivo;
import uiMain.*;

/*Esta clase permite la existencia de un Administrador para realizar las tareas "por encima" del programa, 
 * es decir, manejar las funcionalidades que puedan tener los diferentes usuarios y verificar toda la información
 * del centro.*/
public class Administrador extends Usuario {
	/*Constructor de administrador para asignar los atributos heredados de Usuario de acuerdo a los
	* que se le asignan al momento de crearse.*/
	public Administrador(String name, long id, String email, String password) {
		super(name, id, email, password);	
		//Se le añaden todas las funcionalidades del sistema a su menú para así poder manejarlas
		getMenu().anadirOpcion(new AddFuncionalidad());
		getMenu().anadirOpcion(new RemoveFuncionalidad());
		getMenu().anadirOpcion(new UserMenu());
		getMenu().anadirOpcion(new SystemMenu());
		getMenu().anadirOpcion(Main.funcionalidades.get("Calificar"));
		getMenu().anadirOpcion(Main.funcionalidades.get("CrearCurso"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerCursos"));
		getMenu().anadirOpcion(Main.funcionalidades.get("FinalizeCurso"));
		getMenu().anadirOpcion(Main.funcionalidades.get("Matricular"));
		getMenu().anadirOpcion(Main.funcionalidades.get("Registrar"));
		getMenu().anadirOpcion(Main.funcionalidades.get("ResponderSolicitudes"));
		getMenu().anadirOpcion(Main.funcionalidades.get("SolicitarCupo"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerAdministrativos"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerCertificados"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerDocentes"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerTodosLosEstudiantes"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerHorario"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerSolicitudes"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerNotas"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerEstudiantesCurso"));
		getMenu().anadirOpcion(Main.funcionalidades.get("HacerSugerencia"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerSugerencias"));
		getMenu().anadirOpcion(Main.funcionalidades.get("PromedioCurso"));
		getMenu().anadirOpcion(Main.funcionalidades.get("CerrarSesion"));
	}

	//Muestra el menu del sistema, es decir, todas las funcionalidades que tiene el programa
	public String SystemMenu() {
		String aux = "";
		for (String opcion : Main.funcionalidades.keySet()) {
			aux += ("- " + opcion + "\n");
		}
		return aux;
	}

	/*Muestra el menu del Usuario de acuerdo a su tipo, es decir, 
	 * el menu que tenga ese respectivo usuario, en el momento*/
	public String userSystemMenu(long id) {
		Usuario user = null;
		
		for (Usuario usuario : Archivo.getEstudiantes()) {
			if (usuario.getCedula() == id) {
				user = usuario;
			}
		}
		
		for (Usuario usuario : Archivo.getDocentes()) {
			if (usuario.getCedula() == id) {
				user = usuario;
			}
		}
		
		for (Usuario usuario : Archivo.getAdministrativos()) {
			if (usuario.getCedula() == id) {
				user = usuario;
			}
		}
		
		if(user!=null) {
			String aux = "";
			int cont = 0;
			for (OpcionDeMenu opcion : user.getMenu().getList()) {
				aux += (cont + ". " + opcion + "\n");
				cont++;
			}
			return aux;
		}
		else {
			return "\nUsuario no encontrado.\n";
		}
		
		
	}
}