
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    private static ArrayList<Integer> icerik = new ArrayList<Integer>();
    
    //dosya okuma işlemini bir metod ile yapıyoruz.
    public static void dosyaOku(String dosyaIsmı){
      //  File file = new File("Trapped.mp3");
        try {
            FileInputStream in = new FileInputStream(dosyaIsmı);
            
            int oku ;
            
            while((oku = in.read()) != -1){
               
                icerik.add(oku);
 
            }

        } catch (FileNotFoundException ex) {
                System.out.println("Dosya Okuma Sırasında Meydana Gelen FileNotFoundException");
        } catch (IOException ex) {
         
            System.out.println("Dosya Okuma Sırasında Meydana Gelen IOException");
            
        }
        
    }
    public static  void kopyala(String dosyaIsmı){
        
        try {
            FileOutputStream out = new FileOutputStream(dosyaIsmı);
            for(int deger : icerik){
                out.write(deger);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya Kopyalama Sırasında Meydana Gelen FileNotFoundException");
        } catch (IOException ex) {
            System.out.println("Dosya kopyalama sırasında meydana gelen IOEXCEPTİON");
        }
    }
    
    
    
    public static void main(String[] args) {
     
        dosyaOku("Trapped.mp3");
        kopyala("Trapped2.mp3");
        long baslangıc = System.currentTimeMillis();
        
        dosyaOku("Masumlar Apartmanı Müzikleri - Yalanlar.mp3");
        kopyala("Masumlar Apartmanı Müzikleri - Yalanlar2.mp3");
        long bıtıs =System.currentTimeMillis();
        System.out.println("İşlemler Arasında Geçen Toplam Süre : " +(bıtıs-baslangıc)/1000+" saniye");
    }
    
}
