/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package r_ges;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import r_ges.conec;

/**
 * FXML Controller class
 *
 * @author Nassim
 */
public class MonitoringController implements Initializable {




    public ObservableList<stockk> getStockkList() {
        return stockkList;
    }
    
    @FXML
    private TableColumn<stockk, String> tb_ref;
    @FXML
    private TableColumn<stockk, String> tb_typ;
    @FXML
    private TableColumn<stockk, String> tb_qte;
    @FXML
    private TableColumn<stockk, String> tb_din;
    @FXML
    private TableColumn<stockk, String> tb_dout;
    @FXML
    private Button back_btn1;
    @FXML
    private TableView<?> stockk_tab;

    public TableColumn<stockk, String> getTb_ref() {
        return tb_ref;
    }

    public TableColumn<stockk, String> getTb_typ() {
        return tb_typ;
    }

    public TableColumn<stockk, String> getTb_qte() {
        return tb_qte;
    }

    public TableColumn<stockk, String> getTb_din() {
        return tb_din;
    }

    public TableColumn<stockk, String> getTb_dout() {
        return tb_dout;
    }

    public Button getBack_btn1() {
        return back_btn1;
    }


    public ResultSet getRs() {
        return rs;
    }

    public PreparedStatement getPst() {
        return pst;
    }


    
    
    
    
    
    Connection conn = null;
    ResultSet rs = null ;
    PreparedStatement pst = null;
    
    ObservableList<stockk> stockkList = FXCollections.observableArrayList( );

     
    private void Login(ActionEvent event)throws Exception {
        conn =  conec.Connect3_sql();
    }



    private class stockk{
        String ref,type,qte,d_in,d_out;

        private stockk(String ref, String type, String qte, String d_in, String d_out) {
            this.ref=ref;
            this.type=type;
            this.qte=qte;
            this.d_in=d_in;
            this.d_out=d_out;
        }   
        
    }
    
    
    private ObservableList<stockk> refrechlist(){
        
        String sql ="SELECT * FROM `stock` ";
        try{
            pst =conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                stockkList.add(new stockk(
                                rs.getString("ref"),    
                                rs.getString("type"),
                                rs.getString("qte"),
                                rs.getString("d_in"),
                                rs.getString("d_out")));
            stockkList.clear();
                
 
        
        /*stockk_tab.setItems(stockkList);
          */      
    
        }}catch(Exception ex){
             JOptionPane.showMessageDialog(null, ex);
            
        }
        return stockkList;
        
        }
        
    

  
        
    
    public void addsStock(ActionEvent event){
    conn =  conec.Connect3_sql();

    
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = conec.Connect3_sql();
        ObservableList<stockk> list = refrechlist();
        
        tb_ref.setCellValueFactory(new PropertyValueFactory<>("ref"));
        tb_typ.setCellValueFactory(new PropertyValueFactory<>("type"));
        tb_qte.setCellValueFactory(new PropertyValueFactory<>("qte"));
        tb_din.setCellValueFactory(new PropertyValueFactory<>("d_in"));
        tb_dout.setCellValueFactory(new PropertyValueFactory<>("d_out"));
    /*        stockkList = MonitoringController().refrechlist();
        stockkList = refrechlist();
        stockk_tab.setItems(list);
        
        System.out.println(ObservableList<stockk> list);
        refrechlist();*/

        

        
            
       
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if(event.getSource() == back_btn1){
            Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);             
            primaryStage.setTitle("Dashboard");
            primaryStage.show();
            back_btn1.getScene().getWindow().hide();
        
    }
    
}
}