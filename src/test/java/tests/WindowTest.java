package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.BrowserWindowPage;
import pages.HomePage;
import pages.WindowsPage;
import sharedData.SharedData;

public class WindowTest extends SharedData {
    @Test
    public void metodaTest() {

        HomePage homePage=new HomePage(getDriver());
        homePage.navigateToHomePage();

        BrowserWindowPage browserWindowPage=new BrowserWindowPage(getDriver());
        browserWindowPage.navigateToBrowserWindowPage();

        WindowsPage windowsPage =new WindowsPage(getDriver());
        windowsPage.interactWithFirstTab();
        windowsPage.interactWithTheSecondTab();

    }


}
