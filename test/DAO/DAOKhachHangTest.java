/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author KMB1604
 */

public class DAOKhachHangTest {
    DAOKhachHang kh;
    public DAOKhachHangTest() {
        kh = new DAOKhachHang();
    }

    @Test
    public void testLayLoaiKhachHangCBB() {
        
    }

    @Test
    public void testLaySoKhachHangTrongHD() {
        DBConection db = new DBConection();
//         String query = "SELECT * FROM hoadon where idkhachhang = '"+999+"'";
//        ResultSet rs = DBConection.GetData(query);
//        assertTrue(true);
    }

    @Test
    public void testLayKhachHangCBB() {
    }

    @Test
    public void testLayKhachHangTheoTen() {
    }

    @Test
    public void testLayMaLoaiKhachHangCBB() {
    }

    @Test
    public void testLayKhachHangTheoMaLoai() {
    }

    @Test
    public void testLayKhachHang() {
    }

    @Test
    public void testLayKhachHangTheoMa() {
    }

    @Test
    public void testLayTenKhachHang() {
    }

    @Test
    public void testLaySDTKhachHang() {
    }

    @Test
    public void testLayEmailKhachHang() {
    }

    @Test
    public void testThemKhachHang() {
    }

    @Test
    public void testSuaKhachHang() {
    }

    @Test
    public void testXoaKhachHang() {
    }

    @Test
    public void testSuaHoaDonKhachHang() {
    }

    @Test
    public void testSuaNoTraHangKhachHang() {
    }

    @Test
    public void testSuaLoaiKhachHang() {
    }
    
}
