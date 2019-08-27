package modelo.excepciones;

public class ErrorAplicacion extends Exception {
	
	public ErrorAplicacion(){
		super("Error en la aplicacion");
	}
	public ErrorAplicacion(String mensaje){
		super("Manejo de errores de la Aplicación: " + mensaje);
	}

}
