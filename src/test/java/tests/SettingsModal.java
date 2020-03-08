package tests;

import org.testng.annotations.Test;

public class SettingsModal extends BaseTest {
    @Test
    public void checkSetting(){
        chatPage.openPage();
        chatPage.setting();
        chatPage.checkName();
        chatPage.checkEmail();
        chatPage.checkPhotoURL();
        chatPage.settingSave();
    }
    @Test
    public void buttonInvite() {
        chatPage.openPage();
        chatPage.clickInvite();
        chatPage.getURL();
    }

}
