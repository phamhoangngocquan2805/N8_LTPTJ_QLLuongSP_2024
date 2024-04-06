/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xuli;

import entity.NhanVienHanhChinh;
import gui.GDBaoCaoThongKe;
import gui.GDChinh;
import gui.GDLogin;
import gui.GDPhanCong;
import gui.GDQLCongDoan;
import gui.GDQLHopDong;
import gui.GDQLSanPham;
import gui.GDQLTaiKhoan;
import gui.GDTongQuan;
import gui.GDTroGiup;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import others.BienMacDinh;
import static others.BienMacDinh.mauBorderBottomMenu;
import static others.BienMacDinh.mauDanhMucDangChon;
import static others.BienMacDinh.mauDen;
import static others.BienMacDinh.mauNenMenu;
import static others.BienMacDinh.mauTrang;

/**
 *
 * @author acer
 */
public class ChuyenManHinh implements BienMacDinh {

    public static JPanel pChinh;
    public GDChinh gdChinh;
    private String danhMucDangChon = "";
    private List<DanhMucBean> listDanhMucBean = null;
    private NhanVienHanhChinh nvLog;
    private ArrayList<String> phanQuyenManHinh;
    public ArrayList<JPanel> ds;

    public ChuyenManHinh(JPanel pChinh, NhanVienHanhChinh nvLog, ArrayList<JPanel> ds, GDChinh gdChinh) {
        this.pChinh = pChinh;
        this.nvLog = nvLog;
        this.ds = ds;
        this.gdChinh = gdChinh;
        phanQuyenManHinh = new ArrayList<>();
        if (nvLog.getPhongBan().getMaPB().equals("231")) {
            phanQuyenManHinh.add("TrangChu");
            phanQuyenManHinh.add("QLNhanSu");
            phanQuyenManHinh.add("QLChamCong");
            phanQuyenManHinh.add("TroGiup");
            phanQuyenManHinh.add("DangXuat");
            if (!nvLog.getChucVu().equals("Nhân viên")) {
                phanQuyenManHinh.add("QLTaiKhoan");
            }
        } else if (nvLog.getPhongBan().getMaPB().equals("232")) {
            phanQuyenManHinh.add("TrangChu");
            phanQuyenManHinh.add("QLLuong");
            phanQuyenManHinh.add("BaoCaoThongKe");
            phanQuyenManHinh.add("TroGiup");
            phanQuyenManHinh.add("DangXuat");
        } else {
            phanQuyenManHinh.add("TrangChu");
            phanQuyenManHinh.add("QLHopDong");
            phanQuyenManHinh.add("QLSanPham");
            phanQuyenManHinh.add("QLCongDoan");
            phanQuyenManHinh.add("PhanCong");
            phanQuyenManHinh.add("QLChamCong");
            phanQuyenManHinh.add("TroGiup");
            phanQuyenManHinh.add("DangXuat");
        }
    }

    public void setManHinhNoiDung(JPanel pDanhMucDangChon, JLabel lblDanhMucDangChon) throws SQLException {
        danhMucDangChon = "TrangChu";
        pDanhMucDangChon.setBackground(mauDanhMucDangChon);
        lblDanhMucDangChon.setBackground(mauDanhMucDangChon);
        lblDanhMucDangChon.setForeground(mauTrang);

        //load lại giao diện
        pChinh.removeAll();
        pChinh.setLayout(new BorderLayout());
        pChinh.add(new GDTongQuan());
        pChinh.validate();
        pChinh.repaint();
    }

    public void setSuKienClickDanhMuc(List<DanhMucBean> listDanhMucBean) {
        this.listDanhMucBean = listDanhMucBean;
        for (DanhMucBean item : listDanhMucBean) {
            item.getLbl().addMouseListener(new customSuKienMouseListener(item.getLoaiDanhMuc(), item.getPanel(), item.getLbl()));
        }
    }

    public class customSuKienMouseListener implements MouseListener {

        // pNoiDung dùng để set lại panel nội dung ở bên phải
        private JPanel pNoiDung;

        //3 thành phần tạo nên danh mục trong panel menu
        private String loaiDanhMuc;
        private JPanel panel;
        private JLabel lbl;

