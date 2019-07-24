package BaseDatos;

import java.io.*;
import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;
import uiMain.Main;
import uiMain.OpcionDeMenu;


/* La finalidad de la clase Data es lograr la escritura y carga de los archivos de texto en los que se guarda la informacion de nuestro programa.
 * Para posibles problemas con la lectura y escritura, todos sus metodos se ejecutan en un bloque try - catch */

public class Data {

	//cargarEstudiantes se encarga de leer el archivo estudiantes.txt y cargar en memoria a los estudiantes. No recibe ningun  parametro y tampoco retorna nada
	public static void cargarEstudiantes() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File f = new File(direccion + "estudiantes.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea1;
			while ((linea1 = br.readLine()) != null) {
				String[] usuario = linea1.split(";");
				Estudiante e = new Estudiante(Long.parseLong(usuario[1]), usuario[0], usuario[2], usuario[3]); // Segundo
																												// Contructor

				String linea2 = br.readLine();
				if (!linea2.equals("0")) {
					String[] cursos = linea2.split("-");
					for (String x : cursos) {
						String[] array = x.split(";");
						Curso curso = Archivo.buscarCurso(array[0]);
						curso.matricular(e);
						for (int i = 1; i < array.length; i++) {
							float aux = Float.parseFloat(array[i]);
							e.addNota(curso, aux);
						}
					}
				}
				String linea3 = br.readLine();
				if (!linea3.equals("0")) {
					String[] certificados = linea3.split("-");
					for (String x : certificados) {
						String[] array = x.split(";");
						Docente d = Archivo.buscarDocente(Long.parseLong(array[2]));
						float n = Float.parseFloat(array[3]);
						e.addCertificado(new Certificado(array[0], e, d, n));
					}
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
	//cargarDocentes se encarga de leer el archivo docentes.txt y cargar en memoria a los docentes. No recibe ningun  parametro y tampoco retorna nada
	public static void cargarDocentes() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File f = new File(direccion + "docentes.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			int cont = 0;
			long cedula = 0;
			while ((linea = br.readLine()) != null) {
				if (cont % 2 == 0) {
					String[] usuario = linea.split(";");
					ArrayList<Docente> lista = Archivo.getDocentes();
					int aux = 0;
					for (Docente x : lista) {
						if (x.getCedula() == Long.parseLong(usuario[1])) {
							aux++;
						}
					}
					if (aux == 0) {
						cedula = Long.parseLong(usuario[1]);
						Docente d = new Docente(cedula, usuario[0], usuario[2], usuario[3]); // Segundo
																								// constructor
					}
					cont++;
				} else {
					Docente aux2 = Archivo.buscarDocente(cedula);
					String[] menu = linea.split(";");
					for (String x : menu) {
						aux2.getMenu().anadirOpcion(Main.funcionalidades.get(x));
					}
					cont++;
				}
			}
			br.close();
		} catch (Exception ex) {
			System.out.println("\nError en carga de docentes: " + ex);
		}
	}
	//cargarAdministrativos se encarga de leer el archivo administrativos.txt y cargar en memoria a los administrativos. No recibe ningun  parametro y tampoco retorna nada
	public static void cargarAdministrativos() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File f = new File(direccion + "administrativos.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			int cont = 0;
			long cedula = 0;
			while ((linea = br.readLine()) != null) {
				if (cont % 2 == 0) {
					String[] usuario = linea.split(";");
					ArrayList<Administrativo> lista = Archivo.getAdministrativos();
					int aux = 0;
					for (Administrativo x : lista) {
						if (x.getCedula() == Long.parseLong(usuario[1])) {
							aux++;
						}
					}
					if (aux == 0) {
						cedula = Long.parseLong(usuario[1]);
						Administrativo d = new Administrativo(cedula, usuario[0], usuario[2], usuario[3]); // Segundo
																											// constructor
					}
					cont++;
				} else {
					Administrativo aux2 = Archivo.buscarAdministrativo(cedula);
					String[] menu = linea.split(";");
					for (String x : menu) {
						aux2.getMenu().anadirOpcion(Main.funcionalidades.get(x));
					}
					cont++;
				}
			}
			br.close();
		} catch (Exception ex) {
			System.out.println("\nError en carga de administrativos: " + ex);
		}

	}
	/*cargarSolicitudes se encarga de leer el archivo solicitudes.txt y cargar en memoria a las solicitudes, estas son realizadas por estudiantes pero dado que
	 *las trabajamos como otro objeto y tiene conexiones con administrativo, decidimos hacerle un archivo aparte. No recibe ningun  parametro y tampoco 
	 *retorna nada*/
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
			System.out.println("\nError en carga de solicitudes: " + ex);
		}
	}

	//cargarCursos se encarga de leer el archivo cursos.txt y cargar en memoria a los cursos. No recibe ningun  parametro y tampoco retorna nada
	public static void cargarCursos() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File f = new File(direccion + "cursos.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
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
					// Hasta acá
	
				}

			}
			br.close();
		} catch (Exception ex) {
			System.out.println("\nError en carga de cursos: " + ex);
		}
	}
	//cargarSugerencias se encarga de leer el archivo sugerencias.txt y cargar en memoria a las sugerencias. No recibe ningun  parametro y tampoco retorna nada
	public static void cargarSugerencias() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File f = new File(direccion + "sugerencias.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] sugerencia = linea.split("°");
				Usuario u = Archivo.buscarUsuario(Long.parseLong(sugerencia[0]));
				if (u != null) {
					new Sugerencia(u, sugerencia[1]);
				} else {
					new Sugerencia(Archivo.getAdministrador(), sugerencia[1]);
				}
			}
			br.close();
		} catch (Exception ex) {
			System.out.println("\nError en carga de sugerencias: " + ex);
		}
	}

	/*escribirEstudiantes se encarga de escribir con formato correcto a los estudiantes en el archivo de texto estudiantes.txt para posteriormente ser leido
	 * por el metodo cargarEstudiantes. No recibe nada ni retorna nada
	 */
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
						linea += x;
						ArrayList<Float> notas = hash.get(x);
						for (float y : notas) {
							linea += ";" + y;
						}
						linea += "-";
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
								+ ";" + x.getNota() + "-";
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
	/*escribirDocentes se encarga de escribir con formato correcto a los docentes en el archivo de texto docentes.txt para posteriormente ser leido
	 * por el metodo cargarDocentes. No recibe nada ni retorna nada
	 */
	public static void escribirDocentes() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File f = new File(direccion + "docentes.txt");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for (Docente d : Archivo.getDocentes()) {
				String linea1 = "";
				linea1 += d.getNombre() + ";";
				linea1 += d.getCedula() + ";";
				linea1 += d.getCorreo() + ";";
				linea1 += d.getContrasena();
				pw.write(linea1 + "\n");

				String linea2 = "";
				ArrayList<OpcionDeMenu> aux = d.getMenu().getList();
				for (OpcionDeMenu x : aux) {
					linea2 += x.getNombre() + ";";
				}
				linea2 = linea2.substring(0, linea2.length() - 1);
				pw.write(linea2 + "\n");

			}
			pw.close();
		} catch (Exception ex) {
			System.out.println("Error en escritura de docentes: " + ex);
		}
	}
	/*escribirAdministrativos se encarga de escribir con formato correcto a los administrativos en el archivo de texto administrativos.txt para posteriormente ser leido
	 * por el metodo cargarAdministrativos. No recibe nada ni retorna nada
	 */
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

				String linea2 = "";
				ArrayList<OpcionDeMenu> aux = a.getMenu().getList();
				for (OpcionDeMenu x : aux) {
					linea2 += x.getNombre() + ";";
				}
				linea2 = linea2.substring(0, linea2.length() - 1);
				pw.write(linea2 + "\n");

			}
			pw.close();
		} catch (Exception ex) {
			System.out.println("Error en escritura de administrativos: " + ex);

		}

	}
	/*escribirCursos se encarga de escribir con formato correcto a los cursos en el archivo de texto cursos.txt para posteriormente ser leido
	 * por el metodo cargarCursos. No recibe nada ni retorna nada
	 */
	public static void escribirCursos() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File f = new File(direccion + "cursos.txt");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for (Curso c : Archivo.getCursos()) {
				String linea1 = c.getNombreCurso() + ";";
				linea1 += c.getTipo() + ";";
				linea1 += c.getHorarioCurso() + ";";
				linea1 += c.getDocente().getCedula();
				pw.write(linea1 + "\n");

			}
			pw.close();
		} catch (Exception ex) {
			System.out.println("Error en escritura de cursos: " + ex);

		}
	}
	/*escribirSolicitudes se encarga de escribir con formato correcto a las solicitudes en el archivo de texto solicitudes.txt para posteriormente ser leido
	 * por el metodo cargarSolicitudes. No recibe nada ni retorna nada
	 */
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
	/*escribirSugerencias se encarga de escribir con formato correcto a las sugerencias en el archivo de texto asugernecias.txt para posteriormente ser leido
	 * por el metodo cargarSugerencias. No recibe nada ni retorna nada
	 */
	public static void escribirSugerencias() {
		try {
			String direccion = System.getProperty("user.dir") + "\\src\\temp\\";
			File f = new File(direccion + "sugerencias.txt");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for (Sugerencia s : Archivo.getSugerencias()) {
				pw.write(s.getUsuario().getCedula() + "°" + s.getMensaje() + "\n");
			}
			pw.close();
		} catch (Exception ex) {
			System.out.println("Error en escritura de sugerencias: " + ex);
		}
	}

}