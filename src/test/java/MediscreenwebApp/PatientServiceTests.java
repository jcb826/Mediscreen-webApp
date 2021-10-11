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
    public void createPatientTest() {

        Patient patient = new Patient();
        patient.setGiven("test");
        patient.setAddress("adress test");
        LocalDate localDate = LocalDate.of(1980, 05, 05);
        patient.setDob(localDate);
        patient.setFamily("nameTest");
        patient.setPhone("6666");
        patient.setSex("male");

        Patient patientCreated = patientService.createPatient(patient);

        Assertions.assertEquals("6666", patientService.findPatientById(patientCreated.getId()).getPhone());
        patientService.deletePatient(patientCreated.getId());
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
        Patient patientCreated = patientService.createPatient(patient);

        Patient patient2 = patientService.findPatientById(patientCreated.getId());

        Assertions.assertEquals("5555", patient2.getPhone());
        patientService.deletePatient(patientCreated.getId());
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
        Patient patientCreated = patientService.createPatient(patient);
        patientCreated.setPhone("8888");


        patientService.updatePatient(patientCreated, patientCreated.getId());
        Patient patientUpdated = patientService.findPatientById(patientCreated.getId());

        Assertions.assertEquals("8888", patientUpdated.getPhone());
        patientService.deletePatient(patientUpdated.getId());
    }
    @Test
    void deletePatientTest() {
        Patient patient = new Patient();
        patient.setAddress("adress test");
        LocalDate localDate = LocalDate.of(1980, 05, 05);
        patient.setDob(localDate);
        patient.setFamily("nameTest");
        patient.setPhone("7777");
        patient.setSex("male");
        patient.setPhone("8888");

        Patient patientCreated = patientService.createPatient(patient);
        patientService.deletePatient(patientCreated.getId());

        Assertions.assertEquals("8888", patientCreated.getPhone());

    }

}
