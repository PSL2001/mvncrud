/**
 * mvncrud - modelo - Producto.java
 * 1 mar 2023 - 9:03:11
 * @author Pablo Sánchez López
 */
package es.damdi.pablosanchez.mvncrud.modelo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author usuario
 *
 */
public class Producto {
	private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty codigo = new SimpleStringProperty();
    private StringProperty nombre = new SimpleStringProperty();
    private DoubleProperty precio = new SimpleDoubleProperty();
    private IntegerProperty cantidad = new SimpleIntegerProperty();

    public int getId() {
        return id.get();
    }
    
    public Producto() {
    }

    /**
	 * @param id
	 * @param nombre
	 * @param precio
	 */
	public Producto(IntegerProperty id, StringProperty nombre, DoubleProperty precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	public void setId(int id) {
        this.id.set(id);
    }
	
	public IntegerProperty idProperty() {
		return id;
	}

    public String getCodigo() {
        return codigo.get();
    }

    public void setCodigo(String codigo) {
        this.codigo.set(codigo);
    }
    
    public StringProperty codigoProperty() {
		return codigo;
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }
    
    public StringProperty nombreProperty() {
		return nombre;
    }

    public Double getPrecio() {
        return precio.get();
    }

    public void setPrecio(Double precio) {
        this.precio.set(precio);;
    }
    
    public DoubleProperty precioProperty() {
		return precio;
    }

    public int getCantidad() {
        return cantidad.get();
    }

    public void setCantidad(int cantidad) {
        this.cantidad.set(cantidad);
    }
    
    public IntegerProperty cantidadProperty() {
    	return cantidad;
    }
}
