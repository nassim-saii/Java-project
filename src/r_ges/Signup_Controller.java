/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package R_Ges;

import java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import r_ges.conec;

/**
 * FXML Controller class
 *
 * @author Nassim
 */
public class Signup_Controller implements Initializable {

    @FXML
    private TextField tf_name;
    @FXML
    private TextField tf_surname;
    @FXML
    private TextField tf_date;
    @FXML
    private TextField tf_post;
    @FXML
    private TextField tf_num;
    @FXML
    private PasswordField tf_pass;
    @FXML
    private Button insert_signup_btn;


    
    Connection conn = null;
    ResultSet rs = null ;
    PreparedStatement pst = null;

     
    private void Login(ActionEvent event)throws Exception {
        conn =  conec.Connect3_sql();
    }
    
    /**
     * Initializes the controller class.
     */



    @FXML
    public void addUser(ActionEvent event) throws SQLException{
        conn =  conec.Connect3_sql();
        String sql="INSERT INTO `users`(`worknum`, `name`, `surname`, `age`, `post`, `passwd`) VALUES(?,?,?,?,?,?)";
        try{
            pst =conn.prepareStatement(sql);
            pst.setString(1, tf_num.getText());
            pst.setString(2, tf_name.getText());
            pst.setString(3, tf_surname.getText());
            pst.setString(4, tf_date.getText());
            pst.setString(5, tf_post.getText());
            pst.setString(6, tf_pass.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "SAVED");
            insert_signup_btn.getScene().getWindow().hide();
            
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.setTitle("Log-in");
            primaryStage.show();

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
    }

        @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    


}