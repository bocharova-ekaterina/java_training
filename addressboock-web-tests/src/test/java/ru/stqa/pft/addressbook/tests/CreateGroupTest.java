package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;


//наследует класс TestBase
public class CreateGroupTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test", "test1", "test2"));
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().goToGroupPage();
  }

}
