package org.uniquindio.edu.co.poo;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class App extends Application {
   @Override
    public void start(Stage stage) throws Exception {
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/bancojfx/Fxml/Login.fxml"));
       Scene scene = new Scene(fxmlLoader.load());
       stage.setScene(scene);
       stage.show();
    }
}