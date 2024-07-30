package pages;

import helperMethods.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class BasePage {

    protected WebDriver driver;
    protected ElementsMethods elementMethods;
    protected PageMethods pageMethods;
    protected AlertMethods alertMethods;
    protected FrameMethods frameMethods;
    protected WindowMethods windowMethods;


    public BasePage (WebDriver driver) {
        this.driver = driver;
        pageMethods = new PageMethods(driver);
        elementMethods = new ElementsMethods (driver);
        alertMethods=new AlertMethods(driver);
        frameMethods=new FrameMethods(driver);
        windowMethods=new WindowMethods(driver);
        PageFactory.initElements(driver, this);
    }




}
