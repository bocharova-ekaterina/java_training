package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroup extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().OpenIndexPage();
        if (app.db().contacts().size() == 0) {
            app.getContactHelper().createContact(new ContactData().withFirstname("test").
                    withLastname("test2").withMiddlename("test2").withHome_phone("259789").
                    withMobile_phone("89654561122").withEmail("test@mail.ru"));
            app.goTo().goToHomePage();
        }
        app.goTo().groupPage();
        if (app.db().groups().size() == 0) {
            app.group().create(new GroupData().withName("test1").withHeader("header").withFooter("footer"));
            app.goTo().returnToGroupPage();
        }
    }

    @Test
    public void testAddContactToGroup() {
        //Contacts before= app.db().contactsInGroup(group);
        // ContactData contact= app.getContactHelper().selectContactById();
        //  app.getContactHelper().selectGroupForContact(contact, group);
        app.goTo().goToHomePage();
        //Contacts after=app.db().contactsInGroup(group);
        // assertThat(after.size(), equalTo(before.size() +1));
        //assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }


    private ContactData selectContact() {
        Contacts contacts = app.db().contacts();
        Groups groups = app.db().groups();
        for (ContactData contact : contacts) {
            if (contact.getGroups().size() < groups.size()) {
                return contact;
            }
        }
        return null;
    }
}
