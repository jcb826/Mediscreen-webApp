package MediscreenwebApp.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data

public class Patient {

    private Integer id;
    @NotBlank(message = "please enter your family")
    private String family;
    @NotBlank(message = "please enter your given")
    private String given;
    private LocalDate dob;
    @NotBlank(message = "please enter your gender")
    private String sex;
    @NotBlank(message = "please enter your address")
    private String address;
    @NotBlank(message = "please enter your given")
    private String phone;


    public Patient() {

    }

    public Patient(Integer id, String family, String given, LocalDate dob, String sex, String address, String phone) {
        this.id = id;
        this.family = family;
        this.given = given;
        this.dob = dob;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGiven() {
        return given;
    }

    public void setGiven(String given) {
        this.given = given;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
