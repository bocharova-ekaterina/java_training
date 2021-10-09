package ru.stqa.pft.addressbook;
import org.testng.annotations.*;

public class GroupDeleteTest extends TestBase{

  @Test
  public void testGroupDeletion() throws Exception {
    goToGroupPage();
    selectGroup();
    deleteSelectedGroups();
    returnToGroupPage();
    logout();
  }

}


