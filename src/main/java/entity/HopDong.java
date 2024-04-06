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
 * @author vuhai
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "HopDong")
@EqualsAndHashCode()
public class HopDong implements java.io.Serializable{
	@Id
	@Column(name="maHD", nullable = false, unique = true, columnDefinition = "nvarchar(6)")
    private String maHD;
	@Column(name="tenHD", columnDefinition = "nvarchar(50)", nullable = false)
    private String tenHD;
	@Column(name="ngayKiHD", nullable = false, columnDefinition = "date")
    private Date ngayKiHD;
	@Column(name="ngayBanGiao", nullable = false, columnDefinition = "date")
    private Date ngayBanGiao;
	@Column(name="ghiChu", columnDefinition = "nvarchar(100)")
    private String ghiChu;
	@Column(name="trangThai", nullable = false, columnDefinition = "int")
    private int trangThai;
	@EqualsAndHashCode.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNV")
    private NhanVienHanhChinh nv;
	
	@OneToMany(mappedBy = "hopDong")
	private Set<SanPham> listSP;

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenHD() {
        return tenHD;
    }

    public void setTenHD(String tenHD) {
        this.tenHD = tenHD;
    }

    public Date getNgayKiHD() {
        return ngayKiHD;
    }

    public void setNgayKiHD(Date ngayKiHD) {
        this.ngayKiHD = ngayKiHD;
    }

    public Date getNgayBanGiao() {
        return ngayBanGiao;
    }

    public void setNgayBanGiao(Date ngayBanGiao) {
        this.ngayBanGiao = ngayBanGiao;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public NhanVienHanhChinh getNv() {
        return nv;
    }

    public void setNv(NhanVienHanhChinh nv) {
        this.nv = nv;
    }

    public HopDong(String maHD, String tenHD, Date ngayKiHD, Date ngayBanGiao, String ghiChu, int trangThai, NhanVienHanhChinh nv) {
        this.maHD = maHD;
        this.tenHD = tenHD;
        this.ngayKiHD = ngayKiHD;
        this.ngayBanGiao = ngayBanGiao;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.nv = nv;
    }

    public HopDong(String maHD) {
        this.maHD = maHD;
    }

    public HopDong() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.maHD);
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
        final HopDong other = (HopDong) obj;
        return Objects.equals(this.maHD, other.maHD);
    }

    @Override
    public String toString() {
        return "HopDong{" + "maHD=" + maHD + ", tenHD=" + tenHD + ", ngayKiHD=" + ngayKiHD + ", ngayBanGiao=" + ngayBanGiao + ", ghiChu=" + ghiChu + ", trangThai=" + trangThai + ", nv=" + nv + '}';
    }
    
     public String get10char(String s) {
        return s.substring(0, 10);
    }

    public String getNgayKiHDString() {
        return get10char(this.ngayKiHD.toString());
    }
    public String getNgayBanGiaoString() {
        return get10char(this.ngayBanGiao.toString());
    }

}
