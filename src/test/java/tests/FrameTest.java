package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.BrowserWindowPage;
import pages.FramePage;
import pages.NestedFramePage;
import sharedData.SharedData;

import java.time.Duration;

public class FrameTest extends SharedData {


    @Test
    public void metodaTest(){

        HomePage homePage=new HomePage(getDriver());
        homePage.navigateToHomePage();

        BrowserWindowPage browserWindowPage=new BrowserWindowPage(getDriver());
        browserWindowPage.navigateToBrowserWindowPage();
        browserWindowPage.navigateToFrames();

        FramePage framePage=new FramePage(getDriver());
        framePage.interactWithBigFrame();
        framePage.interactWithSmallFrame();
        framePage.navigateToNestedFrames();

        NestedFramePage nestedFramePage=new NestedFramePage(getDriver());
        nestedFramePage.interactWithNestedFrame();

    }
}
