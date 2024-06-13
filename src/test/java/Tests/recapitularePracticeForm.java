package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.PageMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.File;
import java.util.Arrays;
import java.util.List;

public class recapitularePracticeForm {

    @Test
    public void metodaTest() {
        WebDriver driver;

        //trebuie sa deschidem un browser:
        driver = new ChromeDriver();

        //trebuie sa accesam un url:

        driver.get("https://demoqa.com/");

        //Obiecte (Refactorizam codul:)
        ElementsMethods elementsMethods=new ElementsMethods(driver);
        PageMethods pageMethods=new PageMethods(driver);

        //facem un scroll la pagina pentru vizibilitate:
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,360)", "");
        pageMethods.scrollPage(0,360);

        //vreau sa aleg din meniu/interactionez cu meniul si caut dupa xpath cu ajutorul numelui :  //h5[text()='Forms']
        WebElement formMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
//        formMenu.click();
        elementsMethods.clickElement(formMenu);

        WebElement practiceFormButton = driver.findElement(By.xpath("//span[text()='Practice Form']"));
//        practiceFormButton.click();
        elementsMethods.clickElement(practiceFormButton);

        driver.manage().window().maximize();

        WebElement firstName = driver.findElement(By.id("firstName"));
        String firstNameValue = "Lucia";
//        firstName.sendKeys(firstNameValue);
        elementsMethods.fillElement(firstName, firstNameValue);

        //lastName

        WebElement lastName = driver.findElement(By.id("lastName"));
        String lastNameValue = "Rizac";
//        lastName.sendKeys(lastNameValue);
        elementsMethods.fillElement(lastName,lastNameValue);


        //email:userEmail
        WebElement email = driver.findElement(By.id("userEmail"));
        String emailValue = "alalal@yahoo.com";
//        email.sendKeys(emailValue);
        elementsMethods.fillElement(email,emailValue);

        //avem 3 elemente si le bagam intr-o lista =deci facem o lista de elemente:
        List<WebElement> listaElementeGender = driver.findElements(By.xpath("//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']"));
        String genderValue = "Other"; // e ca si cum deja am bifat din cele 3 una, de asta mi-am facut o variabila in care sa stochez optiunea
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
        //userNumber
        WebElement userNumber = driver.findElement(By.id("userNumber"));
        String userNumberValue = "0987654321";
//        userNumber.sendKeys(userNumberValue);
        elementsMethods.fillElement(userNumber, userNumberValue);

        // dateOfBirthInput
        WebElement dateOfBirthElement = driver.findElement(By.id("dateOfBirthInput"));
//        dateOfBirthElement.click();
        elementsMethods.clickElement(dateOfBirthElement);

        //cautam un input pentru luna nasterii
        WebElement dateOfBirthMonthElement = driver.findElement(By.className("react-datepicker__month-select"));
//        Select monthSelect = new Select(dateOfBirthMonthElement);
//        monthSelect.selectByVisibleText("January");
        elementsMethods.selectByTextElement(dateOfBirthMonthElement, "January");

        //2023
        WebElement dateOfBirthYearElement = driver.findElement(By.className("react-datepicker__year-select"));
//        Select yearSelect = new Select(dateOfBirthYearElement);
//        yearSelect.selectByValue("2100");
        elementsMethods.selectByValue(dateOfBirthYearElement, "2100");

//   ->   //div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and  @role='option']
        List<WebElement> weekDayElements =driver.findElements(By.xpath("//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and  @role='option']"));
        String chooseDayValue ="25";
        for (Integer j=0; j<weekDayElements.size(); j++){
            if(weekDayElements.get(j).getText().equals(chooseDayValue)){
                weekDayElements.get(j).click();
                break;
            }
        }


        //Subjects
        WebElement subjects = driver.findElement(By.id("subjectsInput"));
        String subjectValue = "Social Studies";
//        subjects.sendKeys(subjectValue);
        elementsMethods.fillElement(subjects,subjectValue);
//        subjects.sendKeys(Keys.ENTER);
        elementsMethods.pressElement(subjects,Keys.ENTER);

        //hobbies
        //1) intai facem o lista de webelemente

        List<WebElement> listaActivitati = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']/div/div/label[@class='custom-control-label']"));
        List<String> activitatiValue = Arrays.asList("Sports", "Reading", "Music"); //am facut o lista cu selectia mea


        for (Integer i = 0; i < listaActivitati.size(); i++) {
            String hobbie = listaActivitati.get(i).getText();
            if (activitatiValue.contains(hobbie)) {
//                JavascriptExecutor jsclick = (JavascriptExecutor) driver;
//                jsclick.executeScript("arguments[0].click();", listaActivitati.get(i));

                elementsMethods.clickJSElement(listaActivitati.get(i));

            }

        }
// selectam o poza sau un fisier din calculatorul nostru - incarcam un fisier

