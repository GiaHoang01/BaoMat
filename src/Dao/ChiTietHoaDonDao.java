/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Pojo.Connect;
import Pojo.ChiTietHoaDon;
import java.util.Date;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author 84862
 */
public class ChiTietHoaDonDao {
    
     private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    public ArrayList<ChiTietHoaDon> layDSChiTietHoaDon() {
        ArrayList<ChiTietHoaDon> ds = new ArrayList<ChiTietHoaDon>();
        try {
            String sql = "select * from Admin.ChiTietHoaDon";
            Connect helper = new Connect();
            helper.Connect();
            Statement statement = Connect.conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setMaCTHD(rs.getInt("MaCTHD"));
                cthd.setMaHD(rs.getInt("MaHD"));
                cthd.setMaPhong(rs.getInt("MaPhong"));
                cthd.setTgDat(rs.getDate("ThoiGianDat"));
                cthd.setTgTra(rs.getDate("ThoiGianTra"));
                ds.add(cthd);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ds;
    }
    
    public ArrayList<ChiTietHoaDon> layDSChiTietHoaDonTheoMaHD(int MaHD) {
        ArrayList<ChiTietHoaDon> ds = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Admin.ChiTietHoaDon WHERE MaHD = ?";
            Connect helper = new Connect();
            helper.Connect();
            PreparedStatement statement = Connect.conn.prepareStatement(sql);
            statement.setInt(1, MaHD);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setMaCTHD(rs.getInt("MaCTHD"));
                cthd.setMaHD(rs.getInt("MaHD"));
                cthd.setMaPhong(rs.getInt("MaPhong"));

                // Lấy ngày tháng trực tiếp từ ResultSet như là java.sql.Date
                java.sql.Date thoiGianDat = rs.getDate("ThoiGianDat");
                java.sql.Date thoiGianTra = rs.getDate("ThoiGianTra");

                cthd.setTgDat(thoiGianDat);
                cthd.setTgTra(thoiGianTra);

                ds.add(cthd);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ds;
    }
    
    public boolean themChiTietHoaDon(ChiTietHoaDon cthd) {
        String sql = "BEGIN Admin.ThemChiTietHoaDon(?,?,?,?); END;";
        Connect helper = null;
        PreparedStatement statement = null;
        try {
            helper = new Connect();
            helper.Connect();
            statement = helper.conn.prepareStatement(sql);
            statement.setInt(1, cthd.getMaHD());
            statement.setInt(2, cthd.getMaPhong());
            
            java.sql.Date thoiGianDat = new java.sql.Date(dateFormat.parse(dateFormat.format(cthd.getTgDat())).getTime());
            java.sql.Date thoiGianTra = new java.sql.Date(dateFormat.parse(dateFormat.format(cthd.getTgTra())).getTime());

            // Thiết lập giá trị ngày tháng cho statement
            statement.setDate(3, thoiGianDat);
            statement.setDate(4, thoiGianTra);
            int result = statement.executeUpdate();
            return result > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
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
    }
    
    public static boolean xoaChiTietHoaDon(int maCTHD) {
        try {
            String sql = "delete from Admin.ChiTietHoaDon where MaCTHD = ?";
            Connect helper = new Connect();
            helper.Connect();
            PreparedStatement statement = helper.conn.prepareStatement(sql);
            statement.setInt(1, maCTHD);
            int result = statement.executeUpdate();
            return result > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public static boolean capNhatChiTietHD(ChiTietHoaDon cthd) {

        Connect.Connect();
        try {
            PreparedStatement preparedStatement = Connect.conn.prepareStatement("update Admin.ChiTietHoaDon set MaHD = ?, MaPhong = ?, ThoiGianDat = ?, ThoiGianTra = ? where MaCTHD=?");
            preparedStatement.setInt(1,cthd.getMaHD());
            preparedStatement.setInt(2,cthd.getMaPhong());
            java.sql.Date thDat= new java.sql.Date(cthd.getTgDat().getTime());
            preparedStatement.setDate(3,thDat);
            
            java.sql.Date tgTra= new java.sql.Date(cthd.getTgTra().getTime());
            preparedStatement.setDate(4,tgTra);
            
            preparedStatement.setInt(5, cthd.getMaCTHD());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Sửa Thành công");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Sửa Thất Bại");
                return false;
            }
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex);
            return false;
        }
    }
}
