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
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author vuhai
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "CongNhan")
@EqualsAndHashCode()
public class CongNhan implements java.io.Serializable{
	@Id
	@Column(name = "maCN", nullable = false, unique = true, columnDefinition = "nvarchar(6)")
    private String maCN;
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
	@Column(name = "tayNghe", columnDefinition = "nvarchar(30)")
    private String tayNghe;
	@Column(name = "kinhNghiem", columnDefinition = "nvarchar(30)")
    private String kinhNghiem;
	@Column(name = "tienPhuCapTheoNgay", nullable = false, columnDefinition = "float")
    private double tienPhuCapTheoNgay;
	@Column(name = "tienChuyenCan", nullable = false, columnDefinition = "float")
    private double tienChuyenCan;
	@Column(name = "ghiChu", columnDefinition = "nvarchar(200)")
    private String ghiChu;
	
	@OneToMany(mappedBy = "cn")
	private Set<BangChamCongCongNhan> bangChamCongNhanvien;
	
	@OneToMany(mappedBy = "cn")
	private Set<BangChamCongCongNhan> bangChamCongCongNhans;
	
	@OneToMany(mappedBy = "congNhan")
	private Set<BangPhanCong> bangPhanCongs;
    public String getGhiChu(){
        return ghiChu;
    }
    public void setGhiChu(String ghiChu){
        this.ghiChu = ghiChu;
    }
    public String getMaCN() {
        return maCN;
    }

    public void setMaCN(String maCN) {
        this.maCN = maCN;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isPhai() {
        return phai;
    }

    public void setPhai(boolean phai) {
        this.phai = phai;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTayNghe() {
        return tayNghe;
    }

    public void setTayNghe(String tayNghe) {
        this.tayNghe = tayNghe;
    }

    public String getKinhNghiem() {
        return kinhNghiem;
    }

    public void setKinhNghiem(String kinhNghiem) {
        this.kinhNghiem = kinhNghiem;
    }

    public double getTienPhuCapTheoNgay() {
        return tienPhuCapTheoNgay;
    }

    public void setTienPhuCapTheoNgay(double tienPhuCapTheoNgay) {
        this.tienPhuCapTheoNgay = tienPhuCapTheoNgay;
    }

    public double getTienChuyenCan() {
        return tienChuyenCan;
    }

    public void setTienChuyenCan(double tienChuyenCan) {
        this.tienChuyenCan = tienChuyenCan;
    }
    public boolean getPhai(){
        return phai;
    }
    public boolean getTinhTrang(){
        return tinhTrang;
    }
    public CongNhan(String maCN, String hoTen, boolean phai, Date ngaySinh, String soDT, String diaChi, boolean tinhTrang, Date ngayVaoLam, String hinhAnh, String tayNghe, String kinhNghiem, double tienPhuCapTheoNgay, double tienChuyenCan,String ghiChu) {
        this.maCN = maCN;
        this.hoTen = hoTen;
        this.phai = phai;
        this.ngaySinh = ngaySinh;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.tinhTrang = tinhTrang;
        this.ngayVaoLam = ngayVaoLam;
        this.hinhAnh = hinhAnh;
        this.tayNghe = tayNghe;
        this.kinhNghiem = kinhNghiem;
        this.tienPhuCapTheoNgay = tienPhuCapTheoNgay;
        this.tienChuyenCan = tienChuyenCan;
        this.ghiChu = ghiChu;
    }

    public CongNhan(String maCN) {
        this.maCN = maCN;
    }

    public CongNhan() {
    }

    public CongNhan(String maCN, String hoTen, boolean phai, Date ngaySinh, String soDT, String diaChi, boolean tinhTrang, Date ngayVaoLam, double tienPhuCapTheoNgay, double tienChuyenCan, String ghiChu) {
        this.maCN = maCN;
        this.hoTen = hoTen;
        this.phai = phai;
        this.ngaySinh = ngaySinh;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.tinhTrang = tinhTrang;
        this.ngayVaoLam = ngayVaoLam;
        this.tienPhuCapTheoNgay = tienPhuCapTheoNgay;
        this.tienChuyenCan = tienChuyenCan;
        this.ghiChu = ghiChu;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.maCN);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CongNhan other = (CongNhan) obj;
        return Objects.equals(this.maCN, other.maCN);
    }

    @Override
    public String toString() {
        return "CongNhan{" + "maCN=" + maCN + ", hoTen=" + hoTen + ", phai=" + phai + ", ngaySinh=" + ngaySinh + ", soDT=" + soDT + ", diaChi=" + diaChi + ", tinhTrang=" + tinhTrang + ", ngayVaoLam=" + ngayVaoLam + ", hinhAnh=" + hinhAnh + ", tayNghe=" + tayNghe + ", kinhNghiem=" + kinhNghiem + ", tienPhuCapTheoNgay=" + tienPhuCapTheoNgay + ", tienChuyenCan=" + tienChuyenCan + '}';
    }
    
    public String get10char(String s) {
        return s.substring(0, 10);
    }

    public String getNgaySinhString() {
        return get10char(this.ngaySinh.toString());
    }
    public String getNgayVaoLamString() {
        return get10char(this.ngayVaoLam.toString());
    }

}
