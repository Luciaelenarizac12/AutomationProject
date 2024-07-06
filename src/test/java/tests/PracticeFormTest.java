package tests;

import helperMethods.ElementsMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;
import pages.HomePage;
import pages.PracticeFormPage;


import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

        //Obiecte (Refactorizam codul:)
        HomePage homePage=new HomePage(driver);
        homePage.navigateToForms();

        FormPage formPage=new FormPage(driver);
        formPage.navigateToPracticeForm();

        String firstNameValue = "Marian";
        String lastNameValue = "Popescu";
        String emailValue = "alalal@yahoo.com";
        String genderValue = "Other";
        String userNumberValue = "0987654321";
        String chooseDayValue ="25";
        String subjectValue = "Social Studies";
        List<String> activitatiValue = Arrays.asList("Sports", "Reading", "Music");
        String terminatiePath="Exemplu.txt";
        String userAddressValue = "fsjdbfjkds jfsdfjjdsk fdjj .fjdsnjfk /dsfo";
        String stateinputValue = "NCR";
        String cityinputValue = "Delhi";



        PracticeFormPage practiceFormPage=new PracticeFormPage(driver);
        practiceFormPage.fillEntireForm(firstNameValue,lastNameValue,emailValue,genderValue,userNumberValue,chooseDayValue,subjectValue,
                terminatiePath, userAddressValue,stateinputValue,cityinputValue, activitatiValue);

        practiceFormPage.validateEntireForm(firstNameValue, lastNameValue, emailValue, genderValue, userNumberValue, subjectValue,
                activitatiValue, terminatiePath, userAddressValue, stateinputValue, cityinputValue);


    }
}