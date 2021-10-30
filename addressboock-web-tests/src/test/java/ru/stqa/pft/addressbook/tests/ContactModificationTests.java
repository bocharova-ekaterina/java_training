package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase{

    @Test
    public void contactModificationTest(){
        app.getNavigationHelper().OpenIndexPage();
        if(! app.getContactHelper().isThereContacts()){
            app.getContactHelper().createContact(new ContactData("test", "test1", "test2", "259789", "89654561122", "test@mail.ru"));
            app.getNavigationHelper().goToHomePage();
        }
        List<ContactData> before= app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() -1);
        app.getContactHelper().initContactModification();
        ContactData contact=new ContactData(before.get(before.size()-1).getId(), "test", "test1", "test2", "259789", "89654561122", "test@mail.ru");
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().updateContact();
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after= app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
        before.remove(before.size()-1);
        before.add(contact);




    }
}
