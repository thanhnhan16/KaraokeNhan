package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connect.Connect;
import Enitity.DichVu;

public class DichVu_dao {
	
	public ArrayList<DichVu> getAll(){
		ArrayList dsDichVu = new ArrayList<DichVu>();
           try {
       		Connection con = Connect.getInstance().getConnection();
    		PreparedStatement preparedStatement = null;
    		preparedStatement = con.prepareStatement("select * from DichVu");
    		ResultSet result = preparedStatement.executeQuery();
    		
    		while (result.next()) {
    		DichVu dichvu = new DichVu(result.getString(2),result.getString(1),result.getString(3),
    				result.getInt(4),Double.parseDouble(result.getString(5)));
    		dsDichVu.add(dichvu);
    		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
           return dsDichVu;
	}

	public ArrayList<DichVu> search(String maDichVu,String tenDichVu,String loaiDichVu){
		ArrayList dsDichVu = new ArrayList<DichVu>();
		try {
       		Connection con = Connect.getInstance().getConnection();
    		PreparedStatement preparedStatement = null;
    		preparedStatement = con.prepareStatement("select * from DichVu where maDichVu like '%"
    		+maDichVu+"%' and tenDichVu like N'%"+tenDichVu+"%' and loaiDichVu like N'%"+loaiDichVu+"%'");
    		ResultSet result = preparedStatement.executeQuery();
    		
    		while (result.next()) {
    		DichVu dichvu = new DichVu(result.getString(2),result.getString(1),result.getString(3),
    				result.getInt(4),Double.parseDouble(result.getString(5)));
    		dsDichVu.add(dichvu);
    		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
           return dsDichVu;
	}
	
	public ArrayList<DichVu> getAllCapNhatDichVu(){
		ArrayList dsDichVu = new ArrayList<DichVu>();
        try {
    		Connection con = Connect.getInstance().getConnection();
 		PreparedStatement preparedStatement = null;
 		preparedStatement = con.prepareStatement("select * from DichVu");
 		ResultSet result = preparedStatement.executeQuery();
 		
 		while (result.next()) {
 		DichVu dichvu = new DichVu(result.getString(2),result.getString(1),
 				Double.parseDouble(result.getString(5)));
 		dsDichVu.add(dichvu);
 		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return dsDichVu;

		
	}

}
