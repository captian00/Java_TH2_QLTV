/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entiry;

/**
 *
 * @author ADMIN
 */
public class TaiLieu implements Comparable{
    private String ma,nhaxb;
    private int soban;

    public TaiLieu() {
    }

    public TaiLieu(String ma, 
            String nhaxb, int soban) {
        this.ma = ma;
        this.nhaxb = nhaxb;
        this.soban = soban;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNhaxb() {
        return nhaxb;
    }

    public void setNhaxb(String nhaxb) {
        this.nhaxb = nhaxb;
    }

    public int getSoban() {
        return soban;
    }

    public void setSoban(int soban) {
        this.soban = soban;
    }

    @Override
    public int compareTo(Object o) {
        return this.ma.compareToIgnoreCase(((TaiLieu)o).ma);
       // return soban-((TaiLieu)o).soban;//tang dan
       // return Integer.compare(((TaiLieu)o).soban,soban );//giam dan
    }
    
}
