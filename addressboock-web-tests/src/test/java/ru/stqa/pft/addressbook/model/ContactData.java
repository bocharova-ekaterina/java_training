package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id=Integer.MAX_VALUE;
    private String firstname;
    private String middlename;
    private String lastname;
    private String home_phone;
    private String mobile_phone;
    private String work_phone;
    private String allPhones;
    private String email;
    private String email2;
    private String email3;
    private String allEmails;


    public String getAllPhones() {
        return allPhones;
    }
    public String getAllEmails() {
        return allEmails;
    }
    public String getFirstname(){return firstname;}
    public String getLastname(){return lastname;}
    public String getMiddlename(){return middlename;}
    public String getHome_phone(){return home_phone;}
    public String getMobile_phone(){return mobile_phone;}
    public String getWork_phone(){return work_phone;}
    public String getEmail(){return email;}
    public String getEmail2(){return email2;}
    public String getEmail3(){return email3;}
    public int getId(){return id;}

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withHome_phone(String home_phone) {
        this.home_phone = home_phone;
        return this;
    }

    public ContactData withMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
        return this;
    }

    public ContactData withWork_phone(String work_phone) {
        this.work_phone = work_phone;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }


    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }


}
