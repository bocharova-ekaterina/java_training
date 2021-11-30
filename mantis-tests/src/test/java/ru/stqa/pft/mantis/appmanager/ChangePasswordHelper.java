package ru.stqa.pft.mantis.appmanager;
import ru.stqa.pft.mantis.model.UserData;
import static java.lang.String.format;
import static org.openqa.selenium.By.cssSelector;

public class ChangePasswordHelper extends BaseHelper{

    public ChangePasswordHelper(ApplicationManager app) {
        super(app);
    }

    public void changePassword(UserData user){
        openUsersPage();
        selectUserForChange(user.getId());
        resetPassword();
    }

    public void openUsersPage() {
        wd.get(app.getProperty("web.baseURL") + "/manage_user_page.php");
    }

    private void selectUserForChange(int id){
        click(cssSelector(format("a[href='manage_user_edit_page.php?user_id=%s']", id)));
    }

    public void resetPassword() {
        click(cssSelector("form[id='manage-user-reset-form']>fieldset>span>input[type='submit']"));
    }

}
