package tests;

import org.testng.annotations.Test;

public class SendMessage extends BaseTest {
    @Test
    public void sendMessage() {
        chatPage.openPage();
        chatPage.writeText("Hello");
        chatPage.clickSend();
        chatPage.messageShouldExist(1, "Hello");
    }

    @Test
    public void sendMessageByEnter() {
        chatPage.openPage();
        chatPage.writeText("Hello");
        chatPage.clickEnter();
        chatPage.messageShouldExist(1, "Hello");
    }

    @Test
    public void sendEnterLink() {
        chatPage.openPage();
        chatPage.writeText("https://www.google.com/");
        chatPage.clickEnter();
        chatPage.messageShouldExist(1, "https://www.google.com/");
    }

    @Test
    public void sendEnterHtml() {
        chatPage.openPage();
        chatPage.writeText("<html>");
        chatPage.clickEnter();
        chatPage.messageShouldExist(1, "<html>");
    }

    @Test
    public void editMessageAndDeleteMessage() {
        chatPage.openPage();
        chatPage.writeText("Hello");
        chatPage.clickSend();
        chatPage.editMessage();
        chatPage.writeTextMessage("Bye");
        chatPage.deleteMessage();
    }

    @Test
    public void setting() {
        chatPage.openPage();
        chatPage.setting();
        chatPage.enterName("Anna");
        chatPage.enterEmail("123@mail.ru");
        chatPage.photoURL("https://www.google.com/search");
    }

    @Test
    public void buttonInvite() {
        chatPage.openPage();
        chatPage.clickInvite();
        chatPage.getURL();
    }
    @Test
    public void filesUpload(){
        chatPage.openPage();
        chatPage.clickDragAndDrop();
        chatPage.clickBrowse();
    }
}


