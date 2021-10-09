package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.*;

public class GroupDeleteTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.goToGroupPage();
    app.selectGroup();
    app.deleteSelectedGroups();
    app.returnToGroupPage();
    app.logout();
  }

}


