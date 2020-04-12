package tests;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.ChatPage;
import pages.SingUp;
import steps.CreateCartSteps;
import steps.LoginSteps;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    ChatPage chatPage;
    SingUp singUp;
    LoginSteps loginSteps;
    User user;
    CreateCartSteps createCartSteps;


    @BeforeMethod
    public void setUp(ITestContext context) {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        context.setAttribute("driver", driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        chatPage = new ChatPage(driver);
        singUp = new SingUp(driver);
        loginSteps = new LoginSteps(driver);
        user = new User("piter@mailinator.com", "qwerty123");
        createCartSteps = new CreateCartSteps(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }
}

