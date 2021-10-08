package ru.stqa.pft.addressbook;

public class ContactData {
    private String firstname;
    private String middlename;
    private String lastname;
    private String home_phone;
    private String mobile_phone;
    private String email;

    public ContactData(String firstname, String middlename, String lastname, String home_phone, String mobile_phone, String email){
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
}
