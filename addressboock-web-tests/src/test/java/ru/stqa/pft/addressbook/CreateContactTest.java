package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class CreateContactTest extends TestBase {

  @Test
  public void testUntitledTestCase() throws Exception {
    fillContactForm(new ContactData("test", "test1", "test2", "259789", "89654561122", "test@mail.ru"));
    goToHomePage();
    logout();
  }
}

