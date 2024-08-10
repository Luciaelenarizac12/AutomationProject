package pages;

import loggerUtility.LoggerUtility;
import objectData.PracticeFormObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class PracticeFormPage extends  BasePage{

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id="lastName")
    private WebElement lastName;

    @FindBy(id="userEmail")
    private WebElement email;

    @FindBy(xpath = "//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']")
    private List<WebElement> listaElementeGender;

    @FindBy(id = "userNumber")
    private WebElement userNumber;

    @FindBy(id="dateOfBirthInput")
    private WebElement dateOfBirthElement;

    @FindBy(className = "react-datepicker__month-select")
    private WebElement dateOfBirthMonthElement;

    @FindBy(className = "react-datepicker__year-select")
    private WebElement dateOfBirthYearElement;

    @FindBy(xpath = "//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and  @role='option']")
    private List<WebElement> weekDayElements;

    @FindBy(id = "subjectsInput")
    private WebElement subjects;

    @FindBy(xpath = "//div[@id='hobbiesWrapper']/div/div/label[@class='custom-control-label']")
    private List<WebElement> listaActivitati;

    @FindBy(id = "uploadPicture")
    private WebElement chooseFile;

    @FindBy(id = "currentAddress")
    private WebElement userAddress;

    @FindBy(id = "state")
    private WebElement stateElement;

    @FindBy(id = "react-select-3-input")
    private WebElement stateinputElement;

    @FindBy(id = "city")
    private WebElement cityElement;

    @FindBy(id = "react-select-4-input")
    private WebElement cityinputElement;

    @FindBy(id = "submit")
    private WebElement submitElement;

    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement confimationSurvey;

    @FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr")
    private List<WebElement> tableValues;


    public void fillEntireForm(PracticeFormObject testData){
        elementMethods.fillElement(firstName, testData.getFirstNameValue());
        LoggerUtility.info("The user filled in the firstnameelement with the value: " + testData.getFirstNameValue());
        elementMethods.fillElement(lastName,testData.getLastNameValue());
        LoggerUtility.info("The user filled in the lastnameelement with the value: " + testData.getLastNameValue());
        elementMethods.fillElement(email,testData.getEmailValue());
        LoggerUtility.info("The user filled in the emailelement with the value: " + testData.getEmailValue());
//        String genderValue = "Other";// e ca si cum deja am bifat din cele 3 una, de asta mi-am facut o variabila in care sa stochez optiunea
        switch (testData.getGenderValue()) {
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
        LoggerUtility.info("The user selected the gender: " + testData.getGenderValue());

        elementMethods.fillElement(userNumber, testData.getUserNumberValue());
        LoggerUtility.info("The user filled in the usernumberelement with the value: " + testData.getUserNumberValue());
        pageMethods.scrollPage(0,360);
        LoggerUtility.info("The user scrolled down the page");
        elementMethods.clickElement(dateOfBirthElement);
        LoggerUtility.info("The user clicked to select the birthdate");
        elementMethods.selectByTextElement(dateOfBirthMonthElement, "January");
        LoggerUtility.info("The user selected the month January");
        elementMethods.selectByValue(dateOfBirthYearElement, "2100");
        LoggerUtility.info("The user selected the year 2100");

        for (Integer j=0; j<weekDayElements.size(); j++){
            if(weekDayElements.get(j).getText().equals(testData.getChooseDayValue())){
                weekDayElements.get(j).click();
                break;
            }
        }
        LoggerUtility.info("The user submitted the birthdate of: " + testData.getChooseDayValue());

        elementMethods.fillElement(subjects,testData.getSubjectValue());
        LoggerUtility.info("The user selected the subjects: " + testData.getSubjectValue());
        elementMethods.pressElement(subjects, Keys.ENTER);
        LoggerUtility.info("The user submitted their chosen subjects");


        for (Integer i = 0; i < listaActivitati.size(); i++) {
            String hobbie = listaActivitati.get(i).getText();
            if (testData.getActivitatiValue().contains(hobbie)) {
                elementMethods.clickJSElement(listaActivitati.get(i));

            }

        }
        LoggerUtility.info("The user selected the hobbies: " + testData.getActivitatiValue());

        File file = new File("src/test/resources/" + testData.getTerminatiePath());
        chooseFile.sendKeys(file.getAbsolutePath());
        LoggerUtility.info("The user uploaded a file");
        elementMethods.fillElement(userAddress,testData.getUserAddressValue());
        LoggerUtility.info("The user submitted for currentaddress element the value: " + testData.getUserAddressValue());
        pageMethods.scrollPage(0,360);
        LoggerUtility.info("The user scrolled down the page");
        elementMethods.clickElement(stateElement);
        LoggerUtility.info("The user clicked to select the State");
        pageMethods.scrollPage(0,360);
        LoggerUtility.info("The user scrolled down the page");
        elementMethods.fillElement(stateinputElement,testData.getStateinputValue());
        LoggerUtility.info("The user chose the following state: " + testData.getStateinputValue());
        elementMethods.pressElement(stateinputElement,Keys.ENTER);
        LoggerUtility.info("The user submitted their chosen state");
        pageMethods.scrollPage(0,360);
        LoggerUtility.info("The user scrolled down the page");
        elementMethods.clickElement(cityElement);
        LoggerUtility.info("The user submitted their chosen city");
        elementMethods.fillElement(cityinputElement, testData.getCityinputValue());
        LoggerUtility.info("The user chose the following city: " + testData.getCityinputValue());
        elementMethods.pressElement(cityinputElement,Keys.ENTER);
        LoggerUtility.info("The user submitted their chosen city");
        pageMethods.scrollPage(0,360);
        LoggerUtility.info("The user scrolled down the page");
        elementMethods.clickElement(submitElement);
        LoggerUtility.info("The user submitted the form");
    }

    public void validateEntireForm(PracticeFormObject testData){

        Assert.assertEquals(confimationSurvey.getText(), "Thanks for submitting the form");
        LoggerUtility.info("The user validates the presence of " + confimationSurvey.getText());
        Assert.assertEquals(tableValues.get(0).getText(), "Student Name" +" "+ testData.getFirstNameValue()+" "+testData.getLastNameValue()); //validam stanga-dreapta
        LoggerUtility.info("The user validates the presence of " + testData.getFirstNameValue() + " " + testData.getLastNameValue());
        Assert.assertEquals(tableValues.get(1).getText(), "Student Email" +" "+ testData.getEmailValue());
        LoggerUtility.info("The user validates the presence of " + testData.getEmailValue());
        Assert.assertEquals(tableValues.get(2).getText(), "Gender" +" "+ testData.getGenderValue());
        LoggerUtility.info("The user validates the presence of " + testData.getGenderValue());
        Assert.assertEquals(tableValues.get(3).getText(), "Mobile" +" "+ testData.getUserNumberValue());
        LoggerUtility.info("The user validates the presence of " + testData.getUserNumberValue());
        Assert.assertEquals(tableValues.get(5).getText(), "Subjects" +" "+ testData.getSubjectValue());
        LoggerUtility.info("The user validates the presence of " + testData.getSubjectValue());
        String expectedHobbiesText= "Hobbies "+ String.join(", ", testData.getActivitatiValue());
        Assert.assertEquals(tableValues.get(6).getText(), expectedHobbiesText);
        LoggerUtility.info("The user validates the presence of " + expectedHobbiesText);
        Assert.assertEquals(tableValues.get(7).getText(), "Picture" +" "+ testData.getTerminatiePath());
        LoggerUtility.info("The user validates the presence of " + testData.getTerminatiePath());
        Assert.assertEquals(tableValues.get(8).getText(), "Address" +" "+ testData.getUserAddressValue());
        LoggerUtility.info("The user validates the presence of " + testData.getUserAddressValue());
        Assert.assertEquals(tableValues.get(9).getText(), "State and City" +" "+ testData.getStateinputValue() +" "+testData.getCityinputValue());
        LoggerUtility.info("The user validates the presence of " + testData.getStateinputValue() + testData.getCityinputValue());
    }

}
