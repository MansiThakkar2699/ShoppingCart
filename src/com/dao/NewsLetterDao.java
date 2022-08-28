package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.NewsLetterBean;
import com.util.DbConnection;

public class NewsLetterDao {

	public void insertEmail(NewsLetterBean nbean) {
		// TODO Auto-generated method stub
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into public.newsletter(email)values(?)");
			pstmt.setString(1,nbean.getEmail());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<NewsLetterBean> getEmail() {
		// TODO Auto-generated method stub
		ArrayList<NewsLetterBean> email = new ArrayList<NewsLetterBean>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from newsletter");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				NewsLetterBean nbean = new NewsLetterBean();
				nbean.setEmail(rs.getString("email"));
				email.add(nbean);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email;
	}
}
