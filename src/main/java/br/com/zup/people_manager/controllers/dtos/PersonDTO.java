package br.com.zup.people_manager.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public class PersonDTO {
    @NotBlank(message = "Nome não pode estar em branco")
    @NotNull(message = "Campo obrigatório")
    @Size(min = 3, message = "Nome tem que ter no minimo 3 letras")
    private String name;

    @NotNull(message = "Sobrenome é campo obrigatório")
    @NotBlank(message = "Sobrenome não pode ser branco")
    private String lastName;

    @Size(min = 11, max = 11, message = "Formato de telefone invalido")
    private String phoneNumber;

    @CPF(message = "CPF invalido")
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
