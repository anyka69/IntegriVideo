package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.UUID;

public class SingUp extends BasePage {
    By Email = By.name("email");
    By Password = By.name("password");
    By BUTTON = By.cssSelector(".btn");
    By fileAdd = By.cssSelector(".iv-icon-file-add");

    public SingUp(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage openPage() {
        return null;
    }

    @Override
    public SingUp openPage(String text) {
        driver.get(text);
        return this;
    }

    @Override
    public SingUp isPageOpened() {
        return this;
    }

    public SingUp writeRandomEmail() {
        driver.findElement(Email).sendKeys(UUID.randomUUID().toString() + "@mailinator.com");
        return this;
    }

    public SingUp logout(String email, String password) {
        driver.findElement(Email).sendKeys(email);
        driver.findElement(Password).sendKeys(password);
        driver.findElement(BUTTON).click();
        return this;
    }

    public SingUp writePassword(String text) {
        driver.findElement(Password).sendKeys(text);
        return this;
    }

    public SingUp clickLogin() {
        driver.findElement(BUTTON).click();
        return this;
    }

    public SingUp addProject() {
        driver.findElement(fileAdd).click();
        return this;
    }

    public SingUp writeTextProjectName(String name) {
        driver.findElement(By.name("name")).sendKeys(name);

        return this;
    }

    public SingUp writeTextDomains(int addIndex, String domains) {
        List<WebElement> addElement = driver.findElements(By.name("domains[]"));
        addElement.get(addIndex).sendKeys(domains);
        return this;
    }

    public SingUp deleteDomain(int deleteIndex) {
        List<WebElement> deleteElement = driver.findElements(By.cssSelector(".remove-domain"));
        deleteElement.get(deleteIndex).click();
        return this;
    }

    public SingUp clickButtonCreate() {
        driver.findElement(BUTTON).click();
        return this;
    }


}
