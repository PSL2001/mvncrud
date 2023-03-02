module es.damdi.pablosanchez.mvncrud {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires javafx.base;

    opens es.damdi.pablosanchez.mvncrud to javafx.fxml;
    exports es.damdi.pablosanchez.mvncrud;
}
