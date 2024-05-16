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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Nassim
 */
public class Add_stockController implements Initializable {

    @FXML
    private Button validate_btn;
    @FXML
    private TextField tf_ref;
    @FXML
    private TextField tf_typ;
    @FXML
    private TextField tf_qte;
    @FXML
    private TextField tf_din;
    @FXML
    private TextField tf_dout;
    @FXML
    private Button back_btn;   
    
    
    
    
    Connection conn = null;
    ResultSet rs = null ;
    PreparedStatement pst = null;
 

     
    private void Login(ActionEvent event)throws Exception {
        conn =  conec.Connect3_sql();
    }
    
    @FXML
    public void addsStock(ActionEvent event){
    conn =  conec.Connect3_sql();
    String sql ="INSERT INTO `stock`(`ref`, `type`, `qte`, `d_in`, `d_out`) VALUES (?,?,?,?,?)";
    try{
        pst =conn.prepareStatement(sql);
        pst.setString(1, tf_ref.getText());
        pst.setString(2, tf_typ.getText());
        pst.setString(3, tf_qte.getText());
        pst.setString(4, tf_din.getText());
        pst.setString(5, tf_dout.getText());
        pst.execute();
        JOptionPane.showMessageDialog(null, "SAVED");
      

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }        
        
        

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
        if(event.getSource() == back_btn){
            Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);  
            primaryStage.setTitle("MONITORIN_PAGE");
            primaryStage.show();
            back_btn.getScene().getWindow().hide();
        }
    }
    
}
