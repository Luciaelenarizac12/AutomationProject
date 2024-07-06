package pages;

import helperMethods.AlertMethods;
import helperMethods.ElementsMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {
    public WebDriver driver; //avem nevoie de un driver
    public ElementsMethods elementMethods;
    public PageMethods pageMethods;
    public AlertMethods alertMethods;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        pageMethods = new PageMethods(driver);
        elementMethods = new ElementsMethods (driver);
        alertMethods=new AlertMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "alertButton")
    WebElement firstAlertButton;

    @FindBy(id="timerAlertButton")
    WebElement alertWait;

    @FindBy(id = "confirmButton")
    WebElement thirdAlertButton;

    @FindBy(id = "promtButton")
    WebElement forthAlertButton;


    public void firstButton(){
        elementMethods.clickElement(firstAlertButton);
        alertMethods.acceptAlert();
    }

    public void secondButton(){
        elementMethods.clickElement(alertWait);
        alertMethods.waitForAlert();
        Alert waitConfirm=driver.switchTo().alert();
        System.out.println(waitConfirm.getText());
        waitConfirm.accept();
    }

    public void thirdButton(){
        elementMethods.clickElement(thirdAlertButton);
        alertMethods.dismissAlert();
    }

    public void forthButton(){
        elementMethods.clickElement(forthAlertButton);
        alertMethods.fillAlert("Lucia");
    }


}
