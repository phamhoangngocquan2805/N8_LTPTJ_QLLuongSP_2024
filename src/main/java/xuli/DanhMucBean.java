/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xuli;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author QuanAB
 */
public class DanhMucBean {
    private String loaiDanhMuc;
    private JPanel panel;
    private JLabel lbl;

    public String getLoaiDanhMuc() {
        return loaiDanhMuc;
    }

    public void setLoaiDanhMuc(String loaiDanhMuc) {
        this.loaiDanhMuc = loaiDanhMuc;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JLabel getLbl() {
        return lbl;
    }

    public void setLbl(JLabel lbl) {
        this.lbl = lbl;
    }

    public DanhMucBean(String loaiDanhMuc, JPanel panel, JLabel lbl) {
        this.loaiDanhMuc = loaiDanhMuc;
        this.panel = panel;
        this.lbl = lbl;
    }

    public DanhMucBean() {
    }
    
    
}
