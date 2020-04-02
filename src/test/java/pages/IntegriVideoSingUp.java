package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.UUID;


public class IntegriVideoSingUp extends BasePage {
    @FindBy(name = "email")
    WebElement emailField;
    @FindBy(name = "password")
    WebElement passwordField;
    @FindBy(css = ".btn")
    WebElement button;
    @FindBy(css = ".iv-icon-file-add")
    WebElement fileAdd;


    public IntegriVideoSingUp(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public BasePage isPageOpened() {
        return null;
    }

    @Override
    public BasePage openPage() {
        return null;
    }

    public IntegriVideoSingUp openPageSingUp() {
        driver.get("https://dev.integrivideo.com/signup");
        return this;
    }

    public IntegriVideoSingUp writeRandomEmail() {
        emailField.sendKeys(UUID.randomUUID().toString() + "@mailinator.com");
        return this;
    }

    public IntegriVideoSingUp writeEmail(String text) {
        emailField.sendKeys(text);
        return this;
    }

    public IntegriVideoSingUp writePassword(String text) {
        passwordField.sendKeys(text);
        return this;
    }

    public IntegriVideoSingUp clickLogin() {
        button.click();
        return this;
    }

    public IntegriVideoSingUp openPageLogin() {
        driver.get("https://dev.integrivideo.com/login");
        return this;
    }

    public IntegriVideoSingUp addProject() {
        fileAdd.click();
        return this;
    }

    public IntegriVideoSingUp writeTextProjectName(String name) {
        driver.findElement(By.name("name")).sendKeys(name);
        return this;
    }

    public IntegriVideoSingUp writeTextDomains(int addIndex, String domains) {
        List<WebElement> addElement = driver.findElements(By.name("domains[]"));
        addElement.get(addIndex).sendKeys(domains);
        return this;
    }

    public IntegriVideoSingUp deleteDomain(int deleteIndex) {
        List<WebElement> deleteElement = driver.findElements(By.name("domains[]"));
        deleteElement.get(deleteIndex).click();
        return this;
    }

    public IntegriVideoSingUp clickButtonCreate() {
        driver.findElement(By.xpath("//*[@id=\"project-form\"]/form/button")).click();
        return this;
    }

    public IntegriVideoSingUp checkActiveProject(int indexProject) {
        List<WebElement> deleteElement = driver.findElements(By.id("project-list"));
        deleteElement.get(indexProject).click();
        return this;
    }

    public IntegriVideoSingUp clickAddNewComponent(int indexComponent) {
        List<WebElement> addComponent = driver.findElements(By.id("component-list"));
        addComponent.get(indexComponent).click();
        return this;
    }

    public IntegriVideoSingUp writeTextComponentName(String name) {
        driver.findElement(By.xpath("//*[@id=\"component-form\"]/form/div[3]/input")).sendKeys(name);
        return this;
    }

    public IntegriVideoSingUp clickCreate() {
        driver.findElement(By.xpath("//*[@id=\"component-form\"]/form/button")).click();
        return this;
    }

    public IntegriVideoSingUp clickBilling() {
        driver.findElement(By.cssSelector(".iv-icon-credit-card")).click();
        return this;
    }

    public IntegriVideoSingUp clickButtonAddNew() {
        driver.findElement(By.xpath("/html/body/main/div/div[1]/a")).click();
        return this;
    }

    public IntegriVideoSingUp writeInformationCreditCard(String number, String mm, String yyyy, String name) {
        driver.findElement(By.name("number")).sendKeys(number);
        driver.findElement(By.name("expirationMonth")).sendKeys(mm);
        driver.findElement(By.name("expirationYear")).sendKeys(yyyy);
        driver.findElement(By.name("cardholderName")).sendKeys(name);
        return this;
    }

    public IntegriVideoSingUp clickAddCard() {
        driver.findElement(By.xpath("//*[@id=\"credit-card\"]/form/button")).click();
        return this;
    }

    public IntegriVideoSingUp addNewCard() {
        driver.findElement(By.cssSelector(".bnt")).click();
        return this;
    }

    public IntegriVideoSingUp makeDefault(int number) {
        List<WebElement> makeDefault = driver.findElements(By.cssSelector(".col-md-3"));
        makeDefault.get(number).click();
        return this;
    }

    public IntegriVideoSingUp deleteCard(int number) {
        List<WebElement> deleteElement = driver.findElements(By.cssSelector(".col-md-2"));
        deleteElement.get(number).click();
        return this;
    }

    public IntegriVideoSingUp clickLogout() {
        driver.findElement(By.xpath("//*[@id=\"navbarMenu\"]/a[4]")).click();
        return this;
    }
}