        WebElement chooseFile = driver.findElement(By.id("uploadPicture")); //cautam un input
        String terminatiePath="Exemplu.txt";
        File file = new File("src/test/resources/" + terminatiePath);
        chooseFile.sendKeys(file.getAbsolutePath());

//        String pathFileValue="src/test/resources/Exemplu.txt";  - din pacate primesc eroare ca nu e path absolut
// am nevoie sa gasesc un path...intai mut file ul de resouces din src main in test si dau refactor
//click dreapta pe resources -> open in-> explorer -> intram in folderul de resources -> si copiem aici fisierul pe care vrem sa il selectam
//ne intoarcem in intelliJ si dam click pe resources (ne apare fisierul pe care tocmai l-am mutat) -> ii dam path ul dinamic catre fisierul respectiv
//click dreapta pe fisier-> copy path/reference ->click pe path from content root-> il adaugam in variabila noastra string ca si path

//  https://stackoverflow.com/questions/50684444/path-is-not-absolute-exception-while-uploading-file-in-selenium
//File file = new File("src/test/resources/testData/twt_Pic.jpg");
//yourElement.sendKeys(file.getAbsolutePath());

        //address : currentAddress

        WebElement userAddress = driver.findElement(By.id("currentAddress"));
        String userAddressValue = "fsjdbfjkds jfsdfjjdsk fdjj .fjdsnjfk /dsfo";
//        userAddress.sendKeys(userAddressValue);
        elementsMethods.fillElement(userAddress,userAddressValue);


        //am nevoie de un scroll pentru ca nu imi ruleaza codul : js.executeScript("window.scrollBy(0,360)", "");

//        js.executeScript("window.scrollBy(0,360)", "");
        pageMethods.scrollPage(0,360);

        //state: id -> react-select-3-input
        WebElement stateElement = driver.findElement(By.id("state"));
//        stateElement.click(); //verificam intai daca am identificat corect ID ul sau emelentul
        elementsMethods.clickElement(stateElement);


//        js.executeScript("window.scrollBy(0,360)", "");
        pageMethods.scrollPage(0,360);

        //cautam un input pentru state si ii luam Id ul -> react-select-3-input
        //mai facem un element
        WebElement stateinputElement = driver.findElement(By.id("react-select-3-input"));
        String stateinputValue = "NCR";
//        stateinputElement.sendKeys(stateinputValue);
        elementsMethods.fillElement(stateinputElement,stateinputValue);
//        stateinputElement.sendKeys(Keys.ENTER);
        elementsMethods.pressElement(stateinputElement,Keys.ENTER);


        //city id -> city
        WebElement cityElement = driver.findElement(By.id("city"));
//        cityElement.click();
        elementsMethods.clickElement(cityElement);

        //cautam un input pentru city si ii luam Id ul -> react-select-4-input
        WebElement cityinputElement = driver.findElement(By.id("react-select-4-input"));
        String cityinputValue = "Delhi";
//        cityinputElement.sendKeys(cityinputValue);
        elementsMethods.fillElement(cityinputElement, cityinputValue);
//        cityinputElement.sendKeys(Keys.ENTER);
        elementsMethods.pressElement(cityinputElement,Keys.ENTER);

        //dam un submit: submit

        WebElement submitElement = driver.findElement(By.id("submit"));
//        submitElement.click();
        elementsMethods.clickElement(submitElement);

        //Trebuie sa facem validari ale survey ului
        // validam intai textul pe care il primim dupa finalizarea survey ului:Thanks for submitting the form
        // dupa ce am dat inspect, am vazut ca are un id: example-modal-sizes-title-lg
        //definim un element
        // framework ul TestNG are o clasa specifica ASSERT pe care o foloseste in validari
        //nu putem folosi IF uri(structuri alternative) in validari deoarece ii dam BUG ului posibilitatea de scapare

        WebElement confimationSurvey = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertEquals(confimationSurvey.getText(), "Thanks for submitting the form");

// cautam un locator dupa xpath ->   //table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr
// facem o lista de webElements si sa o identificam cu findElements

        List<WebElement> tableValues =driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr"));
//parcurgem rand pe rand deoarece tabelul a fost formatat (daca avea 1000 de randuri faceam validarea doar pe dreapta)
        //validam prima linie
        Assert.assertEquals(tableValues.get(0).getText(), "Student Name" +" "+ firstNameValue+" "+lastNameValue); //validam stanga-dreapta
        //validam a 2a linie
        Assert.assertEquals(tableValues.get(1).getText(), "Student Email" +" "+ emailValue);
        //validam a 3-a linie
        Assert.assertEquals(tableValues.get(2).getText(), "Gender" +" "+ genderValue);
        //validam a 4-a linie
        Assert.assertEquals(tableValues.get(3).getText(), "Mobile" +" "+ userNumberValue);
        //validam a 6-a linie
        Assert.assertEquals(tableValues.get(5).getText(), "Subjects" +" "+ subjectValue);
        //validam a 7-a linie
        //trebuie sa folosim join deoarece ne formateaza ArrayList ul nostru

        String expectedHobbiesText= "Hobbies "+ String.join(", ", activitatiValue);
        Assert.assertEquals(tableValues.get(6).getText(), expectedHobbiesText);

        //validam a 8-a linie
        Assert.assertEquals(tableValues.get(7).getText(), "Picture" +" "+ terminatiePath);

        //validam a 9-a linie
        Assert.assertEquals(tableValues.get(8).getText(), "Address" +" "+ userAddressValue);























    }
}
