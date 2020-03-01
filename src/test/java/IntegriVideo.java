import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IntegriVideo {
    @Test
    public void integriVideoFindElement(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver browser= new ChromeDriver();
        browser.get("https://dev.integrivideo.com/demo/5e5a9d878adbe12e47e1cb3c");
        browser.findElement(By.cssSelector(".integri-video"));
        browser.findElement(By.cssSelector("#invite-users-to-chat"));
        browser.findElement(By.cssSelector("a[target=_blank]"));
        browser.findElement(By.cssSelector(".integri-chat-send-message"));
        browser.findElement(By.cssSelector(".integri-chat-start-video"));
        browser.findElement(By.cssSelector("textarea"));
        browser.findElement(By.cssSelector(".integri-chat-settings")).click();
        browser.findElement(By.name("userName"));
        browser.findElement(By.name("userEmail"));
        browser.findElement(By.name("userPic"));
        browser.findElement(By.cssSelector(".integri-user-settings-save"));
        browser.findElement(By.cssSelector(".integri-user-settings-reset")).click();
        browser.findElement(By.cssSelector(".close-integri-modal"));
        browser.findElement(By.cssSelector(".integri-chat-manual-upload")).click();
        browser.findElement(By.cssSelector(".integri-file-upload-manual-init"));
        browser.findElement(By.cssSelector(".iv-icon-cross"));
        browser.findElement(By.cssSelector(".integri-file-upload-start"));
        browser.findElement(By.cssSelector(".integri-file-upload-cancel ")).click();
        browser.quit();

    }
}
