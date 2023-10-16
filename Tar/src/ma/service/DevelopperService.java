/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.service;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import ma.beans.Developper;
import ma.dao.Dao;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import ma.connexion.Connexion;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class DevelopperService implements Dao<Developper>{
    
    @Override
    public boolean addDevelopper(Developper d){
        try {
              String req2 = "INSERT INTO DevData VALUES ('" + d.getName() + "','" + d.getJour() + "','" + d.getNbScripts() +"')";
              Statement st = Connexion.getConnection().createStatement();
              if (st.executeUpdate(req2)==1) {
                  System.out.println("values added ");
                  return true;
                
            }
              
        } catch (SQLException e) {
            System.out.println("erreur d'ajoute d'un developper : "+e.getMessage());
     
      
        
  
}
               return false;
    }
    @Override
    public boolean deleteTable(String nom){
        try {
            Statement st = Connexion.getConnection().createStatement();
            String req = "DROP TABLE "+nom;
            if(st.executeUpdate(req)==1){
                 return  true;
            }
          
        } catch (SQLException e) {
            System.out.println("error de supression du tableau :"+e.getMessage());
            
        }
        return false;
    }
    @Override
    public List<Developper>  exoJdbcMaxScripts(){
        List <Developper> Developers = new ArrayList<>();
      ResultSet myRs = null;
        try{
         
        Statement st = Connexion.getConnection().createStatement();
        String request = "SELECT developper, jour, MAX(nbscripts)  FROM devdata GROUP BY jour "; 
        myRs = st.executeQuery(request);
            while (myRs.next()) {
                
                Developers.add(new Developper(myRs.getString(1), myRs.getString(2), myRs.getInt(3)));
       
                
            }
        }catch(SQLException e){
            System.out.println("error sql");
        }
        return Developers;
       
    }
    @Override
    public List<String> exoJdbcTrie(){
        List<String> developpers = new ArrayList<>();
        ResultSet myRs = null ;
        try {
            Statement st = Connexion.getConnection().createStatement();
            String req = "SELECT developper, SUM(nbscripts) AS c FROM devdata GROUP BY developper ORDER BY c DESC";
            myRs = st.executeQuery(req);
            while (myRs.next()) {
                developpers.add(myRs.getString(1)+": "+myRs.getString(2));
                
                               
            }
            
        } catch (SQLException e) {
            System.out.println("error sql"+e.getMessage());
        }
        return developpers;
    }
    @Override
    public void exoJdbcSemaine(){
        ResultSet myRs = null;
    
        try {
            Statement st = Connexion.getConnection().createStatement();
            String req = "SELECT SUM(nbscripts) FROM devdata";
            myRs = st.executeQuery(req);
            while (myRs.next()) {
                System.out.println("le nombre de script réaliser dans ube selaine est :"+myRs.getInt(1));
             
                
            }
            
        } catch (SQLException e) {
            System.out.println("ereur sql"+e.getMessage());
            
        }
    
       
    }
    public void exoJdbcNbscripts(String nom){
         ResultSet myRs;
        try {
            Statement st = Connexion.getConnection().createStatement();
          
               String req = "SELECT developper, sum(nbscripts) FROM devdata GROUP BY developper HAVING developper = ' "+ nom+"'";
             myRs = st.executeQuery(req);
             while(myRs.next()){
                    System.out.println(myRs.getString("sum(nbscripts)"));
                     System.out.println("developper : "+myRs.getString("developper")+"       nbscripts: "+myRs.getInt("sum(nbscripts)"));
             }
            }
        catch (SQLException e) {
            System.out.println("error sql");
        }
    }
    @Override
    public void afficheMetaData(){
        String req = null;
        ResultSet myRs;
        try {
             Scanner input = new Scanner(System.in);
        System.out.println("entrer la resuete sql souhaite a executer :");
        req = input.nextLine();
        Statement st = Connexion.getConnection().createStatement();
        if (req.toLowerCase().startsWith("select")){
             myRs = st.executeQuery(req);
             ResultSetMetaData metaData = myRs.getMetaData();
             int columnCount = metaData.getColumnCount();
             System.out.println("le nombre de colonne du tableau est :"+columnCount);
             //affichage le conteneu des colomn 
             for(int i=1; i <= columnCount; i++){
                 String columnName = metaData.getColumnName(i);
                 String ColumnType = metaData.getColumnTypeName(i);
                 System.out.println("Nome de la colonne : "+columnName +" son type :"+ColumnType);
                 
             }
                //affichage du contenu ligne par ligne 
          System.out.println("affichage le contenu de la table :");
          while (myRs.next()){
              System.out.println("\n");
              for(int i=1 ;i <= columnCount ;i++){

                  System.out.print(myRs.getString(i) +"\t");
              }
         
                       }
       
             
             
        }else{
            int nbLingeModifie = st.executeUpdate(req);
            System.out.println("le nombre de ligne modifie est : "+nbLingeModifie);
        }
        
         
         
        } catch (SQLException e) {
            System.out.println("error sql");
        }
       
        
        
    }
  
            
}
    
