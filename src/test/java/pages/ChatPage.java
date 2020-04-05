package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

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
    private final static By FileItemName = By.cssSelector(".integri-file-item-name");
    String url = "https://dev.integrivideo.com/demo/chat/new";

    public ChatPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ChatPage openPage() {
        driver.get(url);
        isPageOpened();
        return this;
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

    public ChatPage modifyText(int messageIndex, String text) {
        List<WebElement> messages = driver.findElements(CHAT_MESSAGE_TEXT);
        boolean isExist = messages.get(messageIndex - 1).getText().equals(text);
        assertFalse(isExist, "Message does not exist");
        return this;
    }

    public ChatPage deleteMessage() {
        driver.findElement(CHAT_REMOVE_MESSAGE).click();
        Alert alert = driver.switchTo().alert();
        driver.switchTo().alert().accept();
        return this;
    }

    public ChatPage deleteMessageText(int messageIndex, String text) {
        List<WebElement> messages = driver.findElements(CHAT_MESSAGE_TEXT);
        boolean isExist = messages.get(messageIndex - 1).getText().equals(text);
        assertFalse(isExist, "removed...");
        return this;
    }

    public ChatPage checkLimit(String text) {
        for (int i = 0; i < 12; i++) {
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
}
