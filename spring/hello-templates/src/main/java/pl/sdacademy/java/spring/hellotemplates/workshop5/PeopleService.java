package pl.sdacademy.java.spring.hellotemplates.workshop5;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class PeopleService {
    private final Queue<Person> people = new ConcurrentLinkedQueue<>();

    public void addPerson(Person person) {
        people.add(person);
    }

    public Collection<Person> getPeople() {
        return people;
    }
}
