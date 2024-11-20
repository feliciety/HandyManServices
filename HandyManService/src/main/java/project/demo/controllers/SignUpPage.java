package project.demo.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SignUpPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file (signUpPage.fxml)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/demo/FXML/SignUp.fxml"));

            // Load the content from the FXML file
            AnchorPane root = loader.load();

            // Set the scene and the stage (window)
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Sign Up Page");

            // Optional: Set the window size (width, height)
            primaryStage.setWidth(1352);
            primaryStage.setHeight(764);

            // Show the stage (window)
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}
