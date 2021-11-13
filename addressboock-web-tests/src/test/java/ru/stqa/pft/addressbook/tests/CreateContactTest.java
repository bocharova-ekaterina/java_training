package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateContactTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsFromJSON() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contact = gson.fromJson(json, new TypeToken<List<ContactData>>() {
      }.getType());
      XStream xstream = new XStream();
      return contact.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @Test(enabled = false)
  public void CreateContactTest() throws Exception {
    Contacts before= app.getContactHelper().all();
    File  photo=new File("src/test/resources/photo.jpg");
    ContactData contact =new ContactData().withFirstname("test").withLastname("test2").withPhoto(photo);
    app.getContactHelper().createContact(contact);
    app.goTo().goToHomePage();
    Contacts after=app.getContactHelper().all();
    assertThat(after.size(), equalTo(before.size() +1));
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }

  @Test(dataProvider="validContactsFromJSON")
  public void CreateContactFromFileTest(ContactData contact) throws Exception {
    Contacts before= app.getContactHelper().all();
    app.getContactHelper().createContact(contact);
    app.goTo().goToHomePage();
    Contacts after=app.getContactHelper().all();
    assertThat(after.size(), equalTo(before.size() +1));
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }

}

