package BaseDatos;

import java.io.*;
import java.util.*;

import control.Main;
import control.OpcionDeMenu;
import modelo.Centro.*;
import modelo.Usuarios.*;

/* La finalidad de la clase Data es lograr la escritura y carga de los archivos de texto en los que se guarda la informacion de nuestro programa.
 * Para posibles problemas con la lectura y escritura, todos sus metodos se ejecutan en un bloque try - catch */

public class Data {

	// cargarEstudiantes se encarga de leer el archivo estudiantes.txt y cargar en
	// memoria a los estudiantes. No recibe ningun parametro y tampoco retorna nada
	
	public static void cargarDatos() {
		cargarDocentes();
		cargarCursos();
		cargarEstudiantes();
		cargarAdministrativos();
		cargarSolicitudes();
		cargarSugerencias();
	}
	public static void guardarDatos() {
		escribirDocentes();
		escribirEstudiantes();
		escribirAdministrativos();
		escribirSolicitudes();
		escribirCursos();
		escribirSugerencias();
	}
	
	public static void cargarEstudiantes() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File file = new File(direccion + "estudiantes.txt");
			FileReader filer = new FileReader(file);
			BufferedReader br = new BufferedReader(filer);
			String linea1;
			while ((linea1 = br.readLine()) != null) {
				String[] usuario = linea1.split(";");
				Estudiante estudiante = new Estudiante(Long.parseLong(usuario[1]), usuario[0], usuario[2], usuario[3]); // Segundo
																														// constructor
				String linea2 = br.readLine();

				if (!linea2.equals("0")) {
					String[] cursos = linea2.split("-");

					for (String course : cursos) {
						String[] array = course.split(";");
						Curso curso = Archivo.buscarCurso(array[0]);
						curso.matricular(estudiante);

						for (int i = 1; i < array.length; i++) {
							float nota = Float.parseFloat(array[i]);
							estudiante.addNota(curso, nota);
						}

					}

				}

				String linea3 = br.readLine();
				if (!linea3.equals("0")) {
					String[] certificados = linea3.split("-");

					for (String certificado : certificados) {
						String[] array = certificado.split(";");
						Docente docente = Archivo.buscarDocente(Long.parseLong(array[2]));
						float nota = Float.parseFloat(array[3]);
						estudiante.addCertificado(new Certificado(array[0], estudiante, docente, nota));
					}

				}

				String linea4 = br.readLine();
				String[] opciones = linea4.split(";");

				for (String opcion : opciones) {
					estudiante.getProcesos().add(Main.funcionalidades.get(opcion));
				}

			}

