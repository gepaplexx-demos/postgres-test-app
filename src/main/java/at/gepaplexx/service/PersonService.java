package at.gepaplexx.service;

import at.gepaplexx.db.PersonRepository;
import at.gepaplexx.domain.Person;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class PersonService {

    private static final List<String> NAMES = new ArrayList<>() {{
        add("Stephen Churchill");
        add("Diana Lambert");
        add("Claire Smith");
        add("Stephen Arnold");
        add("Alexander Welch");
        add("Kevin Hart");
        add("Emma Young");
        add("John McLean");
        add("Phil Greene");
        add("Una	Arnold");
        add("Jonathan James");
        add("Oliver May");
        add("Diana Hudson");
        add("Amanda Jackson");
        add("Lily Ellison");
        add("Emma Quinn");
        add("Owen Nash");
        add("Victoria Morrison");
        add("Matt Clarkson");
        add("Stephanie Tucker");
    }};

    @Inject
    PersonRepository personRepository;

    @Transactional
    public List<Person> findAll() {
        return personRepository.listAll();
    }

    @Transactional
    public void createNew(Person person) {
        personRepository.persist(person);
    }

    @Transactional
    public void initialize() {
        NAMES.forEach(name -> personRepository.persist(new Person(name)));
    }
}
