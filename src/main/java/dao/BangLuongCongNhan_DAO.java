/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.CongNhan;
import entity.BangLuongCongNhan;
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
public class BangLuongCongNhan_DAO {

    public ArrayList<BangLuongCongNhan> getAllBangLuongCongNhan() {
        ArrayList<BangLuongCongNhan> dsBL = new ArrayList<BangLuongCongNhan>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from BangLuongCongNhan";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maBangLuong = rs.getString(1);
                LocalDateTime ngayTinhLuong = rs.getTimestamp(2).toLocalDateTime();
                int soNgayLam = rs.getInt(3);
                int soNgayNghi = rs.getInt(4);
                double luongSanPham = rs.getDouble(5);
                double luongTangCa = rs.getDouble(6);
                double tienUng = rs.getDouble(7);
                double tienPhuCap = rs.getDouble(8);
                double tienChuyenCan = rs.getDouble(9);
                double baoHiemXaHoi = rs.getDouble(10);
                double thucLanh = rs.getDouble(11);
                CongNhan_DAO cndao = new CongNhan_DAO();
                CongNhan congNhan = cndao.getCongNhanTheoMaVer2(rs.getString(12));
                BangLuongCongNhan bl = new BangLuongCongNhan();
                bl.setMaBangLuong(maBangLuong);
                bl.setNgayTinhLuong(ngayTinhLuong);
                bl.setSoNgayLam(soNgayLam);
                bl.setSoNgayNghi(soNgayNghi);
                bl.setCongNhan(congNhan);
                bl.setTienUng(tienUng);
                bl.setLuongFromDB(luongSanPham, luongTangCa, tienChuyenCan, tienPhuCap);
                dsBL.add(bl);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsBL;
    }

    public boolean createBangLuongCongNhan(BangLuongCongNhan bl) {
        ConnectDB.getInstance();
        final Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("insert into BangLuongCongNhan values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stm.setString(1, bl.getMaBangLuong());
            stm.setString(2, bl.getNgayTinhLuongString());
            stm.setInt(3, bl.getSoNgayLam());
            stm.setInt(4, bl.getSoNgayNghi());
            stm.setDouble(5, bl.getLuongSanPham());
            stm.setDouble(6, bl.getLuongTangCa());
            stm.setDouble(7, bl.getTienUng());
            stm.setDouble(8, bl.getTienPhuCap());
            stm.setDouble(9, bl.getTienChuyenCan());
            stm.setDouble(10, bl.getBaoHiemXaHoi());
            stm.setDouble(11, bl.getThucLanh());
            stm.setString(12, bl.getCongNhan().getMaCN());
            n = stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                stm.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        } finally {
            try {
                stm.close();
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        }
        return n > 0;
    }

    public boolean updateBangLuong(BangLuongCongNhan bl) {
        ConnectDB.getInstance();
        final Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("update BangLuongCongNhan set ngayTinhLuong  = ?, soNgayLam  = ?, soNgayNghi  = ?, luongSP  = ?, luongTangCa  = ?, tienUng  = ?, tienPhuCapTheoThang = ?, tienChuyenCanTheoThang  = ?, baoHiemXaHoi = ?, thucLanh = ?, maCN = ? where maBangLuong  = ?");
            stm.setString(12, bl.getMaBangLuong());
            stm.setString(1, bl.getNgayTinhLuongString());
            stm.setInt(2, bl.getSoNgayLam());
            stm.setInt(3, bl.getSoNgayNghi());
            stm.setDouble(4, bl.getLuongSanPham());
            stm.setDouble(5, bl.getLuongTangCa());
            stm.setDouble(6, bl.getTienUng());
            stm.setDouble(7, bl.getTienPhuCap());
            stm.setDouble(8, bl.getTienChuyenCan());
            stm.setDouble(9, bl.getBaoHiemXaHoi());
            stm.setDouble(10, bl.getThucLanh());
            stm.setString(11, bl.getCongNhan().getMaCN());
            n = stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                stm.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        } finally {
            try {
                stm.close();
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        }
        return n > 0;
    }

    public BangLuongCongNhan getBangLuongCongNhanTheoMa(String maBangLuong) {
        ArrayList<BangLuongCongNhan> dsBL = getAllBangLuongCongNhan();
        for (BangLuongCongNhan x : dsBL) {
            if (x.getMaBangLuong().equalsIgnoreCase(maBangLuong)) {
                return x;
            }
        }
        return null;
    }

    public BangLuongCongNhan getBangLuongCongNhanTheoThangNam(String thang, String nam, String maNV) {
        ArrayList<BangLuongCongNhan> dsBL = getAllBangLuongCongNhan();
//        ArrayList<BangLuongCongNhan> ds = new ArrayList<BangLuongCongNhan>();
        for (BangLuongCongNhan x : dsBL) {
            if (x.getMaBangLuong().substring(0, 2).equalsIgnoreCase(nam)
                    && x.getMaBangLuong().substring(2, 4).equalsIgnoreCase(thang)
                    && x.getCongNhan().getMaCN().equalsIgnoreCase(maNV)) {
//                ds.add(x);
                return x;
            }
        }
        return null;
    }

    public ArrayList<BangLuongCongNhan> getDSBangLuongCongNhanTheoThangNam(String thang, String nam) {
//        ArrayList<BangLuongCongNhan> dsBL = getAllBangLuongCongNhan();
//        ArrayList<BangLuongCongNhan> ds = new ArrayList<BangLuongCongNhan>();
//        for (BangLuongCongNhan x : dsBL) {
//            if (x.getMaBangLuong().substring(0, 2).equalsIgnoreCase(nam)
//                    && x.getMaBangLuong().substring(2, 4).equalsIgnoreCase(thang)) {
//                ds.add(x);
////                return x;
//            }
//        }
//        return ds;
        ArrayList<BangLuongCongNhan> dsBL = new ArrayList<BangLuongCongNhan>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from BangLuongCongNhan WHERE MaBangLuong LIKE '" + nam + thang + "%'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maBangLuong = rs.getString(1);
                LocalDateTime ngayTinhLuong = rs.getTimestamp(2).toLocalDateTime();
                int soNgayLam = rs.getInt(3);
                int soNgayNghi = rs.getInt(4);
                double luongSanPham = rs.getDouble(5);
                double luongTangCa = rs.getDouble(6);
                double tienUng = rs.getDouble(7);
                double tienPhuCap = rs.getDouble(8);
                double tienChuyenCan = rs.getDouble(9);
                double baoHiemXaHoi = rs.getDouble(10);
                double thucLanh = rs.getDouble(11);
                CongNhan_DAO cndao = new CongNhan_DAO();
                CongNhan congNhan = cndao.getCongNhanTheoMa(rs.getString(12));
                BangLuongCongNhan bl = new BangLuongCongNhan();
                bl.setMaBangLuong(maBangLuong);
                bl.setNgayTinhLuong(ngayTinhLuong);
                bl.setSoNgayLam(soNgayLam);
                bl.setSoNgayNghi(soNgayNghi);
                bl.setCongNhan(congNhan);
                bl.setTienUng(tienUng);
                bl.setLuongFromDB(luongSanPham, luongTangCa, tienChuyenCan, tienPhuCap);
                dsBL.add(bl);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsBL;
    }

}
