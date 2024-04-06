/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "NhanVienHanhChinh")
@EqualsAndHashCode()
public class NhanVienHanhChinh implements java.io.Serializable
{
	@Id
	@Column(name = "maNV", nullable = false, unique = true, columnDefinition = "nvarchar(6)")
    private String maNV;
	@Column(name = "hoTen", columnDefinition = "nvarchar(50)", nullable = false)
    private String hoTen;
	@Column(name = "phai", nullable = false, columnDefinition = "bit")
    private boolean phai;
	@Column(name = "ngaySinh", nullable = false, columnDefinition = "date")
    private Date ngaySinh;
	@Column(name = "soDT", columnDefinition = "nvarchar(10)", nullable = false)
    private String soDT;
	@Column(name = "diaChi", columnDefinition = "nvarchar(50)", nullable = false)
    private String diaChi;
	@Column(name = "tinhTrang", nullable = false, columnDefinition = "bit")
    private boolean tinhTrang;
	@Column(name = "ngayVaoLam", nullable = false, columnDefinition = "date")
    private Date ngayVaoLam;
	@Column(name = "hinhAnh", columnDefinition = "nvarchar(100)")
    private String hinhAnh;
	@Column(name = "heSoLuong", nullable = false, columnDefinition = "float")
    private double heSoLuong;
	@Column(name = "luongCoBan", nullable = false, columnDefinition = "float")
    private double luongCoBan;
	@Column(name = "chucVu", columnDefinition = "nvarchar(30)")
    private String chucVu;
	@Column(name = "email", columnDefinition = "nvarchar(50)")
    private String email;
	@Column(name = "tienPhuCapTheoNgay", nullable = false, columnDefinition = "float")
    private double tienPhuCapTheoNgay;
	@Column(name = "tienChuyenCan", nullable = false, columnDefinition = "float")
    private double tienChuyenCan;
	@Column(name = "ghiChu", columnDefinition = "nvarchar(200)")
    private String ghiChu;
	@EqualsAndHashCode.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maPB")
    private PhongBan phongBan;
	
	@OneToMany(mappedBy = "nv")
	private Set<BangLuongNhanVien> bangLuongNhanViens;
	
	@OneToMany(mappedBy = "nv")
	private Set<BangChamCongNhanVien> bangChamCongNhanViens;
	
	@OneToMany(mappedBy = "nv")
    private Set<HopDong> hopDongs;
	
    public String getMaNV() {
        return this.maNV;
    }
    
    public void setMaNV(final String maNV) {
        this.maNV = maNV;
    }
    
    public String getHoTen() {
        return this.hoTen;
    }
    
    public void setHoTen(final String hoTen) {
        this.hoTen = hoTen;
    }
    
    public boolean isPhai() {
        return this.phai;
    }
    
    public void setPhai(final boolean phai) {
        this.phai = phai;
    }
    
    public Date getNgaySinh() {
        return this.ngaySinh;
    }
    
    public void setNgaySinh(final Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    public String getSoDT() {
        return this.soDT;
    }
    
    public void setSoDT(final String soDT) {
        this.soDT = soDT;
    }
    
    public String getDiaChi() {
        return this.diaChi;
    }
    
    public void setDiaChi(final String diaChi) {
        this.diaChi = diaChi;
    }
    
    public boolean isTinhTrang() {
        return this.tinhTrang;
    }
    
    public void setTinhTrang(final boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    public Date getNgayVaoLam() {
        return this.ngayVaoLam;
    }
    
    public void setNgayVaoLam(final Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }
    
    public String getHinhAnh() {
        return this.hinhAnh;
    }
    
    public void setHinhAnh(final String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    
    public double getHeSoLuong() {
        return this.heSoLuong;
    }
    
    public void setHeSoLuong(final double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }
    
    public double getLuongCoBan() {
        return this.luongCoBan;
    }
    
    public void setLuongCoBan(final double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }
    
    public String getChucVu() {
        return this.chucVu;
    }
    
    public void setChucVu(final String chucVu) {
        this.chucVu = chucVu;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
    
    public double getTienPhuCapTheoNgay() {
        return this.tienPhuCapTheoNgay;
    }
    
    public void setTienPhuCapTheoNgay(final double tienPhuCapTheoNgay) {
        this.tienPhuCapTheoNgay = tienPhuCapTheoNgay;
    }
    
    public double getTienChuyenCan() {
        return this.tienChuyenCan;
    }
    
    public void setTienChuyenCan(final double tienChuyenCan) {
        this.tienChuyenCan = tienChuyenCan;
    }
    
    public String getGhiChu() {
        return this.ghiChu;
    }
    
    public void setGhiChu(final String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    public PhongBan getPhongBan() {
        return this.phongBan;
    }
    
    public void setPhongBan(final PhongBan phongBan) {
        this.phongBan = phongBan;
    }
    
    public NhanVienHanhChinh(final String maNV, final String hoTen, final boolean phai, final Date ngaySinh, final String soDT, final String diaChi, final boolean tinhTrang, final Date ngayVaoLam, final String hinhAnh, final double heSoLuong, final double luongCoBan, final String chucVu, final String email, final double tienPhuCapTheoNgay, final double tienChuyenCan, final String ghiChu, final PhongBan phongBan) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.phai = phai;
        this.ngaySinh = ngaySinh;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.tinhTrang = tinhTrang;
        this.ngayVaoLam = ngayVaoLam;
        this.hinhAnh = hinhAnh;
        this.heSoLuong = heSoLuong;
        this.luongCoBan = luongCoBan;
        this.chucVu = chucVu;
        this.email = email;
        this.tienPhuCapTheoNgay = tienPhuCapTheoNgay;
        this.tienChuyenCan = tienChuyenCan;
        this.ghiChu = ghiChu;
        this.phongBan = phongBan;
    }
    
    public NhanVienHanhChinh(final String maNV) {
        this.maNV = maNV;
    }
    
    public NhanVienHanhChinh() {
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.maNV);
        return hash;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final NhanVienHanhChinh other = (NhanVienHanhChinh)obj;
        return Objects.equals(this.maNV, other.maNV);
    }

    @Override
    public String toString() {
        return "NhanVienHanhChinh{" + "maNV=" + maNV + ", hoTen=" + hoTen + ", phai=" + phai + ", ngaySinh=" + ngaySinh + ", soDT=" + soDT + ", diaChi=" + diaChi + ", tinhTrang=" + tinhTrang + ", ngayVaoLam=" + ngayVaoLam + ", hinhAnh=" + hinhAnh + ", heSoLuong=" + heSoLuong + ", luongCoBan=" + luongCoBan + ", chucVu=" + chucVu + ", email=" + email + ", tienPhuCapTheoNgay=" + tienPhuCapTheoNgay + ", tienChuyenCan=" + tienChuyenCan + ", ghiChu=" + ghiChu + ", phongBan=" + phongBan + '}';
    }
    
    
    
    public String get10char(final String s) {
        return s.substring(0, 10);
    }
    
    public String getNgaySinhString() {
        return this.get10char(this.ngaySinh.toString());
    }
    
    public String getNgayVaoLamString() {
        return this.get10char(this.ngayVaoLam.toString());
    }
}