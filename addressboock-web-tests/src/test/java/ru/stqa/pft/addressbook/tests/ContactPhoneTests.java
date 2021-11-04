package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests  extends TestBase {

    @Test
    public void contactPhoneTest() {
        ContactData contact =app.getContactHelper().all().iterator().next();
        ContactData contactInfoFromEditForm=app.getContactHelper().infoFromEditForm(contact);
        assertThat(contact.getHome_phone(), equalTo(cleaned(contactInfoFromEditForm.getHome_phone())));
        assertThat(contact.getMobile_phone(), equalTo(cleaned(contactInfoFromEditForm.getMobile_phone())));
        assertThat(contact.getWork_phone(), equalTo(cleaned(contactInfoFromEditForm.getWork_phone())));
    }

    public String cleaned (String phone)
    {
        return phone.replaceAll("\\s", "").replaceAll( "[-, ()]", "");
    }
}
