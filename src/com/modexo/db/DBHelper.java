package com.modexo.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.modexo.model.UserBean;

public class DBHelper {

	private ConnectionProvider connectionProvider;
	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet resultSet;

	private static final String emp_login_query= "select * from modexo.employee where emp_id=? and emp_password=?";
	private static final String admin_login_query= "select * from modexo.admin where admin_id=? and admin_password=?";
	private static final String emp_checkstatus_query= "select status from modexo.employee_records where emp_id=?";
	
	private static final String emp_lastclockin_query= "select clockin from modexo.employee_records where emp_id=? order by clockin desc limit 1";
	private static final String emp_lastclockout_query= "select clockout from modexo.employee_records where emp_id=? order by clockout desc limit 1";
	
	private static final String emp_insert_query_in= "insert into modexo.employee_records (emp_id,clockin, clockout) values ('600001',now(),null,1)";
	private static final String emp_insert_query_out= "insert into modexo.employee_records (emp_id,clockin, clockout) values ('600001',null,now(),0)";
	
	public DBHelper() {
		connectionProvider = new ConnectionProvider();
	}


	public UserBean login() {
		UserBean user = null;
		try {
			connection = ConnectionProvider.getConnection();
			stmt = connection.createStatement();


			 resultSet= stmt.executeQuery(emp_login_query);
			while(resultSet.next()){  
				String emp_id = resultSet.getString(1);
				String emp_password = resultSet.getString(2);
				
				 user = new UserBean(emp_id, emp_password);
				
				}  

		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(connection!=null)
					connection.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		return user;
	}


}
