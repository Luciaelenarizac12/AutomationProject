package pages;

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
