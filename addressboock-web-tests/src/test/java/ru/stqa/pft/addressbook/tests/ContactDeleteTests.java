package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeleteTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().OpenIndexPage();
        if(! app.getContactHelper().isThereContacts()){
            app.getContactHelper().createContact(new ContactData().withFirstname("test").
                    withLastname("test1").withMiddlename("test2").withHome_phone("259789").
                    withMobile_phone("89654561122").withEmail("test@mail.ru"));
            app.goTo().goToHomePage();
        }
    }

    @Test
    public void testContactDelete(){
        List<ContactData> before= app.getContactHelper().getContactList();
        int index=before.size() -1;
        app.getContactHelper().selectContact(index);
        app.getContactHelper().deleteContact();
        app.goTo().OpenIndexPage();
        List<ContactData> after= app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), index);
        before.remove(index);
        Assert.assertEquals(before, after);
    }
}
