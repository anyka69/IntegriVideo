package tests;

import org.testng.annotations.Test;

public class SingUpTest extends BaseTest {
    @Test
    public void createRandomAccount() {
        singUp
                .openPage("https://dev.integrivideo.com/signup")
                .writeRandomEmail()
                .writePassword("qwerty123")
                .clickLogin();
    }

    @Test
    public void addProject() {
        loginSteps
                .login();
        singUp
                .addProject()
                .writeTextProjectName("Test")
                .writeTextDomains(0, "tut.by")
                .writeTextDomains(1, "onliner.by")
                .deleteDomain(0)
                .clickButtonCreate();
    }
}
