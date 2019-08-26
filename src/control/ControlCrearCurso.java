package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JTextField;

import BaseDatos.Archivo;
import modelo.Centro.*;
import modelo.Usuarios.*;

/*Esta clase es usada por el Administrativo para crear nuevos cursos para los estudiantes.
 * 
 * En esta clase se crean objetos de tipo Curso y se les asignan sus respectivos atributos.*/
public class ControlCrearCurso implements ActionListener {
	private String nombre="CrearCurso";
	public String getNombre() {
		return nombre;
	}
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("CrearCurso")) {
			String tituloCriterios = "Criterio";
			String[] criteriosArray = {"Nombre","Tipo","Profesor","Horario"};
			String tituloValores = "Valores";
			String[] valoresArray = {null,null,null,null};
			boolean[] habilitado = {true,true,true,true};
			Main.ventanaUsuario.formulario(tituloCriterios, criteriosArray, tituloValores, valoresArray, habilitado);
		}
	}
	/*Se hacen verificaciones antes de crear el curso, tales como que éste no exista ya, 
	 * que la información ingresada sea correcta, entre otras cosas, para luego crearlo*/
	

	/*Método toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrará por pantalla en el menú*/
	public String toString() {
		return "Crear Curso";
	}
}