package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.ChangePasswordHelper;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ChangePasswordTests extends TestBase{

    @BeforeMethod
    public void startMailServer(){
        app.mailHelper().start();
    }

    @Test
    public void testChangePassword() throws MessagingException, IOException {
        UserData user = app.db().users()
                .stream().filter((g) -> (!g.getUserName().equals("administrator")))
                .collect(Collectors.toList()).iterator().next();
        HttpSession session = app.newSession();
        session.login("administrator", "root");
        app.changePassword.openUsersPage();
        app.changePassword.resetPassword();
        List<MailMessage> mailMessages = app.mailHelper().waitForMail(2, 10000);
        String confirmationLink = findConfirmationLink(mailMessages, user.getEmail());
        String newPassword = "password";
        app.registration().finish(confirmationLink, newPassword);
        app.newSession().login(user.getUserName(), newPassword);
    }

    public String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mailHelper().stop();
    }
}
