module es.damdi.pablosanchez.mvncrud {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	requires javafx.graphics;

    opens es.damdi.pablosanchez.mvncrud to javafx.fxml;
    opens es.damdi.pablosanchez.mvncrud.controlador;
    opens es.damdi.pablosanchez.mvncrud.modelo;
    exports es.damdi.pablosanchez.mvncrud;
}
