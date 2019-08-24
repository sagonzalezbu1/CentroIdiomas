package control;

/*Clase abstracta de la que derivan todas las opciones de menú del sistema.
 * No hay instancias directas de ella sino de sus subclases, es decir, 
 * de cada opción de menú*/
public abstract class OpcionDeMenu {
	private String nombre;
	
	/*Método que sólo ejecutarán las opciones que pueda añadir/eliminar Administrador
	 * No recibe parámetros. Retorna un String correspondiente al atributo nombre*/
	public String getNombre() {
		return nombre;
	}
	
	//Métodos a implementar por todas las subclases, es decir, por todas las opciones de menú
	public abstract void ejecutar();
	
	public abstract String toString();
	
}