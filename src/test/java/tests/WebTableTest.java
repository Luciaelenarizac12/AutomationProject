package tests;

import helperMethods.ElementsMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class WebTableTest {

    public WebDriver driver;

    @Test

    public void metodaTest() {
        // Deschidem browserul:
        driver = new ChromeDriver();

        // Accesăm un URL:
        driver.get("https://demoqa.com");

        //Obiecte:
        PageMethods pageMethods=new PageMethods(driver);
        ElementsMethods elementsMethods=new ElementsMethods(driver);

        //facem un scroll la pagina pentru vizibilitate:
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,360)", "");
        pageMethods.scrollPage(0,360);

        //interactionam cu meniul/submeniul de pe pagina:
        WebElement elementMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
//        elementMenu.click();
        elementsMethods.clickElement(elementMenu);

        WebElement webTableSubmenu= driver.findElement((By.xpath("//span[text()='Web Tables']")));
//        webTableSubmenu.click();
        elementsMethods.clickElement(webTableSubmenu);

        // Maximizăm browserul:
        driver.manage().window().maximize();

        //Definim un element dupa ID:
        //test1 - adaugam un nou entry:
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
//        addElement.click();
        elementsMethods.clickElement(addElement);

        WebElement firstnameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Lucia";
//        firstnameElement.sendKeys(firstNameValue);
        elementsMethods.fillElement(firstnameElement, firstNameValue);

        WebElement lastnameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Rizac";
//        lastnameElement.sendKeys(lastNameValue);
        elementsMethods.fillElement(lastnameElement,lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "luciarizac@yahoo.com";
//        emailElement.sendKeys(emailValue);
        elementsMethods.fillElement(emailElement,emailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "28";
//        ageElement.sendKeys(ageValue);
        elementsMethods.fillElement(ageElement,ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "4000000000";
//        salaryElement.sendKeys(salaryValue);
        elementsMethods.fillElement(salaryElement,salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "Testare Manuala";
//        departmentElement.sendKeys(departmentValue);
        elementsMethods.fillElement(departmentElement,departmentValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
//        submitElement.click();
        elementsMethods.clickElement(submitElement);

        //test2: modific un entry existent
        WebElement editElement = driver.findElement(By.id("edit-record-4"));
//        editElement.click();
        elementsMethods.clickElement(editElement);

        WebElement editsalaryElement = driver.findElement(By.id("salary"));
        String editsalaryValue = "90000000000000";
//        editsalaryElement.clear();
//        editsalaryElement.sendKeys(editsalaryValue);
//        elementsMethods.fillElement(editsalaryElement,editsalaryValue);
        elementsMethods.clearFillElement(editsalaryElement,editsalaryValue);

        WebElement editdepartmentElement = driver.findElement(By.id("department"));
        String editdepartmentValue = "Testare Automata";
//        editdepartmentElement.clear();
        elementsMethods.clearFillElement(editdepartmentElement,editdepartmentValue);
//        editdepartmentElement.sendKeys(editdepartmentValue);
//        elementsMethods.fillElement(editdepartmentElement,editdepartmentValue);

        WebElement editSubmitElement = driver.findElement(By.id("submit"));
//        editSubmitElement.click();
        elementsMethods.clickElement(editSubmitElement);

        //test 3: sterg un entry:
        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
//        deleteElement.click();
        elementsMethods.clickElement(deleteElement);

        driver.quit();

    }


}
