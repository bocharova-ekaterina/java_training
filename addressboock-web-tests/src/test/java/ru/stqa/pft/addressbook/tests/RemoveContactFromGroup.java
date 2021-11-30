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

public class RemoveContactFromGroup extends TestBase{

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
    public void testRemoveContactFromGroup(){
        GroupData group = selectGroup();
        Contacts groupContactsBefore = app.db().contactsInGroup(group.getId());
        ContactData contact = groupContactsBefore.iterator().next();
        Groups contactGroupsBefore = app.db().contactById(contact.getId()).getGroups();
        app.goTo().OpenIndexPage();
        app.getContactHelper().groupSelect(group.getId());
        app.getContactHelper().removeFromGroup(contact);
        Contacts groupContactsAfter = app.db().contactsInGroup(group.getId());
        Groups contactGroupsAfter = app.db().contactById(contact.getId()).getGroups();

        assertEquals(contactGroupsAfter.size(), contactGroupsBefore.size() - 1);
        assertThat(contactGroupsAfter, equalTo(contactGroupsBefore.withOut(app.db().groupById(group.getId()))));
        assertEquals(groupContactsAfter.size(), groupContactsBefore.size() - 1);
        assertThat(groupContactsAfter, equalTo(groupContactsBefore.withOut(app.db().contactById(contact.getId()))));


    }

    private GroupData selectGroup() {
        Groups groups = app.db().groups();
        for (GroupData group : groups) {
            if (app.db().contactsInGroup(group.getId()).size() > 0) {
                return group;
            }
        }
        GroupData group = groups.iterator().next();
        Contacts contacts = app.db().contacts();
        app.getContactHelper().addToGroup(contacts.iterator().next(), group);
        app.goTo().OpenIndexPage();
        return group;
    }
}
