package BaseDatos;

import java.io.*;
import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.usuarios.*;

public class Data {
	
	//CARGA DE OBJETOS AL PROGRAMA
	public static void cargarEstudiantes() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File f = new File(direccion + "estudiantes.txt");
			FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea = br.readLine()) != null){
                String [] usuario = linea.split(";");
                ArrayList<Estudiante> lista = Archivo.getEstudiantes();
                int aux = 0;
                for(Estudiante x: lista) {
                	if(x.getCedula() == Long.parseLong(usuario[1])) {
                		aux++;
                	}
                }
                if(aux==0) {
                	Estudiante e = new Estudiante(usuario[0], Long.parseLong(usuario[1]), usuario[2], usuario[3]);
                }
            }
            br.close();
        }
		catch(Exception ex) {
            System.out.println("\nError en carga de estudiantes: " + ex);
        }
	}
	
	public static void cargarDocentes() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File f = new File(direccion + "docentes.txt");
			FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea = br.readLine()) != null){
                String [] usuario = linea.split(";");
                ArrayList<Docente> lista = Archivo.getDocentes();
                int aux = 0;
                for(Docente x: lista) {
                	if(x.getCedula() == Long.parseLong(usuario[1])) {
                		aux++;
                	}
                }
                if(aux==0) {
                	Docente d = new Docente(usuario[0], Long.parseLong(usuario[1]), usuario[2], usuario[3]);
                }
            }
            br.close();
        }
		catch(Exception ex) {
            System.out.println("\nError en carga de docentes: " + ex);
        }
	}
	
	public static void cargarAdministrativos() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File f = new File(direccion + "administrativos.txt");
			FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea = br.readLine()) != null){
                String [] usuario = linea.split(";");
                ArrayList<Administrativo> lista = Archivo.getAdministrativos();
                int aux = 0;
                for(Administrativo x: lista) {
                	if(x.getCedula() == Long.parseLong(usuario[1])) {
                		aux++;
                	}
                }
                if(aux==0) {
                	Administrativo a = new Administrativo(usuario[0], Long.parseLong(usuario[1]), usuario[2], usuario[3]);
                }
            }
            br.close();
        }
		catch(Exception ex) {
            System.out.println("\nError en carga de administrativos: " + ex);
        }
	}
	
	//ESCRITURA DE ARCHIVOS DE TEXTO
	public static void escribirEstudiantes() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File f = new File(direccion + "estudiantes.txt");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
			for(Estudiante e: Archivo.getEstudiantes()) {
	            String linea = e.getNombre() + ";";
	            linea += e.getCedula() + ";";
	            linea += e.getCorreo() + ";";
	            linea += e.getContrasena();
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
			File f = new File(direccion + "docentes.txt");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
			for(Docente d: Archivo.getDocentes()) {
	            String linea = d.getNombre() + ";";
	            linea += d.getCedula() + ";";
	            linea += d.getCorreo() + ";";
	            linea += d.getContrasena();
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
			File f = new File(direccion + "administrativos.txt");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
			for(Administrativo a: Archivo.getAdministrativos()) {
	            String linea = a.getNombre() + ";";
	            linea += a.getCedula() + ";";
	            linea += a.getCorreo() + ";";
	            linea += a.getContrasena();
	            pw.write(linea + "\n");
			}
            pw.close();
		}
		catch(Exception ex) {
			System.out.println("Error en escritura de administrativos: " + ex);
		}
	}
}
