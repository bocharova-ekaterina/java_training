package ru.stqa.pft.addressbook.tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeleteTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    if(! app.getGroupHelper().isThereGroups()){
      app.getGroupHelper().createGroup(new GroupData("test2", null, null));
      app.getNavigationHelper().returnToGroupPage();
    }
    List<GroupData> before= app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size()-1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getNavigationHelper().returnToGroupPage();
    List<GroupData> after= app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() -1);
    before.remove(before.size()-1);
    Assert.assertEquals(before, after);
  }

}


