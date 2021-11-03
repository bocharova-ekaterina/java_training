package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class GroupDeleteTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if(app.group().all().size()==0){
      app.group().create(new GroupData().withName("test1"));
      app.goTo().returnToGroupPage();
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    Groups before= app.group().all();
    GroupData deletedGroup=before.iterator().next();
    app.group().delete(deletedGroup);
    app.goTo().returnToGroupPage();
    Groups after= app.group().all();
    assertEquals(after.size(), before.size()-1);
    assertThat(after, equalTo(before.withOut(deletedGroup)));
  }



}


