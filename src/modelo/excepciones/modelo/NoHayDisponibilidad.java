package modelo.excepciones.modelo;

import modelo.excepciones.control.ErrorControl;

public class NoHayDisponibilidad extends ErrorControl {
	public NoHayDisponibilidad() {
		super("NoHayCuposDisponibles");
	}
}
