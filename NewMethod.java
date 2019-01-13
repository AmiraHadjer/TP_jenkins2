//add
public String getStudentLastName() {
 	   Connection conn = null;
 	   String s="";
 	   Statement st = null;
        String query = "select * from student";
        conn = connecter();
        try {
			st=conn.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        while(rs.next()) {
	        	s=rs.getString("lastName");
	        }
	        
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			conn.close(); 
			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        
        return s;
   
 	
 }
