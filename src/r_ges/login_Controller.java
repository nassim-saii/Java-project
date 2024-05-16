/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package R_Ges;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class login_Controller implements Initializable {

    @FXML
    private Button login_btn;
    @FXML
    private TextField textusername;
    @FXML
    private PasswordField textpasswd;
    @FXML
    private Button signupbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    Connection conn = null;
    ResultSet rs = null ;
    PreparedStatement pst = null;
     
    @FXML
    private void Login(ActionEvent event)throws Exception {
        conn =  conec.Connect3_sql();
        String sql ="SELECT * FROM `users` WHERE name = ? and  passwd = ? ";
        try{
            pst =conn.prepareStatement(sql);
            pst.setString(1,textusername.getText());
            pst.setString(2,textpasswd.getText());
            rs =pst.executeQuery();
            if(rs.next()){
                /*JOptionPane.showMessageDialog(null, "Correct");*/
                login_btn.getScene().getWindow().hide();
                
                Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                Scene scene = new Scene(root);
                Stage primaryStage = new Stage();
                primaryStage.setScene(scene);
                primaryStage.setTitle("Dashboard");
                primaryStage.show();
            }else{
                JOptionPane.showMessageDialog(null, "InCorrect");

            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);

            
        }
        
    }
    
    
    @FXML

    private void handleButtonAction(ActionEvent event) throws IOException {
        if(event.getSource() == signupbtn){
            signupbtn.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("sign_up.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.setTitle("Sign-up");
            primaryStage.show();
        
        

}
}

}
