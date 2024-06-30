package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.BrowserWindowPage;
import pages.AlertsFrameWindows;
import pages.WindowsPage;

import java.util.ArrayList;
import java.util.List;

public class WindowTest {
    @Test
    public void metodaTest() {
        WebDriver driver;

        driver = new ChromeDriver();

        driver.get("https://demoqa.com/");

        driver.manage().window().maximize();

        AlertsFrameWindows homePage=new AlertsFrameWindows(driver);
        homePage.navigateToHomePage();

        BrowserWindowPage browserWindowPage=new BrowserWindowPage(driver);
        browserWindowPage.navigateToBrowserWindowPage();

        WindowsPage windowsPage =new WindowsPage(driver);
        windowsPage.interactWithFirstTab();
        windowsPage.interactWithTheSecondTab();

        driver.quit();

        //Definim un obiect de tipul Window Methods:
//        WindowMethods windowMethods=new WindowMethods(driver);
//        ElementsMethods elementMethods = new ElementsMethods (driver);
//        PageMethods pageMethods = new PageMethods(driver);

        //facem un scroll la pagina pentru vizibilitate:
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,360)", "");
//
//        pageMethods.scrollPage(0,350);

//        WebElement formMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        formMenu.click();
//        elementMethods.clickElement(formMenu);

//        WebElement browserWindows = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
//        browserWindows.click();
//        elementMethods.clickElement(browserWindows);


        //id="tabButton"
//        WebElement newTabButton = driver.findElement(By.id("tabButton"));
////        newTabButton.click();
//        elementMethods.clickElement(newTabButton);
//
//        //interactionam cu un tab/window:
//
//        //afisam titlul paginii curente pe care ne aflam:
////        System.out.println(driver.getTitle());
//
//        System.out.println(driver.getCurrentUrl());  //ne afiseaza url ul paginii curente pe care ne aflam
//
////        List<String> tabs= new ArrayList<>(driver.getWindowHandles()); // gaseste cate tab uri/ windows uri sunt deschise
////        driver.switchTo().window(tabs.get(1)); - transformam in comentariu
//        windowMethods.switchSpecificTab(1);
//        System.out.println(driver.getCurrentUrl());

        //inchidem tab ul curent
////        driver.close();
////        driver.switchTo().window(tabs.get(0)); //la fel
////        windowMethods.closeCurrentTab();
//        windowMethods.switchSpecificTab(0);
//
//
//        WebElement newWindow=driver.findElement(By.id("windowButton"));
////        newWindow.click();
//        elementMethods.clickElement(newWindow);
//
////        List<String> window= new ArrayList<>(driver.getWindowHandles());
////        driver.switchTo().window(window.get(1));
//        windowMethods.switchSpecificTab(1);
//        System.out.println(driver.getCurrentUrl());
//
//        //inchidem browserul
//        windowMethods.closeCurrentTab();



    }


}
