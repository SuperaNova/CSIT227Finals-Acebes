package Person;

public abstract class Person {
    // TODO implement Person.Person and its subclasses in other Java files
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public java.lang.String toString() {
        return "Hello, my name is " + name;
    }
}

