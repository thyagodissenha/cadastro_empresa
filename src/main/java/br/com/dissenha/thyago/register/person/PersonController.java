package br.com.dissenha.thyago.register.person;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataDetailPerson> findPerson(@PathVariable UUID id) {
        return ResponseEntity.ok(personService.findPerson(id));
    }

    @GetMapping
    public ResponseEntity<Page<DataListPerson>> listPerson(
            @PageableDefault(size = 20) Pageable pageable
    ){
        return ResponseEntity.ok(personService.listPerson(pageable));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DataDetailPerson> addPerson(@RequestBody @Valid DataAddPerson data, UriComponentsBuilder uriBuilder) {
        DataDetailPerson dataDetailPerson = personService.addPerson(data);
        URI uri = uriBuilder.path("pessoa/{id}").buildAndExpand(dataDetailPerson.id()).toUri();
        return ResponseEntity.created(uri).body(dataDetailPerson);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataDetailPerson> updatePerson(@RequestBody @Valid DataUpdatePerson data){
        return ResponseEntity.ok(personService.updatePerson(data));
    }
}
