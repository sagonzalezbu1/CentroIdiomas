package BaseDatos;

import java.io.*;
import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class Data {

	// CARGA DE OBJETOS AL PROGRAMA...
	public static void cargarEstudiantes() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File f = new File(direccion + "estudiantes.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea1;
			while ((linea1 = br.readLine()) != null) {
				String[] usuario = linea1.split(";");
				Estudiante e = new Estudiante(Long.parseLong(usuario[1]), usuario[0], usuario[2], usuario[3]); // Segundo Contructor																								// contructor
				String linea2 = br.readLine();
				String[] cursos = linea2.split(".");
				for (String x : cursos) {
					String[] array = x.split(";");
					Curso curso = Archivo.buscarCurso(array[0]);
					e.addCurso(curso);
					for (int i = 1; i < cursos.length; i++) {
						e.addNota(curso.getNombreCurso(),Float.parseFloat(array[i]));
					}	
				}		
				String linea3 = br.readLine();
				String[] certificados = linea3.split(".");
				for (String x : certificados) {
					String[] array = x.split(";");
					Docente d = Archivo.buscarDocente(Long.parseLong(array[2]));
					float n = Float.parseFloat(array[3]);
					e.addCertificado(new Certificado(array[0],e,d,n));
				}
				String linea4 = br.readLine();
				String[] opciones = linea4.split(";");
				for (String x : opciones) {
					e.getMenu().anadirOpcion(Main.funcionalidades.get(x));
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
			ArrayList<Estudiante> es = Archivo.getEstudiantes();
			String key;
			while ((key = br.readLine()) != null) {
				String values = br.readLine();
				String[] CC = values.split(";");
				for (String cc : CC) {
					for (Estudiante x : es) {
						if (Long.parseLong(cc) == x.getCedula()) {
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

	public static void cargarCursos() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File f = new File(direccion + "cursos.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			int cont = 0;
			String nombrecurso = "";
			while ((linea = br.readLine()) != null) {

				if (cont % 2 == 0) {
					String[] curso = linea.split(";");
					ArrayList<Curso> lista = Archivo.getCursos();
					int aux = 0;
					for (Curso x : lista) {
						if (x.getNombreCurso().equals(curso[0])) {
							aux++;
						}
					}
					if (aux == 0) {
						long aux2 = Long.parseLong(curso[3]);
						Docente aux3 = Archivo.buscarDocente(aux2);
						Curso c = new Curso(curso[0], curso[1], curso[2], aux3);
						aux3.addCurso(c);
						nombrecurso = curso[0];
					}
					cont++;
				} else {
					String[] students = linea.split(";");
					for (String x : students) {
						Estudiante aux4 = Archivo.buscarEstudiante(Long.parseLong(x));
						Curso aux5 = Archivo.buscarCurso(nombrecurso);
						aux4.addCurso(aux5);
					}
					cont++;
				}

			}
			br.close();
		} catch (Exception ex) {
			System.out.println("\nError en carga de curso: " + ex);
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
				pw.write(linea + "\n");
				linea = "";
				HashMap<String, ArrayList<Float>> hash = e.getNotas();
				if (hash.isEmpty()) {
					pw.write("0" + "\n");
				} else {

					for (String x : hash.keySet()) {
						linea = x;
						ArrayList<Float> notas = hash.get(x);
						for (float y : notas) {
							linea += ";" + y;
						}
						linea += ".";
					}
					linea = linea.substring(0, linea.length() - 1);
					pw.write(linea + "\n");
				}
				linea = "";
				ArrayList<Certificado> certificados = e.getCertificados();
				if (certificados.isEmpty()) {
					pw.write("0" + "\n");
				} else {

					for (Certificado x : certificados) {
						linea += x.getNombre() + ";" + x.getAlumno().getCedula() + ";" + x.getDocente().getCedula()
								+ ";" + x.getNota() + ".";
					}
					linea = linea.substring(0, linea.length() - 1);
					pw.write(linea + "\n");
				}
				linea = "";
				ArrayList<OpcionDeMenu> menu = e.getMenu().getList();
				for (OpcionDeMenu x : menu) {
					linea += x.getNombre() + ";";
				}
				linea = linea.substring(0, linea.length() - 1);
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

	public static void escribirCursos() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File f = new File(direccion + "administrativos.txt");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for (Curso c : Archivo.getCursos()) {
				String linea1 = c.getNombreCurso() + ";";
				linea1 += c.getTipo() + ";";
				linea1 += c.getHorarioCurso() + ";";
				linea1 += c.getDocente().getCedula();
				pw.write(linea1 + "\n");
				String linea2 = "";
				for (Estudiante x : c.getEstudiantes()) {
					linea2 += x.getCedula() + ";";
				}
				linea2 = linea2.substring(0, linea2.length() - 1) + "\n";
			}
			pw.close();
		} catch (Exception ex) {
			System.out.println("Error en escritura de cursos: " + ex);

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
				linea = linea.substring(0, linea.length() - 1);
				pw.write(linea + "\n");
			}
			pw.close();
		} catch (Exception ex) {
			System.out.println("Error en escritura de solicitudes: " + ex);
		}
	}

}