package tests;

import org.testng.annotations.Test;

public class SettingsModal extends BaseTest {
    @Test
    public void checkSetting(){
        chatPage
                .openPage()
                .setting()
                .checkName()
                .checkEmail()
                .checkPhotoURL()
                .saveSetting();
    }

    @Test
    public void buttonInvite() {
        chatPage
                .openPage()
                .clickInvite()
                .clipboardShouldContainCurrentURL();
    }

    @Test
    public void runTest() {
        System.out.println(System.getProperty("testProp"));
    }
}
