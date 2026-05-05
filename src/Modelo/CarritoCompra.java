package Modelo;

import java.util.ArrayList;
import java.util.List;

import Control.ItemsCompra;
import Control.Producto;

public class CarritoCompra {
    private List<ItemsCompra> items;

    public CarritoCompra() {
        this.items = new ArrayList<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        // Buscar si ya existe en el carrito
        
        for (ItemsCompra item : items) {
            if (item.getProducto().getId() == producto.getId()) {
                item.setCantidad(item.getCantidad() + cantidad);
                return;
            }
        }
        // Si no existe, agregar uno nuevo
        items.add(new ItemsCompra(producto, cantidad));
    }

    public void quitarProducto(int idProducto) {
        items.removeIf(item -> item.getProducto().getId() == idProducto);
    }

    public List<ItemsCompra> getItems() {
        return items;
    }

    public double getTotalCompra() {
        double total = 0;
        for (ItemsCompra item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void limpiar() {
        items.clear();
    }
}
