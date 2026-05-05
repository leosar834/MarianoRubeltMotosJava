package Control;

public class Usuario {
    public int codigo;
    public String nombre;
    public String apellido;
    public String dni;
    public String email;
    public String domicilio;
    public String usuario;
    
    public Usuario(String nombre, String apellido, String dni, String email, String domicilio, String usuario){
        this.nombre=nombre;
        this.apellido=apellido;
        this.dni=dni;
        this.email=email;
        this.domicilio=domicilio;
        this.usuario=usuario;
    }
    public Usuario(int codigo,String nombre){
        this.codigo = codigo;
        this.nombre = nombre;
    }
    public int getCodigo(){return codigo;}
    
    @Override
    public String toString(){
        return nombre;
    }
    public Usuario(int id,String nombre, String apellido, String dni, String email, String domicilio, String usuario){
        this.codigo=id;
        this.nombre=nombre;
        this.apellido=apellido;
        this.dni=dni;
        this.email=email;
        this.domicilio=domicilio;
        this.usuario=usuario;
    }
    
    public Usuario(){
        
    }
}
