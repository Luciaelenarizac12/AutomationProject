package pages;

import helperMethods.ElementsMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablePage {
    public WebDriver driver; //avem nevoie de un driver
    public ElementsMethods elementMethods;
    public PageMethods pageMethods;

    public WebTablePage(WebDriver driver) {
        this.driver = driver;
        pageMethods = new PageMethods(driver);
        elementMethods = new ElementsMethods (driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "addNewRecordButton")
    WebElement addElement;
    @FindBy(id = "firstName")
    WebElement firstnameElement;
    @FindBy(id = "lastName")
    WebElement lastnameElement;
    @FindBy(id = "userEmail")
    WebElement emailElement;
    @FindBy(id = "age")
    WebElement ageElement;
    @FindBy(id = "salary")
    WebElement salaryElement;
    @FindBy(id = "department")
    WebElement departmentElement;
    @FindBy(id = "submit")
    WebElement submitElement;
    @FindBy(id = "edit-record-4")
    WebElement editElement;
    @FindBy(id = "salary")
    WebElement editsalaryElement;
    @FindBy(id = "department")
    WebElement editdepartmentElement;
    @FindBy(id = "submit")
    WebElement editSubmitElement;
    @FindBy(id = "delete-record-4")
    WebElement deleteElement;


    public void addEntry(String firstNameValue,String lastNameValue,String emailValue,
                         String ageValue, String salaryValue,String departmentValue){
        elementMethods.clickElement(addElement);
        elementMethods.fillElement(firstnameElement, firstNameValue);
        elementMethods.fillElement(lastnameElement,lastNameValue);
        elementMethods.fillElement(emailElement,emailValue);
        elementMethods.fillElement(ageElement,ageValue);
        elementMethods.fillElement(salaryElement,salaryValue);
        elementMethods.fillElement(departmentElement,departmentValue);
        elementMethods.clickElement(submitElement);
    }

    public void changeEntry(String editsalaryValue,String editdepartmentValue){
        elementMethods.clickElement(editElement);
        elementMethods.clearFillElement(editsalaryElement,editsalaryValue);
        elementMethods.clearFillElement(editdepartmentElement,editdepartmentValue);
        elementMethods.clickElement(editSubmitElement);
    }

    public void deleteEntry(){
        elementMethods.clickElement(deleteElement);
    }



}
