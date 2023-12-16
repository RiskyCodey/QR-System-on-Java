package idproject;

public class Student {
    private String firstName;
    private String lastName;
    private String idNumber;
    private String course;
    private int yearLevel;

    // Constructors
    public Student() {
    }

    public Student(String idNumber, String lastName, String firstName, int yearLevel, String course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.course = course;
        this.yearLevel = yearLevel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }
}