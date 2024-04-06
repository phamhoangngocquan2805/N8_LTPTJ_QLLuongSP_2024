/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.CongDoan;
import entity.HopDong;
import entity.SanPham;
import entity.NhanVienHanhChinh;
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
public class SanPham_DAO {

    public ArrayList<SanPham> getAllSanPham() {
        ArrayList<SanPham> dsSanPham = new ArrayList<SanPham>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from SanPham";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maSP = rs.getString(1);
                String tenSP = rs.getString(2);
                int soLuong = rs.getInt(3);
                double donGia = rs.getFloat(4);
                String thongTin = rs.getString(5);
                int soCongDoan = rs.getInt(6);
                String chatLieu = rs.getString(7);
                String donViTinh = rs.getString(8);
                //String tinhTrang = rs.getString(9);
                HopDong_DAO hddao = new HopDong_DAO();
                HopDong hd = hddao.getHopDongTheoMa(rs.getString(9));
                SanPham sp = new SanPham(maSP, tenSP, soLuong, donGia, thongTin, soCongDoan, chatLieu, donViTinh, hd);
                dsSanPham.add(sp);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsSanPham;
    }

    public boolean createSanPham(SanPham sp) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("insert into SanPham values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stm.setString(1, sp.getMaSP());
            stm.setString(2, sp.getTenSP());
            stm.setInt(3, sp.getSoLuong());
            stm.setFloat(4, (float) sp.getDonGia());
            stm.setString(5, sp.getThongTin());
            stm.setInt(6, sp.getSoCongDoan());
            stm.setString(7, sp.getChatLieu());
            stm.setString(8, sp.getDonViTinh());
            stm.setString(9, sp.getHopDong().getMaHD());
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

    public boolean updateSanPham(SanPham sp) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("update SanPham set tenSP = ?, soLuong = ?, donGia = ?, thongTin = ?, soCongDoan = ?, chatLieu = ?, donViTinh = ?, maHD = ? where maSP = ?");
            stm.setString(9, sp.getMaSP());
            stm.setString(1, sp.getTenSP());
            stm.setInt(2, sp.getSoLuong());
            stm.setFloat(3, (float) sp.getDonGia());
            stm.setString(4, sp.getThongTin());
            stm.setInt(5, sp.getSoCongDoan());
            stm.setString(6, sp.getChatLieu());
            stm.setString(7, sp.getDonViTinh());
            stm.setString(8, sp.getHopDong().getMaHD());
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

    public SanPham getSanPhamTheoMa(String maSP) {
        ArrayList<SanPham> dsSP = getAllSanPham();
        for (SanPham x : dsSP) {
            if (x.getMaSP().equalsIgnoreCase(maSP)) {
                return x;
            }
        }
        return null;
    }

    // return san pham theo ma san pham
    public ArrayList<SanPham> getSanPhamByMaSP(String maSP) {
        ArrayList<SanPham> sanpham = new ArrayList<SanPham>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from SanPham where maSP = ?";
            PreparedStatement preStmt = con.prepareStatement(sql);
            preStmt.setString(1, maSP);
            ResultSet rs = preStmt.executeQuery();
            while (rs.next()) {
                String maSPP = rs.getString(1);
                String tenSP = rs.getString(2);
                int soLuong = rs.getInt(3);
                double donGia = rs.getFloat(4);
                String thongTin = rs.getString(5);
                int soCongDoan = rs.getInt(6);
                String chatLieu = rs.getString(7);
                String donViTinh = rs.getString(8);
                //String tinhTrang = rs.getString(9);
                HopDong_DAO hddao = new HopDong_DAO();
                HopDong hd = hddao.getHopDongTheoMa(rs.getString(9));

                SanPham sp = new SanPham(maSPP, tenSP, soLuong, donGia, thongTin, soCongDoan, chatLieu, donViTinh, hd);
                sanpham.add(sp);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return sanpham;
    }

    public ArrayList<SanPham> getSanPhamTheoMaHD(String maHD) {
        ArrayList<SanPham> sanpham = new ArrayList<>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from SanPham where maHD = ?";
            PreparedStatement preStmt = con.prepareStatement(sql);
            preStmt.setString(1, maHD);
            ResultSet rs = preStmt.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString(1);
                String tenSP = rs.getString(2);
                int soLuong = rs.getInt(3);
                double donGia = rs.getFloat(4);
                String thongTin = rs.getString(5);
                int soCongDoan = rs.getInt(6);
                String chatLieu = rs.getString(7);
                String donViTinh = rs.getString(8);

                SanPham sp = new SanPham(maSP, tenSP, soLuong, donGia, thongTin, soCongDoan, chatLieu, donViTinh, null);
                // Lưu ý rằng ta để giá trị `null` cho `HopDong` tạm thời vì ta không có thông tin `HopDong` trong bảng SanPham.
                sanpham.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanpham;
    }

}
