package ru.stqa.pft.mantis.appmanager;
import org.openqa.selenium.By;

public class ChangePasswordHelper extends BaseHelper{

    public ChangePasswordHelper(ApplicationManager app) {
        super(app);
    }

    public void openUsersPage() {
        wd.get("http://localhost/mantisbt-1.3.20/my_view_page.php");
        wd.findElement(By.linkText("управление")).click();
        wd.findElement(By.linkText("Управление пользователями")).click();
    }

    private void selectUserForChange(){
        wd.findElement(By.id("username")).click();
        wd.findElement(By.id("username")).clear();
        wd.findElement(By.id("username")).sendKeys("test");
        click(By.cssSelector("input[type='submit']"));
    }

    public void resetPassword() {
        selectUserForChange();
        wd.findElement(By.xpath("//input[@value='Сбросить пароль']")).click();

    }

}
