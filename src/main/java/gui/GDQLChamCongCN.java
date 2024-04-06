/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dao.BangChamCongCongNhan_DAO;
import dao.BangPhanCong_DAO;
import dao.ChiTietBangChamCong_DAO;
import dao.CongDoan_DAO;
import dao.CongNhan_DAO;
import dao.SanPham_DAO;
import entity.BangChamCongCongNhan;
import entity.BangPhanCong;
import entity.ChiTietBangChamCong;
import entity.CongDoan;
import entity.CongNhan;
import entity.SanPham;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author acer
 */
public class GDQLChamCongCN extends javax.swing.JPanel {

    /**
     * Creates new form GDQLChamCongCN
     */
    public GDQLChamCongCN() {
        phanCong_Dao = new BangPhanCong_DAO();
        congDoan_Dao = new CongDoan_DAO();
        congNhan_Dao = new CongNhan_DAO();
        sanPham_Dao = new SanPham_DAO();
        bangCCCN_Dao = new BangChamCongCongNhan_DAO();
        ctBangCC_Dao = new ChiTietBangChamCong_DAO();
        listKTCC = new ArrayList<>();
        initComponents();
        addListPC();
//        addListChamCong();
        addCBB();
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rbtCN);
        buttonGroup.add(rbtCa3);
        buttonGroup.add(rbtLe);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comfirmCC = new javax.swing.JDialog();
        pnttCN = new javax.swing.JPanel();
        lbCN = new javax.swing.JLabel();
        lbMaBangCTCC = new javax.swing.JLabel();
        pnValue = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtSP = new javax.swing.JTextField();
        txtCD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTimeHT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rbtCN = new javax.swing.JRadioButton();
        rbtCa3 = new javax.swing.JRadioButton();
        rbtLe = new javax.swing.JRadioButton();
        btnXNCC = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        spinSLHT = new com.toedter.components.JSpinField();
        lbTBKTCC = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comfirmDelete = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        lbttCN = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnHuyXoa = new javax.swing.JButton();
        btnXacNhanXoa = new javax.swing.JButton();
        lbXacNhanXoa = new javax.swing.JLabel();
        pQLChamCongCN = new javax.swing.JPanel();
        pTittle = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        scrollCC = new javax.swing.JScrollPane();
        tableChamCong = new javax.swing.JTable();
        scrollCN = new javax.swing.JScrollPane();
        tableDanhSachPC = new javax.swing.JTable();
        pnLoc = new javax.swing.JPanel();
        cbbSP = new javax.swing.JComboBox<>();
        cbbCD = new javax.swing.JComboBox<>();
        cbbTayNghe = new javax.swing.JComboBox<>();
        pnXuLy = new javax.swing.JPanel();
        btnBatDauCC = new javax.swing.JButton();
        btnKetThucCC = new javax.swing.JButton();
        btnChonTatCN = new javax.swing.JButton();
        dateChamCong = new com.toedter.calendar.JDateChooser();
        lbThongBao = new javax.swing.JLabel();
        pnTraCuuCC = new javax.swing.JPanel();
        btnXemCong = new javax.swing.JButton();
        dateBatDauXemCong = new com.toedter.calendar.JDateChooser();
        dateKetThucXemCong = new com.toedter.calendar.JDateChooser();
        pnChinhSuaCC = new javax.swing.JPanel();
        btnXoaCC = new javax.swing.JButton();
        btnUpdateSPHT = new javax.swing.JButton();
        spinUpdateSPHT = new com.toedter.components.JSpinField();

        comfirmCC.setTitle("Kết thúc chấm công");
        comfirmCC.setAlwaysOnTop(true);
        comfirmCC.setFocusTraversalPolicyProvider(true);
        comfirmCC.setLocation(new java.awt.Point(540, 280));
        comfirmCC.setSize(new java.awt.Dimension(440, 350));

        lbCN.setForeground(new java.awt.Color(255, 0, 51));
        lbCN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCN.setText("Mã công nhân-Họ tên công nhân A ");

        lbMaBangCTCC.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        lbMaBangCTCC.setEnabled(false);

        javax.swing.GroupLayout pnttCNLayout = new javax.swing.GroupLayout(pnttCN);
        pnttCN.setLayout(pnttCNLayout);
        pnttCNLayout.setHorizontalGroup(
            pnttCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbCN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnttCNLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(lbMaBangCTCC, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnttCNLayout.setVerticalGroup(
            pnttCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnttCNLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCN, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMaBangCTCC, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnValue.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Sản phẩm:");

        txtSP.setEditable(false);
        txtSP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtSP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCD.setEditable(false);
        txtCD.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCD.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Công đoạn:");

        txtTimeHT.setEditable(false);
        txtTimeHT.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtTimeHT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTimeHT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimeHTActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("<html><center>Thời gian hoàn thành/<br>Giờ ra</center></html> :");

        rbtCN.setBackground(new java.awt.Color(204, 204, 204));
        rbtCN.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbtCN.setText("Chủ nhật");
        rbtCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtCNActionPerformed(evt);
            }
        });

