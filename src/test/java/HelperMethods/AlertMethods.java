package HelperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods {
    public WebDriver driver; //avem nevoie de un driver

    public AlertMethods(WebDriver driver) {   // ne generam constructorul
        this.driver = driver;
    }

    //definim metode generale pentru interactiunea cu alerte

    //facem o metoda pentru wait explicit:
    public void waitForAlert (){
        WebDriverWait webDriverWait= new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.alertIsPresent());

    }

    //accept
    public void acceptAlert(){
        //ne asiguram ca nu trebuie sa asteptam dupa o alerta, adica apelam metoda de mai sus:
        waitForAlert();

        Alert alertOK=driver.switchTo().alert();
        System.out.println(alertOK.getText());
        alertOK.accept();
    }

    //dismiss
    public void dismissAlert(){
        waitForAlert();
        Alert thirdOK=driver.switchTo().alert();
        System.out.println(thirdOK.getText());
        thirdOK.dismiss();
    }

    //input in alerta
    public void fillAlert(String value){  // ii dam un parametru care sa ia un input
        waitForAlert();
        Alert forthClickMe=driver.switchTo().alert();
        System.out.println(forthClickMe.getText());
        forthClickMe.sendKeys(value);
        forthClickMe.accept();
    }


}
