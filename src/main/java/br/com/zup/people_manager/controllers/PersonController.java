package br.com.zup.people_manager.controllers;

import br.com.zup.people_manager.controllers.dtos.PersonDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
public class PersonController {

    private static List<PersonDTO> people = new ArrayList<>();

    @GetMapping
    public static ResponseEntity<?> getPeople(){
        return ResponseEntity.ok(people);
    }

    @GetMapping("/{cpf}")
    public static ResponseEntity<?> getPersonByCpf(@PathVariable String cpf){
       try {
           PersonDTO personDTO = people.stream().filter(person -> person.getCpf().equals(cpf)).findFirst().get();
           return ResponseEntity.ok(personDTO);
       }catch (Exception e){
           return ResponseEntity.status(400).body(Map.of("message", "person not found"));
       }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public static void savePerson(@RequestBody @Valid PersonDTO person){
        people.add(person);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public static void deletePerson(@RequestParam(name = "cpf") String cpf){
        people = people.stream()
                .filter(personDTO -> !personDTO.getCpf().equals(cpf))
                .collect(Collectors.toList());
    }

    @PutMapping
    public static ResponseEntity<?> updatePerson(@RequestBody PersonDTO personDTO){
        Optional<PersonDTO> personDTOOptional = people.stream().filter(person -> person.getCpf()
                .equals(personDTO.getCpf())).findFirst();

        if(personDTOOptional.isEmpty()){
            return ResponseEntity.status(400).body((Map.of("message", "person not found")));
        }

        PersonDTO personOnList = personDTOOptional.get();
        people.remove(personOnList);
        people.add(personDTO);
        return ResponseEntity.ok(personDTO);
    }


    @PatchMapping("/{cpf}")
    public static ResponseEntity<?> updatePersonPatch(@RequestBody PersonDTO personDTO, @PathVariable String cpf){
        Optional<PersonDTO> personDTOOptional = people.stream().filter(person -> person.getCpf()
                .equals(cpf)).findFirst();

        if(personDTOOptional.isEmpty()){
            return ResponseEntity.status(400).body((Map.of("message", "person not found")));
        }

        PersonDTO personOnList = personDTOOptional.get();

        if(personDTO.getName() != null){
            personOnList.setName(personDTO.getName());
        }
        if(personDTO.getLastName() != null){
            personOnList.setLastName(personDTO.getLastName());
        }
        if(personDTO.getPhoneNumber() != null){
            personOnList.setPhoneNumber(personDTO.getPhoneNumber());
        }

        return ResponseEntity.ok(personOnList);

    }
}