			br.close();
		} catch (Exception ex) {
			System.out.println("\nError en carga de estudiantes: " + ex);
		}

	}

	// cargarDocentes se encarga de leer el archivo docentes.txt y cargar en memoria
	// a los docentes. No recibe ningun parametro y tampoco retorna nada
	public static void cargarDocentes() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File file = new File(direccion + "docentes.txt");
			FileReader filer = new FileReader(file);
			BufferedReader br = new BufferedReader(filer);
			String linea;
			int cont = 0;
			long cedula = 0;

			while ((linea = br.readLine()) != null) {

				if (cont % 2 == 0) {
					String[] usuario = linea.split(";");
					ArrayList<Docente> lista = Archivo.getDocentes();
					int aux = 0;

					for (Docente docente : lista) {
						if (docente.getCedula() == Long.parseLong(usuario[1])) {
							aux++;
						}
					}

					if (aux == 0) {
						cedula = Long.parseLong(usuario[1]);
						new Docente(cedula, usuario[0], usuario[2], usuario[3]); // Segundo constructor
					}

					cont++;
				} else {
					Docente docente = Archivo.buscarDocente(cedula);
					String[] menu = linea.split(";");
					for (String opcion : menu) {
						docente.getProcesos().add(Main.funcionalidades.get(opcion));
					}
					cont++;
				}
			}

			br.close();
		} catch (Exception ex) {
			System.out.println("\nError en carga de docentes: " + ex);
		}
	}

	// cargarAdministrativos se encarga de leer el archivo administrativos.txt y
	// cargar en memoria a los administrativos. No recibe ningun parametro y tampoco
	// retorna nada
	public static void cargarAdministrativos() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File file = new File(direccion + "administrativos.txt");
			FileReader filer = new FileReader(file);
			BufferedReader br = new BufferedReader(filer);
			String linea;
			int cont = 0;
			long cedula = 0;

			while ((linea = br.readLine()) != null) {

				if (cont % 2 == 0) {
					String[] usuario = linea.split(";");
					ArrayList<Administrativo> administrativos = Archivo.getAdministrativos();
					int aux = 0;

					for (Administrativo administrativo : administrativos) {
						if (administrativo.getCedula() == Long.parseLong(usuario[1])) {
							aux++;
						}
					}

					if (aux == 0) {
						cedula = Long.parseLong(usuario[1]);
						new Administrativo(cedula, usuario[0], usuario[2], usuario[3]); // Segundo constructor
					}

					cont++;
				} else {
					Administrativo administrativo = Archivo.buscarAdministrativo(cedula);
					String[] menu = linea.split(";");

					for (String opcion : menu) {
						administrativo.getProcesos().add(Main.funcionalidades.get(opcion));
					}

					cont++;
				}
			}

			br.close();
		} catch (Exception ex) {
			System.out.println("\nError en carga de administrativos: " + ex);
		}

	}

	/*
	 * cargarSolicitudes se encarga de leer el archivo solicitudes.txt y cargar en
	 * memoria a las solicitudes, estas son realizadas por estudiantes pero dado que
	 * las trabajamos como otro objeto y tiene conexiones con administrativo,
	 * decidimos hacerle un archivo aparte. No recibe ningun parametro y tampoco
	 * retorna nada
	 */
	public static void cargarSolicitudes() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File file = new File(direccion + "solicitudes.txt");
			FileReader filer = new FileReader(file);
			BufferedReader br = new BufferedReader(filer);
			ArrayList<Estudiante> estudiantes = Archivo.getEstudiantes();
			String key;

			while ((key = br.readLine()) != null) {
				String values = br.readLine();
				String[] CC = values.split(";");

				for (String cc : CC) {

					for (Estudiante estudiante : estudiantes) {

						if (Long.parseLong(cc) == estudiante.getCedula()) {
							estudiante.solicitar(key);
						}

					}

				}

			}

			br.close();
		} catch (Exception ex) {
			System.out.println("\nError en carga de solicitudes: " + ex);
		}

	}

	// cargarCursos se encarga de leer el archivo cursos.txt y cargar en memoria a
	// los cursos. No recibe ningun parametro y tampoco retorna nada
	public static void cargarCursos() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File file = new File(direccion + "cursos.txt");
			FileReader filer = new FileReader(file);
			BufferedReader br = new BufferedReader(filer);
			String linea;

			while ((linea = br.readLine()) != null) {
				String[] curso = linea.split(";");
				ArrayList<Curso> cursos = Archivo.getCursos();
				int aux = 0;

				for (Curso course : cursos) {
					if (course.getNombreCurso().equals(curso[0])) {
						aux++;
					}
				}

				if (aux == 0) {
					long aux2 = Long.parseLong(curso[3]);
					Docente docente = Archivo.buscarDocente(aux2);
					new Curso(curso[0], curso[1], curso[2], docente);
					// Hasta acá
				}

			}
			br.close();
		} catch (Exception ex) {
			System.out.println("\nError en carga de cursos: " + ex);
		}

	}

	// cargarSugerencias se encarga de leer el archivo sugerencias.txt y cargar en
	// memoria a las sugerencias. No recibe ningun parametro y tampoco retorna nada
	public static void cargarSugerencias() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File file = new File(direccion + "sugerencias.txt");
			FileReader filer = new FileReader(file);
			BufferedReader br = new BufferedReader(filer);
			String linea;

			while ((linea = br.readLine()) != null) {
				String[] sugerencia = linea.split("°");
				Usuario usuario = Archivo.buscarUsuario(Long.parseLong(sugerencia[0]));

				if (usuario != null) {
					new Sugerencia(usuario, sugerencia[1]);
				} else {
					new Sugerencia(Archivo.getAdministrador(), sugerencia[1]);
				}

			}

			br.close();
		} catch (Exception ex) {
			System.out.println("\nError en carga de sugerencias: " + ex);
		}

	}

	/*
	 * escribirEstudiantes se encarga de escribir con formato correcto a los
	 * estudiantes en el archivo de texto estudiantes.txt para posteriormente ser
	 * leido por el metodo cargarEstudiantes. No recibe nada ni retorna nada
	 */
	public static void escribirEstudiantes() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File file = new File(direccion + "estudiantes.txt");
			FileWriter filew = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(filew);
			PrintWriter pw = new PrintWriter(bw);

			for (Estudiante estudiante : Archivo.getEstudiantes()) {
				String linea = estudiante.getNombre() + ";";
				linea += estudiante.getCedula() + ";";
				linea += estudiante.getCorreo() + ";";
				linea += estudiante.getContrasena();
				pw.write(linea + "\n");
				linea = "";
				HashMap<String, ArrayList<Float>> hash = estudiante.getNotas();

				if (hash.isEmpty()) {
					pw.write("0" + "\n");
				} else {

					for (String curso : hash.keySet()) {
						linea += curso;
						ArrayList<Float> notas = hash.get(curso);

						for (float nota : notas) {
							linea += ";" + nota;
						}

						linea += "-";
					}

					linea = linea.substring(0, linea.length() - 1);
					pw.write(linea + "\n");
				}

				linea = "";
				ArrayList<Certificado> certificados = estudiante.getCertificados();

				if (certificados.isEmpty()) {
					pw.write("0" + "\n");
				} else {

					for (Certificado certificado : certificados) {
						linea += certificado.getNombre() + ";" + certificado.getAlumno().getCedula() + ";"
								+ certificado.getDocente().getCedula() + ";" + certificado.getNota() + "-";
					}

					linea = linea.substring(0, linea.length() - 1);
					pw.write(linea + "\n");

				}

				linea = "";
				ArrayList<String> menu = estudiante.getProcesos();

				for (String opcion : menu) {
					linea += opcion + ";";
				}

				linea = linea.substring(0, linea.length() - 1);
				pw.write(linea + "\n");
			}

			pw.close();
		} catch (Exception ex) {
			System.out.println("Error en escritura de estudiantes: " + ex);
		}

	}

	/*
	 * escribirDocentes se encarga de escribir con formato correcto a los docentes
	 * en el archivo de texto docentes.txt para posteriormente ser leido por el
	 * metodo cargarDocentes. No recibe nada ni retorna nada.
	 */
	public static void escribirDocentes() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File file = new File(direccion + "docentes.txt");
			FileWriter filew = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(filew);
			PrintWriter pw = new PrintWriter(bw);

			for (Docente docente : Archivo.getDocentes()) {
				String linea1 = "";
				linea1 += docente.getNombre() + ";";
				linea1 += docente.getCedula() + ";";
				linea1 += docente.getCorreo() + ";";
				linea1 += docente.getContrasena();
				pw.write(linea1 + "\n");

				String linea2 = "";
				ArrayList<String> menu = docente.getProcesos();

				for (String opcion : menu) {
					linea2 += opcion + ";";
				}

				linea2 = linea2.substring(0, linea2.length() - 1);
				pw.write(linea2 + "\n");

			}
			pw.close();
		} catch (Exception ex) {
			System.out.println("Error en escritura de docentes: " + ex);
		}

	}

	/*
	 * escribirAdministrativos se encarga de escribir con formato correcto a los
	 * administrativos en el archivo de texto administrativos.txt para
	 * posteriormente ser leido por el metodo cargarAdministrativos. No recibe nada
	 * ni retorna nada
	 */
	public static void escribirAdministrativos() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File file = new File(direccion + "administrativos.txt");
			FileWriter filew = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(filew);
			PrintWriter pw = new PrintWriter(bw);
			for (Administrativo admnistrativo : Archivo.getAdministrativos()) {
				String linea = admnistrativo.getNombre() + ";";
				linea += admnistrativo.getCedula() + ";";
				linea += admnistrativo.getCorreo() + ";";
				linea += admnistrativo.getContrasena();
				pw.write(linea + "\n");
				String linea2 = "";
				ArrayList<String> menu = admnistrativo.getProcesos();

				for (String opcion : menu) {
					linea2 += opcion + ";";
				}

				linea2 = linea2.substring(0, linea2.length() - 1);
				pw.write(linea2 + "\n");

			}
			pw.close();

		} catch (Exception ex) {
			System.out.println("Error en escritura de administrativos: " + ex);
		}

	}

	/*
	 * escribirCursos se encarga de escribir con formato correcto a los cursos en el
	 * archivo de texto cursos.txt para posteriormente ser leido por el metodo
	 * cargarCursos. No recibe nada ni retorna nada
	 */
	public static void escribirCursos() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File file = new File(direccion + "cursos.txt");
			FileWriter filew = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(filew);
			PrintWriter pw = new PrintWriter(bw);

			for (Curso curso : Archivo.getCursos()) {
				String linea1 = curso.getNombreCurso() + ";";
				linea1 += curso.getTipo() + ";";
				linea1 += curso.getHorarioCurso() + ";";
				linea1 += curso.getDocente().getCedula();
				pw.write(linea1 + "\n");
			}

			pw.close();

		} catch (Exception ex) {
			System.out.println("Error en escritura de cursos: " + ex);
		}

	}

	/*
	 * escribirSolicitudes se encarga de escribir con formato correcto a las
	 * solicitudes en el archivo de texto solicitudes.txt para posteriormente ser
	 * leido por el metodo cargarSolicitudes. No recibe nada ni retorna nada
	 */
	public static void escribirSolicitudes() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File file = new File(direccion + "solicitudes.txt");
			FileWriter filew = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(filew);
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

	/*
	 * escribirSugerencias se encarga de escribir con formato correcto a las
	 * sugerencias en el archivo de texto asugernecias.txt para posteriormente ser
	 * leido por el metodo cargarSugerencias. No recibe nada ni retorna nada
	 */
	public static void escribirSugerencias() {

		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File file = new File(direccion + "sugerencias.txt");
			FileWriter filew = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(filew);
			PrintWriter pw = new PrintWriter(bw);

			for (Sugerencia sugerencia : Archivo.getSugerencias()) {
				pw.write(sugerencia.getUsuario().getCedula() + "°" + sugerencia.getMensaje() + "\n");
			}

			pw.close();

		} catch (Exception ex) {
			System.out.println("Error en escritura de sugerencias: " + ex);
		}

	}

}