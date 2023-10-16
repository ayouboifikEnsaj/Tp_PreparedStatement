
package tp1;

import java.sql.*;


public class Test {
    
    public static void save(Site s){
           //information a la base de donneé
        String url = "jdbc:mysql://localhost/tp1";
        String login = "root";
        String passworrd = "";
        Connection on = null;
        Statement st = null;
        ResultSet myRs = null ;
        
           try {
            // etape 1 chanrgement du driver 
            Class.forName("com.mysql.jdbc.Driver");
            
            //etape 2 récuperation de la connexion 
            on = DriverManager.getConnection(url, login, passworrd);
            st = on.createStatement();
            String req1 = "insert into site values (null, '" + s.getName() + "')";
            
            st.executeUpdate(req1);
            
        }
        catch (SQLException e){
            System.out.println("Erreur SQL");
        }
        catch (ClassNotFoundException e){
          System.out.println("Impossible de charger le driver ");
            
            
        }finally{
            //liberer les resoource de la memoire 
            try {
                on.close();
                st.close();
                
            }catch (SQLException e){
                System.out.println("imposible de libere l'espace");
            }
        }

 
  
            
        }
        public static void main(String args[]){
        save(new Site("Safi"));
        save(new Site("Csablanca"));
        save(new Site("mohammedia"));
    }
   

            
}





