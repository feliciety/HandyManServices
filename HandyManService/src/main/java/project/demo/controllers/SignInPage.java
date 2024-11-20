package project.demo.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SignInPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/demo/FXML/SignIn.fxml"));

            // AnchorPane is the root element in the FXML file
            AnchorPane root = loader.load();

            // Create a Scene using the loaded AnchorPane
            Scene scene = new Scene(root, 1352, 764);  // Use the preferred size or adjust as needed

            // Set the scene on the stage
            primaryStage.setScene(scene);

            // Set the title of the window (optional)
            primaryStage.setTitle("Sign In");

            // Show the window
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Launch the application
    public static void main(String[] args) {
        launch(args);
    }
}
