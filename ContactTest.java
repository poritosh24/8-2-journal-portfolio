package contactservicepackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactTest {
    @Test
    public void testContactCreation() {
        Contact contact = new Contact("001", "Mahtab", "Beplab", "1234567890", "123 Main St");
        Assertions.assertEquals("001", contact.getContactId());
        Assertions.assertEquals("Mahtab", contact.getFirstName());
        Assertions.assertEquals("Beplab", contact.getLastName());
        Assertions.assertEquals("1234567890", contact.getPhoneNumber());
        Assertions.assertEquals("123 Main St", contact.getAddress());
    }

  

    @Test
    public void testInvalidContactIdLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "Mahtab", "Beplab", "1234567890", "123 Main St"));
    }

    @Test
    public void testNullContactId() {
        Assertions.assertThrows(NullPointerException.class, () -> new Contact(null, "Mahtab", "Beplab", "1234567890", "123 Main St"));
    }

    @Test
    public void testInvalidFirstNameLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("001", "MahtabMahtabMahtab", "Beplab", "1234567890", "123 Main St"));
    }

    @Test
    public void testNullFirstName() {
        Assertions.assertThrows(NullPointerException.class, () -> new Contact("001", null, "Beplab", "1234567890", "123 Main St"));
    }

    @Test
    public void testInvalidLastNameLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("001", "Mahtab", "BeplabBeplabBeplab", "1234567890", "123 Main St"));
    }

    @Test
    public void testNullLastName() {
        Assertions.assertThrows(NullPointerException.class, () -> new Contact("001", "Mahtab", null, "1234567890", "123 Main St"));
    }

    @Test
    public void testInvalidPhoneNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("001", "Mahtab", "Beplab", "12345", "123 Main St"));
    }

    @Test
    public void testNullPhoneNumber() {
        Assertions.assertThrows(NullPointerException.class, () -> new Contact("001", "Mahtab", "Beplab", null, "123 Main St"));
    }

    @Test
    public void testInvalidAddressLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("001", "Mahtab", "Beplab", "1234567890", "123 Main St, Apt 101, This is a very long address, which is not allowed."));
    }

    @Test
    public void testNullAddress() {
        Assertions.assertThrows(NullPointerException.class, () -> new Contact("001", "Mahtab", "Beplab", "1234567890", null));
    }
}
