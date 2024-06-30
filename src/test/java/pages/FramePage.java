package pages;

import helperMethods.ElementsMethods;
import helperMethods.FrameMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage {
    public WebDriver driver;
    public PageMethods pageMethods;
    public FrameMethods frameMethods;
    public ElementsMethods elementMethods;


    public FramePage(WebDriver driver) {
        this.driver = driver;
        pageMethods = new PageMethods(driver);
        frameMethods=new FrameMethods(driver);
        elementMethods = new ElementsMethods (driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "sampleHeading")
    WebElement iFrameText;

    @FindBy(id = "sampleHeading")
    WebElement iFrameText2;

    @FindBy(xpath = "//span[text()='Nested Frames']")
    WebElement nestedFrames;

    public void interactWithBigFrame(){
        frameMethods.switchtoFrame("frame1");
        System.out.println(iFrameText.getText());
        frameMethods.defaultcontentMethod();
    }

    public void interactWithSmallFrame(){
        frameMethods.switchtoFrame("frame2");
        System.out.println(iFrameText2.getText());
        frameMethods.defaultcontentMethod();
    }


    public void navigateToNestedFrames(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(nestedFrames);
    }



}
