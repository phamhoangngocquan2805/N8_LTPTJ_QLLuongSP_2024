package gui;
import gui.GDChinh;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App_TinhLuongThinhVuong extends JFrame {
	
    private static final long serialVersionUID = 1L;
    private JLabel label;
    private JProgressBar progressBar;

	public App_TinhLuongThinhVuong() {
        // Táº¡o má»™t cá»­a sá»• má»›i
        JWindow window = new JWindow();
        window.setLayout(new BorderLayout());

        // Táº¡o má»™t nhÃ£n má»›i
        label = new JLabel();

        // Táº¡o má»™t biá»ƒu tÆ°á»£ng má»›i vá»›i hÃ¬nh áº£nh cá»§a báº¡n
		ImageIcon hinhgt= new ImageIcon(getClass().getResource("/image/login.jpg"));
		Image image = hinhgt.getImage();
		Image newImage = image.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH);
		hinhgt = new ImageIcon(newImage);

        // Thiáº¿t láº­p biá»ƒu tÆ°á»£ng cho nhÃ£n
		label.setIcon(hinhgt);

        // ThÃªm nhÃ£n vÃ o cá»­a sá»•
        window.getContentPane().add(label, BorderLayout.CENTER);

        // Táº¡o thanh tiáº¿n trÃ¬nh
        progressBar = new JProgressBar();
        progressBar.setMinimum(0);
        progressBar.setMaximum(10);
        window.getContentPane().add(progressBar, BorderLayout.SOUTH);

        // Ä�áº·t kÃ­ch thÆ°á»›c vÃ  vá»‹ trÃ­ cá»§a cá»­a sá»•
        window.setBounds(450, 150, 400, 400);
        window.setVisible(true);

        // Cáº­p nháº­t thanh tiáº¿n trÃ¬nh
        for (int i = 0; i <= 10; i++) {
            final int progress = i;
            try {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        progressBar.setValue(progress);
                    }
                });
                Thread.sleep(70); // Ä�á»£i 70ms trÆ°á»›c khi cáº­p nháº­t tiáº¿p
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // áº¨n cá»­a sá»• sau khi thá»�i gian chá»� káº¿t thÃºc
        window.setVisible(false);

        // Ä�Ã³ng cá»­a sá»• khá»Ÿi Ä‘á»™ng
        window.dispose();

        // Táº¡o cá»­a sá»• chÃ­nh cá»§a á»©ng dá»¥ng
            GDChinh trangDangNhap = null;
        try {
            trangDangNhap = new GDChinh();
        } catch (SQLException ex) {
            Logger.getLogger(App_TinhLuongThinhVuong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new App_TinhLuongThinhVuong();
    }
}
