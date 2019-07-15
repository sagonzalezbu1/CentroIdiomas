package BaseDatos;

import java.io.*;
import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

public class Data {

	// CARGA DE OBJETOS AL PROGRAMA...
	public static void cargarEstudiantes() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File f = new File(direccion + "estudiantes.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] usuario = linea.split(";");
				ArrayList<Estudiante> lista = Archivo.getEstudiantes();
				int aux = 0;
				for (Estudiante x : lista) {
					if (x.getCedula() == Long.parseLong(usuario[1])) {
						aux++;
					}
				}
				if (aux == 0) {
					Estudiante e = new Estudiante(Long.parseLong(usuario[1]), usuario[0], usuario[2], usuario[3]); // Segundo constructor
					String[] solic = usuario[4].split(",");
					for (String x : solic) {
						e.solicitar(x);
					}
				}
			}
			br.close();
		} catch (Exception ex) {
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
			while ((linea = br.readLine()) != null) {
				String[] usuario = linea.split(";");
				ArrayList<Docente> lista = Archivo.getDocentes();
				int aux = 0;
				for (Docente x : lista) {
					if (x.getCedula() == Long.parseLong(usuario[1])) {
						aux++;
					}
				}
				if (aux == 0) {
					Docente d = new Docente(Long.parseLong(usuario[1]), usuario[0], usuario[2], usuario[3]); // Segundo
																												// constructor
				}
			}
			br.close();
		} catch (Exception ex) {
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
			while ((linea = br.readLine()) != null) {
				String[] usuario = linea.split(";");
				ArrayList<Administrativo> lista = Archivo.getAdministrativos();
				int aux = 0;
				for (Administrativo x : lista) {
					if (x.getCedula() == Long.parseLong(usuario[1])) {
						aux++;
					}
				}
				if (aux == 0) {
					Administrativo a = new Administrativo(Long.parseLong(usuario[1]), usuario[0], usuario[2],
							usuario[3]); // Segundo constructor
				}
			}
			br.close();
		} catch (Exception ex) {
			System.out.println("\nError en carga de administrativos: " + ex);
		}
	}

	public static void cargarSolicitudes() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File f = new File(direccion + "solicitudes.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			ArrayList<Estudiante> es= Archivo.getEstudiantes();
			String key;
			while ((key = br.readLine()) != null) {
				String values = br.readLine();
				String[] CC = values.split(";");
				for (String cc : CC) {
					for(Estudiante x: es) {
						if(Long.parseLong(cc)==x.getCedula()) {
							x.solicitar(key);
						}
					}
				}
			}
			br.close();
		} catch (Exception ex) {
			System.out.println("\nError en carga de docentes: " + ex);
		}
	}

	// ESCRITURA DE ARCHIVOS DE TEXTO
	public static void escribirEstudiantes() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File f = new File(direccion + "estudiantes.txt");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for (Estudiante e : Archivo.getEstudiantes()) {
				String linea = e.getNombre() + ";";
				linea += e.getCedula() + ";";
				linea += e.getCorreo() + ";";
				linea += e.getContrasena();
				linea += e.verSolicitudes();
				pw.write(linea + "\n");
			}
			pw.close();
		} catch (Exception ex) {
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
			for (Docente d : Archivo.getDocentes()) {
				String linea = d.getNombre() + ";";
				linea += d.getCedula() + ";";
				linea += d.getCorreo() + ";";
				linea += d.getContrasena();
				pw.write(linea + "\n");
			}
			pw.close();
		} catch (Exception ex) {
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
			for (Administrativo a : Archivo.getAdministrativos()) {
				String linea = a.getNombre() + ";";
				linea += a.getCedula() + ";";
				linea += a.getCorreo() + ";";
				linea += a.getContrasena();
				pw.write(linea + "\n");
			}
			pw.close();
		} catch (Exception ex) {
			System.out.println("Error en escritura de administrativos: " + ex);
		}
	}

	public static void escribirSolicitudes() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File f = new File(direccion + "solicitudes.txt");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for (String key : (Archivo.getSolicitudes()).keySet()) {
				String linea = key + "\n";
				for (Solicitud value : (Archivo.getSolicitudes()).get(key)) {
					linea += value.getEstudiante().getCedula() + ";";
				}
				pw.write(linea + "\n");
			}
			pw.close();
		} catch (Exception ex) {
			System.out.println("Error en escritura de solicitudes: " + ex);
		}
	}

}