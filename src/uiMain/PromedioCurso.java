package uiMain;

import java.text.DecimalFormat;
import java.util.Scanner;

import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

public class PromedioCurso extends OpcionDeMenu {
	private String nombre="PromedioCurso";
	public String getNombre() {
		return nombre;
	}
	@Override
	public void ejecutar() {
		Scanner e= new Scanner(System.in);
		System.out.println("Ingrese el nombre del curso: ");
		String nombrec= e.next();
		Curso course= Archivo.buscarCurso(nombrec);
		if(course!=null){
			if(course.getEstudiantes().isEmpty()){
				System.out.println("\nNo hay estudiantes inscritos.\n");
			}else{
				double prom=0;
				for(Estudiante x: course.getEstudiantes()){
					prom+= x.getDefinitiva(nombrec);
				}
				prom= prom/(course.getEstudiantes()).size();
				DecimalFormat f= new DecimalFormat("#.00"); 
				System.out.println("\nEl promedio del curso es: "+ f.format(prom) +"\n");
			}
		}else{
			System.out.println("\nEl curso no existe.\n");
		}
	}

	@Override
	public String toString() {
		return "Promedio de un curso";
	}

}
