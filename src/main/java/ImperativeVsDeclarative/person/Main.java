package ImperativeVsDeclarative.person;

import java.util.ArrayList;
import java.util.List;

import static ImperativeVsDeclarative.person.Gender.FEMALE;
import static ImperativeVsDeclarative.person.Gender.MALE;


public class Main {
    public static void main(String[] args) {

        // Imperative
        List<Person> people = List.of(
                new Person("Mohammad", MALE),
                new Person("Sara", FEMALE),
                new Person("Khaled", MALE),
                new Person("Lara", FEMALE),
                new Person("Alic", FEMALE)
        );


        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (person.gender().equals(FEMALE)) {
                females.add(person);
            }
        }

        System.out.println("Imperative: " + females);

        System.out.println("Declarative: ");

        // Declarative
        // functions or lambda expressions as arguments to methods

        List<Person> felmale2 = people.stream()
                .filter(p -> p.gender().equals(FEMALE))
                .toList();

        felmale2.forEach(System.out::println);


    }
}
