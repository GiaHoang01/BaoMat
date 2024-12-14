/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Gui;

import Dao.KhachHangDao;
import Pojo.KhachHang;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HUU KHANH
 */
public class formKhachHang extends javax.swing.JPanel {

    /**
     * Creates new form formKhachHang
     */

    public formKhachHang() {
        
        initComponents();

        hienThi();
        txt_MaKhachHang.enable(false);
    }
    private void hienThi()
    {
        ArrayList<KhachHang> ds=KhachHangDao.layDanhSachKhachHang();
        DefaultTableModel dtm=new DefaultTableModel();
        dtm.addColumn("Mã khách hàng");
        dtm.addColumn("Số CMND");
        dtm.addColumn("Tên khách hàng");
        dtm.addColumn("SDT");
        dtm.addColumn("Giới tính");
        dtm.setNumRows(ds.size());
        for(int i=0;i<ds.size();i++)
        {
            KhachHang ls=ds.get(i);
            dtm.setValueAt(ls.getMaKH(), i, 0);
            dtm.setValueAt(ls.getSoCMND(),i, 1);
            dtm.setValueAt(ls.getTenKH(), i,2 );
            dtm.setValueAt(ls.getSDT(), i, 3);
            dtm.setValueAt(ls.getGioiTinh(), i, 4);
        }
        tbl_KhachHang.setModel(dtm);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_KhachHang = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_MaKhachHang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_CMND = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_TenKhachHang = new javax.swing.JTextField();
        txt_SoDT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btn_Them = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        txt_Search = new javax.swing.JTextField();
        btn_Tim = new javax.swing.JButton();
        rdo_Nu = new javax.swing.JRadioButton();
        rdo_Nam = new javax.swing.JRadioButton();
        btn_LamMoi = new javax.swing.JButton();
        btn_Encrypt = new javax.swing.JButton();
        btn_Decrypt = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Khách hàng");

        tbl_KhachHang.setForeground(new java.awt.Color(153, 0, 0));
        tbl_KhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MaKH", "TenKH", "Số CMND", "SDT", "Giới Tính"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_KhachHang.setPreferredSize(new java.awt.Dimension(700, 500));
        tbl_KhachHang.setRowHeight(40);
        tbl_KhachHang.setSelectionBackground(new java.awt.Color(153, 0, 0));
        tbl_KhachHang.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_KhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_KhachHang);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("Mã khách hàng :");

        txt_MaKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MaKhachHangActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Tên khách hàng :");

