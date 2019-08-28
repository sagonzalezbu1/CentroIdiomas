package modelo.Usuarios;

import java.util.ArrayList;

import BaseDatos.Archivo;
import BaseDatos.Data;
import control.*;
import defecto.Main;
import modelo.excepciones.*;

/*Esta clase permite la existencia de un Administrador para realizar las tareas "por encima" del programa, 
 * es decir, manejar las funcionalidades que puedan tener los diferentes usuarios y verificar toda la información
 * del centro.*/
public class Administrador extends Usuario {
	private String[] funcionalidadesDocentes = { "Calificar", "CrearCurso", "VerCursos", "FinalizeCurso",
			"MatricularEstudiante", "RegistrarDocente", "RegistarAdministrativo", "RegistarEstudiante",
			"ResponderSolicitudes", "SolicitarCupoEstudiante", "VerAdministrativos", "VerCertificadoEstudiante",
			"VerDocentes", "VerTodosLosEstudiantes", "VerSolicitudesEstudiante", "VerNotasEstudiante",
			"VerEstudiantesCurso", "HacerSugerencia", "VerSugerencias", "PromedioCurso", "VerHorarioEstudiante",
			"VerHorario", "SystemMenu", "VerMenuUsuario" };
	private String[] funcionalidadesEstudiantes = { "Calificar", "CrearCurso", "VerCursos", "FinalizeCurso",
			"MatricularEstudiante", "RegistrarDocente", "RegistarAdministrativo", "RegistarEstudiante",
			"ResponderSolicitudes", "SolicitarCupoEstudiante", "VerAdministrativos", "VerCertificadoEstudiante",
			"VerDocentes", "VerTodosLosEstudiantes", "VerSolicitudesEstudiante", "VerNotasEstudiante",
			"VerEstudiantesCurso", "HacerSugerencia", "VerSugerencias", "PromedioCurso", "VerHorarioEstudiante",
			"VerHorario", "VerNotas", "VerCertificados", "VerSolicitudes", "Matricular", "SystemMenu",
			"VerMenuUsuario" };
	private String[] funcionalidadesAdministrativos = { "Calificar", "CrearCurso", "VerCursos", "FinalizeCurso",
			"MatricularEstudiante", "RegistrarDocente", "RegistarAdministrativo", "RegistarEstudiante",
			"ResponderSolicitudes", "SolicitarCupoEstudiante", "VerAdministrativos", "VerCertificadoEstudiante",
			"VerDocentes", "VerTodosLosEstudiantes", "VerSolicitudesEstudiante", "VerNotasEstudiante",
			"VerEstudiantesCurso", "HacerSugerencia", "VerSugerencias", "PromedioCurso", "VerHorarioEstudiante",
			"SystemMenu", "VerMenuUsuario" };

