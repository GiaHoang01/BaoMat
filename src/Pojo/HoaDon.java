/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojo;

import java.math.BigDecimal;

/**
 *
 * @author AD
 */
public class HoaDon {
    private int maHD;
    private BigDecimal tongTien;
    private BigDecimal phiPhatSinh;
    private BigDecimal thanhToan;
    private String ghiChu;
    private int maNV;
    private int maKH;

    public HoaDon() {
    }

    public HoaDon(int maHD, BigDecimal tongTien, BigDecimal phiPhatSinh, BigDecimal thanhToan, String ghiChu, int maNV, int maKH) {
        this.maHD = maHD;
        this.tongTien = tongTien;
        this.phiPhatSinh = phiPhatSinh;
        this.thanhToan = thanhToan;
        this.ghiChu = ghiChu;
        this.maNV = maNV;
        this.maKH = maKH;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public BigDecimal getPhiPhatSinh() {
        return phiPhatSinh;
    }

    public void setPhiPhatSinh(BigDecimal phiPhatSinh) {
        this.phiPhatSinh = phiPhatSinh;
    }

    public BigDecimal getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(BigDecimal thanhToan) {
        this.thanhToan = thanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }
   
    
}
