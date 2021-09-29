package com.moringaschool.blackalertandroid.ui.modules;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private String age;
    private String location;

    public User(String firstName, String lastName, String email, String password, String gender, String age, String location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.location = location;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }
}
