package MediscreenwebApp;

import MediscreenwebApp.gateway.PatientGateway;
import MediscreenwebApp.model.Patient;
import MediscreenwebApp.service.PatientService;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class PatientTests {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientGateway patientGateway;

    @Test
    void contextLoads() {
    }

    @Test
    void patientServiceTest() {
        // Save

        Patient patient = new Patient();
        patient.setId(100);
        patient.setAddress("adress test");
      //  LocalDate localDate = LocalDate.of(1980, 05, 05);
      //  patient.setDob(localDate);
        patient.setFamily("nameTest");
        patient.setPhone("6666");
        patient.setSex("male");




   patientService.createPatient(patient);
  Patient patient1= patientService.findPatientById(100);
        Assertions.assertEquals("6666",patient1.getPhone());


    }

}
