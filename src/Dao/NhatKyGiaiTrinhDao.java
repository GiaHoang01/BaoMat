package Dao;

import Pojo.Connect;
import Pojo.EmployeeAudit;
import java.sql.Timestamp;  // Đã sửa import
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class NhatKyGiaiTrinhDao {
    public static ArrayList<EmployeeAudit> layDanhSachLichSu() {
        ArrayList<EmployeeAudit> ds = new ArrayList<EmployeeAudit>();
        try {
            String sql = "SELECT * FROM Admin.employee_audit";
            Connect helper = new Connect();
            helper.Connect();
            Statement statement = Connect.conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                EmployeeAudit ls = new EmployeeAudit();
                ls.setActionType(rs.getString("Action_Type"));
                ls.setActionTime(rs.getTimestamp("Action_Time"));
                ls.setUserName(rs.getString("User_Name"));
                ds.add(ls);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ds;
    }
}
