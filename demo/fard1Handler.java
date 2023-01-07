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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class fard1Handler {
    LRMIS lrmis=new LRMIS();
    araziRecordCenterC controllerObj=new araziRecordCenterC();
    ObservableList<String> identityList= FXCollections.observableArrayList("choose identity","CNIC","POC","NCOC","passport");
    @FXML
    private ChoiceBox identityyList;
    ObservableList<String> reasonList= FXCollections.observableArrayList("choose reason","personal record");
    @FXML
    private ChoiceBox reasonnList;
    ObservableList<String> mozaList= FXCollections.observableArrayList("choose reason","personal record");//is main db say data dalna hay
    //jo ham nay land wali found main dalla tha when adding revenue record
    @FXML
    private ChoiceBox mozaaList;

    @FXML
    private Button homeButton,lastFardButton,firstFardButton,fard3Buton,fard1Buuton;

    @FXML
    private TextField jugarMn;
    Parent root;
    Stage stage;
    Scene scene;



    @FXML
    private void initialize()
    {
    }

    @FXML
    public void handleBUttons(ActionEvent event) throws IOException {

        if(event.getSource()==fard1Buuton)
        {
            root= FXMLLoader.load(getClass().getResource("fard.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

        else if(event.getSource()==fard3Buton)
        {

            ArrayList<landDetails> found=new ArrayList<>();

            String mozaNo=jugarMn.getText();
            // System.out.println(mozaNo);
            found=controllerObj.enterLandDetails(mozaNo);
            ObservableList<fardTable> array=FXCollections.observableArrayList();
            for(int i=0;i<found.size();i++) {
                System.out.println(found.get(i));

            }
            for(int i=0;i< found.size();i++)
            {
                System.out.println(i);
                System.out.println(found.size());
                array.add(i,new fardTable(found.get(i).propertyInfo.ownerName,found.get(i).propertyInfo.khatoniNo,found.get(i).propertyInfo.khewatNo,found.get(i).personalInfo.getCnic()));
            }

            for(int i=0;i<array.size();i++) {
                System.out.println(array.get(i));

            }


            FXMLLoader loader=new FXMLLoader(getClass().getResource("fard2.fxml"));
            Parent root=(Parent) loader.load();
            fard2Controller controller=loader.getController();
            controller.setValue(found);
            controller.setTable(array);
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();

//
//            root= FXMLLoader.load(getClass().getResource("fard2.fxml"));
//            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene=new Scene(root);
//            stage.setScene(scene);
//            stage.show();

        }
        else if(event.getSource()==lastFardButton)
        {

            root= FXMLLoader.load(getClass().getResource("fard3.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else if(event.getSource()==firstFardButton)
        {

            root= FXMLLoader.load(getClass().getResource("fard.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else if(event.getSource()==homeButton)
        {

            root= FXMLLoader.load(getClass().getResource("mainPage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }



    }
}
