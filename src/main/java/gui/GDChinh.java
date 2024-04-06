/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import connectDB.ConnectDB;
import entity.NhanVienHanhChinh;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import xuli.ChuyenManHinh;
import static xuli.ChuyenManHinh.pChinh;
import xuli.DanhMucBean;

/**
 *
 * @author acer
 */
public class GDChinh extends javax.swing.JFrame {

    /**
     * Creates new form GDChinh1
     */
    private GDLogin gdlogin;
    private NhanVienHanhChinh nvLog;
    private ArrayList<JPanel> dsMenu;

    public GDChinh() throws SQLException {

        icon();
        this.setTitle("Chương trình quản lý lương sản phẩm của công ty Thịnh Vượng.");
        initComponents();
        setLocationRelativeTo(null);
        this.setResizable(false);
        gdlogin = new GDLogin();
        gdlogin.setVisible(true);
        this.gdlogin.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void windowClosing(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void windowClosed(WindowEvent e) {
                nvLog = gdlogin.getCurrNV();
                setMauMenu();
                setVisible(true);
                ChuyenManHinh dieuKhien = new ChuyenManHinh(pNoiDung, nvLog, dsMenu, getThis());
                try {
                    dieuKhien.setManHinhNoiDung(pHome, lblHome);
                } catch (SQLException ex) {
                    Logger.getLogger(GDChinh.class.getName()).log(Level.SEVERE, null, ex);
                }

                List<DanhMucBean> listDanhMucBean = new ArrayList<>();
                listDanhMucBean.add(new DanhMucBean("TrangChu", pHome, lblHome));
                listDanhMucBean.add(new DanhMucBean("QLNhanSu", pQLNhanSu, lblQLNhanSu));
                listDanhMucBean.add(new DanhMucBean("QLHopDong", pQLHopDong, lblQLHopDong));
                listDanhMucBean.add(new DanhMucBean("QLSanPham", pQLSanPham, lblQLSanPham));
                listDanhMucBean.add(new DanhMucBean("QLCongDoan", pQLCongDoan, lblQLCongDoan));
                listDanhMucBean.add(new DanhMucBean("PhanCong", pPhanCong, lblPhanCong));
                listDanhMucBean.add(new DanhMucBean("QLChamCong", pQLChamCong, lblQLChamCong));
                listDanhMucBean.add(new DanhMucBean("QLLuong", pQLLuong, lblQLLuong));
                listDanhMucBean.add(new DanhMucBean("BaoCaoThongKe", pBaoCao, lblBaoCao));
                listDanhMucBean.add(new DanhMucBean("QLTaiKhoan", pQLTaiKhoan, lblQLTaiKhoan));
                listDanhMucBean.add(new DanhMucBean("TroGiup", pTroGiup, jLabelTroGiup));
                listDanhMucBean.add(new DanhMucBean("DangXuat", pDangXuat, jLabel11));
                dieuKhien.setSuKienClickDanhMuc(listDanhMucBean);

                String tl = LocalDateTime.now().toString();
                jLabel12.setText("Ngày " + tl.substring(8, 10) + " tháng " + tl.substring(5, 7) + " năm " + tl.substring(0, 4));
                lblHinhNV.setIcon(resizeImage(getClass().getResource(nvLog.getHinhAnh()).getPath()));
                jLabel14.setText(nvLog.getHoTen());
                lblChucVu.setText(nvLog.getChucVu());
                
            }

            @Override
            public void windowIconified(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void windowActivated(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
    }
    
    public GDChinh getThis()
    {
        return this;
    }

    public void icon() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/logo.png")));
    }
    // resize hình theo kích thước label
    public ImageIcon resizeImage(String imagePath) {
        ImageIcon myImage = new ImageIcon(imagePath);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuNhanSu = new javax.swing.JPopupMenu();
        nhanVienHanhChinh = new javax.swing.JMenuItem();
        congNhan = new javax.swing.JMenuItem();
        menuChamCong = new javax.swing.JPopupMenu();
        chamCongNVHC = new javax.swing.JMenuItem();
        chamCongCongNhan = new javax.swing.JMenuItem();
        menuLuong = new javax.swing.JPopupMenu();
        tinhLuongNVHC = new javax.swing.JMenuItem();
        tinhLuongCongNhan = new javax.swing.JMenuItem();
        xemBangLuong = new javax.swing.JMenuItem();
        pBackGroundMain = new javax.swing.JPanel();
        pMenu = new javax.swing.JPanel();
        pNhanVien = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lblHinhNV = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblChucVu = new javax.swing.JLabel();
        pListMenu = new javax.swing.JPanel();
        pHome = new javax.swing.JPanel();
        lblHome = new javax.swing.JLabel();
        iConHome = new javax.swing.JLabel();
        pQLNhanSu = new javax.swing.JPanel();
        lblQLNhanSu = new javax.swing.JLabel();
        iconNhanSu = new javax.swing.JLabel();
        pQLHopDong = new javax.swing.JPanel();
        lblQLHopDong = new javax.swing.JLabel();
        iconHopDong = new javax.swing.JLabel();
        pQLSanPham = new javax.swing.JPanel();
        lblQLSanPham = new javax.swing.JLabel();
        iconSP = new javax.swing.JLabel();
        pQLCongDoan = new javax.swing.JPanel();
        lblQLCongDoan = new javax.swing.JLabel();
        iconCD = new javax.swing.JLabel();
        pPhanCong = new javax.swing.JPanel();
        lblPhanCong = new javax.swing.JLabel();
        iconPC = new javax.swing.JLabel();
        pQLChamCong = new javax.swing.JPanel();
        lblQLChamCong = new javax.swing.JLabel();
        iconCC = new javax.swing.JLabel();
        pQLLuong = new javax.swing.JPanel();
        lblQLLuong = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pBaoCao = new javax.swing.JPanel();
        lblBaoCao = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pQLTaiKhoan = new javax.swing.JPanel();
        lblQLTaiKhoan = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pDangXuat = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pTroGiup = new javax.swing.JPanel();
        jLabelTroGiup = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pNoiDung = new javax.swing.JPanel();
        pTittle = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        pTongQuan = new javax.swing.JPanel();

        nhanVienHanhChinh.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nhanVienHanhChinh.setText("Nhân viên hành chính");
        nhanVienHanhChinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhanVienHanhChinhActionPerformed(evt);
            }
        });
        menuNhanSu.add(nhanVienHanhChinh);

