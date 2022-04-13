package HM_3_1_3_introduction_to_OOP;

import java.util.ArrayList;
import java.util.List;

/*
Практическое задание
1. Создать классы Собака, Домашний Кот, Тигр, Животное (можете добавить два-три своих
класса).
2. Животные могут бежать и плыть. В качестве аргумента каждому методу передается длина
препятствия.
3. У каждого животного есть ограничения на действия (бег: кот — 200 м, собака — 500 м;
плавание: кот — не умеет плавать, собака — 10 м). Результатом выполнения действия будет
печать в консоль. Например: dogBobik.run(150); -> 'Бобик пробежал 150 м'.
4. Создать один массив с животными и заставляете их по очереди пробежать дистанцию и
проплыть.
5. * Добавить подсчет созданных Домашних Котов, Тигров, Собак, Животных.
 */
public class Task {

    public static void main(String[] args) {
        List<Animal> animalList = new ArrayList<>();

        animalList.add(new Moose("Лосяра1"));
        animalList.add(new Dog("Песель1"));
        animalList.add(new DomesticCat("Кошак1"));
        animalList.add(new Duck("Кря1"));
        animalList.add(new DomesticCat("Кошак2"));
        animalList.add(new Tiger("Тигра1"));
        animalList.add(new Tiger("Тигра2"));
        animalList.add(new Tiger("Тигра3"));
        animalList.add(new Dog("Песель2"));
        animalList.add(new DomesticCat("Кошак2"));
        animalList.add(new Moose("Лосяра2"));
        animalList.add(new Dog("Песель3"));
        animalList.add(new Dog("Песель4"));


        runAndSwim(animalList, 200);

        System.out.println("Animal.count = " + Animal.getCount());
        System.out.println("DomesticCat.domesticCatCount = " + DomesticCat.getDomesticCatCount());
        System.out.println("Moose.mooseCount = " + Moose.getMooseCount());
        System.out.println("Duck.count " + "= " + Duck.getDuckCount());
        System.out.println("Tiger.count " + "= " + Tiger.getTigerCount());
        System.out.println("Dog.count " + "= " + Dog.getDogCount());


    }

    static void runAndSwim(List<Animal> animals, double distance) {
        for (Animal animal : animals) {
            animal.run(distance);
            animal.swim(distance);
        }
    }
}
