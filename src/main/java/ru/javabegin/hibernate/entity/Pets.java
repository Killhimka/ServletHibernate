package ru.javabegin.hibernate.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Pets {
    private int id;
    private String animal;
    private Integer age;

    public Pets() {

    }

    public Pets(int id, String animal, Integer age) {
        this.id = id;
        this.animal = animal;
        this.age = age;
    }

    public Pets(String animal, Integer age) {
        this.animal = animal;
        this.age = age;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "animal", nullable = true, length = 30)
    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pets pets = (Pets) o;
        return id == pets.id && Objects.equals(animal, pets.animal) && Objects.equals(age, pets.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, animal, age);
    }
}
