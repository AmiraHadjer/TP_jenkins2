

import java.sql.*;
import java.util.logging.*;


public class DataBaseService {
	
    private static String className = "com.mysql.jdbc.Driver";
    private static String chaine = "jdbc:mysql://localhost:3306/studentbib";
    private static String username = "root";
    private static String password = getEncryptedPass();
    
    private static Logger logg=Logger.getLogger(DataBaseService.class.getName());;
    
    
    public Connection connecter()   {

        Connection con = null;
        try {
            Class.forName(className);
            con = DriverManager.getConnection(chaine, username, password);
        } catch (ClassNotFoundException |SQLException  e) {	
        	logg.log(Level.SEVERE, "connection non établie", e);
        }
        return con;
    }
    
    private static String getEncryptedPass() {
		
		return "root";
	}

	public String getStudentFirstName() {
    	   Connection conn = null;
    	   String s="";
           String query = "select * from student";
           conn = connecter();
           try (
            Statement st=conn.createStatement();
	        ResultSet rs = st.executeQuery(query);)
	        { 
        	   while(rs.next()) {
	        	s=rs.getString("firstName");
	        }
	        conn.close();
			//st.close();  
			
           } catch (SQLException e) {
			
        	   logg.log(Level.SEVERE, "getStudentFirstName: probleme dans la création du satement", e);
		   }
        
           
           return s;    	
    } 
   
    public boolean processLogin(String user) {
    	Connection conn = null;
    	boolean results = false;
    	conn = connecter();
    	String query = "select * "+" from User where userName=?";
        try(   
            
        	PreparedStatement pstmt = conn.prepareStatement(query);
            )
            {
        	pstmt.setString(1, user);
        	try(ResultSet res = pstmt.executeQuery();){
                	   results = res.next();
                       conn.close(); 
                   }catch (Exception e) {
                	   logg.log(Level.SEVERE, "probleme dans la création du ResultSet", e);
                   }
            } catch (Exception e) {
            	logg.log(Level.SEVERE, "probleme dans la préparation de statemente", e);
            }
           
        
        return results;
    } 
    
    public String getStudentLastName() {
  	   Connection conn = null;
  	   String s="";
       String query = "select * from student";
       conn = connecter();
       try (
                Statement st=conn.createStatement();
     	        ResultSet rs = st.executeQuery(query);){
 	        while(rs.next()) {
 	        	s=rs.getString("lastName");
 	        }
 	        
         } catch (SQLException e) {
        	 logg.log(Level.SEVERE, "getStudentLastName: probleme dans la création du satement", e);
      	}
         try {
 			conn.close(); 	
 		} catch (SQLException e) {
 			logg.log(Level.SEVERE, "getStudentLastName: probleme dans la fermeture de la connexion", e);
 		}
        
         
         return s;
    
  	
  }


  



}
