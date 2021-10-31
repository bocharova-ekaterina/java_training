package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactDeleteTests extends TestBase{

    @Test
    public void testContactDelete(){
        app.getNavigationHelper().OpenIndexPage();
        if(! app.getContactHelper().isThereContacts()){
            app.getContactHelper().createContact(new ContactData("test", "test1", "test2", "259789", "89654561122", "test@mail.ru"));
            app.getNavigationHelper().goToHomePage();
        }
        List<ContactData> before= app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() -1);
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().OpenIndexPage();
        List<ContactData> after= app.getContactHelper().getContactList();
        before.remove(before.size()-1);
        Assert.assertEquals(after.size(), before.size() -1);
        before.remove(before.size()-1);
        Assert.assertEquals(before, after);
    }
}
