/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import java.util.Vector;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
//        Vector v=new Vector();
//        v.add(123);
//        v.add(987);
//        v.add(66);
//        v.add(890);
//        Enumeration e=v.elements();
//        while(e.hasMoreElements())
//            System.out.println(e.nextElement());
          Map h=new HashMap();
          h.put("So 1","Ban tuan");
          h.put("So 2","Thu trang");
          h.put("So 1","Kieu Ba");
          h.put("So 3","Lam lam");
          Iterator i=h.keySet().iterator();
          while(i.hasNext()){
              String key=(String)i.next();
              System.out.println(h.get(key));
          }
    }
}
