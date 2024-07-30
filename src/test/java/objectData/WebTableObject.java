package objectData;

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

    public String getAgeValue() {
        return ageValue;
    }

    public void setAgeValue(String ageValue) {
        this.ageValue = ageValue;
    }

    public String getSalaryValue() {
        return salaryValue;
    }

    public void setSalaryValue(String salaryValue) {
        this.salaryValue = salaryValue;
    }

    public String getDepartmentValue() {
        return departmentValue;
    }

    public void setDepartmentValue(String departmentValue) {
        this.departmentValue = departmentValue;
    }

    public String getEditsalaryValue() {
        return editsalaryValue;
    }

    public void setEditsalaryValue(String editsalaryValue) {
        this.editsalaryValue = editsalaryValue;
    }

    public String getEditdepartmentValue() {
        return editdepartmentValue;
    }

    public void setEditdepartmentValue(String editdepartmentValue) {
        this.editdepartmentValue = editdepartmentValue;
    }
}
