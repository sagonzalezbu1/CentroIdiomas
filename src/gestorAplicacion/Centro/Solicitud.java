package gestorAplicacion.Centro;

import java.util.ArrayList;

import gestorAplicacion.Usuarios.Estudiante;
/*Esta clase permite crear objetos de tipo solicitud. Las solicitudes se hacen con la finalidad de que un estudiante solicite cupo para un tipo de curso,
  Se puede solicitar cupo en un curso de cualquier tipo de idioma, siempre y cuando no queden cupos o no haya cursos creados de dicho idioma*/

public class Solicitud {
	private Estudiante estu;
	private String tipo;
	
	/*Constructor de solicitud. Las solicitudes tienen al estudiante que la realiza y un String que contiene el tipo de curso al cual solicita el 
	  estudiante. Cuando se crea una solicitud esta inmediatamente se a�ade a  la lista correspondiente del hashmap de archivo, si esa lista aun no existe,
	  se crea automaticamente antes de agregar la solicitud */
	public Solicitud(String tipo, Estudiante e) {
		this.tipo = tipo;
		estu= e;
		if (Archivo.getSolicitudes().containsKey(tipo)) {
			(Archivo.getSolicitudes().get(tipo)).add(this);
		} else {
			Archivo.getSolicitudes().put(tipo, new ArrayList<>());
			(Archivo.getSolicitudes().get(tipo)).add(this);
		}
	}
	
	//Metodo que retorna al estudiante que hizo la solicitud. No recibe ningun parametro
	public Estudiante getEstudiante() {
		return estu;
	}

	//Metodo que retorna un String que contiene el tipo de la solicitud. No recibe ningun parametro
	public String getTipo() {
		return tipo;
	}

	//Metodo toString. Retorna un String con formato correcto que contiene el tipo de la solicitud. No recibe ningun parametro.
	public String toString() {
		return tipo;
	}
}