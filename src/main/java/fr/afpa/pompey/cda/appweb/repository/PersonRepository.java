package fr.afpa.pompey.cda.appweb.repository;

import fr.afpa.pompey.cda.appweb.CustomProperties;
import fr.afpa.pompey.cda.appweb.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Repository
public class PersonRepository {


    @Autowired
    private CustomProperties properties;


    public Iterable<Person> getPersons() {
        String baseURL = properties.getApiUrl();
// construction de L'url pour appel & L'APT
        String getPersonsURL = baseURL + "/persons";
        log.info(getPersonsURL);
// construction de 1a requete HTTP
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Person>> response = restTemplate.exchange(
                getPersonsURL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });

        log.debug("Get Persons call" + response.getStatusCode());

// envoi de 1a reponse.
        return response.getBody();


    }


    public Person createPerson(Person person) {
        String baseApiUrl = properties.getApiUrl();
        String createPersonsUrl = baseApiUrl + "/person";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Person> request = new HttpEntity<>(person);
        ResponseEntity<Person> response = restTemplate.exchange(
                createPersonsUrl,
                HttpMethod.POST,
                request,
                Person.class);

        log.debug("Create Person call " + response.getStatusCode());
        return response.getBody();


    }

    public Person getPerson(int id) {
        String baseApiUrl = properties.getApiUrl();
        String getPersonUrl = baseApiUrl + "/person/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Person> response = restTemplate.exchange(
                getPersonUrl,
                HttpMethod.GET,
                null,
                Person.class);

        log.debug("Get Person call " + response.getStatusCode());

        return response.getBody();

    }


    public Person updatePerson(Person person) {
        String baseApiUrl = properties.getApiUrl();
        String updatePersonUrl = baseApiUrl + "/person/" + person.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Person> request = new HttpEntity<>(person);
        ResponseEntity<Person> response = restTemplate.exchange(
                updatePersonUrl,
                HttpMethod.PUT,
                request,
                Person.class);

        log.debug("Update Person call " + response.getStatusCode());

        return response.getBody();

    }


    public void deletePerson(int id) {
        String baseApiUrl = properties.getApiUrl();
        String deletePersonUrl = baseApiUrl + "/person/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deletePersonUrl,
                HttpMethod.DELETE,
                null,
                Void.class);
        log.debug("Delete Person call " + response.getStatusCode());

    }
}
