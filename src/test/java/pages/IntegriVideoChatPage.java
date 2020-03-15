package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.*;

public class IntegriVideoChatPage extends BasePage {
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
    private final static By FileItemName = By.cssSelector(".integri-file-item-name");

    public IntegriVideoChatPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public BasePage isPageOpened() {
        return null;
    }

    public IntegriVideoChatPage openPage() {
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        isPageOpened();
        return this;
    }

    public IntegriVideoChatPage writeText(String text) {
        driver.findElement(CHAT_INPUT).sendKeys(text);
        return this;
    }

    public IntegriVideoChatPage clickSend() {
        driver.findElement(CHAT_SEND_MESSAGE).click();
        return this;
    }

    public IntegriVideoChatPage clickEnter() {
        WebElement enter = driver.findElement(CHAT_SEND_MESSAGE);
        enter.sendKeys(Keys.ENTER);
        return this;
    }

    public IntegriVideoChatPage messageShouldExist(int messageIndex, String text) {
        List<WebElement> messages = driver.findElements(CHAT_SEND_MESSAGE_TEXT);
        boolean isExist = messages.get(messageIndex - 1).getText().equals(text);
        assertTrue(isExist, "Message does not exist");
        return this;
    }

    public IntegriVideoChatPage linkText(int messageIndex, String text) {
        List<WebElement> link = driver.findElements(CHAT_MESSAGE_ATTACHMENT_LINK);
        boolean isExist = link.get(messageIndex - 1).getText().equals(text);
        assertFalse(isExist, "page does not load");
        return this;
    }

    public IntegriVideoChatPage editMessage() {
        driver.findElement(CHAT_EDIT_MESSAGE).click();
        return this;
    }

    public IntegriVideoChatPage modifyTextMessage(String text) {
        driver.findElement(CHAT_INPUT).clear();
        driver.findElement(CHAT_INPUT).sendKeys(text);
        return this;
    }

    public IntegriVideoChatPage modifyText(int messageIndex, String text) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> messages = driver.findElements(CHAT_MESSAGE_TEXT);
        boolean isExist = messages.get(messageIndex - 1).getText().equals(text);
        assertFalse(isExist, "Message does not exist");
        return this;
    }

    public IntegriVideoChatPage deleteMessage() {
        driver.findElement(CHAT_REMOVE_MESSAGE).click();
        Alert alert = driver.switchTo().alert();
        driver.switchTo().alert().accept();
        return this;
    }

    public IntegriVideoChatPage deleteMessageText(int messageIndex, String text) {
        List<WebElement> messages = driver.findElements(CHAT_MESSAGE_TEXT);
        boolean isExist = messages.get(messageIndex - 1).getText().equals(text);
        assertFalse(isExist, "removed...");
        return this;
    }

    public IntegriVideoChatPage checkLimit(String text) {
        for (int i = 0; i < 12; i++) {
            writeText(text);
            driver.findElement(CHAT_SEND_MESSAGE).click();
            wait.until(ExpectedConditions.numberOfElementsToBe((CHAT_MESSAGE_TEXT), i + 1));
        }
        driver.findElement(Big_Button);
        return this;
    }

    public IntegriVideoChatPage setting() {
        driver.findElement(CHAT_SETTINGS).click();
        return this;
    }

    public IntegriVideoChatPage checkName() {
        driver.findElement(UserName).clear();
        driver.findElement(UserName).sendKeys("Anna");
        String name = driver.findElement(UserName).getAttribute("value");
        assertEquals(name, "Anna", "Error!Repeat Entry!Check Name!");
        return this;
    }

    public IntegriVideoChatPage checkEmail() {
        driver.findElement(UserEmail).clear();
        driver.findElement(UserEmail).sendKeys("123@mail.ru");
        String email = driver.findElement(UserEmail).getAttribute("value");
        assertEquals(email, "123@mail.ru", "Error!Repeat Entry!Check Email!");
        return this;
    }

    public IntegriVideoChatPage checkPhotoURL() {
        driver.findElement(UserPic).clear();
        driver.findElement(UserPic).sendKeys("https://www.google.com/search");
        String photoURL = driver.findElement(UserPic).getAttribute("value");
        assertEquals(photoURL, "https://www.google.com/search", "Error!Repeat Entry!");
        return this;
    }

    public IntegriVideoChatPage saveSetting() {
        driver.findElement(User_Setting_Save).click();
        return this;
    }

    public IntegriVideoChatPage clickInvite() {
        driver.findElement(UsersToChat).click();
        return this;
    }

    public IntegriVideoChatPage clipboardShouldContainCurrentURL() {
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

    public IntegriVideoChatPage clickDragAndDrop() {
        driver.findElement(Chat_Manual_Upload).click();
        return this;
    }

    public IntegriVideoChatPage clickBrowse(String url) {
        WebElement browse = driver.findElement(Hide);
        browse.sendKeys(System.getProperty("user.dir") + url);
        driver.findElement(File_Upload_Start).click();
        return this;
    }

    public IntegriVideoChatPage verifyFile(String validName) {
        String fileName = driver.findElement(FileItemName).getText();
        assertEquals(fileName, validName, "File upload error!");
        return this;
    }
}


