package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.ProductBean;
import com.bean.SubCategoryBean;
import com.util.DbConnection;

public class ProductDao 
{
	public ArrayList<ProductBean> listProduct()
	{
		System.out.println("productdao called");
		ArrayList<ProductBean> productList=new ArrayList<ProductBean>();
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select p.*,s.cat_name,sb.subcat_name,b.brand_name from category s,subcategory sb,brand b,product p where s.cat_id = p.cat_id and sb.subcat_id=p.subcat_id and b.brand_id = p.brand_id");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				ProductBean pbean=new ProductBean();
				pbean.setProid(rs.getInt("proid"));
				pbean.setProname(rs.getString("proname"));
				pbean.setCat_id(rs.getInt("cat_id"));
				pbean.setCat_name(rs.getString("cat_name"));
				pbean.setSubcat_id(rs.getInt("subcat_id"));
				pbean.setSubcat_name(rs.getString("subcat_name"));
				pbean.setBrand_id(rs.getInt("brand_id"));
				pbean.setBrand_name(rs.getString("brand_name"));
				pbean.setPrice(rs.getInt("price"));
				pbean.setQuntity(rs.getInt("quantity"));
				pbean.setProdinfo(rs.getString("prodinfo"));
				pbean.setOtherinfo(rs.getString("otherinfo"));
				productList.add(pbean);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	public void insertProduct(ProductBean pbean) 
	{
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("insert into public.product(proname,cat_id,subcat_id,brand_id,price,quantity,prodinfo,otherinfo)values(?,?,?,?,?,?,?,?)");
			pstmt.setString(1,pbean.getProname());
			pstmt.setInt(2,pbean.getCat_id());
			pstmt.setInt(3,pbean.getSubcat_id());
			pstmt.setInt(4,pbean.getBrand_id());
			pstmt.setInt(5,pbean.getPrice());
			pstmt.setInt(6,pbean.getQuntity());
			pstmt.setString(7,pbean.getProdinfo());
			System.out.println("dao called"+pbean.getProdinfo());
			pstmt.setString(8,pbean.getOtherinfo());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public ProductBean getDataByPk(int proid) {
		// TODO Auto-generated method stub
		Connection con=null;
		ProductBean pbean=new ProductBean();
		PreparedStatement pstmt=null;
		try
		{
			con=DbConnection.getConnection();
			pstmt=con.prepareStatement("select * from product where proid = ?");
			pstmt.setInt(1,proid);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				pbean.setProid(rs.getInt("proid"));
				pbean.setProname(rs.getString("proname"));
				pbean.setCat_id(rs.getInt("cat_id"));
				pbean.setSubcat_id(rs.getInt("subcat_id"));
				pbean.setBrand_id(rs.getInt("brand_id"));
				pbean.setPrice(rs.getInt("price"));
				pbean.setQuntity(rs.getInt("quantity"));
				pbean.setProdinfo(rs.getString("prodinfo"));
				pbean.setOtherinfo(rs.getString("otherinfo"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return pbean;
	}

	public boolean updateProduct(ProductBean pbean) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try
		{
			con=DbConnection.getConnection();
			pstmt=con.prepareStatement("Update product set proname=?,cat_id=?,subcat_id=?,brand_id=?,price=?,quantity=?,prodinfo=?,otherinfo=? where proid=?");
			pstmt.setString(1, pbean.getProname());
			pstmt.setInt(2, pbean.getCat_id());
			pstmt.setInt(3, pbean.getSubcat_id());
			pstmt.setInt(4, pbean.getBrand_id());
			pstmt.setInt(5, pbean.getPrice());
			pstmt.setInt(6, pbean.getQuntity());
			pstmt.setString(7, pbean.getProdinfo());
			pstmt.setString(8,pbean.getOtherinfo());
			pstmt.setInt(9,pbean.getProid());
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteProduct(ProductBean pbean) 
	{
		Connection con;
		PreparedStatement pstmt;
		try {
			con = DbConnection.getConnection();
			pstmt=con.prepareStatement("delete from product where proid = ?");
			pstmt.setInt(1,pbean.getProid());
			pstmt.executeUpdate();
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public ArrayList<ProductBean> getProductByCategory(int catid) {
		// TODO Auto-generated method stub
		System.out.println("getProductByCategorycalled");
		ArrayList<ProductBean> products = new ArrayList<ProductBean>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from product where cat_id = ?");
			pstmt.setInt(1, catid);
			//System.out.println(catid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				ProductBean p = new ProductBean();
				p.setProid(rs.getInt("proid"));
				System.out.println(rs.getInt("proid"));
				p.setProname(rs.getString("proname"));
				System.out.println(rs.getString("proname"));
				p.setPrice(rs.getInt("price"));
				System.out.println(rs.getInt("price"));
				p.setQuntity(rs.getInt("quantity"));
				products.add(p);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	public ArrayList<ProductBean> getProductDetails(int proid) {
		// TODO Auto-generated method stub
		ArrayList<ProductBean> product = new ArrayList<ProductBean>();
		try
		{
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from product where proid = ?");
			pstmt.setInt(1,proid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				ProductBean p = new ProductBean();
				p.setProid(rs.getInt("proid"));
				p.setProname(rs.getString("proname"));
				p.setPrice(rs.getInt("price"));
				p.setProdinfo(rs.getString("prodinfo"));
				p.setOtherinfo(rs.getString("otherinfo"));
				product.add(p);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return product;
	}
	
}