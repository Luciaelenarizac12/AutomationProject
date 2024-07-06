package tests;

import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.BrowserWindowPage;
import pages.HomePage;
import pages.WebTablePage;


public class WebTableTest {

    public WebDriver driver;

    @Test

    public void metodaTest() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
        //Obiecte:
        PageMethods pageMethods=new PageMethods(driver);
        pageMethods.scrollPage(0,360);

        HomePage homePage=new HomePage(driver);
        homePage.navigateToElements();

        BrowserWindowPage browserWindowPage=new BrowserWindowPage(driver);
        browserWindowPage.navigateToWebTable();

        WebTablePage webTablePage=new WebTablePage(driver);
        webTablePage.addEntry("Lucia","Rizac","luciarizac@yahoo.com",
                "28","4000000000","Clinical Trials");
        webTablePage.changeEntry("90000000000000", "Testare Automata" );
        webTablePage.deleteEntry();

        driver.quit();

    }


}
