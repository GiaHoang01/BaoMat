/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Gui;

import Dao.NhatKyGiaiTrinhDao;
import Pojo.EmployeeAudit;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HUU KHANH
 */
public class FrmNhatKyGiaiTrinh extends javax.swing.JPanel {

    /**
     * Creates new form FrmNhatKyGiaiTrinh
     */
    public FrmNhatKyGiaiTrinh() {
        initComponents();
        hienThi();
    }
    private void hienThi()
    {
        ArrayList<EmployeeAudit> ds=NhatKyGiaiTrinhDao.layDanhSachLichSu();
        DefaultTableModel dtm=new DefaultTableModel();
        dtm.addColumn("Hành động");
        dtm.addColumn("Thời điểm");
        dtm.addColumn("Người dùng");
        dtm.setNumRows(ds.size());
        for(int i=0;i<ds.size();i++)
        {
            EmployeeAudit ls=ds.get(i);
            dtm.setValueAt(ls.getActionType(), i, 0);
            dtm.setValueAt(ls.getActionTime(),i, 1);
            dtm.setValueAt(ls.getUserName(), i,2 );
        }
        tbl_LichSu.setModel(dtm);
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
        btn_LamMoi6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_LichSu = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Nhật Ký Giải Trình");

        btn_LamMoi6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/reset_1.png"))); // NOI18N
        btn_LamMoi6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoi6ActionPerformed(evt);
            }
        });

        tbl_LichSu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_LichSu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(btn_LamMoi6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(209, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_LamMoi6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LamMoi6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoi6ActionPerformed
        hienThi();
    }//GEN-LAST:event_btn_LamMoi6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LamMoi;
    private javax.swing.JButton btn_LamMoi1;
    private javax.swing.JButton btn_LamMoi2;
    private javax.swing.JButton btn_LamMoi3;
    private javax.swing.JButton btn_LamMoi4;
    private javax.swing.JButton btn_LamMoi5;
    private javax.swing.JButton btn_LamMoi6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_LichSu;
    // End of variables declaration//GEN-END:variables
}
