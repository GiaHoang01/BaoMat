/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Pojo.Connect;
import Gui.FrmTong;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 84862
 */
public class DangKyDao {

    private static PublicKey publicKey;
    private static PrivateKey privateKey;

    static {
        try {
            // Tạo cặp khóa RSA khi khởi tạo class (khởi tạo một lần)
            KeyPair keyPair = EncryptionHelperDao.generateRSAKeyPair();
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean ketNoiDangKyCapQuyen(String tenTaiKhoan, String matKhau) {

        Statement stmt = null;
        try {
            // Kết nối đến cơ sở dữ liệu
            Connect.Connect();

            // Tắt auto-commit
            Connect.conn.setAutoCommit(false);
            try {
                String mahoamk = EncryptionHelperDao.encryptRSA(matKhau, publicKey);
                String insertTaiKhoanSQL = "INSERT INTO Admin.TaiKhoan (TenDangNhap, MatKhau) VALUES ('" + tenTaiKhoan + "', '" + mahoamk + "')";
                stmt = Connect.conn.createStatement();
                stmt.executeUpdate(insertTaiKhoanSQL);

            } catch (Exception ex) {
                Logger.getLogger(DangKyDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Thực hiện lệnh SQL để thêm tài khoản mới vào bảng TaiKhoan
//            // Thực hiện lệnh SQL để tạo người dùng mới trong cơ sở dữ liệu
            String createUserSQL = "CREATE USER " + tenTaiKhoan + " IDENTIFIED BY " + matKhau;
            stmt.executeUpdate(createUserSQL);

            // Cấp quyền cho người dùng mới
            String grantSQL = "GRANT nhanvien TO " + tenTaiKhoan;
            stmt.executeUpdate(grantSQL);

            String grantSQL1 = "GRANT UNLIMITED TABLESPACE TO " + tenTaiKhoan;
            stmt.executeUpdate(grantSQL1);

            String grantSQL2 = "GRANT REFERENCES(MaKH) ON Admin.KhachHang TO " + tenTaiKhoan;
            stmt.executeUpdate(grantSQL2);

            String grantSQL3 = "GRANT REFERENCES(MaNV) ON Admin.NhanVien TO " + tenTaiKhoan;
            stmt.executeUpdate(grantSQL3);

            String grantSQL4 = "GRANT ALTER SYSTEM TO " + tenTaiKhoan;
            stmt.executeUpdate(grantSQL4);

            String grantSQL5 = "GRANT SELECT ON v_$session TO " + tenTaiKhoan;
            stmt.executeUpdate(grantSQL5);
            // Commit giao dịch
            Connect.conn.commit();

            // Trả về true nếu tất cả lệnh SQL được thực hiện thành công
            return true;
        } catch (SQLException ex) {
            // Xảy ra lỗi, hủy bỏ giao dịch và hiển thị thông báo lỗi
            try {
                if (Connect.conn != null) {
                    Connect.conn.rollback();
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            // Đóng các tài nguyên
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (Connect.conn != null) {
                    Connect.conn.setAutoCommit(true); // Bật lại auto-commit
                    Connect.conn.close();
                }
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
    }

}
