package modelo.Usuarios;

import modelo.excepciones.noHayCursos;

/*Interfaz para que implementen las clases Docente y Estudiante.
 * El m�todo miHorario ser� implementado por estas para mostrar 
 * sus respectivos horarios*/
public interface Horario {
	String miHorario() throws noHayCursos;
}
