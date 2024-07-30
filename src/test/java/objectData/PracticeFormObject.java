package objectData;

import java.util.List;

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

    public String getFirstNameValue() {
        return firstNameValue;
    }

    public void setFirstNameValue(String firstNameValue) {
        this.firstNameValue = firstNameValue;
    }

    public String getLastNameValue() {
        return lastNameValue;
    }

    public void setLastNameValue(String lastNameValue) {
        this.lastNameValue = lastNameValue;
    }

    public String getEmailValue() {
        return emailValue;
    }

    public void setEmailValue(String emailValue) {
        this.emailValue = emailValue;
    }

    public String getGenderValue() {
        return genderValue;
    }

    public void setGenderValue(String genderValue) {
        this.genderValue = genderValue;
    }

    public String getUserNumberValue() {
        return userNumberValue;
    }

    public void setUserNumberValue(String userNumberValue) {
        this.userNumberValue = userNumberValue;
    }

    public String getChooseDayValue() {
        return chooseDayValue;
    }

    public void setChooseDayValue(String chooseDayValue) {
        this.chooseDayValue = chooseDayValue;
    }

    public String getSubjectValue() {
        return subjectValue;
    }

    public void setSubjectValue(String subjectValue) {
        this.subjectValue = subjectValue;
    }

    public List<String> getActivitatiValue() {
        return activitatiValue;
    }

    public void setActivitatiValue(List<String> activitatiValue) {
        this.activitatiValue = activitatiValue;
    }

    public String getTerminatiePath() {
        return terminatiePath;
    }

    public void setTerminatiePath(String terminatiePath) {
        this.terminatiePath = terminatiePath;
    }

    public String getUserAddressValue() {
        return userAddressValue;
    }

    public void setUserAddressValue(String userAddressValue) {
        this.userAddressValue = userAddressValue;
    }

    public String getStateinputValue() {
        return stateinputValue;
    }

    public void setStateinputValue(String stateinputValue) {
        this.stateinputValue = stateinputValue;
    }

    public String getCityinputValue() {
        return cityinputValue;
    }

    public void setCityinputValue(String cityinputValue) {
        this.cityinputValue = cityinputValue;
    }
}
