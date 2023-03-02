/**
 * mvncrud - controlador - RootLayoutController.java
 * 2 mar 2023 - 13:23:15
 * @author Pablo Sánchez López
 */
package es.damdi.pablosanchez.mvncrud.controlador;

import es.damdi.pablosanchez.mvncrud.Main;
import javafx.fxml.FXML;

/**
 * @author usuario
 *
 */
public class RootLayoutController {
	
	//Referencia a la aplicacion principal
	private Main mainApp;

	/**
	 * @param mainApp the mainApp to set
	 */
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	private void handleClose() {
		System.exit(0);
	}

}
