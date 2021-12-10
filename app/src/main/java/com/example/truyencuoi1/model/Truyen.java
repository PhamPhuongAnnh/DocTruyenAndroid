package com.example.truyencuoi1.model;

public class Truyen {
    private  String ten;
    private String noidung;

    public Truyen(String ten, String noidung) {
        this.ten = ten;
        this.noidung = noidung;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
}
