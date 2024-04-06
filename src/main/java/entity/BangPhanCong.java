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
@Table(name = "BangPhanCong")
@EqualsAndHashCode()
public class BangPhanCong implements java.io.Serializable{
	@Id
	@Column(name = "maBangPC", nullable = false, unique = true, columnDefinition = "nvarchar(10)")
    private String maBangPC;
    @Column(name = "soLuong", nullable = false, columnDefinition = "int")
	private int soLuong;
    @EqualsAndHashCode.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maCD", nullable = false)
    private CongDoan congDoan;
    @EqualsAndHashCode.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maCN", nullable = false)
    private CongNhan congNhan;
    
    @OneToMany(mappedBy = "bangPC")
    private Set<ChiTietBangChamCong> listCTBCC;

    public String getMaBangPC() {
        return maBangPC;
    }

    public void setMaBangPC(String maBangPC) {
        this.maBangPC = maBangPC;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public CongDoan getCongDoan() {
        return congDoan;
    }

    public void setCongDoan(CongDoan congDoan) {
        this.congDoan = congDoan;
    }

    public CongNhan getCongNhan() {
        return congNhan;
    }

    public void setCongNhan(CongNhan congNhan) {
        this.congNhan = congNhan;
    }

    public BangPhanCong(String maBangPC, int soLuong, CongDoan congDoan, CongNhan congNhan) {
        this.maBangPC = maBangPC;
        this.soLuong = soLuong;
        this.congDoan = congDoan;
        this.congNhan = congNhan;
    }

    public BangPhanCong(String maBangPC) {
        this.maBangPC = maBangPC;
    }

    public BangPhanCong() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.maBangPC);
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
        final BangPhanCong other = (BangPhanCong) obj;
        return Objects.equals(this.maBangPC, other.maBangPC);
    }

    @Override
    public String toString() {
        return "BangPhanCong{" + "maBangPC=" + maBangPC + ", soLuong=" + soLuong + ", congDoan=" + congDoan + ", congNhan=" + congNhan + '}';
    }
    
    
}
