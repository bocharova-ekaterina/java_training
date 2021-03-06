package ru.stqa.pft.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.*;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void startMailServer(){
        app.mailHelper().start();
    }

    @Test
    public void testRegistration() throws IOException, MessagingException {
        long now=System.currentTimeMillis();
        String email =String.format("user%s@localhost.localdomain", now);
        String user =String.format("user1%s", now);
        String password="password";
        app.registration().start(user, email);
        List<MailMessage> mailMessages = app.mailHelper().waitForMail(2, 10000);
        String confirmationLink=findConirmationLink(mailMessages, email);
        app.registration().finish(confirmationLink, password);
        assertTrue(app.newSession().login(user, password));

    }

    private String findConirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mailHelper().stop();
    }

}
