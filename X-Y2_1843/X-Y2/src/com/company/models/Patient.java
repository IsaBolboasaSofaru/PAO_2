package com.company.models;

import java.util.Objects;

public class Patient extends BaseEntity<Long>{
    private String name;
    private Integer age;

    public Patient(Long id, String name, Integer age) {
        this.name = name;
        this.age = age;
        this.setId(id);
    }
    public Patient(){

    }
    public Patient(Long id){
        this.setId(id);
    }

    @Override
    public BaseEntity<Long> extractEntity(String[] entityArray) {
        try {
            Long id = Long.valueOf(entityArray[0]);
            String name = entityArray[1];
            Integer age = Integer.valueOf(entityArray[2]);
            return new Patient(id, name, age);
        }
        catch (Exception ignored) {
            return null;
        }
    }

    @Override
    public String toCSVString() {
        return this.getId() + "," +
                this.name + "," +
                this.age;
    }

    @Override
    public String toString() {
        return "Patient{" + super.toString() +
                " name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return this.getId().equals(patient.getId());

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
