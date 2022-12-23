package ru.netology;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {

        return age == -1 ? OptionalInt.empty() : OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean hasAge() {
        return getAge().isPresent();
    }

    public boolean hasAddress() {
        return getAddress() != null;
    }

    public void happyBirthday() {
        getAge().ifPresent(age -> this.age++);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(0)
                .setAddress(address);
    }

    @Override
    public String toString() {
        if (hasAge()) {
            return name + " " + surname + ", возраст " + age + ", место проживания " + address;
        }
        return name + " " + surname + ", возраст неизвестен, место проживания " + address;

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
