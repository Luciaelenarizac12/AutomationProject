package tests;

import helperMethods.ElementsMethods;
import helperMethods.FrameMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.AlertsFrameWindows;
import pages.BrowserWindowPage;
import pages.FramePage;
import pages.NestedFramePage;

import java.time.Duration;

public class FrameTest {
    public WebDriver driver;

    @Test
    public void metodaTest(){
        //trebuie sa deschidem un browser:
        driver = new ChromeDriver();

        //trebuie sa accesam un url:

        driver.get("https://demoqa.com/");

        //definim un wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        AlertsFrameWindows homePage=new AlertsFrameWindows(driver);
        homePage.navigateToHomePage();

        BrowserWindowPage browserWindowPage=new BrowserWindowPage(driver);
        browserWindowPage.navigateToBrowserWindowPage();
        browserWindowPage.navigateToFrames();

        FramePage framePage=new FramePage(driver);
        framePage.interactWithBigFrame();
        framePage.interactWithSmallFrame();
        framePage.navigateToNestedFrames();

        NestedFramePage nestedFramePage=new NestedFramePage(driver);
        nestedFramePage.interactWithNestedFrame();

        driver.quit();


//        WebElement formMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
////        formMenu.click();
//        elementsMethods.clickElement(formMenu);

//        WebElement frameButton = driver.findElement(By.xpath("//span[text()='Frames']"));
////        alertsButton.click();
//        elementMethods.clickElement(frameButton);


//
//        //ne mutam cu focusul pe un iFrame:
////        driver.switchTo().frame("frame1");
//        frameMethods.switchtoFrame("frame1");
//
//        WebElement iFrameText=driver.findElement(By.id("sampleHeading"));
//        System.out.println(iFrameText.getText());
//
//
//        //ne intoarcem cu focusul la frame-ul default:
////        driver.switchTo().defaultContent();
//        frameMethods.defaultcontentMethod();
//
//
////        driver.switchTo().frame("frame2");
//        frameMethods.switchtoFrame("frame2");
//
//        WebElement iFrameText2=driver.findElement(By.id("sampleHeading"));
//        System.out.println(iFrameText2.getText());
//
////        driver.switchTo().defaultContent();
//        frameMethods.defaultcontentMethod();
//
//        WebElement nestedFrames = driver.findElement(By.xpath("//span[text()='Nested Frames']"));
////        alertsButton.click();
//        elementMethods.clickElement(nestedFrames);
//
//        //interactionam cu iframe in iframe:
//
////        driver.switchTo().frame("frame1");
//        frameMethods.switchtoFrame("frame1");
//
//        WebElement childFrame= driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
////        driver.switchTo().frame(childFrame);
//        frameMethods.switchtoFrame(childFrame);
//
//
//        WebElement text=driver.findElement(By.xpath("//p"));
//        System.out.println(text.getText());


    }
}
