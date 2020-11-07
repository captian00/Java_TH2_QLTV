package run;



import java.util.Scanner;
import model.QLTV;





public class Menu {
    public static void main(String[] args) {
        QLTV q=new QLTV();
        
        while(true){
            System.out.println("1. Nhap sach");
            System.out.println("2. Nhap bao");
            
            System.out.println("3. viet ra ds");
            System.out.println("4. Xoa");
            System.out.println("5. Sua");
            System.out.println("6. Tim kiem dung (ma)");
            System.out.println("7. tim kiem chua");
            System.out.println("8. tim kiem tu..den..");
            System.out.println("9. sap xep ");
            System.out.println("10. Dem");
            System.out.println("11. ");
            System.out.println("12. ");
                        
            System.out.println("0. Exit");
            System.out.print("Your choice (0->4):");
            
            int choice;
            Scanner in=new Scanner(System.in);
            choice=Integer.parseInt(in.nextLine());
            switch(choice){
                case 0:System.out.println("Bye!!!!");
                       System.exit(0);
                    break;
                case 1:q.nhapSach();
                    break;
                case 2:q.nhapBao();
                    break;
                case 3: q.vietDS();
                    break;
                case 4:System.out.print("ma can xoa:");
                String ma=in.nextLine();
                q.xoa(ma);
                    break;
                case 5:System.out.print("ma can sua:");
                String m=in.nextLine();
                q.sua(m);
                    break;
                case 6:
                    break;  
                case 7:
                    break;
                case 8:q.tk();
                    break;
                case 9:q.sxTheoTrang();
                    break; 
                case 10:q.maxGroup();
                case 11: 
                break;
                case 12: 
                break;
                
                default:System.out.println("only select 0->7");
                
            }
        }
        
    }
}
