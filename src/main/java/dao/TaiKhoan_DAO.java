/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package dao;
//
//import connectDB.ConnectDB;
//import entity.NhanVienHanhChinh;
//import entity.TaiKhoan;
//import entity.PhongBan;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//
///**
// *
// * @author vuhai
// */
//public class TaiKhoan_DAO {
//    public ArrayList<TaiKhoan> getAllTaiKhoan()
//	{
//		ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "select * from TaiKhoan";
//			Statement stm = con.createStatement();
//			ResultSet rs = stm.executeQuery(sql);
//			while(rs.next())
//			{
//				NhanVienHanhChinh_DAO nvdao = new NhanVienHanhChinh_DAO();
//                                NhanVienHanhChinh nv = nvdao.getNhanVienTheoMa(rs.getString(1));
//				String tenTK = rs.getString(2);
//                                String matKhau = rs.getString(3);                                                             
//                                TaiKhoan tk = new TaiKhoan(nv, tenTK, matKhau);
//				dsTK.add(tk);
//			}
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dsTK;
//	}
//	
//    public boolean createTaiKhoan(final TaiKhoan tk) {
//        ConnectDB.getInstance();
//        final Connection con = ConnectDB.getConnection();
//        PreparedStatement stm = null;
//        int n = 0;
//        try {
//            stm = con.prepareStatement("insert into TaiKhoan values(?, ?, ?)");
//            stm.setString(1, tk.getNv().getMaNV());
//            stm.setString(2, tk.getTenTK());
//            stm.setString(3, tk.getMatKhau());
//            n = stm.executeUpdate();
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//            try {
//                stm.close();
//            }
//            catch (SQLException e2) {
//                e2.printStackTrace();
//            }
//        }
//        finally {
//            try {
//                stm.close();
//            }
//            catch (SQLException e3) {
//                e3.printStackTrace();
//            }
//        }
//        return n > 0;
//    }
//    
//    public boolean updateTaiKhoan(final TaiKhoan tk) {
//        ConnectDB.getInstance();
//        final Connection con = ConnectDB.getConnection();
//        PreparedStatement stm = null;
//        int n = 0;
//        try {
//            stm = con.prepareStatement("update TaiKhoan set tenTK = ?, matKhau = ? where maNV = ?");           
//            stm.setString(1, tk.getTenTK());
//            stm.setString(2, tk.getMatKhau());
//            stm.setString(3, tk.getNv().getMaNV());
//            n = stm.executeUpdate();
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//            try {
//                stm.close();
//            }
//            catch (SQLException e2) {
//                e2.printStackTrace();
//            }
//        }
//        finally {
//            try {
//                stm.close();
//            }
//            catch (SQLException e3) {
//                e3.printStackTrace();
//            }
//        }
//        return n > 0;
//    }
//
//        public TaiKhoan getTaiKhoanTheoMa(String maNV)
//        {
//            ArrayList<TaiKhoan> dsTK = getAllTaiKhoan();
//            for(TaiKhoan x : dsTK)
//            {
//                if(x.getNv().getMaNV().equalsIgnoreCase(maNV))
//                    return x;
//            }
//            return null;
//        }
//}
package dao;

import connectDB.ConnectDB;
import entity.NhanVienHanhChinh;
import entity.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author tho
 */
public class TaiKhoan_DAO {

    public ArrayList<TaiKhoan> getAllTaiKhoan() {
        ArrayList<TaiKhoan> dsTK = new ArrayList<>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from TaiKhoan";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                NhanVienHanhChinh_DAO nvdao = new NhanVienHanhChinh_DAO();
                NhanVienHanhChinh nv = nvdao.getNhanVienTheoMa(rs.getString("maNV"));
                String tenTK = rs.getString("tenTaiKhoan");
                String matKhau = rs.getString("matKhau");
                TaiKhoan tk = new TaiKhoan(nv, tenTK, matKhau);
                dsTK.add(tk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsTK;
    }

    public boolean createTaiKhoan(final TaiKhoan tk) {
        ConnectDB.getInstance();
        final Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("insert into TaiKhoan values(?, ?, ?)");
            stm.setString(1, tk.getNv().getMaNV());
            stm.setString(2, tk.getTenTK());
            stm.setString(3, tk.getMatKhau());
            n = stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n > 0;
    }

    public boolean updateTaiKhoan(final TaiKhoan tk) {
        ConnectDB.getInstance();
        final Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("update TaiKhoan set tenTaiKhoan = ?, matKhau = ? where maNV = ?");
            stm.setString(1, tk.getTenTK());
            stm.setString(2, tk.getMatKhau());
            stm.setString(3, tk.getNv().getMaNV());
            n = stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n > 0;
    }

    public boolean xoaTaiKhoan(String ma) throws SQLException {
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("delete TaiKhoan where maNV = ?");
            stmt.setString(1, ma);
            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n > 0;
    }

    public TaiKhoan getTaiKhoanTheoMa(String maNV) {
        ArrayList<TaiKhoan> dsTK = getAllTaiKhoan();
        for (TaiKhoan x : dsTK) {
            if (x.getNv().getMaNV().equalsIgnoreCase(maNV)) {
                return x;
            }
        }
        return null;
    }
}
