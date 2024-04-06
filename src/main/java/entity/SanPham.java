/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

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
 * @author vuhai
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "SanPham")
@EqualsAndHashCode()
public class SanPham implements java.io.Serializable{
	@Id	
	@Column(name = "maSP", nullable = false, unique = true, columnDefinition = "nvarchar(8)")
    private String maSP;
	@Column(name = "tenSP", columnDefinition = "nvarchar(50)", nullable = false)
    private String tenSP;
	@Column(name = "soLuong", nullable = false, columnDefinition = "int")
    private int soLuong;
	@Column(name = "donGia", nullable = false, columnDefinition = "float")
    private double donGia;
	@Column(name = "thongTin", columnDefinition = "nvarchar(200)")
    private String thongTin;
	@Column(name = "soCongDoan", nullable = false, columnDefinition = "int")
    private int soCongDoan;
	@Column(name = "chatLieu", columnDefinition = "nvarchar(30)")
    private String chatLieu;
	@Column(name = "donViTinh", columnDefinition = "nvarchar(20)")
    private String donViTinh;
	
	@EqualsAndHashCode.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maHD")
    private HopDong hopDong;
	
	@OneToMany(mappedBy = "sanPham")
	private Set<CongDoan> listCD;
    

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP=tenSP;
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

    public String getThongTin() {
        return thongTin;
    }

    public void setThongTin(String thongTin) {
        this.thongTin = thongTin;
    }

    public int getSoCongDoan() {
        return soCongDoan;
    }

    public void setSoCongDoan(int soCongDoan) {
        this.soCongDoan = soCongDoan;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }   

    public HopDong getHopDong() {
        return hopDong;
    }

    public void setHopDong(HopDong hopDong) {
        this.hopDong = hopDong;
    }

    public SanPham(String maSP, String tenSP, int soLuong, double donGia, String thongTin, int soCongDoan, String chatLieu, String donViTinh, HopDong hopDong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thongTin = thongTin;
        this.soCongDoan = soCongDoan;
        this.chatLieu = chatLieu;
        this.donViTinh = donViTinh;
        this.hopDong = hopDong;
    }

    

    public SanPham(String maSP) {
        this.maSP = maSP;
    }

    public SanPham() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.maSP);
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
        final SanPham other = (SanPham) obj;
        return Objects.equals(this.maSP, other.maSP);
    }

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
 
}
