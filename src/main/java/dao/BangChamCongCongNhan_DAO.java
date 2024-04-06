/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.BangChamCongCongNhan;
import entity.BangPhanCong;
import entity.ChiTietBangChamCong;
import entity.CongNhan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author vuhai
 */
public class BangChamCongCongNhan_DAO {

    public ArrayList<BangChamCongCongNhan> getAllBangChamCongCongNhan() {
        ArrayList<BangChamCongCongNhan> dsBangChamCongCongNhan = new ArrayList<BangChamCongCongNhan>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from BangChamCongCongNhan";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maBangChamCong = rs.getString(1);
                LocalTime gioVao = rs.getTime(2).toLocalTime();
                LocalTime gioRa = rs.getTime(3).toLocalTime();
                LocalDateTime ngayChamCong = rs.getTimestamp(4).toLocalDateTime();
                String caLamViec = rs.getString(5);
                CongNhan_DAO cndao = new CongNhan_DAO();
                CongNhan cn = cndao.getCongNhanTheoMa(rs.getString(6));

                BangChamCongCongNhan bcc = new BangChamCongCongNhan(maBangChamCong, gioVao, gioRa, ngayChamCong, caLamViec, cn);
                dsBangChamCongCongNhan.add(bcc);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsBangChamCongCongNhan;
    }

    public boolean createBangChamCongCongNhan(BangChamCongCongNhan bcc) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("insert into BangChamCongCongNhan values(?, ?, ?, ?, ?, ?)");
            stm.setString(1, bcc.getMaBangChamCong());
            stm.setString(2, bcc.getGioVao().toString());
            stm.setString(3, bcc.getGioRa().toString());
            stm.setString(4, bcc.getNgayChamCongString());
            stm.setString(5, bcc.getCaLamViec());
            stm.setString(6, bcc.getCn().getMaCN());
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

    public boolean updateBangChamCongCongNhan(BangChamCongCongNhan bcc) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("update BangChamCongCongNhan set gioVao = ?, gioRa = ?, ngayChamCong = ?, caLamViec = ?,maCN = ? where maBangChamCong = ?");
            stm.setString(6, bcc.getMaBangChamCong());
            stm.setString(1, bcc.getGioVaoString());
            stm.setString(2, bcc.getGioRaString());
            stm.setString(3, bcc.getNgayChamCongString());
            stm.setString(4, bcc.getCaLamViec());
            stm.setString(5, bcc.getCn().getMaCN());
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

    public BangChamCongCongNhan getBangChamCongCongNhanTheoMa(String maBangChamCongCongNhan) {
        ArrayList<BangChamCongCongNhan> dsSP = getAllBangChamCongCongNhan();
        for (BangChamCongCongNhan x : dsSP) {
            if (x.getMaBangChamCong().equalsIgnoreCase(maBangChamCongCongNhan)) {
                return x;
            }
        }
        return null;
    }

    public BangChamCongCongNhan getBangChamCongMoiNhat(String ngayCham) {
        BangChamCongCongNhan bcc = new BangChamCongCongNhan();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT TOP 1 * FROM BangChamCongCongNhan\n"
                    + "where ngayChamCong = '" + ngayCham + "'\n"
                    + "ORDER BY maBangChamCong DESC";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maBangCC = rs.getString(1);
                LocalTime gioVao = rs.getTime(2).toLocalTime();
                LocalTime gioRa = rs.getTime(3).toLocalTime();
                LocalDateTime ngayChamCong = rs.getTimestamp(4).toLocalDateTime();
                String caLamViec = rs.getString(5);
                CongNhan_DAO cndao = new CongNhan_DAO();
                CongNhan cn = cndao.getCongNhanTheoMa(rs.getString(6));

                bcc = new BangChamCongCongNhan(maBangCC, gioVao, gioRa, ngayChamCong, caLamViec, cn);

            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return bcc;
    }

