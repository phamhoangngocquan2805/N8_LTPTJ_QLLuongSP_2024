/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.CongNhan;
import entity.PhongBan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author vuhai
 */
public class PhongBan_DAO {
      public ArrayList<PhongBan> getAllPhongBan()
	{
		ArrayList<PhongBan> dsPB= new ArrayList<PhongBan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from PhongBan";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next())
			{
				String maPB = rs.getString(1);
				String tenPB = rs.getString(2);
                                PhongBan pb = new PhongBan(maPB, tenPB);
				dsPB.add(pb);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsPB;
	}
	
    public boolean createPhongBan(PhongBan pb)
	{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("insert into PhongBan values(?, ?)");
			stm.setString(1, pb.getMaPB());
			stm.setString(2, pb.getTenPB());
			n = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			try {
				stm.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
    
        public PhongBan getPhongBanTheoMa(String maPB)
        {
            ArrayList<PhongBan> dsPB = getAllPhongBan();
            for(PhongBan x : dsPB)
            {
                if(x.getMaPB().equalsIgnoreCase(maPB))
                    return x;
            }
            return null;
        }
           
        
        /**
	 * 
	 * @param ten phòng ban được nhập
	 * @return mã phòng ban
	 */
	
	public String getMaPBTheoTenPB(String tenPB) {
		String maPB ="";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select maPB from PhongBan where tenPB = N'"+tenPB +"'";
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				
				maPB = rs.getString(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return maPB;
		
	}
}
