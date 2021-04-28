package com.company.models;

import java.util.ArrayList;
import java.util.Objects;
import java.util.SortedSet;

public class Doctor extends MedicalStaff {
    private String name;
    private Integer yearsOfExperience;


    public Doctor(Long id, String typeOfJob,  String name, Integer yearsOfExperience, String address) {
        super(id, typeOfJob, address, 200.0);

        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
    }
    public Doctor(Long id){
        super(id, "", "", 200.0);

        this.name = "";
        this.yearsOfExperience = 0;
    }
    public Doctor(){
        super((long) -1,  "", "", 200.0);

        this.name = "";
        this.yearsOfExperience = 0;
    }

    @Override
    public BaseEntity<Long> extractEntity(String[] entityArray) {
        try {
            Long id = Long.valueOf(entityArray[0]);
            String typeOfJob = entityArray[1];
            String name = entityArray[2];
            Integer experience = Integer.valueOf(entityArray[3]);
            String address = entityArray[4];
            return new Doctor(id, typeOfJob, name, experience, address);
        }
        catch (Exception ignored) {
            return null;
        }
    }

    @Override
    public String toCSVString() {
        return this.getId() + "," +
                this.typeOfJob + "," +
                this.name + "," +
                this.yearsOfExperience + "," +
                this.address;
    }

    @Override
    public String toString() {
        return "Doctor{" + super.toString() +
                ", name='" + name + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if(!super.equals(o)) return false;

        Doctor doctor = (Doctor) o;
        return this.getId().equals(doctor.getId());

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearsOfExperience);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
