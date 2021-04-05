/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.nam.qlsv;

import java.io.Serializable;

/**
 *
 * @author duato
 */
public class Nguoi implements Serializable{
    private String ho;
    private String ten;

    public Nguoi() {
    }

    public Nguoi(String ho, String ten) {
        this.ho = ho;
        this.ten = ten;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return String.format("%20s%10s", ho, ten);
    }
    
    
}
