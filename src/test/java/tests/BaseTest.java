package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.IntegriVideoChatPage;
import pages.IntegriVideoSingUp;
import untils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    IntegriVideoChatPage chatPage;
    IntegriVideoSingUp singUp;
    @BeforeMethod
    public void setUp() {

//        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
//        driver = new ChromeDriver();
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        chatPage = new IntegriVideoChatPage(driver);
        singUp = new IntegriVideoSingUp(driver);
    }
    @AfterMethod(alwaysRun=true)
    public void closeDriver(){
        driver.quit();
    }
}
