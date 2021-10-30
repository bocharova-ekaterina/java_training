package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String home_phone;
    private String mobile_phone;
    private String email;

    public ContactData(String firstname, String middlename, String lastname, String home_phone, String mobile_phone, String email){
       this.id=Integer.MAX_VALUE;
       this.firstname=firstname;
       this.lastname=lastname;
       this.middlename=middlename;
       this.home_phone=home_phone;
       this.mobile_phone = mobile_phone;
       this.email=email;
    }


    public ContactData(int id, String firstname, String middlename, String lastname, String home_phone, String mobile_phone, String email){
        this.id=id;
        this.firstname=firstname;
        this.lastname=lastname;
        this.middlename=middlename;
        this.home_phone=home_phone;
        this.mobile_phone = mobile_phone;
        this.email=email;
    }

    public String getFirstname(){return firstname;}
    public String getLastname(){return lastname;}
    public String getMiddlename(){return middlename;}
    public String getHome_phone(){return home_phone;}
    public String getMobile_phone(){return mobile_phone;}
    public String getEmail(){return email;}
    public int getId(){return id;}
    public void setId(int id) {
        this.id = id;
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
