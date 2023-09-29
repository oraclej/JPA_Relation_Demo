package ir.oraclej.jpa_relation_demo.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "person")
@Table(name = "TBL_PERSON")
public class Person {
    @Id
    @Column(name = "ID_PERSON", columnDefinition = "NUMBER")
    private int id;

    @Basic
    @Column(name = "NAME", columnDefinition = "VARCHAR2(50)")
    private String name;
    @Basic
    @Column(name = "AGE", columnDefinition = "NUMBER")
    private int age;

    @OneToMany(targetEntity = Car.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PERSON_ID", referencedColumnName = "ID_PERSON")
    private List<Car> cars;

    public Person() {
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
