/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;

/**
 *
 * @author 84862
 */
public class ChiTietHoaDon {
    int maCTHD;
    int maHD;
    int maPhong;
    Date tgDat;
    Date tgTra;

    public Date getTgDat() {
        return tgDat;
    }

    public void setTgDat(Date tgDat) {
        this.tgDat = tgDat;
    }

    public Date getTgTra() {
        return tgTra;
    }

    public void setTgTra(Date tgTra) {
        this.tgTra = tgTra;
    }

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int maCTHD, int maHD, int maPhong, Date tgDat, Date tgTra) {
        this.maCTHD = maCTHD;
        this.maHD = maHD;
        this.maPhong = maPhong;
        this.tgDat = tgDat;
        this.tgTra = tgTra;
    }

    public int getMaCTHD() {
        return maCTHD;
    }

    public void setMaCTHD(int maCTHD) {
        this.maCTHD = maCTHD;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }
}
