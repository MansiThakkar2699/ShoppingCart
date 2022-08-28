package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.CategoryBean;
import com.bean.SubCategoryBean;
import com.util.DbConnection;

public class SubCategoryDao {

	public void insertSubCategory(SubCategoryBean sbean) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into public.subcategory(subcat_name,cat_id)values(?,?)");
		pstmt.setString(1, sbean.getSubcat_name());
		pstmt.setInt(2, sbean.getCat_id());
		pstmt.executeUpdate();
	}

	public ArrayList<SubCategoryBean> listSubCategory() throws ClassNotFoundException, SQLException {
		ArrayList<SubCategoryBean> subcategoryList = new ArrayList<SubCategoryBean>();
		Connection con = DbConnection.getConnection();
		PreparedStatement pstmt = con
				.prepareStatement("select *,s.cat_name from subcategory,category s where s.cat_id=subcategory.cat_id");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			SubCategoryBean sbean = new SubCategoryBean();
			sbean.setSubcat_id(rs.getInt("subcat_id"));
			sbean.setSubcat_name(rs.getString("subcat_name"));
			sbean.setCat_id(rs.getInt("cat_id"));
			sbean.setCat_name(rs.getString("cat_name"));
			subcategoryList.add(sbean);
		}
		return subcategoryList;
	}

	public boolean deleteSubCategory(SubCategoryBean sbean) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getConnection();
		PreparedStatement pstmt = con.prepareStatement("delete from subcategory where subcat_id = ?");
		pstmt.setInt(1, sbean.getSubcat_id());
		pstmt.executeUpdate();
		return true;
	}

	public SubCategoryBean getDataByPk(int subcat_id) {
		Connection con = null;
		SubCategoryBean sbean = new SubCategoryBean();
		PreparedStatement pstmt = null;
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(
					"select sb.*,c.cat_name from subcategory sb,category c where sb.cat_id = c.cat_id and subcat_id = ?");
			pstmt.setInt(1, subcat_id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				sbean.setSubcat_id(rs.getInt("subcat_id"));
				sbean.setSubcat_name(rs.getString("subcat_name"));
				sbean.setCat_id(rs.getInt("cat_id"));
				sbean.setCat_name(rs.getString("cat_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return sbean;
	}

	public boolean UpadateSubCategory(SubCategoryBean sbean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement("Update subcategory set subcat_name=?,cat_id=? where subcat_id=?");
			pstmt.setString(1, sbean.getSubcat_name());
			pstmt.setInt(2, sbean.getCat_id());
			pstmt.setInt(3, sbean.getSubcat_id());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ArrayList<SubCategoryBean> getSubCategory(int cat_id) {
		ArrayList<SubCategoryBean> subcategoryList = new ArrayList<SubCategoryBean>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"select *,s.cat_name from subcategory,category s where s.cat_id=subcategory.cat_id and subcategory.cat_id = ?");
			pstmt.setInt(1,cat_id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				SubCategoryBean sbean = new SubCategoryBean();
				sbean.setSubcat_id(rs.getInt("subcat_id"));
				sbean.setSubcat_name(rs.getString("subcat_name"));
				sbean.setCat_id(rs.getInt("cat_id"));
				sbean.setCat_name(rs.getString("cat_name"));
				subcategoryList.add(sbean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subcategoryList;
	}
}
