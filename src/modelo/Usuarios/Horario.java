package modelo.Usuarios;

import modelo.excepciones.*;

/*Interfaz para que implementen las clases Docente y Estudiante.
 * El método miHorario será implementado por estas para mostrar 
 * sus respectivos horarios*/
public interface Horario {
	String miHorario() throws noHayHorario;
}
