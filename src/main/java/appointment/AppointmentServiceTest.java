package appointment;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {

    @Test
    @DisplayName("Test to Update appointment date")
    @Order(1)
    void testUpdateAppointmentDate() {
        AppointmentService service = new AppointmentService();
        service.addAppointment(LocalDate.of(2023, 2, 10), "Description");
        service.updateAppointmentDate(LocalDate.of(2023, 2, 22), "2");
        service.displayAppointmentList();
        LocalDate date = LocalDate.from(service.getAppointment("2").getAppointmentDate());
        assertEquals(date, LocalDate.of(2023,2, 22));
    }

    @Test
    @DisplayName("Test to Update appointment description.")
    @Order(2)
    void testUpdateAppointmentDesc() {
        AppointmentService service = new AppointmentService();
        service.addAppointment(LocalDate.of(2023, 2, 20), "Description");
        service.updateAppointmentDesc("Updated Description", "4");
        service.displayAppointmentList();
        assertEquals("Updated Description", service.getAppointment("4").getAppointmentDesc(), "Appointment description was not updated.");
    }

    @Test
    @DisplayName("Test to ensure that service correctly deletes appointments.")
    @Order(3)
    void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        service.addAppointment(LocalDate.of(2023, 2, 20), "Description");
        service.deleteAppointment("6");
        ArrayList<Appointment> appointmentListEmpty = new ArrayList<Appointment>();
        service.displayAppointmentList();
        assertEquals(service.appointmentList, appointmentListEmpty, "The appointment was not deleted.");
    }

    @Test
    @DisplayName("Test to ensure that service can add an appointment.")
    @Order(4)
    void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        service.addAppointment(LocalDate.of(2023, 2, 20), "Description");
        service.displayAppointmentList();
        assertNotNull(service.getAppointment("0"), "Appointment was not added correctly.");
    }
}
