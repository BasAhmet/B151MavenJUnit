package techproed.day07_MavenJUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    // notasyonlu method oluşturmak için "sağ tık + generate" veya "alt + insert"
    // test çalışma sırası alfabetik natural order olur.
    @After
    public void tearDown() {
        System.out.println("Her test methodundan SONRA bir kez çalışır.");
    }
    @Before
    public void setup(){
        System.out.println("Her test methodundan ÖNCE bir kez çalışır.");
    }
    @Test
    public void test1(){
        System.out.println("Birinci Test.");
    }
    @Test
    public void test2(){
        System.out.println("İkinci Test");
    }
    @Test
    public void test3(){
        System.out.println("Üçüncü Test");
    }

}
