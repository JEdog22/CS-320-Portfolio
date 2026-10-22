package contactservice;

import java.util.ArrayList;

public class ContactService {

    private final ArrayList<Contact> contacts = new ArrayList<>();

    // Adds a contact if the contact ID is unique.
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        if (findContact(contact.getContactID()) != null) {
            throw new IllegalArgumentException("Contact ID already exists");
        }

        contacts.add(contact);
    }

    // Deletes a contact using the contact ID.
    public void deleteContact(String contactID) {
        Contact contact = findContact(contactID);

        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        contacts.remove(contact);
    }

    // Updates the first name using the contact ID.
    public void updateFirstName(String contactID, String firstName) {
        Contact contact = findContact(contactID);

        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        contact.setFirstName(firstName);
    }

    // Updates the last name using the contact ID.
    public void updateLastName(String contactID, String lastName) {
        Contact contact = findContact(contactID);

        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        contact.setLastName(lastName);
    }

    // Updates the phone number using the contact ID.
    public void updatePhone(String contactID, String phone) {
        Contact contact = findContact(contactID);

        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        contact.setPhone(phone);
    }

    // Updates the address using the contact ID.
    public void updateAddress(String contactID, String address) {
        Contact contact = findContact(contactID);

        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        contact.setAddress(address);
    }

    // Finds a contact using its ID.
    private Contact findContact(String contactID) {
        for (Contact contact : contacts) {
            if (contact.getContactID().equals(contactID)) {
                return contact;
            }
        }

        return null;
    }
}