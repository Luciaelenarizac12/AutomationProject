package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage{


    @FindBy(id = "tabButton")
    private WebElement newTabButton;
    @FindBy(id = "windowButton")
    private WebElement newWindow;

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    public void interactWithFirstTab() {

            pageMethods.scrollPage(0, 150);
            LoggerUtility.info("The user scrolled down the page");
            elementMethods.clickJSElement(newTabButton);
            LoggerUtility.info("The user clicked on new tab button");
            System.out.println(driver.getCurrentUrl());  //ne afiseaza url ul paginii curente pe care ne aflam
            windowMethods.switchSpecificTab(1);
            LoggerUtility.info("The user switched on second tab");
            System.out.println(driver.getCurrentUrl());
            windowMethods.closeCurrentTab();
            LoggerUtility.info("The user closed the current tab");
            windowMethods.switchSpecificTab(0);
            LoggerUtility.info("The user switched back on the default tab");

        }

        public void interactWithTheSecondTab(){
            pageMethods.scrollPage(0,150);
            LoggerUtility.info("The user scrolled down the page");
            newWindow.click();
            LoggerUtility.info("The user performed a click");
            windowMethods.switchSpecificTab(1);
            LoggerUtility.info("The user switched to another tab");
            System.out.println(driver.getCurrentUrl());
            windowMethods.closeCurrentTab();
            LoggerUtility.info("The user closed the current tab");

        }


}
