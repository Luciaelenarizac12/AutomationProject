package pages;

import helperMethods.ElementsMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver; //avem nevoie de un driver
    public ElementsMethods elementMethods;
    public PageMethods pageMethods;


    public HomePage(WebDriver driver) { //constructorul
        this.driver = driver;
        pageMethods = new PageMethods(driver);
        elementMethods = new ElementsMethods (driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']") //anotare gen porecla
    public WebElement formMenu; //am transformat-o in variabila globala

    @FindBy(xpath = "//h5[text()='Forms']")
    WebElement formsMenu;

    @FindBy(xpath = "//h5[text()='Elements']")
    WebElement elementMenu;

    public void navigateToHomePage(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(formMenu);
    }
    public void navigateToForms(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(formsMenu);
    }
    public void navigateToElements(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(elementMenu);

    }


}
