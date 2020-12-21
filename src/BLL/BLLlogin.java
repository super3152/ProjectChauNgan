
package BLL;

import DTO.DTONguoidung;
import GUI.ThongBaoCanhBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Takemikazuchi
 */
public class BLLlogin {

    public static DTO.DTONguoidung nguoidung = new DTONguoidung();
    public static DTO.DTONguoidung idNguoidung = new DTONguoidung();
    public static DTO.DTONguoidung quyen = new DTONguoidung();
    
    public static boolean Checklogin(String username, String password) {
            if (username.trim().length() < 5) {
            //Thông báo
            ThongBaoCanhBao.ThongBao("Tên đăng nhập chưa hợp lệ, vui lòng kiểm tra"+"\n"+" thông tin và đăng nhập lại sau 5 giây", "Thông báo đăng nhập");
            return false;
        }
        if (password.trim().length() < 5) {
            ThongBaoCanhBao.ThongBao("Mật khẩu chưa hợp lệ, vui lòng kiểm tra"+"\n"+" thông tin và đăng nhập lại sau 5 giây", "Thông báo đăng nhập");
            return false;
        }
        ResultSet rs = DAO.DAONguoiDung.DangNhap(username);
        try {
            if (!rs.next()) {
                ThongBaoCanhBao.ThongBao("Tên đăng nhập không đúng, vui lòng kiểm tra"+"\n"+" thông tin và đăng nhập lại sau 5 giây", "Thông báo");
                return false;
            } else {
                if (!rs.getString("matkhau").equals(password)) {
                    ThongBaoCanhBao.ThongBao("Mật khẩu không đúng, vui lòng kiểm tra"+"\n"+" thông tin và đăng nhập lại sau 5 giây", "Thông báo");
                    return false;
                } else {
                    nguoidung.setAnhDaiDien(rs.getString("anhdaidien"));
                    nguoidung.setIdNguoiDung(rs.getInt("idnguoidung"));
                    nguoidung.setTenDangNhap(username);
                    nguoidung.setTenNguoiDung(rs.getString("tennguoidung"));
                      nguoidung.setQuyen(rs.getInt("quyen"));
                }
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi câu lệnh SQL", "Thông báo lỗi");
            return false;
        }

        return true; 
     
    }

}