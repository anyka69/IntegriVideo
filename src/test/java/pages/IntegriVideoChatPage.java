package pages;

import org.openqa.selenium.*;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
public class IntegriVideoChatPage extends BasePage {
    private final static By CHAT_INPUT = By.cssSelector("textarea");

    public IntegriVideoChatPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://dev.integrivideo.com/demo/chat/new");
    }

    public void writeText(String text) {
        driver.findElement(CHAT_INPUT).sendKeys(text);
    }

    public void clickSend() {
        driver.findElement(By.cssSelector(".integri-chat-send-message")).click();
    }

    public void clickEnter() {
        WebElement enter = driver.findElement(By.cssSelector(".integri-chat-send-message"));
        enter.sendKeys(Keys.ENTER);
    }

    public void messageShouldExist(int messageIndex, String text) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> messages = driver.findElements(By.cssSelector(".integri-chat-message-text"));
        boolean isExist = messages.get(messageIndex - 1).getText().equals(text);
        assertTrue(isExist, "Message does not exist");
    }
    public void editMessage(){
        driver.findElement(By.cssSelector(".integri-chat-edit-message")).click();
    }
    public void writeTextMessage(String text){
        driver.findElement(By.cssSelector("textarea")).clear();
        driver.findElement(By.cssSelector("textarea")).sendKeys(text);
    }
    public void deleteMessage(){
        driver.findElement(By.cssSelector(".integri-chat-remove-message")).click();
        Alert alert = driver.switchTo().alert();
        driver.switchTo().alert().accept();
    }
}


