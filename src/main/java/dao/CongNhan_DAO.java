/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connectDB.ConnectDB;
import entity.CongNhan;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 *
 * @author vuhai
 */
public class CongNhan_DAO {

    public ArrayList<CongNhan> getAllCongNhan() {
        ArrayList<CongNhan> dsCongNhan = new ArrayList<CongNhan>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from CongNhan";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maCN = rs.getString(1);
                String tenCN = rs.getString(2);
                Boolean phai = rs.getBoolean(3);
                Date ngaySinh = rs.getDate(4);
                String soDT = rs.getString(5);
                String diaChi = rs.getString(6);
                Boolean tinhTrang = rs.getBoolean(7);
                Date ngayVaoLam = rs.getDate(8);
                String hinhAnh = rs.getString(9);
                String tayNghe = rs.getString(10);
                String kinhNghiem = rs.getString(11);
                double tienPhuCapTheoNgay = rs.getFloat(12);
                double tienChuyenCan = rs.getFloat(13);
                String ghiChu = rs.getString(14);
                CongNhan cn = new CongNhan(maCN, tenCN, phai, ngaySinh, soDT, diaChi, tinhTrang, ngayVaoLam, hinhAnh, tayNghe, kinhNghiem, tienPhuCapTheoNgay, tienChuyenCan, ghiChu);
                dsCongNhan.add(cn);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsCongNhan;
    }

    public boolean createCongNhan(CongNhan cn) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("insert into CongNhan values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
            stm.setString(1, cn.getMaCN());
            stm.setString(2, cn.getHoTen());
            stm.setBoolean(3, cn.isPhai());
            stm.setString(4, cn.getNgaySinhString());
            stm.setString(5, cn.getSoDT());
            stm.setString(6, cn.getDiaChi());
            stm.setBoolean(7, cn.isTinhTrang());
            stm.setString(8, cn.getNgayVaoLamString());
            stm.setString(9, cn.getHinhAnh());
            stm.setString(10, cn.getTayNghe());
            stm.setString(11, cn.getKinhNghiem());
            stm.setFloat(12, (float) cn.getTienPhuCapTheoNgay());
            stm.setFloat(13, (float) cn.getTienChuyenCan());
            stm.setString(14, cn.getGhiChu());

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

    public boolean updateCongNhan(CongNhan cn) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("update CongNhan set tenCN = ?, phai = ?, ngaySinh = ?, soDT = ?, diaChi = ?, tinhTrang = ?, ngayVaoLam = ?, hinhAnh = ?, tayNghe = ?, kinhNghiem = ?, tienPhuCapTheoNgay = ?, tienChuyenCan = ?,ghiChu = ? where maCN = ?");
            stm.setString(14, cn.getMaCN());
            stm.setString(1, cn.getHoTen());
            stm.setBoolean(2, cn.isPhai());
            stm.setString(3, cn.getNgaySinhString());
            stm.setString(4, cn.getSoDT());
            stm.setString(5, cn.getDiaChi());
            stm.setBoolean(6, cn.isTinhTrang());
            stm.setString(7, cn.getNgayVaoLamString());
            stm.setString(8, cn.getHinhAnh());
            stm.setString(9, cn.getTayNghe());
            stm.setString(10, cn.getKinhNghiem());
            stm.setFloat(11, (float) cn.getTienPhuCapTheoNgay());
            stm.setFloat(12, (float) cn.getTienChuyenCan());
            stm.setString(13, cn.getGhiChu());

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

    public CongNhan getCongNhanTheoMa(String maCN) {
        ArrayList<CongNhan> dsCN = getAllCongNhan();
        for (CongNhan x : dsCN) {
            if (x.getMaCN().equalsIgnoreCase(maCN)) {
                return x;
            }
        }
        return null;
    }

    // Tự động phát sinh mã công nhân
    public String getMaCN() {
        String maCN = "";
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select CONCAT(CONCAT(RIGHT(YEAR(getdate()),2),1), RIGHT(CONCAT('000',ISNULL(right(max(maCN),3),0) + 1),3)) from [dbo].[CongNhan] where maCN like '__1%'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                maCN = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maCN;
    }

    public boolean checkSdtCN(String soDT) {
        CongNhan CN = new CongNhan();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("select * from CongNhan where soDT = '" + soDT + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CN.setMaCN(rs.getString(1));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<CongNhan> getAllCongNhanTheoTayNghe(String tayNghe) {
        ArrayList<CongNhan> dsCongNhan = new ArrayList<CongNhan>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from CongNhan\n"
                    + "where tayNghe = N'"+tayNghe+"'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maCN = rs.getString(1);
                String tenCN = rs.getString(2);
                Boolean phai = rs.getBoolean(3);
                Date ngaySinh = rs.getDate(4);
                String soDT = rs.getString(5);
                String diaChi = rs.getString(6);
                Boolean tinhTrang = rs.getBoolean(7);
                Date ngayVaoLam = rs.getDate(8);
                String hinhAnh = rs.getString(9);
                String tayNghee = rs.getString(10);
                String kinhNghiem = rs.getString(11);
                double tienPhuCapTheoNgay = rs.getFloat(12);
                double tienChuyenCan = rs.getFloat(13);
                String ghiChu = rs.getString(14);
                CongNhan cn = new CongNhan(maCN, tenCN, phai, ngaySinh, soDT, diaChi, tinhTrang, ngayVaoLam, hinhAnh, tayNghee, kinhNghiem, tienPhuCapTheoNgay, tienChuyenCan, ghiChu);
                dsCongNhan.add(cn);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsCongNhan;
    }
    public CongNhan getCongNhanTheoMaVer2(String maCn) {
        CongNhan cn = null;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from CongNhan where maCN = " + maCn;
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maCN = rs.getString(1);
                String tenCN = rs.getString(2);
                Boolean phai = rs.getBoolean(3);
                Date ngaySinh = rs.getDate(4);
                String soDT = rs.getString(5);
                String diaChi = rs.getString(6);
                Boolean tinhTrang = rs.getBoolean(7);
                Date ngayVaoLam = rs.getDate(8);
                String hinhAnh = rs.getString(9);
                String tayNghe = rs.getString(10);
                String kinhNghiem = rs.getString(11);
                double tienPhuCapTheoNgay = rs.getFloat(12);
                double tienChuyenCan = rs.getFloat(13);
                String ghiChu = rs.getString(14);
                cn = new CongNhan(maCN, tenCN, phai, ngaySinh, soDT, diaChi, tinhTrang, ngayVaoLam, hinhAnh, tayNghe, kinhNghiem, tienPhuCapTheoNgay, tienChuyenCan, ghiChu);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return cn;
    }
}
