/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.BangPhanCong;
import entity.CongDoan;
import entity.CongNhan;
import entity.SanPham;
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
public class BangPhanCong_DAO {

    public ArrayList<BangPhanCong> getAllBangPhanCong() {
        ArrayList<BangPhanCong> dsBangPhanCong = new ArrayList<BangPhanCong>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from BangPhanCong";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maBangPhanCong = rs.getString(1);
                int soLuong = rs.getInt(2);

                CongDoan_DAO cddao = new CongDoan_DAO();
                CongDoan cd = cddao.getCongDoanTheoMa(rs.getString(3));

                CongNhan_DAO cndao = new CongNhan_DAO();
                CongNhan cn = cndao.getCongNhanTheoMa(rs.getString(4));

                BangPhanCong bpc = new BangPhanCong(maBangPhanCong, soLuong, cd, cn);
                dsBangPhanCong.add(bpc);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsBangPhanCong;
    }

    public boolean createBangPhanCong(BangPhanCong bpc) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("insert into BangPhanCong values(?, ?, ?, ?)");
            stm.setString(1, bpc.getMaBangPC());
            stm.setInt(2, bpc.getSoLuong());
            stm.setString(3, bpc.getCongDoan().getMaCD());
            stm.setString(4, bpc.getCongNhan().getMaCN());
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

    public boolean updateBangPhanCong(BangPhanCong bpc) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("update BangPhanCong set soLuong = ?, maCD = ?, maCN = ? where maBangPC = ?");
            stm.setString(4, bpc.getMaBangPC());
            stm.setInt(1, bpc.getSoLuong());
            stm.setString(2, bpc.getCongDoan().getMaCD());
            stm.setString(3, bpc.getCongNhan().getMaCN());
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

    public BangPhanCong getBangPhanCongTheoMa(String maBangPhanCong) {
        ArrayList<BangPhanCong> dsSP = getAllBangPhanCong();
        for (BangPhanCong x : dsSP) {
            if (x.getMaBangPC().equalsIgnoreCase(maBangPhanCong)) {
                return x;
            }
        }
        return null;
    }

    public BangPhanCong getBangPhanCongTheoMaCNMaCD(String maCN, String maCD) {
        BangPhanCong bpc = new BangPhanCong();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from BangPhanCong\n"
                    + "where maCD =" + maCD + " and maCN = " + maCN;
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maBangPhanCong = rs.getString(1);
                bpc = getBangPhanCongTheoMa(maBangPhanCong);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return bpc;
    }

    public BangPhanCong getBangPhanCongMoiNhat() {
        BangPhanCong bpc = new BangPhanCong();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT TOP 1 * FROM BangPhanCong ORDER BY maBangPC DESC;";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maBangPhanCong = rs.getString(1);
                int soLuong = rs.getInt(2);

                CongDoan_DAO cddao = new CongDoan_DAO();
                CongDoan cd = cddao.getCongDoanTheoMa(rs.getString(3));

                CongNhan_DAO cndao = new CongNhan_DAO();
                CongNhan cn = cndao.getCongNhanTheoMa(rs.getString(4));

                bpc = new BangPhanCong(maBangPhanCong, soLuong, cd, cn);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return bpc;
    }

    public boolean xoaBangPhanCong(String maBangPC) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("delete BangPhanCong where maBangPC = ?");
            stm.setString(1, maBangPC);
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

    public int getTongSLHT(String maPC) {
        int bpc = 0;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select sum(soLuongHT)\n"
                    + "from ChiTietBangChamCong\n"
                    + "where maBangPC = " + maPC;
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                bpc = rs.getInt(1);

            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return bpc;
    }

    public BangPhanCong getBangPhanCongTheoMaBPC(String ma) {
        BangPhanCong bpc = new BangPhanCong();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from BangPhanCong\n"
                    + "where maBangPC = " + ma;
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maBangPhanCong = rs.getString(1);
                int soLuong = rs.getInt(2);

                CongDoan_DAO cddao = new CongDoan_DAO();
                CongDoan cd = cddao.getCongDoanTheoMaVer2(rs.getString(3));

                CongNhan_DAO cndao = new CongNhan_DAO();
                CongNhan cn = cndao.getCongNhanTheoMaVer2(rs.getString(4));

                bpc = new BangPhanCong(maBangPhanCong, soLuong, cd, cn);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return bpc;
    }

    public ArrayList<BangPhanCong> getAllBangPhanCongVer2() {
        ArrayList<BangPhanCong> dsBangPhanCong = new ArrayList<BangPhanCong>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from BangPhanCong";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maBangPhanCong = rs.getString(1);
                int soLuong = rs.getInt(2);

                CongDoan_DAO cddao = new CongDoan_DAO();
                CongDoan cd = cddao.getCongDoanTheoMaVer2(rs.getString(3));

                CongNhan_DAO cndao = new CongNhan_DAO();
                CongNhan cn = cndao.getCongNhanTheoMaVer2(rs.getString(4));

                BangPhanCong bpc = new BangPhanCong(maBangPhanCong, soLuong, cd, cn);
                dsBangPhanCong.add(bpc);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsBangPhanCong;
    }

