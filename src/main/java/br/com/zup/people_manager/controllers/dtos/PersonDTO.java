package br.com.zup.people_manager.controllers.dtos;

public class PersonDTO {
    private String name;
    private String lastName;
    private String phoneNumber;
    private String cpf;

    public PersonDTO(String name, String lastName, String phoneNumber, String cpf) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.cpf = cpf;
    }

    public PersonDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
