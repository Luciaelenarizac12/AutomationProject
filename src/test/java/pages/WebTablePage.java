package pages;

import loggerUtility.LoggerUtility;
import objectData.WebTableObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablePage extends BasePage{
    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "addNewRecordButton")
    private WebElement addElement;
    @FindBy(id = "firstName")
    private WebElement firstnameElement;
    @FindBy(id = "lastName")
    private WebElement lastnameElement;
    @FindBy(id = "userEmail")
    private WebElement emailElement;
    @FindBy(id = "age")
    private WebElement ageElement;
    @FindBy(id = "salary")
    private WebElement salaryElement;
    @FindBy(id = "department")
    private WebElement departmentElement;
    @FindBy(id = "submit")
    private WebElement submitElement;
    @FindBy(id = "edit-record-4")
    private WebElement editElement;
    @FindBy(id = "salary")
    private WebElement editsalaryElement;
    @FindBy(id = "department")
    private WebElement editdepartmentElement;
    @FindBy(id = "submit")
    private WebElement editSubmitElement;
    @FindBy(id = "delete-record-4")
    private WebElement deleteElement;



    public void addEntry(WebTableObject testData){
        elementMethods.clickElement(addElement);
        LoggerUtility.info("The user clicked to add a new entry");
        elementMethods.fillElement(firstnameElement, testData.getFirstNameValue());
        LoggerUtility.info("The user fills firstname element with the value: " + firstnameElement);
        elementMethods.fillElement(lastnameElement,testData.getLastNameValue());
        LoggerUtility.info("The user fills in the lastname element with the value: " + lastnameElement);
        elementMethods.fillElement(emailElement,testData.getEmailValue());
        LoggerUtility.info("The user fills in the useremailelement with the value: " + emailElement);
        elementMethods.fillElement(ageElement,testData.getAgeValue());
        LoggerUtility.info("The user fills in the ageelement with the value: " + ageElement);
        elementMethods.fillElement(salaryElement,testData.getSalaryValue());
        LoggerUtility.info("The user fills in the salaryelement with the value: " + salaryElement);
        elementMethods.fillElement(departmentElement,testData.getDepartmentValue());
        LoggerUtility.info("The user fills in the departmentelement with the value: " + departmentElement);
        elementMethods.clickElement(submitElement);
        LoggerUtility.info("The user clicked to submit the form");
    }

    public void changeEntry(WebTableObject testData){
        elementMethods.clickElement(editElement);
        LoggerUtility.info("The user clicked to edit an existing entry");
        elementMethods.clearFillElement(editsalaryElement,testData.getEditsalaryValue());
        LoggerUtility.info("The user edits firstname element with the value: " + editsalaryElement);
        elementMethods.clearFillElement(editdepartmentElement,testData.getEditdepartmentValue());
        LoggerUtility.info("The user edits the salaryelement  with the value: " + editdepartmentElement);
        elementMethods.clickElement(editSubmitElement);
        LoggerUtility.info("The user clicked to submit the edited values");
    }

    public void deleteEntry(){
        elementMethods.clickElement(deleteElement);
        LoggerUtility.info("The user clicked to delete the entry");
    }



}
