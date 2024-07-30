package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "sampleHeading")
    private WebElement iFrameText;

    @FindBy(id = "sampleHeading")
    private WebElement iFrameText2;

    @FindBy(xpath = "//span[text()='Nested Frames']")
    private WebElement nestedFrames;


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
