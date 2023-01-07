package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class mainPageHandler implements Initializable {
    FXMLLoader loader=new FXMLLoader();
    @FXML
    private Button appointmentButton,complaintButton,fardButton,landOwnershipButton,mutationButton,naqshaAraziButton,registryButton,addR,updateR,delR;

    @FXML
    private ImageView searchButton;

    Parent root;
    Stage stage;
    Scene scene;
    @FXML
   public void handleBUttons(ActionEvent event) throws IOException {

       if(event.getSource()==addR)
       {
           root= FXMLLoader.load(getClass().getResource("addRecord.fxml"));
           stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           scene=new Scene(root);
           stage.setScene(scene);
           stage.show();

       }

       else if(event.getSource()==complaintButton)
       {
           root= FXMLLoader.load(getClass().getResource("complain.fxml"));
           stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           scene=new Scene(root);
           stage.setScene(scene);
           stage.show();
       }

       else if(event.getSource()==fardButton)
       {

           root= FXMLLoader.load(getClass().getResource("confirmFard.fxml"));
           stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           scene=new Scene(root);
           stage.setScene(scene);
           stage.show();

       }
       else if(event.getSource()==naqshaAraziButton)
       {

           root= FXMLLoader.load(getClass().getResource("verifyMap.fxml"));
           stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           scene=new Scene(root);
           stage.setScene(scene);
           stage.show();

       }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
