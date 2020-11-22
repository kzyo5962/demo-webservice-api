package com.example.testwebservice;

public class NhomPhuotModel {
    private int id;
    private String name;
    private String ngaydi;
    private int status;

    public NhomPhuotModel() {
    }

    public NhomPhuotModel(int id, String name, String ngaydi, int status) {
        this.id = id;
        this.name = name;
        this.ngaydi = ngaydi;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNgaydi() {
        return ngaydi;
    }

    public void setNgaydi(String ngaydi) {
        this.ngaydi = ngaydi;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
