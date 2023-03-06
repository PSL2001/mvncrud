/**
 * mvncrud - es.damdi.pablosanchez.mvncrud.controlador - ProductoController.java
 * 6 mar 2023 - 8:34:48
 * @author Pablo Sánchez López
 */
package es.damdi.pablosanchez.mvncrud.controlador;

import java.util.List;
import java.util.Optional;

import es.damdi.pablosanchez.mvncrud.Main;
import es.damdi.pablosanchez.mvncrud.modelo.ConsultasProducto;
import es.damdi.pablosanchez.mvncrud.modelo.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author usuario
 *
 */
public class ProductoController {
	private Producto modelo;
    private ConsultasProducto consultas;
    private Main mainApp;
    
    @FXML
    private TextField tfCodigo;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfPrecio;
    @FXML
    private TextField tfCantidad;
    @FXML
    private TableColumn<Producto, String> columnaNombre;
    @FXML
    private TableColumn<Producto, Double> columnaPrecio;
    @FXML
    private TableView<Producto> tablaProductos;
    
    private List<Producto> listaProductos;
    

    public void CtrlProducto(Producto modelo, ConsultasProducto consultas) {
        this.modelo = modelo;
        this.consultas = consultas;
    }
    
    public void actualizarLista() {
        listaProductos = consultas.getAll();
        tablaProductos.getItems().setAll(listaProductos);
    }

    
    @FXML
    private void initialize() {
    	modelo = new Producto();
    	consultas = new ConsultasProducto();
    	columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	columnaPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
    	tablaProductos.getColumns().setAll(columnaNombre, columnaPrecio);
    	actualizarLista();
    }


	/**
	 * @param mainApp the mainApp to set
	 */
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	public void handleGuardar() {
		if (!hayError()) {
			modelo.setCodigo(tfCodigo.getText());
			modelo.setNombre(tfNombre.getText());
			modelo.setPrecio(Double.parseDouble(tfPrecio.getText()));
			modelo.setCantidad(Integer.parseInt(tfCantidad.getText()));
			//Conectamos a la base de datos y añadimos el registro
			if (consultas.registrar(modelo)) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
			    alert.setHeaderText(null);
			    alert.setTitle("Info");
			    alert.setContentText("Modelo Registrado con exito");
			    alert.showAndWait();
			} else {
				//Si salta esto, entonces algo ha ido mal
				Alert alert = new Alert(Alert.AlertType.ERROR);
		        alert.setHeaderText(null);
		        alert.setTitle("Error");
		        alert.setContentText("Error al guardar los datos");
		        alert.showAndWait();
			}
		}
		actualizarLista();
	}
	
	@FXML
	public void handleBorrar() {
		TextInputDialog dialog = new TextInputDialog();
	    dialog.setTitle("Borrar producto");
	    dialog.setHeaderText(null);
	    dialog.setContentText("Introduce el codigo del producto:");

	    Optional<String> result = dialog.showAndWait();
	    result.ifPresent(codigo -> {
	        Producto producto = new Producto();
	        producto.setCodigo(codigo);
	        
	        if (consultas.buscar(producto)) {
	            // Si el producto existe, lo eliminamos de la base de datos
	            consultas.eliminar(producto);
	            
	            // Actualizamos la tabla para reflejar el cambio
	            actualizarLista();
	        } else {
	            // Si el producto no existe, mostramos un mensaje de error
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setTitle("Error");
	            alert.setHeaderText(null);
	            alert.setContentText("El producto no existe");
	            alert.showAndWait();
	        }

	    });
	}



	/**
	 * @return
	 */
	private boolean hayError() {
		String mensajeError = "";
		if (tfCodigo.getText() == null || tfCodigo.getText().length() == 0 || tfCodigo.getText().isEmpty()) {
			mensajeError += "Codigo no valido!\n"; 
		}
		if (tfNombre.getText() == null || tfNombre.getText().length() == 0 || tfNombre.getText().isEmpty()) {
			mensajeError += "Nombre no valido!\n"; 
		}
		if (tfPrecio.getText() == null || tfPrecio.getText().length() == 0 || tfPrecio.getText().isEmpty()) {
			mensajeError += "Precio no valido!\n"; 
		} else {
			//Intentamos parsear a double
			try {
				Double.parseDouble(tfPrecio.getText());
			} catch(Exception e) {
				mensajeError += "El precio debe de ser un numero real!\n";
			}
		}
		if (tfCantidad.getText() == null || tfCantidad.getText().length() == 0 || tfCantidad.getText().isEmpty()) {
			mensajeError += "Cantidad no valida!\n"; 
		} else {
			//Intentamos parsear a int
			try {
				Integer.parseInt(tfCantidad.getText());
			} catch(Exception e) {
				mensajeError += "La cantidad debe de ser un numero entero!\n";
			}
		}
		//Si la longitud del mensaje es 0 entonces es que no hay errores
		if(mensajeError.length() == 0) {
			return false;
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setHeaderText(null);
	        alert.setTitle("Error");
	        alert.setContentText("Hay errores en los campos, comprueba que estan correctos:\n" + mensajeError);
	        alert.showAndWait();

            return true;
		}
	}
}
