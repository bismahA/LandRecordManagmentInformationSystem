package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class verifyMapHandler {

    @FXML
    private TextField districtLabel;
    @FXML
    private TextField khatoniLabel;
    @FXML
    private TextField mozaLabel;
    @FXML
    private TextField tehsilLabel;

    @FXML
    private Button verify2Button;
    @FXML
    private Button homeButton;
    araziRecordCenterC controllerObj=new araziRecordCenterC();

    Parent root;
    Stage stage;
    Scene scene;
    @FXML
    public void handleBUttons(ActionEvent event) throws IOException {

        if (event.getSource() == homeButton) {
            root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else if (event.getSource() == verify2Button) {

            ArrayList<landDetails> found = new ArrayList<>();


            String mozaNo = mozaLabel.getText();
            // System.out.println(mozaNo);
            found = controllerObj.enterLandDetails(mozaNo);
            ObservableList<mapTable> array = FXCollections.observableArrayList();
            for (int i = 0; i < found.size(); i++) {
                System.out.println(found.get(i));

            }
            for (int i = 0; i < found.size(); i++) {
               // System.out.println(i);
                //System.out.println(found.size());
                System.out.println("-----"+found.get(i).propertyInfo.getKhatoniNo());
                array.add(i, new mapTable(found.get(i).propertyInfo.getKhewatNo(),found.get(i).propertyInfo.getKhatoniNo(),found.get(i).propertyInfo.getPropertyDimension(),found.get(i).propertyInfo.getPropertyType()));
                System.out.println("0000--"+array.get(i).khatoniNo);
            }

            for (int i = 0; i < array.size(); i++) {
                System.out.println(array.get(i));

            }


            FXMLLoader loader = new FXMLLoader(getClass().getResource("verifyMap2.fxml"));
            Parent root = (Parent) loader.load();
            verifyMap2Handler controller = loader.getController();
            controller.setValue(found);
            controller.setTable(array);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

//
//            root= FXMLLoader.load(getClass().getResource("fard2.fxml"));
//            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene=new Scene(root);
//            stage.setScene(scene);
//            stage.show();

        }
    }

}
