package tests;

import org.testng.annotations.Test;

public class SettingModalTest extends BaseTest {
    @Test
    public void checkSetting() {
        chatPage
                .openPage()
                .clickSetting()
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
}