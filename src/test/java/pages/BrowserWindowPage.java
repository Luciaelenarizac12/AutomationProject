package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowserWindowPage extends BasePage {

    public BrowserWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Browser Windows']") //anotare gen porecla
    private WebElement browserWindows; //am transformat-o in variabila globala


    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement frameButton;

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertsButton;

    @FindBy(xpath = "//span[text()='Web Tables']")
    private WebElement webTableSubmenu;

    public void navigateToBrowserWindowPage(){
        pageMethods.scrollPage(0,150);
        LoggerUtility.info("The user scrolled down the page");
        elementMethods.clickElement(browserWindows);
        LoggerUtility.info("The user clicked on the Browser Window page");

    }
    public void navigateToFrames(){
        pageMethods.scrollPage(0,150);
        LoggerUtility.info("The user scrolled down the page");
        elementMethods.clickElement(frameButton);
        LoggerUtility.info("The user clicked on the Frames page");
    }

    public void navigateToAlerts(){
        pageMethods.scrollPage(0,350);
        LoggerUtility.info("The user scrolled down the page");
        elementMethods.clickElement(alertsButton);
        LoggerUtility.info("The user clicked on the Alerts page");
    }


    public void navigateToWebTable(){
        pageMethods.scrollPage(0,350);
        LoggerUtility.info("The user scrolled down the page");
        elementMethods.clickElement(webTableSubmenu);
        LoggerUtility.info("The user clicked on the WebTable page");
    }



}
