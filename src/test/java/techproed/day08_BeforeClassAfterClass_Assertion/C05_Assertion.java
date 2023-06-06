package techproed.day08_BeforeClassAfterClass_Assertion;

import org.junit.Assert;
import org.junit.Test;

public class C05_Assertion {
    @Test
    public void test01() {
        Assert.assertEquals(2,2);
        System.out.println("Test Başarılı.");
    }
    @Test
    public void test02() {
        Assert.assertEquals(3,2);
        System.out.println("Test Başarılı.");
    }
    @Test
    public void test03() {
        Assert.assertEquals(2,2);
        System.out.println("Test Başarılı.");
    }
    @Test
    public void test04() {
        Assert.assertEquals("Ahmet","ahmet");
        System.out.println("Test Başarılı.");
    }
}
