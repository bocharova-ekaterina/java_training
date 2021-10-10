package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

    @Test
    public void contactModificationTest(){
        app.getNavigationHelper().OpenIndexPage();
        app.getContactHelper().selectContact("4");
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("test", "test1", "test2", "259789", "89654561122", "test@mail.ru"));
        app.getContactHelper().updateContact();
        app.getNavigationHelper().goToHomePage();

    }
}
