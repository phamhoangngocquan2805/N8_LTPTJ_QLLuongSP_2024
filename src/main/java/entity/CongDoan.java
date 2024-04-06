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

/**
 *
 * @author tho
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "CongDoan")
@EqualsAndHashCode()
public class CongDoan implements java.io.Serializable{

    public static int indexOf(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Id
    @Column(name = "maCD", nullable = false, unique = true, columnDefinition = "nvarchar(10)")
    private String maCD;
    @Column(name = "tenCD", columnDefinition = "nvarchar(50)", nullable = false)
    private String tenCD;
    @Column(name = "soLuong", nullable = false, columnDefinition = "int")
    private int soLuong;
    @Column(name = "donGia", nullable = false, columnDefinition = "float")
    private double donGia;
    @Column(name = "ngayBatDau", nullable = false, columnDefinition = "date")
    private Date ngayBatDau;
    @Column(name = "ngayKetThuc", nullable = false, columnDefinition = "date")
    private  Date ngayKetThuc;
    @Column(name = "tenCDTruoc", columnDefinition = "nvarchar(50)", nullable = false)
    private String tenCDTruoc;
    @Column(name = "trangThai", nullable = false, columnDefinition = "int")
    private int trangThai;
    @EqualsAndHashCode.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maSP", nullable = false)
    private SanPham sanPham;
    
    @OneToMany(mappedBy = "congDoan")
    private Set<BangPhanCong> listPC;

    public String getMaCD() {
        return maCD;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    public String getTenCD() {
        return tenCD;
    }

    public void setTenCD(String tenCD) {
        this.tenCD = tenCD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getTenCDTruoc() {
        return tenCDTruoc;
    }

    public void setTenCDTruoc(String tenCDTruoc) {
        this.tenCDTruoc = tenCDTruoc;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
    

    public CongDoan(String maCD, String tenCD, int soLuong, double donGia, Date ngayBatDau, Date ngayKetThuc, String tenCDTruoc, int trangThai, SanPham sanPham) {
        this.maCD = maCD;
        this.tenCD = tenCD;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.tenCDTruoc = tenCDTruoc;
        this.trangThai = trangThai;
        this.sanPham = sanPham;
    }

    public CongDoan(String maCD) {
        this.maCD = maCD;
    }

    public CongDoan() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.maCD);
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
        final CongDoan other = (CongDoan) obj;
        return Objects.equals(this.maCD, other.maCD);
    }

    @Override
    public String toString() {
        return "CongDoan{" + "maCD=" + maCD + ", tenCD=" + tenCD + ", soLuong=" + soLuong + ", donGia=" + donGia + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", tenCDTruoc=" + tenCDTruoc + ", trangThai=" + trangThai + ", sanPham=" + sanPham + '}';
    }
    
     
     public String get10char(String s) {
        return s.substring(0, 10);
    }
    public String getNgayBatDauString() {
        return get10char(this.ngayBatDau.toString());
    }
    public String getNgayKetThucString() {
        return get10char(this.ngayKetThuc.toString());
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
