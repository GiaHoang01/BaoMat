/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Dao;
import Gui.formNhanVien;
import Pojo.Connect;
import Pojo.KhachHang;
import Pojo.LoaiPhong;
import Pojo.Phong;
import Pojo.PhongView;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 84862
 */
public class LoaiPhongDao {

    public LoaiPhongDao() {
    }
    
    public BigDecimal SearchGiaPhong(int maPhong)
    {
        String sql = "Select Admin.LoaiPhong.GiaThue from Admin.LoaiPhong join Admin.Phong on Admin.phong.maloaiphong=Admin.loaiphong.maloaiphong where MaPhong=?";
        Connect helper = null;
        ResultSet rs = null;
        BigDecimal temp= new BigDecimal("0.0");
        PreparedStatement statement = null;
        try {
            helper = new Connect();
            helper.Connect();
            statement = helper.conn.prepareStatement(sql);
            statement.setInt(1, maPhong);
            rs = statement.executeQuery();
            while (rs.next()) {
                temp=rs.getBigDecimal("GIATHUE");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return temp;
    }
    public int SearchLoaiPhong(String tenLoaiPhong)
    {
        String sql = "Select Admin.LoaiPhong.MaLoaiPhong from Admin.LoaiPhong where LoaiPhong=?";
        Connect helper = null;
        ResultSet rs = null;
        int temp=0;
        PreparedStatement statement = null;
        try {
            helper = new Connect();
            helper.Connect();
            statement = helper.conn.prepareStatement(sql);
            statement.setString(1, tenLoaiPhong);
            rs = statement.executeQuery();
            while (rs.next()) {
                temp=rs.getInt("MaLoaiPhong");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return temp;
    }

    public static boolean xoaKhachHang(int maKH) {
        try {
            String sql = "DELETE FROM Admin.KHACHHANG WHERE MaKH=?";
            Connect helper = new Connect();
            helper.Connect();
            PreparedStatement statement = helper.conn.prepareStatement(sql);
            statement.setInt(1, maKH);
            int result = statement.executeUpdate();
            return result > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public List<LoaiPhong> ListPhong(List<LoaiPhong> phongs)
    {
        phongs = new ArrayList<>();
        try {
            Connect.Connect();
            String sql="SELECT  * FROM Admin.LoaiPhong ORDER BY Admin.LoaiPhong.MaLoaiPhong ASC";
            Statement statement=Connect.conn.createStatement();
            ResultSet result=statement.executeQuery(sql);
            while(result.next())
            {
                LoaiPhong temp= new LoaiPhong();
                temp.setMaLoaiPhong(result.getInt(1));
                temp.setLoaiPhong(result.getString(2));
                temp.setGiathue(result.getBigDecimal(3));
               
                phongs.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(formNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return phongs;
    }
}
