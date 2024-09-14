create database QlSanPham;
use QlSanPham;

create table LoaiSP (
	MaLoai	char(2) primary key,
    TenLoai	nvarchar(20)
);

create table SanPham (
	MaSP	char(4) primary key,
    TenSP	nvarchar(20),
    DonGia	bigint,
    MaLoai	char(2) references LoaiSP(MaLoai)
);

insert into LoaiSP values
	('BK', 'Bánh kẹo'),
    ('GK', 'Giải khát'),
    ('MP', 'Mỹ phẩm');
    
insert into SanPham values
	('SP01', 'Bánh mì', 10000, 'BK'),
    ('SP02', 'Bánh bao', 15000, 'BK'),
    ('SP03', 'Coca cola', 12000, 'GK'),
    ('SP04', 'Pepsi', 11000, 'GK'),
    ('SP05', 'Kem chống nắng', 85000, 'MP');
    