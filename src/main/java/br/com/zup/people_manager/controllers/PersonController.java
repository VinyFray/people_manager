package br.com.zup.people_manager.controllers;

import br.com.zup.people_manager.controllers.dtos.PersonDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
public class PersonController {

    private static List<PersonDTO> people = new ArrayList<>();

    @GetMapping
    public static List<PersonDTO> getPeople(){
        return people;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public static void savePerson(@RequestBody PersonDTO person){
        people.add(person);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public static void deletePerson(@RequestParam(name = "cpf") String cpf){
        people = people.stream()
                .filter(personDTO -> !personDTO.getCpf().equals(cpf))
                .collect(Collectors.toList());
    }

    // TODO MEtodo para atualizar uma person pelo cpf. PUT ou PATCH para terminar o CRUD
    // PUT o objeto inteiro deverá ser enviado no json -> não precisa de RequestParam
    // PATCH apenas os campos que serão atualizado será enviado -> RequestParam necessario para o cpf
}