        txt_CMND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CMNDActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("Số CMND:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Số điện thoại :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("Giới tính :");

        txt_SoDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SoDTActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 0, 0));
        jLabel9.setText("Tìm Kiếm :");

        btn_Them.setBackground(new java.awt.Color(0, 255, 51));
        btn_Them.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Them.setForeground(new java.awt.Color(255, 255, 255));
        btn_Them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/add.png"))); // NOI18N
        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        btn_Xoa.setBackground(new java.awt.Color(255, 0, 0));
        btn_Xoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_Xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/xoa.png"))); // NOI18N
        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        btn_Sua.setBackground(new java.awt.Color(0, 51, 255));
        btn_Sua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_Sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/sua.png"))); // NOI18N
        btn_Sua.setText("Sửa");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });

        txt_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SearchActionPerformed(evt);
            }
        });
        txt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_SearchKeyPressed(evt);
            }
        });

        btn_Tim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/search.png"))); // NOI18N
        btn_Tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdo_Nu);
        rdo_Nu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdo_Nu.setForeground(new java.awt.Color(153, 0, 0));
        rdo_Nu.setText("Nữ");

        buttonGroup1.add(rdo_Nam);
        rdo_Nam.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdo_Nam.setForeground(new java.awt.Color(153, 0, 0));
        rdo_Nam.setText("Nam");

        btn_LamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/reset_1.png"))); // NOI18N
        btn_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoiActionPerformed(evt);
            }
        });

        btn_Encrypt.setText("Mã hóa");
        btn_Encrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EncryptActionPerformed(evt);
            }
        });

        btn_Decrypt.setText("Giải mã");
        btn_Decrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DecryptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(570, 570, 570)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_TenKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_CMND, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                .addComponent(txt_MaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(55, 55, 55)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdo_Nam, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(rdo_Nu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txt_Search)
                            .addGap(18, 18, 18)
                            .addComponent(btn_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_Them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Encrypt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_Xoa, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(btn_Decrypt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(43, 43, 43)
                            .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txt_SoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_MaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txt_SoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rdo_Nam, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdo_Nu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_TenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_CMND, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_LamMoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Decrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Encrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_KhachHangMouseClicked
        // TODO add your handling code here:
        int selectedRow = tbl_KhachHang.getSelectedRow();
        if (selectedRow >= 0) {
            // Lấy dữ liệu từ dòng được chọn
            String maKH = tbl_KhachHang.getValueAt(selectedRow, 0).toString();
            String soCMND = tbl_KhachHang.getValueAt(selectedRow, 1).toString();
            String tenKH = tbl_KhachHang.getValueAt(selectedRow, 2).toString();
            String SDT = tbl_KhachHang.getValueAt(selectedRow, 3).toString();
            String gioiTinh = tbl_KhachHang.getValueAt(selectedRow, 4).toString();
            
            if(gioiTinh.equals("Nam"))
            {
                rdo_Nam.setSelected(true);
            }
            else
            {
                rdo_Nu.setSelected(true);
            }
           
            // Hiển thị dữ liệu trong các JTextField tương ứng
            txt_MaKhachHang.setText(maKH);
            txt_CMND.setText(soCMND);
            txt_TenKhachHang.setText(tenKH);
            txt_SoDT.setText(SDT);
        }
    }//GEN-LAST:event_tbl_KhachHangMouseClicked

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here
        KhachHang kh = new KhachHang();
        kh.setSoCMND(txt_CMND.getText());
        kh.setTenKH(txt_TenKhachHang.getText());
        kh.setSDT(txt_SoDT.getText());
        if (rdo_Nam.isSelected()) {
            kh.setGioiTinh("Nam");
        } else if (rdo_Nu.isSelected()) {
            kh.setGioiTinh("Nữ");
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính!");
            return;
        }
       

        // Gọi phương thức thêm sách từ lớp SachDAO
        boolean success = KhachHangDao.themKhachHang(kh);
        if (success) {
            // Thông báo thành công
            JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công!");
            // Cập nhật lại danh sách sách trên giao diện
            hienThi();
        } else {
            // Thông báo thất bại
            JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại!");
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:
        int maKH = Integer.parseInt(txt_MaKhachHang.getText());
        int confirmed = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa lớp này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            boolean success = KhachHangDao.xoaKhachHang(maKH);
            if (success) {
                // Thông báo thành công
                JOptionPane.showMessageDialog(this, "Xóa khách hàng thành công!");
                // Cập nhật lại danh sách trên giao diện
                hienThi();
            } else {
                // Thông báo thất bại
                JOptionPane.showMessageDialog(this, "Xóa khách hàng thất bại!");
            }
        }
       
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        // TODO add your handling code here:
        KhachHang kh = new KhachHang();
        int maKH = Integer.parseInt(txt_MaKhachHang.getText());
        kh.setMaKH(maKH);        
        kh.setSoCMND(txt_CMND.getText());
        kh.setTenKH(txt_TenKhachHang.getText());
        kh.setSDT(txt_SoDT.getText());
        if (rdo_Nam.isSelected()) {
            kh.setGioiTinh("Nam");
        } else if (rdo_Nu.isSelected()) {
            kh.setGioiTinh("Nữ");
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính!");
            return;
        }
       
        // Khởi tạo thông tin sách từ các trường dữ liệu trên giao diện

        // Gọi phương thức thêm sách từ lớp SachDAO
        boolean success = KhachHangDao.capNhatKhachHang(kh);
        if (success) {
            // Thông báo thành công
            JOptionPane.showMessageDialog(this, "Cập nhật khách hàng thành công!");
            // Cập nhật lại danh sách sách trên giao diện
            hienThi();
        } else {
            // Thông báo thất bại
            JOptionPane.showMessageDialog(this, "Cập nhật khách hàng thất bại!");
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_TimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimActionPerformed
        // TODO add your handling code here:
        String keyword = txt_Search.getText().trim().toLowerCase();
        // Get the list of all customers
        ArrayList<KhachHang> ds = KhachHangDao.layDanhSachKhachHang();

        // Create a list to store the search results
        ArrayList<KhachHang> searchResults = new ArrayList<>();

        // Loop through the customer list and add matching customers to the searchResults list
        for (KhachHang kh : ds) {
            if (kh.getSoCMND().toLowerCase().contains(keyword) ||
                kh.getTenKH().toLowerCase().contains(keyword) ||
                kh.getSDT().toLowerCase().contains(keyword) ||
                kh.getGioiTinh().toLowerCase().contains(keyword)) {
                searchResults.add(kh);
            }
        }

        // Update the table with the search results
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã khách hàng");
        dtm.addColumn("Số CMND");
        dtm.addColumn("Tên khách hàng");
        dtm.addColumn("SDT");
        dtm.addColumn("Giới tính");
        dtm.setNumRows(searchResults.size());

        for (int i = 0; i < searchResults.size(); i++) {
            KhachHang kh = searchResults.get(i);
            dtm.setValueAt(kh.getMaKH(), i, 0);
            dtm.setValueAt(kh.getSoCMND(), i, 1);
            dtm.setValueAt(kh.getTenKH(), i, 2);
            dtm.setValueAt(kh.getSDT(), i, 3);
            dtm.setValueAt(kh.getGioiTinh(), i, 4);
        }

        tbl_KhachHang.setModel(dtm);
    }//GEN-LAST:event_btn_TimActionPerformed

    private void txt_SearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_SearchKeyPressed

    private void txt_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SearchActionPerformed

    private void txt_CMNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CMNDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CMNDActionPerformed

    private void txt_MaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MaKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MaKhachHangActionPerformed

    private void txt_SoDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SoDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SoDTActionPerformed

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        // TODO add your handling code here:
        txt_MaKhachHang.setText("");
        txt_CMND.setText("");
        txt_SoDT.setText("");
        txt_TenKhachHang.setText("");
        txt_Search.setText("");
        buttonGroup1.clearSelection();
    }//GEN-LAST:event_btn_LamMoiActionPerformed

    private void btn_EncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EncryptActionPerformed
        // TODO add your handling code here:
        if (!btn_Encrypt.isEnabled()) {
            return;
        }
        KhachHang kh = new KhachHang();
        int maKH = Integer.parseInt(txt_MaKhachHang.getText());
        kh.setMaKH(maKH);
        kh.setSoCMND(txt_CMND.getText());
        kh.setTenKH(txt_TenKhachHang.getText());
        kh.setSDT(txt_SoDT.getText());
        if (rdo_Nam.isSelected()) {
            kh.setGioiTinh("Nam");
        } else if (rdo_Nu.isSelected()) {
            kh.setGioiTinh("Nữ");
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính!");
            return;
        }

        // Khởi tạo thông tin sách từ các trường dữ liệu trên giao diện
        // Gọi phương thức thêm sách từ lớp SachDAO
        boolean success = KhachHangDao.maHoaKhachHang(kh);
        if (success) {
            // Thông báo thành công
            JOptionPane.showMessageDialog(this, "Mã hóa SDT khách hàng thành công!");
            // Cập nhật lại danh sách sách trên giao diện
            hienThi();
            btn_Encrypt.setEnabled(false);
            btn_Decrypt.setEnabled(true);
        } else {
            // Thông báo thất bại
            JOptionPane.showMessageDialog(this, "Mã hóa SDT khách hàng thất bại!");
        }
    }//GEN-LAST:event_btn_EncryptActionPerformed

    private void btn_DecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DecryptActionPerformed
        // TODO add your handling code here:
        KhachHang kh = new KhachHang();
        int maKH = Integer.parseInt(txt_MaKhachHang.getText());
        kh.setMaKH(maKH);
        kh.setSoCMND(txt_CMND.getText());
        kh.setTenKH(txt_TenKhachHang.getText());
        kh.setSDT(txt_SoDT.getText());
        if (rdo_Nam.isSelected()) {
            kh.setGioiTinh("Nam");
        } else if (rdo_Nu.isSelected()) {
            kh.setGioiTinh("Nữ");
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính!");
            return;
        }

        // Khởi tạo thông tin sách từ các trường dữ liệu trên giao diện
        // Gọi phương thức thêm sách từ lớp SachDAO
        boolean success = KhachHangDao.giaiMaKhachHang(kh);
        if (success) {
            // Thông báo thành công
            JOptionPane.showMessageDialog(this, "Giải mã SDT khách hàng thành công!");
            // Cập nhật lại danh sách sách trên giao diện
            hienThi();
            btn_Decrypt.setEnabled(false);
            btn_Encrypt.setEnabled(true);
        } else {
            // Thông báo thất bại
            JOptionPane.showMessageDialog(this, "Giải mã SDT khách hàng thất bại!");
        }
    }//GEN-LAST:event_btn_DecryptActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Decrypt;
    private javax.swing.JButton btn_Encrypt;
    private javax.swing.JButton btn_LamMoi;
    public javax.swing.JButton btn_Sua;
    public javax.swing.JButton btn_Them;
    public javax.swing.JButton btn_Tim;
    public javax.swing.JButton btn_Xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JRadioButton rdo_Nam;
    public javax.swing.JRadioButton rdo_Nu;
    public javax.swing.JTable tbl_KhachHang;
    public javax.swing.JTextField txt_CMND;
    public javax.swing.JTextField txt_MaKhachHang;
    public javax.swing.JTextField txt_Search;
    public javax.swing.JTextField txt_SoDT;
    public javax.swing.JTextField txt_TenKhachHang;
    // End of variables declaration//GEN-END:variables
}
