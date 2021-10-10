package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.*;

public class GroupDeleteTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.deleteSelectedGroups();
    app.returnToGroupPage();
  }

}


