package contactservicepackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new InMemoryContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("001", "Mahtab", "Beplab", "1234567890", "123 Main St");
        try {
            contactService.addContact(contact);
            List<Contact> allContacts = contactService.getAllContacts();
            Assertions.assertEquals(1, allContacts.size());
            Assertions.assertEquals(contact, allContacts.get(0));
        } catch (DuplicateContactException e) {
            Assertions.fail("Should not throw DuplicateContactException");
        }
    }

    @Test
    public void testDeleteContact() throws ContactNotFoundException {
        Contact contact = new Contact("001", "Mahtab", "Beplab", "1234567890", "123 Main St");
        try {
            contactService.addContact(contact);
            contactService.deleteContact("001");
            List<Contact> allContacts = contactService.getAllContacts();
            Assertions.assertTrue(allContacts.isEmpty());
        } catch (DuplicateContactException e) {
            Assertions.fail("Should not throw DuplicateContactException");
        }
    }

    @Test
    public void testUpdateContact() throws ContactNotFoundException {
        Contact contact = new Contact("001", "Mahtab", "Beplab", "1234567890", "123 Main St");
        try {
            contactService.addContact(contact);
            contactService.updateContact("001", "Jane", "Smith", "9876543210", "456 Elm St");
            Contact updatedContact = contactService.getContactById("001");
            Assertions.assertEquals("Jane", updatedContact.getFirstName());
            Assertions.assertEquals("Smith", updatedContact.getLastName());
            Assertions.assertEquals("9876543210", updatedContact.getPhoneNumber());
            Assertions.assertEquals("456 Elm St", updatedContact.getAddress());
        } catch (DuplicateContactException e) {
            Assertions.fail("Should not throw DuplicateContactException");
        }
    }

    @Test
    public void testGetContactById() throws ContactNotFoundException {
        Contact contact = new Contact("001", "Mahtab", "Beplab", "1234567890", "123 Main St");
        try {
            contactService.addContact(contact);
            Contact foundContact = contactService.getContactById("001");
            Assertions.assertEquals(contact, foundContact);
        } catch (DuplicateContactException e) {
            Assertions.fail("Should not throw DuplicateContactException");
        }
    }
}