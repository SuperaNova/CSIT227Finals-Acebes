package Person;

public abstract class Employee extends Person {
    int months_worked;
    double salary;

    public Employee(String name, int age, int months_worked, double salary) {
        super(name, age);
        this.months_worked = months_worked;
        this.salary = salary;
    }

    public double thirteenth_month() {
        return (salary * months_worked) / 6;
    }
}
