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
public class DTOChamCong {
    
    
    int idchamcong;
    int idnguoidung;
    String ngaychamcong;
    int socachamcong;
    int tongsocachamcong;
    int songaytrongthang;
    String tennguoidung;

    
      public DTOChamCong() {
       
    }
    
       public DTOChamCong(int idnguoidung, String ngaychamcong) {
        this.idnguoidung = idnguoidung;
        this.ngaychamcong = ngaychamcong;
      
    }
      
       public DTOChamCong(int idnguoidung, String ngaychamcong, int socachamcong, int tongsocachamcong, int songaytrongthang) {
        this.idnguoidung = idnguoidung;
        this.ngaychamcong = ngaychamcong;
        this.socachamcong = socachamcong;
        this.tongsocachamcong = tongsocachamcong;
        this.songaytrongthang = songaytrongthang;
    }
      
    public DTOChamCong(int socachamcong, int tongsocachamcong, int idnguoidung) {
     
        this.idnguoidung = idnguoidung;
      
        this.socachamcong = socachamcong;
        this.tongsocachamcong = tongsocachamcong;
       
    }

    public int getIdchamcong() {
        return idchamcong;
    }

    public void setIdchamcong(int idchamcong) {
        this.idchamcong = idchamcong;
    }

    public int getIdnguoidung() {
        return idnguoidung;
    }

    public void setIdnguoidung(int idnguoidung) {
        this.idnguoidung = idnguoidung;
    }

    public String getNgaychamcong() {
        return ngaychamcong;
    }

    public void setNgaychamcong(String ngaychamcong) {
        this.ngaychamcong = ngaychamcong;
    }

    public int getSocachamcong() {
        return socachamcong;
    }

    public void setSocachamcong(int socachamcong) {
        this.socachamcong = socachamcong;
    }

    public int getTongsocachamcong() {
        return tongsocachamcong;
    }

    public void setTongsocachamcong(int tongsocachamcong) {
        this.tongsocachamcong = tongsocachamcong;
    }

    public int getSongaytrongthang() {
        return songaytrongthang;
    }

    public void setSongaytrongthang(int songaytrongthang) {
        this.songaytrongthang = songaytrongthang;
    }

    public String getTennguoidung() {
        return tennguoidung;
    }

    public void setTennguoidung(String tennguoidung) {
        this.tennguoidung = tennguoidung;
    }
    
    
    
}
