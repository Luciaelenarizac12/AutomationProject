package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage {


    public AlertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    private WebElement firstAlertButton;

    @FindBy(id="timerAlertButton")
    private WebElement alertWait;

    @FindBy(id = "confirmButton")
    private WebElement thirdAlertButton;

    @FindBy(id = "promtButton")
    private WebElement forthAlertButton;

    public void firstButton(){
        elementMethods.clickJSElement(firstAlertButton);
        LoggerUtility.info("The user clicks on the alertOK button");
        alertMethods.acceptAlert();
        LoggerUtility.info("The user interacts with the alertOK successfully");
    }

    public void secondButton(){
        elementMethods.clickJSElement(alertWait);
        LoggerUtility.info("The user interacts with the 2nd button successfully");
        alertMethods.waitForAlert();
        LoggerUtility.info("The user is waiting for the alert to appear");
        Alert waitConfirm=driver.switchTo().alert();
        System.out.println(waitConfirm.getText());
        waitConfirm.accept();
        LoggerUtility.info("The user clicked on OK button");

    }

    public void thirdButton(){
        elementMethods.clickJSElement(thirdAlertButton);
        LoggerUtility.info("The user interacts with the 3rd button successfully");
        alertMethods.dismissAlert();
        LoggerUtility.info("The user clicked on cancel");

    }

    public void forthButton(){
        elementMethods.clickJSElement(forthAlertButton);
        LoggerUtility.info("The user interacts with the 4th button successfully");
        alertMethods.fillAlert("Lucia");
        LoggerUtility.info("The user submits the text in the prompt");
    }


}
