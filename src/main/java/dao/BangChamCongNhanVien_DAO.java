/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.BangChamCongNhanVien;
import entity.CongDoan;
import entity.CongNhan;
import entity.NhanVienHanhChinh;
import entity.PhongBan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author vuhai
 */
public class BangChamCongNhanVien_DAO {

    public ArrayList<BangChamCongNhanVien> getAllBangChamCongNhanVien() {
        ArrayList<BangChamCongNhanVien> dsBangChamCongNhanVien = new ArrayList<BangChamCongNhanVien>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from BangChamCongNhanVien";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maBangChamCong = rs.getString(1);
                LocalTime gioVao = rs.getTime(2).toLocalTime();
                LocalTime gioRa = rs.getTime(3).toLocalTime();
                LocalDateTime ngayChamCong = rs.getTimestamp(4).toLocalDateTime();
                String caLamViec = rs.getString(5);
                NhanVienHanhChinh_DAO nvdao = new NhanVienHanhChinh_DAO();
                NhanVienHanhChinh nv = nvdao.getNhanVienTheoMa(rs.getString(6));

                BangChamCongNhanVien bcc = new BangChamCongNhanVien(maBangChamCong, gioVao, gioRa, ngayChamCong, caLamViec, nv);
                dsBangChamCongNhanVien.add(bcc);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsBangChamCongNhanVien;
    }

    public boolean createBangChamCongNhanVien(BangChamCongNhanVien bcc) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("insert into BangChamCongNhanVien values(?, ?, ?, ?, ?, ?)");
            stm.setString(1, bcc.getMaBangChamCong());
            stm.setString(2, bcc.getGioVaoString());
            stm.setString(3, bcc.getGioRaString());
            stm.setString(4, bcc.getNgayChamCongString());
            stm.setString(5, bcc.getCaLamViec());
            stm.setString(6, bcc.getNv().getMaNV());
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

    public boolean updateBangChamCongNhanVien(BangChamCongNhanVien bcc) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("update BangChamCongNhanVien set gioVao = ?, gioRa = ?, ngayChamCong = ?, caLamViec = ?, maNV = ? where maBangChamCong = ?");
            stm.setString(6, bcc.getMaBangChamCong());
            stm.setString(1, bcc.getGioVaoString());
            stm.setString(2, bcc.getGioRaString());
            stm.setString(3, bcc.getNgayChamCongString());
            stm.setString(4, bcc.getCaLamViec());
            stm.setString(5, bcc.getNv().getMaNV());
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

    public boolean deleteBangChamCongNhanVien(String maBangChamCong){
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;

        try {
            String sql = "Delete from BangChamCongNhanVien WHERE maBangChamCong=?";
            stm = con.prepareStatement(sql);

            stm.setString(1, maBangChamCong);
            n = stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return n > 0;
    }

    public BangChamCongNhanVien getBangChamCongNhanVienTheoMa(String maBangChamCongNhanVien) {
        ArrayList<BangChamCongNhanVien> dsSP = getAllBangChamCongNhanVien();
        for (BangChamCongNhanVien x : dsSP) {
            if (x.getMaBangChamCong().equalsIgnoreCase(maBangChamCongNhanVien)) {
                return x;
            }
        }
        return null;
    }

    public String getMaCCMoiNhat() {
        String maCC = "";
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT TOP 1 maBangChamCong FROM BangChamCongNhanVien ORDER BY maBangChamCong desc";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                maCC = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maCC;
    }
    
    // lấy danh sách chấm công theo khoảng thời gian 
    public ArrayList<BangChamCongNhanVien> getBangCCNhanVienTheoKhoangTG(String tuNgay, String denNgay) {
        ArrayList<BangChamCongNhanVien> dsBangChamCongNhanVien = new ArrayList<BangChamCongNhanVien>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from BangChamCongNhanVien where ngayChamCong between '" + tuNgay + "' and '" + denNgay + "'";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String maBangChamCong = rs.getString(1);
                LocalTime gioVao = rs.getTime(2).toLocalTime();
                LocalTime gioRa = rs.getTime(3).toLocalTime();
                LocalDateTime ngayChamCong = rs.getTimestamp(4).toLocalDateTime();
                String caLamViec = rs.getString(5);
                NhanVienHanhChinh_DAO nvdao = new NhanVienHanhChinh_DAO();
                NhanVienHanhChinh nv = nvdao.getNhanVienTheoMa(rs.getString(6));

                BangChamCongNhanVien bcc = new BangChamCongNhanVien(maBangChamCong, gioVao, gioRa, ngayChamCong, caLamViec, nv);
                dsBangChamCongNhanVien.add(bcc);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsBangChamCongNhanVien;
    }
    
    // lấy danh sách chấm công theo mã nhân viên và ngay cham cong
    public ArrayList<BangChamCongNhanVien> getBangCCNhanVienTheoMaNVVaNgayCC(String maNV, String ngayCC) {
        ArrayList<BangChamCongNhanVien> dsBangChamCongNhanVien = new ArrayList<BangChamCongNhanVien>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from BangChamCongNhanVien where maNV = '" + maNV + "' and ngayChamCong = '" + ngayCC + "'";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String maBangChamCong = rs.getString(1);
                LocalTime gioVao = rs.getTime(2).toLocalTime();
                LocalTime gioRa = rs.getTime(3).toLocalTime();
                LocalDateTime ngayChamCong = rs.getTimestamp(4).toLocalDateTime();
                String caLamViec = rs.getString(5);
                NhanVienHanhChinh_DAO nvdao = new NhanVienHanhChinh_DAO();
                NhanVienHanhChinh nv = nvdao.getNhanVienTheoMa(rs.getString(6));

                BangChamCongNhanVien bcc = new BangChamCongNhanVien(maBangChamCong, gioVao, gioRa, ngayChamCong, caLamViec, nv);
                dsBangChamCongNhanVien.add(bcc);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsBangChamCongNhanVien;
    }
    
   // return bảng chấm công theo mã bảng cc
    public ArrayList<BangChamCongNhanVien> getBangCCByMaBCC(String maBCC) {
        ArrayList<BangChamCongNhanVien> bangChamCong = new ArrayList<BangChamCongNhanVien>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from BangChamCongNhanVien where maBangChamCong = ?";
            PreparedStatement preStmt = con.prepareStatement(sql);
            preStmt.setString(1, maBCC);
            ResultSet rs = preStmt.executeQuery();
            while (rs.next()) {
                String maBangChamCong = rs.getString(1);
                LocalTime gioVao = rs.getTime(2).toLocalTime();
                LocalTime gioRa = rs.getTime(3).toLocalTime();
                LocalDateTime ngayChamCong = rs.getTimestamp(4).toLocalDateTime();
                String caLamViec = rs.getString(5);
                NhanVienHanhChinh_DAO nvdao = new NhanVienHanhChinh_DAO();
                NhanVienHanhChinh nv = nvdao.getNhanVienTheoMa(rs.getString(6));

                BangChamCongNhanVien bcc = new BangChamCongNhanVien(maBangChamCong, gioVao, gioRa, ngayChamCong, caLamViec, nv);
                bangChamCong.add(bcc);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return bangChamCong;
    }
}
