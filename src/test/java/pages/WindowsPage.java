package pages;

import helperMethods.ElementsMethods;
import helperMethods.PageMethods;
import helperMethods.WindowMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowsPage {
        public WebDriver driver;
        public ElementsMethods elementMethods;
        public PageMethods pageMethods;
        public WindowMethods windowMethods;

        public WindowsPage (WebDriver driver) { //constructorul
            this.driver = driver;
            pageMethods = new PageMethods(driver);
            elementMethods = new ElementsMethods (driver);
            windowMethods= new WindowMethods(driver);
            PageFactory.initElements(driver, this);
        }

        @FindBy(id = "tabButton")
        public WebElement newTabButton;

        @FindBy(id = "windowButton")
        public WebElement newWindow;

        public void interactWithFirstTab() {

            pageMethods.scrollPage(0, 150);
            elementMethods.clickElement(newTabButton);
            System.out.println(driver.getCurrentUrl());  //ne afiseaza url ul paginii curente pe care ne aflam
            windowMethods.switchSpecificTab(1);
            System.out.println(driver.getCurrentUrl());
            windowMethods.closeCurrentTab();
            windowMethods.switchSpecificTab(0);

        }

        public void interactWithTheSecondTab(){
            pageMethods.scrollPage(0,150);
            newWindow.click();
            elementMethods.clickElement(newWindow);
            windowMethods.switchSpecificTab(1);
            System.out.println(driver.getCurrentUrl());
            windowMethods.closeCurrentTab();

        }


}
