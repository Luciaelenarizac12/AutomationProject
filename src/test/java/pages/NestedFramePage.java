package pages;

import helperMethods.ElementsMethods;
import helperMethods.FrameMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFramePage {
    public WebDriver driver;
    public ElementsMethods elementMethods;
    public PageMethods pageMethods;
    public FrameMethods frameMethods;

    public NestedFramePage(WebDriver driver) {
        this.driver = driver;
        pageMethods = new PageMethods(driver);
        elementMethods = new ElementsMethods (driver);
        frameMethods=new FrameMethods(driver);
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
    WebElement childFrame;

    @FindBy(xpath = "//p")
    WebElement text;

    public void interactWithNestedFrame(){
        frameMethods.switchtoFrame("frame1");
        frameMethods.switchtoFrame(childFrame);
        System.out.println(text.getText());
    }
}
