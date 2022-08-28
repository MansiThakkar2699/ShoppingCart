package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.bean.AddressBean;
import com.bean.CartBean;
import com.bean.OrderBean;
import com.util.DbConnection;

public class CartDao {

	public void AddProduct(CartBean cbean) {
		// TODO Auto-generated method stub
		Connection con;
		try {
			con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into public.cart(proid,qty,id)values(?,?,?)");
			pstmt.setInt(1,cbean.getProid());
			pstmt.setInt(2,1);
			pstmt.setInt(3,cbean.getId());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<CartBean> listCart(int id) {
		ArrayList<CartBean> cartList = new ArrayList<CartBean>();
		System.out.println("Cart Dao Called");
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select c.*,p.proname,p.price,u.fname from public.product p ,public.user u , public.cart c where p.proid = c.proid and u.id = c.id and c.id = ?");
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("id from list cart"+id);
			while(rs.next())
			{
				CartBean cbean = new CartBean();
				cbean.setCart_id(rs.getInt("cart_id"));
				cbean.setId(rs.getInt("id"));
				cbean.setFname(rs.getString("fname"));
				cbean.setProid(rs.getInt("proid"));
				cbean.setProname(rs.getString("proname"));
				cbean.setQty(rs.getInt("qty"));
				cbean.setPrice(rs.getInt("price"));
				cartList.add(cbean);
				System.out.println("productid = "+ cbean.getProid());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartList;
		// TODO Auto-generated method stub
		
	}

	public void DeleteProduct(int cartid) {
		// TODO Auto-generated method stub
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from public.cart where cart_id = ?");
			pstmt.setInt(1,cartid);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ClearCart(CartBean cbean, OrderBean obean, AddressBean abean) {
		// TODO Auto-generated method stub
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmtorder = con.prepareStatement("insert into public.order (user_id,totalamount,discount,deliverycharge,payment_type,paymentstatus,orderstatus,date,add_id) values (?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			pstmtorder.setInt(1,cbean.getId());
			pstmtorder.setInt(2,obean.getTotalamount());
			pstmtorder.setInt(3, 0);
			pstmtorder.setInt(4,obean.getDeliverycharge());
			pstmtorder.setString(5, "card");
			pstmtorder.setString(6, "paid");
			pstmtorder.setString(7, "Approved");
			pstmtorder.setString(8, new Date().toString());
			pstmtorder.setInt(9,abean.getAdd_id());
			System.out.println("cart dao"+abean.getAdd_id());
			pstmtorder.executeUpdate();
			ResultSet key = pstmtorder.getGeneratedKeys();
			key.next();
			int orderid = key.getInt(1);
			ArrayList<CartBean> cart = listCart(cbean.getId());
			for (CartBean cb : cart)
			{
				PreparedStatement pstmtorderdetail = con.prepareStatement("insert into public.orderdetail(o_id,proid,amount) values(?,?,?)");
				pstmtorderdetail.setInt(1, orderid);
				System.out.println(orderid);
				pstmtorderdetail.setInt(2,cb.getProid());
				System.out.println(cbean.getProid());
				pstmtorderdetail.setInt(3,cb.getPrice());
				System.out.println(cbean.getPrice());
				pstmtorderdetail.executeUpdate();
			}
			PreparedStatement pstmt = con.prepareStatement("delete from cart where id = ?");
			pstmt.setInt(1,cbean.getId());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	}
