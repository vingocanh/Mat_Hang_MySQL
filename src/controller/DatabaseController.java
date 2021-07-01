package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.MatHang;


public class DatabaseController {
	private String url;
	private String user;
	private String pass;
	Connection con = null;

	public DatabaseController(String _url, String _user, String _pass) {
		url = _url;
		user = _user;
		pass = _pass;
	}

	public void openConnection() throws SQLException {
		if (con == null || con.isClosed()) {
			try {

				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, pass);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	public void closeConnect() throws SQLException {
		if (con != null || !con.isClosed()) {
			con.close();
		}
	}
	public boolean insertMatHang(MatHang mh) throws SQLException {
		openConnection();
		String sql = "INSERT INTO mat_hang(tenMH, moTa, chatLieu, noiSX, hangSX, ngaySX) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement prstatement = con.prepareStatement(sql);
		prstatement.setString(1, mh.getTenMH());
		prstatement.setString(2, mh.getMoTa());
		prstatement.setString(3, mh.getChatLieu());
		prstatement.setString(4, mh.getNoiSX());
		prstatement.setString(5, mh.getHangSX());
		prstatement.setDate(6, mh.getNgaySX());
		boolean insertrow = prstatement.executeUpdate() > 0;
		prstatement.close();
		con.close();
		return insertrow;
	}
	
	public boolean updateMatHang(MatHang mh) throws SQLException {
		String sql = "UPDATE mat_hang SET tenMH = ?, moTa = ? ,chatLieu = ? , noiSX = ?, hangSX = ? , ngaySX = ? WHERE id = ?";
		openConnection();
		PreparedStatement prstatement = con.prepareStatement(sql);
		prstatement.setString(1, mh.getTenMH());
		prstatement.setString(2, mh.getMoTa());
		prstatement.setString(3, mh.getChatLieu());
		prstatement.setString(4, mh.getNoiSX());
		prstatement.setString(5, mh.getHangSX());
		prstatement.setDate(6, mh.getNgaySX());
//		prstatement.setString(6, thuoc.getMota());
		prstatement.setInt(7, mh.getId());
		boolean updateok = prstatement.execute();
		prstatement.close();
		con.close();
		return updateok;
	}
	
	public boolean deleteMH(MatHang mh) throws SQLException {
		String sql = "delete from mat_hang where id = ?";
		openConnection();
		PreparedStatement pr = con.prepareStatement(sql);
		pr.setInt(1, mh.getId());
		boolean deleteok = pr.execute();
		pr.close();
		con.close();
		return deleteok;
	}
	
	public ArrayList<MatHang> getAllMH() throws SQLException {
		String sql = "select * from mat_hang";
		ArrayList<MatHang> list = new ArrayList<>();
		openConnection();
		Statement sta = con.createStatement();
		ResultSet rs = sta.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt(1);
			String ten = rs.getString(2);
			String mota = rs.getString(3);
			String chatLieu = rs.getString(4);
			String noiSX = rs.getString(5);
			String hangSX = rs.getString(6);
			Date ngay = rs.getDate(7);
			
			MatHang mh = new MatHang(id, ten, mota, chatLieu, noiSX, hangSX, ngay);
			list.add(mh);
		}
		rs.close();
		sta.close();
		con.close();
		return list;
	}
	
	public MatHang getAllMHID(int id) throws SQLException {
		openConnection();
		String sql = "select * from mat_hang WHERE id = ?";
		MatHang mh = null;
		
		PreparedStatement pr =(PreparedStatement) con.prepareStatement(sql);
		pr.setInt(1, id);
		ResultSet rs = pr.executeQuery();
		while (rs.next()) {
			String ten = rs.getString(2);
			String mota = rs.getString(3);
			String chatLieu = rs.getString(4);
			String noiSX = rs.getString(5);
			String hangSX = rs.getString(6);
			Date ngay = rs.getDate(7);
			
			mh = new MatHang(id, ten, mota, chatLieu, noiSX, hangSX, ngay);
		}
		rs.close();
		pr.close();
		con.close();
		return mh;
	}
}
