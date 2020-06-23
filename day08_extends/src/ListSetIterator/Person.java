package ListSetIterator;

public class Person implements Comparable {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
