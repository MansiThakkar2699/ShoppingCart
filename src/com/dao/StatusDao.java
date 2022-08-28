package com.dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.StatusBean;
import com.util.DbConnection;
/**
 * Servlet implementation class StatusDao
 */
@WebServlet("/StatusDao")
public class StatusDao extends HttpServlet 
{
	public void insertStatus(StatusBean sbean) 
	{
		Connection con;
		PreparedStatement pstmt;
		try {
			con = DbConnection.getConnection();
			pstmt=con.prepareStatement("insert into public.status(status)values(?)");
			pstmt.setString(1,sbean.getStatus());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<StatusBean> listStatus() 
	{
		ArrayList<StatusBean> statusList = new ArrayList<StatusBean>();
		Connection con;
		PreparedStatement pstmt;
		try {
			con = DbConnection.getConnection();
			pstmt=con.prepareStatement("select * from status");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				StatusBean sbean=new StatusBean();
				sbean.setS_id(rs.getInt("s_id"));
				sbean.setStatus(rs.getString("status"));
				statusList.add(sbean);	
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return statusList;
	}

	public boolean deleteStatus(StatusBean sbean) 
	{
		Connection con;
		PreparedStatement pstmt;
		try {
			con = DbConnection.getConnection();
			pstmt=con.prepareStatement("delete from status where s_id = ?");
			pstmt.setInt(1, sbean.getS_id());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public StatusBean getDataByPk(int s_id) 
	{
		Connection con;
		StatusBean sbean = new StatusBean();
		PreparedStatement pstmt;
		try {
			con = DbConnection.getConnection();
			pstmt=con.prepareStatement("select * from status where s_id = ?");
			pstmt.setInt(1,s_id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				sbean.setS_id(rs.getInt("s_id"));
				sbean.setStatus(rs.getString("status"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sbean;
	}

	public boolean updateStatus(StatusBean sbean) 
	{
		Connection con;
		PreparedStatement pstmt;
		try {
			con = DbConnection.getConnection();
			pstmt=con.prepareStatement("update status set status = ? where s_id = ?");
			pstmt.setString(1,sbean.getStatus());
			pstmt.setInt(2,sbean.getS_id());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}