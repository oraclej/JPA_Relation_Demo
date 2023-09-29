package ir.oraclej.jpa_relation_demo.model.entity;

import jakarta.persistence.*;

@Entity(name = "car")
@Table(name = "TBL_CAR")
public class Car {
    @Id
    @Column(name = "ID_CAR", columnDefinition = "NUMBER")
    private int id;

    @Basic
    @Column(name = "brand", columnDefinition = "VARCHAR2(40)")
    private String brand;

    @ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PERSON_ID", referencedColumnName = "ID_PERSON")
    private Person person;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
