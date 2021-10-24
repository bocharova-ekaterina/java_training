package ru.stqa.pft.addressbook.tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeleteTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    int before=app.getGroupHelper().getGroupCount();
    if(! app.getGroupHelper().isThereGroups()){
      app.getGroupHelper().createGroup(new GroupData("test2", null, null));
      app.getNavigationHelper().returnToGroupPage();
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getNavigationHelper().returnToGroupPage();
    int after=app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before -1);
  }

}


