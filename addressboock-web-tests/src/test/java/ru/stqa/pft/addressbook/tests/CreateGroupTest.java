package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;


//наследует класс TestBase
public class CreateGroupTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goToGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test", "test1", "test2"));
    app.submitGroupCreation();
    app.goToGroupPage();
    app.logout();
  }

}
