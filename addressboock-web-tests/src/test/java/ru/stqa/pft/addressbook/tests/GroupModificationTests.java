package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().goToGroupPage();
        if(! app.getGroupHelper().isThereGroups()){
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
            app.getNavigationHelper().returnToGroupPage();
        }
    }
    @Test
    public void testGroupModification(){
        List<GroupData> before= app.getGroupHelper().getGroupList();
        GroupData group = new GroupData(before.get(before.size()-1).getId(),"new group1", null, null);
        int index=before.size()-1;
        app.getGroupHelper().modifyGroup(group, index);
        app.getNavigationHelper().returnToGroupPage();

        List<GroupData> after= app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());
        before.remove(index);
        before.add(group);

        Comparator<? super GroupData> byId =(g1, g2)->Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals (before, after);
    }


}
