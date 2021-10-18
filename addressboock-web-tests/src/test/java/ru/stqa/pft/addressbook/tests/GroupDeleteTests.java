package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeleteTests extends TestBase{

    @Test
    public void testDeleteGroup(){
        app.getNavigationHelper().goToGroupPage();
        if(! app.getGroupHelper().isThereGroups()){
            app.getGroupHelper().createGroup(new GroupData("test2", null, null));
            app.getNavigationHelper().returnToGroupPage();
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getNavigationHelper().returnToGroupPage();
    }
}
