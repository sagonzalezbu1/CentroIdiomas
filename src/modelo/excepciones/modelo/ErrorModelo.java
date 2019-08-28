package modelo.excepciones.modelo;

import modelo.excepciones.ErrorAplicacion;

public class ErrorModelo extends ErrorAplicacion {
	
	public ErrorModelo(){
		super("Error en el modelo");
	}
	
	public ErrorModelo(String mensaje){
		super("ErrorModelo."+mensaje);
	}
}
