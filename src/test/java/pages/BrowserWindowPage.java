package pages;

import helperMethods.ElementsMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserWindowPage {
    public WebDriver driver; //avem nevoie de un driver
    public ElementsMethods elementMethods;
    public PageMethods pageMethods;

    public BrowserWindowPage(WebDriver driver) { //constructorul
        this.driver = driver;
        pageMethods = new PageMethods(driver);
        elementMethods = new ElementsMethods (driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Browser Windows']") //anotare gen porecla
    public WebElement browserWindows; //am transformat-o in variabila globala


    @FindBy(xpath = "//span[text()='Frames']")
    public WebElement frameButton;

    @FindBy(xpath = "//span[text()='Alerts']")
    WebElement alertsButton;

    @FindBy(xpath = "//span[text()='Web Tables']")
    WebElement webTableSubmenu;


    public void navigateToBrowserWindowPage(){
        pageMethods.scrollPage(0,150);
        elementMethods.clickElement(browserWindows);

    }
    public void navigateToFrames(){
        pageMethods.scrollPage(0,150);
        elementMethods.clickElement(frameButton);
    }

    public void navigateToAlerts(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(alertsButton);
    }


    public void navigateToWebTable(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(webTableSubmenu);
    }



}
