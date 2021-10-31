package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class CreateContactTest extends TestBase {

  @Test
  public void CreateContactTest() throws Exception {
    List<ContactData> before= app.getContactHelper().getContactList();
    ContactData contact =new ContactData().withFirstname("test").withLastname("test2");
    app.getContactHelper().createContact(contact);
    app.goTo().goToHomePage();
    List<ContactData> after= app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() +1);

    contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId =(g1, g2)->Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals (before, after);


  }
}

