package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class CreateContactTest extends TestBase {

  @Test
  public void CreateContactTest() throws Exception {
    int before=app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactData("test", "test1", "test2", "259789", "89654561122", "test@mail.ru"));
    app.getNavigationHelper().goToHomePage();
    int after=app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before +1);


  }
}

