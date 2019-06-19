package gestorAplicacion.usuarios;

public abstract class Usuario {
    protected String nombre;
    protected long cedula;
    protected String correo;
    protected String contrase�a;
    
    public void setContrase�a(String pass){
        contrase�a = pass;
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
    public String getContrase�a(){
        return contrase�a;
    }
    
    public Usuario(String name, long id, String email, String password) {
        nombre = name;
        cedula = id;
        correo = email;
        contrase�a = password;
    }
}