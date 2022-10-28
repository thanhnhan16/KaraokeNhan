create DATABASE QLKaraoke
use QLKaraoke


 create table Phong(
	maPhong nvarchar(6) primary key not null,
	tenPhong nvarchar(20) not null,
	loaiPhong nvarchar(20) not null,
	trangThai nvarchar(20),
	sucChua int check(sucChua >0),
	dienTich int check(dienTich>0),
	giaPhong money check(giaPhong>0))
	insert into Phong(maPhong,tenPhong,loaiPhong,trangThai,sucChua,dienTich,giaPhong)
	values('PH0001',N'Phòng 1',N'Phòng thường',N'Phòng trống',10, 25,150000)
	insert into Phong(maPhong,tenPhong,loaiPhong,trangThai,sucChua,dienTich,giaPhong)
	values('PH0002',N'Phòng 2',N'Phòng thường',N'Phòng trống',10, 25,150000)
	insert into Phong(maPhong,tenPhong,loaiPhong,trangThai,sucChua,dienTich,giaPhong)
	values('PH0003',N'Phòng 3',N'Phòng thường',N'Phòng đang sử dụng',10, 25,150000)
	insert into Phong(maPhong,tenPhong,loaiPhong,trangThai,sucChua,dienTich,giaPhong)
	values('PH0004',N'Phòng 4',N'Phòng thường',N'Phòng trống',10, 25,150000)
	insert into Phong(maPhong,tenPhong,loaiPhong,trangThai,sucChua,dienTich,giaPhong)
	values('PH0005',N'Phòng 5',N'Phòng thường',N'Phòng trống',10, 25,150000)
	insert into Phong(maPhong,tenPhong,loaiPhong,trangThai,sucChua,dienTich,giaPhong)
	values('PH0006',N'Phòng 6',N'Phòng VIP',N'Phòng trống',15, 30,180000)

create table TaiKhoan(
	tenDangNhap nvarchar(30) not null primary key,
	matKhau nvarchar(30) not null,
	quyen nvarchar(20)
)

insert into TaiKhoan(tenDangNhap,matKhau,quyen)
values('nv1','nv1',N'Nhân viên tiếp tân')
insert into TaiKhoan(tenDangNhap,matKhau,quyen)
values('nv2','nv2',N'Quản lý thống kê')
insert into TaiKhoan(tenDangNhap,matKhau,quyen)
values('nv3','nv3',N'Quản trị hệ thống')
create table NhanVien(	
	maNhanVien nvarchar(6) not null primary key,
	tenNhanVien nvarchar(30) not null,
	gioiTinh nvarchar(4),
	sdt nvarchar(10) unique,
	chucVu nvarchar(30),
	luong money check (luong>0),
	tenDangNhap nvarchar(30) foreign key references TaiKhoan(tenDangNhap)
	)
	
	insert into NhanVien
	values('NV0001',N'Đổ Thùy Trang',N'Nữ','0123456788',N'Nhân viên tiếp tân',7000000,'nv1')
	insert into NhanVien
	values('NV0002',N'Nguyển Thành Nhân',N'Nam','0123456789',N'Quản lý thống kê',15000000,'nv2')
	insert into NhanVien
	values('NV0003',N'Lê Vân Ngọc',N'Nam','0123456779',N'Quản trị hệ thống',15000000,'nv3')
	
create table KhachHang(
	maKhachHang nvarchar(6) not null primary key,
	tenKhachHang nvarchar(50) not null,
	gioiTinh nvarchar(4),--0 là nam, 1 là nữ
	sdt nvarchar(10) unique,
	diaChi nvarchar(150))
	insert into KhachHang(maKhachHang,tenKhachHang,gioiTinh,sdt,diaChi)
	values('KH0001',N'Lê Văn Ngọc',N'Nam','0326392434',N'An Định, Mỏ Cày Nam, Bến Tre')

create table DichVu(
	loaiDichVu nvarchar(50) not null,
	maDichVu nvarchar(6) not null primary key,
	tenDichVu nvarchar(50) not null,
	soLuong int check(soLuong>0),
	gia money check(gia>0))
	--
insert into DichVu 
values(N'Đồ ăn','DV0001',N'Mỳ cay',20,30000)
insert into DichVu 
values(N'Đồ uống','DV0002',N'Bia 333',20,200000)
insert into DichVu 
values(N'Đồ uống','DV0003',N'Pessi',20,20000)
insert into DichVu 
values(N'Tiệc sinh nhật','DV0004',N'Bánh kem',5,250000)

create table ChiTietDichVu(
	maChiTietDichVu nvarchar(8) not null primary key,
	soLuongSanPham int check(soLuongSanPham>0),
	maDichVu nvarchar(6) foreign key references DichVu(maDichVu)
	)
	
	insert into ChiTietDichVu
	values('CTDV0001',10,'DV0003')
	insert into ChiTietDichVu
	values('CTDV0002',1,'DV0002')
	insert into ChiTietDichVu
	values('CTDV0003',1,'DV0004')
create table ChiTietDatPhong(
	maChiTietDatPhong nvarchar(6) not null primary key,
	soLuongPhongDat int check(soLuongPhongDat >0),
	thoiGianVao time,
	maPhong nvarchar(6) foreign key references Phong(maPhong),
	maChiTietDichVu nvarchar(8) foreign key references ChiTietDichVu(maChiTietDichVu))
	insert into ChiTietDatPhong
	values('DP0001',2,'10:30','PH0001','CTDV0002')
	insert into ChiTietDatPhong
	values('DP0002',2,'10:31','PH0001','CTDV0003')

create table DatTruocPhong(
	maDatTruocPhong nvarchar(7) not null primary key,
	ngayDatPhong date,
	gioDatPhong time,
	gioNhanPhong time,
	maPhong nvarchar(6) foreign key references Phong(maPhong),
	maChiTietDichVu nvarchar(8) foreign key references ChiTietDichVu(maChiTietDichVu))
	

create table ChiTietDatTruocPhong(
	maChiTietDatTruocPhong nvarchar(8) not null primary key,
	soLuongPhongDatTruoc int check(soLuongPhongDatTruoc>0),
	thoiGianVao time,
	thoiGianRa time,
	maDatTruocPhong nvarchar(7) foreign key references DatTruocPhong(maDatTruocPhong))

create table HoaDon(
	maHoaDon nvarchar(6) not null primary key,
	ngayLapHoaDon date,
	maNhanVien nvarchar(6) foreign key references NhanVien(maNhanVien),
	maKhachHang nvarchar(6) foreign key references KhachHang(maKhachHang),
	maChiTietDatPhong nvarchar(6) foreign key references ChiTietDatPhong(maChiTietDatPhong),
	maChiTietDatTruocPhong nvarchar(8) foreign key references ChiTietDatTruocPhong(maChiTietDatTruocPhong))





	