/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojo;

/**
 *
 * @author 84862
 */
public class PhongView {
    private int maPhong;
    private String tenLoaiPhong;
    private int soNguoiToiDa;
    private String tenTrangThai;

    public PhongView() {
    }

    public PhongView(int maPhong, String tenLoaiPhong, int soNguoiToiDa, String tenTrangThai) {
        this.maPhong = maPhong;
        this.tenLoaiPhong = tenLoaiPhong;
        this.soNguoiToiDa = soNguoiToiDa;
        this.tenTrangThai = tenTrangThai;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public int getSoNguoiToiDa() {
        return soNguoiToiDa;
    }

    public void setSoNguoiToiDa(int soNguoiToiDa) {
        this.soNguoiToiDa = soNguoiToiDa;
    }

    public String getTenTrangThai() {
        return tenTrangThai;
    }

    public void setTenTrangThai(String tenTrangThai) {
        this.tenTrangThai = tenTrangThai;
    }
    
}
