package contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "1234567890",
                "John",
                "Smith",
                "4175551234",
                "123 Main Street"
        );

        service.addContact(contact);

        assertDoesNotThrow(() ->
                service.updateFirstName("1234567890", "James"));
    }

    @Test
    void testCannotAddDuplicateContactID() {
        ContactService service = new ContactService();

        Contact contact1 = new Contact(
                "1234567890", "John", "Smith",
                "4175551234", "123 Main Street");

        Contact contact2 = new Contact(
                "1234567890", "Jane", "Doe",
                "4175555678", "456 Oak Street");

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () ->
                service.addContact(contact2));
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "1234567890", "John", "Smith",
                "4175551234", "123 Main Street");

        service.addContact(contact);
        service.deleteContact("1234567890");

        assertThrows(IllegalArgumentException.class, () ->
                service.deleteContact("1234567890"));
    }

    @Test
    void testUpdateFirstName() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "1234567890", "John", "Smith",
                "4175551234", "123 Main Street");

        service.addContact(contact);
        service.updateFirstName("1234567890", "James");

        assertEquals("James", contact.getFirstName());
    }

    @Test
    void testUpdateLastName() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "1234567890", "John", "Smith",
                "4175551234", "123 Main Street");

        service.addContact(contact);
        service.updateLastName("1234567890", "Jones");

        assertEquals("Jones", contact.getLastName());
    }

    @Test
    void testUpdatePhone() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "1234567890", "John", "Smith",
                "4175551234", "123 Main Street");

        service.addContact(contact);
        service.updatePhone("1234567890", "4175555678");

        assertEquals("4175555678", contact.getPhone());
    }

    @Test
    void testUpdateAddress() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "1234567890", "John", "Smith",
                "4175551234", "123 Main Street");

        service.addContact(contact);
        service.updateAddress("1234567890", "456 Oak Street");

        assertEquals("456 Oak Street", contact.getAddress());
    }

    @Test
    void testUpdateNonexistentContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () ->
                service.updateFirstName("9999999999", "James"));
    }

    @Test
    void testDeleteNonexistentContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () ->
                service.deleteContact("9999999999"));
    }

    @Test
    void testInvalidFirstNameDuringUpdate() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "1234567890", "John", "Smith",
                "4175551234", "123 Main Street");

        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () ->
                service.updateFirstName("1234567890", "Christopher"));
    }

    @Test
    void testInvalidPhoneDuringUpdate() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "1234567890", "John", "Smith",
                "4175551234", "123 Main Street");

        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () ->
                service.updatePhone("1234567890", "12345"));
    }

    @Test
    void testInvalidAddressDuringUpdate() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "1234567890", "John", "Smith",
                "4175551234", "123 Main Street");

        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () ->
                service.updateAddress(
                        "1234567890",
                        "1234567890123456789012345678901"));
    }
}
