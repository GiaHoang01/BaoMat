/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Pojo.Connect;
import java.sql.SQLException;
import Pojo.HoaDon;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.CallableStatement;

import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
//import Pojo.Connect;
//import Pojo.HoaDon;
/**
 *
 * @author AD
 */
public class HoaDonDao {
    public void updateStatePhong(int maHD)
    {
        Connect.Connect();
        
        CallableStatement callableStatement = null;

        try {
            String sql = "{CALL Admin.UpdateRoomAndInvoiceStatus(?)}";
            callableStatement = Connect.conn.prepareCall(sql);
            callableStatement.setInt(1, maHD);

            // Execute the stored procedure
            callableStatement.execute();
            JOptionPane.showMessageDialog(null, "Thanh toán thành công");
            // Check if any rows were updated
            
           
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Thanh toán thất bại : " + ex.getMessage());
        } 
        finally 
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
     public ArrayList<HoaDon> layDSHoaDonChuaThanhToan()
    {
        ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
        try{
            String sql = "select * from Admin.HoaDon where GhiChu='chưa thanh toán'";
            Connect helper = new Connect();
            helper.Connect();
            Statement statement = Connect.conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt("MaHD"));
                hd.setMaNV(rs.getInt("MaNV"));
                hd.setMaKH(rs.getInt("MaKH"));
                hd.setPhiPhatSinh(rs.getBigDecimal("PhiPhatSinh"));
                hd.setTongTien(rs.getBigDecimal("TongTien"));
                hd.setThanhToan(rs.getBigDecimal("ThanhToan"));
                hd.setGhiChu(rs.getString("GhiChu"));
                ds.add(hd);
            
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return ds;
    }
    public ArrayList<HoaDon> layDSHoaDon()
    {
        ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
        try{
            String sql = "select * from Admin.HoaDon";
            Connect helper = new Connect();
            helper.Connect();
            Statement statement = Connect.conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt("MaHD"));
                hd.setMaNV(rs.getInt("MaNV"));
                hd.setMaKH(rs.getInt("MaKH"));
                hd.setPhiPhatSinh(rs.getBigDecimal("PhiPhatSinh"));
                hd.setTongTien(rs.getBigDecimal("TongTien"));
                hd.setThanhToan(rs.getBigDecimal("ThanhToan"));
                hd.setGhiChu(rs.getString("GhiChu"));
                ds.add(hd);
            
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return ds;
    }
    
    public static ArrayList<Integer> layDSMaHD()
    {
        ArrayList<Integer> dsHoaDon = new ArrayList();
        try{
            Connect helper = new Connect();
            helper.Connect();
            String sql = "select distinct MaHD from Admin.HoaDon";
            Statement statement = Connect.conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
                dsHoaDon.add(rs.getInt("MaHD"));
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return dsHoaDon;
    }
    
    public boolean themHoaDon(HoaDon hd)
    {
        String sql = "BEGIN Admin.ThemHoaDon(?,?); END;";
        Connect helper = null;
        PreparedStatement statement = null;
        try{
            helper = new Connect();
            helper.Connect();
            statement = helper.conn.prepareStatement(sql);
            statement.setInt(1, hd.getMaNV());
            statement.setInt(2, hd.getMaKH());
            String temp = sql;
            int result = statement.executeUpdate();
            return result > 0;
        } catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            if(statement != null)
            {
                try{
                    statement.close();
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            if(helper != null){
                try{
                    helper.conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static boolean xoaHoaDon(int maHD) {
        try {
            String sql = "delete from Admin.HoaDon where MAHD = ?";
            Connect helper = new Connect();
            helper.Connect();
            PreparedStatement statement = helper.conn.prepareStatement(sql);
            statement.setInt(1, maHD);
            int result = statement.executeUpdate();
            return result > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static boolean capNhatHoaDon(HoaDon hd) {
        try {
            String sql = "update Admin.HoaDon set MaNV = ?, MaKH = ?, TongTien = ?, PhiPhatSinh = ?, ThanhToan = ?,GhiChu=? where maHD = ?";
            Connect helper = new Connect();
            helper.Connect();
            PreparedStatement statement = helper.conn.prepareStatement(sql);
            statement.setInt(1, hd.getMaNV());
            statement.setInt(2, hd.getMaKH());
            statement.setBigDecimal(3,hd.getTongTien());
            statement.setBigDecimal(4, hd.getPhiPhatSinh());
            statement.setBigDecimal(5, hd.getThanhToan());
            statement.setString(6, hd.getGhiChu());
            statement.setInt(7, hd.getMaHD());
            int result = statement.executeUpdate();
            return result > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
