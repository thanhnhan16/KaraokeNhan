package Enitity;

public class DichVu {
	private String maDichVu;
	private String loaiDichVu;
	private String tenDichVu;
	private int soLuong;
	private double gia;
	public DichVu(String maDichVu, String loaiDichVu, String tenDichVu, int soLuong, double gia) {
		super();
		this.maDichVu = maDichVu;
		this.loaiDichVu = loaiDichVu;
		this.tenDichVu = tenDichVu;
		this.soLuong = soLuong;
		this.gia = gia;
	}
	public DichVu() {
		super();
	}

	public DichVu(String maDichVu, String loaiDichVu, double gia) {
		super();
		this.maDichVu = maDichVu;
		this.loaiDichVu = loaiDichVu;
		this.gia = gia;
	}
	public String getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getLoaiDichVu() {
		return loaiDichVu;
	}
	public void setLoaiDichVu(String loaiDichVu) {
		this.loaiDichVu = loaiDichVu;
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	@Override
	public String toString() {
		return "DichVu [maDichVu=" + maDichVu + ", loaiDichVu=" + loaiDichVu + ", tenDichVu=" + tenDichVu + ", soLuong="
				+ soLuong + ", gia=" + gia + "]";
	}
	
	
	
}
