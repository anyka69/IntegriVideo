package tests;

import org.testng.annotations.Test;

public class FileUploadModalsTest extends BaseTest {
    @Test
    public void fileUpload() {
        chatPage
                .openPage()
                .clickDragAndDrop()
                .clickBrowse("\\src\\test\\resources\\webdrivers\\блабла.txt")
                .verifyFile("блабла.txt (0kb)");
    }
}
