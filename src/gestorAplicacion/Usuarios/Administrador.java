package gestorAplicacion.Usuarios;

import gestorAplicacion.Centro.Archivo;
import uiMain.*;

public class Administrador extends Usuario {
	static long cedula;
	static String contrasena;
	public Administrador(String name, long id, String email, String password) {
		super(name, id, email, password);
		
		getMenu().anadirOpcion(Main.funcionalidades.get("AddFuncionalidad"));
		getMenu().anadirOpcion(Main.funcionalidades.get("RemoveFuncionalidad"));
		getMenu().anadirOpcion(Main.funcionalidades.get("UserMenu"));
		getMenu().anadirOpcion(Main.funcionalidades.get("SystemMenu"));
	}

	public String SystemMenu() {
		String aux = "";
		for (String x : Main.funcionalidades.keySet()) {
			aux += ("- " + x + "\n");
		}
		return aux;
	}

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
			return "Usuario no Encontrado";
		}
		
		
	}
}