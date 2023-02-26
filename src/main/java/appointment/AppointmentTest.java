package appointment;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AppointmentTest {

    @Test
    @DisplayName("Appointment ID cannot have more than 10 characters")
    void testAppointmentIDWithMoreThanTenCharacters() {
        Appointment appointment = new Appointment(LocalDate.of(2023, 12, 20), "Description");
        if (appointment.getAppointmentID().length() > 10) {
            fail("Appointment ID has more than 10 characters.");
        }
    }

    @Test
    @DisplayName("Task Description cannot have more than 50 characters")
    void testAppointmentDescWithMoreThanFiftyCharacters() {
        Appointment appointment = new Appointment(LocalDate.of(2023, 12, 20),
                "This sentence is more than 50 characters, it needs to be shorter.");
        if (appointment.getAppointmentDesc().length() > 50) {
            fail("Appointment Description has more than 50 characters.");
        }
    }

    @Test
    @DisplayName("Appointment Date cannot be before current date")
    void testAppointmentDateBeforeCurrent() {
        Appointment appointment = new Appointment(LocalDate.of(2023, 12, 25), "Description");
//        System.out.println(appointment.getAppointmentDate());
        if (appointment.getAppointmentDate().isBefore(LocalDate.now())) {
            fail("Appointment Date is before current date.");
        }
    }

    @Test
    @DisplayName("Task Date shall not be null")
    void testAppointmentDateNotNull() {
        Appointment appointment = new Appointment(null, "Description");
        assertNotNull(appointment.getAppointmentDate(), "Appointment Date was empty.");
    }

    @Test
    @DisplayName("Task Description shall not be null")
    void testAppointmentDescNotNull() {
        Appointment task = new Appointment(LocalDate.of(2023, 12, 20), null);
        assertNotNull(task.getAppointmentDesc(), "Appointment Description was empty.");
    }
}