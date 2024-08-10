package objectData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebTableObject extends GeneralObject{

    private String firstNameValue;
    private String lastNameValue;
    private String emailValue;
    private String ageValue;
    private String salaryValue;
    private String departmentValue;
    private String editsalaryValue;
    private String editdepartmentValue;

    public WebTableObject(String pathJson) {
        fromJsonToObject(pathJson);
    }
}
