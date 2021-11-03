package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

public class CreateContactTest extends TestBase {

  @Test
  public void CreateContactTest() throws Exception {
    Set<ContactData> before= app.getContactHelper().all();
    ContactData contact =new ContactData().withFirstname("test").withLastname("test2");
    app.getContactHelper().createContact(contact);
    app.goTo().goToHomePage();
    Set<ContactData> after= app.getContactHelper().all();
    Assert.assertEquals(after.size(), before.size() +1);

    contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals (before, after);


  }
}

