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
    if (app.db().groups().size()==0){
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1").withHeader("header").withFooter("footer"));
      app.goTo().returnToGroupPage();
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    Groups before=app.db().groups();
    GroupData deletedGroup=before.iterator().next();
    app.goTo().groupPage();
    app.group().delete(deletedGroup);
    app.goTo().returnToGroupPage();
    assertEquals(app.group().count(), before.size()-1);
    Groups after=app.db().groups();
    assertThat(after, equalTo(before.withOut(deletedGroup)));
  }



}


