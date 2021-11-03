package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[id='"+id+"']")).click();
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void initContactModification(ContactData contact) {
        selectContactById(contact.getId());
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void updateContact() {
        click(By.name("update"));
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void deleteContact(ContactData contact) {
        selectContactById(contact.getId());
        deleteContact();
    }

    public boolean isThereContacts() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact) {
        addNewContactPage();
        fillContactForm(contact);
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts=new ArrayList<ContactData>();
        List<WebElement> elements=wd.findElements(By.name("entry"));
        for(WebElement element:elements){
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String firstname=cells.get(2).getText();
            String lastname=cells.get(1).getText();
            int id= Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
        }
        return contacts;
    }

    public Contacts all() {
        Contacts contacts=new Contacts();
        List<WebElement> elements=wd.findElements(By.name("entry"));
        for(WebElement element:elements){
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String firstname=cells.get(2).getText();
            String lastname=cells.get(1).getText();
            int id= Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
        }
        return contacts;
    }
}
