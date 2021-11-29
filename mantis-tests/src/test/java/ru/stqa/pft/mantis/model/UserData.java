package ru.stqa.pft.mantis.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mantis_user_table")
public class UserData {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String userName;
    private String password;

    @Column(name = "email")
    private String email;


    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public UserData withId(int id) {
        this.id = id;
        return this;
    }

    public UserData withUserName( String userName) {
        this.userName=userName;
        return this;
    }

    public UserData withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserData withEmail(String email) {
        this.email=email;
        return this;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