	/*
	 * Constructor de administrador para asignar los atributos heredados de Usuario
	 * de acuerdo a los que se le asignan al momento de crearse.
	 */
	public Administrador() {
		super("Jaime Guzman", (long) 123, "admin@cdi.com", "123");
		// Se le añaden todas las funcionalidades del sistema a su menú para así poder
		// manejarlas
		getProcesos().add("AddFuncionalidad");
		getProcesos().add("RemoveFuncionalidad");
		getProcesos().add("VerMenuUsuario");
		getProcesos().add("SystemMenu");
		getProcesos().add(Main.funcionalidades.get("Calificar"));
		getProcesos().add(Main.funcionalidades.get("CrearCurso"));
		getProcesos().add(Main.funcionalidades.get("VerCursos"));
		getProcesos().add(Main.funcionalidades.get("FinalizeCurso"));
		getProcesos().add(Main.funcionalidades.get("MatricularEstudiante"));
		getProcesos().add(Main.funcionalidades.get("RegistrarEstudiante"));
		getProcesos().add(Main.funcionalidades.get("RegistrarDocente"));
		getProcesos().add(Main.funcionalidades.get("RegistrarAdministrativo"));
		getProcesos().add(Main.funcionalidades.get("ResponderSolicitudes"));
		getProcesos().add(Main.funcionalidades.get("SolicitarCupoEstudiante"));
		getProcesos().add(Main.funcionalidades.get("VerAdministrativos"));
		getProcesos().add(Main.funcionalidades.get("VerCertificadosEstudiante"));
		getProcesos().add(Main.funcionalidades.get("VerDocentes"));
		getProcesos().add(Main.funcionalidades.get("VerTodosLosEstudiantes"));
		getProcesos().add(Main.funcionalidades.get("VerHorarioDocente"));
		getProcesos().add(Main.funcionalidades.get("VerHorarioEstudiante"));
		getProcesos().add(Main.funcionalidades.get("VerSolicitudesEstudiante"));
		getProcesos().add(Main.funcionalidades.get("VerNotasEstudiante"));
		getProcesos().add(Main.funcionalidades.get("VerEstudiantesCurso"));
		getProcesos().add(Main.funcionalidades.get("HacerSugerencia"));
		getProcesos().add(Main.funcionalidades.get("VerSugerencias"));
		getProcesos().add(Main.funcionalidades.get("PromedioCurso"));
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
	public String userSystemMenu(long id) throws NoExisteUsuario {
		Usuario user = Administrador.buscarUsuario(id);
		String aux = "";
		int cont = 0;
		for (String opcion : user.getProcesos()) {
			aux += (cont + ". " + opcion + "\n");
			cont++;
		}
		return aux;

	}

	public String removerFuncionalidad(long CC, String opcion) throws NoExisteUsuario, FuncionalidadIncorrecta {

		Usuario user = Administrador.buscarUsuario(CC);
		ArrayList<String> menu = user.getProcesos();

		for (String op : menu) {
			if (op.equals(opcion) && !op.equals("CerrarSesion")) {
				menu.remove(op);
				return "La opcion de menu fue eliminada con exito.";
			}
		}
		throw new FuncionalidadIncorrecta();

	}
	
	static public void verificarUsuario(long cc, String pass) throws NoExisteUsuario, LoginInvalido {
		if (Administrador.buscarUser(cc).getContrasena().equals(pass)) {
			return;
		}
		throw new LoginInvalido();
	}
	
	static public String ingresarUsuario(long cc, String pass) {
		try {
			Usuario usuario = Administrador.buscarUser(cc);
			Administrador.verificarUsuario(cc, pass);
			Main.user = usuario;
			return "Se ha iniciado sesion.";
		} catch (NoExisteUsuario exception1) {
			return "Usuario Incorrecto";

		} catch (LoginInvalido exception2) {
			return "Clave Incorrecta.";
		}
	}
	
	static public Administrador buscarAdministrador(long cc) throws NoExisteAdministrador {
		if (Main.admin.getCedula() == cc) {
			return Main.admin;
		}
		throw new NoExisteAdministrador();
	}
	
	static public void salir() {
		Data.guardarDatos();
		System.exit(0);
	}

	public String addFuncionalidad(long CC, String opcion) {
		try {
			Usuario user = Administrador.buscarUsuario(CC);
			ArrayList<String> menu = user.getProcesos();
			
			for (String op : menu) {
					if (op.equals(opcion)) {
						return "El usuario ya cuenta con esa opcion.";
					}
				}
			
			if (user instanceof Estudiante) {
				
				for (int i = 0; i < funcionalidadesEstudiantes.length; i++) {
					if (funcionalidadesEstudiantes[i].equals(opcion) && !opcion.equals("CerrarSesion")) {
						menu.add(opcion);
						return "Se ha añadido la opcion correctamente.";
					}
				}
				
				return "Opcion invalida.";
			} else if (user instanceof Docente) {
				
				for (int i = 0; i < funcionalidadesDocentes.length; i++) {
					if (funcionalidadesDocentes[i].equals(opcion) && !opcion.equals("CerrarSesion")) {
						menu.add(opcion);
						return "Se ha añadido la opcion correctamente.";
					}
				}
				
				return "Opcion invalida.";
			} else if (user instanceof Administrativo) {
				
				for (int i = 0; i < funcionalidadesAdministrativos.length; i++) {
					if (funcionalidadesAdministrativos[i].equals(opcion) && !opcion.equals("CerrarSesion")) {
						menu.add(opcion);
						return "Se ha añadido la opcion correctamente.";
					}
				}
				
				return "Opcion invalida.";
			}else {
				return "No es un usuario.";
			}
		} catch (NoExisteUsuario excepcion) {
			return "El usuario no esta registrado.";
		}
	}
	
	
	/*
	 * Busca un usuario en las lista de estudiante,docente y administrativo por su
	 * cedula, recibe como parametro la cedula del usaurio a encontrar y retorna el
	 * usuario en caso de que lo encuentre, si no lo encuentra retornara null
	 */
	static public Usuario buscarUsuario(long id) throws NoExisteUsuario {
		try {
			if (id == 123) {
				return new Administrador();
			}
			return Administrativo.buscarAdministrativo(id);
		} catch (NoExisteAdministrativo excepcion1) {
			try {
				return Docente.buscarDocente(id);
			} catch (NoExisteDocente excepcion2) {
				try {
					return Estudiante.buscarEstudiante(id);
				} catch (NoExisteEstudiante excepcion3) {
					throw new NoExisteUsuario();
				}
			}

		}
	}
	
	static public Usuario buscarUser(long id) throws NoExisteUsuario {
		try {
			return Administrativo.buscarAdministrativo(id);
		} catch (NoExisteAdministrativo excepcion1) {
			try {
				return Docente.buscarDocente(id);
			} catch (NoExisteDocente excepcion2) {
				try {
					return Estudiante.buscarEstudiante(id);
				} catch (NoExisteEstudiante excepcion3) {
					throw new NoExisteUsuario();
				}
			}
		}
	}

	public String registrarAdministrativo(String name, String apellido, long CC, String correo, String pass,
			String codigo) {
		try {
			Usuario user = Administrador.buscarUsuario(CC);
			return "Ya se encuentra registrado un usuario.";
		} catch (NoExisteUsuario excepcion) {
			if (codigo.equals("1234")) {
				new Administrativo(name + " " + apellido, CC, correo, pass);
				return "Se ha registrado el administrativo exitosamente.";
			} else {
				return "Codigo incorrecto.";
			}
		}

	}

	public String registrarDocente(String name, String apellido, long CC, String correo, String pass, String codigo) {
		try {
			Usuario user = Administrador.buscarUsuario(CC);
			return "Ya se encuentra registrado un usuario.";
		} catch (NoExisteUsuario excepcion) {
			if (codigo.equals("0000")) {
				new Docente(name + " " + apellido, CC, correo, pass);
				return "Se ha registrado el docente exitosamente.";
			} else {
				return "Codigo incorrecto.";
			}
		}

	}

	public String registrarEstudiante(String name, String apellido, long CC, String correo, String pass) {
		try {
			Usuario user = Administrador.buscarUsuario(CC);
			return "Ya se encuentra registrado un usuario.";
		} catch (NoExisteUsuario excepcion) {
			new Estudiante(name + " " + apellido, CC, correo, pass);
			return "Se ha registrado el estudiante exitosamente.";
		}
	}

	public String funcionalidadesDocentes() {
		String fDocentes = "Las funcionalidades docentes: " + funcionalidadesDocentes[0];
		for (int i = 1; i < funcionalidadesDocentes.length; i++) {
			fDocentes += ", " + funcionalidadesDocentes[i];
		}
		return fDocentes;
	}

	public String funcionalidadesEstudiantes() {
		String fEstudiantes = "Las funcionalidades Estudiantes: " + funcionalidadesEstudiantes[0];
		for (int i = 1; i < funcionalidadesEstudiantes.length; i++) {
			fEstudiantes += ", " + funcionalidadesEstudiantes[i];
		}
		return fEstudiantes;
	}

	public String funcionalidadesAdministrativos() {
		String fAdministrativos = "Las funcionalidades Administrativos: " + funcionalidadesAdministrativos[0];
		for (int i = 1; i < funcionalidadesAdministrativos.length; i++) {
			fAdministrativos += ", " + funcionalidadesAdministrativos[i];
		}
		return fAdministrativos;
	}

	public String[] getFuncionalidadesDocentes() {
		return funcionalidadesDocentes;
	}

	public String[] getFuncionalidadesEstudiantes() {
		return funcionalidadesEstudiantes;
	}

	public String[] getFuncionalidadesAdministrativos() {
		return funcionalidadesAdministrativos;
	}
	static public String ingresarAdmin(long cc, String pass) {
		try {
			Usuario usuario = Archivo.buscarAdministrador(cc);
			Administrador.verificarAdministrador(cc, pass);
			Main.user = usuario;
			return "Se ha iniciado sesion.";
		} catch (NoExisteAdministrador exception1) {
			return "Usuario Incorrecto.";
		} catch (LoginInvalido exception2) {
			return "Clave Incorrecta.";
		}
	}
}