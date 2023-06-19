package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C01_FilesExists {
    @Test
    public void test01() {
        /*
            Bir web sitesini test ettiğimizde download işlemi yapıldığı zaman dosyanın bilgisayarımıza inip inmediğini
        kontrol etmek varlığını doğrulamak için yada bilgisayarımızdaki herhangi bir dosyanın varlığını doğrulabilmek
        için;
            Files class'ından exists() methodunu kullanarak parametre olarak Paths.get(dosyaYolu) methodunu kullanarak
        dosyanın varlığını test edebiliriz. --> Files.exists(Paths.get(dosyaYolu)
        Dolayısıyla bu işleme başlamadan önce varlığını test edeceğimiz dosyanın yolunu String bir değişkene
        assing ederiz.
         */
        String filePath = "C:/Users/ahba8/Desktop/ /12 Ücretsiz Tasarım Kaynağı.txt";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }

    @Test
    public void test02() throws InterruptedException {
        /*
           Bir server'da farkli isletim sistemleri ile ayni anda dosya varligini test etmek istedigimiz zaman, daha dinamik
           olmasi acisindan System.getProoerty("os.name") bu sekilde isletim sistemini alir
           her isletim sisteminin kullanici yolu farkli olacagindan System.getProoerty("user.home") bilgisayarimizdaki
           kullanici yolunu bu sekilde alip String bir degiskene farkliYol ismi ile System.getProoerty("user.home") atayarak
           her seferinde farkli yollari almayla ugrasmamiz oluruz. Dosya diyelim ki masa ustunde ve her isletim sisteminde
           bize ayni yolu verecegi icin bunu da ortak yol olarak bir String'e assing ederiz
         */
        String isletimSistemiAdi = System.getProperty("os.name");
        System.out.println(isletimSistemiAdi);
        System.out.println(System.getProperty("user.home"));

        //Dosya oluşturdum//
        try {
            Files.createFile(Path.of("C:/Users/ahba8/Desktop/sil.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Thread.sleep(5000);

        //Dosya sildim//
        try {
            Files.delete(Paths.get("C:/Users/ahba8/Desktop/sil.txt"));
        } catch (IOException e) {
            System.out.println("Yok yok silemedim");;
        }
    }

    @Test
    public void test03() throws InterruptedException {
        /*
            Yukarıdaki methodlarda bilgisayarımızdaki dosya yolunun varlığını Files.exists()methoduyla test etmiştik
        Aynı işlemi aşağıdaki örnekteki gibi File class'ından obje oluşturarak da yapabiliriz.
         */
        String dosyaYolu = "C:/Users/ahba8/Desktop/sil.txt";
        File file = new File(dosyaYolu);
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
        Thread.sleep(3000);
        file.delete();
    }

}
