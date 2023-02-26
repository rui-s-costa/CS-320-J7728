package appointment;

import java.time.LocalDate;
import java.util.ArrayList;

public class AppointmentService {

    public ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();

    public void displayAppointmentList() {
        for (int counter = 0; counter < appointmentList.size(); counter++) {
            System.out.println("\t Appointment ID: " + appointmentList.get(counter).getAppointmentID());
            System.out.println("\t Appointment Date: " + appointmentList.get(counter).getAppointmentDate());
            System.out.println("\t Appointment Description: " + appointmentList.get(counter).getAppointmentDesc());
        }
    }

    public void addAppointment(LocalDate appointmentDate, String appointmentDesc) {
        Appointment appointment = new Appointment(appointmentDate, appointmentDesc);
        appointmentList.add(appointment);
    }

    public Appointment getAppointment(String appointmentID) {
        Appointment appointment = new Appointment(null, null);
        for (int counter = 0; counter < appointmentList.size(); counter++) {
            if (appointmentList.get(counter).getAppointmentID().contentEquals(appointmentID)) {
                appointment = appointmentList.get(counter);
            }
        }
        return appointment;
    }

    public void deleteAppointment(String appointmentID) {
        for (int counter = 0; counter < appointmentList.size(); counter++) {
            if (appointmentList.get(counter).getAppointmentID().equals(appointmentID)) {
                appointmentList.remove(counter);
                break;
            }
            if (counter == appointmentList.size() - 1) {
                System.out.println("Appointment ID: " + appointmentID + " not found.");
            }
        }
    }

    public void updateAppointmentDate(LocalDate updatedDate, String appointmentID) {
        for (int counter = 0; counter < appointmentList.size(); counter++) {
            if (appointmentList.get(counter).getAppointmentID().equals(appointmentID)) {
                appointmentList.get(counter).setAppointmentDate(updatedDate);
                break;
            }
            if (counter == appointmentList.size() - 1) {
                System.out.println("Appointment ID: " + appointmentID + " not found.");
            }
        }
    }

    public void updateAppointmentDesc(String updatedString, String appointmentID) {
        for (int counter = 0; counter < appointmentList.size(); counter++) {
            if (appointmentList.get(counter).getAppointmentID().equals(appointmentID)) {
                appointmentList.get(counter).setAppointmentDesc(updatedString);
                break;
            }
            if (counter == appointmentList.size() - 1) {
                System.out.println("Appointment ID: " + appointmentID + " not found.");
            }
        }
    }
}
