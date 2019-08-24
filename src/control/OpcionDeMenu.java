package control;

/*Clase abstracta de la que derivan todas las opciones de men� del sistema.
 * No hay instancias directas de ella sino de sus subclases, es decir, 
 * de cada opci�n de men�*/
public abstract class OpcionDeMenu {
	private String nombre;
	
	/*M�todo que s�lo ejecutar�n las opciones que pueda a�adir/eliminar Administrador
	 * No recibe par�metros. Retorna un String correspondiente al atributo nombre*/
	public String getNombre() {
		return nombre;
	}
	
	//M�todos a implementar por todas las subclases, es decir, por todas las opciones de men�
	public abstract void ejecutar();
	
	public abstract String toString();
	
}