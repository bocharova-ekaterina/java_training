package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;


//наследует класс TestBase
public class CreateGroupTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    int before=app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("test", "test1", "test2"));
    app.getNavigationHelper().goToGroupPage();
    int after=app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before +1);
  }

}
