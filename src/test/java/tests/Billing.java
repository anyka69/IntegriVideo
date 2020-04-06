package tests;

import org.testng.annotations.Test;

public class Billing extends BaseTest {
    @Test
    public void billingTest() {
        singUp
                .openPage("https://dev.integrivideo.com/login")
                .logout("piter@mailinator.com", "qwerty123")
                .clickBilling()
                .clickAddNew()
                .writeInformationCreditCard("4111111111111111", "02", "2025", "Piter Pan")
                .clickAddCard()
                .clickAddNew()
                .writeInformationCreditCard("4111111111111111", "04", "2025", "Piter Pan")
                .clickAddCard()
                .makeDefault(1)
                .removeCard(0);
    }
}
