package Tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.PageMethods;
import com.beust.ah.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alerts {
    public WebDriver driver;

    @Test
    public void metodaTest(){

        //trebuie sa deschidem un browser:
        driver = new ChromeDriver();

        //trebuie sa accesam un url:

        driver.get("https://demoqa.com/");

        PageMethods pageMethods = new PageMethods(driver);
        ElementsMethods elementsMethods=new ElementsMethods(driver);

        //facem un scroll la pagina pentru vizibilitate:
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,360)", "");
        pageMethods.scrollPage(0,360);

        //definim un wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //definim un obiect de tip alertMethods ca sa apelam metodele generale din clasa:
        AlertMethods alertMethods = new AlertMethods(driver);


        WebElement formMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        formMenu.click();
        elementsMethods.clickElement(formMenu);

        WebElement alertsButton = driver.findElement(By.xpath("//span[text()='Alerts']"));
//        alertsButton.click();
        elementsMethods.clickElement(alertsButton);

        //prima alerta
        WebElement firstAlertButton = driver.findElement(By.id("alertButton"));
//        firstAlertButton.click();
        elementsMethods.clickElement(firstAlertButton);

//        Alert alertOK=driver.switchTo().alert();
//        System.out.println(alertOK.getText());
//        alertOK.accept();
        alertMethods.acceptAlert();

        //al 3lea buton de alerta
        WebElement thirdAlertButton=driver.findElement(By.id("confirmButton"));
//        thirdAlertButton.click();
        elementsMethods.clickElement(thirdAlertButton);

//        Alert thirdOK=driver.switchTo().alert();
//        System.out.println(thirdOK.getText());
//        thirdOK.dismiss();
        alertMethods.dismissAlert();

        //al 4-lea buton de alerta

        WebElement forthAlertButton= driver.findElement(By.id("promtButton"));
//        forthAlertButton.click();
        elementsMethods.clickElement(forthAlertButton);

//        Alert forthClickMe=driver.switchTo().alert();
//        System.out.println(forthClickMe.getText());
//        String alertValue="Lucia";
//        forthClickMe.sendKeys(alertValue);
//        forthClickMe.accept();
        alertMethods.fillAlert("Lucia");

        //interactionam cu o alerta pentru care trebuie sa asteptam:

       WebElement alertWait= driver.findElement(By.id("timerAlertButton"));
//       alertWait.click();
        elementsMethods.clickElement(alertWait);

       //definim un wait explicit:
//        WebDriverWait webDriverWait= new WebDriverWait(driver, Duration.ofSeconds(10));
//        webDriverWait.until(ExpectedConditions.alertIsPresent());

        alertMethods.waitForAlert();

       Alert waitConfirm=driver.switchTo().alert();
       System.out.println(waitConfirm.getText());
       waitConfirm.accept();

    }
}
