/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@EqualsAndHashCode()
@Table(name = "BangChamCongNhanVien")
public class BangChamCongNhanVien implements java.io.Serializable {
	@Id
	@Column(name = "maBangChamCong", nullable = false, unique = true)
    private String maBangChamCong;
	@Column(name = "gioVao", nullable = false, columnDefinition = "time")
    private LocalTime gioVao;
	@Column(name = "gioRa", nullable = false, columnDefinition = "time")
    private LocalTime gioRa;
	@Column(name = "ngayChamCong", nullable = false, columnDefinition = "datetime")
    private LocalDateTime ngayChamCong;
	@Column(name = "caLamViec", nullable = false, columnDefinition = "nvarchar(20)")
    private String caLamViec;
    @EqualsAndHashCode.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNV", nullable = false)
    private NhanVienHanhChinh nv;

    public String getMaBangChamCong() {
        return maBangChamCong;
    }

    public void setMaBangChamCong(String maBangChamCong) {
        this.maBangChamCong = maBangChamCong;
    }

    public LocalTime getGioVao() {
        return gioVao;
    }

    public void setGioVao(LocalTime gioVao) {
        this.gioVao = gioVao;
    }

    public LocalTime getGioRa() {
        return gioRa;
    }

    public void setGioRa(LocalTime gioRa) {
        this.gioRa = gioRa;
    }

    public LocalDateTime getNgayChamCong() {
        return ngayChamCong;
    }

    public void setNgayChamCong(LocalDateTime ngayChamCong) {
        this.ngayChamCong = ngayChamCong;
    }

    public String getCaLamViec() {
        return caLamViec;
    }

    public void setCaLamViec(String caLamViec) {
        this.caLamViec = caLamViec;
    }

    public NhanVienHanhChinh getNv() {
        return nv;
    }

    public void setNv(NhanVienHanhChinh nv) {
        this.nv = nv;
    }

    public BangChamCongNhanVien(String maBangChamCong, LocalTime gioVao, LocalTime gioRa, LocalDateTime ngayChamCong, String caLamViec, NhanVienHanhChinh nv) {
        this.maBangChamCong = maBangChamCong;
        this.gioVao = gioVao;
        this.gioRa = gioRa;
        this.ngayChamCong = ngayChamCong;
        this.caLamViec = caLamViec;
        this.nv = nv;
    }

    public BangChamCongNhanVien(String maBangChamCong) {
        this.maBangChamCong = maBangChamCong;
    }

    public BangChamCongNhanVien() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.maBangChamCong);
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
        final BangChamCongNhanVien other = (BangChamCongNhanVien) obj;
        return Objects.equals(this.maBangChamCong, other.maBangChamCong);
    }

    @Override
    public String toString() {
        return "BangChamCongNhanVien{" + "maBangChamCong=" + maBangChamCong + ", gioVao=" + gioVao + ", gioRa=" + gioRa + ", ngayChamCong=" + ngayChamCong + ", caLamViec=" + caLamViec + ", nv=" + nv + '}';
    }
    
    public String get10char(String s) {
        return s.substring(0, 10);
    }

    public String getNgayChamCongString() {
        return get10char(this.ngayChamCong.toString());
    }
    public String getGioVaoString() {
        return (this.gioVao.toString());
    }
    public String getGioRaString() {
        return (this.gioRa.toString());
    }
}
