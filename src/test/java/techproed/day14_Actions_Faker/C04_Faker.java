package techproed.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import techproed.Utilities.TestBase;

public class C04_Faker{
    @Test
    public void faker() {
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            System.out.println("****************************************");
            System.out.println("TC     : " + faker.number().digits(11));
            System.out.println("İsim   : " + faker.name().fullName());
            System.out.println("Meslek : " + faker.job().title());
            System.out.println("Cep No : " + faker.phoneNumber().cellPhone());
            System.out.println("Adres  : " + faker.address().fullAddress());
        }
    }
}
