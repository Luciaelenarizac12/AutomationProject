package HelperMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowMethods {

    public WebDriver driver;

    //Constructor
    public WindowMethods (WebDriver driver){
        this.driver=driver;
    }

    // metode generale pt interactiunea cu tab/window:

    public void switchSpecificTab (Integer index) {

        List<String> tabs = new ArrayList<>(driver.getWindowHandles()); // gaseste cate tab uri/ windows uri sunt deschise
        driver.switchTo().window(tabs.get(index));
    }

    public void closeCurrentTab(){
        driver.close();
    }
}
