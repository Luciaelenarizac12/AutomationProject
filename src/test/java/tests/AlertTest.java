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
import sharedData.SharedData;

import java.time.Duration;

public class AlertTest extends SharedData {

    @Test
    public void metodaTest(){

        //definim un obiect de tip alertMethods ca sa apelam metodele generale din clasa:
        HomePage homePage =new HomePage(getDriver());
        homePage.navigateToHomePage();

        BrowserWindowPage browserWindowPage=new BrowserWindowPage(getDriver());
        browserWindowPage.navigateToAlerts();

        AlertPage alertPage=new AlertPage(getDriver());
        alertPage.firstButton();
        alertPage.secondButton();
        alertPage.thirdButton();
        alertPage.forthButton();

    }
}