        public customSuKienMouseListener(String loaiDanhMuc, JPanel panel, JLabel lbl) {
            this.loaiDanhMuc = loaiDanhMuc;
            this.panel = panel;
            this.lbl = lbl;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            danhMucDangChon = loaiDanhMuc;
            switch (loaiDanhMuc) {
                case "TrangChu": {
                    pNoiDung = new GDTongQuan();
                }
                break;

                case "QLNhanSu": {
                    if (nvLog.getPhongBan().getMaPB().equals("231")) {
                        pNoiDung = new AbstractColorChooserPanel() {
                            @Override
                            public void updateChooser() {
                                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                            }

                            @Override
                            protected void buildChooser() {
                                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                            }

                            @Override
                            public String getDisplayName() {
                                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                            }

                            @Override
                            public Icon getSmallDisplayIcon() {
                                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                            }

                            @Override
                            public Icon getLargeDisplayIcon() {
                                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                            }
                        };
                    }
                }
                break;

                case "QLHopDong": {
                    if (nvLog.getPhongBan().getMaPB().equals("233")) {
                        pNoiDung = new GDQLHopDong();
                    }
                }
                break;

                case "QLSanPham": {
                    if (nvLog.getPhongBan().getMaPB().equals("233")) {
                        pNoiDung = new GDQLSanPham();
                    }
                }
                break;

                case "QLCongDoan": {
                    if (nvLog.getPhongBan().getMaPB().equals("233")) {
                        pNoiDung = new GDQLCongDoan();
                    }
                }
                break;

                case "PhanCong": {
                    if (nvLog.getPhongBan().getMaPB().equals("233")) {
                        pNoiDung = new GDPhanCong();
                    }
                }
                break;

                case "QLChamCong": {
                    if (nvLog.getPhongBan().getMaPB().equals("233")
                            || nvLog.getPhongBan().getMaPB().equals("23")) {
                        pNoiDung = new AbstractColorChooserPanel() {
                            @Override
                            public void updateChooser() {
                                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                            }

                            @Override
                            protected void buildChooser() {
                                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                            }

                            @Override
                            public String getDisplayName() {
                                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                            }

                            @Override
                            public Icon getSmallDisplayIcon() {
                                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                            }

                            @Override
                            public Icon getLargeDisplayIcon() {
                                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                            }
                        };
                    }
                }
                break;
                case "QLLuong": {
                    if (nvLog.getPhongBan().getMaPB().equals("232")) {
                        pNoiDung = new AbstractColorChooserPanel() {
                            @Override
                            public void updateChooser() {
                                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                            }

                            @Override
                            protected void buildChooser() {
                                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                            }

                            @Override
                            public String getDisplayName() {
                                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                            }

                            @Override
                            public Icon getSmallDisplayIcon() {
                                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                            }

                            @Override
                            public Icon getLargeDisplayIcon() {
                                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                            }
                        };
                    }
                }
                break;

                case "QLTaiKhoan": {
                    if (nvLog.getPhongBan().getMaPB().equals("231")
                            && !(nvLog.getChucVu().equals("Nhân viên"))) {
                        pNoiDung = new GDQLTaiKhoan();
                    }
                }
                break;

                case "BaoCaoThongKe": {
                    if (nvLog.getPhongBan().getMaPB().equals("232")) {
                        pNoiDung = new GDBaoCaoThongKe();
                    }
                }
                break;

                case "TroGiup": {
                    pNoiDung = new GDTroGiup();
                }
                break;

                case "DangXuat": {
                    ImageIcon icon = new ImageIcon("/image/logo.png");
                    // Các lựa chọn
                    Object[] options = {"Hủy", "Đăng xuất"};
                    // Hiển thị JOptionPane với biểu tượng
                    int result = JOptionPane.showOptionDialog(null, "Bạn đang thực hiện đăng xuất khỏi hệ thống?", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);
                    if (result == JOptionPane.NO_OPTION) {
                        try {
                            gdChinh.dispose();
                            gdChinh = new GDChinh();
                        } catch (SQLException ex) {
                            Logger.getLogger(ChuyenManHinh.class.getName()).log(Level.SEVERE, null, ex);
                        }
                            
                    }
                }
                break;

                default:
                    break;
            }
            if (pNoiDung != null) {
                pChinh.removeAll();
                pChinh.setLayout(new BorderLayout());
                pChinh.add(pNoiDung);
                pChinh.validate();
                pChinh.repaint();
                thayDoiBackGroundKhiClick(loaiDanhMuc);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // set hiệu ứng khi được để chuột vào
            for (String label : phanQuyenManHinh) {
                if (loaiDanhMuc.equals(label)) {
                    panel.setBackground(mauDanhMucDangChon);
                    lbl.setBackground(mauDanhMucDangChon);
                    lbl.setForeground(mauTrang);
                    lbl.setBorder(null);
                    break;
                }
            }

        }

        @Override
        public void mouseExited(MouseEvent e) {
            //set hiệu ứng khi lia chuột ra chỗ khác
            for (String label : phanQuyenManHinh) {
                if (loaiDanhMuc.equals(label)) {
                    if (!danhMucDangChon.equalsIgnoreCase(loaiDanhMuc)) {
                        panel.setBackground(mauNenMenu);
                        lbl.setBackground(mauNenMenu);
                        lbl.setForeground(mauDen);
//                lbl.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, mauBorderBottomMenu));
                    }
                }
            }
        }

        private void thayDoiBackGroundKhiClick(String loaiDangChon) {
            int check = 0;
            for (DanhMucBean item : listDanhMucBean) {
                if (item.getLoaiDanhMuc().equalsIgnoreCase(loaiDangChon)) {
                    item.getPanel().setBackground(mauDanhMucDangChon);
                    item.getLbl().setBackground(mauDanhMucDangChon);
                    item.getLbl().setForeground(mauTrang);
                    item.getLbl().setBorder(null);
                } else {
                    for (JPanel panel : ds) {
                        if (panel == item.getPanel()) {
                            check = 1;
                        }
                    }
                    if (check != 1) {
                        item.getPanel().setBackground(mauNenMenu);
                        item.getLbl().setBackground(mauNenMenu);
                        item.getLbl().setForeground(mauDen);
                    }
//                    item.getLbl().setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, mauBorderBottomMenu));
                }
            }
        }
    }
}
