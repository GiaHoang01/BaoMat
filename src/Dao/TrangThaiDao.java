/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Gui.formNhanVien;
import Pojo.Connect;
import Pojo.LoaiPhong;
import Pojo.TrangThai;
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
public class TrangThaiDao {

    public TrangThaiDao() {
    }
    
    public List<TrangThai> ListTrangThai(List<TrangThai> trangthais)
    {
        trangthais = new ArrayList<>();
        try {
            Connect.Connect();
            String sql="SELECT  * FROM Admin.TrangThai ORDER BY Admin.TrangThai.MaTT ASC";
            Statement statement=Connect.conn.createStatement();
            ResultSet result=statement.executeQuery(sql);
            while(result.next())
            {
                TrangThai temp= new TrangThai();
                temp.setMaTrangThai(result.getInt(1));
                temp.setTenTrangThai(result.getString(2));
                trangthais.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(formNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return trangthais;
    }
    
     public int SearchTrangThai(String tenTrangThai)
    {
        String sql = "Select Admin.TrangThai.MaTT from Admin.TrangThai where TenTrangThai=?";
        Connect helper = null;
        ResultSet rs = null;
        int temp=0;
        PreparedStatement statement = null;
        try {
            helper = new Connect();
            helper.Connect();
            statement = helper.conn.prepareStatement(sql);
            statement.setString(1, tenTrangThai);
            rs = statement.executeQuery();
            while (rs.next()) {
                temp=rs.getInt("MaTT");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return temp;
    }
}
