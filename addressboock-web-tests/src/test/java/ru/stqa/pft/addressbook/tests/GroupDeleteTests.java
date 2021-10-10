package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeleteTests extends TestBase{

    @Test
    public void testDeleteGroup(){
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getNavigationHelper().returnToGroupPage();
    }
}
