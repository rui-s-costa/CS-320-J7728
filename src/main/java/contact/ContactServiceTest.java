package contact;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)
public class ContactServiceTest {

    @Test
    @DisplayName("Test to ensure that service can add a contact.")
    @Order(1)
    void testAddContact() {
        ContactService service = new ContactService();
        service.addContact("Duke", "Realty", "5555555555", "1234 Main Street");
        service.displayContactList();
        assertNotNull(service.getContact("0"), "Contact was not added correctly.");
    }

    @Test
    @DisplayName("Test to Update First Name.")
    @Order(2)
    void testUpdateFirstName() {
        ContactService service = new ContactService();
        service.addContact("Duke", "Realty", "5555555555", "1234 Main Street");
        service.updateFirstName("King", "2");
        service.displayContactList();
        assertEquals("King", service.getContact("2").getFirstName(), "First name was not updated.");
    }

    @Test
    @DisplayName("Test to Update Last Name.")
    @Order(3)
    void testUpdateLastName() {
        ContactService service = new ContactService();
        service.addContact("Duke", "Realty", "5555555555", "1234 Main Street");
        service.updateLastName("Business", "4");
        service.displayContactList();
        assertEquals("Business", service.getContact("4").getLastName(), "Last name was not updated.");
    }

    @Test
    @DisplayName("Test to update phone number.")
    @Order(4)
    void testUpdatePhoneNumber() {
        ContactService service = new ContactService();
        service.addContact("Duke", "Realty", "5555555555", "1234 Main Street");
        service.updateNumber("1234567890", "6");
        service.displayContactList();
        assertEquals("1234567890", service.getContact("6").getNumber(), "Phone number was not updated.");
    }

    @Test
    @DisplayName("Test to update address.")
    @Order(5)
    void testUpdateAddress() {
        ContactService service = new ContactService();
        service.addContact("Duke", "Realty", "5555555555", "1234 Main Street");
        service.updateAddress("4321 Second Street", "8");
        service.displayContactList();
        assertEquals("4321 Second Street", service.getContact("8").getAddress(), "Address was not updated.");
    }

    @Test
    @DisplayName("Test to ensure that service correctly deletes contacts.")
    @Order(6)
    void testDeleteContact() {
        ContactService service = new ContactService();
        service.addContact("Duke", "Realty", "5555555555", "1234 Main Street");
        service.deleteContact("10");
        ArrayList<Contact> contactListEmpty = new ArrayList<Contact>();
        service.displayContactList();
        assertEquals(service.contactList, contactListEmpty, "The contact was not deleted.");
    }


}