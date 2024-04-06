/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.BangLuongNhanVien;
import entity.NhanVienHanhChinh;
import entity.BangLuongNhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author vuhai
 */
public class BangLuongNhanVien_DAO {

    public ArrayList<BangLuongNhanVien> getAllBangLuongNhanVien() {
        ArrayList<BangLuongNhanVien> dsBL = new ArrayList<BangLuongNhanVien>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from BangLuongNhanVien";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maBangLuong = rs.getString(1);
                LocalDateTime ngayTinhLuong = rs.getTimestamp(2).toLocalDateTime();
                int soNgayLam = rs.getInt(3);
                int soNgayNghi = rs.getInt(4);
                double luongChinh = rs.getDouble(5);
                double luongTangCa = rs.getDouble(6);
                double tienUng = rs.getDouble(7);
                double tienPhuCap = rs.getDouble(8);
                double tienChuyenCan = rs.getDouble(9);
                double baoHiemXaHoi = rs.getDouble(10);
                double thucLanh = rs.getDouble(11);
                NhanVienHanhChinh_DAO nvdao = new NhanVienHanhChinh_DAO();
                NhanVienHanhChinh nv = nvdao.getNhanVienTheoMaVer2(rs.getString(12));
                BangLuongNhanVien bl = new BangLuongNhanVien();
                bl.setNv(nv);
                bl.setMaBangLuong(maBangLuong);
                bl.setNgayTinhLuong(ngayTinhLuong);
                bl.setSoNgayLam(soNgayLam);
                bl.setSoNgayNghi(soNgayNghi);
                bl.setTienUng(tienUng);

                bl.setLuongFromDB(luongChinh, luongTangCa, tienChuyenCan, tienPhuCap);
                dsBL.add(bl);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsBL;
    }

    public boolean createBangLuongNhanVien(BangLuongNhanVien bl) {
        ConnectDB.getInstance();
        final Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("insert into BangLuongNhanVien values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stm.setString(1, bl.getMaBangLuong());
            stm.setString(2, bl.getNgayTinhLuongString());
            stm.setInt(3, bl.getSoNgayLam());
            stm.setInt(4, bl.getSoNgayNghi());
            stm.setDouble(5, bl.getLuongChinh());
            stm.setDouble(6, bl.getLuongTangCa());
            stm.setDouble(7, bl.getTienUng());
            stm.setDouble(8, bl.getTienPhuCap());
            stm.setDouble(9, bl.getTienChuyenCan());
            stm.setDouble(10, bl.getBaoHiemXaHoi());
            stm.setDouble(11, bl.getThucLanh());
            stm.setString(12, bl.getNv().getMaNV());
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

    public boolean updateBangLuong(BangLuongNhanVien bl) {
        ConnectDB.getInstance();
        final Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("update BangLuongNhanVien set ngayTinhLuong  = ?, soNgayLam  = ?, soNgayNghi  = ?, luongChinh  = ?, luongTangCa  = ?, tienUng  = ?, tienPhuCapTheoThang = ?, tienChuyenCanTheoThang  = ?, baoHiemXaHoi = ?, thucLanh = ?, maNV = ? where maBangLuong  = ?");

            stm.setString(1, bl.getNgayTinhLuongString());
            stm.setInt(2, bl.getSoNgayLam());
            stm.setInt(3, bl.getSoNgayNghi());
            stm.setDouble(4, bl.getLuongChinh());
            stm.setDouble(5, bl.getLuongTangCa());
            stm.setDouble(6, bl.getTienUng());
            stm.setDouble(7, bl.getTienPhuCap());
            stm.setDouble(8, bl.getTienChuyenCan());
            stm.setDouble(9, bl.getBaoHiemXaHoi());
            stm.setDouble(10, bl.getThucLanh());
            stm.setString(11, bl.getNv().getMaNV());
            stm.setString(12, bl.getMaBangLuong());
            n = stm.executeUpdate();
//            JOptionPane.showMessageDialog(null, n + " update");
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

    public BangLuongNhanVien getBangLuongNhanVienTheoMa(String maBangLuong) {
        ArrayList<BangLuongNhanVien> dsBL = getAllBangLuongNhanVien();
        for (BangLuongNhanVien x : dsBL) {
            if (x.getMaBangLuong().equalsIgnoreCase(maBangLuong)) {
                return x;
            }
        }
        return null;
    }

    public BangLuongNhanVien getBangLuongNhanVienTheoThangNam(String thang, String nam, String maNV) {
        ArrayList<BangLuongNhanVien> dsBL = getAllBangLuongNhanVien();
//        ArrayList<BangLuongNhanVien> ds = new ArrayList<BangLuongNhanVien>();
        for (BangLuongNhanVien x : dsBL) {
            if (x.getMaBangLuong().substring(0, 2).equalsIgnoreCase(nam)
                    && x.getMaBangLuong().substring(2, 4).equalsIgnoreCase(thang)
                    && x.getNv().getMaNV().equalsIgnoreCase(maNV)) {
//                ds.add(x);
                return x;
            }
        }
        return null;
    }

    public ArrayList<BangLuongNhanVien> getDSBangLuongNhanVienTheoThangNam(String thang, String nam) {
//        ArrayList<BangLuongNhanVien> dsBL = getAllBangLuongNhanVien();
//        ArrayList<BangLuongNhanVien> ds = new ArrayList<BangLuongNhanVien>();
//        for (BangLuongNhanVien x : dsBL) {
//            if (x.getMaBangLuong().substring(0, 2).equalsIgnoreCase(nam)
//                    && x.getMaBangLuong().substring(2, 4).equalsIgnoreCase(thang)) {
//                ds.add(x);
////                return x;
//            }
//        }
//        return ds;
        ArrayList<BangLuongNhanVien> dsBL = new ArrayList<BangLuongNhanVien>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from BangLuongNhanVien WHERE MaBangLuong LIKE '" + nam + thang + "%'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maBangLuong = rs.getString(1);
                LocalDateTime ngayTinhLuong = rs.getTimestamp(2).toLocalDateTime();
                int soNgayLam = rs.getInt(3);
                int soNgayNghi = rs.getInt(4);
                double luongChinh = rs.getDouble(5);
                double luongTangCa = rs.getDouble(6);
                double tienUng = rs.getDouble(7);
                double tienPhuCap = rs.getDouble(8);
                double tienChuyenCan = rs.getDouble(9);
                double baoHiemXaHoi = rs.getDouble(10);
                double thucLanh = rs.getDouble(11);
                NhanVienHanhChinh_DAO nvdao = new NhanVienHanhChinh_DAO();
                NhanVienHanhChinh nv = nvdao.getNhanVienTheoMa(rs.getString(12));
                BangLuongNhanVien bl = new BangLuongNhanVien();
                bl.setNv(nv);
                bl.setMaBangLuong(maBangLuong);
                bl.setNgayTinhLuong(ngayTinhLuong);
                bl.setSoNgayLam(soNgayLam);
                bl.setSoNgayNghi(soNgayNghi);
                bl.setTienUng(tienUng);

                bl.setLuongFromDB(luongChinh, luongTangCa, tienChuyenCan, tienPhuCap);
                dsBL.add(bl);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsBL;
    }

}
