/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

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
@Table(name = "PhongBan")
@EqualsAndHashCode()
public class PhongBan implements java.io.Serializable{
	@Id
	@Column(name = "maPB", nullable = false, unique = true, columnDefinition = "nvarchar(3)")
    private String maPB;
	@Column(name = "tenPB", columnDefinition = "nvarchar(50)", nullable = false)
    private String tenPB;
	
	@OneToMany(mappedBy = "phongBan")
	private Set<NhanVienHanhChinh> listNV;

    public String getMaPB() {
        return maPB;
    }

    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }

    public String getTenPB() {
        return tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

    public PhongBan(String maPB, String tenPB) {
        this.maPB = maPB;
        this.tenPB = tenPB;
    }

    public PhongBan() {
    }

    public PhongBan(String maPB) {
        this.maPB = maPB;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.maPB);
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
        final PhongBan other = (PhongBan) obj;
        return Objects.equals(this.maPB, other.maPB);
    }

    @Override
    public String toString() {
        return "PhongBan{" + "maPB=" + maPB + ", tenPB=" + tenPB + '}';
    }
    
}
