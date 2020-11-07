/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entiry.Bao;
import entiry.Sach;
import entiry.TaiLieu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author ADMIN
 */
public class QLTV implements ChucNang{
     private List<TaiLieu> data;
     private Scanner in;
     public QLTV(){
         data=new ArrayList<>();
         in=new Scanner(System.in);
         data.add(new Sach("GF432","IT","To an",
                 123,"PTIT",340));
         data.add(new Sach("KK765","IT","To an",
                 123,"PTIT",900));
         data.add(new Sach("HH987","LTHDT","Tran Que",
                 120,"Giao duc",1000));
         data.add(new Bao("GF432","2/5/1999",
                 "Giao duc",456));
     }
     private int getVitri(String ma){
         for (int i = 0; i < data.size(); i++) {
             if(data.get(i).getMa().equalsIgnoreCase(ma))
                 return i;
         }
         return -1;
     }
    private TaiLieu nhap(){
        String ma,nhaxb;
        int sb;
        while(true){
           System.out.print("ma:");
           ma=in.nextLine().toUpperCase();
           if((getVitri(ma)==-1)&&(ma.matches("[A-Z]{2}\\d{3}")))
               break;
            System.err.println("Nhap lai!!!");
        }
        System.out.print("nha xuat ban:");
          nhaxb=in.nextLine();
          System.out.print("so ban:");
           sb=Integer.parseInt(in.nextLine());
           return new TaiLieu(ma, nhaxb, sb);
        }
    
    @Override
    public void nhapSach() {
        TaiLieu t=nhap();
        System.out.print("Ten sach:");
        String  ten=in.nextLine();
        System.out.print("Ten tac gia:");
        String  tg=in.nextLine();
        System.out.print("So trang:");
        int  so=Integer.parseInt(in.nextLine());
        data.add(new Sach(t.getMa(), ten, tg,
                so, t.getNhaxb(),t.getSoban()));
    }

    @Override
    public void nhapBao() {
        TaiLieu t=nhap();
        System.out.print("Ngay:");
        String  ng=in.nextLine();
        data.add(new Bao(t.getMa(),ng,t.getNhaxb(),t.getSoban()));
    }

    @Override
    public void vietDS() {
        System.out.println(Sach.getHeader());
        for(TaiLieu i:data)
            if(i instanceof Sach)
                System.out.println(((Sach) i).toString());
        System.out.println(Bao.getHeader());
        for(TaiLieu i:data)
            if(i instanceof Bao)
                System.out.println(((Bao) i).toString());
        System.out.println("Tong:"+data.size());
    }

    @Override
    public void xoa(String ma) {
        int vt=getVitri(ma);
        if(vt==-1)
            System.out.println("khong co!!!");
        else{
            data.remove(vt);
            System.out.println("xoa thanh cong!!!");
        }
    }

    @Override
    public void tkTheoMa(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sxTheoMa() {
        Collections.sort(data);
    }

    @Override
    public void tk() {
        System.out.print("TU:");
        int tu=Integer.parseInt(in.nextLine());
        System.out.print("den:");
        int den=Integer.parseInt(in.nextLine());
        for(TaiLieu i:data)
            if((i.getSoban()>=tu)&&(i.getSoban()<=den))
                System.out.println(i.toString());
        
    }

    @Override
    public void sua(String ma) {
       int vt=getVitri(ma);
       if(vt==-1)
            System.out.println("khong co");
       else{
           TaiLieu t=data.get(vt);
           System.out.print("Nha xuat ban:");
           String nn=in.nextLine();
           t.setNhaxb(nn);
           System.out.print("So ban:");
           int s=Integer.parseInt(in.nextLine());
           t.setSoban(s);
           System.out.println("sua thanh cong!!!");
       }
    }
    //sap xep tang dan theo so ban
    public void sxSoBan(){
        data.sort(new Comparator<TaiLieu>(){
            @Override
            public int compare(TaiLieu o1, TaiLieu o2) {
                return o1.getSoban()-o2.getSoban();
            }
            
        });
    }
    //sap xep sach tang dan theo trang
    public void sxTheoTrang(){
        List<Sach> ll=new ArrayList<>();
        for(TaiLieu i:data)
            if(i instanceof Sach)
                ll.add((Sach)i);
        ll.sort(new Comparator<Sach>(){
            @Override
            public int compare(Sach o1, Sach o2) {
                return Double.compare(o1.getTrang(),o2.getTrang());
            }
            
        });
        System.out.println(Sach.getHeader());
        for(Sach i:ll)
            System.out.println(i.toString());
    }
    public void sxTheoTenTG(){
        List<Sach> ll=new ArrayList<>();
        for(TaiLieu i:data)
            if(i instanceof Sach)
                ll.add((Sach)i);
        
        ll.sort(new Comparator<Sach>(){
            @Override
            public int compare(Sach o1, Sach o2) {
                String[] t1=o1.getTg().split("\\s+");
                String tg1=t1[t1.length-1]+o1.getTg();
                String[] t2=o2.getTg().split("\\s+");
                String tg2=t2[t2.length-1]+o2.getTg();
                return tg1.compareToIgnoreCase(tg2);
            }
            
        });
        System.out.println(Sach.getHeader());
        Iterator i=ll.iterator();
        while(i.hasNext())
            System.out.println(i.next());
        
//        for(Sach i:ll)
//            System.out.println(i.toString());
    }
    //dem xem moi nha xb co bao nhieu dau sach
    public void count(){
        Map<String,Long> c=data.stream().collect(
                Collectors.groupingBy(TaiLieu::getNhaxb,
                        Collectors.counting()));
        System.out.println(c);
    }
    //dem xem moi nha xb co ban nhieu ban
    public void sum(){
        Map<String,Integer> sum=data.stream().
                collect(Collectors.groupingBy(
                        TaiLieu::getNhaxb,
                Collectors.summingInt(
                        TaiLieu::getSoban)));
        System.out.println(sum);
    }
    public void max(){
        Optional<TaiLieu> max =           
            data.stream().collect(
              Collectors.maxBy(
                 Comparator.comparing(
                     TaiLieu::getSoban)));
        System.out.println("Tai Lieu with max So ban:"+(max.isPresent()? max.get():"Not Applicable"));
    }
    //dua ra so ban cao nhat cho tung nha xb
    public void maxGroup(){
        Map<String, TaiLieu> o =
          data.stream().collect(
          Collectors.groupingBy(TaiLieu::getNhaxb,
         Collectors.collectingAndThen(
         Collectors.reducing((TaiLieu t1, TaiLieu t2)
         ->  t1.getSoban()> t2.getSoban()?
            t1 : t2),  Optional::get)));    
    System.out.println(o);
    }


}
