package day2;

public class POJO_PostRequest {

    String name;
    String age;
    String grade;
    String subjects[];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] course) {
        this.subjects = course;
    }
}
