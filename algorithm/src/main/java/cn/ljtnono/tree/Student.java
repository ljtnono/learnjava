package cn.ljtnono.tree;

public class Student {
    private String name;
    private Gender gender;
    private Integer age;
    private String sid;


    public enum Gender {
        male, female
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Student [age=" + age + ", gender=" + gender + ", name=" + name + ", sid=" + sid + "]";
    }
    
}