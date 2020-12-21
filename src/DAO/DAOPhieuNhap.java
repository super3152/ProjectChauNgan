/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTOKho;
import DTO.DTOPhieuNhap;
import DTO.DTOSanPham;
import static GUI.Test.addid;
import GUI.jdlNhapXuatExcel;
import static GUI.jdlNhapXuatExcel.idphieunhapp;
import static GUI.jdlNhapXuatExcel.idpn;
import static GUI.pnlhanghoa.countPN;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class DAOPhieuNhap {

    public static ResultSet LayPhieuNhapLocNguoiDung() {
        String query = "Select DISTINCT idnguoidung from phieunhap";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayThongTinSPTheoID(int MaSP) {
        String query = "SELECT * FROM sanpham where idsanpham =  '" + MaSP + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayPhieuNhapTheoID(int MaPN) {
        String query = "SELECT * FROM phieunhap where idphieunhap =  '" + MaPN + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayTenNCC(int MaNCC) {
        String query = "SELECT * FROM nhacungcap where idnhacungcap =  '" + MaNCC + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayPhieuNhapLocNhaCungCap() {
        String query = "Select DISTINCT idnhacungcap from phieunhap";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayTenND(int MaND) {
        String query = "SELECT * FROM nguoidung where idnguoidung =  '" + MaND + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayTenKH(int MaKH) {
        String query = "SELECT * FROM khachhang where idkhachhang =  '" + MaKH + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayPhieuNhap(String TuKhoa, int trang) {
        String query = "Select * from phieunhap where idphieunhap like '%" + TuKhoa + "%' or idnhacungcap like '%" + TuKhoa + "%' or idnguoidung like '%" + TuKhoa + "%' or sophieunhap like '%" + TuKhoa + "%' or ngaynhap like '%" + TuKhoa + "%' or thanhtien like '%" + TuKhoa + "%' order by ngaynhap DESC limit " + trang + ", 13";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }
    public static ResultSet LayPhieuNhapLoc(String MaNhanVien, String NhaCungCap, String HinhThucNhap, String TrangThai, String CongNo, int Trang) {
        String query = "Select * from phieunhap where idnhacungcap like '%" + MaNhanVien + "%' and idnhanvien like '%" + NhaCungCap + "%' and hinhthucnhap like '%" + HinhThucNhap + "%' and trangthai like '%" + TrangThai + "%' and congno "+CongNo+" limit " + Trang + ", 13";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }

    public static ResultSet CountPN() {
        try {
            String query = "Select count(*) from phieunhap";
            ResultSet rs = DBConection.GetData(query);

            while (rs.next()) {
                countPN = rs.getInt(1);
            }
            System.out.println(countPN);
            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public static ResultSet LayNhaCungCap() {
        String query = "Select * from nhacungcap where trangthai = 1";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayKhoTheoIDSP(int MaSanPham) {
        String query = "Select * from kho where idsanpham= '" + MaSanPham + "'";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }

    public static int ThemPhieNhap(DTOPhieuNhap pn) {
        String query = "INSERT INTO `phieunhap`"
                + "( `idnhacungcap`,  `idnguoidung`, `sophieunhap`, `ngaynhap`, `thanhtien`, `hinhthucthanhtoan`, `hinhthucnhap`, `trangthai`, `nhapkho`, `thanhtoan`, `congno`, `tag`, `ghichu`)"
                + " VALUES "
                + "('" + pn.getIDNhaCungCap() + "',"
                + "'" + pn.getIDNguoiDung() + "',"
                + "'" + pn.getSoPhieuNhap() + "',"
                + "'" + pn.getNgayNhap() + "',"
                + "'" + pn.getThanhTien() + "',"
                + "'" + pn.getHinhThucThanhToan() + "',"
                + "'" + pn.getHinhThucNhap() + "',"
                + "'" + pn.getTrangThai() + "',"
                + "'" + pn.getNhapKho() + "',"
                + "'" + pn.getThanhToan() + "',"
                + "'" + pn.getCongNo() + "',"
                + "'" + pn.getTag() + "',"
                + "'" + pn.getGhiChu() + "')";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);

    }

    public static int ThemIDPhieuNhap(DTOPhieuNhap pn) {
        String query = "INSERT INTO `phieunhap`"
                + "(`idphieunhap`)"
                + " VALUES "
                + "('" + pn.getIDPhieuNhap() + "')";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);

    }

    public static ResultSet GetByTenPN(String SoPhieuNhap) {
        String cauTruyVan = "select * from phieunhap where sophieunhap = '" + SoPhieuNhap + "'";
        ResultSet rs = DBConection.GetData(cauTruyVan);
        return rs;
    }

    public static int SuaTonKhoGia(DTOKho kh) {
        String query = "UPDATE `kho` SET "
                + "`tonkho`='" + kh.getTonKho()
                + "',`hangdangve`='" + kh.getHangDangVe()
                + "',`trangthai`='" + kh.getTrangThai()
                + "' WHERE `idsanpham`='" + kh.getIDSanPham() + "'";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);
    }

    public static int SuaNhapKhoPN(DTOPhieuNhap pn) {
        String query = "UPDATE `phieunhap` SET `ngaynhap`='" + pn.getNgayNhap() + "', `nhapkho`='" + pn.getNhapKho()
                + "' WHERE `sophieunhap`='" + pn.getSoPhieuNhap() + "'";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);
    }

    public static int SuaPhieuNhap(DTOPhieuNhap pn) {
        String query = "UPDATE `phieunhap` SET "
                + "`idnhacungcap`='" + pn.getIDNhaCungCap()
                + "',`idnguoidung`='" + pn.getIDNguoiDung()
                + "',`sophieunhap`='" + pn.getSoPhieuNhap()
                + "',`thanhtien`='" + pn.getThanhTien()
                + "',`hinhthucthanhtoan`='" + pn.getHinhThucThanhToan()
                + "',`hinhthucnhap`='" + pn.getHinhThucNhap()
                + "',`trangthai`='" + pn.getTrangThai()
                + "',`nhapkho`='" + pn.getNhapKho()
                + "',`thanhtoan`='" + pn.getThanhToan()
                + "',`congno`='" + pn.getCongNo()
                + "',`tag`='" + pn.getTag()
                + "',`ghichu`='" + pn.getGhiChu()
                + "' WHERE `idphieunhap` = '" + pn.getIDPhieuNhap() + "'";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);
    }

    public static int SuaTonKhoSP(DTOSanPham sp) {
        String query = "UPDATE `sanpham` SET `gianhap`='" + sp.getGiaNhap() + "',`tonkho`='" + sp.getTonKho() + "' WHERE `idsanpham`='" + sp.getIDSanPham() + "'";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);
    }

    public static int SuaThanhToanPN(DTOPhieuNhap pn) {
        String query = "UPDATE `phieunhap` SET `hinhthucthanhtoan`='" + pn.getHinhThucThanhToan() + "',`trangthai`='" + pn.getTrangThai() + "',`thanhtoan`='" + pn.getThanhToan() + "',`congno`='" + pn.getCongNo() + "',`hantracongno`='" + pn.getHanTraCongNo() + "' WHERE `sophieunhap`='" + pn.getSoPhieuNhap() + "'";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);
    }

    public static int TraNoPhieuNhap(DTOPhieuNhap pn) {
        String query = "UPDATE `phieunhap` SET `congno`='" + pn.getCongNo() + "' WHERE `idphieunhap`='" + pn.getIDPhieuNhap() + "'";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);
    }

    public static ResultSet AddID() {
        try {
            String query = "SELECT idphieunhap FROM phieunhap ORDER BY idphieunhap DESC LIMIT 1";
            ResultSet rs = DBConection.GetData(query);

            while (rs.next()) {
                idphieunhapp = rs.getInt(1);
            }
            System.out.println(idphieunhapp);
            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public static ResultSet LayThongTinCTPhieuNhap(int idphieunhap) {
        try {
            String query = "SELECT idnhacungcap, sum(thanhtien), hinhthucnhap FROM `chitietphieunhap` WHERE idphieunhap = '" + idphieunhap + "'";
            ResultSet rs = DBConection.GetData(query);

            while (rs.next()) {

                jdlNhapXuatExcel.idnhacungcap = rs.getInt(1);
                jdlNhapXuatExcel.thanhtien = rs.getDouble(2);
                jdlNhapXuatExcel.hinhthucnhap = rs.getString(3);
            }
            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public static int XoaPhieuNhap(Integer idphieunhap) {
        String cauTruyVan = "DELETE FROM `phieunhap` WHERE idphieunhap = '" + idphieunhap + "'";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);

    }

}
