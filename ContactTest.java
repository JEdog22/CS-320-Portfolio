package contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void testValidContact() {
        Contact contact = new Contact(
                "1234567890",
                "John",
                "Smith",
                "4175551234",
                "123 Main Street"
        );

        assertEquals("1234567890", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("4175551234", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    void testContactIDCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "John", "Smith",
                        "4175551234", "123 Main Street"));
    }

    @Test
    void testContactIDCannotBeLongerThan10Characters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345678901", "John", "Smith",
                        "4175551234", "123 Main Street"));
    }

    @Test
    void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890", null, "Smith",
                        "4175551234", "123 Main Street"));
    }

    @Test
    void testFirstNameCannotBeLongerThan10Characters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890", "Christopher",
                        "Smith", "4175551234", "123 Main Street"));
    }

    @Test
    void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890", "John", null,
                        "4175551234", "123 Main Street"));
    }

    @Test
    void testLastNameCannotBeLongerThan10Characters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890", "John",
                        "WashingtonX", "4175551234", "123 Main Street"));
    }

    @Test
    void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890", "John", "Smith",
                        null, "123 Main Street"));
    }

    @Test
    void testPhoneMustBeExactly10Digits() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890", "John", "Smith",
                        "417555123", "123 Main Street"));

        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890", "John", "Smith",
                        "41755512345", "123 Main Street"));
    }

    @Test
    void testPhoneCannotContainLetters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890", "John", "Smith",
                        "41755512AB", "123 Main Street"));
    }

    @Test
    void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890", "John", "Smith",
                        "4175551234", null));
    }

    @Test
    void testAddressCannotBeLongerThan30Characters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890", "John", "Smith",
                        "4175551234",
                        "1234567890123456789012345678901"));
    }

    @Test
    void testFirstNameCanBeUpdated() {
        Contact contact = new Contact(
                "1234567890", "John", "Smith",
                "4175551234", "123 Main Street");

        contact.setFirstName("James");

        assertEquals("James", contact.getFirstName());
    }

    @Test
    void testLastNameCanBeUpdated() {
        Contact contact = new Contact(
                "1234567890", "John", "Smith",
                "4175551234", "123 Main Street");

        contact.setLastName("Jones");

        assertEquals("Jones", contact.getLastName());
    }

    @Test
    void testPhoneCanBeUpdated() {
        Contact contact = new Contact(
                "1234567890", "John", "Smith",
                "4175551234", "123 Main Street");

        contact.setPhone("4175555678");

        assertEquals("4175555678", contact.getPhone());
    }

    @Test
    void testAddressCanBeUpdated() {
        Contact contact = new Contact(
                "1234567890", "John", "Smith",
                "4175551234", "123 Main Street");

        contact.setAddress("456 Oak Street");

        assertEquals("456 Oak Street", contact.getAddress());
    }
}