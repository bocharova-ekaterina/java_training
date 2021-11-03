package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().OpenIndexPage();
        if(app.getContactHelper().all().size()==0){
            app.getContactHelper().createContact(new ContactData().withFirstname("test").
                    withLastname("test2").withMiddlename("test2").withHome_phone("259789").
                    withMobile_phone("89654561122").withEmail("test@mail.ru"));
            app.goTo().goToHomePage();
        }
    }

    @Test
    public void contactModificationTest(){
        Set<ContactData> before= app.getContactHelper().all();
        ContactData modifiedContact=before.iterator().next();
        app.getContactHelper().initContactModification(modifiedContact);
        ContactData contact=new ContactData().withId(modifiedContact.getId()).withFirstname("test").
                withLastname("test2").withMiddlename("test1").withHome_phone("259789").
                withMobile_phone("89654561122").withEmail("test@mail.ru");
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().updateContact();
        app.goTo().goToHomePage();
        Set<ContactData> after= app.getContactHelper().all();
        Assert.assertEquals(after.size(), before.size());
        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals (before, after);




    }
}
