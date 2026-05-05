package Control;

public class ItemsCompra {
    private Producto producto;
    private int cantidad;

    public ItemsCompra(Producto p, int cantidad, double costo){
        this.producto = p;
        this.cantidad = cantidad;
    }
    public ItemsCompra(Producto p, int cantidad){
        this.producto = p;
        this.cantidad = cantidad;
    }

    public Producto getProducto(){ return producto; }
    public int getCantidad(){ return cantidad; }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return producto.getPrecio() * cantidad;
    }
}