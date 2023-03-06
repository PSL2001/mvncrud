package es.damdi.pablosanchez.mvncrud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import es.damdi.pablosanchez.mvncrud.controlador.ProductoController;
import es.damdi.pablosanchez.mvncrud.controlador.RootLayoutController;

/**
 * JavaFX App
 */
public class Main extends Application {

    private Stage primaryStage;
    
    private BorderPane rootLayout;

    @Override
    public void start(Stage stage) {
    	this.primaryStage = stage;
    	this.primaryStage.setTitle("Crud Maven App");
    	
    	initRoot();
    	initFrame();
    }

    

    /**
	 * 
	 */
	private void initFrame() {
		try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/frmProducto.fxml"));
            AnchorPane frame = (AnchorPane) loader.load();

            // Fill the center
            rootLayout.setCenter(frame);

            // Give the controller access to the main app.
            ProductoController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}



	/**
	 * 
	 */
	private void initRoot() {
		try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}



	public static void main(String[] args) {
        launch();
    }

}