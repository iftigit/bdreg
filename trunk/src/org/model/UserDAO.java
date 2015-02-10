package org.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.table.UserDTO;

import util.connection.ConnectionManager;

public class UserDAO {
	
	
	public UserDTO validateLogin(String userId,String password)
	{
		UserDTO user=null;
		
		 Connection conn = ConnectionManager.getConnection();
		   String sql = " Select MST_USER.*,case when sysdate >= VALID_FROM then 'yes' else 'no' end S_DATE, " +
		   		" case when sysdate <= VALID_TO then 'yes' else 'no' end E_DATE from MST_USER Where userid=? and password=? ";
		   
		   PreparedStatement stmt = null;
		   ResultSet r = null;
			try
			{
				stmt = conn.prepareStatement(sql);
				
			    stmt.setString(1, userId);
			    stmt.setString(2, password);

			    
				r = stmt.executeQuery();
				if (r.next())
				{
					user=new UserDTO();
					user.setUserId(r.getString("USERID"));
					user.setPassword(r.getString("PASSWORD"));
					user.setUserType(r.getString("USER_TYPE"));
					user.setFullName(r.getString("FULL_NAME"));
					user.setValidFrom(r.getString("VALID_FROM"));
					user.setValidTo(r.getString("VALID_TO"));
					
					String startDate=r.getString("S_DATE");
					String endDate=r.getString("E_DATE");
		        	
		        	if(startDate.equalsIgnoreCase("yes") && endDate.equalsIgnoreCase("yes")){
		        		user.setAccessRight(1);
		        	}
		        	else
		        		user.setAccessRight(0);
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
		
		
		return user;
	}
	
	  
}
