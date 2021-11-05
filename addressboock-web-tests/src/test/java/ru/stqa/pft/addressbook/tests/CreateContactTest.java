package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateContactTest extends TestBase {

  @Test
  public void CreateContactTest() throws Exception {
    Contacts before= app.getContactHelper().all();
    File photo=new File("src/test/resources/photo.jpg");
    ContactData contact =new ContactData().withFirstname("test").withLastname("test2").withPhoto(photo);
    app.getContactHelper().createContact(contact);
    app.goTo().goToHomePage();
    Contacts after=app.getContactHelper().all();
    assertThat(after.size(), equalTo(before.size() +1));
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }

}

