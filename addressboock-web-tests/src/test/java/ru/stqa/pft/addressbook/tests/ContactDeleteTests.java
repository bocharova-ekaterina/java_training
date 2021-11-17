package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeleteTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().OpenIndexPage();
        if (app.db().contacts().size() == 0) {
            app.getContactHelper().createContact(new ContactData().withFirstname("test").
                    withLastname("test2").withMiddlename("test2").withHome_phone("259789").
                    withMobile_phone("89654561122").withEmail("test@mail.ru"));
            app.goTo().goToHomePage();
        }
    }

    @Test
    public void testContactDelete(){
        Contacts before=app.db().contacts();
        ContactData deletedContact=before.iterator().next();
        app.getContactHelper().deleteContact(deletedContact);
        app.goTo().OpenIndexPage();
        Contacts after=app.db().contacts();
        assertEquals(after.size(), before.size()-1);
        assertThat(after, equalTo(before.withOut(deletedContact)));
    }
}
