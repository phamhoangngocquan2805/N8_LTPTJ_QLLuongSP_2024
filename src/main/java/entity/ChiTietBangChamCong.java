/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
@Table(name = "ChiTietBangChamCong")
@EqualsAndHashCode()
public class ChiTietBangChamCong implements java.io.Serializable{
	@EmbeddedId
	ChiTietBangChamCongKey id;
	@Column(name = "soLuong", nullable = false, columnDefinition = "int")
    private int soLuong;
    @EqualsAndHashCode.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maBangPC")
	@JoinColumn(name = "maBangPC", nullable = false)
    private BangPhanCong bangPC;
    @EqualsAndHashCode.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maBangChamCong")
	@JoinColumn(name = "maBangChamCong", nullable = false)
    private BangChamCongCongNhan bangCC;
    
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BangPhanCong getBangPC() {
        return bangPC;
    }

    public void setBangPC(BangPhanCong bangPC) {
        this.bangPC = bangPC;
    }

    public BangChamCongCongNhan getBangCC() {
        return bangCC;
    }

    public void setBangCC(BangChamCongCongNhan bangCC) {
        this.bangCC = bangCC;
    }

    public ChiTietBangChamCong(int soLuong, BangPhanCong bangPC, BangChamCongCongNhan bangCC) {
        this.soLuong = soLuong;
        this.bangPC = bangPC;
        this.bangCC = bangCC;
    }

    @Override
    public String toString() {
        return "ChiTietBangChamCong{" + "soLuong=" + soLuong + ", bangPC=" + bangPC + ", bangCC=" + bangCC + '}';
    }
    
    
}
