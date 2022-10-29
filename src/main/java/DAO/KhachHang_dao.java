package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import Connect.Connect;
import Enitity.KhachHang;

public class KhachHang_dao {
	public static ArrayList<KhachHang>getAllKhachHang(){
		ArrayList<KhachHang>dskh = new ArrayList<KhachHang>();
		Connection connection = null;
		Statement sm = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLKaraoke", "sa", "0123");
			String sql = "select * from KhachHang";
			sm = connection.createStatement();
			ResultSet rs = sm.executeQuery(sql);
			while(rs.next()) {
				String maKhachHang = rs.getString(1);
				String tenKhachHang = rs.getString(2);
				String gioiTinh = rs.getString(3);
				String sdt = rs.getString(4);
				String diaChi = rs.getString(5);
				KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, gioiTinh, sdt, diaChi);
				dskh.add(kh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(sm!=null) {
				try {
					sm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return dskh;
	}
	public static void them(KhachHang kh) {
		Connection connection = null;
		PreparedStatement sm = null;
		ArrayList<KhachHang>dsnv = new ArrayList<KhachHang>();
		
		try {
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLKaraoke", "sa", "0123");
			String sql ="insert into KhachHang(maKhachHang,tenKhachHang,gioiTinh,sdt,diaChi) values (?,?,?,?,?)";
			sm = connection.prepareCall(sql);
			sm.setString(1, kh.getMaKhachHang());
			sm.setString(2, kh.getTenKhachHang());
			sm.setString(3, kh.getGioiTinh());
			sm.setString(4, kh.getSdt());
			sm.setString(5, kh.getDiaChi());
			sm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(sm!=null) {
				try {
					sm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	public static void xoa(String maKhachHang) {
		Connection connection = null;
		PreparedStatement sm = null;
		ArrayList<KhachHang>dsnv = new ArrayList<KhachHang>();
		
		try {
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLKaraoke", "sa", "0123");
			String sql ="delete from KhachHang where maKhachHang=?";
			sm = connection.prepareCall(sql);
			sm.setString(1, maKhachHang);
			sm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(sm!=null) {
				try {
					sm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void update(KhachHang kh) {
		Connection connection = null;
		PreparedStatement sm = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLKaraoke","sa","0123");
			String sql ="update KhachHang set tenKhachHang=?, gioiTinh=?,sdt=? ,diaChi=? where maKhachHang=? ";
			sm = connection.prepareStatement(sql);
			
			sm.setString(1, kh.getTenKhachHang());
			sm.setString(2, kh.getGioiTinh());
			sm.setString(3, kh.getSdt());
			sm.setString(4, kh.getDiaChi());
			sm.setString(5, kh.getMaKhachHang());
			sm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sm != null) {
				try {
					sm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	public static ArrayList<KhachHang> findbyName(String tenKhachHang){
		Connection connection = null;
		PreparedStatement sm =null;
		ArrayList<KhachHang> dskh =  new ArrayList<KhachHang>();

		try {
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLKaraoke","sa","0123");
			String sql = "select *from KhachHang where tenKhachHang like ?";
			sm = connection.prepareCall(sql);
			sm.setString(1,"%"+tenKhachHang+"%");
			ResultSet rs = sm.executeQuery();
			while(rs.next()) {
				String maKhachHang = rs.getString(1);
				tenKhachHang = rs.getString(2);
				String sdt = rs.getString(3);
				String gioiTinh = rs.getString(4);
				String diaChi = rs.getString(5);

				KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, gioiTinh, sdt, diaChi);
				dskh.add(kh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sm != null) {
				try {
					sm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return dskh;
		
	}
	public static ArrayList<KhachHang> find(String sdt){
		Connection connection = null;
		PreparedStatement sm =null;
		ArrayList<KhachHang> dskh =  new ArrayList<KhachHang>();

		try {
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLKaraoke","sa","0123");
			String sql = "select *from KhachHang where sdt like ?";
			sm = connection.prepareCall(sql);
			sm.setString(1,"%"+sdt+"%");
			ResultSet rs = sm.executeQuery();
			while(rs.next()) {
				String maKhachHang = rs.getString(1);
				String tenKhachHang = rs.getString(2);
				sdt = rs.getString(3);
				String gioiTinh = rs.getString(4);
				String diaChi = rs.getString(5);

				KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, gioiTinh, sdt, diaChi);
				dskh.add(kh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sm != null) {
				try {
					sm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return dskh;
		
	}

}
