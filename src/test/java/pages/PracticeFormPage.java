package pages;

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
        elementMethods.fillElement(lastName,testData.getLastNameValue());
        elementMethods.fillElement(email,testData.getEmailValue());
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
        elementMethods.fillElement(userNumber, testData.getUserNumberValue());
        pageMethods.scrollPage(0,360);
        elementMethods.clickElement(dateOfBirthElement);
        elementMethods.selectByTextElement(dateOfBirthMonthElement, "January");
        elementMethods.selectByValue(dateOfBirthYearElement, "2100");

        for (Integer j=0; j<weekDayElements.size(); j++){
            if(weekDayElements.get(j).getText().equals(testData.getChooseDayValue())){
                weekDayElements.get(j).click();
                break;
            }
        }

        elementMethods.fillElement(subjects,testData.getSubjectValue());
        elementMethods.pressElement(subjects, Keys.ENTER);


        for (Integer i = 0; i < listaActivitati.size(); i++) {
            String hobbie = listaActivitati.get(i).getText();
            if (testData.getActivitatiValue().contains(hobbie)) {
                elementMethods.clickJSElement(listaActivitati.get(i));

            }

        }

        File file = new File("src/test/resources/" + testData.getTerminatiePath());
        chooseFile.sendKeys(file.getAbsolutePath());
        elementMethods.fillElement(userAddress,testData.getUserAddressValue());
        pageMethods.scrollPage(0,360);
        elementMethods.clickElement(stateElement);
        pageMethods.scrollPage(0,360);
        elementMethods.fillElement(stateinputElement,testData.getStateinputValue());
        elementMethods.pressElement(stateinputElement,Keys.ENTER);
        pageMethods.scrollPage(0,360);
        elementMethods.clickElement(cityElement);
        elementMethods.fillElement(cityinputElement, testData.getCityinputValue());
        elementMethods.pressElement(cityinputElement,Keys.ENTER);
        pageMethods.scrollPage(0,360);
        elementMethods.clickElement(submitElement);
    }

    public void validateEntireForm(PracticeFormObject testData){

        Assert.assertEquals(confimationSurvey.getText(), "Thanks for submitting the form");
        Assert.assertEquals(tableValues.get(0).getText(), "Student Name" +" "+ testData.getFirstNameValue()+" "+testData.getLastNameValue()); //validam stanga-dreapta
        Assert.assertEquals(tableValues.get(1).getText(), "Student Email" +" "+ testData.getEmailValue());
        Assert.assertEquals(tableValues.get(2).getText(), "Gender" +" "+ testData.getGenderValue());
        Assert.assertEquals(tableValues.get(3).getText(), "Mobile" +" "+ testData.getUserNumberValue());
        Assert.assertEquals(tableValues.get(5).getText(), "Subjects" +" "+ testData.getSubjectValue());
        String expectedHobbiesText= "Hobbies "+ String.join(", ", testData.getActivitatiValue());
        Assert.assertEquals(tableValues.get(6).getText(), expectedHobbiesText);
        Assert.assertEquals(tableValues.get(7).getText(), "Picture" +" "+ testData.getTerminatiePath());
        Assert.assertEquals(tableValues.get(8).getText(), "Address" +" "+ testData.getUserAddressValue());
        Assert.assertEquals(tableValues.get(9).getText(), "State and City" +" "+ testData.getStateinputValue() +" "+testData.getCityinputValue());
    }

}
