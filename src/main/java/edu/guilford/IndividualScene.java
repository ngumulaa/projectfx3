package edu.guilford;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class IndividualScene extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Instantiate a VBox root node
        VBox root = new VBox();
        // Add a label to the root node
       
        // Instantiate a defualt Individual object 
        // Individual individual = new Individual();

        // Instantiate anb IndividualPane object and add it to the root node
        root.getChildren().add(new IndividualPane(new Individual()));
        scene = new Scene(root, 1100, 700);
        stage.setScene(scene);
        stage.show();

        
    }

    public static void main(String[] args) {
        launch();

        
    }

}