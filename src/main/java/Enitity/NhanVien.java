package Enitity;

public class NhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private String gioiTinh;
	private String sdt;
	private String chucVu;
	private double luong;
	private TaiKhoan tenDangNhap;
	public NhanVien(String maNhanVien, String tenNhanVien, String gioiTinh, String sdt, String chucVu, double luong,
			TaiKhoan tenDangNhap) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.chucVu = chucVu;
		this.luong = luong;
		this.tenDangNhap = tenDangNhap;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	public TaiKhoan getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(TaiKhoan tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", gioiTinh=" + gioiTinh
				+ ", sdt=" + sdt + ", chucVu=" + chucVu + ", luong=" + luong + ", tenDangNhap=" + tenDangNhap + "]";
	}
	
	
	
}
