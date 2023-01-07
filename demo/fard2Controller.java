package com.example.demo;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class fard2Controller  implements Initializable{
    LRMIS lrmis=new LRMIS();
    araziRecordCenterC controllerObj=new araziRecordCenterC();
    @FXML
    private Button homeButton;
 //   ArrayList<landDetails> found =new ArrayList<>();
    @FXML
    public Label tehsilLabel,districtLabel,mozaLabel,cnicLabel;
    @FXML
    private TableView<fardTable> fardTable;
    @FXML
    private TableColumn<fardTable, Integer> khatoniNoC;
    @FXML
    private TableColumn<fardTable, String> nameC;
    @FXML
    private TableColumn<fardTable, Integer> KhewatNoC;
    @FXML
    private TableColumn<fardTable, Integer> cnicC;

    @FXML
    private Button lastFardButton;
    @FXML
    private Button firstFardButton;
    @FXML
    private Button fard1Button;
    @FXML
    private Button fard3Button;
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
        int cnic= found.get(1).personalInfo.getCnic();
        String cnicc=Integer.toString(cnic);
        cnicLabel.setText(cnicc);
        for(int i=0;i<found.size();i++) {
            System.out.println(found.get(1)+"-------");

        }
    }

    public void setTable(ObservableList<fardTable> array)
    {
        nameC.setCellValueFactory(new PropertyValueFactory<fardTable,String>("name"));
        khatoniNoC.setCellValueFactory(new PropertyValueFactory<fardTable,Integer>("khatnoi"));
        KhewatNoC.setCellValueFactory(new PropertyValueFactory<fardTable,Integer>("khewat"));
        cnicC.setCellValueFactory(new PropertyValueFactory<fardTable,Integer>("cnic"));
        fardTable.setItems(array);

        fardTable.setOnMouseClicked(mouseEvent -> {

            for(fardTable fardTable1:fardTable.getSelectionModel().getSelectedItems())
            {
                landDetails record=new landDetails();
                persistanceHandler phObj=persistanceFactory.getInstance().createPersistanceHandler("db");
                phObj.connectDB();
                record=phObj.getLandRecordForFard(fardTable1);
                try {
                    int fardDocNumber=controllerObj.selectDesiredLand(record);
                    billDetails bill=controllerObj.knowPayment(fardDocNumber);
                    System.out.println(bill);

                    FXMLLoader loader=new FXMLLoader(getClass().getResource("fard3.fxml"));
                    Parent root=(Parent) loader.load();
                    fard3Handler controller=loader.getController();
                    controller.setLabels(bill,record);
                    Stage stage=new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();


                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                // fard landFard=new fard(record);

                System.out.println(record);
            }
        });

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void  handleBUttons(ActionEvent event) throws IOException {

        if (event.getSource() == homeButton) {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            lrmis.loadAnother("mainPage.fxml",stage);

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
        else if(event.getSource()==fard1Button)
        {

            root= FXMLLoader.load(getClass().getResource("fard1.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else if(event.getSource()==fard3Button)
        {

            root= FXMLLoader.load(getClass().getResource("fard3.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }


    }
}
