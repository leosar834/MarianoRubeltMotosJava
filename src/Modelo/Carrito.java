package Modelo;

import java.util.ArrayList;
import java.util.List;
import Control.Items;
import Control.Producto;
public class Carrito {
    
    private List<Items> items;

    public Carrito(){
        items = new ArrayList<>();
    }
    public List<Items> getItems(){
        return items;
    }
    public void agregarProducto(Producto producto, int cantidad){
        for (Items item : items) {
            if (item.getProducto().getId() == producto.getId()) {
                item.setCantidad(item.getCantidad() + cantidad);
                return;
            }
        }
        items.add(new Items(producto, cantidad));
    }
    public void quitarProducto(int idProducto){
        items.removeIf(item -> item.getProducto().getId() == idProducto);
    }
    public double getTotal(){
        double total = 0;
        for (Items item : items){
            total += item.getSubtotal();
        }
        return total;
    }
    public void vaciar(){
        items.clear();
    }
}
