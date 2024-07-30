package tests;

import helperMethods.PageMethods;
import objectData.PracticeFormObject;
import objectData.WebTableObject;
import org.testng.annotations.Test;
import pages.BrowserWindowPage;
import pages.HomePage;
import pages.WebTablePage;
import sharedData.SharedData;


public class WebTableTest extends SharedData {

    @Test

    public void metodaTest() {

        WebTableObject testData=new WebTableObject("src/test/resources/testData/WebTable.json");

        //Obiecte:
        PageMethods pageMethods=new PageMethods(getDriver());
        pageMethods.scrollPage(0,360);

        HomePage homePage=new HomePage(getDriver());
        homePage.navigateToElements();

        BrowserWindowPage browserWindowPage=new BrowserWindowPage(getDriver());
        browserWindowPage.navigateToWebTable();


        WebTablePage webTablePage=new WebTablePage(getDriver());
        webTablePage.addEntry(testData);
        webTablePage.changeEntry(testData);
        webTablePage.deleteEntry();

    }


}
