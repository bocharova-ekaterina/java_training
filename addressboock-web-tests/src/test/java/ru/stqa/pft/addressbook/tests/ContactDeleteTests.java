package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeleteTests extends TestBase{

    @Test
    public void testContactDelete(){
        app.getNavigationHelper().OpenIndexPage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
    }
}
