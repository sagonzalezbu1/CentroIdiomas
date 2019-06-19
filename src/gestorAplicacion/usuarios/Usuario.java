package gestorAplicacion.usuarios;

public abstract class Usuario {
    protected String nombre;
    protected long cedula;
    protected String correo;
    protected String contrasena;
    
    public void setContrasena(String pass){
        contrasena = pass;
    }
    public String getNombre(){
        return nombre;
    }
    public long getCedula(){
        return cedula;
    }
    public String getCorreo(){
        return correo;
    }
    public String getContraseña(){
        return contrasena;
    }
    
    public Usuario(String name, long id, String email, String password) {
        nombre = name;
        cedula = id;
        correo = email;
        contrasena = password;
    }
}