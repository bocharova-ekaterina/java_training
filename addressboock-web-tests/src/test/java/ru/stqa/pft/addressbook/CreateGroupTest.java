package ru.stqa.pft.addressbook;
import org.testng.annotations.*;


 //наследует класс TestBase
public class CreateGroupTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    goToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test", "test1", "test2"));
    submitGroupCreation();
    goToGroupPage();
    logout();
  }

}
