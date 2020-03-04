package tests;

import org.testng.annotations.Test;

public class ChatTests extends BaseTest {
    @Test()
    public void sendMessage (){
       chatPage.openPage();
       chatPage.writeText("test");
       chatPage.clickSend();
       chatPage.messageShouldExist(1,"test");

    }

}