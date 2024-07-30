package tests;

import helperMethods.PageMethods;
import org.testng.annotations.Test;
import pages.BrowserWindowPage;
import pages.HomePage;
import pages.WebTablePage;
import sharedData.SharedData;


public class WebTableTest extends SharedData {

    @Test

    public void metodaTest() {

        //Obiecte:
        PageMethods pageMethods=new PageMethods(getDriver());
        pageMethods.scrollPage(0,360);

        HomePage homePage=new HomePage(getDriver());
        homePage.navigateToElements();

        BrowserWindowPage browserWindowPage=new BrowserWindowPage(getDriver());
        browserWindowPage.navigateToWebTable();

        WebTablePage webTablePage=new WebTablePage(getDriver());
        webTablePage.addEntry("Lucia","Rizac","luciarizac@yahoo.com",
                "28","4000000000","Clinical Trials");
        webTablePage.changeEntry("90000000000000", "Testare Automata" );
        webTablePage.deleteEntry();

    }


}
