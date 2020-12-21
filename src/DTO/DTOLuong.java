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
public class DTOLuong {
    int idluong;
    Double tienluong;
    String MoTa;

    
     public DTOLuong() {
      
    }
      public DTOLuong(Double tienluong, String MoTa) {
       this.tienluong = tienluong;
        this.MoTa = MoTa;
    }
     
    public DTOLuong(int idluong, Double tienluong, String MoTa) {
        this.idluong = idluong;
        this.tienluong = tienluong;
        this.MoTa = MoTa;
    }

    public int getIdluong() {
        return idluong;
    }

    public void setIdluong(int idluong) {
        this.idluong = idluong;
    }

    public Double getTienluong() {
        return tienluong;
    }

    public void setTienluong(Double tienluong) {
        this.tienluong = tienluong;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    
}
