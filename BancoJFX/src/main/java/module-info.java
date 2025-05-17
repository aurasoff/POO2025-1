module org.uniquindio.edu.co.poo.bancojfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires org.controlsfx.controls;
    requires java.sql;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;


    opens org.uniquindio.edu.co.poo.contollers to javafx.fxml;



    exports org.uniquindio.edu.co.poo; // ← ¡IMPORTANTE!
    opens org.uniquindio.edu.co.poo to javafx.graphics, javafx.fxml; // ← Para que JavaFX pueda instanciar App
    opens org.uniquindio.edu.co.poo.bancojfx to javafx.fxml;

    exports org.uniquindio.edu.co.poo.bancojfx;
    exports org.uniquindio.edu.co.poo.contollers.Admin;
    exports org.uniquindio.edu.co.poo.Model;
    exports org.uniquindio.edu.co.poo.Views;
}
