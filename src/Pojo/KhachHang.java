/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojo;

/**
 *
 * @author HUU KHANH
 */
public class KhachHang {
    private int MaKH;
    private String SoCMND;
    private String TenKH;
    private String SDT;
    private String GioiTinh;

    public KhachHang() {
    }

    public KhachHang(int MaKH, String SoCMND, String TenKH, String SDT, String GioiTinh) {
        this.MaKH = MaKH;
        this.SoCMND = SoCMND;
        this.TenKH = TenKH;
        this.SDT = SDT;
        this.GioiTinh = GioiTinh;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public String getSoCMND() {
        return SoCMND;
    }

    public void setSoCMND(String SoCMND) {
        this.SoCMND = SoCMND;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
    
}
