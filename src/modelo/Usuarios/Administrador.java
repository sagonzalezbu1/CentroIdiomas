package modelo.Usuarios;

import BaseDatos.Archivo;
import control.*;

/*Esta clase permite la existencia de un Administrador para realizar las tareas "por encima" del programa, 
 * es decir, manejar las funcionalidades que puedan tener los diferentes usuarios y verificar toda la información
 * del centro.*/
public class Administrador extends Usuario {
	/*
	 * Constructor de administrador para asignar los atributos heredados de Usuario
	 * de acuerdo a los que se le asignan al momento de crearse.
	 */
	public Administrador(String name, long id, String email, String password) {
		super(name, id, email, password);
		// Se le añaden todas las funcionalidades del sistema a su menú para así poder
		// manejarlas
		getProcesos().add("AddFuncionalidad");
		getProcesos().add("RemoveFuncionalidad");
		getProcesos().add("UserMenu");
		getProcesos().add("SystemMenu");
		getProcesos().add(Main.funcionalidades.get("Calificar"));
		getProcesos().add(Main.funcionalidades.get("CrearCurso"));
		getProcesos().add(Main.funcionalidades.get("VerCursos"));
		getProcesos().add(Main.funcionalidades.get("FinalizeCurso"));
		getProcesos().add(Main.funcionalidades.get("Matricular"));
		getProcesos().add(Main.funcionalidades.get("Registrar"));
		getProcesos().add(Main.funcionalidades.get("ResponderSolicitudes"));
		getProcesos().add(Main.funcionalidades.get("SolicitarCupo"));
		getProcesos().add(Main.funcionalidades.get("VerAdministrativos"));
		getProcesos().add(Main.funcionalidades.get("VerCertificados"));
		getProcesos().add(Main.funcionalidades.get("VerDocentes"));
		getProcesos().add(Main.funcionalidades.get("VerTodosLosEstudiantes"));
		getProcesos().add(Main.funcionalidades.get("VerHorario"));
		getProcesos().add(Main.funcionalidades.get("VerSolicitudes"));
		getProcesos().add(Main.funcionalidades.get("VerNotas"));
		getProcesos().add(Main.funcionalidades.get("VerEstudiantesCurso"));
		getProcesos().add(Main.funcionalidades.get("HacerSugerencia"));
		getProcesos().add(Main.funcionalidades.get("VerSugerencias"));
		getProcesos().add(Main.funcionalidades.get("PromedioCurso"));
		getProcesos().add(Main.funcionalidades.get("CerrarSesion"));
	}

	// Muestra el menu del sistema, es decir, todas las funcionalidades que tiene el
	// programa
	public String SystemMenu() {
		String aux = "";
		for (String opcion : Main.funcionalidades.keySet()) {
			aux += ("- " + opcion + "\n");
		}
		return aux;
	}

	/*
	 * Muestra el menu del Usuario de acuerdo a su tipo, es decir, el menu que tenga
	 * ese respectivo usuario, en el momento
	 */
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

		if (user != null) {
			String aux = "";
			int cont = 0;
			for (String opcion : user.getProcesos()) {
				aux += (cont + ". " + opcion + "\n");
				cont++;
			}
			return aux;
		} else {
			return "\nUsuario no encontrado.\n";
		}
	}
}