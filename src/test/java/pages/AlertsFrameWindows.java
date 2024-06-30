package pages;

import helperMethods.ElementsMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsFrameWindows {
    public WebDriver driver; //avem nevoie de un driver
    public ElementsMethods elementMethods;
    public PageMethods pageMethods;


    public AlertsFrameWindows(WebDriver driver) { //constructorul
        this.driver = driver;
        pageMethods = new PageMethods(driver);
        elementMethods = new ElementsMethods (driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']") //anotare gen porecla
    public WebElement formMenu; //am transformat-o in variabila globala

    public void navigateToHomePage(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(formMenu);
    }


}
