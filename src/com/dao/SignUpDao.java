package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.UserBean;
import com.util.DbConnection;

public class SignUpDao 
{
	public void InsertUser(UserBean userBean)
	{
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("insert into public.user(fname,lname,email,password,gender,roleid,securityque,securityans) values(?,?,?,?,?,?,?,?)");
			pstmt.setString(1,userBean.getFname());
			pstmt.setString(2,userBean.getLname());
			pstmt.setString(3,userBean.getEmail());
			pstmt.setString(4,userBean.getPassword());
			pstmt.setString(5,userBean.getGender());
			pstmt.setInt(6, 1);
			pstmt.setString(7,userBean.getSecurityque());
			pstmt.setString(8,userBean.getSecurityans());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public UserBean login(String email, String password) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstmt=null;
		try
		{
			con=DbConnection.getConnection();
			pstmt=con.prepareStatement("select * from public.user where email = ? and password = ?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				UserBean userBean=new UserBean();
				int id=rs.getInt("id");
				String fname=rs.getString("fname");
				String lname=rs.getString("lname");
				String gender=rs.getString("gender");
				 email=rs.getString("email");
				
				userBean.setId(id);
				userBean.setFname(fname);
				userBean.setLname(lname);
				userBean.setGender(gender);
				userBean.setEmail(email);
				userBean.setPassword(password);
				userBean.setRoleId(rs.getInt("roleId"));
				return userBean;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public UserBean getDataByEmail(String email) 
	{
		UserBean ubean = null;
		Connection con;
		System.out.println("dao"+email);
		try {
			con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from public.user where email = ?");
			pstmt.setString(1,email);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				ubean = new UserBean();
				ubean.setEmail(rs.getString("email"));
				ubean.setPassword(rs.getString("password"));
				ubean.setFname(rs.getString("fname"));
				ubean.setSecurityque(rs.getString("securityque"));
				ubean.setSecurityans(rs.getString("securityans"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ubean);
		// TODO Auto-generated method stub
		return ubean;
	}

	public boolean updatePassword(String email, String newPassword) 
	{
		System.out.println("updatePassword");
		// TODO Auto-generated method stub
		UserBean ubean = new UserBean();
		Connection con;
		try {
			con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update public.user set password = ? where email = ?");
			//ubean.setPassword(newPassword);
			//ubean.setEmail(email);
			pstmt.setString(1,newPassword);
			pstmt.setString(2,email);
			System.out.println(email);
			System.out.println(newPassword);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true; 
	}
	public int CountUser() {
		int totaluser  = 0;
		try
		{
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select count(*) as totaluser from public.user where roleid = 1");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			totaluser = rs.getInt("totaluser");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return totaluser;
	}
	public int AdminCount()
	{
		int totaladmin = 0;
		try
		{
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt= con.prepareStatement("select count(*) as totaladmin from public.user where roleid = 2");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			totaladmin = rs.getInt("totaladmin");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return totaladmin;
	}
}