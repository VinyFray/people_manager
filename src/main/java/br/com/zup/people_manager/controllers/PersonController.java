package br.com.zup.people_manager.controllers;

import br.com.zup.people_manager.controllers.dtos.PersonDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    // TODO MEtodo para deletar uma person pelo CPF.
    // TODO MEtodo para atualizar uma person pelo cpf.
}
