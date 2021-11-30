package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
        ContactData contact = selectContact();
        GroupData group = selectGroup(contact);
        Groups contactGroupsBefore = app.db().contactById(contact.getId()).getGroups();
        Contacts groupContactsBefore = app.db().contactsInGroup(group.getId());
        app.goTo().OpenIndexPage();
        app.getContactHelper().addToGroup(contact, group);
        Groups contactGroupsAfter = app.db().contactById(contact.getId()).getGroups();
        Contacts groupContactsAfter = app.db().contactsInGroup(group.getId());

        assertEquals(contactGroupsAfter.size(), contactGroupsBefore.size() + 1);
        assertThat(contactGroupsAfter, equalTo(contactGroupsBefore.withAdded(app.db().groupById(group.getId()))));
        assertEquals(groupContactsAfter.size(), groupContactsBefore.size() + 1);
        assertThat(groupContactsAfter, equalTo(groupContactsBefore.withAdded(app.db().contactById(contact.getId()))));
    }

    private ContactData selectContact() {
        Contacts contacts = app.db().contacts();
        Groups groups = app.db().groups();
        for (ContactData contact : contacts) {
            if (contact.getGroups().size() < groups.size()) {
                return contact;
            }
        }
        app.getContactHelper().addNewContactPage();
        app.getContactHelper().createContact(new ContactData().withFirstname("test")
                .withLastname("test1").withAddress("test address")
                .withHome_phone("89654561122").withMobile_phone("89654561122").withWork_phone("89654561122")
                .withEmail("test1@gmail.com").withEmail2("test2@gmail.com").withEmail3("test3@gmail.com"));
        Contacts contactsWithAded = app.db().contacts();

        return app.db().contactById(contactsWithAded.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    }

    private GroupData selectGroup(ContactData contact) {
        Groups allGroups = app.db().groups();
        Groups contactGroups = app.db().contactById(contact.getId()).getGroups();
        for (GroupData group : contactGroups) {
            allGroups.remove(group);
        }
        return allGroups.iterator().next();
    }

}
