package modelo.excepciones.control;

import modelo.excepciones.ErrorAplicacion;

public class ErrorControl extends ErrorAplicacion {
	
	public ErrorControl(){
		super("Error en la control");
	}
	public ErrorControl(String mensaje){
		super("ErrorControl."+ mensaje);
	}
}
