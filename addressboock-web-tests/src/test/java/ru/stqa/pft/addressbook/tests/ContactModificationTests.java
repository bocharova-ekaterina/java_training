package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().OpenIndexPage();
        if (app.db().contacts().size() == 0) {
                app.getContactHelper().createContact(new ContactData().withFirstname("test").
                        withLastname("test2").withMiddlename("test2").withHome_phone("259789").
                        withMobile_phone("89654561122").withEmail("test@mail.ru"));
                app.goTo().goToHomePage();
            }
        }

    @Test
    public void contactModificationTest(){
        Contacts before= app.db().contacts();
        ContactData modifiedContact=before.iterator().next();
        ContactData contact=new ContactData().withId(modifiedContact.getId()).withFirstname("test 11").
                withLastname("test2").withMiddlename("test1").withHome_phone("259789").
                withMobile_phone("89654561122").withEmail("test@mail.ru");
        app.getContactHelper().modifyContact(contact);
        app.goTo().goToHomePage();
        Contacts after= app.db().contacts();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
        verifyContactListInUI();
    }
}
