package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.CategoryBean;
import com.util.DbConnection;
public class CategoryDao 
{
	public void insertCategory(CategoryBean c) throws ClassNotFoundException, SQLException 
	{
		Connection con=DbConnection.getConnection();
		PreparedStatement pstmt=con.prepareStatement("insert into public.category(cat_name)values(?)");
		pstmt.setString(1,c.getCat_name());
		pstmt.executeUpdate();
	}

	public ArrayList<CategoryBean> listCategory() throws ClassNotFoundException, SQLException {
		ArrayList<CategoryBean> categoryList=new ArrayList<CategoryBean>();
		try
		{
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select * from category");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				CategoryBean categoryBean=new CategoryBean();
				categoryBean.setCat_id(rs.getInt("cat_id"));
				categoryBean.setCat_name(rs.getString("cat_name"));
				categoryList.add(categoryBean);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return categoryList;
	}

	public Boolean DeleteCategory(CategoryBean categorybean) 
	{
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("delete from category where cat_id=?");
			pstmt.setInt(1,categorybean.getCat_id());
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
	public CategoryBean getDataByPk(int cat_id) 
	{
		Connection con=null;
		CategoryBean categoryBean=new CategoryBean();
		PreparedStatement pstmt=null;
		try
		{
			con=DbConnection.getConnection();
			pstmt=con.prepareStatement("select * from category where cat_id = ?");
			pstmt.setInt(1,cat_id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				categoryBean.setCat_id(rs.getInt("cat_id"));
				categoryBean.setCat_name(rs.getString("cat_name"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return categoryBean;
	}

	public Boolean UpadateCategory(CategoryBean categorybean) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		try
		{
			con=DbConnection.getConnection();
			pstmt=con.prepareStatement("Update category set cat_name=? where cat_id=?");
			pstmt.setString(1, categorybean.getCat_name());
			pstmt.setInt(2,categorybean.getCat_id());
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