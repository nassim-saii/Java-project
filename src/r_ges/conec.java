/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package r_ges;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nassim
 */
public class conec { 
    Connection conn = null ;
    public static Connection Connect3_sql() {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/r_mangment","root","") ;
            return conn;
                 
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("ERROR : "+ e.getMessage());
            
        }
        return null;
    }
}
   /* public static void changeScene(ActionEvent event,String fxmlFile, String title , String username){
        Parent root = null ;
        if(username != null && )
    }*/
