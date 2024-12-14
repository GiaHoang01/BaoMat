/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Gui.AddNhanVien;
import Gui.formNhanVien;
import Pojo.Connect;
import Pojo.NhanVien;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 84862
 */
public class NhanVienDao {

  public NhanVienDao() {
    }

    formNhanVien Goc;
    public NhanVienDao(formNhanVien temp) {
        Goc=temp;
    }
     public String SearchTenNhanVien(int maNV)
    {
        String sql = "Select Admin.NhanVien.TenNV from Admin.NhanVien where MaNV=?";
        Connect helper = null;
        ResultSet rs = null;
        String temp="";
        PreparedStatement statement = null;
        try {
            helper = new Connect();
            helper.Connect();
            statement = helper.conn.prepareStatement(sql);
            statement.setInt(1, maNV);
            rs = statement.executeQuery();
            while (rs.next()) {
                temp=rs.getString("TenNV");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return temp;
    }
    
    public int SearchMaNhanVien(String tenNhanVien)
    {
        String sql = "Select Admin.NhanVien.MaNhanVien from Admin.NhanVien where TenNhanVien=?";
        Connect helper = null;
        ResultSet rs = null;
        int temp=0;
        PreparedStatement statement = null;
        try {
            helper = new Connect();
            helper.Connect();
            statement = helper.conn.prepareStatement(sql);
            statement.setString(1, tenNhanVien);
            rs = statement.executeQuery();
            while (rs.next()) {
                temp=rs.getInt("MaKhachHang");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return temp;
    }
    
    public void themNhanVien(AddNhanVien temp)
    {
        Connect.Connect();
        String imagePath = temp.selectedImagePath;
        String fileName = "";
        if (imagePath != null) {
            fileName = imagePath.substring(imagePath.lastIndexOf("\\") + 1);
        }
        try{
            PreparedStatement preparedStatement=Connect.conn.prepareStatement("BEGIN Admin.ThemNhanVien(?, ?, ?, ?, ?, ?, ?); END;");
            preparedStatement.setString(1, temp.txt_TenNhanVien.getText().toString());
            preparedStatement.setString(2, temp.txt_ChucVu.getText().toString());
            preparedStatement.setString(3, temp.txt_SoDT.getText().toString());
            String sex="";
            if(temp.rdo_Nam.isSelected()==true)
            {
                sex="Nam";
            }
            else
            {
                sex="Nữ";
            }
            preparedStatement.setString(4,sex);
            preparedStatement.setString(5, temp.txt_TenDangNhap.getText().toString());
            preparedStatement.setString(6, temp.txt_NgaySinh.getText().toString());
            preparedStatement.setString(7, fileName); 
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null,"Thêm thành công");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Thêm thất bại");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showConfirmDialog(null, ex);
        }
        Goc.initNhanVien();
        Goc.initTable();
    }
    public void timKiem()
    {
        if(Goc.txt_Search.getText().isEmpty())
        {
            Goc.initNhanVien();
            Goc.initTable();
        }
        else
        {
            Goc.nhanviens.clear();
            try {
                Connect.Connect();
                String searchText = Goc.txt_Search.getText().trim();
                String sql="SELECT * FROM Admin.NhanVien WHERE (MaNV LIKE ?  OR TenNV LIKE ?) ORDER BY MaNV ASC";
                PreparedStatement statement = Connect.conn.prepareStatement(sql);
                statement.setString(1, "%" + searchText + "%"); // Search within name
                statement.setString(2, "%" + searchText + "%"); // Search within ID (optional)

                ResultSet result = statement.executeQuery();
                while(result.next())
                {
                    NhanVien temp= new NhanVien();
                    temp.setMaNV(result.getInt(1));
                    temp.setTenNV(result.getString(2));
                    temp.setChucVu(result.getString(3));
                    temp.setSoDT(result.getString(4));
                    temp.setGioiTinh(result.getString(5));
                    temp.setTenDangNhap(result.getString(6));
                    Date ngaysinh=result.getDate(7);
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String ngayGioFormatted = sdf.format(ngaysinh);
                    temp.setNgaySinh(ngayGioFormatted);
                    Goc.nhanviens.add(temp);
                }
            } catch (SQLException ex) {
                Logger.getLogger(formNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
            Goc.initTable();
            }
    }
   
  public void EditNhanVien() 
  {
    Connect.Connect();
        try {
            // Sử dụng đường dẫn ảnh được lưu trữ nếu nó không phải là null
            String imagePath = Goc.selectedImagePath;
            String fileName = "";
            if (imagePath != null) {
                fileName = imagePath.substring(imagePath.lastIndexOf("\\") + 1);
            }

            // Chuẩn bị câu lệnh SQL với cả cột HinhAnh
            PreparedStatement preparedStatement = Connect.conn.prepareStatement(
                "UPDATE Admin.NhanVien SET TenNV=?, ChucVu=?, SDT=?, GioiTinh=?, TenDangNhap=?, NgaySinh=?, HinhAnh=? WHERE MaNV=?"
            );
            preparedStatement.setString(1, Goc.txt_TenNhanVien.getText());
            preparedStatement.setString(2, Goc.txt_ChucVu.getText());
            preparedStatement.setString(3, Goc.txt_SoDT.getText());

            String sex = Goc.rdo_Nam.isSelected() ? "Nam" : "Nữ";
            preparedStatement.setString(4, sex);
            preparedStatement.setString(5, Goc.txt_TenDangNhap.getText());
            preparedStatement.setString(6, Goc.txt_NgaySinh.getText());
            preparedStatement.setString(7, fileName); // Đặt tên tệp hình ảnh vào đây
            preparedStatement.setString(8, Goc.txt_MaNhanVien.getText());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Sửa Thành công");
                Goc.initNhanVien();
                Goc.initTable();
            } else {
                JOptionPane.showMessageDialog(null, "Sửa Thất Bại");
            }
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
    }

    public static ArrayList<String> layDSNhanVien() 
    {
        ArrayList<String> dsNhanVien = new ArrayList();
        try{
            Connect helper = new Connect();
            helper.Connect();
            String sql = "select distinct TenNV from Admin.NhanVien";
            Statement statement = Connect.conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
                dsNhanVien.add(String.valueOf(rs.getString("TenNV")));
            }  
        }
        catch(Exception ex){
                    System.out.println(ex.getMessage());
        }
        return dsNhanVien;
    }

    
    public void deleteNhanVien()
    {
        Connect.Connect();
            try{
                
                PreparedStatement preparedStatement=Connect.conn.prepareStatement("Delete from Admin.NhanVien where MaNV=?");
                preparedStatement.setString(1,Goc.txt_MaNhanVien.getText().toString());
           
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null,"Xóa thành công");
                    Goc.initNhanVien();
                    Goc.initTable();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Xóa thất bại");
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showConfirmDialog(null, ex);
            }
    }
    
    public int layidNhanVienTheoTen(String tenNV) {
    int maNV = -1; // Giá trị mặc định khi không tìm thấy khách hàng
    String sql = "select MaNV from Admin.NhanVien where TenNV = ?";
    Connect helper = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    try {
        helper = new Connect();
        helper.Connect();
        statement = helper.conn.prepareStatement(sql);
        statement.setString(1, tenNV);
        rs = statement.executeQuery();
        if (rs.next()) {
            maNV = rs.getInt("MaNV");
        }
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    } finally {
        // Đóng ResultSet, statement và kết nối
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (helper != null) {
            try {
                helper.conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    return maNV;
}
    
    
}
