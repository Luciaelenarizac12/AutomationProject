package tests;

import helperMethods.AlertMethods;
import helperMethods.ElementsMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.HomePage;
import pages.BrowserWindowPage;

import java.time.Duration;

public class AlertTest {
    public WebDriver driver;

    @Test
    public void metodaTest(){

        //trebuie sa deschidem un browser:
        driver = new ChromeDriver();

        //trebuie sa accesam un url:

        driver.get("https://demoqa.com/");

        //definim un wait implicit -asta ramane
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //definim un obiect de tip alertMethods ca sa apelam metodele generale din clasa:
        HomePage homePage =new HomePage(driver);
        homePage.navigateToHomePage();

        BrowserWindowPage browserWindowPage=new BrowserWindowPage(driver);
        browserWindowPage.navigateToAlerts();

        AlertPage alertPage=new AlertPage(driver);
        alertPage.firstButton();
        alertPage.secondButton();
        alertPage.thirdButton();
        alertPage.forthButton();

    }
}
