/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Gui;


import Dao.KhachHangDao;
import Dao.LoaiPhongDao;
import Dao.PhongDao;
import Dao.TrangThaiDao;
import Pojo.LoaiPhong;
import Pojo.Phong;
import Pojo.PhongView;
import Pojo.TrangThai;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author 84862
 */
public class PhongFrom extends javax.swing.JPanel {
    private List<PhongView> phongList=new ArrayList<>();
    private List<LoaiPhong> loaiPhongs= new ArrayList<>();
    private List<TrangThai> trangThais= new ArrayList<>();
    TrangThaiDao handleTrangThai = new TrangThaiDao();
    LoaiPhongDao handleLoaiPhong= new LoaiPhongDao();
    PhongDao handlePhong = new PhongDao(this);
    /**
     * Creates new form PhongFrom
     */
    public PhongFrom() {
        initComponents();
   
        phongList= handlePhong.ListPhong(phongList);
        customInit();
        init_CBO();
        init_CBO_LoaiPhong();
        init_CBO_TrangThai();
        
    }
    private void init_CBO()
    {
        cbo_ChonLoaiPhong.removeAllItems();
        cbo_ChonLoaiPhong.addItem("Tất cả");
        loaiPhongs=handleLoaiPhong.ListPhong(loaiPhongs);
        for (int i = 0; i < loaiPhongs.size(); i++) {
          LoaiPhong loai=loaiPhongs.get(i);
          cbo_ChonLoaiPhong.addItem(loai.getLoaiPhong());
        }
        cbo_ChonLoaiPhong.setSelectedItem("Tất cả");
        cbo_ChonLoaiPhong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(cbo_ChonLoaiPhong.getSelectedItem().toString().equals("Tất cả"))
                {
                    phongList = handlePhong.ListPhong(phongList);
                    reset();
                }
                else {
                    phongList = handlePhong.ListPhongTheoLoaiPhong(phongList, cbo_ChonLoaiPhong.getSelectedItem().toString());
                    reset();
                }
            }
        });
    }
    private void init_CBO_TrangThai()
    {
        cbo_TrangThai.removeAllItems();
        trangThais=handleTrangThai.ListTrangThai(trangThais);
        for (int i = 0; i < trangThais.size(); i++) {
          TrangThai loai=trangThais.get(i);
          cbo_TrangThai.addItem(loai.getTenTrangThai());
        }
        cbo_TrangThai.setSelectedIndex(-1);
    }
    
    private void init_CBO_LoaiPhong()
    {
        cbo_LoaiPhong.removeAllItems();
        loaiPhongs=handleLoaiPhong.ListPhong(loaiPhongs);
        for (int i = 0; i < loaiPhongs.size(); i++) {
          LoaiPhong loai=loaiPhongs.get(i);
          cbo_LoaiPhong.addItem(loai.getLoaiPhong());
        }
        cbo_LoaiPhong.setSelectedIndex(-1);
    }
    
    private void reset()
    {
        panel_Phong.removeAll();
        panel_Phong.removeAll();
        panel_Phong.revalidate(); // Revalidate the panel to apply changes
        panel_Phong.repaint(); 
            // Tạo dữ liệu mẫu
        // Tạo panel chứa các phòng với absolute layout
        panel_Phong.setLayout(null); // Sử dụng layout cố định
        int x = 10, y = 10;
        int width = 250, height = 100;
        int padding = 10;
        int columns = 3; // Sử dụng 3 cột

        for (int i = 0; i < phongList.size(); i++) {
            PhongView phong = phongList.get(i);
            custom_Phong phongButton = new custom_Phong(phong.getMaPhong(),phong.getTenLoaiPhong(),phong.getSoNguoiToiDa(),phong.getTenTrangThai());
             phongButton.addMouseListener(new MouseAdapter() 
            {
                @Override
                public void mouseClicked(MouseEvent e) {
                    txt_MaLoaiPhong.setText(""+phong.getMaPhong());
                    txt_SoNguoi.setText(String.valueOf(phong.getSoNguoiToiDa()));
                    cbo_LoaiPhong.setSelectedItem(phong.getTenLoaiPhong());
                    cbo_TrangThai.setSelectedItem(phong.getTenTrangThai());
                }  
            }); 
            
            phongButton.setBounds(x, y, width, height); // Đặt vị trí và kích thước cố định
            panel_Phong.add(phongButton);

            // Tính toán vị trí cho button tiếp theo
            if ((i + 1) % columns == 0) {
                x = 10; // Reset x về giá trị ban đầu
                y += height + padding; // Tăng y để xuống hàng
            } else {
                x += width + padding; // Tăng x để sang cột kế tiếp
            }
        }
    }

    private void customInit() {
        panel_Phong.removeAll();
        panel_Phong.removeAll();
        panel_Phong.revalidate(); // Revalidate the panel to apply changes
        panel_Phong.repaint(); 
            // Tạo dữ liệu mẫu
        // Tạo panel chứa các phòng với absolute layout
        panel_Phong.setLayout(null); // Sử dụng layout cố định
        int x = 10, y = 10;
        int width = 250, height = 100;
        int padding = 10;
        int columns = 3; // Sử dụng 3 cột

        for (int i = 0; i < phongList.size(); i++) {
            PhongView phong = phongList.get(i);
            custom_Phong phongButton = new custom_Phong(phong.getMaPhong(),phong.getTenLoaiPhong(),phong.getSoNguoiToiDa(),phong.getTenTrangThai());
            phongButton.addMouseListener(new MouseAdapter() 
            {
                @Override
                public void mouseClicked(MouseEvent e) {
                    txt_MaLoaiPhong.setText(""+phong.getMaPhong());
                    txt_SoNguoi.setText(String.valueOf(phong.getSoNguoiToiDa()));
                    cbo_LoaiPhong.setSelectedItem(phong.getTenLoaiPhong());
                    cbo_TrangThai.setSelectedItem(phong.getTenTrangThai());
                }  
            }); 
            
            
            phongButton.setBounds(x, y, width, height); // Đặt vị trí và kích thước cố định
            panel_Phong.add(phongButton);

            // Tính toán vị trí cho button tiếp theo
            if ((i + 1) % columns == 0) {
                x = 10; // Reset x về giá trị ban đầu
                y += height + padding; // Tăng y để xuống hàng
            } else {
                x += width + padding; // Tăng x để sang cột kế tiếp
            }
        }

        // Tính toán kích thước ưa thích cho panel_Phong
        int preferredHeight = y + height + 10;
        panel_Phong.setPreferredSize(new Dimension(810, preferredHeight));

        // Tạo JScrollPane để chứa panel_Phong
        JScrollPane scrollPane = new JScrollPane(panel_Phong);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Hiển thị thanh trượt dọc luôn
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Không hiển thị thanh trượt ngang

        // Thêm JScrollPane vào jPanel1
        jPanel1.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 810, 530));
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbo_ChonLoaiPhong = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        panel_Phong = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_MaLoaiPhong = new javax.swing.JTextField();
        cbo_LoaiPhong = new javax.swing.JComboBox<>();
        txt_SoNguoi = new javax.swing.JTextField();
        cbo_TrangThai = new javax.swing.JComboBox<>();
        btn_Them = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_LamLai = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1370, 670));
        setPreferredSize(new java.awt.Dimension(1370, 670));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(700, 800));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Danh Sách Phòng");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        cbo_ChonLoaiPhong.setForeground(new java.awt.Color(204, 0, 204));
        cbo_ChonLoaiPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_ChonLoaiPhongActionPerformed(evt);
            }
        });
        jPanel1.add(cbo_ChonLoaiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 180, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("Chọn Loại Phòng");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 20));

        panel_Phong.setBackground(new java.awt.Color(255, 255, 255));
        panel_Phong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_Phong.setToolTipText("");
        panel_Phong.setAutoscrolls(true);
        panel_Phong.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_Phong.setMinimumSize(new java.awt.Dimension(820, 530));
        panel_Phong.setPreferredSize(new java.awt.Dimension(820, 530));
        panel_Phong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(panel_Phong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 810, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 0));
        jLabel11.setText("Trống");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, -1, 30));

        jPanel3.setBackground(new java.awt.Color(51, 255, 0));
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 40, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 0, 0));
        jLabel12.setText("Bảo trì");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, -1, 30));

        jPanel4.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 40, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 0, 0));
        jLabel13.setText("Đã đặt");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, 30));

        jPanel5.setBackground(new java.awt.Color(204, 0, 204));
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 40, 30));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 670));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Mã phòng");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("Loại phòng");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Số người tối đa");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("Trạng thái");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));
        jPanel2.add(txt_MaLoaiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 300, 30));

        jPanel2.add(cbo_LoaiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 300, 30));
        jPanel2.add(txt_SoNguoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 300, 30));

        jPanel2.add(cbo_TrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 300, 30));

        btn_Them.setBackground(new java.awt.Color(0, 255, 0));
        btn_Them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Them.setForeground(new java.awt.Color(255, 255, 255));
        btn_Them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/add.png"))); // NOI18N
        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Them, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 110, 40));

        btn_Xoa.setBackground(new java.awt.Color(255, 51, 51));
        btn_Xoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_Xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/xoa.png"))); // NOI18N
        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 110, 40));

        btn_Sua.setBackground(new java.awt.Color(0, 102, 204));
        btn_Sua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_Sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/sua.png"))); // NOI18N
        btn_Sua.setText("Sửa");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 100, 40));

        btn_LamLai.setBackground(new java.awt.Color(204, 204, 204));
        btn_LamLai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_LamLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/reset_1.png"))); // NOI18N
        btn_LamLai.setText("Làm Lại");
        btn_LamLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamLaiActionPerformed(evt);
            }
        });
        jPanel2.add(btn_LamLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 110, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setText("Thông Tin Phòng");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("(*)");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("(*)");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("(*)");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, -1, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 0, 560, 670));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LamLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamLaiActionPerformed
        // TODO add your handling code here:
        txt_MaLoaiPhong.setText("");
        txt_SoNguoi.setText("");
        cbo_LoaiPhong.setSelectedIndex(-1);
        cbo_TrangThai.setSelectedIndex(-1);
    }//GEN-LAST:event_btn_LamLaiActionPerformed

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
        handlePhong.themPhong();
        phongList = handlePhong.ListPhong(phongList);
        reset();
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void cbo_ChonLoaiPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_ChonLoaiPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_ChonLoaiPhongActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        // TODO add your handling code here:
        handlePhong.suaPhong();
        phongList = handlePhong.ListPhong(phongList);
        reset();
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:
        handlePhong.deletePhong();
        phongList = handlePhong.ListPhong(phongList);
        reset();
    }//GEN-LAST:event_btn_XoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LamLai;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JComboBox<String> cbo_ChonLoaiPhong;
    public javax.swing.JComboBox<String> cbo_LoaiPhong;
    public javax.swing.JComboBox<String> cbo_TrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel panel_Phong;
    public javax.swing.JTextField txt_MaLoaiPhong;
    public javax.swing.JTextField txt_SoNguoi;
    // End of variables declaration//GEN-END:variables
}
