package steps;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.SingUp;

public class LoginSteps {
    SingUp singUp;

    public LoginSteps(WebDriver driver) {
        singUp = new SingUp(driver);

    }

    @Step("Registration ")
    public LoginSteps login() {
        User user = new User("piter@mailinator.com", "qwerty123");
        singUp
                .openPage("https://dev.integrivideo.com/login")
                .login(user);
        return this;
    }
}
