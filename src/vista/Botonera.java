package vista;

import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import control.*;
import control.controlMenu.*;

public interface Botonera {
	public static HashMap<String, ActionListener> controladores = new HashMap<String, ActionListener>() {
		{
			put("Calificar", new Calificar());
			put("CrearCurso", new ControlCrearCurso());
			put("VerCursos", new VerCursosMenu());
			put("FinalizeCurso", new FinalizeCurso());
			put("Matricular", new Matricular());
			put("Registrar", new Registrar());
			put("ResponderSolicitudes", new ResponderSolicitudes());
			put("SolicitarCupo", new SolicitarCupoMenu());
			put("VerAdministrativos", new VerAdministrativosMenu());
			put("VerCertificados", new VerCertificadosMenu());
			put("VerDocentes", new VerDocentesMenu());
			put("VerTodosLosEstudiantes", new VerTodosLosEstudiantesMenu());
			put("VerHorarioDocente", new VerHorarioDocenteMenu());
			put("VerSolicitudes", new VerSolicitudesMenu());
			put("VerNotasEstudiante", new VerNotasEstudianteMenu());
			put("CerrarSesion", new CerrarSesion());
			put("VerEstudiantesCurso", new VerEstudiantesCursoMenu());
			put("HacerSugerencia", new HacerSugerencia());
			put("VerSugerencias", new VerSugerenciasMenu());
			put("PromedioCurso", new PromedioCurso());
			put("AddFuncionalidad", new AddFuncionalidad());
			put("RemoveFuncionalidad", new RemoveFuncionalidad());
			put("VerMenuUsuario", new VerMenuUsuarioMenu());
			put("SystemMenu", new SystemMenu());
		}
	};
	
	public static HashMap<String, JMenuItem> botones = new HashMap<String, JMenuItem>() {
		{
			put("Calificar", new JMenuItem("Calificar"));
			put("CrearCurso", new JMenuItem("CrearCurso"));
			put("VerCursos", new JMenuItem("VerCursos"));
			put("FinalizeCurso", new JMenuItem("FinalizeCurso"));
			put("Matricular", new JMenuItem("Matricular"));
			put("Registrar", new JMenuItem("Registrar"));
			put("ResponderSolicitudes", new JMenuItem("ResponderSolicitudes"));
			put("SolicitarCupo", new JMenuItem("SolicitarCupo"));
			put("VerAdministrativos", new JMenuItem("VerAdministrativos"));
			put("VerCertificados", new JMenuItem("VerCertificados"));
			put("VerDocentes", new JMenuItem("VerDocentes"));
			put("VerTodosLosEstudiantes", new JMenuItem("VerTodosLosEstudiantes"));
			put("VerHorarioDocente",new JMenuItem("VerHorarioDocente"));
			put("VerSolicitudes", new JMenuItem("VerSolicitudes"));
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
