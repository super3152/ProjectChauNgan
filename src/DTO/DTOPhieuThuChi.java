/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author KMB1604
 */
public class DTOPhieuThuChi {
    
    int IDThuChi;
    String MaThuChi;
    int IDNhaCungCap;
    int IDKhachHang;
    int IDNguoiDung;
    String LoaiPhieu;
    String NgayTao;
    String HangMucThuChi;
    double TongTien;
    String GhiChu;

    public DTOPhieuThuChi() {
    }

    public DTOPhieuThuChi(String MaThuChi, int IDKhachHang, String LoaiPhieu, String HangMucThuChi, double TongTien, String GhiChu) {
        this.MaThuChi = MaThuChi;
        this.IDKhachHang = IDKhachHang;
        this.LoaiPhieu = LoaiPhieu;
        this.HangMucThuChi = HangMucThuChi;
        this.TongTien = TongTien;
        this.GhiChu = GhiChu;
    }

    public DTOPhieuThuChi(String MaThuChi, String LoaiPhieu, int IDNhaCungCap, String HangMucThuChi, double TongTien, String GhiChu) {
        this.MaThuChi = MaThuChi;
        this.LoaiPhieu = LoaiPhieu;
        this.IDNhaCungCap = IDNhaCungCap;
        this.HangMucThuChi = HangMucThuChi;
        this.TongTien = TongTien;
        this.GhiChu = GhiChu;
    }

      public DTOPhieuThuChi(String MaThuChi, String LoaiPhieu,  String HangMucThuChi,int IDNguoiDung, double TongTien, String GhiChu) {
        this.MaThuChi = MaThuChi;
        this.LoaiPhieu = LoaiPhieu;
        this.HangMucThuChi = HangMucThuChi;
        this.IDNguoiDung = IDNguoiDung;
        this.TongTien = TongTien;
        this.GhiChu = GhiChu;
    }
    
    public int getIDThuChi() {
        return IDThuChi;
    }

    public void setIDThuChi(int IDThuChi) {
        this.IDThuChi = IDThuChi;
    }

    public String getMaThuChi() {
        return MaThuChi;
    }

    public void setMaThuChi(String MaThuChi) {
        this.MaThuChi = MaThuChi;
    }

    public int getIDNhaCungCap() {
        return IDNhaCungCap;
    }

    public void setIDNhaCungCap(int IDNhaCungCap) {
        this.IDNhaCungCap = IDNhaCungCap;
    }

    public int getIDKhachHang() {
        return IDKhachHang;
    }

    public void setIDKhachHang(int IDKhachHang) {
        this.IDKhachHang = IDKhachHang;
    }

    public int getIDNguoiDung() {
        return IDNguoiDung;
    }

    public void setIDNguoiDung(int IDNguoiDung) {
        this.IDNguoiDung = IDNguoiDung;
    }

    public String getLoaiPhieu() {
        return LoaiPhieu;
    }

    public void setLoaiPhieu(String LoaiPhieu) {
        this.LoaiPhieu = LoaiPhieu;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getHangMucThuChi() {
        return HangMucThuChi;
    }

    public void setHangMucThuChi(String HangMucThuChi) {
        this.HangMucThuChi = HangMucThuChi;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
    
}
