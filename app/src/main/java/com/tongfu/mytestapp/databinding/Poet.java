package com.tongfu.mytestapp.databinding;

public class Poet {
    private String name ;
    private String birthPlace ;
    private int age ;
    private String dynasty;

    public Poet(String name, String birthPlace, int age, String dynasty) {
        this.name = name;
        this.birthPlace = birthPlace;
        this.age = age;
        this.dynasty = dynasty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }
}
