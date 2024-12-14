/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojo;

import java.math.BigDecimal;

/**
 *
 * @author 84862
 */
public class LoaiPhong {
    private int maLoaiPhong;
    private String loaiPhong;
    private BigDecimal giathue;

    public int getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(int maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public BigDecimal getGiathue() {
        return giathue;
    }

    public void setGiathue(BigDecimal giathue) {
        this.giathue = giathue;
    }

    public LoaiPhong() {
    }

    public LoaiPhong(int maLoaiPhong, String loaiPhong, BigDecimal giathue) {
        this.maLoaiPhong = maLoaiPhong;
        this.loaiPhong = loaiPhong;
        this.giathue = giathue;
    }
    
}
