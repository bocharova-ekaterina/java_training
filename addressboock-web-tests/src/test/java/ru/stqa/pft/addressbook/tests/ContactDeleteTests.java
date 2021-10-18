package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeleteTests extends TestBase{

    @Test
    public void testContactDelete(){
        app.getNavigationHelper().OpenIndexPage();
        if(! app.getContactHelper().isThereContacts()){
            app.getContactHelper().createContact(new ContactData("test", "test1", "test2", "259789", "89654561122", "test@mail.ru"));
            app.getNavigationHelper().goToHomePage();
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
    }
}
