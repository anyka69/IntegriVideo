package tests;

import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    @Test
    public void Logout() {
        singUp
                .openPage("https://dev.integrivideo.com/login")
                .login(user)
                .clickLogout();
    }
}
