package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeleteTests extends TestBase{

    @Test
    public void testContactDelete(){
        app.getNavigationHelper().OpenIndexPage();
        app.getContactHelper().selectContact("6");
        app.getContactHelper().deleteContact();
    }
}
