package tests;

import org.testng.annotations.Test;

public class BillingTest extends BaseTest {
    @Test
    public void billingTest() {
        loginSteps
                .login();
        createCartSteps
                .createCart()
                .createCart();

        singUp
                .makeDefault(1)
                .removeCard(1);
    }
}
