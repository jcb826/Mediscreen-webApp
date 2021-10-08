package MediscreenwebApp;

import MediscreenwebApp.gateway.PatientGateway;
import MediscreenwebApp.model.Patient;
import MediscreenwebApp.service.PatientService;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@SpringBootTest
class PatientServiceTests {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientGateway patientGateway;

    @Test
    void contextLoads() {
    }

    @Test
    void createPatientTest() {
        Patient patient = new Patient();
        patient.setAddress("adress test");
        LocalDate localDate = LocalDate.of(1980, 05, 05);
        patient.setDob(localDate);
        patient.setFamily("nameTest");
        patient.setPhone("6666");
        patient.setSex("male");

        patientService.createPatient(patient);
        List<Patient> patientLists = patientService.findAllPatients();
        Patient patient2 = patientLists.stream()
                .filter(p -> p.getPhone().equals("6666"))
                .findFirst()
                .orElseGet(() -> new Patient());

        Assertions.assertEquals("6666", patient2.getPhone());
        patientService.deletePatient(patient2.getId());
    }

  @Test
    void findPatientByIdTest() {
        Patient patient = new Patient();
        patient.setAddress("adress test");
        LocalDate localDate = LocalDate.of(1980, 05, 05);
        patient.setDob(localDate);
        patient.setFamily("nameTest");
        patient.setPhone("5555");
        patient.setSex("male");
        patientService.createPatient(patient);

        Patient patient2 = patientService.findPatientById(2);

        Assertions.assertEquals("5555", patient2.getPhone());
        patientService.deletePatient(patient2.getId());
    }

    @Test
    void updatePatientTest() {
        Patient patient = new Patient();
        patient.setAddress("adress test");
        LocalDate localDate = LocalDate.of(1980, 05, 05);
        patient.setDob(localDate);
        patient.setFamily("nameTest");
        patient.setPhone("7777");
        patient.setSex("male");
        patientService.createPatient(patient);
        patient.setPhone("8888");

        patientService.updatePatient(patient, 3);
        Patient patient2 = patientService.findPatientById(4);

        Assertions.assertEquals("8888", patient2.getPhone());
        patientService.deletePatient(patient2.getId());
    }



}
