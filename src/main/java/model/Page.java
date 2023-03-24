package model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    public WebDriver driver;
    public final static String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    
    public Page(WebDriver driver) {
        this.driver = driver;
    }
    
    public void openPage() {
        driver.get(PAGE_URL);
    }
    
    public void scrollAndClickElement(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 20)
            .until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
    
    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }
    
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }
    
    public String getElementText(WebElement element) {
        new WebDriverWait(driver, 20)
            .until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
    public void findElementAndInputData(By locator, String data) {
        new WebDriverWait(driver, 20)
            .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).sendKeys(data);
    }
    
    public void selectElementFromList(String locatorTemplate,String option) {
        new WebDriverWait(driver, 20)
            .until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(locatorTemplate,option))));
        driver.findElement(By.xpath(String.format(locatorTemplate,option))).click();
    }
    
    public void findAndClickElement(By locator){
        new WebDriverWait(driver, 20)
            .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }
}
