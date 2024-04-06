/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import static connectDB.ConnectDB.getConnection;
import entity.HopDong;
import entity.HopDong;
import entity.NhanVienHanhChinh;
import entity.PhongBan;
import entity.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Ngọc Quân
 */
public class HopDong_DAO {

    public ArrayList<HopDong> getAllHopDong() {
        ArrayList<HopDong> dsHopDong = new ArrayList<HopDong>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from HopDong";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString(1);
                String tenHD = rs.getString(2);
                Date ngayKiHD = rs.getDate(3);
                Date ngayBanGiao = rs.getDate(4);
                String ghiChu = rs.getString(5);
                int trangThai = rs.getInt(6);
                NhanVienHanhChinh_DAO nvdao = new NhanVienHanhChinh_DAO();
                NhanVienHanhChinh nv = nvdao.getNhanVienTheoMa(rs.getString(7));
                HopDong hd = new HopDong(maHD, tenHD, ngayKiHD, ngayBanGiao, ghiChu, trangThai, nv);
                dsHopDong.add(hd);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsHopDong;
    }

    public boolean createHopDong(HopDong hd) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("insert into HopDong values(?, ?, ?, ?, ?, ?, ?)");
            stm.setString(1, hd.getMaHD());
            stm.setString(2, hd.getTenHD());
            stm.setDate(3, hd.getNgayKiHD());
            stm.setDate(4, hd.getNgayBanGiao());
            stm.setString(5, hd.getGhiChu());
            stm.setInt(6, hd.getTrangThai());
            stm.setString(7, hd.getNv().getMaNV());
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

    public boolean updateHopDong(HopDong hd) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("update HopDong set tenHD = ?, ngayKiHD = ?, ngayBanGiao = ?, ghiChu = ?, trangThai = ?, maNV = ? where maHD = ?");
            stm.setString(7, hd.getMaHD());
            stm.setString(1, hd.getTenHD());
            stm.setDate(2, hd.getNgayKiHD());
            stm.setDate(3, hd.getNgayBanGiao());
            stm.setString(4, hd.getGhiChu());
            stm.setInt(5, hd.getTrangThai());
            stm.setString(6, hd.getNv().getMaNV());
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

    // Tự động phát sinh mã nhân viên
    public String getMaHD() {
        String maHD = "";
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select CONCAT(CONCAT(RIGHT(YEAR(getdate()),2),3), RIGHT(CONCAT('000',ISNULL(right(max(maHD),3),0) + 1),3)) from [dbo].[HopDong] where maHD like '__3%'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                maHD = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maHD;
    }

    // return hợp đồng theo mã hợp đồng
    public ArrayList<HopDong> getHopDongByMaHD(String maHD) {
        ArrayList<HopDong> hopDong = new ArrayList<HopDong>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from HopDong where maHD = ?";
            PreparedStatement preStmt = con.prepareStatement(sql);
            preStmt.setString(1, maHD);
            ResultSet rs = preStmt.executeQuery();
            while (rs.next()) {
                String maHDD = rs.getString(1);
                String tenHD = rs.getString(2);
                Date ngayKiHD = rs.getDate(3);
                Date ngayBanGiao = rs.getDate(4);
                String ghiChu = rs.getString(5);
                int trangThai = rs.getInt(6);
                NhanVienHanhChinh_DAO nvdao = new NhanVienHanhChinh_DAO();
                NhanVienHanhChinh nv = nvdao.getNhanVienTheoMa(rs.getString(7));
                HopDong hd = new HopDong(maHDD, tenHD, ngayKiHD, ngayBanGiao, ghiChu, trangThai, nv);
                hopDong.add(hd);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return hopDong;
    }

//    lấy danh sách hợp đồng từ tên hợp đồng
    public ArrayList<HopDong> getHopDongByTenHD(String info) {
        ArrayList<HopDong> hopDong = new ArrayList<HopDong>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        String sql = "select * from HopDong where tenHD like N'%" + info + "%'";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                HopDong hd = new HopDong();
                hd.setMaHD(rs.getString(1));
                hd.setTenHD(rs.getString(2));
                hd.setNgayKiHD(rs.getDate(3));
                hd.setNgayBanGiao(rs.getDate(4));
                hd.setGhiChu(rs.getString(5));
                hd.setTrangThai(rs.getInt(6));
                hd.setNv(new NhanVienHanhChinh_DAO().getNhanVienTheoMa(rs.getString(7)));
                hopDong.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hopDong;
    }

//    lấy hợp đồng theo trạng thái
    public ArrayList<HopDong> getHopDongByTrangThai(int trangThai) {
        ArrayList<HopDong> hopDong = new ArrayList<HopDong>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        String sql = "select * from HopDong where trangThai =" + trangThai;
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                HopDong hd = new HopDong();
                hd.setMaHD(rs.getString(1));
                hd.setTenHD(rs.getString(2));
                hd.setNgayKiHD(rs.getDate(3));
                hd.setNgayBanGiao(rs.getDate(4));
                hd.setGhiChu(rs.getString(5));
                hd.setTrangThai(rs.getInt(6));
                hd.setNv(new NhanVienHanhChinh_DAO().getNhanVienTheoMa(rs.getString(7)));
                hopDong.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hopDong;
    }

    public HopDong getHopDongTheoMa(String maHD) {
        ArrayList<HopDong> dsHD = getAllHopDong();
        for (HopDong x : dsHD) {
            if (x.getMaHD().equalsIgnoreCase(maHD)) {
                return x;
            }
        }
        return null;
    }

//    kiểm tra dữ liệu hợp lệ khi thêm và cập nhật hợp đồng.
    public boolean validDataHopDong(JTextField txtTenHD) {
        String tenHD = txtTenHD.getText().trim();

        if (!(tenHD.length() > 0 && tenHD.matches("^([ A-Za-z0-9,\\/.a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]*(\\s?))+$"))) {
            JOptionPane.showMessageDialog(null, "Tên hợp đồng không hợp lệ\nVui lòng kiểm tra lại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            txtTenHD.requestFocus();
            txtTenHD.selectAll();
            return false;
        }
        return true;
    }

    public boolean regexTimHD(JTextField txtTimHD) {
        String input = txtTimHD.getText().toUpperCase();
        String regexMaHD = "([0-9]{2}(3)[0-9]{3})|";
        String regexTenHD = "([ A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+)";
        String regexHopDong = "^(" + regexMaHD + regexTenHD + ")$";
        if (!input.matches(regexHopDong)) {
            JOptionPane.showMessageDialog(null,
                    "Thông tin tìm kiếm không hợp lệ hoặc hợp đồng không tồn tại\nThông tin hợp đồng có thể tìm kiếm:"
                    + "\n Mã hợp đồng gồm 6 chữ số. Ví dụ: 233001"
                    + "\n Tên hợp đồng: có dấu và viết hoa chữ cái đầu tiên. VD: Hợp đồng số 1.",
                    "Thông báo", JOptionPane.ERROR_MESSAGE);
            txtTimHD.requestFocus();
            txtTimHD.selectAll();
            return false;
        }
        return true;
    }

    
}
