package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeleteTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if(app.group().list().size()==0){
      app.group().create(new GroupData().withName("test1"));
      app.goTo().returnToGroupPage();
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    List<GroupData> before= app.group().list();
    int index=before.size()-1;
    app.group().delete(index);
    app.goTo().returnToGroupPage();
    List<GroupData> after= app.group().list();
    Assert.assertEquals(after.size(), index);
    before.remove(index);
    Assert.assertEquals(before, after);
  }



}


