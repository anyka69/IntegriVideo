package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.*;

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
        List<WebElement> messages = driver.findElements(By.cssSelector(".integri-chat-message-text"));
        boolean isExist = messages.get(messageIndex - 1).getText().equals(text);
        assertTrue(isExist, "Message does not exist");
    }
    public void linkText(int messageIndex, String text){
        List<WebElement> link=driver.findElements(By.cssSelector(".integri-chat-message-attachment-link"));
        boolean isExist = link.get(messageIndex - 1).getText().equals(text);
        assertFalse(isExist, "page does not load");

    }

    public void editMessage() {
        driver.findElement(By.cssSelector(".integri-chat-edit-message")).click();
    }

    public void modifyTextMessage(String text) {
        driver.findElement(By.cssSelector("textarea")).clear();
        driver.findElement(By.cssSelector("textarea")).sendKeys(text);
    }
    public void modifyText(int messageIndex, String text) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> messages = driver.findElements(By.cssSelector(".integri-chat-message-text"));
        boolean isExist = messages.get(messageIndex - 1).getText().equals(text);
        assertFalse(isExist, "Message does not exist");
    }


    public void deleteMessage() {
        driver.findElement(By.cssSelector(".integri-chat-remove-message")).click();
        Alert alert = driver.switchTo().alert();
        driver.switchTo().alert().accept();
    }
    public void deleteMessageText(int messageIndex, String text){
        List<WebElement> messages = driver.findElements(By.cssSelector(".integri-chat-message-text"));
        boolean isExist = messages.get(messageIndex - 1).getText().equals(text);
        assertFalse(isExist, "removed...");
    }
    public void checkLimit(){
        for(int i =0;i<12;i++){
            driver.findElement(CHAT_INPUT).sendKeys("text");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.findElement(By.cssSelector(".integri-chat-send-message")).click();
        }
    }
    public void sendMessage1() {
        for(int i =0;i<12;i++){
            driver.findElement(CHAT_INPUT).sendKeys("text");
            wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".integri-chat-send-message"),12));
            driver.findElement(By.cssSelector(".integri-chat-send-message")).click();
        }
    }
}


