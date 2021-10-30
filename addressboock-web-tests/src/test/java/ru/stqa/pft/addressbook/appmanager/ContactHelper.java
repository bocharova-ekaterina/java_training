package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("home"), contactData.getHome_phone());
        type(By.name("mobile"), contactData.getMobile_phone());
        type(By.name("email"), contactData.getEmail());
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void addNewContactPage() {
        click(By.linkText("add new"));
    }

    public void selectContact(int index) {
        //click(By.id(id));
       // click(By.name("selected[]"));
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void updateContact() {
        click(By.name("update"));
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public boolean isThereContacts() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact) {
        addNewContactPage();
        fillContactForm(contact);
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts=new ArrayList<ContactData>();
        List<WebElement> elements=wd.findElements(By.name("entry"));
        for(WebElement element:elements){
            String firstname=element.getText();
            String lastname=element.getText();
            int id= Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact=new ContactData(id, firstname, null, lastname, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