        congNhan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        congNhan.setText("Công nhân");
        congNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                congNhanActionPerformed(evt);
            }
        });
        menuNhanSu.add(congNhan);

        chamCongNVHC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chamCongNVHC.setText("Nhân viên hành chính");
        chamCongNVHC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chamCongNVHCActionPerformed(evt);
            }
        });
        menuChamCong.add(chamCongNVHC);

        chamCongCongNhan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chamCongCongNhan.setText("Công nhân");
        chamCongCongNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chamCongCongNhanActionPerformed(evt);
            }
        });
        menuChamCong.add(chamCongCongNhan);

        tinhLuongNVHC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tinhLuongNVHC.setText("Tính lương nhân viên");
        tinhLuongNVHC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinhLuongNVHCActionPerformed(evt);
            }
        });
        menuLuong.add(tinhLuongNVHC);

        tinhLuongCongNhan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tinhLuongCongNhan.setText("Tính lương công nhân");
        tinhLuongCongNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinhLuongCongNhanActionPerformed(evt);
            }
        });
        menuLuong.add(tinhLuongCongNhan);

        xemBangLuong.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        xemBangLuong.setText("Xem bảng lương");
        xemBangLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xemBangLuongActionPerformed(evt);
            }
        });
        menuLuong.add(xemBangLuong);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        pBackGroundMain.setBackground(new java.awt.Color(255, 255, 255));
        pBackGroundMain.setPreferredSize(new java.awt.Dimension(1200, 735));

        pMenu.setBackground(new java.awt.Color(255, 255, 255));
        pMenu.setPreferredSize(new java.awt.Dimension(236, 720));

        pNhanVien.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Ngày tháng năm");

        lblHinhNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinhNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user_60px.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Tên nhân viên");

        lblChucVu.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        lblChucVu.setForeground(new java.awt.Color(102, 102, 102));
        lblChucVu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChucVu.setText("Chức vụ");
        lblChucVu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout pNhanVienLayout = new javax.swing.GroupLayout(pNhanVien);
        pNhanVien.setLayout(pNhanVienLayout);
        pNhanVienLayout.setHorizontalGroup(
            pNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pNhanVienLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(lblHinhNV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pNhanVienLayout.setVerticalGroup(
            pNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pNhanVienLayout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pListMenu.setBackground(new java.awt.Color(255, 255, 255));
        pListMenu.setPreferredSize(new java.awt.Dimension(230, 611));

        pHome.setBackground(new java.awt.Color(255, 255, 255));
        pHome.setPreferredSize(new java.awt.Dimension(140, 45));

        lblHome.setBackground(new java.awt.Color(255, 255, 255));
        lblHome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblHome.setText("Trang chủ");
        lblHome.setToolTipText("Trang chủ");

        iConHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iConHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home_20px.png"))); // NOI18N

        javax.swing.GroupLayout pHomeLayout = new javax.swing.GroupLayout(pHome);
        pHome.setLayout(pHomeLayout);
        pHomeLayout.setHorizontalGroup(
            pHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pHomeLayout.createSequentialGroup()
                .addComponent(iConHome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHome, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pHomeLayout.setVerticalGroup(
            pHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(iConHome, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pQLNhanSu.setBackground(new java.awt.Color(255, 255, 255));
        pQLNhanSu.setPreferredSize(new java.awt.Dimension(140, 45));

        lblQLNhanSu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblQLNhanSu.setText("Quản lý nhân sự");
        lblQLNhanSu.setToolTipText("Quản lý nhân sự");
        lblQLNhanSu.setPreferredSize(new java.awt.Dimension(140, 45));
        lblQLNhanSu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQLNhanSuMouseClicked(evt);
            }
        });

        iconNhanSu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconNhanSu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nhansu_32px.png"))); // NOI18N

        javax.swing.GroupLayout pQLNhanSuLayout = new javax.swing.GroupLayout(pQLNhanSu);
        pQLNhanSu.setLayout(pQLNhanSuLayout);
        pQLNhanSuLayout.setHorizontalGroup(
            pQLNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pQLNhanSuLayout.createSequentialGroup()
                .addComponent(iconNhanSu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQLNhanSu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        pQLNhanSuLayout.setVerticalGroup(
            pQLNhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQLNhanSu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(iconNhanSu, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        pQLHopDong.setBackground(new java.awt.Color(255, 255, 255));
        pQLHopDong.setPreferredSize(new java.awt.Dimension(140, 45));

        lblQLHopDong.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblQLHopDong.setText("Quản lý hợp đồng");
        lblQLHopDong.setToolTipText("Quản lý hợp đồng");
        lblQLHopDong.setPreferredSize(new java.awt.Dimension(140, 45));

        iconHopDong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconHopDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hopdong_32px.png"))); // NOI18N

        javax.swing.GroupLayout pQLHopDongLayout = new javax.swing.GroupLayout(pQLHopDong);
        pQLHopDong.setLayout(pQLHopDongLayout);
        pQLHopDongLayout.setHorizontalGroup(
            pQLHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pQLHopDongLayout.createSequentialGroup()
                .addComponent(iconHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQLHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        pQLHopDongLayout.setVerticalGroup(
            pQLHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQLHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(pQLHopDongLayout.createSequentialGroup()
                .addComponent(iconHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pQLSanPham.setBackground(new java.awt.Color(255, 255, 255));
        pQLSanPham.setPreferredSize(new java.awt.Dimension(140, 45));

        lblQLSanPham.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblQLSanPham.setText("Quản lý sản phẩm");
        lblQLSanPham.setToolTipText("Quản lý sản phẩm");
        lblQLSanPham.setPreferredSize(new java.awt.Dimension(140, 45));

        iconSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sanpham_25px.png"))); // NOI18N

        javax.swing.GroupLayout pQLSanPhamLayout = new javax.swing.GroupLayout(pQLSanPham);
        pQLSanPham.setLayout(pQLSanPhamLayout);
        pQLSanPhamLayout.setHorizontalGroup(
            pQLSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pQLSanPhamLayout.createSequentialGroup()
                .addComponent(iconSP, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQLSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        pQLSanPhamLayout.setVerticalGroup(
            pQLSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQLSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(iconSP, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        pQLCongDoan.setBackground(new java.awt.Color(255, 255, 255));
        pQLCongDoan.setPreferredSize(new java.awt.Dimension(140, 45));

        lblQLCongDoan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblQLCongDoan.setText("Công đoạn");
        lblQLCongDoan.setToolTipText("Quản lý công đoạn");
        lblQLCongDoan.setPreferredSize(new java.awt.Dimension(140, 45));

        iconCD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconCD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/congdoan_32px.png"))); // NOI18N

        javax.swing.GroupLayout pQLCongDoanLayout = new javax.swing.GroupLayout(pQLCongDoan);
        pQLCongDoan.setLayout(pQLCongDoanLayout);
        pQLCongDoanLayout.setHorizontalGroup(
            pQLCongDoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pQLCongDoanLayout.createSequentialGroup()
                .addComponent(iconCD, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQLCongDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        pQLCongDoanLayout.setVerticalGroup(
            pQLCongDoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQLCongDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(iconCD, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        pPhanCong.setBackground(new java.awt.Color(255, 255, 255));
        pPhanCong.setPreferredSize(new java.awt.Dimension(140, 45));

        lblPhanCong.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPhanCong.setText("Phân công đoạn");
        lblPhanCong.setToolTipText("Phân công công đoạn");
        lblPhanCong.setPreferredSize(new java.awt.Dimension(140, 45));

        iconPC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconPC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/phancong_32px.png"))); // NOI18N

        javax.swing.GroupLayout pPhanCongLayout = new javax.swing.GroupLayout(pPhanCong);
        pPhanCong.setLayout(pPhanCongLayout);
        pPhanCongLayout.setHorizontalGroup(
            pPhanCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPhanCongLayout.createSequentialGroup()
                .addComponent(iconPC, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPhanCong, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        pPhanCongLayout.setVerticalGroup(
            pPhanCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPhanCong, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(iconPC, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        pQLChamCong.setBackground(new java.awt.Color(255, 255, 255));
        pQLChamCong.setPreferredSize(new java.awt.Dimension(140, 45));

        lblQLChamCong.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblQLChamCong.setText("Chấm công");
        lblQLChamCong.setToolTipText("Quản lý chấm công");
        lblQLChamCong.setPreferredSize(new java.awt.Dimension(140, 45));
        lblQLChamCong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQLChamCongMouseClicked(evt);
            }
        });

        iconCC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/chamcong_32px.png"))); // NOI18N

        javax.swing.GroupLayout pQLChamCongLayout = new javax.swing.GroupLayout(pQLChamCong);
        pQLChamCong.setLayout(pQLChamCongLayout);
        pQLChamCongLayout.setHorizontalGroup(
            pQLChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pQLChamCongLayout.createSequentialGroup()
                .addComponent(iconCC, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQLChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        pQLChamCongLayout.setVerticalGroup(
            pQLChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQLChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(iconCC, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        pQLLuong.setBackground(new java.awt.Color(255, 255, 255));
        pQLLuong.setPreferredSize(new java.awt.Dimension(140, 45));

        lblQLLuong.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblQLLuong.setText("Quản lý lương");
        lblQLLuong.setToolTipText("Quản lý lương");
        lblQLLuong.setPreferredSize(new java.awt.Dimension(140, 45));
        lblQLLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQLLuongMouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/luong_32px.png"))); // NOI18N

        javax.swing.GroupLayout pQLLuongLayout = new javax.swing.GroupLayout(pQLLuong);
        pQLLuong.setLayout(pQLLuongLayout);
        pQLLuongLayout.setHorizontalGroup(
            pQLLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pQLLuongLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQLLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        pQLLuongLayout.setVerticalGroup(
            pQLLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQLLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        pBaoCao.setBackground(new java.awt.Color(255, 255, 255));
        pBaoCao.setPreferredSize(new java.awt.Dimension(140, 45));

        lblBaoCao.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblBaoCao.setText("Báo cáo thống kê");
        lblBaoCao.setToolTipText("Báo cáo thống kê");
        lblBaoCao.setPreferredSize(new java.awt.Dimension(140, 45));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thongke_32px.png"))); // NOI18N

        javax.swing.GroupLayout pBaoCaoLayout = new javax.swing.GroupLayout(pBaoCao);
        pBaoCao.setLayout(pBaoCaoLayout);
        pBaoCaoLayout.setHorizontalGroup(
            pBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBaoCaoLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        pBaoCaoLayout.setVerticalGroup(
            pBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        pQLTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));
        pQLTaiKhoan.setPreferredSize(new java.awt.Dimension(140, 45));

        lblQLTaiKhoan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblQLTaiKhoan.setText("Quản lý tài khoản");
        lblQLTaiKhoan.setToolTipText("Quản lý tài khoản");
        lblQLTaiKhoan.setPreferredSize(new java.awt.Dimension(140, 45));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/qltaikhoan_25px.png"))); // NOI18N

        javax.swing.GroupLayout pQLTaiKhoanLayout = new javax.swing.GroupLayout(pQLTaiKhoan);
        pQLTaiKhoan.setLayout(pQLTaiKhoanLayout);
        pQLTaiKhoanLayout.setHorizontalGroup(
            pQLTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pQLTaiKhoanLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQLTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        pQLTaiKhoanLayout.setVerticalGroup(
            pQLTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQLTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        pDangXuat.setBackground(new java.awt.Color(255, 255, 255));
        pDangXuat.setPreferredSize(new java.awt.Dimension(140, 45));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Thoát");
        jLabel11.setToolTipText("Đăng xuất");
        jLabel11.setPreferredSize(new java.awt.Dimension(140, 45));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logout_25px.png"))); // NOI18N

        javax.swing.GroupLayout pDangXuatLayout = new javax.swing.GroupLayout(pDangXuat);
        pDangXuat.setLayout(pDangXuatLayout);
        pDangXuatLayout.setHorizontalGroup(
            pDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDangXuatLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
        );
        pDangXuatLayout.setVerticalGroup(
            pDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        pTroGiup.setBackground(new java.awt.Color(255, 255, 255));
        pTroGiup.setPreferredSize(new java.awt.Dimension(140, 45));

        jLabelTroGiup.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelTroGiup.setText("Trợ giúp");
        jLabelTroGiup.setToolTipText("Trợ giúp");
        jLabelTroGiup.setPreferredSize(new java.awt.Dimension(140, 45));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/question-solid.png"))); // NOI18N

        javax.swing.GroupLayout pTroGiupLayout = new javax.swing.GroupLayout(pTroGiup);
        pTroGiup.setLayout(pTroGiupLayout);
        pTroGiupLayout.setHorizontalGroup(
            pTroGiupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTroGiupLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTroGiup, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        pTroGiupLayout.setVerticalGroup(
            pTroGiupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTroGiup, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pListMenuLayout = new javax.swing.GroupLayout(pListMenu);
        pListMenu.setLayout(pListMenuLayout);
        pListMenuLayout.setHorizontalGroup(
            pListMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pListMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pListMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pHome, javax.swing.GroupLayout.PREFERRED_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(pQLTaiKhoan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(pBaoCao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(pQLLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(pQLChamCong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(pPhanCong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(pQLSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(pQLHopDong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(pQLNhanSu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(pDangXuat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(pTroGiup, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(pQLCongDoan, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        pListMenuLayout.setVerticalGroup(
            pListMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pListMenuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pHome, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pQLNhanSu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pQLHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pQLSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pQLCongDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPhanCong, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pQLChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pQLLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pQLTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pTroGiup, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(pDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pMenuLayout = new javax.swing.GroupLayout(pMenu);
        pMenu.setLayout(pMenuLayout);
        pMenuLayout.setHorizontalGroup(
            pMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMenuLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(pMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pListMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)))
        );
        pMenuLayout.setVerticalGroup(
            pMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMenuLayout.createSequentialGroup()
                .addComponent(pNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pListMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pNoiDung.setBackground(new java.awt.Color(204, 204, 204));
        pNoiDung.setMaximumSize(new java.awt.Dimension(958, 735));
        pNoiDung.setPreferredSize(new java.awt.Dimension(958, 735));

        pTittle.setBackground(new java.awt.Color(0, 0, 0));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(191, 95, 95));

        javax.swing.GroupLayout pTittleLayout = new javax.swing.GroupLayout(pTittle);
        pTittle.setLayout(pTittleLayout);
        pTittleLayout.setHorizontalGroup(
            pTittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTittleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                .addContainerGap())
        );
        pTittleLayout.setVerticalGroup(
            pTittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pTongQuan.setBackground(new java.awt.Color(134, 102, 134));

        javax.swing.GroupLayout pTongQuanLayout = new javax.swing.GroupLayout(pTongQuan);
        pTongQuan.setLayout(pTongQuanLayout);
        pTongQuanLayout.setHorizontalGroup(
            pTongQuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pTongQuanLayout.setVerticalGroup(
            pTongQuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pNoiDungLayout = new javax.swing.GroupLayout(pNoiDung);
        pNoiDung.setLayout(pNoiDungLayout);
        pNoiDungLayout.setHorizontalGroup(
            pNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pTongQuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pNoiDungLayout.setVerticalGroup(
            pNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pNoiDungLayout.createSequentialGroup()
                .addComponent(pTittle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pTongQuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pBackGroundMainLayout = new javax.swing.GroupLayout(pBackGroundMain);
        pBackGroundMain.setLayout(pBackGroundMainLayout);
        pBackGroundMainLayout.setHorizontalGroup(
            pBackGroundMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBackGroundMainLayout.createSequentialGroup()
                .addComponent(pMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pNoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pBackGroundMainLayout.setVerticalGroup(
            pBackGroundMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pNoiDung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pBackGroundMain, javax.swing.GroupLayout.DEFAULT_SIZE, 1162, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pBackGroundMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void congNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_congNhanActionPerformed
        if (nvLog.getPhongBan().getMaPB().equals("231")) {
//            System.out.println("gui.GDChinh.congNhanActionPerformed()");
            pNoiDung = new GDQLCongNhan();
            pChinh.removeAll();
            pChinh.setLayout(new BorderLayout());
            pChinh.add(pNoiDung);
            pChinh.validate();
            pChinh.repaint();
        }
    }//GEN-LAST:event_congNhanActionPerformed

    private void nhanVienHanhChinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhanVienHanhChinhActionPerformed
        if (nvLog.getPhongBan().getMaPB().equals("231")) {
            pNoiDung = new GDQLNhanVienHanhChinh();
            pChinh.removeAll();
            pChinh.setLayout(new BorderLayout());
            pChinh.add(pNoiDung);
            pChinh.validate();
            pChinh.repaint();
        }
    }//GEN-LAST:event_nhanVienHanhChinhActionPerformed

    private void lblQLNhanSuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQLNhanSuMouseClicked
//        System.out.println("gui.GDChinh.lblQLNhanSuMouseClicked()");
        if (nvLog.getPhongBan().getMaPB().equals("231"))
            menuNhanSu.show(pHome, evt.getX(), evt.getY());
    }//GEN-LAST:event_lblQLNhanSuMouseClicked

    private void lblQLChamCongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQLChamCongMouseClicked
//        System.out.println("gui.GDChinh.lblQLChamCongMouseClicked()");
        if (nvLog.getPhongBan().getMaPB().equals("231")
                || nvLog.getPhongBan().getMaPB().equals("233"))
            menuChamCong.show(pQLChamCong, evt.getX(), evt.getY());
    }//GEN-LAST:event_lblQLChamCongMouseClicked

    private void lblQLLuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQLLuongMouseClicked
//        System.out.println("gui.GDChinh.lblQLLuongMouseClicked()");
        if (nvLog.getPhongBan().getMaPB().equals("232"))
            menuLuong.show(pQLLuong, evt.getX(), evt.getY());
    }//GEN-LAST:event_lblQLLuongMouseClicked

    private void chamCongNVHCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chamCongNVHCActionPerformed
        if (nvLog.getPhongBan().getMaPB().equals("231")) {
//            System.out.println("gui.GDChinh.chamCongNVHCActionPerformed()");
            pNoiDung = new GDQLChamCongNVHC();
            pChinh.removeAll();
            pChinh.setLayout(new BorderLayout());
            pChinh.add(pNoiDung);
            pChinh.validate();
            pChinh.repaint();
        }
    }//GEN-LAST:event_chamCongNVHCActionPerformed

    private void chamCongCongNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chamCongCongNhanActionPerformed
        if (nvLog.getPhongBan().getMaPB().equals("233")) {
//            System.out.println("gui.GDChinh.chamCongCongNhanActionPerformed()");
            pNoiDung = new GDQLChamCongCN();
            pChinh.removeAll();
            pChinh.setLayout(new BorderLayout());
            pChinh.add(pNoiDung);
            pChinh.validate();
            pChinh.repaint();
        }
    }//GEN-LAST:event_chamCongCongNhanActionPerformed

    private void tinhLuongNVHCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tinhLuongNVHCActionPerformed
        if (nvLog.getPhongBan().getMaPB().equals("232")) {
//            System.out.println("gui.GDChinh.tinhLuongNVHCActionPerformed()");
            pNoiDung = new GDTinhLuongNV();
            pChinh.removeAll();
            pChinh.setLayout(new BorderLayout());
            pChinh.add(pNoiDung);
            pChinh.validate();
            pChinh.repaint();
        }
    }//GEN-LAST:event_tinhLuongNVHCActionPerformed

    private void tinhLuongCongNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tinhLuongCongNhanActionPerformed
        if (nvLog.getPhongBan().getMaPB().equals("232")) {
//            System.out.println("gui.GDChinh.tinhLuongCongNhanActionPerformed()");
            pNoiDung = new GDTinhLuongCN();
            pChinh.removeAll();
            pChinh.setLayout(new BorderLayout());
            pChinh.add(pNoiDung);
            pChinh.validate();
            pChinh.repaint();
        }
    }//GEN-LAST:event_tinhLuongCongNhanActionPerformed

    private void xemBangLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xemBangLuongActionPerformed
        if (nvLog.getPhongBan().getMaPB().equals("232")) {
//            System.out.println("gui.GDChinh.xemBangLuongActionPerformed()");
            pNoiDung = new GDXemBangLuong();
            pChinh.removeAll();
            pChinh.setLayout(new BorderLayout());
            pChinh.add(pNoiDung);
            pChinh.validate();
            pChinh.repaint();
        }
    }//GEN-LAST:event_xemBangLuongActionPerformed

    private void setMauMenu() {
        List<DanhMucBean> listDanhMucBean = new ArrayList<>();
        listDanhMucBean.add(new DanhMucBean("TrangChu", pHome, lblHome));
        listDanhMucBean.add(new DanhMucBean("QLNhanSu", pQLNhanSu, lblQLNhanSu));
        listDanhMucBean.add(new DanhMucBean("QLHopDong", pQLHopDong, lblQLHopDong));
        listDanhMucBean.add(new DanhMucBean("QLSanPham", pQLSanPham, lblQLSanPham));
        listDanhMucBean.add(new DanhMucBean("QLCongDoan", pQLCongDoan, lblQLCongDoan));
        listDanhMucBean.add(new DanhMucBean("PhanCong", pPhanCong, lblPhanCong));
        listDanhMucBean.add(new DanhMucBean("QLChamCong", pQLChamCong, lblQLChamCong));
        listDanhMucBean.add(new DanhMucBean("QLLuong", pQLLuong, lblQLLuong));
        listDanhMucBean.add(new DanhMucBean("BaoCaoThongKe", pBaoCao, lblBaoCao));
        listDanhMucBean.add(new DanhMucBean("QLTaiKhoan", pQLTaiKhoan, lblQLTaiKhoan));
        listDanhMucBean.add(new DanhMucBean("TroGiup", pTroGiup, jLabelTroGiup));
        listDanhMucBean.add(new DanhMucBean("DangXuat", pDangXuat, jLabel11));
        dsMenu = new ArrayList<>();
        if(nvLog.getPhongBan().getMaPB().equals("231"))
        {
            dsMenu.add(pQLHopDong);
            dsMenu.add(pQLSanPham);
            dsMenu.add(pQLCongDoan);
            dsMenu.add(pPhanCong);
            dsMenu.add(pQLLuong);
            dsMenu.add(pBaoCao);
            if(nvLog.getChucVu().equals("Nhân viên"))
                dsMenu.add(pQLTaiKhoan);
        }
        else if(nvLog.getPhongBan().getMaPB().equals("232"))
        {
            dsMenu.add(pQLNhanSu);
            dsMenu.add(pQLHopDong);
            dsMenu.add(pQLSanPham);
            dsMenu.add(pQLCongDoan);
            dsMenu.add(pPhanCong);
            dsMenu.add(pQLChamCong);
            dsMenu.add(pQLTaiKhoan);
        }
        else if(nvLog.getPhongBan().getMaPB().equals("233"))
        {
            dsMenu.add(pQLNhanSu);
            dsMenu.add(pQLLuong);
            dsMenu.add(pBaoCao);
            dsMenu.add(pQLTaiKhoan);
        }
        for(JPanel panel: dsMenu)
        {
//            System.out.println(panel.toString());
            panel.setBackground(new Color(204,204,204));
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem chamCongCongNhan;
    private javax.swing.JMenuItem chamCongNVHC;
    private javax.swing.JMenuItem congNhan;
    private javax.swing.JLabel iConHome;
    private javax.swing.JLabel iconCC;
    private javax.swing.JLabel iconCD;
    private javax.swing.JLabel iconHopDong;
    private javax.swing.JLabel iconNhanSu;
    private javax.swing.JLabel iconPC;
    private javax.swing.JLabel iconSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelTroGiup;
    private javax.swing.JLabel lblBaoCao;
    private javax.swing.JLabel lblChucVu;
    private javax.swing.JLabel lblHinhNV;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblPhanCong;
    private javax.swing.JLabel lblQLChamCong;
    private javax.swing.JLabel lblQLCongDoan;
    private javax.swing.JLabel lblQLHopDong;
    private javax.swing.JLabel lblQLLuong;
    private javax.swing.JLabel lblQLNhanSu;
    private javax.swing.JLabel lblQLSanPham;
    private javax.swing.JLabel lblQLTaiKhoan;
    private javax.swing.JPopupMenu menuChamCong;
    private javax.swing.JPopupMenu menuLuong;
    private javax.swing.JPopupMenu menuNhanSu;
    private javax.swing.JMenuItem nhanVienHanhChinh;
    private javax.swing.JPanel pBackGroundMain;
    private javax.swing.JPanel pBaoCao;
    private javax.swing.JPanel pDangXuat;
    private javax.swing.JPanel pHome;
    private javax.swing.JPanel pListMenu;
    private javax.swing.JPanel pMenu;
    private javax.swing.JPanel pNhanVien;
    private javax.swing.JPanel pNoiDung;
    private javax.swing.JPanel pPhanCong;
    private javax.swing.JPanel pQLChamCong;
    private javax.swing.JPanel pQLCongDoan;
    private javax.swing.JPanel pQLHopDong;
    private javax.swing.JPanel pQLLuong;
    private javax.swing.JPanel pQLNhanSu;
    private javax.swing.JPanel pQLSanPham;
    private javax.swing.JPanel pQLTaiKhoan;
    private javax.swing.JPanel pTittle;
    private javax.swing.JPanel pTongQuan;
    private javax.swing.JPanel pTroGiup;
    private javax.swing.JMenuItem tinhLuongCongNhan;
    private javax.swing.JMenuItem tinhLuongNVHC;
    private javax.swing.JMenuItem xemBangLuong;
    // End of variables declaration//GEN-END:variables

}
