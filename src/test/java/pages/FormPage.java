package pages;

import helperMethods.ElementsMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
    public WebDriver driver; //avem nevoie de un driver
    public ElementsMethods elementMethods;
    public PageMethods pageMethods;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        pageMethods = new PageMethods(driver);
        elementMethods = new ElementsMethods (driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='col-12 mt-4  col-md-3']/div/div/div/div[@class='element-list collapse show']/ul/li/span[text()='Practice Form']")
    WebElement practiceForm;

    public void navigateToPracticeForm(){
        elementMethods.clickElement(practiceForm);
    }
}
