/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author vuhai
 */
@Entity
@Table(name = "BangLuongNhanVien")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
public class BangLuongNhanVien implements java.io.Serializable{
	@Id
	@Column(name = "maBangLuong", nullable = false, unique = true, columnDefinition = "nvarchar(10)")
    private String maBangLuong;
	@Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime ngayTinhLuong;
	@Column(nullable = false, columnDefinition = "int")
    private int soNgayLam;
	@Column(nullable = false, columnDefinition = "int")
    private int soNgayNghi;
	@Column(nullable = false, columnDefinition = "float")
    private double luongChinh; //Lấy lương cơ bản chia cho 26, nhân với số ngày đi làm
    @Column(nullable = false, columnDefinition = "float")
	private double luongTangCa;
    @Column(nullable = false, columnDefinition = "float")
    private double tienUng;
    @Column(nullable = false, columnDefinition = "float", name = "tienPhuCapTheoThang")
    private double tienPhuCap;
    @Column(nullable = false, columnDefinition = "float", name = "tienChuyenCanTheoThang")
    private double tienChuyenCan;
    @Column(nullable = false, columnDefinition = "float")
    private double baoHiemXaHoi;
    @Column(nullable = false, columnDefinition = "float")
    private double thucLanh;
    @EqualsAndHashCode.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNV")
    private NhanVienHanhChinh nv;
    
    public String getMaBangLuong() {
        return maBangLuong;
    }

    public void setMaBangLuong(String maBangLuong) {
        this.maBangLuong = maBangLuong;
    }

    public LocalDateTime getNgayTinhLuong() {
        return ngayTinhLuong;
    }

    public void setNgayTinhLuong(LocalDateTime ngayTinhLuong) {
        this.ngayTinhLuong = ngayTinhLuong;
    }

    public int getSoNgayLam() {
        return soNgayLam;
    }

    public void setSoNgayLam(int soNgayLam) {
        this.soNgayLam = soNgayLam;
        setTienPhuCap();
        setTienChuyenCan();
    }

    public int getSoNgayNghi() {
        return soNgayNghi;
    }

    public void setSoNgayNghi(int soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }

    public double getLuongChinh() {
        return luongChinh;
    }

    public void setLuongChinh() {
        this.luongChinh = getNv().getLuongCoBan()/26*soNgayLam;
    }

    public double getLuongTangCa() {
        return luongTangCa;
    }

    public void setLuongTangCa(double soGioTangCa, double heSo) {
        this.luongTangCa+= soGioTangCa * (getNv().getLuongCoBan()/26/8 * heSo);
        setThucLanh();
    }

    public double getTienUng() {
        return tienUng;
    }

    public void setTienUng(double tienUng) {
        this.tienUng = tienUng;
    }

    public double getTienPhuCap() {
        return tienPhuCap;
    }

    public void setTienPhuCap() {
        this.tienPhuCap = getNv().getTienPhuCapTheoNgay() * soNgayLam;
    }

    public double getTienChuyenCan() {
        return tienChuyenCan;
    }

    public void setTienChuyenCan() {
        if(soNgayLam >= 26)
            this.tienChuyenCan = getNv().getTienChuyenCan();
        else
            this.tienChuyenCan = 0;
    }

    public double getBaoHiemXaHoi() {
        return baoHiemXaHoi;
    }

    public double getThucLanh() {
        return thucLanh;
    }

    public void setThucLanh() {
        this.thucLanh = getLuongChinh() + getLuongTangCa() + getTienPhuCap() + getTienChuyenCan() - getTienUng() -getBaoHiemXaHoi();
    }

    public void setBaoHiemXaHoi() {
        this.baoHiemXaHoi = getLuongChinh() * 0.105;
    }

    public NhanVienHanhChinh getNv() {
        return nv;
    }

    public void setNv(NhanVienHanhChinh nv) {
        this.nv = nv;
    }

    public BangLuongNhanVien(String maBangLuong, LocalDateTime ngayTinhLuong, int soNgayLam, int soNgayNghi, double tienUng, NhanVienHanhChinh nv) {
        this.maBangLuong = maBangLuong;
        this.ngayTinhLuong = ngayTinhLuong;
        this.soNgayLam = soNgayLam;
        this.soNgayNghi = soNgayNghi;
        this.tienUng = tienUng;
        this.nv = nv;
        this.luongTangCa = 0;
        setLuongChinh();
        setBaoHiemXaHoi();
        setTienPhuCap();
        setTienChuyenCan();
        setThucLanh();
    }

    public BangLuongNhanVien() {
    
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.maBangLuong);
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
        final BangLuongNhanVien other = (BangLuongNhanVien) obj;
        return Objects.equals(this.maBangLuong, other.maBangLuong);
    }

    @Override
    public String toString() {
        return "BangLuongNhanVien{" + "maBangLuong=" + maBangLuong + ", ngayTinhLuong=" + ngayTinhLuong + ", soNgayLam=" + soNgayLam + ", soNgayNghi=" + soNgayNghi + ", luongChinh=" + luongChinh + ", luongTangCa=" + luongTangCa + ", tienUng=" + tienUng + ", tienPhuCap=" + tienPhuCap + ", tienChuyenCan=" + tienChuyenCan + ", baoHiemXaHoi=" + baoHiemXaHoi + ", thucLanh=" + thucLanh + ", nv=" + nv + '}';
    }
    
    public String get10char(final String s) {
        return s.substring(0, 10);
    }
    
    public String getNgayTinhLuongString() {
        return this.get10char(this.ngayTinhLuong.toString());
    }
    
    public void setLuongFromDB(double luongChinh, double luongTangCa, double tienChuyenCan, double tienPhuCap)
    {
        this.luongChinh = luongChinh;
        this.luongTangCa = luongTangCa;
        setBaoHiemXaHoi();
        this.tienChuyenCan = tienChuyenCan;
        this.tienPhuCap = tienPhuCap;
        setThucLanh();
    }
}
