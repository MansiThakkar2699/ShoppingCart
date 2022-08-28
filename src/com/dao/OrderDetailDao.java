package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.OrderDetailBean;
import com.util.DbConnection;

public class OrderDetailDao {

	public ArrayList<OrderDetailBean> listOrderDetail(int oid) 
	{
		ArrayList<OrderDetailBean> odbean = new ArrayList<OrderDetailBean>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select o.*,p.proname from public.orderdetail o,public.product p where o.proid = p.proid and o_id = ?");
			pstmt.setInt(1,oid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				OrderDetailBean od = new OrderDetailBean();
				od.setProname(rs.getString("proname"));
				od.setAmount(rs.getInt("amount"));
				odbean.add(od);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return odbean;
	}

}
