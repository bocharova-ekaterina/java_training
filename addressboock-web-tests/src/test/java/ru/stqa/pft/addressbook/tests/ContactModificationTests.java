package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;

public class ContactModificationTests extends TestBase{

    @Test
    public void contactModificationTest(){
        app.getNavigationHelper().OpenIndexPage();
        int before=app.getContactHelper().getContactCount();
        if(! app.getContactHelper().isThereContacts()){
            app.getContactHelper().createContact(new ContactData("test", "test1", "test2", "259789", "89654561122", "test@mail.ru"));
            app.getNavigationHelper().goToHomePage();
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("test", "test1", "test2", "259789", "89654561122", "test@mail.ru"));
        app.getContactHelper().updateContact();
        app.getNavigationHelper().goToHomePage();
        int after=app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);




    }
}
