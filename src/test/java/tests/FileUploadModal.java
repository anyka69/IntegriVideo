package tests;

import org.testng.annotations.Test;

public class FileUploadModal extends BaseTest{
    @Test
    public void fileUpload(){
        chatPage
                .openPage()
                .clickDragAndDrop()
                .clickBrowse("\\src\\main\\resources\\Cat.jpg")
                .verifyFile("Cat.jpg");
    }
}
