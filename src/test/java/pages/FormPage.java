package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage extends BasePage{
    public FormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='col-12 mt-4  col-md-3']/div/div/div/div[@class='element-list collapse show']/ul/li/span[text()='Practice Form']")
    private WebElement practiceForm;


    public void navigateToPracticeForm(){
        elementMethods.clickElement(practiceForm);
        LoggerUtility.info("The user clicks on the Practice Form submenu");

    }
}
