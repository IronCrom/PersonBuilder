package ru.netology;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAddress("Сидней")
                .build();
        mom.happyBirthday();
        System.out.println(mom.hasAddress() + " " + mom.hasAge());
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        son.happyBirthday();
        System.out.println("У " + mom + " есть сын, " + son);

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}