package Encapsulation;

public class Person {

    private String id;
    private String name;
    private String address;
    private String contact_number;
    private double salary;
    private int age;

    public Person() {
    }

    public Person(String id, String name, String address, String contact_number, double salary, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact_number = contact_number;
        this.salary = salary;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
