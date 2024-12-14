/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojo;

/**
 *
 * @author 84862
 */
public class TrangThai {
    private int maTrangThai;
    private String tenTrangThai;

    public int getMaTrangThai() {
        return maTrangThai;
    }

    public void setMaTrangThai(int maTrangThai) {
        this.maTrangThai = maTrangThai;
    }

    public String getTenTrangThai() {
        return tenTrangThai;
    }

    public void setTenTrangThai(String tenTrangThai) {
        this.tenTrangThai = tenTrangThai;
    }

    public TrangThai() {
    }

    public TrangThai(int maTrangThai, String tenTrangThai) {
        this.maTrangThai = maTrangThai;
        this.tenTrangThai = tenTrangThai;
    }
    
}
