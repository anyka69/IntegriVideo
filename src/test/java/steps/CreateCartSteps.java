package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.SingUp;


public class CreateCartSteps {
    SingUp singUp;

    public CreateCartSteps(WebDriver driver) {
        singUp = new SingUp(driver);

    }

    @Step("Creat Credit Cart")
    public CreateCartSteps createCart() {
        singUp
                .clickBilling()
                .clickAddNew()
                .createCreditCard("4111111111111111", "02", "2025", "Piter Pan");
        return this;
    }
}



