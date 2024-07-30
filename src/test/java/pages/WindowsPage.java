package pages;

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
