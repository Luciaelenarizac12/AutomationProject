package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']") //anotare gen porecla
    private WebElement formMenu; //am transformat-o in variabila globala

    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formsMenu;

    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementMenu;


    public void navigateToHomePage(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(formMenu);
        LoggerUtility.info("The user clicks on Alerts, Frame & Windows Menu");
    }
    public void navigateToForms(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(formsMenu);
        LoggerUtility.info("The user clicks on Forms Menu");
    }
    public void navigateToElements(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(elementMenu);
        LoggerUtility.info("The user clicks on Elements Menu");

    }


}
