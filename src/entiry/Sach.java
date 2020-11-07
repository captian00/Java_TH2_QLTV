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
public class Sach extends TaiLieu implements TinhTien{
    private String ten,tg;
    private int trang;

    public Sach() {
    }

    public Sach(String ma,String ten, 
            String tg, int trang,
             String nhaxb, int soban) {
        super(ma, nhaxb, soban);
        this.ten = ten;
        this.tg = tg;
        this.trang = trang;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTg() {
        return tg;
    }

    public void setTg(String tg) {
        this.tg = tg;
    }

    public int getTrang() {
        return trang;
    }

    public void setTrang(int trang) {
        this.trang = trang;
    }
    
    @Override
    public double getGia() {
        if(getSoban()>300)
            return trang*12000*0.9;
        else
            return trang*12000;
    }

    @Override
    public String toString() {
        return getMa()+"\t"+ten+"\t"+tg+"\t"+
                getNhaxb()+"\t"+getSoban()+"\t"+trang+"\t"+getGia();
    }
    public static String getHeader(){
        return "Ma\tTen\tTac gia\tTrang\tNha XB\tSo ban";
    }
}
