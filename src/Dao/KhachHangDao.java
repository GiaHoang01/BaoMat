/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Pojo.Connect;
import Pojo.KhachHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author HUU KHANH
 */
public class KhachHangDao {
    
    
   public int SearchMaKhachHang(String tenKhachHang)
    {
        String sql = "Select Admin.KhachHang.MaKhachHang from Admin.KhachHang where MaKhachHang=?";
        Connect helper = null;
        ResultSet rs = null;
        int temp=0;
        PreparedStatement statement = null;
        try {
            helper = new Connect();
            helper.Connect();
            statement = helper.conn.prepareStatement(sql);
            statement.setString(1, tenKhachHang);
            rs = statement.executeQuery();
            while (rs.next()) {
                temp=rs.getInt("MaKhachHang");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return temp;
    }
    public String SearchTenKhachHang(int maKH)
    {
        String sql = "Select Admin.KhachHang.TenKH from Admin.KhachHang where MaKH=?";
        Connect helper = null;
        ResultSet rs = null;
        String temp="";
        PreparedStatement statement = null;
        try {
            helper = new Connect();
            helper.Connect();
            statement = helper.conn.prepareStatement(sql);
            statement.setInt(1, maKH);
            rs = statement.executeQuery();
            while (rs.next()) {
                temp=rs.getString("TenKH");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return temp;
    }
    
    
    public static ArrayList<KhachHang> layDanhSachKhachHang()
    {
        ArrayList<KhachHang> ds=new ArrayList<KhachHang>();
        try
        {
            String sql="select * from Admin.KHACHHANG";
            Connect helper=new Connect();
            helper.Connect();
            Statement statement=Connect.conn.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            while(rs.next())
            {
                KhachHang ls=new KhachHang();
                ls.setMaKH(rs.getInt("MaKH"));
                ls.setSoCMND(rs.getString("SoCMND"));
                ls.setTenKH(rs.getString("TenKH"));
                ls.setSDT(rs.getString("SDT"));
                ls.setGioiTinh(rs.getString("GioiTinh"));
                ds.add(ls);
            }            
        }
        catch(Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
        return ds;
    }
    public static boolean themKhachHang(KhachHang kh) 
    {
        String sql = "BEGIN Admin.ThemKhachHang(?, ?, ?, ?); END;";
        Connect helper = null;
        PreparedStatement statement = null;
        try {
            helper = new Connect();
            helper.Connect();
            statement = helper.conn.prepareStatement(sql);
            statement.setString(1, kh.getSoCMND());
            statement.setString(2, kh.getTenKH());
            statement.setString(3, kh.getSDT());
            statement.setString(4, kh.getGioiTinh());
            String temp=sql;
            int result = statement.executeUpdate();
            return result > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            // Đóng statement và kết nối
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

    public static boolean capNhatKhachHang(KhachHang kh) {
        try {
            String sql = "UPDATE Admin.KHACHHANG SET SoCMND = ?, TenKH = ?, SDT = ?, GioiTinh = ? where MaKH=?";
            Connect helper = new Connect();
            helper.Connect();
            PreparedStatement statement = helper.conn.prepareStatement(sql);
            statement.setString(1, kh.getSoCMND());
            statement.setString(2, kh.getTenKH());
            statement.setString(3,kh.getSDT());
            statement.setString(4, kh.getGioiTinh());
            statement.setInt(5, kh.getMaKH());
            int result = statement.executeUpdate();
            return result > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static ArrayList<String> layDSMaKH() 
    {
        ArrayList<String> dsKhachHang = new ArrayList();
        try{
            Connect helper = new Connect();
            helper.Connect();
            String sql = "select distinct TenKH from Admin.KhachHang";
            Statement statement = Connect.conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
                dsKhachHang.add(String.valueOf(rs.getString("TenKH")));
            }  
        }
        catch(Exception ex){
                    System.out.println(ex.getMessage());
        }
        return dsKhachHang;
    }
    public static ArrayList<KhachHang> timKhachHang(String keyword) {
        ArrayList<KhachHang> ds = new ArrayList<KhachHang>();
        String sql = "SELECT * FROM Admin.KHACHHANG WHERE TenKH LIKE ? OR SoCMND LIKE ?";
        Connect helper = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            helper = new Connect();
            helper.Connect();
            statement = helper.conn.prepareStatement(sql);
            String searchKeyword = "%" + keyword + "%";
            statement.setString(1, searchKeyword);
            statement.setString(2, searchKeyword);
            rs = statement.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt("MaKH"));
                kh.setSoCMND(rs.getString("SoCMND"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setSDT(rs.getString("SDT"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                ds.add(kh);
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
        return ds;
    }
    
    
    public KhachHang layKhachHangTheoMa(String tenKH) {
        KhachHang kh = new KhachHang();
        String sql = "SELECT * FROM Admin.KHACHHANG WHERE TenKH=?";
        Connect helper = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            helper = new Connect();
            helper.Connect();
            statement = helper.conn.prepareStatement(sql);
            statement.setString(1, tenKH);
            rs = statement.executeQuery();
            while (rs.next()) {
               
                kh.setMaKH(rs.getInt("MaKH"));
                kh.setSoCMND(rs.getString("SoCMND"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setSDT(rs.getString("SDT"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
               
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
        return kh;
    }
    
    public int layidKhachHangTheoTen(String tenKH) {
    int maKH = -1; // Giá trị mặc định khi không tìm thấy khách hàng
    String sql = "select maKH from Admin.KhachHang where tenKH = ?";
    Connect helper = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    try {
        helper = new Connect();
        helper.Connect();
        statement = helper.conn.prepareStatement(sql);
        statement.setString(1, tenKH);
        rs = statement.executeQuery();
        if (rs.next()) {
            maKH = rs.getInt("MaKH");
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
    return maKH;
}

}
