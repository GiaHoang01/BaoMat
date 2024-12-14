/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Gui.FormDatPhong;
import Gui.PhongFrom;
import Gui.formNhanVien;
import Pojo.Connect;
import Pojo.NhanVien;
import Pojo.Phong;
import Pojo.PhongView;
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
import javax.swing.JOptionPane;

/**
 *
 * @author 84862
 */
public class PhongDao {
    PhongFrom pf;
    FormDatPhong dp;
    LoaiPhongDao lpD=new LoaiPhongDao();
    TrangThaiDao ttD=new TrangThaiDao();
    public PhongDao(PhongFrom phongForm) {
        this.pf = phongForm;
    }
    public PhongDao(FormDatPhong datphong) {
        this.dp = datphong;
    }
    public List<PhongView> ListPhong(List<PhongView> phongs)
    {
        phongs = new ArrayList<>();
        try {
            Connect.Connect();
            String sql="SELECT Admin.Phong.MaPhong,Admin.LoaiPhong.LoaiPhong,Admin.Phong.SoNguoiToiDa,Admin.TrangThai.TenTrangThai FROM Admin.Phong,Admin.TrangThai,Admin.LoaiPhong where Admin.Phong.MaTrangThai=Admin.TrangThai.MaTT and  Admin.Phong.MaLoaiPhong= Admin.LoaiPhong.MaLoaiPhong ORDER BY Admin.Phong.MaPhong ASC";
            Statement statement=Connect.conn.createStatement();
            ResultSet result=statement.executeQuery(sql);
            while(result.next())
            {
                PhongView temp= new PhongView();
                temp.setMaPhong(result.getInt(1));
                temp.setTenLoaiPhong(result.getString(2));
                temp.setSoNguoiToiDa(result.getInt(3));
                temp.setTenTrangThai(result.getString(4));
                phongs.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(formNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return phongs;
    }
    public List<PhongView> ListPhongTheoLoaiPhong(List<PhongView> phongs,String tenLoaiPhong)
    {
        phongs.clear();
        phongs = new ArrayList<>();
        try {
            Connect.Connect();
            String sql="SELECT Admin.Phong.MaPhong,Admin.LoaiPhong.LoaiPhong,Admin.Phong.SoNguoiToiDa,Admin.TrangThai.TenTrangThai FROM Admin.Phong,Admin.TrangThai,Admin.LoaiPhong where Admin.Phong.MaTrangThai=Admin.TrangThai.MaTT and  Admin.Phong.MaLoaiPhong= Admin.LoaiPhong.MaLoaiPhong and Admin.LoaiPhong.LoaiPhong='"+tenLoaiPhong+"' ORDER BY Admin.Phong.MaPhong ASC";
            Statement statement=Connect.conn.createStatement();
            ResultSet result=statement.executeQuery(sql);
            while(result.next())
            {
                PhongView temp= new PhongView();
                temp.setMaPhong(result.getInt(1));
                temp.setTenLoaiPhong(result.getString(2));
                temp.setSoNguoiToiDa(result.getInt(3));
                temp.setTenTrangThai(result.getString(4));
                phongs.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(formNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return phongs;
    }
    
    public void themPhong()
    {
        Connect.Connect();
        try{
            PreparedStatement preparedStatement=Connect.conn.prepareStatement("BEGIN INSERT INTO Admin.PHONG VALUES(?,?,?,?); END;");
            preparedStatement.setString(1, pf.txt_MaLoaiPhong.getText().toString());
            int maLop=lpD.SearchLoaiPhong(pf.cbo_LoaiPhong.getSelectedItem().toString());
            preparedStatement.setInt(2,maLop);
            preparedStatement.setString(3, pf.txt_SoNguoi.getText().toString());
            int maTrangThai=(ttD.SearchTrangThai(pf.cbo_TrangThai.getSelectedItem().toString()));
            preparedStatement.setInt(4,maTrangThai);
            
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
    }
  public void suaPhong() 
  {
    Connect.Connect();
    try {
        String sql = "UPDATE Admin.PHONG SET MaLoaiPhong = ?, SoNguoiToiDa = ?, MaTrangThai = ? WHERE MaPhong = ?";
        PreparedStatement preparedStatement = Connect.conn.prepareStatement(sql);

        int maLop = lpD.SearchLoaiPhong(pf.cbo_LoaiPhong.getSelectedItem().toString());
        preparedStatement.setInt(1, maLop);
        
        preparedStatement.setString(2, pf.txt_SoNguoi.getText().toString());
        
        int maTrangThai = ttD.SearchTrangThai(pf.cbo_TrangThai.getSelectedItem().toString());
        preparedStatement.setInt(3, maTrangThai);
        
        preparedStatement.setString(4, pf.txt_MaLoaiPhong.getText().toString());

        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Sửa thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Sửa thất bại");
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
    } finally 
        {
        // Đóng kết nối sau khi hoàn thành công việc
            try {
                if (Connect.conn != null && !Connect.conn.isClosed()) {
                    Connect.conn.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng kết nối: " + e.getMessage());
            }
        }
    }
    public void deletePhong()
    {
        Connect.Connect();
            try{
                
                PreparedStatement preparedStatement=Connect.conn.prepareStatement("Delete from Admin.Phong where MaPhong=?");
                preparedStatement.setString(1,pf.txt_MaLoaiPhong.getText().toString());
           
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null,"Xóa thành công");
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
    
    public boolean kiemTraTrangThaiPhong(int maPhong)
    {
        String query = "SELECT TT.TenTrangThai FROM Admin.Phong P join Admin.TrangThai TT on TT.MaTT=P.MaTrangThai WHERE MaPhong =?";
        Connect helper = null;
        ResultSet rs = null;
        String ten="";
        PreparedStatement statement = null;
        try {
            helper = new Connect();
            helper.Connect();
            statement = helper.conn.prepareStatement(query);
            statement.setInt(1, maPhong);
            rs = statement.executeQuery();
            while (rs.next()) {
                ten=rs.getString("TenTrangThai");
            } 
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        if(ten.equals("Trống"))
        {
            return true;
        }
        return false;
    }
    
    
}
