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
public class Bao extends TaiLieu implements TinhTien{
    private String ngay;

    public Bao() {
    }

    public Bao(String ma,String ngay,  String nhaxb, int soban) {
        super(ma, nhaxb, soban);
        this.ngay = ngay;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    @Override
    public double getGia() {
        if(getSoban()>300)
            return 20000;
        else
            return 20000*0.9;
    }

    @Override
    public String toString() {
        return getMa()+"\t"+getNgay()+"\t"+getNhaxb()+"\t"+getSoban();
    }
    public static String getHeader(){
        return "Ma\tNgar\tNha XB\tSo ban";
    }
    
}
