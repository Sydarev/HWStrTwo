import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        //First exercise
        long underage = persons.stream()
                .filter(age-> age.getAge()<18)
                .count();
        //Second exercise
        List<String> recruit = persons.stream()
                .filter(age-> age.getAge()>=18)
                .filter(sex-> sex.getSex()==Sex.MAN)
                .map(name -> name.getName())
                .collect(Collectors.toList());
        //Third exercise
        var workers = persons.stream()
                .filter(age-> age.getAge()>=18)
                .filter(value-> (value.getSex()==Sex.MAN && value.getAge() < 65)|| (value.getSex()==Sex.WOMAN && value.getAge() < 60))
                .filter(ed -> ed.getEducation()==Education.HIGHER)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());

//        System.out.println(underage);
//        System.out.println(recruit);
//        System.out.println(workers);
    }
}