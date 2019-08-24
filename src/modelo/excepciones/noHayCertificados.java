package modelo.excepciones;

public class noHayCertificados extends Exception{
	public noHayCertificados() {
		super("No hay certificados");
	}
}