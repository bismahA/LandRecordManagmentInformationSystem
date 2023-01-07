package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LRMIS extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        Parent root = null;
//        File css = new File("style.css");
//
//        try {
//            root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
//            root.getStylesheets().clear();
//            root.getStylesheets().add("file:///" + css.getAbsolutePath().replace("\\", "/"));
//        } catch (IOException e) {
//            System.out.println(e);
//            System.exit(1);
//        } // try
//
//        stage.setTitle("Programmer's Calculator");
//        stage.setScene(new Scene(root, 1154.0, 534.0));
//        stage.show();



        FXMLLoader fxmlLoader = new FXMLLoader(LRMIS.class.getResource("mainPage.fxml"));
      //  StackPane layout = new StackPane();
      //  layout.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
        Scene scene = new Scene(fxmlLoader.load(), 1154.0, 534.0);
        scene.getStylesheets().add("style.css");

        stage.setTitle("LRMIS:)");
        stage.setScene(scene);
        stage.show();
    }
    public void loadAnother(String fxmlName, Stage stage) throws IOException {
        AnchorPane root=new AnchorPane();
        root= FXMLLoader.load(getClass().getResource(fxmlName));

        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}