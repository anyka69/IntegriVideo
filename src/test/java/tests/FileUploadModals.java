package tests;

import org.testng.annotations.Test;

public class FileUploadModals extends BaseTest {
    @Test
    public void fileUpload() {
        chatPage
                .openPage()
                .clickDragAndDrop()
                .clickBrowse("\\src\\main\\resources\\блабла.txt")
                .verifyFile("блабла.txt (0kb)");
    }
}
