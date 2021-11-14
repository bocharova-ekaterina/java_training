package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactInfoTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().OpenIndexPage();
        if(app.getContactHelper().all().size()==0){
            app.getContactHelper().createContact(new ContactData().withFirstname("test").
                    withLastname("test2").withMiddlename("test2").withHome_phone("259789").
                    withMobile_phone("89654561122").withEmail("test@mail.ru").withAddress("test address"));
            app.goTo().goToHomePage();
        }
    }

    @Test
    public void contactInfoTest() {
        ContactData contact =app.getContactHelper().all().iterator().next();
        ContactData contactInfoFromEditForm=app.getContactHelper().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> !s.equals(""))
                .collect(Collectors.joining("\n"));
    }


    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHome_phone(), contact.getMobile_phone(), contact.getWork_phone()).
                stream().filter((s)->!s.equals("")).map(ContactInfoTests::cleaned).
                collect(Collectors.joining("\n"));
    }

    public static String cleaned (String phone) {
        return phone.replaceAll("\\s", "").
                replaceAll( "[-()]", "");
    }
}
