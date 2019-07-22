package gestorAplicacion.Usuarios;

import gestorAplicacion.Centro.Archivo;
import uiMain.*;

public class Administrador extends Usuario {
	//Constructor por defecto de administrador
	public Administrador(String name, long id, String email, String password) {
		super(name, id, email, password);	
		
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
		getMenu().anadirOpcion(Main.funcionalidades.get("CerrarSesion"));
	}

	// Menu del sistema
	public String SystemMenu() {
		String aux = "";
		for (String x : Main.funcionalidades.keySet()) {
			aux += ("- " + x + "\n");
		}
		return aux;
	}

	// Menu del Usuario
	public String userSystemMenu(long id) {
		Usuario user = null;
		for (Usuario x : Archivo.getEstudiantes()) {
			if (x.getCedula() == id) {
				user = x;
			}
		}
		for (Usuario x : Archivo.getDocentes()) {
			if (x.getCedula() == id) {
				user = x;
			}
		}
		for (Usuario x : Archivo.getAdministrativos()) {
			if (x.getCedula() == id) {
				user = x;
			}
		}
		if(user!=null) {
			String aux = "";
			int cont = 0;
			for (OpcionDeMenu y : user.getMenu().getList()) {
				aux += (cont + ". " + y + "\n");
				cont++;
			}
			return aux;
		}
		else {
			return "\nUsuario no encontrado.\n";
		}
		
		
	}
}