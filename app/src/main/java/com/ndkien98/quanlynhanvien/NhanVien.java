package com.ndkien98.quanlynhanvien;

import android.widget.ImageView;

public class NhanVien {

    private int id;
    private String hoTen;
    private String namSinh;
    private String phongBan;
    private int luong;
    private String diaChi;
    private int quyen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getQuyen() {
        return quyen;
    }

    public void setQuyen(int quyen) {
        this.quyen = quyen;
    }

    public NhanVien(int id, String hoTen, String diaChi, String phongBan, String namSinh, int luong,int quyen) {
        this.id = id;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.phongBan = phongBan;
        this.luong = luong;
        this.diaChi = diaChi;
        this.quyen = quyen;
    }

    public NhanVien() {
    }
}
