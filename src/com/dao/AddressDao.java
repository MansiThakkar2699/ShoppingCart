package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.AddressBean;
import com.util.DbConnection;

public class AddressDao {

	public void insertAddress(AddressBean abean) {
		// TODO Auto-generated method stub
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into public.address(user_id,address)values(?,?)");
			pstmt.setInt(1,abean.getUser_id());
			pstmt.setString(2,abean.getAddress());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<AddressBean> ListAddress(int user_id) {
		// TODO Auto-generated method stub
		ArrayList<AddressBean> addressList = new ArrayList<AddressBean>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select a.*,u.fname from public.address a , public.user u where a.user_id = u.id and a.user_id = ?");
			pstmt.setInt(1, user_id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				AddressBean abean = new AddressBean();
				abean.setAdd_id(rs.getInt("add_id"));
				abean.setFname(rs.getString("fname"));
				abean.setAddress(rs.getString("address"));
				addressList.add(abean);
			}
			System.out.println(addressList.size());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addressList;
	}

}
