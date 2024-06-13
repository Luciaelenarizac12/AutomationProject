package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit; // Importăm TimeUnit pentru a seta așteptarea implicită

public class TextBox {
    public WebDriver driver;

    @Test
    public void metodaTextBoxTest (){
        // Deschidem browserul:
        driver = new ChromeDriver();

        // Setăm așteptarea implicită la 10 secunde:
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Accesăm un URL:
        driver.get("https://demoqa.com/text-box");

        // Maximizăm browserul:
        driver.manage().window().maximize();

        // Definim elementele după ID:
        WebElement fullNameElement=driver.findElement(By.id("userName"));
        String fullNameValue= "Lucia-Elena Rizac";
        fullNameElement.sendKeys(fullNameValue);

        WebElement emailAddressElement= driver.findElement(By.id("userEmail"));
        String emailAddressValue = "Abracadabra@yahoo.com";
        emailAddressElement.sendKeys(emailAddressValue);

        WebElement currentAddressElement=driver.findElement(By.id("currentAddress"));
        String currentAddressValue="Iasi, Str. Ion Cranga 44, ap.10, et. 4 ";
        currentAddressElement.sendKeys(currentAddressValue);

        WebElement permanentAddressElement= driver.findElement(By.id("permanentAddress"));
        String permanentAddressValue=" Noua Adresa este fnjjsnfjdsnfd..1134324@99(";
        permanentAddressElement.sendKeys(permanentAddressValue);

        WebElement submitElement = driver.findElement(By.id("submit")); // nu merge..agiuta me!
        submitElement.click();





    }
}
