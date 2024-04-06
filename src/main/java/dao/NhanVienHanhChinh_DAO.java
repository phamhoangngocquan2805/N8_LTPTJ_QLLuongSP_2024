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
import entity.NhanVienHanhChinh;
import entity.PhongBan;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author vuhai
 */
public class NhanVienHanhChinh_DAO {

    // lấy toàn bộ danh sách nhân viên từ cơ sở dữ liệu
    // return: danh sách nhân viên
    public ArrayList<NhanVienHanhChinh> getAllNhanVien() {
        ArrayList<NhanVienHanhChinh> dsNhanVien = new ArrayList<NhanVienHanhChinh>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from NhanVienHanhChinh";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maNV = rs.getString(1);
                String hoTen = rs.getString(2);
                boolean phai = rs.getBoolean(3);
                Date ngaySinh = rs.getDate(4);
                String soDT = rs.getString(5);
                String diaChi = rs.getString(6);
                boolean tinhTrang = rs.getBoolean(7);
                Date ngayVaoLam = rs.getDate(8);
                String hinhAnh = rs.getString(9);
                double heSoLuong = rs.getFloat(10);
                double luognCoBan = rs.getFloat(11);
                String chucVu = rs.getString(12);
                String email = rs.getString(13);
                double tienPhuCapTheoNgay = rs.getFloat(14);
                double tienChuyenCan = rs.getFloat(15);
                String ghiChu = rs.getString(16);
                PhongBan_DAO pbdao = new PhongBan_DAO();
                PhongBan phongBan = pbdao.getPhongBanTheoMa(rs.getString(17));
                NhanVienHanhChinh nv = new NhanVienHanhChinh(maNV, hoTen, phai, ngaySinh, soDT, diaChi, tinhTrang, ngayVaoLam, hinhAnh, heSoLuong, luognCoBan, chucVu, email, tienPhuCapTheoNgay, tienChuyenCan, ghiChu, phongBan);
                dsNhanVien.add(nv);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsNhanVien;
    }

    /**
     *
     * @param Nhập tên nhân viên
     * @return danh sách nhân viên theo tên được nhập
     */
    public ArrayList<NhanVienHanhChinh> getNhanVienByTenNV(String info) {
        ArrayList<NhanVienHanhChinh> nhanVien = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        String sql = "select * from NhanVienHanhChinh where hoTen like N'%" + info + "%'";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                NhanVienHanhChinh nv = new NhanVienHanhChinh();
                nv.setMaNV(rs.getString(1));
                nv.setHoTen(rs.getString(2));
                nv.setPhai(rs.getBoolean(3));
                nv.setNgaySinh(rs.getDate(4));
                nv.setSoDT(rs.getString(5));
                nv.setDiaChi(rs.getString(6));
                nv.setTinhTrang(rs.getBoolean(7));
                nv.setNgayVaoLam(rs.getDate(8));
                nv.setHinhAnh(rs.getString(9));
                nv.setHeSoLuong(rs.getDouble(10));
                nv.setLuongCoBan(rs.getDouble(11));
                nv.setChucVu(rs.getString(12));
                nv.setEmail(rs.getString(13));
                nv.setTienPhuCapTheoNgay(rs.getDouble(14));
                nv.setTienChuyenCan(rs.getDouble(15));
                nv.setGhiChu(rs.getString(16));
                nv.setPhongBan(new PhongBan_DAO().getPhongBanTheoMa(rs.getString(17)));
                nhanVien.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanVien;
    }

