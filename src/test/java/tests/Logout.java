package tests;

import org.testng.annotations.Test;

public class Logout extends BaseTest {
    @Test
    public void Logout() {
        singUp
                .openPage("https://dev.integrivideo.com/login")
                .logout("piter@mailinator.com", "qwerty123")
                .clickLogout();
    }
}