    public ArrayList<BangPhanCong> getAllBangPhanCongTheoCD(String cdoan) {
        ArrayList<BangPhanCong> dsBangPhanCong = new ArrayList<BangPhanCong>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from BangPhanCong\n"
                    + "where maCD = " + cdoan;
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maBangPhanCong = rs.getString(1);
                int soLuong = rs.getInt(2);

                CongDoan_DAO cddao = new CongDoan_DAO();
                CongDoan cd = cddao.getCongDoanTheoMa(rs.getString(3));

                CongNhan_DAO cndao = new CongNhan_DAO();
                CongNhan cn = cndao.getCongNhanTheoMa(rs.getString(4));

                BangPhanCong bpc = new BangPhanCong(maBangPhanCong, soLuong, cd, cn);
                dsBangPhanCong.add(bpc);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsBangPhanCong;
    }

    public BangPhanCong getBangPCTheoMaCDMaCN(String maCD, String maCN) {
        BangPhanCong bpc = new BangPhanCong();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from BangPhanCong\n"
                    + "where maCD = " + maCD + "and maCN = " + maCN;
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maBangPhanCong = rs.getString(1);
                int soLuong = rs.getInt(2);
                CongDoan_DAO cddao = new CongDoan_DAO();
                CongDoan cd = cddao.getCongDoanTheoMaVer2(rs.getString(3));
                CongNhan_DAO cndao = new CongNhan_DAO();
                CongNhan cn = cndao.getCongNhanTheoMaVer2(rs.getString(4));

                bpc = new BangPhanCong(maBangPhanCong, soLuong, cd, cn);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return bpc;
    }

    public int getTongSLHTCuaCD(String maCD) {
        int bpc = 0;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select sum(ct.soLuongHT) from ChiTietBangChamCong ct join BangPhanCong pc\n"
                    + "on ct.maBangPC = pc.maBangPC \n"
                    + "where pc.maCD = " + maCD;
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                bpc = rs.getInt(1);

            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return bpc;
    }

    public int getSLConCuaCD(String maCD) {
        int bpc = 0;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select sum(soLuong) from BangPhanCong\n"
                    + "where maCD = " + maCD;
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                bpc = rs.getInt(1);

            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return bpc;
    }

    public ArrayList<BangPhanCong> getAllBangPhanCongTheoSP(String tenSP) {
        ArrayList<BangPhanCong> dsBangPhanCong = new ArrayList<BangPhanCong>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select maBangPC,pc.soLuong,pc.maCD,maCN from BangPhanCong pc join CongDoan cd\n"
                    + "on pc.maCD = cd.maCD join SanPham sp on cd.maSP = sp.maSP\n"
                    + "where sp.tenSP = N'" + tenSP + "'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maBangPhanCong = rs.getString(1);
                int soLuong = rs.getInt(2);

                CongDoan_DAO cddao = new CongDoan_DAO();
                CongDoan cd = cddao.getCongDoanTheoMa(rs.getString(3));

                CongNhan_DAO cndao = new CongNhan_DAO();
                CongNhan cn = cndao.getCongNhanTheoMa(rs.getString(4));

                BangPhanCong bpc = new BangPhanCong(maBangPhanCong, soLuong, cd, cn);
                dsBangPhanCong.add(bpc);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsBangPhanCong;
    }

    public ArrayList<BangPhanCong> getAllBangPhanCongTheoNgayBD(String ngayBD) {
        ArrayList<BangPhanCong> dsBangPhanCong = new ArrayList<BangPhanCong>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select maBangPC,pc.soLuong,pc.maCD,maCN from BangPhanCong pc join CongDoan cd\n"
                    + "on pc.maCD = cd.maCD\n"
                    + "where cd.ngayBatDau = '" + ngayBD + "'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maBangPhanCong = rs.getString(1);
                int soLuong = rs.getInt(2);

                CongDoan_DAO cddao = new CongDoan_DAO();
                CongDoan cd = cddao.getCongDoanTheoMa(rs.getString(3));

                CongNhan_DAO cndao = new CongNhan_DAO();
                CongNhan cn = cndao.getCongNhanTheoMa(rs.getString(4));

                BangPhanCong bpc = new BangPhanCong(maBangPhanCong, soLuong, cd, cn);
                dsBangPhanCong.add(bpc);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsBangPhanCong;
    }

    public ArrayList<BangPhanCong> getAllBangPhanCongChuaHT() {
        ArrayList<BangPhanCong> dsBangPhanCong = new ArrayList<BangPhanCong>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from BangPhanCong pc\n"
                    + "where (soLuong - (select sum(soLuongHT)\n"
                    + "                    from ChiTietBangChamCong\n"
                    + "                    where maBangPC = pc.maBangPC) )!=0";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maBangPhanCong = rs.getString(1);
                int soLuong = rs.getInt(2);

                CongDoan_DAO cddao = new CongDoan_DAO();
                CongDoan cd = cddao.getCongDoanTheoMa(rs.getString(3));

                CongNhan_DAO cndao = new CongNhan_DAO();
                CongNhan cn = cndao.getCongNhanTheoMa(rs.getString(4));

                BangPhanCong bpc = new BangPhanCong(maBangPhanCong, soLuong, cd, cn);
                dsBangPhanCong.add(bpc);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsBangPhanCong;
    }
}
