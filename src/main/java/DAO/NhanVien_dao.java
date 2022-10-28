package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connect.Connect;
import Enitity.NhanVien;
import Enitity.TaiKhoan;

public class NhanVien_dao {
	
	public ArrayList<NhanVien> getAll() {
		ArrayList list_nv = new ArrayList<NhanVien>();
		try {
			Connection con = Connect.getInstance().getConnection();
			PreparedStatement preparedStatement = null;
			preparedStatement = con.prepareStatement("select * from NhanVien");
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				TaiKhoan taikhoan = new TaiKhoan(result.getString(7));
				NhanVien nhanvien = new NhanVien(result.getString(1), result.getString(2),result.getString(3) , result.getString(4), result.getString(5), result.getDouble(6), taikhoan);
			
				
				list_nv.add(nhanvien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list_nv;
	}
//	public boolean save(NhanVien nhanvien) {
//		Connection con = Connect.getInstance().getConnection();
//		PreparedStatement preparedStatement = null;
//		try {
//			preparedStatement = con.prepareStatement(
//					"insert orders(code,type,description,productName,provider,price,userId,status,created_at) values(?,?,?,?,?,?,?,?,?)");
//			preparedStatement.setString(1, order.getCode_order());
//			preparedStatement.setString(2, order.getType());
//			preparedStatement.setString(3, order.getDescription());
//			preparedStatement.setString(4, order.getProductName());
//			preparedStatement.setString(5, order.getProvider());
//			preparedStatement.setDouble(6, order.getPrice());
//			preparedStatement.setInt(7, order.getUser().getId());
//			preparedStatement.setString(8, order.getStatus());
//			preparedStatement.setDate(9, order.getCreat_at());
//			if (preparedStatement.executeUpdate() > 0) {
//				return true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
}
