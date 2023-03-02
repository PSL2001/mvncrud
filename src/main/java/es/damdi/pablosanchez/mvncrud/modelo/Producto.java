/**
 * mvncrud - modelo - Producto.java
 * 1 mar 2023 - 9:03:11
 * @author Pablo Sánchez López
 */
package es.damdi.pablosanchez.mvncrud.modelo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * @author usuario
 *
 */
public class Producto {
	private int id;
    private StringProperty codigo;
    private StringProperty nombre;
    private DoubleProperty precio;
    private IntegerProperty cantidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo.get();
    }

    public void setCodigo(String codigo) {
        this.codigo.set(codigo);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public Double getPrecio() {
        return precio.get();
    }

    public void setPrecio(Double precio) {
        this.precio.set(precio);;
    }

    public int getCantidad() {
        return cantidad.get();
    }

    public void setCantidad(int cantidad) {
        this.cantidad.set(cantidad);
    }
}
