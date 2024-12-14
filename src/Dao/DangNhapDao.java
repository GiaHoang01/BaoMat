/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Pojo.Connect;
import Gui.FrmTong;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author 84862
 */
public class DangNhapDao {
    public void quyen(String tenDangNhap,FrmTong temp)
    {
        if(tenDangNhap.equals("Admin"))
        {
            temp.txt_NhanVien.setVisible(true);
        }
        else
        {
             temp.txt_NhanVien.setVisible(false);
        }
    }
    public boolean ketNoiDangNhap(String tenTaiKhoan, FrmTong temp)
    {
        Connect.Connect();
        try{
               String quyen = null;
               String tenTK=null;
                try 
                {
                    String sql = "SELECT Admin.NhanVien.ChucVu,Admin.NhanVien.TenDangNhap FROM Admin.TaiKhoan join Admin.NhanVien on Admin.TaiKhoan.TenDangNhap=Admin.NhanVien.TenDangNhap WHERE Admin.TaiKhoan.TenDangNhap='" + tenTaiKhoan + "'";
                    Statement statement=Connect.conn.createStatement();
                    ResultSet result = statement.executeQuery(sql);

                    if (result.next()) {
                        // If there is a result, retrieve the value
                        quyen = result.getString("ChucVu");
                        tenTK = result.getString("TenDangNhap");
                        temp.txt_TenDangNhap.setText(tenTK);
                        temp.txt_ChucVu.setText(quyen);
                        result.close();
                        statement.close();
                        return true;
                    } 
                    else {
                        // If no result, login failed
                        result.close();
                        statement.close();
                        return false;
                    }
            
                } catch (Exception e) {
                    e.printStackTrace();
                }
           
    }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
}
