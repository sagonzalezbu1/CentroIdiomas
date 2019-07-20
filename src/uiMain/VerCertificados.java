package uiMain;

import java.util.Scanner;
import gestorAplicacion.Centro.Archivo;
import gestorAplicacion.Usuarios.*;

public class VerCertificados extends OpcionDeMenu{
	private String nombre="VerCertificados";
	public String getNombre() {
		return nombre;
	}
	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		//Verifica qué tipo de usuario verá los certificados
		if(Main.user instanceof Estudiante) {
			//Si es estudiante muestra sus certificados
			String aux = ((Estudiante)Main.user).verCertificados();
			if(aux.equals("")){
				System.out.println("usted no tiene certificados");
			}else {
				System.out.println(aux);
			}
		}
		else {
			System.out.println("Introduzca el ID del estudiante del que quiere ver los certificados");
			long ID = entry.nextLong();
			Estudiante e = Archivo.buscarEstudiante(ID);
			if(e==null) {
				System.out.println("Este estudiante no esta registrado");
			}else {
				String aux = e.verCertificados();
				if(aux.equals("")){
					System.out.println("Este estudiante no tiene certificados");
				}else {
					System.out.println(aux);
				}
			}
			
		}	
	}
	public String toString() {
		return "Mis Certificados";
	}
}
