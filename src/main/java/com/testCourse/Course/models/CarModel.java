package com.testCourse.Course.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cars")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)

    private long id;

    private String brand;

    private String model;

    private Integer HP;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getHP() {
        return this.HP;
    }

    public void setHP(Integer HP) {
        this.HP = HP;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", brand='" + getBrand() + "'" + ", model='" + getModel() + "'"
                + ", HP='" + getHP() + "'" + "}";
    }

}
