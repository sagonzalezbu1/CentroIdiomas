package vista;

import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import control.*;
import control.controlMenu.*;

public interface Botonera {
	public static HashMap<String, ActionListener> controladores = new HashMap<String, ActionListener>() {
		{
			put("Calificar", new CalificarMenu());
			put("CrearCurso", new CrearCursoMenu());
			put("VerCursos", new VerCursosMenu());
			put("FinalizeCurso", new FinalizeCursoMenu());
			put("MatricularEstudiante", new MatricularEstudianteMenu());
			put("RegistrarEstudiante", new RegistrarEstudianteMenu());
			put("RegistrarDocente", new RegistrarDocenteMenu());
			put("RegistrarAdministrativo", new RegistrarAdministrativoMenu());
			//put("Registrar", new RegistrarMenu());
			put("ResponderSolicitudes", new ResponderSolicitudesMenu());
			put("SolicitarCupoEstudiante", new SolicitarCupoEstudianteMenu());
			put("VerAdministrativos", new VerAdministrativosMenu());
			put("VerCertificadosEstudiante", new VerCertificadosEstudianteMenu());
			put("VerDocentes", new VerDocentesMenu());
			put("VerTodosLosEstudiantes", new VerTodosLosEstudiantesMenu());
			put("VerHorarioDocente", new VerHorarioDocenteMenu());
			put("VerSolicitudesEstudiante", new VerSolicitudesEstudianteMenu());
			put("VerNotasEstudiante", new VerNotasEstudianteMenu());
			put("CerrarSesion", new CerrarSesionMenu());
			put("VerEstudiantesCurso", new VerEstudiantesCursoMenu());
			put("HacerSugerencia", new HacerSugerenciaMenu());
			put("VerSugerencias", new VerSugerenciasMenu());
			put("PromedioCurso", new PromedioCursoMenu());
			put("AddFuncionalidad", new AddFuncionalidadMenu());
			put("RemoveFuncionalidad", new RemoveFuncionalidadMenu());
			put("VerMenuUsuario", new VerMenuUsuarioMenu());
			put("SystemMenu", new SystemMenu());
			put("VerNotas", new VerNotasMenu());
			put("VerSolicitudes", new VerSolicitudesMenu());
			put("VerCertificados", new VerCertificadosMenu());
			put("Matricular", new MatricularMenu());
			put("VerHorarioEstudiante", new VerHorarioEstudianteMenu());
			put("SolicitarCupo", new SolicitarCupoMenu());
		}
	};
	
	public static HashMap<String, JMenuItem> botones = new HashMap<String, JMenuItem>() {
		{
			put("Calificar", new JMenuItem("Calificar"));
			put("CrearCurso", new JMenuItem("CrearCurso"));
			put("VerCursos", new JMenuItem("VerCursos"));
			put("FinalizeCurso", new JMenuItem("FinalizeCurso"));
			put("MatricularEstudiante", new JMenuItem("MatricularEstudiante"));
			put("RegistrarEstudiante", new JMenuItem("RegistrarEstudiante"));
			put("RegistrarDocente", new JMenuItem("RegistrarDocente"));
			put("RegistrarAdministrativo", new JMenuItem("RegistrarAdministrativo"));
			put("ResponderSolicitudes", new JMenuItem("ResponderSolicitudes"));
			put("SolicitarCupoEstudiante", new JMenuItem("SolicitarCupoEstudiante"));
			put("VerAdministrativos", new JMenuItem("VerAdministrativos"));
			put("VerCertificadosEstudiante", new JMenuItem("VerCertificadosEstudiante"));
			put("VerDocentes", new JMenuItem("VerDocentes"));
			put("VerTodosLosEstudiantes", new JMenuItem("VerTodosLosEstudiantes"));
			put("VerHorarioDocente",new JMenuItem("VerHorarioDocente"));
			put("VerSolicitudesEstudiante", new JMenuItem("VerSolicitudesEstudiante"));
			put("VerNotasEstudiante", new JMenuItem("VerNotasEstudiante"));
			put("CerrarSesion", new JMenuItem("CerrarSesion"));
			put("VerEstudiantesCurso", new JMenuItem("VerEstudiantesCurso"));
			put("HacerSugerencia", new JMenuItem("HacerSugerencia"));
			put("VerSugerencias", new JMenuItem("VerSugerencias"));
			put("PromedioCurso", new JMenuItem("PromedioCurso"));
			put("AddFuncionalidad", new JMenuItem("AddFuncionalidad"));
			put("RemoveFuncionalidad", new JMenuItem("RemoveFuncionalidad"));
			put("VerMenuUsuario", new JMenuItem("VerMenuUsuario"));
			put("SystemMenu", new JMenuItem("SystemMenu"));
			put("VerNotas", new JMenuItem("VerNotas"));
			put("VerSolicitudes", new JMenuItem("VerSolicitudes"));
			put("VerCertificados", new JMenuItem("VerCertificados"));
			put("Matricular", new JMenuItem("Matricular"));
			put("VerHorarioEstudiante", new JMenuItem("VerHorarioEstudiante"));
			put("SolicitarCupo", new JMenuItem("SolicitarCupo"));
		}
	};
	
	public static void addControladores() {
		for (String boton : botones.keySet()) {
			for (String controlador : controladores.keySet()) {
				if (boton.equals(controlador)) {
					botones.get(boton).addActionListener(controladores.get(controlador));
					break;
				}
			}

		}
	}
}
