package Control;

public class Producto {
    public int codigo;
    public String nombre;
    public double precio;
    public String categoria;
    public int id_categoria;
    public int stock;
    
    public double getPrecio(){
        return precio;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public int getId(){
        return codigo;
    }
    public void setId(int codigo){
        this.codigo = codigo;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getCategoria(){
        return categoria;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    public Producto(int codigo, String nombre,double precio,int id_categoria, int stock){
        this.codigo=codigo;
        this.nombre=nombre;
        this.precio=precio;
        this.id_categoria=id_categoria;
        this.stock=stock;
    }
    public Producto(int codigo, String nombre, double precio, String categoria, int stock) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.precio = precio;
    this.categoria = categoria;
    this.stock = stock;
    this.id_categoria = 0;
    }
    public Producto(){
    }    
}
