package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class complainHandler {

    @FXML
    private ImageView menuLogo1;

    @FXML
    private Button homeButton;

    @FXML
    private AnchorPane slider;

    @FXML
    private Button fardButton;

    @FXML
    private Button registryButton;

    @FXML
    private Button mutationButton;


    @FXML
    private Button verifyOwnerButton;

    @FXML
    private Button mapButton;

    @FXML
    private Button complaintButton;

    @FXML
    private Button appointmentButton;

    @FXML
    private Button sendComplainButton;

    Parent root;
    Stage stage;
    Scene scene;

    @FXML
    public void handle(ActionEvent event) throws IOException {
        if(event.getSource()==homeButton)
        {
            root= FXMLLoader.load(getClass().getResource("mainPage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
       // Button complainButton = new Button("Send");
        else if(event.getSource()==sendComplainButton)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Congratulations");
            alert.setHeaderText("Your Complain has been Registered");
            alert.showAndWait();

        }
//        sendComplainButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Congratulations");
//                alert.setHeaderText("Your Complain has been Registered");
//                alert.showAndWait();
//
//            }
//        });
    }

    ObservableList<String> districtChoiceBox= FXCollections.observableArrayList("Choose District","Lasbela","Harnai","Kalat","Chiman");
    @FXML
    private ChoiceBox districtChoiceBox2;

    ObservableList<String> tehsilChoiceBox= FXCollections.observableArrayList("Choose District","Lasbela","Harnai","Kalat","Chiman");
    @FXML
    private ChoiceBox tehsilChoiceBox2;


    ObservableList<String> complainNatureBox= FXCollections.observableArrayList("Choose complain Type","Mutuation","Fard","Corruption");
    @FXML
    private ChoiceBox complainNatureChoiceBox2;


    @FXML
    public void initialize()
    {
        districtChoiceBox2.setValue("Choose District");
        districtChoiceBox2.setItems(districtChoiceBox);


        tehsilChoiceBox2.setValue("Choose Tehsil");
        tehsilChoiceBox2.setItems(tehsilChoiceBox);

        complainNatureChoiceBox2.setValue("Choose Complain Type");
        complainNatureChoiceBox2.setItems(complainNatureBox);



    }


}
