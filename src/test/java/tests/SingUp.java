package tests;

import org.testng.annotations.Test;

public class SingUp extends BaseTest {
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
        singUp
                .openPage("https://dev.integrivideo.com/login")
                .logout("piter@mailinator.com", "qwerty123")
                .addProject()
                .writeTextProjectName("Test")
                .writeTextDomains(0, "tut.by")
                .writeTextDomains(1, "onliner.by")
                .deleteDomain(0)
                .clickButtonCreate();
    }
}
