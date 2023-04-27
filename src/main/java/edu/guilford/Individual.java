package edu.guilford;

public class Individual {
    // Four attributes for name, email, phone, and birthday
    private String name;
    private String email;
    private String phone;
    private String birthday;
    private String date;

    // Constructor that gives the default data 
    public Individual() {
        // Set the name attribute to "John Doe"
        name = "";
        // Set the email attribute to "jdoe@guilford"
        email = "";
        // Set the phone attribute to "555-555-5555"
        phone = "";
        // Set the birthday attribute to "01/01/2000"
        birthday = "";
        // Set the date 
        date = "";

    }

    // Constructor with parameters
    public Individual(String name, String email, String phone, String birthday) {
        // Set the name attribute to the name parameter
        this.name = name;
        // Set the email attribute to the email parameter
        this.email = email;
        // Set the phone attribute to the phone parameter
        this.phone = phone;
        // Set the birthday attribute to the birthday parameter
        this.birthday = birthday;
        // Set the date
        this.date = date;
    }

    // getters and setters
    // getter for name 
    public String getName() {
        // return the name attribute
        return name;
    }

    // setter for name
    public void setName(String name) {
        // set the name attribute to the name parameter
        this.name = name;
    }

    // getter for email
    public String getEmail() {
        // return the email attribute
        return email;
    }

    // setter for email
    public void setEmail(String email) {
        // set the email attribute to the email parameter
        this.email = email;
    }

    // getter for phone
    public String getPhone() {
        // return the phone attribute
        return phone;
    }

    // setter for phone
    public void setPhone(String phone) {
        // set the phone attribute to the phone parameter
        this.phone = phone;
    }

    // getter for birthday
    public String getBirthday() {
        // return the birthday attribute
        return birthday;
    }

    // setter for birthday
    public void setBirthday(String birthday) {
        // set the birthday attribute to the birthday parameter
        this.birthday = birthday;
    }

    // getter for date
    public String getDate() {
        // return the date attribute
        return date;
    }

    // setter for date
    public void setDate(String date) {
        // set the date attribute to the date parameter
        this.date = date;
    }



    // toString method
    @Override
    public String toString() {
        // return a string with the name, email, phone, and birthday attributes
        return "Name: " + name + "\nEmail: " + email + "\nPhone: " + phone + "\nBirthday: " + birthday + "\nDate: " + date;
    }
}
