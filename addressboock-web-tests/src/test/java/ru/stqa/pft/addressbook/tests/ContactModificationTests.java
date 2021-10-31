package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().OpenIndexPage();
        if(! app.getContactHelper().isThereContacts()){
            app.getContactHelper().createContact(new ContactData().withFirstname("test").
                    withLastname("test2").withMiddlename("test2").withHome_phone("259789").
                    withMobile_phone("89654561122").withEmail("test@mail.ru"));
            app.goTo().goToHomePage();
        }
    }

    @Test
    public void contactModificationTest(){
        List<ContactData> before= app.getContactHelper().getContactList();
        int index=before.size() -1;
        app.getContactHelper().selectContact(index);
        app.getContactHelper().initContactModification();
        ContactData contact=new ContactData().withId(before.get(index).getId()).withFirstname("test").
                withLastname("test2").withMiddlename("test1").withHome_phone("259789").
                withMobile_phone("89654561122").withEmail("test@mail.ru");
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().updateContact();
        app.goTo().goToHomePage();
        List<ContactData> after= app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
        before.remove(index);
        before.add(contact);

        Comparator<? super ContactData> byId =(g1, g2)->Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals (before, after);




    }
}
