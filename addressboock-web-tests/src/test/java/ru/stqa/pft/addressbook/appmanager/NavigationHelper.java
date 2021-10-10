package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper{

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToHomePage() {
        click(By.linkText("home page"));
    }

    public void goToGroupPage() {
      click(By.linkText("groups"));
    }

    public void returnToGroupPage() { click(By.linkText("group page")); }
}
