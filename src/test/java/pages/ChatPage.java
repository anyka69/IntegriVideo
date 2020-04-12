package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.*;

public class ChatPage extends BasePage {
    private final static By CHAT_INPUT = By.cssSelector("textarea");
    private final static By CHAT_SEND_MESSAGE = By.cssSelector(".integri-chat-send-message");
    private final static By CHAT_SEND_MESSAGE_TEXT = By.cssSelector(".integri-chat-message-text");
    private final static By CHAT_MESSAGE_ATTACHMENT_LINK = By.cssSelector(".integri-chat-message-attachment-link");
    private final static By CHAT_EDIT_MESSAGE = By.cssSelector(".integri-chat-edit-message");
    private final static By CHAT_MESSAGE_TEXT = By.cssSelector(".integri-chat-message-text");
    private final static By CHAT_SETTINGS = By.cssSelector(".integri-chat-settings");
    private final static By UserName = By.name("userName");
    private final static By UserEmail = By.name("userEmail");
    private final static By UserPic = By.name("userPic");
    private final static By User_Setting_Save = By.cssSelector(".integri-user-settings-save");
    private final static By Chat_Manual_Upload = By.cssSelector(".integri-chat-manual-upload");
    private final static By Hide = By.cssSelector(".integri-hide");
    private final static By File_Upload_Start = By.cssSelector(".integri-file-upload-start");
    private final static By CHAT_REMOVE_MESSAGE = By.cssSelector(".integri-chat-remove-message");
    private final static By Big_Button = By.cssSelector(".integri-button big-button");
    private final static By UsersToChat = By.cssSelector("#invite-users-to-chat");
    private final static By FileName = By.cssSelector(".integri-chat-message-attachment-file-name");
    String url = "https://dev.integrivideo.com/demo/chat/new";

    public ChatPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Открытие страницы чата")
    public ChatPage openPage() {
        driver.get(url);
        isPageOpened();
        return this;
    }

    @Override
    public SingUp openPage(String text) {
        return null;
    }

    @Override
    public ChatPage isPageOpened() {
        return this;
    }

    public ChatPage writeText(String text) {
        driver.findElement(CHAT_INPUT).sendKeys(text);
        return this;
    }

    public ChatPage clickSend() {
        driver.findElement(CHAT_SEND_MESSAGE).click();
        return this;
    }

    public ChatPage clickEnter() {
        WebElement enter = driver.findElement(CHAT_SEND_MESSAGE);
        enter.sendKeys(Keys.ENTER);
        return this;
    }

    public ChatPage messageShouldExist(int messageIndex, String text) {
        List<WebElement> messages = driver.findElements(CHAT_SEND_MESSAGE_TEXT);
        boolean isExist = messages.get(messageIndex - 1).getText().equals(text);
        assertTrue(isExist, "Message does not exist");
        return this;
    }

    public ChatPage linkText(int messageIndex, String text) {
        List<WebElement> link = driver.findElements(CHAT_MESSAGE_ATTACHMENT_LINK);
        boolean isExist = link.get(messageIndex - 1).getText().equals(text);
        assertFalse(isExist, "page does not load");
        return this;
    }

    public ChatPage editMessage() {
        driver.findElement(CHAT_EDIT_MESSAGE).click();
        return this;
    }

    public ChatPage modifyTextMessage(String text) {
        driver.findElement(CHAT_INPUT).clear();
        driver.findElement(CHAT_INPUT).sendKeys(text);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CHAT_INPUT));
        return this;
    }

    public ChatPage verifyText(int messageIndex, String text) {
        List<WebElement> messages = driver.findElements(CHAT_MESSAGE_TEXT);
        boolean isExist = messages.get(messageIndex - 1).getText().equals(text);
        assertFalse(isExist, "Message does not exist");
        return this;
    }

    public ChatPage deleteMessage(int index) {
        List<WebElement> deleteButtons = driver.findElements(CHAT_REMOVE_MESSAGE);
        deleteButtons.get(index - 1).click();
        driver.switchTo().alert().accept();
        return this;
    }

    public ChatPage deleteMessageText(int messageIndex, String text) {
        List<WebElement> messages = driver.findElements(CHAT_MESSAGE_TEXT);
        boolean isExist = messages.get(messageIndex - 1).getText().equals(text);
        assertFalse(isExist, "removed...");
        return this;
    }

    public ChatPage checkLimit(String text, int limit) {
        for (int i = 0; i < limit - 1; i++) {
            writeText(text);
            driver.findElement(CHAT_SEND_MESSAGE).click();
            wait.until(ExpectedConditions.numberOfElementsToBe((CHAT_MESSAGE_TEXT), i + 1));
        }
        driver.findElement(Big_Button).click();
        return this;
    }

    public ChatPage clickSetting() {
        driver.findElement(CHAT_SETTINGS).click();
        return this;
    }

    public ChatPage checkName() {
        driver.findElement(UserName).clear();
        driver.findElement(UserName).sendKeys("Anna");
        String name = driver.findElement(UserName).getAttribute("value");
        assertEquals(name, "Anna", "Error!Repeat Entry!Check Name!");
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserName));
        return this;
    }

    public ChatPage checkEmail() {
        driver.findElement(UserEmail).clear();
        driver.findElement(UserEmail).sendKeys("123@mail.ru");
        String email = driver.findElement(UserEmail).getAttribute("value");
        assertEquals(email, "123@mail.ru", "Error!Repeat Entry!Check Email!");
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserEmail));
        return this;
    }

    public ChatPage checkPhotoURL() {
        driver.findElement(UserPic).clear();
        driver.findElement(UserPic).sendKeys("https://www.google.com/search");
        String photoURL = driver.findElement(UserPic).getAttribute("value");
        assertEquals(photoURL, "https://www.google.com/search", "Error!Repeat Entry!");
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserPic));
        return this;
    }

    public ChatPage saveSetting() {
        driver.findElement(User_Setting_Save).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(User_Setting_Save));
        return this;
    }

    public ChatPage clickInvite() {
        driver.findElement(UsersToChat).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(UsersToChat));
        return this;
    }

    public ChatPage clipboardShouldContainCurrentURL() {
        String currentUrl = driver.getCurrentUrl();
        String clipboardShouldContainCurrentURL = null;
        try {
            clipboardShouldContainCurrentURL = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(currentUrl, clipboardShouldContainCurrentURL, "Link incorrect");
        return this;
    }

    public ChatPage clickDragAndDrop() {
        driver.findElement(Chat_Manual_Upload).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Chat_Manual_Upload));
        return this;
    }

    public ChatPage clickBrowse(String url) {
        WebElement browse = driver.findElement(Hide);
        browse.sendKeys(System.getProperty("user.dir") + url);
        driver.findElement(File_Upload_Start).click();
        return this;
    }

    public ChatPage verifyFile(String validName) {
        String fileName = driver.findElement(FileName).getText();
        assertEquals(fileName, validName, "File upload error!");
        return this;
    }
}

