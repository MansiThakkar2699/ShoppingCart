package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.OrderBean;
import com.util.DbConnection;

public class OrderDao {

	public int CountOrder() {
		int totalorder = 0;
		try
		{
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select count(*) as totalorder from public.order ");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			totalorder = rs.getInt("totalorder");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return totalorder;
	}
	public int PendingOrder()
	{
		int pendingorder = 0;
		try
		{
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select count(*) as pendingorder from public.order where orderstatus!='complete'");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			pendingorder = rs.getInt("pendingorder");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return pendingorder;
	}
	public ArrayList<OrderBean> listOrder(int id) {
		ArrayList<OrderBean> obean = new ArrayList<OrderBean>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from public.order where user_id = ?");
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				OrderBean ob = new OrderBean();
				ob.setO_id(rs.getInt("o_id"));
				ob.setUser_id(rs.getInt("user_id"));
				obean.add(ob);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obean;
		
	}

}
