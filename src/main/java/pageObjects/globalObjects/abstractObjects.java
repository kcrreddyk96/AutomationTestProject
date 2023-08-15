package pageObjects.globalObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class abstractObjects {
    WebDriver driver;

    public abstractObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //TODO - Global Objects Pages Elements
/*    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement search;*/

    //TODO - Visibility of Web Element using BY Locator
    public void waitforElementtoAppear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    //TODO - Visibility of Web Element using WebElement Locator

    public void waitforElementtoAppear(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    //TODO - invisibility of Web Element using WebElement Locator
    public void waitforElementtoDisappear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    //TODO - Global Objects Pages Elements Methods
    

}
