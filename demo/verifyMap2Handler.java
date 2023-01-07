package com.example.demo;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class verifyMap2Handler {

    LRMIS lrmis=new LRMIS();
    araziRecordCenterC controllerObj=new araziRecordCenterC();
    @FXML
    private Button homeButton;
    //   ArrayList<landDetails> found =new ArrayList<>();
    @FXML
    public Label tehsilLabel,districtLabel,mozaLabel;
    @FXML
    private TableView<mapTable> mapTable;
    @FXML
    private TableColumn<mapTable, Integer> KhewatNoC;
    @FXML
    private TableColumn<mapTable, Integer> khatoniNoC;
    @FXML
    private TableColumn<mapTable, Double> propertyD;
  //  @FXML
    //private TableColumn<mapTable, Integer> KhewatNoC;
    @FXML
    private TableColumn<mapTable, String> propertyT;

    @FXML
    private Button lastFardButton;
    @FXML
    private Button firstFardButton;
    @FXML
    private Button verifyMapButton;
    @FXML
    private Button fard3Button;
    String map;
    Stage stage;
    Parent root;
    Scene scene;

    public void setValue(ArrayList<landDetails> found)
    {
        // found=found;
        System.out.println(districtLabel.getText()+"-----");
        tehsilLabel.setText(found.get(1).personalInfo.getCity());
        mozaLabel.setText(found.get(1).propertyInfo.getMozaNo());
        districtLabel.setText(found.get(1).personalInfo.getDistrict());
//        int cnic= found.get(1).personalInfo.getCnic();
//        String cnicc=Integer.toString(cnic);
//        cnicLabel.setText(cnicc);
        for(int i=0;i<found.size();i++) {
            System.out.println(found.get(1)+"-------");

        }
    }

    public void setTable(ObservableList<mapTable> array)  throws IOException
    {
        propertyT.setCellValueFactory(new PropertyValueFactory<mapTable,String>("propertyType"));
        khatoniNoC.setCellValueFactory(new PropertyValueFactory<mapTable,Integer>("khatoniNo"));
        KhewatNoC.setCellValueFactory(new PropertyValueFactory<mapTable,Integer>("khewatNo"));
        propertyD.setCellValueFactory(new PropertyValueFactory<mapTable,Double>("propertyDimesnion"));

        mapTable.setItems(array);
        mapTable.setOnMouseClicked(mouseEvent -> {

            for(mapTable mapTable1:mapTable.getSelectionModel().getSelectedItems())
            {
               // landDetails record=new landDetails();
                persistanceHandler phObj=persistanceFactory.getInstance().createPersistanceHandler("db");
                phObj.connectDB();

                 map=controllerObj.selectDesiredLand(mapTable1);
                System.out.println(map+"mapppppppppppppppp");

                    FXMLLoader loader=new FXMLLoader(getClass().getResource("digitizedMap.fxml"));
            //    Parent root = null;
                try {
                    root = (Parent) loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Stage stage=new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();

                // fard3Handler controller=loader.getController();
                   // controller.setLabels(bill,record);




                // fard landFard=new fard(record);


            }
        });

    }



//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//    }

    public void  handleBUttons(ActionEvent event) throws IOException {

        if (event.getSource() == homeButton) {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            lrmis.loadAnother("mainPage.fxml",stage);

        }
        else if(event.getSource()==verifyMapButton)
        {

            root= FXMLLoader.load(getClass().getResource("verifyMap.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else if(event.getSource()==fard3Button)
        {
            if(map=="MAP")
            {
              //  root= FXMLLoader.load(getClass().getResource("digitizedMap.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                lrmis.loadAnother("digitizedMap.fxml",stage);
//                scene=new Scene(root);
//                stage.setScene(scene);
//                stage.show();

            }

        }
//        else if(event.getSource()==firstFardButton)
//        {
//
//            root= FXMLLoader.load(getClass().getResource("fard.fxml"));
//            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene=new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//
//        }
//        else if(event.getSource()==fard1Button)
//        {
//
//            root= FXMLLoader.load(getClass().getResource("fard1.fxml"));
//            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene=new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//
//        }
//        else if(event.getSource()==fard3Button)
//        {
//
//            root= FXMLLoader.load(getClass().getResource("fard3.fxml"));
//            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene=new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//
//        }


    }
}
