package helperMethods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@AllArgsConstructor
public class FrameMethods {

    public WebDriver driver;

    public void switchtoFrame(String text){
        driver.switchTo().frame(text);
    }

    public void switchtoFrame(WebElement element){
        driver.switchTo().frame(element);
    }

    public void defaultcontentMethod (){
        driver.switchTo().defaultContent();
    }
}
