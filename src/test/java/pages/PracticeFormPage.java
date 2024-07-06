package pages;

import helperMethods.ElementsMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormPage {
    public WebDriver driver; //avem nevoie de un driver
    public ElementsMethods elementMethods;
    public PageMethods pageMethods;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        pageMethods = new PageMethods(driver);
        elementMethods = new ElementsMethods (driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id="lastName")
    WebElement lastName;

    @FindBy(id="userEmail")
    WebElement email;

    @FindBy(xpath = "//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']")
    List<WebElement> listaElementeGender;

    @FindBy(id = "userNumber")
    WebElement userNumber;

    @FindBy(id="dateOfBirthInput")
    WebElement dateOfBirthElement;

    @FindBy(className = "react-datepicker__month-select")
    WebElement dateOfBirthMonthElement;

    @FindBy(className = "react-datepicker__year-select")
    WebElement dateOfBirthYearElement;

    @FindBy(xpath = "//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and  @role='option']")
    List<WebElement> weekDayElements;

    @FindBy(id = "subjectsInput")
    WebElement subjects;

    @FindBy(xpath = "//div[@id='hobbiesWrapper']/div/div/label[@class='custom-control-label']")
    List<WebElement> listaActivitati;

    @FindBy(id = "uploadPicture")
    WebElement chooseFile;

    @FindBy(id = "currentAddress")
    WebElement userAddress;

    @FindBy(id = "state")
    WebElement stateElement;

    @FindBy(id = "react-select-3-input")
    WebElement stateinputElement;

    @FindBy(id = "city")
    WebElement cityElement;

    @FindBy(id = "react-select-4-input")
    WebElement cityinputElement;

    @FindBy(id = "submit")
    WebElement submitElement;

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement confimationSurvey;

    @FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr")
    List<WebElement> tableValues;


    public void fillEntireForm(String firstNameValue,String lastNameValue,String emailValue,String genderValue,
                               String userNumberValue, String chooseDayValue, String subjectValue,String terminatiePath,
                               String userAddressValue, String stateinputValue, String cityinputValue, List<String> activitatiValue){
        elementMethods.fillElement(firstName, firstNameValue);
        elementMethods.fillElement(lastName,lastNameValue);
        elementMethods.fillElement(email,emailValue);
//        String genderValue = "Other";// e ca si cum deja am bifat din cele 3 una, de asta mi-am facut o variabila in care sa stochez optiunea
        switch (genderValue) {
            case "Male":
                listaElementeGender.get(0).click();
                break;
            case "Female":
                listaElementeGender.get(1).click();
                break;
            case "Other":
                listaElementeGender.get(2).click();
                break;

        }
        elementMethods.fillElement(userNumber, userNumberValue);
        pageMethods.scrollPage(0,360);
        elementMethods.clickElement(dateOfBirthElement);
        elementMethods.selectByTextElement(dateOfBirthMonthElement, "January");
        elementMethods.selectByValue(dateOfBirthYearElement, "2100");

        for (Integer j=0; j<weekDayElements.size(); j++){
            if(weekDayElements.get(j).getText().equals(chooseDayValue)){
                weekDayElements.get(j).click();
                break;
            }
        }

        elementMethods.fillElement(subjects,subjectValue);
        elementMethods.pressElement(subjects, Keys.ENTER);


        for (Integer i = 0; i < listaActivitati.size(); i++) {
            String hobbie = listaActivitati.get(i).getText();
            if (activitatiValue.contains(hobbie)) {
                elementMethods.clickJSElement(listaActivitati.get(i));

            }

        }

        File file = new File("src/test/resources/" + terminatiePath);
        chooseFile.sendKeys(file.getAbsolutePath());
        elementMethods.fillElement(userAddress,userAddressValue);
        pageMethods.scrollPage(0,360);
        elementMethods.clickElement(stateElement);
        pageMethods.scrollPage(0,360);
        elementMethods.fillElement(stateinputElement,stateinputValue);
        elementMethods.pressElement(stateinputElement,Keys.ENTER);
        pageMethods.scrollPage(0,360);
        elementMethods.clickElement(cityElement);
        elementMethods.fillElement(cityinputElement, cityinputValue);
        elementMethods.pressElement(cityinputElement,Keys.ENTER);
        pageMethods.scrollPage(0,360);
        elementMethods.clickElement(submitElement);
    }

    public void validateEntireForm(String firstNameValue,String lastNameValue, String emailValue,String genderValue,
                                   String userNumberValue,String subjectValue, List<String> activitatiValue,
                                   String terminatiePath, String userAddressValue, String stateinputValue, String cityinputValue){

        Assert.assertEquals(confimationSurvey.getText(), "Thanks for submitting the form");
        Assert.assertEquals(tableValues.get(0).getText(), "Student Name" +" "+ firstNameValue+" "+lastNameValue); //validam stanga-dreapta
        Assert.assertEquals(tableValues.get(1).getText(), "Student Email" +" "+ emailValue);
        Assert.assertEquals(tableValues.get(2).getText(), "Gender" +" "+ genderValue);
        Assert.assertEquals(tableValues.get(3).getText(), "Mobile" +" "+ userNumberValue);
        Assert.assertEquals(tableValues.get(5).getText(), "Subjects" +" "+ subjectValue);
        String expectedHobbiesText= "Hobbies "+ String.join(", ", activitatiValue);
        Assert.assertEquals(tableValues.get(6).getText(), expectedHobbiesText);
        Assert.assertEquals(tableValues.get(7).getText(), "Picture" +" "+ terminatiePath);
        Assert.assertEquals(tableValues.get(8).getText(), "Address" +" "+ userAddressValue);
        Assert.assertEquals(tableValues.get(9).getText(), "State and City" +" "+ stateinputValue +" "+cityinputValue);
    }

}
