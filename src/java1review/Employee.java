package java1review;

import java.text.NumberFormat;

public class Employee extends Person implements Cloneable {
    private double salary;

    public Employee() {
        super();
        this.salary = 30000;

    }
    public Employee(double salary) {
        super();
        setSalary(salary);
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        if(salary < 0) {
            throw new IllegalArgumentException("Salary must be 0 or greater");
        }
        this.salary = salary;
    }

    @Override
    public String toString(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return super.getFirstName() + " earns " + currency.format(this.salary) + " per year.";
    }

    @Override
    public Employee clone() {
        try {
            return (Employee)super.clone();
        } catch(CloneNotSupportedException e) {
            throw new RuntimeException("Oops");
        }
    }
}
