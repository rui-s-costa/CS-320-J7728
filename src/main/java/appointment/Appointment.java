package appointment;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Calendar;

public class Appointment {
    private final String appointmentID;
    private LocalDate appointmentDate;
    private String appointmentDesc;
    private static AtomicLong idGenerator = new AtomicLong();

    public Appointment(LocalDate appointmentDate, String appointmentDesc) {

        this.appointmentID = String.valueOf(idGenerator.getAndIncrement());

        if (appointmentDate == null) {
            this.appointmentDate = LocalDate.of(2025, Calendar.FEBRUARY, 5);
        } else if (appointmentDate.isBefore(LocalDate.now())) {
            System.out.println(appointmentDate);
            throw new IllegalArgumentException("Cannot make appointment before current date.");
        } else {
            this.appointmentDate = appointmentDate;
        }

        if (appointmentDesc == null || appointmentDesc.isEmpty()) {
            this.appointmentDesc = "NULL";
        } else if (appointmentDesc.length() > 50) {
            this.appointmentDesc = appointmentDesc.substring(0, 50);
        } else {
            this.appointmentDesc = appointmentDesc;
        }
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentDesc() {
        return appointmentDesc;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        if (appointmentDate == null) {
            appointmentDate = LocalDate.of(2023, Calendar.FEBRUARY, 20);
        } else if (appointmentDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Appointments cannot be scheduled prior to the current date.");
        } else {
            this.appointmentDate = appointmentDate;
        }
    }

    public void setAppointmentDesc(String appointmentDesc) {
        if (appointmentDesc == null || appointmentDesc.isEmpty()) {
            this.appointmentDesc = "NULL";
        } else if (appointmentDesc.length() > 50) {
            this.appointmentDesc = appointmentDesc.substring(0, 50);
        } else {
            this.appointmentDesc = appointmentDesc;
        }
    }
}