        rbtCa3.setBackground(new java.awt.Color(204, 204, 204));
        rbtCa3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbtCa3.setText("Ca 3");
        rbtCa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtCa3ActionPerformed(evt);
            }
        });

        rbtLe.setBackground(new java.awt.Color(204, 204, 204));
        rbtLe.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbtLe.setText("Ngày lễ");
        rbtLe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtLeActionPerformed(evt);
            }
        });

        btnXNCC.setBackground(new java.awt.Color(255, 102, 102));
        btnXNCC.setForeground(new java.awt.Color(255, 255, 255));
        btnXNCC.setText("<html><center>Xác nhận<br>chấm công</center></html>");
        btnXNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXNCCActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Số lượng hoàn thành:");

        lbTBKTCC.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        lbTBKTCC.setForeground(new java.awt.Color(255, 0, 51));
        lbTBKTCC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTBKTCC.setText("*");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Tăng ca:");

        javax.swing.GroupLayout pnValueLayout = new javax.swing.GroupLayout(pnValue);
        pnValue.setLayout(pnValueLayout);
        pnValueLayout.setHorizontalGroup(
            pnValueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnValueLayout.createSequentialGroup()
                .addGroup(pnValueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnValueLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(pnValueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnValueLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnValueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnValueLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(pnValueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCD)
                    .addComponent(txtSP)
                    .addComponent(txtTimeHT)
                    .addGroup(pnValueLayout.createSequentialGroup()
                        .addComponent(spinSLHT, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnValueLayout.createSequentialGroup()
                        .addGroup(pnValueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnValueLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lbTBKTCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnValueLayout.createSequentialGroup()
                                .addGroup(pnValueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnXNCC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnValueLayout.createSequentialGroup()
                                        .addComponent(rbtCa3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbtCN)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbtLe)))
                                .addGap(0, 3, Short.MAX_VALUE)))
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        pnValueLayout.setVerticalGroup(
            pnValueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnValueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnValueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnValueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnValueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimeHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnValueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnValueLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnValueLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(spinSLHT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(lbTBKTCC, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(pnValueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(rbtCa3)
                    .addComponent(rbtCN)
                    .addComponent(rbtLe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout comfirmCCLayout = new javax.swing.GroupLayout(comfirmCC.getContentPane());
        comfirmCC.getContentPane().setLayout(comfirmCCLayout);
        comfirmCCLayout.setHorizontalGroup(
            comfirmCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnttCN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        comfirmCCLayout.setVerticalGroup(
            comfirmCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comfirmCCLayout.createSequentialGroup()
                .addComponent(pnttCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        comfirmDelete.setTitle("Xác nhận xóa");
        comfirmDelete.setAlwaysOnTop(true);
        comfirmDelete.setFocusTraversalPolicyProvider(true);
        comfirmDelete.setLocation(new java.awt.Point(540, 280));
        comfirmDelete.setModal(true);
        comfirmDelete.setSize(new java.awt.Dimension(340, 250));

        lbttCN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbttCN.setText("Họ tên công nhân A - Mã công nhân");
        lbttCN.setPreferredSize(new java.awt.Dimension(340, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbttCN, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbttCN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(340, 220));

        btnHuyXoa.setBackground(new java.awt.Color(255, 102, 102));
        btnHuyXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyXoa.setText("Hủy");
        btnHuyXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyXoaActionPerformed(evt);
            }
        });

        btnXacNhanXoa.setBackground(new java.awt.Color(255, 102, 102));
        btnXacNhanXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhanXoa.setLabel("Xác nhận");
        btnXacNhanXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanXoaActionPerformed(evt);
            }
        });

        lbXacNhanXoa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbXacNhanXoa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbXacNhanXoa.setText("Bạn có chắc muốn xóa ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnXacNhanXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHuyXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbXacNhanXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lbXacNhanXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhanXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout comfirmDeleteLayout = new javax.swing.GroupLayout(comfirmDelete.getContentPane());
        comfirmDelete.getContentPane().setLayout(comfirmDeleteLayout);
        comfirmDeleteLayout.setHorizontalGroup(
            comfirmDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        comfirmDeleteLayout.setVerticalGroup(
            comfirmDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comfirmDeleteLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pQLChamCongCN.setPreferredSize(new java.awt.Dimension(958, 735));

        pTittle.setBackground(new java.awt.Color(85, 167, 222));
        pTittle.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(233, 231, 231)));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(234, 233, 233));
        jLabel15.setText("QUẢN LÝ CHẤM CÔNG CÔNG NHÂN");

        javax.swing.GroupLayout pTittleLayout = new javax.swing.GroupLayout(pTittle);
        pTittle.setLayout(pTittleLayout);
        pTittleLayout.setHorizontalGroup(
            pTittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTittleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
                .addContainerGap())
        );
        pTittleLayout.setVerticalGroup(
            pTittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(233, 231, 231)));
        jPanel18.setPreferredSize(new java.awt.Dimension(958, 679));

        scrollCC.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, new java.awt.Color(204, 0, 0)), "Danh sách chi tiết chấm công", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tableChamCong.setBackground(new java.awt.Color(242, 242, 242));
        tableChamCong.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(153, 153, 153)));
        tableChamCong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableChamCong.setGridColor(new java.awt.Color(153, 153, 153));
        tableChamCong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableChamCongMouseClicked(evt);
            }
        });
        tableChamCong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableChamCongKeyReleased(evt);
            }
        });
        scrollCC.setViewportView(tableChamCong);

        scrollCN.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, new java.awt.Color(204, 0, 0)), "Danh sách phân công", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tableDanhSachPC.setAutoCreateRowSorter(true);
        tableDanhSachPC.setBackground(new java.awt.Color(242, 242, 242));
        tableDanhSachPC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(153, 153, 153)));
        tableDanhSachPC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableDanhSachPC.setGridColor(new java.awt.Color(153, 153, 153));
        tableDanhSachPC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDanhSachPCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tableDanhSachPCMouseEntered(evt);
            }
        });
        scrollCN.setViewportView(tableDanhSachPC);

        pnLoc.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(255, 255, 255), null, new java.awt.Color(204, 204, 255)), "Lọc theo:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        cbbSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "May", "Cắt", "ủi", "cắt chỉ" }));
        cbbSP.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm"));
        cbbSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSPActionPerformed(evt);
            }
        });

        cbbCD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên CD-Tên SP" }));
        cbbCD.setBorder(javax.swing.BorderFactory.createTitledBorder("Công đoạn"));
        cbbCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbCDActionPerformed(evt);
            }
        });

        cbbTayNghe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Cắt vải", "May vắt sổ", "Đóng gói", "May móc xích kép", "May móc xích đơn", "Là ủi" }));
        cbbTayNghe.setBorder(javax.swing.BorderFactory.createTitledBorder("Tay nghề"));
        cbbTayNghe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTayNgheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnLocLayout = new javax.swing.GroupLayout(pnLoc);
        pnLoc.setLayout(pnLocLayout);
        pnLocLayout.setHorizontalGroup(
            pnLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbTayNghe, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbCD, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbSP, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnLocLayout.setVerticalGroup(
            pnLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLocLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbTayNghe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbCD)
                    .addComponent(cbbSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnXuLy.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, new java.awt.Color(204, 204, 255)), "Xử lý"));

        btnBatDauCC.setBackground(new java.awt.Color(85, 167, 222));
        btnBatDauCC.setForeground(new java.awt.Color(255, 255, 255));
        btnBatDauCC.setText("Điểm danh");
        btnBatDauCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatDauCCActionPerformed(evt);
            }
        });

        btnKetThucCC.setBackground(new java.awt.Color(85, 167, 222));
        btnKetThucCC.setForeground(new java.awt.Color(255, 255, 255));
        btnKetThucCC.setText("Chấm công");
        btnKetThucCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetThucCCActionPerformed(evt);
            }
        });

        btnChonTatCN.setBackground(new java.awt.Color(85, 167, 222));
        btnChonTatCN.setForeground(new java.awt.Color(255, 255, 255));
        btnChonTatCN.setText("<html><center>Chọn<br>tất cả</center></html>");
        btnChonTatCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonTatCNActionPerformed(evt);
            }
        });

        dateChamCong.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null), "Ngày chấm công", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        lbThongBao.setBackground(new java.awt.Color(255, 255, 255));
        lbThongBao.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbThongBao.setForeground(new java.awt.Color(255, 0, 51));
        lbThongBao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnXuLyLayout = new javax.swing.GroupLayout(pnXuLy);
        pnXuLy.setLayout(pnXuLyLayout);
        pnXuLyLayout.setHorizontalGroup(
            pnXuLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnXuLyLayout.createSequentialGroup()
                .addGroup(pnXuLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnXuLyLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lbThongBao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnXuLyLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnChonTatCN, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(dateChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBatDauCC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnKetThucCC)))
                .addContainerGap())
        );
        pnXuLyLayout.setVerticalGroup(
            pnXuLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnXuLyLayout.createSequentialGroup()
                .addGroup(pnXuLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonTatCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnXuLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnKetThucCC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addComponent(btnBatDauCC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbThongBao, javax.swing.GroupLayout.DEFAULT_SIZE, 12, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnTraCuuCC.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, new java.awt.Color(204, 204, 255)), "Tra cứu chấm công"));
        pnTraCuuCC.setPreferredSize(new java.awt.Dimension(419, 65));

        btnXemCong.setBackground(new java.awt.Color(85, 167, 222));
        btnXemCong.setForeground(new java.awt.Color(255, 255, 255));
        btnXemCong.setText("Xem công");
        btnXemCong.setActionCommand("");
        btnXemCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemCongActionPerformed(evt);
            }
        });

        dateBatDauXemCong.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null), "Từ ngày", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        dateKetThucXemCong.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null), "Đến ngày", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        javax.swing.GroupLayout pnTraCuuCCLayout = new javax.swing.GroupLayout(pnTraCuuCC);
        pnTraCuuCC.setLayout(pnTraCuuCCLayout);
        pnTraCuuCCLayout.setHorizontalGroup(
            pnTraCuuCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTraCuuCCLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(dateBatDauXemCong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dateKetThucXemCong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnXemCong)
                .addContainerGap())
        );
        pnTraCuuCCLayout.setVerticalGroup(
            pnTraCuuCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnXemCong, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnTraCuuCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(dateBatDauXemCong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(dateKetThucXemCong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnChinhSuaCC.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, new java.awt.Color(204, 204, 255)), "Chỉnh sửa chấm công"));

        btnXoaCC.setBackground(new java.awt.Color(85, 167, 222));
        btnXoaCC.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaCC.setText("Xóa");
        btnXoaCC.setActionCommand("");
        btnXoaCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCCActionPerformed(evt);
            }
        });

        btnUpdateSPHT.setBackground(new java.awt.Color(85, 167, 222));
        btnUpdateSPHT.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateSPHT.setText("<html><center>Cập nhật<br>Số lượng HT</center></html>");
        btnUpdateSPHT.setToolTipText("");
        btnUpdateSPHT.setActionCommand("");
        btnUpdateSPHT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSPHTActionPerformed(evt);
            }
        });

        spinUpdateSPHT.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null), "Sản phẩm HT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        javax.swing.GroupLayout pnChinhSuaCCLayout = new javax.swing.GroupLayout(pnChinhSuaCC);
        pnChinhSuaCC.setLayout(pnChinhSuaCCLayout);
        pnChinhSuaCCLayout.setHorizontalGroup(
            pnChinhSuaCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChinhSuaCCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnXoaCC, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateSPHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(spinUpdateSPHT, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        pnChinhSuaCCLayout.setVerticalGroup(
            pnChinhSuaCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChinhSuaCCLayout.createSequentialGroup()
                .addComponent(spinUpdateSPHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChinhSuaCCLayout.createSequentialGroup()
                .addGroup(pnChinhSuaCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnUpdateSPHT, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoaCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollCN)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(pnXuLy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollCC)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(pnTraCuuCC, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pnChinhSuaCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(6, 6, 6))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnXuLy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnLoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollCN, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnTraCuuCC, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(pnChinhSuaCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollCC, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pQLChamCongCNLayout = new javax.swing.GroupLayout(pQLChamCongCN);
        pQLChamCongCN.setLayout(pQLChamCongCNLayout);
        pQLChamCongCNLayout.setHorizontalGroup(
            pQLChamCongCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pQLChamCongCNLayout.setVerticalGroup(
            pQLChamCongCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pQLChamCongCNLayout.createSequentialGroup()
                .addComponent(pTittle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 958, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pQLChamCongCN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 735, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pQLChamCongCN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSPActionPerformed
        if (testModelTBPC == 0) {
            modelKTCC.setNumRows(0);
            if (cbbTayNghe.getSelectedItem().toString().equals("Tất cả")) {
                addListKTCC();
                return;
            }
            int stt = 1;
            Date selectedDate = dateChamCong.getDate();
            LocalDate localDateCC = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            // Format ngày tháng năm bằng DateTimeFormatter
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String formattedDateNow = localDateCC.format(formatter);

            for (ChiTietBangChamCong s : bangCCCN_Dao.getAllBangChamCongCongNhanTheoNgay(formattedDateNow, formattedDateNow)) {
                if (s.getBangPC().getCongDoan().getSanPham().getTenSP().equals(cbbSP.getSelectedItem().toString())) {
                    if (s.getBangPC().getSoLuong() - phanCong_Dao.getTongSLHT(s.getBangPC().getMaBangPC()) != 0 && s.getBangCC().getNgayChamCongString().equals(formattedDateNow)) {
                        Boolean chon = true;
                        if (s.getSoLuong() != 0) {
                            chon = false;
                        }
                        modelKTCC.addRow(new Object[]{chon, Integer.toString(stt), s.getBangCC().getCn().getMaCN(), s.getBangCC().getCn().getHoTen(), s.getBangPC().getSoLuong() - phanCong_Dao.getTongSLHT(s.getBangPC().getMaBangPC()), s.getBangPC().getCongDoan().getSanPham().getTenSP(), s.getBangPC().getCongDoan().getTenCD(), s.getSoLuong(), s.getBangPC().getMaBangPC(), s.getBangCC().getMaBangChamCong(), false, false, false});
                        stt++;
                    }
                }
            }
        } else {
            modelDSPC.setNumRows(0);
            String tenCD = modelcbbSanPham.getSelectedItem().toString();
            if (tenCD.equals("Tất cả")) {
                addListPC();
                return;
            }
            int stt = 1;
            for (BangPhanCong s : phanCong_Dao.getAllBangPhanCongChuaHT()) {
                if (modelcbbSanPham.getSelectedItem().toString().equals(s.getCongDoan().getSanPham().getTenSP())) {
                    modelDSPC.addRow(new Object[]{false, Integer.toString(stt), s.getCongNhan().getMaCN(), s.getCongNhan().getHoTen(), s.getCongNhan().getTayNghe(), s.getCongDoan().getTenCD(), Integer.toString(s.getSoLuong()), s.getCongDoan().getSanPham().getTenSP(), Integer.toString(s.getSoLuong() - phanCong_Dao.getTongSLHT(s.getMaBangPC())), s.getMaBangPC()});
                    stt++;
                }
            }
        }
    }//GEN-LAST:event_cbbSPActionPerformed

    private void cbbCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbCDActionPerformed

        if (testModelTBPC == 0) {
            modelKTCC.setNumRows(0);
            if (modelcbbCongDoan.getSelectedItem().toString().equals("Tất cả")) {
                addListKTCC();
                return;
            }
            int stt = 1;
            Date selectedDate = dateChamCong.getDate();
            LocalDate localDateCC = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            // Format ngày tháng năm bằng DateTimeFormatter
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String formattedDateNow = localDateCC.format(formatter);
            String cdSP;
            for (ChiTietBangChamCong s : bangCCCN_Dao.getAllBangChamCongCongNhanTheoNgay(formattedDateNow, formattedDateNow)) {
                cdSP = s.getBangPC().getCongDoan().getTenCD() + "-" + "(" + s.getBangPC().getCongDoan().getSanPham().getTenSP() + ")";
                if (cdSP.equals(cbbCD.getSelectedItem().toString())) {
                    if (s.getBangPC().getSoLuong() - phanCong_Dao.getTongSLHT(s.getBangPC().getMaBangPC()) != 0 && s.getBangCC().getNgayChamCongString().equals(formattedDateNow)) {
                        Boolean chon = true;
                        if (s.getSoLuong() != 0) {
                            chon = false;
                        }
                        modelKTCC.addRow(new Object[]{chon, Integer.toString(stt), s.getBangCC().getCn().getMaCN(), s.getBangCC().getCn().getHoTen(), s.getBangPC().getSoLuong() - phanCong_Dao.getTongSLHT(s.getBangPC().getMaBangPC()), s.getBangPC().getCongDoan().getSanPham().getTenSP(), s.getBangPC().getCongDoan().getTenCD(), s.getSoLuong(), s.getBangPC().getMaBangPC(), s.getBangCC().getMaBangChamCong(), false, false, false});
                        stt++;
                    }
                }
            }
        } else {
            modelDSPC.setNumRows(0);
            if (modelcbbCongDoan.getSelectedItem().toString().equals("Tất cả")) {
                addListPC();
                return;
            }
            int stt = 1;
            String cdSP;
            for (BangPhanCong s : phanCong_Dao.getAllBangPhanCongChuaHT()) {
                cdSP = s.getCongDoan().getTenCD() + "-" + "(" + s.getCongDoan().getSanPham().getTenSP() + ")";
                if (modelcbbCongDoan.getSelectedItem().toString().equals(cdSP)) {
                    modelDSPC.addRow(new Object[]{false, Integer.toString(stt), s.getCongNhan().getMaCN(), s.getCongNhan().getHoTen(), s.getCongNhan().getTayNghe(), s.getCongDoan().getTenCD(), Integer.toString(s.getSoLuong()), s.getCongDoan().getSanPham().getTenSP(), Integer.toString(s.getSoLuong() - phanCong_Dao.getTongSLHT(s.getMaBangPC())), s.getMaBangPC()});
                    stt++;
                }
            }
        }

    }//GEN-LAST:event_cbbCDActionPerformed

    private void cbbTayNgheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTayNgheActionPerformed

        if (testModelTBPC == 0) {
            modelKTCC.setNumRows(0);
            if (cbbTayNghe.getSelectedItem().toString().equals("Tất cả")) {
                addListKTCC();
                return;
            }
            int stt = 1;
            Date selectedDate = dateChamCong.getDate();
            LocalDate localDateCC = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            // Format ngày tháng năm bằng DateTimeFormatter
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String formattedDateNow = localDateCC.format(formatter);
            for (ChiTietBangChamCong s : bangCCCN_Dao.getAllBangChamCongCongNhanTheoNgay(formattedDateNow, formattedDateNow)) {
                if (s.getBangCC().getCn().getTayNghe().equals(cbbTayNghe.getSelectedItem().toString())) {
                    if (s.getBangPC().getSoLuong() - phanCong_Dao.getTongSLHT(s.getBangPC().getMaBangPC()) != 0 && s.getBangCC().getNgayChamCongString().equals(formattedDateNow)) {
                        Boolean chon = true;
                        if (s.getSoLuong() != 0) {
                            chon = false;
                        }
                        modelKTCC.addRow(new Object[]{chon, Integer.toString(stt), s.getBangCC().getCn().getMaCN(), s.getBangCC().getCn().getHoTen(), s.getBangPC().getSoLuong() - phanCong_Dao.getTongSLHT(s.getBangPC().getMaBangPC()), s.getBangPC().getCongDoan().getSanPham().getTenSP(), s.getBangPC().getCongDoan().getTenCD(), s.getSoLuong(), s.getBangPC().getMaBangPC(), s.getBangCC().getMaBangChamCong(), false, false, false});
                        stt++;
                    }
                }
            }
        } else {
            modelDSPC.setNumRows(0);
            if (cbbTayNghe.getSelectedItem().toString().equals("Tất cả")) {
                addListPC();
                return;
            }
            int stt = 1;
            for (BangPhanCong s : phanCong_Dao.getAllBangPhanCongChuaHT()) {
                if (s.getCongNhan().getTayNghe().equalsIgnoreCase(cbbTayNghe.getSelectedItem().toString())) {
                    modelDSPC.addRow(new Object[]{false, Integer.toString(stt), s.getCongNhan().getMaCN(), s.getCongNhan().getHoTen(), s.getCongNhan().getTayNghe(), s.getCongDoan().getTenCD(), Integer.toString(s.getSoLuong()), s.getCongDoan().getSanPham().getTenSP(), Integer.toString(s.getSoLuong() - phanCong_Dao.getTongSLHT(s.getMaBangPC())), s.getMaBangPC()});
                    stt++;
                }
            }
        }

    }//GEN-LAST:event_cbbTayNgheActionPerformed

    private void btnBatDauCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatDauCCActionPerformed
        lbThongBao.setText("");
        int temp = 0;
        if (btnBatDauCC.getText().equals("<html><center>Hủy<br>chấm công</center></html>")) {
            btnBatDauCC.setText("Điểm danh");
            btnKetThucCC.setText("Chấm công");
            listKTCC.clear();
            addListPC();
            return;
        } else {
            Date selectedDate = dateChamCong.getDate();
            // Phân tích giá trị thành ngày, tháng, năm
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(selectedDate);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = sdf.format(selectedDate);
            LocalDateTime localDateTime = convertToLocalDateTime(dateChamCong.getDate());
            int rows = modelDSPC.getRowCount();
            BangChamCongCongNhan ccCN = null;
            ChiTietBangChamCong ctCC = null;
            boolean checkChon = false;
            boolean selected;
            for (int i = 0; i < rows; i++) {
                selected = (boolean) modelDSPC.getValueAt(i, 0);
                if (selected) {
                    checkChon = true;
                    if (bangCCCN_Dao.checkBangChamCongTrongNgay(modelDSPC.getValueAt(i, 9).toString(), formattedDate)) { //check Công nhân đã được điểm danh chưa.
                        JOptionPane.showMessageDialog(null, "Phân công " + modelDSPC.getValueAt(i, 3).toString() + "trong công đoạn " + modelDSPC.getValueAt(i, 5).toString() + " Đã được điểm danh");
                        continue;
                    }
                    ccCN = new BangChamCongCongNhan(getMaCCNew(), LocalTime.now(), LocalTime.of(0, 0, 0), localDateTime, null, congNhan_Dao.getCongNhanTheoMa(modelDSPC.getValueAt(i, 2).toString()));
                    ctCC = new ChiTietBangChamCong(0, phanCong_Dao.getBangPhanCongTheoMa(modelDSPC.getValueAt(i, 9).toString()), ccCN);
                    if (bangCCCN_Dao.createBangChamCongCongNhan(ccCN)) {
                        if (ctBangCC_Dao.createChiTietBangChamCong(ctCC)) {
                            temp = 1;
                        } else {
                            lbThongBao.setText("tạo CT Chấm công thất bại");
                        }
                    } else {
                        lbThongBao.setText("điểm danh " + ccCN.getCn().getHoTen() + "thất bại");
                    }
                }
            }
            if (temp == 1) {
//                addListChamCong();
                lbThongBao.setText("Đã ghi nhận công nhân có mặt");
            } else if (!checkChon) {
                lbThongBao.setText("Chưa chọn phân công");
            }

        }
    }//GEN-LAST:event_btnBatDauCCActionPerformed

    private static LocalDateTime convertToLocalDateTime(Date date) {
        if (date != null) {
            // Chuyển Date sang Instant
            // ZoneId.systemDefault() lấy múi giờ mặc định của hệ thống
            Instant instant = date.toInstant();

            // Chuyển từ Instant sang LocalDateTime
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

            return localDateTime;
        }
        return null;
    }
    private void btnKetThucCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucCCActionPerformed
        lbThongBao.setText("");
        if (btnKetThucCC.getText().equals("Chấm công")) {
            if (addListKTCC()) {
                btnKetThucCC.setText("<html><center>Lưu<br>chấm công</center></html>");
                btnBatDauCC.setText("<html><center>Hủy<br>chấm công</center></html>");
                // Lấy TableColumnModel của JTable

                modelKTCC.addTableModelListener(new TableModelListener() {
                    @Override
                    public void tableChanged(TableModelEvent e) {
                        if (e.getType() == TableModelEvent.UPDATE) {
                            lbThongBao.setText("");
                            int row = e.getFirstRow();
                            int column = e.getColumn();
                            if (column == 10 || column == 11 || column == 12) {
                                Boolean newValue = (Boolean) modelKTCC.getValueAt(row, column);
                                if (newValue) {// Nếu ô checkbox được chọn, hủy chọn các ô checkbox khác trong cùng một hàng
                                    for (int i = 10; i < 13; i++) {
                                        if (i != column) {
                                            modelKTCC.setValueAt(false, row, i);
                                        }
                                    }
                                }
                            } else if (column == 7) {
                                if (Integer.parseInt(modelKTCC.getValueAt(row, 7).toString()) > 0) {
                                    if (Integer.parseInt(modelKTCC.getValueAt(row, 7).toString()) > Integer.parseInt(modelKTCC.getValueAt(row, 4).toString())) {
                                        lbThongBao.setText("Số lượng HT lớn hơn số lượng còn.");
                                        tableDanhSachPC.isCellEditable(row, 7);
                                        tableDanhSachPC.changeSelection(row, 7, false, false);
                                    }
                                } else {
                                    lbThongBao.setText("Số lượng HT không hợp lệ.");
                                    tableDanhSachPC.isCellSelected(row, 7);
                                    tableDanhSachPC.changeSelection(row, 7, false, false);
                                }
                            }
                        }
                    }

                }
                );
            }
        } else if (btnKetThucCC.getText().equals("<html><center>Lưu<br>chấm công</center></html>")) {
            Boolean testCCTC = false;
            int rows = modelKTCC.getRowCount();
            LocalTime startTime1 = LocalTime.of(6, 30);
            LocalTime endTime1 = LocalTime.of(12, 30);
            LocalTime startTime2 = LocalTime.of(12, 30);
            LocalTime endTime2 = LocalTime.of(17, 30);
            int test = 0;
            BangChamCongCongNhan ccCNTC = null;
            BangChamCongCongNhan ccCN = null;
            ChiTietBangChamCong ctcc = null;
            String caLam = "";
            System.out.println(1);
            Boolean TC;
            for (int i = 0; i < rows; i++) {
                TC = false;
                if (Boolean.valueOf((boolean) modelKTCC.getValueAt(i, 0))) {
                    testCCTC = true;
                    ccCN = bangCCCN_Dao.getBangChamCongCongNhanTheoMa(modelKTCC.getValueAt(i, 9).toString());
                    ccCN.setGioRa(LocalTime.now());
                    System.out.println(1.1);
                    if (Boolean.valueOf((boolean) modelKTCC.getValueAt(i, 10))) {
                        caLam = "ca 3";
                        TC = true;
                    } else if (Boolean.valueOf((boolean) modelKTCC.getValueAt(i, 11))) {
                        caLam = "ca CN";
                        TC = true;

                    } else if (Boolean.valueOf((boolean) modelKTCC.getValueAt(i, 12))) {
                        caLam = "ca lễ";
                        TC = true;
                    } else {
                        if (ccCN.getGioVao().isAfter(startTime1) && ccCN.getGioRa().isBefore(endTime1)) {
                            caLam = "ca 1";
                        } else if (ccCN.getGioVao().isAfter(startTime2) && ccCN.getGioRa().isBefore(endTime2)) {
                            caLam = "ca 2";
                        } else if (ccCN.getGioVao().isAfter(startTime1) && ccCN.getGioRa().isBefore(endTime2)) {
                            caLam = "ca 1, ca 2";
                        }
                    }
                    if (TC) {
                        ccCNTC = new BangChamCongCongNhan(getMaCCNew(), ccCN.getGioVao(), ccCN.getGioRa(), ccCN.getNgayChamCong(), caLam, ccCN.getCn());
                        bangCCCN_Dao.createBangChamCongCongNhan(ccCNTC);
                        ctcc = new ChiTietBangChamCong(Integer.valueOf(modelKTCC.getValueAt(i, 7).toString()), phanCong_Dao.getBangPhanCongTheoMa(modelKTCC.getValueAt(i, 8).toString()), ccCNTC);
                        ctBangCC_Dao.createChiTietBangChamCong(ctcc);
                        test = 1;
                    } else if (!TC) {
                        System.out.println(1.2);
                        ccCN.setCaLamViec(caLam);
                        bangCCCN_Dao.updateBangChamCongCongNhan(ccCN);
                        ctcc = new ChiTietBangChamCong(Integer.valueOf(modelKTCC.getValueAt(i, 7).toString()), phanCong_Dao.getBangPhanCongTheoMa(modelKTCC.getValueAt(i, 8).toString()), ccCN);
                        System.out.println(1.3);
                        if (ctBangCC_Dao.updateChiTietBangChamCong(ctcc)) {
                            test = 1;
                            System.out.println(1.4);
                            updateTinhTrangHTCD(ctcc.getBangPC().getCongDoan().getMaCD(),Integer.parseInt(modelKTCC.getValueAt(i, 7).toString()));
                            System.out.println(1.5);
                        } else {
                            JOptionPane.showMessageDialog(null, "chấm công bảng chấm công: " + ctcc.getBangCC().getMaBangChamCong() + "thất bại");
                        }
                    }
                }
            }

            if (!testCCTC) {
                lbThongBao.setText("Chưa chọn công nhân!");
                return;
            }
            if (test == 1) {
                btnKetThucCC.setText("Chấm công");
                lbThongBao.setText("chấm công thành công");
                btnBatDauCC.setText("Điểm danh");
//                addListChamCong();
                addListPC();
            }
        }

    }//GEN-LAST:event_btnKetThucCCActionPerformed
    private String getMaCCNew() {
        Date selectedDate = dateChamCong.getDate();
        // Phân tích giá trị thành ngày, tháng, năm
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(selectedDate);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1; // Tháng bắt đầu từ 0
        int year = calendar.get(Calendar.YEAR);
        String nowMonth = String.format("%02d", month);
        String nowDay = String.format("%02d", day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(selectedDate);
        LocalDateTime localDateTime = convertToLocalDateTime(dateChamCong.getDate());

        String maBangCCMoiNhat = bangCCCN_Dao.getBangChamCongMoiNhat(formattedDate).getMaBangChamCong();
        String ngayThangNamHTai = Integer.toString(year % 100) + nowMonth + nowDay;
        int bonSoCuoiMaBangPCMoiNhat = 1;
        if (maBangCCMoiNhat != null) {
            if (maBangCCMoiNhat.substring(0, 6).equals(ngayThangNamHTai)) {
                bonSoCuoiMaBangPCMoiNhat = Integer.valueOf(maBangCCMoiNhat.substring(maBangCCMoiNhat.length() - 4)) + 1;
            }
        }
        String ddddMa = String.format("%04d", bonSoCuoiMaBangPCMoiNhat);
        String maBangPCNew = ngayThangNamHTai + ddddMa;
        return maBangPCNew;
    }
    private void btnChonTatCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonTatCNActionPerformed
        int rows = modelDSPC.getRowCount();
        if (btnChonTatCN.getText().equals("<html><center>Chọn<br>tất cả</center></html>")) {
            if (testModelTBPC != 0) {
                for (int i = 0; i < rows; i++) {
                    modelDSPC.setValueAt(true, i, 0);
                }
            } else {
                for (int i = 0; i < modelKTCC.getRowCount(); i++) {
                    modelKTCC.setValueAt(true, i, 0);
                }
            }

            btnChonTatCN.setText("<html><center>Bỏ chọn<br>tất cả</center></html>");
        } else if (btnChonTatCN.getText().equals("<html><center>Bỏ chọn<br>tất cả</center></html>")) {
            if (testModelTBPC != 0) {
                for (int i = 0; i < rows; i++) {
                    modelDSPC.setValueAt(false, i, 0);
                }
            } else {
                for (int i = 0; i < modelKTCC.getRowCount(); i++) {
                    modelKTCC.setValueAt(false, i, 0);

                }
            }
            btnChonTatCN.setText("<html><center>Chọn<br>tất cả</center></html>");
        }
    }//GEN-LAST:event_btnChonTatCNActionPerformed

    private void btnXemCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemCongActionPerformed
        modelDSCC.setNumRows(0);
        Date tuNgayDate = dateBatDauXemCong.getDate();
        Date denNgayDate = dateKetThucXemCong.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ngayBD = sdf.format(tuNgayDate);
        String ngayKT = sdf.format(denNgayDate);

        int stt = 1;
        CongNhan cn;
        for (ChiTietBangChamCong s : bangCCCN_Dao.getAllBangChamCongCongNhanTheoNgay(ngayBD, ngayKT)) {
            cn = s.getBangPC().getCongNhan();
            String[] row = {Integer.toString(stt), cn.getMaCN(), cn.getHoTen(), s.getBangCC().getNgayChamCongString(), s.getBangCC().getGioVaoString(), s.getBangCC().getGioRaString(), s.getBangPC().getCongDoan().getSanPham().getTenSP(), s.getBangPC().getCongDoan().getTenCD(), s.getBangCC().getCaLamViec(), Integer.toString(s.getSoLuong()), s.getBangPC().getMaBangPC(), s.getBangCC().getMaBangChamCong(), Integer.toString(s.getBangPC().getSoLuong() - phanCong_Dao.getTongSLHT(s.getBangPC().getMaBangPC()))};
            modelDSCC.addRow(row);
            stt++;
        }
        TableColumnModel columnModel = tableChamCong.getColumnModel();

        // Ẩn cột ở vị trí cột thứ 10 (Mã PC)
        int columnIndexToHide = 10;
        TableColumn column = columnModel.getColumn(columnIndexToHide);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setWidth(0);
        column.setPreferredWidth(0);
        column.setResizable(false);

        // Ẩn cột ở vị trí cột thứ 11 (Mã CC)
        int columnIndexToHide9 = 11;
        TableColumn column9 = columnModel.getColumn(columnIndexToHide9);
        column9.setMinWidth(0);
        column9.setMaxWidth(0);
        column9.setWidth(0);
        column9.setPreferredWidth(0);
        column9.setResizable(false);
    }//GEN-LAST:event_btnXemCongActionPerformed

    private void btnXoaCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCCActionPerformed
        if (tableChamCong.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn chấm công cần xoá");
        } else {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Chắc chắn xóa chấm công của " + modelDSCC.getValueAt(tableChamCong.getSelectedRow(), 2).toString(), "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                if (ctBangCC_Dao.xoaCTCC(modelDSCC.getValueAt(tableChamCong.getSelectedRow(), 10).toString(), modelDSCC.getValueAt(tableChamCong.getSelectedRow(), 11).toString())) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công!");
                    addListChamCong();
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại");
                }
            }
        }
    }//GEN-LAST:event_btnXoaCCActionPerformed

    private void btnXNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXNCCActionPerformed
        if (!isValidValue()) {
            lbTBKTCC.setText("Số lượng HT không hợp lệ");
        }
        if (spinSLHT.equals(0))
            lbTBKTCC.setText("Số lượng HT phải lớn hơn 0.");
        else {
            String calam;
            if (rbtCN.isSelected()) {
                calam = "Chủ nhật";
            } else if (rbtCa3.isSelected()) {
                calam = "Ca 3";
            } else if (rbtLe.isSelected()) {
                calam = "Lễ";
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            for (ChiTietBangChamCong s : ctBangCC_Dao.getAllChiTietBangChamCong()) {
                if (s.getBangCC().getMaBangChamCong().equals(lbMaBangCTCC.getText().substring(0, 10)) && s.getBangPC().getMaBangPC().equals(lbMaBangCTCC.getText().substring(11))) {
                    BangChamCongCongNhan ccNew = s.getBangCC();
                    ccNew.setGioRa(LocalTime.parse(txtTimeHT.getText()));
                    ChiTietBangChamCong ctNew = new ChiTietBangChamCong(spinSLHT.getValue(), s.getBangPC(), ccNew);
                    if (ctBangCC_Dao.updateChiTietBangChamCong(ctNew)) {
                        lbThongBao.setText("Kết thúc chấm công thành công");
                    }// giờ ra kh update
                }
            }
            addListChamCong();
        }
    }//GEN-LAST:event_btnXNCCActionPerformed

    private void rbtLeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtLeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtLeActionPerformed

    private void rbtCa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtCa3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtCa3ActionPerformed

    private void rbtCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtCNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtCNActionPerformed

    private void txtTimeHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimeHTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimeHTActionPerformed

    private void btnHuyXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyXoaActionPerformed
        comfirmDelete.setVisible(true);
    }//GEN-LAST:event_btnHuyXoaActionPerformed

    private void btnXacNhanXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanXoaActionPerformed
        if (ctBangCC_Dao.xoaCTCC(modelDSCC.getValueAt(tableChamCong.getSelectedRow(), 10).toString(), modelDSCC.getValueAt(tableChamCong.getSelectedRow(), 11).toString())) {
            comfirmDelete.setVisible(false);
            lbThongBao.setText("Xóa thành công!");
        } else {
            comfirmDelete.setVisible(false);
            lbThongBao.setText("Xóa thất bại");
        }
    }//GEN-LAST:event_btnXacNhanXoaActionPerformed

    private void btnUpdateSPHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSPHTActionPerformed
        if (tableChamCong.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn phân công cần update");
        } else {
            ChiTietBangChamCong ctcc = new ChiTietBangChamCong(spinUpdateSPHT.getValue(), phanCong_Dao.getBangPhanCongTheoMa(modelDSCC.getValueAt(tableChamCong.getSelectedRow(), 10).toString()), bangCCCN_Dao.getBangChamCongCongNhanTheoMa(modelDSCC.getValueAt(tableChamCong.getSelectedRow(), 11).toString()));
            if (ctBangCC_Dao.updateChiTietBangChamCong(ctcc)) {
                JOptionPane.showMessageDialog(null, "update thành công");
                addListChamCong();
            } else {
                JOptionPane.showMessageDialog(null, "update thất bại");
            }
        }
    }//GEN-LAST:event_btnUpdateSPHTActionPerformed

    private void tableChamCongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableChamCongMouseClicked
