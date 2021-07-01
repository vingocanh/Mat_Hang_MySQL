package models;

import java.sql.Date;

public class MatHang {
	private int id;
	private String tenMH, moTa, chatLieu, noiSX, hangSX;
	private Date ngaySX;
	
	public MatHang() {
		super();
	}
	
	

	public MatHang(int id) {
		super();
		this.id = id;
	}



	public MatHang(int id, String tenMH, String moTa, String chatLieu, String noiSX, String hangSX, Date ngaySX) {
		super();
		this.id = id;
		this.tenMH = tenMH;
		this.moTa = moTa;
		this.chatLieu = chatLieu;
		this.noiSX = noiSX;
		this.hangSX = hangSX;
		this.ngaySX = ngaySX;
	}



	public MatHang(String tenMH, String moTa, String chatLieu, String noiSX, String hangSX, Date ngaySX) {
		super();
		this.tenMH = tenMH;
		this.moTa = moTa;
		this.chatLieu = chatLieu;
		this.noiSX = noiSX;
		this.hangSX = hangSX;
		this.ngaySX = ngaySX;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getChatLieu() {
		return chatLieu;
	}

	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}

	public String getNoiSX() {
		return noiSX;
	}

	public void setNoiSX(String noiSX) {
		this.noiSX = noiSX;
	}

	public String getHangSX() {
		return hangSX;
	}

	public void setHangSX(String hangSX) {
		this.hangSX = hangSX;
	}

	public Date getNgaySX() {
		return ngaySX;
	}

	public void setNgaySX(Date ngaySX) {
		this.ngaySX = ngaySX;
	}
}
