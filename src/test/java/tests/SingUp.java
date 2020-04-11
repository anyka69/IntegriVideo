package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class SingUp extends BaseTest {
    @Test
    @Description("Создание проекта user")
    public void createRandomAccount() {
        singUp
                .openPage("https://dev.integrivideo.com/signup")
                .writeRandomEmail()
                .writePassword("qwerty123")
                .clickLogin();
    }

    @Test
    @Description("Создание проекта user")
    public void addProject() {
        loginSteps.login();
        singUp
                .addProject()
                .writeTextProjectName("Test")
                .writeTextDomains(0, "tut.by")
                .writeTextDomains(1, "onliner.by")
                .deleteDomain(0)
                .clickButtonCreate();
    }
}
