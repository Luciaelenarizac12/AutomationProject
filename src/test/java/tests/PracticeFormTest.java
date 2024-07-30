package tests;

import helperMethods.ElementsMethods;
import helperMethods.PageMethods;
import objectData.PracticeFormObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;
import pages.HomePage;
import pages.PracticeFormPage;
import sharedData.SharedData;


import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {

        //Pregatim datele de test specifice

        PracticeFormObject testData=new PracticeFormObject("src/test/resources/testData/PracticeFormData.json");

        //Obiecte (Refactorizam codul:)
        HomePage homePage=new HomePage(getDriver());
        homePage.navigateToForms();

        FormPage formPage=new FormPage(getDriver());
        formPage.navigateToPracticeForm();

        PracticeFormPage practiceFormPage=new PracticeFormPage(getDriver());
        practiceFormPage.fillEntireForm(testData);

        practiceFormPage.validateEntireForm(testData);


    }
}
