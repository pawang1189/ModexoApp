package com.modexo.controller;

import java.sql.*;

import com.modexo.db.ConnectionProvider;

import com.modexo.model.UserBean; 

public class ClockInOut {  
	
	

	public static boolean validate(UserBean bean){  
		boolean status=false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		try{  
			con=ConnectionProvider.getConnection();  

			ps=con.prepareStatement(  
					"select * from modexo.employee where emp_id=? and emp_password=?");  

			ps.setString(1,bean.getEmpid());
			//			String emp_id=bean.getEmpid();
			//			System.out.println(emp_id);

			ps.setString(2, bean.getEmppassword());  
			//			String emp_password=bean.getPassword();
			//			System.out.println(emp_password);

			rs=ps.executeQuery();  
			status=rs.next();  


		}catch(Exception e){
			e.printStackTrace();
		}  
		finally {
			if (con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return status;  

	}  

	public static void ClockInOutEntryStatus(UserBean bean) {
		Connection con = null;
		PreparedStatement psinsertsts = null;
		PreparedStatement psselectsts = null;
		PreparedStatement psupdatests = null;


		ResultSet rs= null;

		try{  


			con=ConnectionProvider.getConnection();  

			psselectsts=con.prepareStatement("select emp_status from modexo.emp_status where emp_id=?");
			psselectsts.setString(1,bean.getEmpid());
			rs=psselectsts.executeQuery();




			if (!rs.next()) {
				psinsertsts=con.prepareStatement("insert into modexo.emp_status (emp_id,emp_status) values (?,?)");
				psinsertsts.setString(1,bean.getEmpid());
				psinsertsts.setInt(2, 1);
				int val =psinsertsts.executeUpdate();
				System.out.println("Insertion successful with row modification in table emp_status "+ val);

			}
			else {
				psupdatests=con.prepareStatement("update modexo.emp_status set emp_status=?  where emp_id=?");
				if (rs.getInt(1)==1 ) {
					psupdatests.setInt(1,0);
					psupdatests.setInt(2,Integer.parseInt(bean.getEmpid()));
					psupdatests.executeUpdate();
					System.out.println("Records updated for clockout");
				}
				else
				{
					psupdatests.setInt(1, 1);
					psupdatests.setInt(2,Integer.parseInt(bean.getEmpid()));

					psupdatests.executeUpdate();
					System.out.println("Records updated for clockin");
				}



			}


		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (psinsertsts!=null)
				try {
					psinsertsts.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}



		}
	}

	public static void ClockInOutEntryStatusRecords(UserBean bean) {
		Connection con = null;
		PreparedStatement psinsert = null;
		PreparedStatement psselect = null;
		//PreparedStatement psupdatein = null;
		PreparedStatement psupdateout = null;


		ResultSet rs= null;

		try{  


			con=ConnectionProvider.getConnection();  

			psselect=con.prepareStatement("select * from modexo.emp_clockhistory where emp_id=? and emp_clockdate=?");
			psselect.setString(1,bean.getEmpid());
			psselect.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
			rs=psselect.executeQuery();




			if (!rs.next()) {
				psinsert=con.prepareStatement("insert into modexo.emp_clockhistory (emp_id,emp_clockin,emp_clockout,emp_clockdate) values (?,?,?,?)");
				psinsert.setString(1,bean.getEmpid());
				psinsert.setTimestamp(2,java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
				psinsert.setTimestamp(3,null);
				psinsert.setDate(4,java.sql.Date.valueOf(java.time.LocalDate.now()));
				int val =psinsert.executeUpdate();
				System.out.println("Insertion successful with row modification in table emp_clockhistory "+ val);

			}
			else {
				psupdateout=con.prepareStatement("update modexo.emp_clockhistory set emp_clockout=?  where emp_id=? and emp_clockin=? and emp_clockdate=?");
				psinsert=con.prepareStatement("insert into modexo.emp_clockhistory (emp_id,emp_clockin,emp_clockout,emp_clockdate) values (?,?,?,?)");

				while (rs.next()) {

					Timestamp clockin = rs.getTimestamp(1); 
					Integer empid=rs.getInt(2); 
					Timestamp clockout =rs.getTimestamp(3); 
					Date clockdate=rs.getDate(4); 

					if (clockin!=null && clockout!=null && clockdate!=null && empid!=null )  //new entry 

					{
						psinsert.setString(1,bean.getEmpid());
						psinsert.setTimestamp(2,java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
						psinsert.setTimestamp(3,null);
						psinsert.setDate(4,java.sql.Date.valueOf(java.time.LocalDate.now()));

					}
					else if (clockin!=null && clockout==null ) {
						psupdateout.setTimestamp(1,java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
					}

				}
				
			}
			
		}		


			
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (con!=null)
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if (psinsert!=null)
					try {
						psinsert.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}



			}
		}
	}  
