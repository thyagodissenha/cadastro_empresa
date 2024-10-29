package br.com.dissenha.thyago.register.person;

import br.com.dissenha.thyago.register.infra.exception.ValidationException;
import br.com.dissenha.thyago.register.util.Util;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public DataDetailPerson findPerson(UUID id) {
        return personRepository.findById(id)
                .map(DataDetailPerson::new)
                .orElseThrow(() -> new ValidationException("Person not found!"));
    }

    public Page<DataListPerson> listPerson(Pageable pageable) {
        return personRepository.findAll(pageable).map(DataListPerson::new);
    }

    @Transactional
    public DataDetailPerson addPerson(DataAddPerson dataAddPerson) {
        Person person = new Person(dataAddPerson);
        return new DataDetailPerson(personRepository.save(person));
    }

    @Transactional
    public DataDetailPerson updatePerson(DataUpdatePerson dataUpdatePerson) {
        if(!personRepository.existsById(dataUpdatePerson.id()))
            throw new ValidationException("Person not found!");
        Person person = personRepository.getReferenceById(dataUpdatePerson.id());
        Util.copyPropertiesNotNull(dataUpdatePerson, person);
        return new DataDetailPerson(person);
    }
}
