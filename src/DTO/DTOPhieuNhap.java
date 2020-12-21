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
public class DTOPhieuNhap {
    int IDPhieuNhap;
    int IDNhaCungCap;
    int IDNguoiDung;
    String SoPhieuNhap;
    String NgayNhap;
    double ThanhTien;
    String HinhThucThanhToan;
    String HinhThucNhap;
    int TrangThai;
    int NhapKho;
    int ThanhToan;
    double CongNo;
    String HanTraCongNo;
    String Tag;
    String GhiChu;

    public DTOPhieuNhap(int IDPhieuNhap, int IDNhaCungCap, int IDNguoiDung, String SoPhieuNhap, String NgayNhap, double ThanhTien, String HinhThucThanhToan, String HinhThucNhap, int TrangThai, int NhapKho, int ThanhToan, double CongNo, String HanTraCongNo, String Tag, String GhiChu) {
        this.IDPhieuNhap = IDPhieuNhap;
        this.IDNhaCungCap = IDNhaCungCap;
        this.IDNguoiDung = IDNguoiDung;
        this.SoPhieuNhap = SoPhieuNhap;
        this.NgayNhap = NgayNhap;
        this.ThanhTien = ThanhTien;
        this.HinhThucThanhToan = HinhThucThanhToan;
        this.HinhThucNhap = HinhThucNhap;
        this.TrangThai = TrangThai;
        this.NhapKho = NhapKho;
        this.ThanhToan = ThanhToan;
        this.CongNo = CongNo;
        this.HanTraCongNo = HanTraCongNo;
        this.Tag = Tag;
        this.GhiChu = GhiChu;
    }
    
    
     public DTOPhieuNhap(int IDPhieuNhap, int IDNhaCungCap, int IDNguoiDung, String SoPhieuNhap,  double ThanhTien, String HinhThucThanhToan, String HinhThucNhap, int TrangThai, int NhapKho, int ThanhToan, double CongNo,  String Tag, String GhiChu) {
        this.IDPhieuNhap = IDPhieuNhap;
        this.IDNhaCungCap = IDNhaCungCap;
        this.IDNguoiDung = IDNguoiDung;
        this.SoPhieuNhap = SoPhieuNhap;
        this.ThanhTien = ThanhTien;
        this.HinhThucThanhToan = HinhThucThanhToan;
        this.HinhThucNhap = HinhThucNhap;
        this.TrangThai = TrangThai;
        this.NhapKho = NhapKho;
        this.ThanhToan = ThanhToan;
        this.CongNo = CongNo;
      
        this.Tag = Tag;
        this.GhiChu = GhiChu;
    }

    public DTOPhieuNhap(int IDNhaCungCap, int IDNguoiDung, String SoPhieuNhap, String NgayNhap, double ThanhTien, String HinhThucThanhToan, String HinhThucNhap, int TrangThai, int NhapKho, int ThanhToan, double CongNo, String Tag, String GhiChu) {
        this.IDNhaCungCap = IDNhaCungCap;
        this.IDNguoiDung = IDNguoiDung;
        this.SoPhieuNhap = SoPhieuNhap;
        this.NgayNhap = NgayNhap;
        this.ThanhTien = ThanhTien;
        this.HinhThucThanhToan = HinhThucThanhToan;
        this.HinhThucNhap = HinhThucNhap;
        this.TrangThai = TrangThai;
        this.NhapKho = NhapKho;
        this.ThanhToan = ThanhToan;
        this.CongNo = CongNo;
        this.Tag = Tag;
        this.GhiChu = GhiChu;
    }

  public DTOPhieuNhap(int IDPhieuNhap) {
        this.IDPhieuNhap = IDPhieuNhap;
       
    }

    public DTOPhieuNhap(String SoPhieuNhap, String NgayNhap, int NhapKho) {
        this.SoPhieuNhap = SoPhieuNhap;
        this.NgayNhap = NgayNhap;
        this.NhapKho = NhapKho;
    }
  

    


  

    public DTOPhieuNhap(String SoPhieuNhap, String HinhThucThanhToan, int TrangThai, int ThanhToan, double CongNo, String HanTraCongNo) {
        this.SoPhieuNhap = SoPhieuNhap;
        this.HinhThucThanhToan = HinhThucThanhToan;
        this.TrangThai = TrangThai;
        this.ThanhToan = ThanhToan;
        this.CongNo = CongNo;
        this.HanTraCongNo = HanTraCongNo;
    }
    
    

    public DTOPhieuNhap(int IDPhieuNhap, double CongNo) {
        this.IDPhieuNhap = IDPhieuNhap;
        this.CongNo = CongNo;
    }

    public DTOPhieuNhap() {
       
    }

    

    public int getIDPhieuNhap() {
        return IDPhieuNhap;
    }

    public void setIDPhieuNhap(int IDPhieuNhap) {
        this.IDPhieuNhap = IDPhieuNhap;
    }

    public int getIDNhaCungCap() {
        return IDNhaCungCap;
    }

    public void setIDNhaCungCap(int IDNhaCungCap) {
        this.IDNhaCungCap = IDNhaCungCap;
    }

    public int getIDNguoiDung() {
        return IDNguoiDung;
    }

    public void setIDNguoiDung(int IDNguoiDung) {
        this.IDNguoiDung = IDNguoiDung;
    }

    public String getSoPhieuNhap() {
        return SoPhieuNhap;
    }

    public void setSoPhieuNhap(String SoPhieuNhap) {
        this.SoPhieuNhap = SoPhieuNhap;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(String NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public String getHinhThucThanhToan() {
        return HinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String HinhThucThanhToan) {
        this.HinhThucThanhToan = HinhThucThanhToan;
    }

    public String getHinhThucNhap() {
        return HinhThucNhap;
    }

    public void setHinhThucNhap(String HinhThucNhap) {
        this.HinhThucNhap = HinhThucNhap;
    }
    
    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getNhapKho() {
        return NhapKho;
    }

    public void setNhapKho(int NhapKho) {
        this.NhapKho = NhapKho;
    }

    public int getThanhToan() {
        return ThanhToan;
    }

    public void setThanhToan(int ThanhToan) {
        this.ThanhToan = ThanhToan;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String Tag) {
        this.Tag = Tag;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public double getCongNo() {
        return CongNo;
    }

    public void setCongNo(double CongNo) {
        this.CongNo = CongNo;
    }

    public String getHanTraCongNo() {
        return HanTraCongNo;
    }

    public void setHanTraCongNo(String HanTraCongNo) {
        this.HanTraCongNo = HanTraCongNo;
    }

  
}
