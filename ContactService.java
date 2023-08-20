package contactservicepackage;

import java.util.List;

public interface ContactService {
    void addContact(Contact contact) throws DuplicateContactException;
    void deleteContact(String contactId) throws ContactNotFoundException;
    void updateContact(String contactId, String firstName, String lastName, String phoneNumber, String address) throws ContactNotFoundException;
    List<Contact> getAllContacts();
    Contact getContactById(String contactId) throws ContactNotFoundException;
}
