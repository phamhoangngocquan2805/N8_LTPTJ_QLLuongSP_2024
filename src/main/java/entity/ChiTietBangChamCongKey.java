package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ChiTietBangChamCongKey implements java.io.Serializable{
	@Column(name = "maBangChamCong")
	String maBangChamCong;
	@Column(name = "maBangPC")
	String maBangPC;
}
