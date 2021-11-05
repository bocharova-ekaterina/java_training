package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

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

    public void initContactModificationById(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
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
        contactCache=null;
    }

    public boolean isThereContacts() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact) {
        addNewContactPage();
        fillContactForm(contact);
        contactCache=null;
    }

    public void modifyContact(ContactData contact) {
        selectContactById(contact.getId());
        initContactModificationById(contact.getId());
        fillContactForm(contact);
        updateContact();
        contactCache=null;
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

    private Contacts contactCache=null;

    public Contacts all() {
        if(contactCache!=null){
            return new Contacts (contactCache);
        }
        Contacts contacts=new Contacts();
        List<WebElement> elements=wd.findElements(By.name("entry"));
        for(WebElement element:elements){
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String firstname=cells.get(2).getText();
            String lastname=cells.get(1).getText();
            String allPhones = cells.get(5).getText();
            int id= Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).
                    withAllPhones(allPhones));
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname)
                .withLastname(lastname).withHome_phone(home).withMobile_phone(mobile).withWork_phone(work).withEmail(email);
    }
}
