package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.bean.RoleBean;
import com.util.DbConnection;
public class RoleDao 
{
	public void insertRole(RoleBean b) throws ClassNotFoundException, SQLException
	{
		Connection con=DbConnection.getConnection();
		PreparedStatement pstmt=con.prepareStatement("insert into public.role(role_name)values(?)");
		pstmt.setString(1,b.getName());
		pstmt.executeUpdate();
		
	}
	public ArrayList<RoleBean>listRole()
	{
		ArrayList<RoleBean> roleList=new ArrayList<RoleBean>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select * from role");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				RoleBean roleBean=new RoleBean();
				roleBean.setId(rs.getInt("role_id"));
				roleBean.setName(rs.getString("role_name"));
				roleList.add(roleBean);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return roleList;
	}
	public Boolean DeleteRole(RoleBean b)
	{
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("delete from role where role_id=?");
			pstmt.setInt(1,b.getId());
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
	public RoleBean getDataByPk(int roleId)
	{
		Connection con=null;
		RoleBean roleBean=new RoleBean();
		PreparedStatement pstmt=null;
		try
		{
			con=DbConnection.getConnection();
			pstmt=con.prepareStatement("select * from role where role_id=?");
			pstmt.setInt(1,roleId);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				roleBean.setId(rs.getInt("role_id"));
				roleBean.setName(rs.getString("role_name"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		return roleBean;
	}
	public boolean UpdateBook(RoleBean roleBean) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		try
		{
			con=DbConnection.getConnection();
			pstmt=con.prepareStatement("update role set role_name = ? where role_id= ?");
			pstmt.setString(1,roleBean.getName());
			pstmt.setInt(2,roleBean.getId());
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