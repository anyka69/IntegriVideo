package tests;

import org.testng.annotations.Test;

import java.io.File;

public class FileUploadModalsTest extends BaseTest {
    @Test
    public void fileUpload() {
        chatPage
                .openPage()
                .clickDragAndDrop()
                .clickBrowse(File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "webdrivers" + File.separator + "блабла.txt")
                .verifyFile("блабла.txt (0kb)");
    }
}
