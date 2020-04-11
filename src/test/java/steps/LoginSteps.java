package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.SingUp;

public class LoginSteps {
    SingUp singUp;

    public LoginSteps(WebDriver driver) {
        singUp = new SingUp(driver);

    }

    @Step("Registration ")
    public void login() {
        singUp
                .openPage("https://dev.integrivideo.com/login")
                .logout("piter@mailinator.com", "qwerty123");
    }
}
