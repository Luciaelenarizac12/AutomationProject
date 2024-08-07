package helperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementsMethods {

    public WebDriver driver;

    //Constructor
    public ElementsMethods (WebDriver driver){
        this.driver=driver;
    }

    //metode generale pentru interactiunea cu elemente

    public void waitForElementVisibile(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickElement(WebElement element){
        waitForElementVisibile(element);
        element.click();
    }

    public void fillElement(WebElement element, String input){
        waitForElementVisibile(element);
        element.sendKeys(input);
    }

    public void pressElement(WebElement element, Keys key){
        waitForElementVisibile(element);
        element.sendKeys(key);
    }

    public void clickJSElement(WebElement element){
        waitForElementVisibile(element);
        JavascriptExecutor jsclick = (JavascriptExecutor) driver;
        jsclick.executeScript("arguments[0].click();", element);
    }

    public void selectByTextElement(WebElement element, String text){
        waitForElementVisibile(element);
        Select monthSelect = new Select(element);
        monthSelect.selectByVisibleText(text);

    }
    public void selectByValue(WebElement element, String text){
        waitForElementVisibile(element);
        Select monthSelect = new Select(element);
        monthSelect.selectByValue(text);

    }
    public void clearFillElement(WebElement element, String text){
        waitForElementVisibile(element);
        element.clear();
        element.sendKeys(text);
    }


}
