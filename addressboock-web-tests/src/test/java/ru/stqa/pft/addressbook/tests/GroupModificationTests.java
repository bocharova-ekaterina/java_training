package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;
import java.util.regex.Matcher;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class GroupModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().groups().size()==0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1").withHeader("header").withFooter("footer"));
            app.goTo().returnToGroupPage();
            }
        }

    @Test
    public void testGroupModification(){
        Groups before=app.db().groups();
        GroupData modifiedGroup=before.iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("new group1").withHeader("header 1").withFooter("footer 1");
        app.goTo().groupPage();
        app.group().modify(group);
        app.goTo().returnToGroupPage();
        assertEquals(app.group().count(), before.size());
        Groups after= app.db().groups();
        assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));

    }
}
