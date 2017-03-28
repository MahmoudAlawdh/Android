package com.example.mhd.donor;

/**
 * Created by PIFSS on 3/27/2017.
 */

public class Profile {

    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String birthDate;
    private String bloodType;
    private int donorId;
    private String  nationality;
    private String password;
    private String phoneNumber;



    public Profile(){

    }

    public void Login(String username, String password){

    }
    public Profile(String firstName, String lastName, String gender, String email, String birthDate, String bloodType, int donorId, String nationality, String password, String phoneNumber) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGender(gender);
        this.setEmail(email);
        this.setBirthDate(birthDate);
        this.setBloodType(bloodType);
        this.setDonorId(donorId);
        this.setNationality(nationality);
        this.setPassword(password);
        this.setPhoneNumber(phoneNumber);
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
