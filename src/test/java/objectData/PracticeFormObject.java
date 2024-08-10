package objectData;

import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Getter
@Setter
public class PracticeFormObject extends GeneralObject{

    private String firstNameValue;
    private String lastNameValue;
    private String emailValue;
    private String genderValue;
    private String userNumberValue;
    private String chooseDayValue;
    private String subjectValue;
    private List<String> activitatiValue;
    private String terminatiePath;
    private String userAddressValue;
    private String stateinputValue;
    private String cityinputValue;

    public PracticeFormObject(String filePath) {

        fromJsonToObject(filePath);
    }

}
