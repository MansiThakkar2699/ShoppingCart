package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.BrandBean;
import com.bean.CategoryBean;
import com.util.DbConnection;

public class BrandDao 
{
	public void insertBrand(BrandBean b) throws ClassNotFoundException, SQLException 
	{
		Connection con=DbConnection.getConnection();
		PreparedStatement pstmt=con.prepareStatement("insert into public.brand(brand_name,brand_site)values(?,?)");
		pstmt.setString(1,b.getBrand_name());
		pstmt.setString(2,b.getBrand_site());
		pstmt.executeUpdate();
	}
	public ArrayList<BrandBean> listBrand() {
		ArrayList<BrandBean> brandList =new ArrayList<BrandBean>();
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select * from brand");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				BrandBean b = new BrandBean();
				b.setBrand_id(rs.getInt("brand_id"));
				b.setBrand_name(rs.getString("brand_name"));
				b.setBrand_site(rs.getString("brand_site"));
				brandList.add(b);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return brandList;
	}
	public Boolean deleteBrand(BrandBean b) 
	{
		Connection con;
		try {
			con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from brand where brand_id = ?");
			pstmt.setInt(1,b.getBrand_id());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	public BrandBean getDataByPk(int brand_id) 
	{
		Connection con=null;
		BrandBean b=new BrandBean();
		PreparedStatement pstmt=null;
		try
		{
			con=DbConnection.getConnection();
			pstmt=con.prepareStatement("select * from brand where brand_id = ?");
			pstmt.setInt(1,brand_id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				b.setBrand_id(rs.getInt("brand_id"));
				b.setBrand_name(rs.getString("brand_name"));
				b.setBrand_site(rs.getString("brand_site"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return b;
	}
	public Boolean UpadateBrand(BrandBean b) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		try
		{
			con=DbConnection.getConnection();
			pstmt=con.prepareStatement("Update brand set brand_name=?,brand_site=? where brand_id=?");
			pstmt.setString(1,b.getBrand_name());
			pstmt.setString(2,b.getBrand_site());
			pstmt.setInt(3,b.getBrand_id());
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
}		