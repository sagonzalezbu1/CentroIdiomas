package uiMain;

import java.util.*;

import gestorAplicacion.usuarios.*;
public class Main {
	public static Usuario user= new Invitado();
	public static void main(String[] args) {
		ArrayList<OpcionDeMenu> funcionalidadess = new ArrayList<OpcionDeMenu>();
		funcionalidadess.add(new AceptarSolicitudes());
		funcionalidadess.add(new AddFuncionalidad());
		funcionalidadess.add(new Calificar());
		funcionalidadess.add(new CrearCurso());
		funcionalidadess.add(new CursosDisponibles());
		funcionalidadess.add(new FinalizeCurso());
		funcionalidadess.add(new Ingresar());
		funcionalidadess.add(new Matricular());
		funcionalidadess.add(new RechazarSolicitudes());
		funcionalidadess.add(new Registrar());
		funcionalidadess.add(new RemoveFuncionalidad());
		funcionalidadess.add(new SolicitarCupo());
		funcionalidadess.add(new VerAdministradores());
		funcionalidadess.add(new VerCertificados());
		funcionalidadess.add(new VerDocentes());
		funcionalidadess.add(new VerEstudiantes());
		funcionalidadess.add(new VerHorario());
		funcionalidadess.add(new VerMisSolicitudes());
		funcionalidadess.add(new VerNotas());
		
		while(true) {
			user.getMenu().lanzarMenu();
		}
	}
}
