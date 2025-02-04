package fr.afpa.pompey.cda.appweb.service;

import fr.afpa.pompey.cda.appweb.entity.Person;
import fr.afpa.pompey.cda.appweb.repository.PersonRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class PersonService {


    @Autowired
    private PersonRepository personRepository;

    public Person getPerson(int id) {
        return personRepository.getPerson(id);
    }

    public Iterable<Person> getPersons() {
        return personRepository.getPersons();
    }

    public void deletePerson(final int id) {
        personRepository.deletePerson(id);
    }

    public Person savePerson(Person person) {
        Person saved;
        //system.out.printin(person.toString());
        // Régle de gestion : Le nom de famille doit étre mis en majuscule.
        person.setLastName(person.getLastName().toUpperCase());

        if (person.getId() == null) {
            // Si Lid est nul, alors c'est un nouvel employs.
            saved = personRepository.createPerson(person);
        } else {
            saved = personRepository.updatePerson(person);

        }

        return saved;

    }
}
