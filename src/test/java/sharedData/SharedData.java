package sharedData;

import loggerUtility.LoggerUtility;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.Credentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

@Getter
@Setter
public class SharedData {

    private WebDriver driver;  //parentul lasa copilul sa mosteneasca variabila driver, dar nu ii lasa sa o modifice

    @BeforeMethod
    public void prepareEnvironment() {
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--headless=new"); //nu iti ruleaza browserul vizibil, ci ruleaza in background (se misca mai repede)
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoggerUtility.info("The browser is open with success");
    }

    @AfterMethod
    public void clearEnvironment(ITestResult result) {
        if (!result.isSuccess()) {
            LoggerUtility.error(result.getThrowable().getMessage());
        }
        driver.quit();
        LoggerUtility.info("The browser is closed with success");
    }
}