//        private void tableCongNhanMouseClicked(java.awt.event.MouseEvent evt) {
        int slHT = Integer.valueOf(modelDSCC.getValueAt(tableChamCong.getSelectedRow(), 9).toString());
        spinUpdateSPHT.setValue(slHT);
//    }

    }//GEN-LAST:event_tableChamCongMouseClicked

    private void tableDanhSachPCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDanhSachPCMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tableDanhSachPCMouseEntered

    private void tableDanhSachPCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDanhSachPCMouseClicked
        if (testModelTBPC == 1) {
            if (tableDanhSachPC.getSelectedColumn() == 0) {
                return;
            }
            if (modelDSPC.getValueAt(tableDanhSachPC.getSelectedRow(), 0).equals(true)) {
                modelDSPC.setValueAt(false, tableDanhSachPC.getSelectedRow(), 0);
            } else {
                modelDSPC.setValueAt(true, tableDanhSachPC.getSelectedRow(), 0);
            }
        }
    }//GEN-LAST:event_tableDanhSachPCMouseClicked

    private void tableChamCongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableChamCongKeyReleased
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN) {
            // Xử lý khi mũi tên lên hoặc mũi tên xuống được nhấn
            int slHT = Integer.valueOf(modelDSCC.getValueAt(tableChamCong.getSelectedRow(), 9).toString());
            spinUpdateSPHT.setValue(slHT);
        }
    }//GEN-LAST:event_tableChamCongKeyReleased
    private boolean isValidValue() {
        try {
            // Kiểm tra xem giá trị của spinner có thể chuyển đổi thành số hay không
            Integer.parseInt(Integer.toString(spinSLHT.getValue()));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void addCBB() {
        modelcbbCongDoan = new DefaultComboBoxModel<String>();
        modelcbbCongDoan.addElement("Tất cả");
        for (CongDoan s : congDoan_Dao.getAllCongDoanTheoTrangThai()) {
            modelcbbCongDoan.addElement("" + s.getTenCD() + "-(" + s.getSanPham().getTenSP() + ")");
        }
        cbbCD.setModel(modelcbbCongDoan);

        modelcbbSanPham = new DefaultComboBoxModel<String>();
        modelcbbSanPham.addElement("Tất cả");
        for (SanPham s : sanPham_Dao.getAllSanPham()) {
            modelcbbSanPham.addElement("" + s.getTenSP());
        }
        cbbSP.setModel(modelcbbSanPham);
    }

    private void addListPC() {

        testModelTBPC = 1;
        modelDSPC = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return String.class;
                    case 5:
                        return String.class;
                    case 6:
                        return String.class;
                    case 7:
                        return String.class;
                    case 8:
                        return String.class;
                    case 9:
                        return String.class;
                    default:
                        throw new AssertionError();
                }
            }
        };
        modelDSPC.addColumn("Chọn");
        modelDSPC.addColumn("STT");
        modelDSPC.addColumn("Mã công nhân");
        modelDSPC.addColumn("Tên công nhân");
        modelDSPC.addColumn("Tay nghề");
        modelDSPC.addColumn("Công đoạn");
        modelDSPC.addColumn("SL phân công");
        modelDSPC.addColumn("Sản phẩm");
        modelDSPC.addColumn("SL còn");
        modelDSPC.addColumn("Mã phân công");
        tableDanhSachPC.setModel(modelDSPC);
        tableDanhSachPC.getColumnModel().getColumn(0).setPreferredWidth(5);
        tableDanhSachPC.getColumnModel().getColumn(1).setPreferredWidth(5);
        tableDanhSachPC.getColumnModel().getColumn(6).setPreferredWidth(50);
        tableDanhSachPC.getColumnModel().getColumn(8).setPreferredWidth(40);
        int stt = 1;
        for (BangPhanCong s : phanCong_Dao.getAllBangPhanCongChuaHT()) {
            modelDSPC.addRow(new Object[]{true, Integer.toString(stt), s.getCongNhan().getMaCN(), s.getCongNhan().getHoTen(), s.getCongNhan().getTayNghe(), s.getCongDoan().getTenCD(), Integer.toString(s.getSoLuong()), s.getCongDoan().getSanPham().getTenSP(), Integer.toString(s.getSoLuong() - phanCong_Dao.getTongSLHT(s.getMaBangPC())), s.getMaBangPC()});
            stt++;
        }
    }

    private Boolean addListKTCC() {
//        cbbCD.setSelectedIndex(0);
//        cbbSP.setSelectedIndex(0);
//        cbbTayNghe.setSelectedIndex(0);

        testModelTBPC = 0;
        modelKTCC = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return String.class;
                    case 5:
                        return String.class;
                    case 6:
                        return int.class;
                    case 7:
                        return String.class;
                    case 8:
                        return String.class;
                    case 9:
                        return String.class;
                    case 10:
                        return Boolean.class;
                    case 11:
                        return Boolean.class;
                    case 12:
                        return Boolean.class;
                    default:
                        throw new AssertionError();
                }
            }
        };
        modelKTCC.addColumn("Chọn");
        modelKTCC.addColumn("STT");
        modelKTCC.addColumn("Mã công nhân");
        modelKTCC.addColumn("Tên công nhân");
        modelKTCC.addColumn("SL chưa HT");
        modelKTCC.addColumn("Sản phẩm HT");
        modelKTCC.addColumn("Công đoạn HT");
        modelKTCC.addColumn("Số lượng HT");
        modelKTCC.addColumn("Mã PC");
        modelKTCC.addColumn("Mã CC");
        modelKTCC.addColumn("ca 3");
        modelKTCC.addColumn("ca CN");
        modelKTCC.addColumn("ca Lễ");

        tableDanhSachPC.setModel(modelKTCC);
        tableDanhSachPC.getColumnModel().getColumn(0).setPreferredWidth(5);
        tableDanhSachPC.getColumnModel().getColumn(1).setPreferredWidth(5);
        tableDanhSachPC.getColumnModel().getColumn(6).setPreferredWidth(50);
        tableDanhSachPC.getColumnModel().getColumn(10).setPreferredWidth(5);
        tableDanhSachPC.getColumnModel().getColumn(11).setPreferredWidth(5);
        tableDanhSachPC.getColumnModel().getColumn(12).setPreferredWidth(5);

        int stt = 1;
        Date selectedDate = dateChamCong.getDate();
        // Format ngày tháng năm bằng DateTimeFormatter
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDateNow = dateFormat.format(selectedDate);
        Boolean chon = true;
        int tongSLHT = 0;
        for (ChiTietBangChamCong s : bangCCCN_Dao.getAllBangChamCongCongNhanTheoNgay(formattedDateNow, formattedDateNow)) {
            tongSLHT = phanCong_Dao.getTongSLHT(s.getBangPC().getMaBangPC());
            if (s.getBangPC().getSoLuong() - tongSLHT != 0) {
                if (s.getSoLuong() != 0) {
                    chon = false;
                } else {
                    chon = true;
                }
                modelKTCC.addRow(new Object[]{chon, Integer.toString(stt), s.getBangCC().getCn().getMaCN(), s.getBangCC().getCn().getHoTen(), s.getBangPC().getSoLuong() - tongSLHT, s.getBangPC().getCongDoan().getSanPham().getTenSP(), s.getBangPC().getCongDoan().getTenCD(), s.getSoLuong(), s.getBangPC().getMaBangPC(), s.getBangCC().getMaBangChamCong(), false, false, false});
                stt++;
            }
        }

        if (stt == 1) {
            lbThongBao.setText("Chưa bắt đầu chấm công trong ngày.");
            addListPC();
            return false;
        }
        TableColumnModel columnModel = tableDanhSachPC.getColumnModel();

        // Ẩn cột ở vị trí cột thứ 8 (Mã PC)
        int columnIndexToHide = 8;
        TableColumn column = columnModel.getColumn(columnIndexToHide);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setWidth(0);
        column.setPreferredWidth(0);
        column.setResizable(false);

        // Ẩn cột ở vị trí cột thứ 9 (Mã CC)
        int columnIndexToHide9 = 9;
        TableColumn column9 = columnModel.getColumn(columnIndexToHide9);
        column9.setMinWidth(0);
        column9.setMaxWidth(0);
        column9.setWidth(0);
        column9.setPreferredWidth(0);
        column9.setResizable(false);
        return true;
    }

    private void addListChamCong() {
        String[] row1 = {"STT", "Mã công nhân", "Tên công nhân", "Ngày chấm", "Giờ vào", "Giờ ra", "Sản phẩm HT", "Công đoạn HT", "Ca làm", "Số lượng HT", "maPC", "maCC", "SL còn"};
        modelDSCC = new DefaultTableModel(row1, 0);
        tableChamCong.setModel(modelDSCC);
        tableChamCong.getColumnModel().getColumn(0).setPreferredWidth(10);
        int stt = 1;
        CongNhan cn;

        Date selectedDate = dateChamCong.getDate();
        // Phân tích giá trị thành ngày, tháng, năm
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // Format ngày tháng năm bằng DateTimeFormatter
        String formattedDate = sdf.format(selectedDate);
        for (ChiTietBangChamCong s : bangCCCN_Dao.getAllBangChamCongCongNhanTheoNgayChamCong(formattedDate)) {
            cn = s.getBangPC().getCongNhan();
            String[] row = {Integer.toString(stt), cn.getMaCN(), cn.getHoTen(), s.getBangCC().getNgayChamCongString(), s.getBangCC().getGioVaoString(), s.getBangCC().getGioRaString(), s.getBangPC().getCongDoan().getSanPham().getTenSP(), s.getBangPC().getCongDoan().getTenCD(), s.getBangCC().getCaLamViec(), Integer.toString(s.getSoLuong()), s.getBangPC().getMaBangPC(), s.getBangCC().getMaBangChamCong(), Integer.toString(s.getBangPC().getSoLuong() - phanCong_Dao.getTongSLHT(s.getBangPC().getMaBangPC()))};
            modelDSCC.addRow(row);
            stt++;
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tableChamCong.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        TableColumnModel columnModel = tableChamCong.getColumnModel();

        // Ẩn cột ở vị trí cột thứ 10 (Mã PC)
        int columnIndexToHide = 10;
        TableColumn column = columnModel.getColumn(columnIndexToHide);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setWidth(0);
        column.setPreferredWidth(0);
        column.setResizable(false);

        // Ẩn cột ở vị trí cột thứ 11 (Mã CC)
        int columnIndexToHide9 = 11;
        TableColumn column9 = columnModel.getColumn(columnIndexToHide9);
        column9.setMinWidth(0);
        column9.setMaxWidth(0);
        column9.setWidth(0);
        column9.setPreferredWidth(0);
        column9.setResizable(false);
    }

    private boolean updateTinhTrangHTCD(String maCD, int slHT) {
        int tongSLHT = phanCong_Dao.getTongSLHTCuaCD(maCD)+slHT;
        CongDoan cd = congDoan_Dao.getCongDoanTheoMa(maCD);
        if (cd.getSoLuong()-tongSLHT <= cd.getSoLuong()*0.025) {
            cd.setTrangThai(3);
            if (congDoan_Dao.updateCongDoan(cd)) {
                JOptionPane.showMessageDialog(null, "Công đoạn: " + cd.getTenCD() + "-" + cd.getSanPham().getTenSP() + " đã được hoàn thành.");
                return true;
            }
        }
        return false;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatDauCC;
    private javax.swing.JButton btnChonTatCN;
    private javax.swing.JButton btnHuyXoa;
    private javax.swing.JButton btnKetThucCC;
    private javax.swing.JButton btnUpdateSPHT;
    private javax.swing.JButton btnXNCC;
    private javax.swing.JButton btnXacNhanXoa;
    private javax.swing.JButton btnXemCong;
    private javax.swing.JButton btnXoaCC;
    private javax.swing.JComboBox<String> cbbCD;
    private javax.swing.JComboBox<String> cbbSP;
    private javax.swing.JComboBox<String> cbbTayNghe;
    private javax.swing.JDialog comfirmCC;
    private javax.swing.JDialog comfirmDelete;
    private com.toedter.calendar.JDateChooser dateBatDauXemCong;
    private com.toedter.calendar.JDateChooser dateChamCong;
    private com.toedter.calendar.JDateChooser dateKetThucXemCong;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbCN;
    private javax.swing.JLabel lbMaBangCTCC;
    private javax.swing.JLabel lbTBKTCC;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JLabel lbXacNhanXoa;
    private javax.swing.JLabel lbttCN;
    private javax.swing.JPanel pQLChamCongCN;
    private javax.swing.JPanel pTittle;
    private javax.swing.JPanel pnChinhSuaCC;
    private javax.swing.JPanel pnLoc;
    private javax.swing.JPanel pnTraCuuCC;
    private javax.swing.JPanel pnValue;
    private javax.swing.JPanel pnXuLy;
    private javax.swing.JPanel pnttCN;
    private javax.swing.JRadioButton rbtCN;
    private javax.swing.JRadioButton rbtCa3;
    private javax.swing.JRadioButton rbtLe;
    private javax.swing.JScrollPane scrollCC;
    private javax.swing.JScrollPane scrollCN;
    private com.toedter.components.JSpinField spinSLHT;
    private com.toedter.components.JSpinField spinUpdateSPHT;
    private javax.swing.JTable tableChamCong;
    private javax.swing.JTable tableDanhSachPC;
    private javax.swing.JTextField txtCD;
    private javax.swing.JTextField txtSP;
    private javax.swing.JTextField txtTimeHT;
    // End of variables declaration//GEN-END:variables

    private DefaultTableModel modelDSPC;
    private DefaultTableModel modelKTCC;
    private DefaultTableModel modelDSCC;
    private DefaultComboBoxModel<String> modelcbbCongDoan;
    private DefaultComboBoxModel<String> modelcbbSanPham;
    private SpinnerModel modelSpnSLHT;
    private ArrayList<ChiTietBangChamCong> listKTCC;

    private BangPhanCong_DAO phanCong_Dao;
    private CongNhan_DAO congNhan_Dao;
    private CongDoan_DAO congDoan_Dao;
    private SanPham_DAO sanPham_Dao;
    private BangChamCongCongNhan_DAO bangCCCN_Dao;
    private ChiTietBangChamCong_DAO ctBangCC_Dao;

    private int testModelTBPC = 0;
}
