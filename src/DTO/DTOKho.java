/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Administrator
 */
public class DTOKho {
    int IDKho;
    int IDSanPham;
    int IDPhieuNhap;
    int TonKho;
    int HangDangVe;
    int TrangThai;

    public DTOKho() {
    }
    

    public DTOKho(int IDKho, int IDSanPham, int IDPhieuNhap, int TonKho, int HangDangVe, int TrangThai) {
        this.IDKho = IDKho;
        this.IDSanPham = IDSanPham;
        this.IDPhieuNhap = IDPhieuNhap;
        this.TonKho = TonKho;
        this.HangDangVe = HangDangVe;
        this.TrangThai = TrangThai;
    }
    
    

    public DTOKho(int IDSanPham, int IDPhieuNhap, int TonKho, int HangDangVe, int TrangThai) {
        this.IDSanPham = IDSanPham;
        this.IDPhieuNhap = IDPhieuNhap;
        this.TonKho = TonKho;
        this.HangDangVe = HangDangVe;
        this.TrangThai = TrangThai;
    }

    public DTOKho(int IDSanPham, int TonKho, int TrangThai) {
        this.IDSanPham = IDSanPham;
        this.TonKho = TonKho;
        this.TrangThai = TrangThai;
    }

    public DTOKho(int IDSanPham, int TonKho, int HangDangVe, int TrangThai) {
        this.IDSanPham = IDSanPham;
        this.TonKho = TonKho;
        this.HangDangVe = HangDangVe;
        this.TrangThai = TrangThai;
    }

    public DTOKho(int IDSanPham, int TonKho) {
        this.IDSanPham = IDSanPham;
        this.TonKho = TonKho;
    }
    

    

   
    


    public int getIDKho() {
        return IDKho;
    }

    public void setIDKho(int IDKho) {
        this.IDKho = IDKho;
    }

    public int getIDSanPham() {
        return IDSanPham;
    }

    public void setIDSanPham(int IDSanPham) {
        this.IDSanPham = IDSanPham;
    }

    public int getIDPhieuNhap() {
        return IDPhieuNhap;
    }

    public void setIDPhieuNhap(int IDPhieuNhap) {
        this.IDPhieuNhap = IDPhieuNhap;
    }

    public int getTonKho() {
        return TonKho;
    }

    public void setTonKho(int TonKho) {
        this.TonKho = TonKho;
    }

    public int getHangDangVe() {
        return HangDangVe;
    }

    public void setHangDangVe(int HangDangVe) {
        this.HangDangVe = HangDangVe;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

  
}
