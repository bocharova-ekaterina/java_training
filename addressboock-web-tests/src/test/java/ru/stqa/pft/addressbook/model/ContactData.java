package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@Entity
@Table(name="addressbook")
public class ContactData {
    @Id
    @Column(name="id")
    private int id=Integer.MAX_VALUE;
    @Expose
    @Column(name="firstname")
    private String firstname;
    @Expose
    @Column(name="middlename")
    private String middlename;
    @Expose
    @Column(name="lastname")
    private String lastname;
    @Expose
    @Column(name="home")
    @Type(type="text")
    private String home_phone;
    @Expose
    @Column(name="mobile")
    @Type(type="text")
    private String mobile_phone;
    @Expose
    @Column(name="work")
    @Type(type="text")
    private String work_phone;
    @Transient
    private String allPhones;
    @Expose
    @Column(name="email")
    @Type(type="text")
    private String email;
    @Expose
    @Column(name="email2")
    @Type(type="text")
    private String email2;
    @Expose
    @Column(name="email3")
    @Type(type="text")
    private String email3;
    @Transient
    private String allEmails;
    @Column(name="photo")
    @Type(type="text")
    private String photoPath;
    @Column(name="address")
    @Type(type="text")
    private String address;

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
   // public File getPhoto() { return new File (photo);}
   public File getPhoto() {
       if (photoPath  == null) {
           return null;
       } else {
           File photo = new File(photoPath);
           return photo;
       }
   }
    public String getAddress() { return address; }

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

    public ContactData withPhoto(File photoPath) {
        this.photoPath = photoPath.getPath();
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
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
