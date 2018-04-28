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

	public static void ClockInOutEntry(UserBean bean) {
		Connection con = null;
		PreparedStatement psinsertsts = null;
		PreparedStatement psselectsts = null;
		PreparedStatement psupdatests = null;


		PreparedStatement psselect = null;
		PreparedStatement psinsert = null;
		PreparedStatement psupdate = null;


		ResultSet rs= null;
		ResultSet rs1= null;
		try{  


			con=ConnectionProvider.getConnection();  

			psselectsts=con.prepareStatement("select emp_status from modexo.emp_status where emp_id=?");
			psselectsts.setString(1,bean.getEmpid());
			rs=psselectsts.executeQuery();


			psselect=con.prepareStatement("select * from modexo.employee_records where emp_id=? and emp_clockdate=?");
			psselect.setString(1, bean.getEmpid());
			 
			rs1=psselect.executeQuery();


			if (!rs.next() && !rs1.next()) {
				psinsertsts=con.prepareStatement("insert into modexo.emp_status (emp_id,emp_status) values (?,?)");
				psinsertsts.setString(1,bean.getEmpid());
				psinsertsts.setInt(2, 1);
				int val =psinsertsts.executeUpdate();
				System.out.println("Insertion successful with row modification in table emp_status "+ val);

				psinsert=con.prepareStatement("insert into modexo.employee_records (emp_id,clockin, clockout,emp_clockdate) values (?,?,?,?)");
				psinsert.setString(1,bean.getEmpid());
				psinsert.setTimestamp(2, java.sql.Timestamp.from(java.time.Instant.now()));
				psinsert.setTimestamp(3, null);
				psinsert.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
				int val1 =psinsert.executeUpdate();
				System.out.println("Insertion successful with row modification in table employee_records"+ val1);

			}
			else {
				psupdatests=con.prepareStatement("update modexo.emp_status set emp_status=?  where emp_id=?");
				psupdate=con.prepareStatement("update modexo.employee_records set clockout=?  where emp_id=? and emp_clockdate=?");
				if (rs.getInt(1)==1 && rs1.getTimestamp(1)==null && rs1.getDate(3)==) {
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


	private static void CheckClockInOutStatus(int empid) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		try{  
			con=ConnectionProvider.getConnection();  
			ps=con.prepareStatement("select * from modexo.emp_status where emp_id=? and emp_status=?");





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
	}
}  
