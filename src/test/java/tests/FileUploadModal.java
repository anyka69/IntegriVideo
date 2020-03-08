package tests;

import org.testng.annotations.Test;

public class FileUploadModal extends BaseTest{
    @Test
    public void fileUpload(){
        chatPage.openPage();
        chatPage.clickDragAndDrop();
        chatPage.clickBrowse("C:\\Users\\Юра\\Desktop\\блабла.txt");
    }
}