    // return nhân viên theo mã nhân viên
    public ArrayList<NhanVienHanhChinh> getNhanVienByMaNV(String maNV) {
        ArrayList<NhanVienHanhChinh> nhanVien = new ArrayList<NhanVienHanhChinh>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from NhanVienHanhChinh where maNV = ?";
            PreparedStatement preStmt = con.prepareStatement(sql);
            preStmt.setString(1, maNV);
            ResultSet rs = preStmt.executeQuery();
            while (rs.next()) {
                String maNVHC = rs.getString(1);
                String hoTen = rs.getString(2);
                Boolean phai = rs.getBoolean(3);
                Date ngaySinh = rs.getDate(4);
                String soDT = rs.getString(5);
                String diaChi = rs.getString(6);
                Boolean tinhTrang = rs.getBoolean(7);
                Date ngayVaoLam = rs.getDate(8);
                String hinhAnh = rs.getString(9);
                double heSoLuong = rs.getFloat(10);
                double luognCoBan = rs.getFloat(11);
                String chucVu = rs.getString(12);
                String email = rs.getString(13);
                double tienPhuCapTheoNgay = rs.getFloat(14);
                double tienChuyenCan = rs.getFloat(15);
                String ghiChu = rs.getString(16);
                PhongBan_DAO pbdao = new PhongBan_DAO();
                PhongBan phongBan = pbdao.getPhongBanTheoMa(rs.getString(17));
                NhanVienHanhChinh nv = new NhanVienHanhChinh(maNVHC, hoTen, phai, ngaySinh, soDT, diaChi, tinhTrang, ngayVaoLam, hinhAnh, heSoLuong, luognCoBan, chucVu, email, tienPhuCapTheoNgay, tienChuyenCan, ghiChu, phongBan);
                nhanVien.add(nv);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return nhanVien;
    }

    /**
     *
     * @param info là số điện thoại hoặc mã nhân viên
     * @return danh sách thông tin các nhân viên trùng với số điện thoại hoặc mã
     */
    public ArrayList<NhanVienHanhChinh> getMaVaSDTNhanVien(String info) {
        ArrayList<NhanVienHanhChinh> nhanVien = new ArrayList<NhanVienHanhChinh>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        String sqlMaNV = "select * from nhanVienHanhChinh where maNV = '" + info + "'";
        String sqlSDTNV = "select * from NhanVienHanhChinh where soDT = '" + info + "'";
        try {
            Statement stm = con.createStatement();
            ResultSet rsMa = stm.executeQuery(sqlMaNV);
            while (rsMa.next()) {
                NhanVienHanhChinh nv = new NhanVienHanhChinh();
                nv.setMaNV(rsMa.getString(1));
                nv.setHoTen(rsMa.getString(2));
                nv.setPhai(rsMa.getBoolean(3));
                nv.setNgaySinh(rsMa.getDate(4));
                nv.setSoDT(rsMa.getString(5));
                nv.setDiaChi(rsMa.getString(6));
                nv.setTinhTrang(rsMa.getBoolean(7));
                nv.setNgayVaoLam(rsMa.getDate(8));
                nv.setHinhAnh(rsMa.getString(9));
                nv.setHeSoLuong(rsMa.getDouble(10));
                nv.setLuongCoBan(rsMa.getDouble(11));
                nv.setChucVu(rsMa.getString(12));
                nv.setEmail(rsMa.getString(13));
                nv.setTienPhuCapTheoNgay(rsMa.getDouble(14));
                nv.setTienChuyenCan(rsMa.getDouble(15));
                nv.setGhiChu(rsMa.getString(16));
                nv.setPhongBan(new PhongBan_DAO().getPhongBanTheoMa(rsMa.getString(17)));
                nhanVien.add(nv);
            }

            ResultSet rsSDT = stm.executeQuery(sqlSDTNV);
            while (rsSDT.next()) {
                NhanVienHanhChinh nv = new NhanVienHanhChinh();
                nv.setMaNV(rsSDT.getString(1));
                nv.setHoTen(rsSDT.getString(2));
                nv.setPhai(rsSDT.getBoolean(3));
                nv.setNgaySinh(rsSDT.getDate(4));
                nv.setSoDT(rsSDT.getString(5));
                nv.setDiaChi(rsSDT.getString(6));
                nv.setTinhTrang(rsSDT.getBoolean(7));
                nv.setNgayVaoLam(rsSDT.getDate(8));
                nv.setHinhAnh(rsSDT.getString(9));
                nv.setHeSoLuong(rsSDT.getDouble(10));
                nv.setLuongCoBan(rsSDT.getDouble(11));
                nv.setChucVu(rsSDT.getString(12));
                nv.setEmail(rsSDT.getString(13));
                nv.setTienPhuCapTheoNgay(rsSDT.getDouble(14));
                nv.setTienChuyenCan(rsSDT.getDouble(15));
                nv.setGhiChu(rsSDT.getString(16));
                nv.setPhongBan(new PhongBan_DAO().getPhongBanTheoMa(rsSDT.getString(17)));
                nhanVien.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanVien;
    }

    // Thêm nhân viên vào cơ sở dữ liệu
    public boolean createNhanVien(NhanVienHanhChinh nv) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("insert into NhanVienHanhChinh values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stm.setString(1, nv.getMaNV());
            stm.setString(2, nv.getHoTen());
            stm.setBoolean(3, nv.isPhai());
            stm.setDate(4, nv.getNgaySinh());
            stm.setString(5, nv.getSoDT());
            stm.setString(6, nv.getDiaChi());
            stm.setBoolean(7, nv.isTinhTrang());
            stm.setDate(8, nv.getNgayVaoLam());
            stm.setString(9, nv.getHinhAnh());
            stm.setFloat(10, (float) nv.getHeSoLuong());
            stm.setFloat(11, (float) nv.getLuongCoBan());
            stm.setString(12, nv.getChucVu());
            stm.setString(13, nv.getEmail());
            stm.setFloat(14, (float) nv.getTienPhuCapTheoNgay());
            stm.setFloat(15, (float) nv.getTienChuyenCan());
            stm.setString(16, nv.getGhiChu());
            stm.setString(17, nv.getPhongBan().getMaPB());
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

    // Cập nhật thông tin nhân viên
    public boolean updateNhanVien(NhanVienHanhChinh nv) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stm = null;
        int n = 0;
        try {
            stm = con.prepareStatement("update NhanVienHanhChinh set hoTen = ?, phai = ?, ngaySinh = ?, soDT = ?, diaChi = ?, tinhTrang = ?, ngayVaoLam = ?, hinhAnh = ?, heSoLuong = ?, luongCoBan = ?, chucVu = ?, email = ?, tienPhuCapTheoNgay = ?, tienChuyenCan = ?, ghiChu = ?, maPB = ?  where maNV = ?");
            stm.setString(17, nv.getMaNV());
            stm.setString(1, nv.getHoTen());
            stm.setBoolean(2, nv.isPhai());
            stm.setDate(3, nv.getNgaySinh());
            stm.setString(4, nv.getSoDT());
            stm.setString(5, nv.getDiaChi());
            stm.setBoolean(6, nv.isTinhTrang());
            stm.setDate(7, nv.getNgayVaoLam());
            stm.setString(8, nv.getHinhAnh());
            stm.setFloat(9, (float) nv.getHeSoLuong());
            stm.setFloat(10, (float) nv.getLuongCoBan());
            stm.setString(11, nv.getChucVu());
            stm.setString(12, nv.getEmail());
            stm.setFloat(13, (float) nv.getTienPhuCapTheoNgay());
            stm.setFloat(14, (float) nv.getTienChuyenCan());
            stm.setString(15, nv.getGhiChu());
            stm.setString(16, nv.getPhongBan().getMaPB());
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
    public String getMaNV() {
        String maNV = "";
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select CONCAT(CONCAT(RIGHT(YEAR(getdate()),2),1), RIGHT(CONCAT('000',ISNULL(right(max(maNV),3),0) + 1),3)) from [dbo].[NhanVienHanhChinh] where maNV like '__1%'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                maNV = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maNV;
    }

    /**
     *
     * @param sdt can kiem tra
     * @return true nếu không có và return false nếu có thôgn tin nhân viên theo
     * số điện thoại
     */
    public boolean checkSdtNV(String soDT) {
        NhanVienHanhChinh nv = new NhanVienHanhChinh();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("select * from NhanVienHanhChinh where soDT = '" + soDT + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nv.setMaNV(rs.getString(1));
                nv.setHoTen(rs.getString(2));
                nv.setPhai(rs.getBoolean(3));
                nv.setNgaySinh(rs.getDate(4));
                nv.setSoDT(rs.getString(5));
                nv.setDiaChi(rs.getString(6));
                nv.setTinhTrang(rs.getBoolean(7));
                nv.setNgayVaoLam(rs.getDate(8));
                nv.setHinhAnh(rs.getString(9));
                nv.setHeSoLuong(rs.getDouble(10));
                nv.setLuongCoBan(rs.getDouble(11));
                nv.setChucVu(rs.getString(12));
                nv.setEmail(rs.getString(13));
                nv.setTienPhuCapTheoNgay(rs.getDouble(14));
                nv.setTienChuyenCan(rs.getDouble(15));
                nv.setGhiChu(rs.getString(16));
                nv.setPhongBan(new PhongBan(rs.getString(17)));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // return nhân viên theo phòng ban
    public ArrayList<NhanVienHanhChinh> getNhanVienByTenPB(String tenPB, boolean tinhTrangg) {
        ArrayList<NhanVienHanhChinh> nhanVien = new ArrayList<NhanVienHanhChinh>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from NhanVienHanhChinh where maPB = (select maPB from PhongBan where tenPB = N'" + tenPB + "') AND tinhTrang = '" + tinhTrangg + "'";
            PreparedStatement preStmt = con.prepareStatement(sql);

            ResultSet rs = preStmt.executeQuery();
            while (rs.next()) {
                String maNVHC = rs.getString(1);
                String hoTen = rs.getString(2);
                Boolean phai = rs.getBoolean(3);
                Date ngaySinh = rs.getDate(4);
                String soDT = rs.getString(5);
                String diaChi = rs.getString(6);
                Boolean tinhTrang = rs.getBoolean(7);
                Date ngayVaoLam = rs.getDate(8);
                String hinhAnh = rs.getString(9);
                double heSoLuong = rs.getFloat(10);
                double luognCoBan = rs.getFloat(11);
                String chucVu = rs.getString(12);
                String email = rs.getString(13);
                double tienPhuCapTheoNgay = rs.getFloat(14);
                double tienChuyenCan = rs.getFloat(15);
                String ghiChu = rs.getString(16);
                PhongBan_DAO pbdao = new PhongBan_DAO();
                PhongBan phongBan = pbdao.getPhongBanTheoMa(rs.getString(17));
                NhanVienHanhChinh nv = new NhanVienHanhChinh(maNVHC, hoTen, phai, ngaySinh, soDT, diaChi, tinhTrang, ngayVaoLam, hinhAnh, heSoLuong, luognCoBan, chucVu, email, tienPhuCapTheoNgay, tienChuyenCan, ghiChu, phongBan);
                nhanVien.add(nv);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return nhanVien;
    }

    // return nhân viên theo chức vụ
    public ArrayList<NhanVienHanhChinh> getNhanVienByChucVu(String chucVu, boolean tinhTrangg) {
        ArrayList<NhanVienHanhChinh> nhanVien = new ArrayList<NhanVienHanhChinh>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from NhanVienHanhChinh where chucVu = N'" + chucVu + "' AND tinhTrang = '" + tinhTrangg +"'";
            PreparedStatement preStmt = con.prepareStatement(sql);

            ResultSet rs = preStmt.executeQuery();
            while (rs.next()) {
                String maNVHC = rs.getString(1);
                String hoTen = rs.getString(2);
                Boolean phai = rs.getBoolean(3);
                Date ngaySinh = rs.getDate(4);
                String soDT = rs.getString(5);
                String diaChi = rs.getString(6);
                Boolean tinhTrang = rs.getBoolean(7);
                Date ngayVaoLam = rs.getDate(8);
                String hinhAnh = rs.getString(9);
                double heSoLuong = rs.getFloat(10);
                double luognCoBan = rs.getFloat(11);
                String chucVuu = rs.getString(12);
                String email = rs.getString(13);
                double tienPhuCapTheoNgay = rs.getFloat(14);
                double tienChuyenCan = rs.getFloat(15);
                String ghiChu = rs.getString(16);
                PhongBan_DAO pbdao = new PhongBan_DAO();
                PhongBan phongBan = pbdao.getPhongBanTheoMa(rs.getString(17));
                NhanVienHanhChinh nv = new NhanVienHanhChinh(maNVHC, hoTen, phai, ngaySinh, soDT, diaChi, tinhTrang, ngayVaoLam, hinhAnh, heSoLuong, luognCoBan, chucVuu, email, tienPhuCapTheoNgay, tienChuyenCan, ghiChu, phongBan);
                nhanVien.add(nv);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return nhanVien;
    }
    
     // return nhân viên theo tình trạng
    public ArrayList<NhanVienHanhChinh> getNhanVienByTinhTrang(boolean tTrang) {
        ArrayList<NhanVienHanhChinh> nhanVien = new ArrayList<NhanVienHanhChinh>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from NhanVienHanhChinh where tinhTrang = '" + tTrang + "'";
            PreparedStatement preStmt = con.prepareStatement(sql);

            ResultSet rs = preStmt.executeQuery();
            while (rs.next()) {
                String maNVHC = rs.getString(1);
                String hoTen = rs.getString(2);
                Boolean phai = rs.getBoolean(3);
                Date ngaySinh = rs.getDate(4);
                String soDT = rs.getString(5);
                String diaChi = rs.getString(6);
                Boolean tinhTrang = rs.getBoolean(7);
                Date ngayVaoLam = rs.getDate(8);
                String hinhAnh = rs.getString(9);
                double heSoLuong = rs.getFloat(10);
                double luognCoBan = rs.getFloat(11);
                String chucVu = rs.getString(12);
                String email = rs.getString(13);
                double tienPhuCapTheoNgay = rs.getFloat(14);
                double tienChuyenCan = rs.getFloat(15);
                String ghiChu = rs.getString(16);
                PhongBan_DAO pbdao = new PhongBan_DAO();
                PhongBan phongBan = pbdao.getPhongBanTheoMa(rs.getString(17));
                NhanVienHanhChinh nv = new NhanVienHanhChinh(maNVHC, hoTen, phai, ngaySinh, soDT, diaChi, tinhTrang, ngayVaoLam, hinhAnh, heSoLuong, luognCoBan, chucVu, email, tienPhuCapTheoNgay, tienChuyenCan, ghiChu, phongBan);
                nhanVien.add(nv);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return nhanVien;
    }
    
    /**
	 * 
	 * @param tên nhân viên được nhập
	 * @return mã nhân viên
	 */
	
	public String getMaNVTheoTenNV(String tenNV) {
		String maNV ="";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select maNV from NhanVienHanhChinh where hoTen = N'"+ tenNV +"'";
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				
				maNV = rs.getString(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return maNV;
		
	}

    public NhanVienHanhChinh getNhanVienTheoMa(String maNV) {
        ArrayList<NhanVienHanhChinh> dsNV = getAllNhanVien();
        for (NhanVienHanhChinh x : dsNV) {
            if (x.getMaNV().equalsIgnoreCase(maNV)) {
                return x;
            }
        }
        return null;
    }

    // kiểm tra dữ liệu nhập vào của nhân viên
    public boolean validDataNhanVien(JTextField txtHoTen, JTextField txtSDT, JTextField txtDiaChi, JTextField txtEmail, JComboBox cbxPhongBan, JComboBox cbxChucVu) {
        String hoTen = txtHoTen.getText().trim();
        String soDT = txtSDT.getText().trim();
        String diaChi = txtDiaChi.getText().trim();
        String email = txtEmail.getText().trim();
        
        if (cbxPhongBan.getSelectedItem().toString().equals("Chọn phòng ban")) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng ban!!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            cbxPhongBan.requestFocus();
            return false;
        }
        if (cbxPhongBan.getSelectedItem().toString().equals("Chọn chức vụ")) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn chức vụ!!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            cbxPhongBan.requestFocus();
            return false;
        }
        if (!(hoTen.length()>0)) {
            JOptionPane.showMessageDialog(null, "Họ tên không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            txtHoTen.requestFocus();
            return false;
        }
        if (!(soDT.length()>0)) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            txtSDT.requestFocus();
            return false;
        }
        if (!(diaChi.length()>0)) {
            JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            txtDiaChi.requestFocus();
            return false;
        }
        if (!(email.length()>0)) {
            JOptionPane.showMessageDialog(null, "Email không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            txtEmail.requestFocus();
            return false;
        }

        if (!hoTen.matches("^([ A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]*(\\s?))+$")) {
            JOptionPane.showMessageDialog(null, "Họ tên không hợp lệ \nVui lòng nhập họ tên theo mẫu: Lê Văn A", "Thông báo", JOptionPane.ERROR_MESSAGE);
            txtHoTen.requestFocus();
            return false;
        }

        if (!soDT.matches("^(03|08|09|07|05)[0-9]{8}$")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ \nSDT gồm 10 chữ số, bắt đầu bằng 2 chữ số: 03, 08, 07, 09, 05", "Thông báo", JOptionPane.ERROR_MESSAGE);
            txtSDT.requestFocus();
            return false;
        }

        if (!diaChi.matches("^([ A-Za-z0-9,\\/.a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]*(\\s?))+$")) {
            JOptionPane.showMessageDialog(null, "Địa chỉ không hợp lệ \nVui lòng nhập địa chỉ theo mẫu: 1428 Huỳnh Tấn Phát, Phú Mỹ, Quận 7", "Thông báo", JOptionPane.ERROR_MESSAGE);
            txtDiaChi.requestFocus();
            return false;
        }

        if (!email.matches("^[a-zA-Z0-9_.]+@[a-z]{3,15}(\\.com)$")) {
            JOptionPane.showMessageDialog(null, "Email không hợp lệ \nVui lòng nhập email theo mẫu: nguyenvana123@example.com", "Thông báo", JOptionPane.ERROR_MESSAGE);
            txtSDT.requestFocus();
            return false;
        }

        return true;
    }

    // kiểm tra thông tin nhân viên khi nhập vào ô tìm kiếm
    public boolean regexTimNV(JTextField txtTimNV) {
        String input = txtTimNV.getText().trim().toUpperCase();
        String regexMaNV = "([0-9]{2}(1)[0-9]{3})|";
        String regexTenNV = "([ A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+)|";
        String regexSDT = "((03|08|09|07|05)[0-9]{8})";
        String regexNhanVien = "^(" + regexMaNV + regexTenNV + regexSDT + ")$";
        if (!input.matches(regexNhanVien)) {
            JOptionPane.showMessageDialog(null,
                    "Thông tin tìm kiếm không hợp lệ hoặc nhân viên không tồn tại!\nThông tin có thể tìm kiếm:"
                    + "\n - Mã nhân viên gồm 6 chữ số. Ví dụ: 231001"
                    + "\n - Tên nhân viên. Ví dụ: Phạm Hoàng Ngọc Quân hoặc Quân"
                    + "\n - SĐT gồm 10 chữ số và bắt đầu bằng 2 chữ số: 03, 08, 09, 07, 05",
                    "Thông báo", JOptionPane.ERROR_MESSAGE);
            txtTimNV.requestFocus();
            txtTimNV.selectAll();
            return false;
        }
        return true;
    }
    
    public NhanVienHanhChinh getNhanVienTheoMaVer2(String maNv) {
        NhanVienHanhChinh nv = null;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from NhanVienHanhChinh where maNV = " + maNv;
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maNV = rs.getString(1);
                String hoTen = rs.getString(2);
                boolean phai = rs.getBoolean(3);
                Date ngaySinh = rs.getDate(4);
                String soDT = rs.getString(5);
                String diaChi = rs.getString(6);
                boolean tinhTrang = rs.getBoolean(7);
                Date ngayVaoLam = rs.getDate(8);
                String hinhAnh = rs.getString(9);
                double heSoLuong = rs.getFloat(10);
                double luognCoBan = rs.getFloat(11);
                String chucVu = rs.getString(12);
                String email = rs.getString(13);
                double tienPhuCapTheoNgay = rs.getFloat(14);
                double tienChuyenCan = rs.getFloat(15);
                String ghiChu = rs.getString(16);
                PhongBan_DAO pbdao = new PhongBan_DAO();
                PhongBan phongBan = pbdao.getPhongBanTheoMa(rs.getString(17));
                nv = new NhanVienHanhChinh(maNV, hoTen, phai, ngaySinh, soDT, diaChi, tinhTrang, ngayVaoLam, hinhAnh, heSoLuong, luognCoBan, chucVu, email, tienPhuCapTheoNgay, tienChuyenCan, ghiChu, phongBan);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return nv;
    }
}
