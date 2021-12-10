package com.example.truyencuoi1.model;

public class HinhAnh {
    private  String ten;
    private  String icon;

    public HinhAnh(String ten, String icon) {
        this.ten = ten;
        this.icon = icon;
    }
    public HinhAnh() {

    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
