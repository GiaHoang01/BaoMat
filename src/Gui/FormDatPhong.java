/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Gui;

import Dao.ChiTietHoaDonDao;
import Dao.HoaDonDao;
import Dao.KhachHangDao;
import Dao.LoaiPhongDao;
import Dao.NhanVienDao;
import Dao.PhongDao;
import Pojo.ChiTietHoaDon;
import Pojo.HoaDon;
import Pojo.KhachHang;
import Pojo.NhanVien;
import Pojo.PhongView;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 84862
 */
public class FormDatPhong extends javax.swing.JPanel {

    /**
     * Creates new form FormDatPhong
     */
    private List<PhongView> phongList=new ArrayList<>();
    private List<String> nhanViens=new ArrayList<>();
    private List<String> khachHangs=new ArrayList<>();
    private ArrayList<HoaDon> hoaDons=new ArrayList<>();
    KhachHangDao handleKhachHang= new KhachHangDao();
    NhanVienDao handleNhanVien= new NhanVienDao();
    ChiTietHoaDonDao handlChiTietHoaDonDao= new ChiTietHoaDonDao();
    PhongDao handlePhong = new PhongDao(this);
    HoaDonDao handleHoaDon= new HoaDonDao();
    LoaiPhongDao handleLoaiPhong = new LoaiPhongDao();
    String[] columnNames = {"Mã Phòng", "Thời Gian Đặt", "Thời Gian Trả","Giá phòng","Tổng tiền"};
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    public FormDatPhong() {
        initComponents();
        phongList= handlePhong.ListPhong(phongList);
        customInit();
        init_CboKhachHang();
        init_CboNhanVien();
        init_Cbo_HoaDon();
    }
    private void init_CboNhanVien()
    {
        nhanViens=handleNhanVien.layDSNhanVien();
        for(String temp:nhanViens)
        {
            cbo_NhanVien.addItem(temp);
        }
        cbo_NhanVien.setSelectedIndex(-1);
    }
    private void init_Cbo_HoaDon()
    {
        hoaDons=handleHoaDon.layDSHoaDonChuaThanhToan();
        for(HoaDon temp:hoaDons)
        {
            cbo_MaHD.addItem(String.valueOf(temp.getMaHD()));
        }
        cbo_MaHD.setSelectedIndex(-1);
    }
    private void init_CboKhachHang()
    {
        khachHangs=handleKhachHang.layDSMaKH();
        for(String temp:khachHangs)
        {
            cbo_KhachHang.addItem(temp);
        }
        cbo_KhachHang.setSelectedIndex(-1);
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
                    txt_MaPhong.setText(""+phong.getMaPhong());
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
        panel_Phong.setPreferredSize(new Dimension(810, 580));

        // Tạo JScrollPane để chứa panel_Phong
        JScrollPane scrollPane = new JScrollPane(panel_Phong);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Hiển thị thanh trượt dọc luôn
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Không hiển thị thanh trượt ngang

        // Thêm JScrollPane vào jPanel1
        jPanel2.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 810, 580));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_CTDP = new javax.swing.JTable();
        btn_TaoHoaDon = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_MaPhong = new javax.swing.JTextField();
        btn_Them = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_LamLai = new javax.swing.JButton();
        txt_ThoiGianDat = new javax.swing.JFormattedTextField();
        txt_ThoiGianTra = new javax.swing.JFormattedTextField();
        cbo_NhanVien = new javax.swing.JComboBox<>();
        cbo_KhachHang = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbo_MaHD = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        panel_Phong = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setAutoscrolls(true);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("CHI TIẾT ĐẶT PHÒNG");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        tb_CTDP.setForeground(new java.awt.Color(153, 0, 0));
        tb_CTDP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Phòng", "Thời gian đặt", "Thời gian trả", "Giá phòng", "Tổng tiền"
            }
        ));
        tb_CTDP.setRowHeight(40);
        tb_CTDP.setSelectionBackground(new java.awt.Color(153, 0, 0));
        tb_CTDP.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tb_CTDP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_CTDPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_CTDP);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 167, 560, 380));

        btn_TaoHoaDon.setBackground(new java.awt.Color(255, 255, 0));
        btn_TaoHoaDon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_TaoHoaDon.setForeground(new java.awt.Color(255, 0, 0));
        btn_TaoHoaDon.setText("Đặt Phòng");
        btn_TaoHoaDon.setActionCommand("");
        btn_TaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TaoHoaDonActionPerformed(evt);
            }
        });
        jPanel1.add(btn_TaoHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 590, -1, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("Mã phòng :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Thời gian đặt :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("Thời gian trả :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));

        txt_MaPhong.setEnabled(false);
        jPanel1.add(txt_MaPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 170, -1));

        btn_Them.setBackground(new java.awt.Color(0, 255, 0));
        btn_Them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Them.setForeground(new java.awt.Color(255, 255, 255));
        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Them, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 70, 30));

        btn_Xoa.setBackground(new java.awt.Color(255, 51, 51));
        btn_Xoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 70, 30));

        btn_Sua.setBackground(new java.awt.Color(0, 102, 204));
        btn_Sua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_Sua.setText("Sửa");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 70, 30));

        btn_LamLai.setBackground(new java.awt.Color(204, 204, 204));
        btn_LamLai.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btn_LamLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/reset_1.png"))); // NOI18N
        btn_LamLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamLaiActionPerformed(evt);
            }
        });
        jPanel1.add(btn_LamLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, -1));

        txt_ThoiGianDat.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        txt_ThoiGianDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ThoiGianDatActionPerformed(evt);
            }
        });
        jPanel1.add(txt_ThoiGianDat, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 150, -1));

        txt_ThoiGianTra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        jPanel1.add(txt_ThoiGianTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 150, -1));

        cbo_NhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_NhanVienActionPerformed(evt);
            }
        });
        jPanel1.add(cbo_NhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 570, 200, -1));

        jPanel1.add(cbo_KhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 610, 200, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("Nhân Viên");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Khách Hàng");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 0));
        jLabel8.setText("Mã hóa đơn :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jPanel1.add(cbo_MaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 170, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 560, 670));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_Phong.setBackground(new java.awt.Color(255, 255, 255));
        panel_Phong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        panel_Phong.setToolTipText("");
        panel_Phong.setAutoscrolls(true);
        panel_Phong.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_Phong.setMinimumSize(new java.awt.Dimension(820, 620));
        panel_Phong.setPreferredSize(new java.awt.Dimension(820, 620));
        panel_Phong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(panel_Phong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 810, 580));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setText("DANH SÁCH PHÒNG");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 0));
        jLabel11.setText("Trống");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 30));

        jPanel3.setBackground(new java.awt.Color(51, 255, 0));
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 40, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 0, 0));
        jLabel13.setText("Đã đặt");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, 30));

        jPanel4.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 40, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 0, 0));
        jLabel12.setText("Bảo trì");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, 30));

        jPanel5.setBackground(new java.awt.Color(204, 0, 204));
        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 40, 30));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 670));

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents
private void reset()
    {
        phongList= handlePhong.ListPhong(phongList);
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
                    txt_MaPhong.setText(""+phong.getMaPhong());
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
    private void btn_LamLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamLaiActionPerformed
        // TODO add your handling code here:
        txt_MaPhong.setText("");
        txt_ThoiGianDat.setText("");
        txt_ThoiGianTra.setText("");
        cbo_KhachHang.setSelectedIndex(-1);
        cbo_NhanVien.setSelectedIndex(-1);
    }//GEN-LAST:event_btn_LamLaiActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
       if(handlePhong.kiemTraTrangThaiPhong(Integer.parseInt(txt_MaPhong.getText())))
       {
           if(kiemTraThoiGianDatVaThoiGianTra())
           {
                if(!kiemTraTrungLapDuLieu(txt_MaPhong.getText().toString(),txt_ThoiGianDat.getText().toString(),txt_ThoiGianTra.getText().toString()))
                {
                    String maPhong=txt_MaPhong.getText();
                    String tgD=txt_ThoiGianDat.getText();
                    String tgT=txt_ThoiGianTra.getText();
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                         if (tableModel.getValueAt(i, 0).equals(maPhong)) {
                             tableModel.setValueAt(tgD, i, 1);
                             tableModel.setValueAt(tgT, i, 2);
                             tb_CTDP.setModel(tableModel);
                             return;
                         }
                     }
                    tableModel.addRow(new Object[]{maPhong, tgD, tgT});
                    tb_CTDP.setModel(tableModel);
                    txt_MaPhong.setText("");
                    txt_ThoiGianDat.setText("");
                    txt_ThoiGianTra.setText("");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Không thể đặt một phòng cùng một thời gian");
                }
           }
           else{
               JOptionPane.showMessageDialog(null, "Thời gian sai định dạng dd-MM-YYYY HH:mm:ss hoặc thời gian đặt không thể sau thời gian trả");
           }
       }
       else
       {
             JOptionPane.showMessageDialog(null, "Phòng này đang đặt hoặc trong tình trang sửa chữa !");
       }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:
        int selectedRow = tb_CTDP.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
            tb_CTDP.setModel(tableModel);
            JOptionPane.showMessageDialog(null, "Đã xóa dòng được chọn.");
            txt_MaPhong.setText("");
            txt_ThoiGianDat.setText("");
            txt_ThoiGianTra.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để xóa.");
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    public boolean kiemTraThoiGianDatVaThoiGianTra()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            // Convert thoiGianDat and thoiGianTra strings to Date objects
            Date datTimeBooked = new Date(dateFormat.parse(txt_ThoiGianDat.getText().toString()).getTime());
            Date dateTimeReturn = new Date(dateFormat.parse(txt_ThoiGianTra.getText().toString()).getTime());
            // Compare the dates
            if (datTimeBooked.before(dateTimeReturn)) {
                return true; // Valid booking time
            } else {
                return false; // Invalid booking time
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false; // Error occurred during parsing, consider it invalid
        }
    }

    private boolean kiemTraTrungLapDuLieu(String maPhong, String thoiGianDat, String thoiGianTra) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String maPhongDaCo = tableModel.getValueAt(i, 0).toString();
            String tgDDaCo = tableModel.getValueAt(i, 1).toString();
            String tgTDaCo = tableModel.getValueAt(i, 2).toString();

            // Kiểm tra xem dòng mới có trùng lặp với dòng nào đã có hay không
            if (maPhong.equals(maPhongDaCo) && thoiGianDat.equals(tgDDaCo) && thoiGianTra.equals(tgTDaCo)) {
                return true; // Dữ liệu trùng lặp
            }
        }
        return false; // Không có dữ liệu trùng lặp
    }
    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
       if(handlePhong.kiemTraTrangThaiPhong(Integer.parseInt(txt_MaPhong.getText())))
        {
            if(kiemTraThoiGianDatVaThoiGianTra())
            {
                if(!kiemTraTrungLapDuLieu(txt_MaPhong.getText().toString(),txt_ThoiGianDat.getText().toString(),txt_ThoiGianTra.getText().toString()))
                {
                    long soNgay=0;
                    String maPhong=txt_MaPhong.getText();
                    
                    BigDecimal giaPhong=handleLoaiPhong.SearchGiaPhong(Integer.parseInt(maPhong));
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        // Chuyển đổi thành đối tượng Date
                        java.util.Date thoiGianDat = dateFormat.parse(txt_ThoiGianDat.getText());
                        java.util.Date thoiGianTra = dateFormat.parse(txt_ThoiGianTra.getText());

                        // Convert java.util.Date to java.sql.Date
                        java.sql.Date sqlThoiGianDat = new java.sql.Date(thoiGianDat.getTime());
                        java.sql.Date sqlThoiGianTra = new java.sql.Date(thoiGianTra.getTime());

                        // Tính khoảng thời gian giữa hai ngày
                        long khoangThoiGian = sqlThoiGianTra.getTime() - sqlThoiGianDat.getTime();

                        // Chuyển đổi sang số ngày
                        soNgay = khoangThoiGian / (1000 * 60 * 60 * 24);

                        
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    BigDecimal soNgayBigDecimal = BigDecimal.valueOf(soNgay);
                    BigDecimal tongTien = soNgayBigDecimal.multiply(giaPhong);
                    tableModel.addRow(new Object[]{maPhong,txt_ThoiGianDat.getText(),txt_ThoiGianTra.getText(),giaPhong,tongTien});
                    tb_CTDP.setModel(tableModel);
                    txt_MaPhong.setText("");
                    txt_ThoiGianDat.setText("");
                    txt_ThoiGianTra.setText("");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Không thể đặt một phòng cùng một thời gian");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Thời gian sai định dạng dd/MM/yyyy HH:mm:ss hoặc thời gian đặt không thể sau thời gian trả");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Phòng này đang đặt hoặc trong tình trang sửa chữa !");
        }
        
        reset();
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void tb_CTDPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_CTDPMouseClicked
        // TODO add your handling code here:
        int selectedRow = tb_CTDP.getSelectedRow();
         if (selectedRow >= 0) 
        {
            // Lấy dữ liệu từ dòng được chọn
            String maP = tb_CTDP.getValueAt(selectedRow, 0).toString();
            String tgD = tb_CTDP.getValueAt(selectedRow, 1).toString();
            String tgT = tb_CTDP.getValueAt(selectedRow, 2).toString();
            txt_MaPhong.setText(maP);
            txt_ThoiGianDat.setText(tgD);
            txt_ThoiGianTra.setText(tgT);
        }
       
    }//GEN-LAST:event_tb_CTDPMouseClicked
    
    private void btn_TaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TaoHoaDonActionPerformed
        // TODO add your handling code here:
        if(cbo_NhanVien.getSelectedIndex()==-1 || cbo_KhachHang.getSelectedIndex()==-1)
        {
             JOptionPane.showMessageDialog(null, "Phải chọn nhân viên và khách hàng ");
        }
        else
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            for(int row = 0; row < tb_CTDP.getRowCount(); row++) {
                int maPhong = Integer.parseInt(tb_CTDP.getValueAt(row, 0).toString());
                
               

               try {
                    java.util.Date utilDateDat = dateFormat.parse(tb_CTDP.getValueAt(row, 1).toString());
                    java.util.Date utilDateTra = dateFormat.parse(tb_CTDP.getValueAt(row, 2).toString());

                    java.sql.Date thoiGianDat = new java.sql.Date(utilDateDat.getTime());
                    java.sql.Date thoiGianTra = new java.sql.Date(utilDateTra.getTime());
                    
                    ChiTietHoaDon temp= new ChiTietHoaDon();
                    temp.setMaHD(Integer.parseInt(cbo_MaHD.getSelectedItem().toString()));
                    temp.setMaPhong(maPhong);
                    temp.setTgDat(new java.sql.Date(thoiGianDat.getTime())); // Chuyển đổi sang java.sql.Date
                    temp.setTgTra(new java.sql.Date(thoiGianTra.getTime())); // Chuyển đổi sang java.sql.Date
                    if(handlChiTietHoaDonDao.themChiTietHoaDon(temp)) {
                        JOptionPane.showMessageDialog(null, "Thêm Thành Công!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Thêm Thất Bại!");
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }


            }
        }
        
    }//GEN-LAST:event_btn_TaoHoaDonActionPerformed

    private void txt_ThoiGianDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ThoiGianDatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ThoiGianDatActionPerformed

    private void cbo_NhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_NhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_NhanVienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LamLai;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_TaoHoaDon;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JComboBox<String> cbo_KhachHang;
    private javax.swing.JComboBox<String> cbo_MaHD;
    private javax.swing.JComboBox<String> cbo_NhanVien;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_Phong;
    private javax.swing.JTable tb_CTDP;
    private javax.swing.JTextField txt_MaPhong;
    private javax.swing.JFormattedTextField txt_ThoiGianDat;
    private javax.swing.JFormattedTextField txt_ThoiGianTra;
    // End of variables declaration//GEN-END:variables
}
