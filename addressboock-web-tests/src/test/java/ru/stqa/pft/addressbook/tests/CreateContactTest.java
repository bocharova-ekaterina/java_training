package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class CreateContactTest extends TestBase {

  @Test
  public void testUntitledTestCase() throws Exception {
    app.getContactHelper().addNewContactPage();
    app.getContactHelper().fillContactForm(new ContactData("test", "test1", "test2", "259789", "89654561122", "test@mail.ru"));
    app.getNavigationHelper().goToHomePage();
  }
}

