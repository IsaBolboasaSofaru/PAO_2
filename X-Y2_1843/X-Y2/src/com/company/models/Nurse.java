package com.company.models;

import java.util.List;
import java.util.Objects;

public class Nurse extends MedicalStaff {
    private final String name;
    private final String qualification;

    public Nurse(Long id, String typeOfJob, String name, String qualification, String address) {
        super(id, typeOfJob, address, 100.0);
        this.name = name;
        this.qualification = qualification;
    }
    public Nurse(){
        super((long) -1, "", "", 100.0);
        this.name = "";
        this.qualification = "";
    }


    @Override
    public BaseEntity<Long> extractEntity(String[] entityArray) {
        try {
            Long id = Long.valueOf(entityArray[0]);
            String typeOfJob = entityArray[1];
            String name = entityArray[2];
            String qualification = entityArray[3];
            String address = entityArray[4];
            return new Nurse(id, typeOfJob, name, qualification, address);
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
                this.qualification + "," +
                this.address;
    }


    @Override
    public String toString() {
        return "Nurse{" + super.toString() +
                " name='" + name + '\'' +
                ", qualification='" + qualification + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Nurse nurse = (Nurse) o;
        return this.getId().equals(nurse.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, qualification);
    }

    public String getName(){
        return name;
    }

    public String getQualification() {
        return qualification;
    }
}
