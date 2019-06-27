package BaseDatos;

import java.io.*;
import java.util.*;

import gestorAplicacion.Centro.*;
import gestorAplicacion.usuarios.*;

public class Data {
	
	//CARGA DE OBJETOS A ARCHIVOS DE TEXTO
	public static void cargarEstudiantes() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
            FileReader fr = new FileReader(direccion + "estudiantes.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea = br.readLine()) != null){
                String [] user = linea.split(" ");
                Estudiante e = new Estudiante(user[0], Long.parseLong(user[1]), user[2], user[3]);
            }
            br.close();
        }
		catch(Exception ex) {
            System.out.println("Error en carga de estudiantes: " + ex);
        }
	}
	
	public static void cargarDocentes() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
            FileReader fr = new FileReader(direccion + "docentes.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea = br.readLine()) != null){
                String [] user = linea.split(" ");
                Docente d = new Docente(user[0], Long.parseLong(user[1]), user[2], user[3]);
            }
            br.close();
        }
		catch(Exception ex) {
            System.out.println("Error en carga de docentes: " + ex);
        }
	}
	
	public static void cargarAdministrativos() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
            FileReader fr = new FileReader(direccion + "administrativos.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea = br.readLine()) != null){
                String [] user = linea.split(" ");
                Administrativo a = new Administrativo(user[0], Long.parseLong(user[1]), user[2], user[3]);
            }
            br.close();
        }
		catch(Exception ex) {
            System.out.println("Error en carga de administrativos: " + ex);
        }
	}
	//ESCRITURA ARCHIVOS DE TEXTO
	public static void escribirEstudiantes() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			FileWriter fw = new FileWriter(direccion + "estudiantes.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
			for(Estudiante e: Archivo.getEstudiantes()) {
	            String linea = e.getNombre() + " ";
	            linea += e.getCedula() + " ";
	            linea += e.getCorreo() + " ";
	            linea += e.getContrasena() + " ";
	            pw.write(linea + "\n");
			}
            pw.close();
		}
		catch(Exception ex) {
			System.out.println("Error en escritura de estudiantes: " + ex);
		}
	}
	
	public static void escribirDocentes() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			FileWriter fw = new FileWriter(direccion + "docentes.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
			for(Docente d: Archivo.getDocentes()) {
	            String linea = d.getNombre() + " ";
	            linea += d.getCedula() + " ";
	            linea += d.getCorreo() + " ";
	            linea += d.getContrasena() + " ";
	            pw.write(linea + "\n");
			}
            pw.close();
		}
		catch(Exception ex) {
			System.out.println("Error en escritura de docentes: " + ex);
		}
	}
	
	public static void escribirAdministrativos() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			FileWriter fw = new FileWriter(direccion + "administrativos.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
			for(Administrativo a: Archivo.getAdministrativos()) {
	            String linea = a.getNombre() + " ";
	            linea += a.getCedula() + " ";
	            linea += a.getCorreo() + " ";
	            linea += a.getContrasena() + " ";
	            pw.write(linea + "\n");
			}
            pw.close();
		}
		catch(Exception ex) {
			System.out.println("Error en escritura de administrativos: " + ex);
		}
	}
}