    public boolean checkBangChamCongTrongNgay(String maPC, String ngayCham) {
        boolean check = false;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from BangChamCongCongNhan cc join ChiTietBangChamCong ct\n"
                    + "on cc.maBangChamCong = ct.maBangChamCong\n"
                    + "where ct.maBangPC =" + maPC + "and " + "ngayChamCong = '" + ngayCham + "'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maBangCC = rs.getString(1);
                if (maBangCC != null) {
                    check = true;
                }
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return check;
    }

    public ArrayList<ChiTietBangChamCong> getAllBangChamCongCongNhanTheoNgay(String ngayBD, String ngayKT) {
        ArrayList<ChiTietBangChamCong> dsCtCC = new ArrayList<ChiTietBangChamCong>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select soLuongHT, ct.maBangPC, ct.maBangChamCong from ChiTietBangChamCong ct join BangChamCongCongNhan cc\n"
                    + "on ct.maBangChamCong = cc.maBangChamCong\n"
                    + "where ngayChamCong between '" + ngayBD + "' and '" + ngayKT + "'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int sl = rs.getInt(1);
                String maBangPC = rs.getString(2);
                String maBangChamCong = rs.getString(3);
                BangPhanCong_DAO pcdao = new BangPhanCong_DAO();
                BangChamCongCongNhan_DAO ccdao = new BangChamCongCongNhan_DAO();
                BangPhanCong pc = pcdao.getBangPhanCongTheoMa(maBangPC);
                BangChamCongCongNhan ccCN = ccdao.getBangChamCongCongNhanTheoMa(maBangChamCong);

                ChiTietBangChamCong ctcc = new ChiTietBangChamCong(sl, pc, ccCN);
                dsCtCC.add(ctcc);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsCtCC;
    }

    public ArrayList<ChiTietBangChamCong> getAllBangChamCongCongNhanTheoNgayChamCong(String ngayCC) {
        ArrayList<ChiTietBangChamCong> dsCtCC = new ArrayList<ChiTietBangChamCong>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select soLuongHT, ct.maBangPC, ct.maBangChamCong from ChiTietBangChamCong ct join BangChamCongCongNhan cc\n"
                    + "on ct.maBangChamCong = cc.maBangChamCong\n"
                    + "where ngayChamCong = '" + ngayCC + "'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            int i = 1;
            while (rs.next()) {
                i++;
                int sl = rs.getInt(1);
                String maBangPC = rs.getString(2);
                String maBangChamCong = rs.getString(3);
                BangPhanCong_DAO pcdao = new BangPhanCong_DAO();
                BangChamCongCongNhan_DAO ccdao = new BangChamCongCongNhan_DAO();
                BangPhanCong pc = pcdao.getBangPhanCongTheoMa(maBangPC);
                BangChamCongCongNhan ccCN = ccdao.getBangChamCongCongNhanTheoMa(maBangChamCong);

                ChiTietBangChamCong ctcc = new ChiTietBangChamCong(sl, pc, ccCN);
                dsCtCC.add(ctcc);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsCtCC;
    }

    public BangChamCongCongNhan getBangChamCongCongNhanTheoMaVer2(String maBangChamCongCongNhan) {
        BangChamCongCongNhan bcc = new BangChamCongCongNhan();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM BangChamCongCongNhan where maBangChamCong = " + maBangChamCongCongNhan;
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maBangCC = rs.getString(1);
                LocalTime gioVao = rs.getTime(2).toLocalTime();
                LocalTime gioRa = rs.getTime(3).toLocalTime();
                LocalDateTime ngayChamCong = rs.getTimestamp(4).toLocalDateTime();
                String caLamViec = rs.getString(5);
                CongNhan_DAO cndao = new CongNhan_DAO();
                CongNhan cn = cndao.getCongNhanTheoMa(rs.getString(6));

                bcc = new BangChamCongCongNhan(maBangCC, gioVao, gioRa, ngayChamCong, caLamViec, cn);

            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return bcc;
    }
}
