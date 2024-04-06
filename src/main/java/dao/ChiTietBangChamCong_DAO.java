/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.BangChamCongCongNhan;
import entity.BangPhanCong;
import entity.ChiTietBangChamCong;
import entity.CongDoan;
import entity.CongNhan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author vuhai
 */
public class ChiTietBangChamCong_DAO {

    public ArrayList<ChiTietBangChamCong> getAllChiTietBangChamCong() {
        ArrayList<ChiTietBangChamCong> dsChiTietBangChamCong = new ArrayList<ChiTietBangChamCong>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from ChiTietBangChamCong";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {

                int soLuongHT = rs.getInt(1);

                BangPhanCong_DAO bpcdao = new BangPhanCong_DAO();
                BangPhanCong bpc = bpcdao.getBangPhanCongTheoMa(rs.getString(2));

                BangChamCongCongNhan_DAO bccdao = new BangChamCongCongNhan_DAO();
                BangChamCongCongNhan bcc = bccdao.getBangChamCongCongNhanTheoMa(rs.getString(3));

                ChiTietBangChamCong ct = new ChiTietBangChamCong(soLuongHT, bpc, bcc);
                dsChiTietBangChamCong.add(ct);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsChiTietBangChamCong;
    }

    public boolean createChiTietBangChamCong(ChiTietBangChamCong bcc) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("insert into ChiTietBangChamCong values(?, ?, ?)");
            stm.setInt(1, bcc.getSoLuong());
            stm.setString(2, bcc.getBangPC().getMaBangPC());
            stm.setString(3, bcc.getBangCC().getMaBangChamCong());
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

    public boolean updateChiTietBangChamCong(ChiTietBangChamCong bcc) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("update ChiTietBangChamCong set soLuongHT = ? where maBangPC = ? and  maBangChamCong = ? ");
            stm.setInt(1, bcc.getSoLuong());
            stm.setString(2, bcc.getBangPC().getMaBangPC());
            stm.setString(3, bcc.getBangCC().getMaBangChamCong());
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


    public boolean xoaCTCC(String maPC, String maCC) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("delete ChiTietBangChamCong where maBangPC = ? and maBangChamCong = ?");
            stm.setString(1, maPC);
            stm.setString(2, maCC);
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

    public ArrayList<ChiTietBangChamCong> getAllChiTietBangChamCongVer2() {
        ArrayList<ChiTietBangChamCong> dsChiTietBangChamCong = new ArrayList<ChiTietBangChamCong>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from ChiTietBangChamCong";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {

                int soLuongHT = rs.getInt(1);

                BangPhanCong bpc = bpcdao.getBangPhanCongTheoMaBPC(rs.getString(2));

                BangChamCongCongNhan bcc = bccdao.getBangChamCongCongNhanTheoMaVer2(rs.getString(3));

                ChiTietBangChamCong ct = new ChiTietBangChamCong(soLuongHT, bpc, bcc);
                dsChiTietBangChamCong.add(ct);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsChiTietBangChamCong;
    }
    BangPhanCong_DAO bpcdao = new BangPhanCong_DAO();
    BangChamCongCongNhan_DAO bccdao = new BangChamCongCongNhan_DAO();
}
