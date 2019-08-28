package control.controlPanel.procesos;
import java.awt.event.*;
import javax.swing.*;
import control.*;
import defecto.Main;
import modelo.Usuarios.*;
import modelo.excepciones.*;
import modelo.excepciones.control.CampoVacio;
import modelo.excepciones.modelo.CursoConDisponibilidad;
import modelo.excepciones.modelo.CursoYaInscrito;
import modelo.excepciones.modelo.EstudianteConCertificado;
import modelo.excepciones.modelo.NoExisteEstudiante;
import modelo.excepciones.modelo.SolicitudYaHecha;


public class SolicitarCupoPanel implements ActionListener {

	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("Aceptar")) {
			try {
				String tipo = Main.ventanaUsuario.getPanelP().getValue("Tipo de la Solicitud: ");
				String solicitud = ((Estudiante) (Main.user)).solicitarCupo(Main.user.getCedula(), tipo);

				Main.ventanaUsuario.Popup2(solicitud);
				Main.ventanaUsuario.setPanelP();
				
			} catch (CampoVacio excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch(NumberFormatException excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NoExisteEstudiante excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (SolicitudYaHecha excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (CursoYaInscrito excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (EstudianteConCertificado excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (CursoConDisponibilidad excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} /*catch (EstudianteSinCursos excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}*/

		} else if (evento.getActionCommand().equals("Borrar")) {
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}

}
