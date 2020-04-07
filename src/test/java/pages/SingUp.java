package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON));
        driver.findElement(BUTTON).click();
//        AllureUtils.takeScreenshot(driver);
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

    public SingUp clickBilling() {
        driver.findElement(By.xpath("//*[contains(text(),'Billing')]")).click();
        return this;
    }

    public SingUp clickAddNew() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Add new')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Add new')]")).click();
        return this;
    }

    public SingUp writeInformationCreditCard(String number, String mm, String yyyy, String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".paypal-button")));
        driver.findElement(By.name("number")).sendKeys(number);
        driver.findElement(By.name("expirationMonth")).sendKeys(mm);
        driver.findElement(By.name("expirationYear")).sendKeys(yyyy);
        driver.findElement(By.name("cardholderName")).sendKeys(name);
        return this;
    }

    public SingUp clickAddCard() {
        driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add')]")));
        return this;
    }

    public SingUp makeDefault(int number) {
        List<WebElement> makeDefault = driver.findElements(By.xpath("//*[contains(text(),'Make default')]"));
        makeDefault.get(number).click();
        return this;
    }

    public SingUp removeCard(int number) {
        List<WebElement> deleteElement = driver.findElements(By.xpath("//*[contains(text(),'Remove')]"));
        deleteElement.get(number).click();
        return this;
    }

    public SingUp clickLogout() {
        driver.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();
        return this;
    }
}
