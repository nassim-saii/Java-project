/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package r_ges;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nassim
 */
public class DashboardController implements Initializable {

    @FXML
    private Button add_btn;
    @FXML
    private Button remove_btn;
    @FXML
    private Button monitor_btn;
    @FXML
    private Button facture_btn;
    @FXML
    private Button logout_btn;
    
    
    
    
    Connection conn = null;
    ResultSet rs = null ;
    PreparedStatement pst = null;

     
    private void Login(ActionEvent event)throws Exception {
        conn =  conec.Connect3_sql();
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if(event.getSource() == add_btn){
            add_btn.getScene().getWindow().hide();    
            Parent root = FXMLLoader.load(getClass().getResource("add_stock.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.setTitle("Add_Stock");
            primaryStage.show();   
        }else if(event.getSource() == logout_btn){
            logout_btn.getScene().getWindow().hide();    
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.setTitle("Log-in");
            primaryStage.show();  
        }else if(event.getSource() == monitor_btn){
            logout_btn.getScene().getWindow().hide();    
            Parent root = FXMLLoader.load(getClass().getResource("Monitoring.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.setTitle("Monitoring");
            primaryStage.show(); 
        
        }else if(event.getSource() == remove_btn){
            remove_btn.getScene().getWindow().hide();    
            Parent root = FXMLLoader.load(getClass().getResource("take_off.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.setTitle("Take_off");
            primaryStage.show(); 
    
}}
}