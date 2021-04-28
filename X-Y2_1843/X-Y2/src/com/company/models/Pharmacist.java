package com.company.models;

import java.util.Objects;

public class Pharmacist extends MedicalStaff{
    private final String name;
    private final String jobTitle;


    public Pharmacist(Long id, String typeOfJob, String name, String jobTitle, String address) {
        super(id, typeOfJob,address, 120.0);
        this.name = name;
        this.jobTitle = jobTitle;
    }
    public Pharmacist(){
        super((long) -1, "","", 120.0);
        this.name = "";
        this.jobTitle = "";
    }


    @Override
    public BaseEntity<Long> extractEntity(String[] entityArray) {
        try {
            Long id = Long.valueOf(entityArray[0]);
            String typeOfJob = entityArray[1];
            String name = entityArray[2];
            String qualification = entityArray[3];
            String address = entityArray[4];
            return new Pharmacist(id, typeOfJob, name, qualification, address);
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
                this.jobTitle + "," +
                this.address;
    }

    @Override
    public String toString() {
        return "Pharmacist{" + super.toString() +
                " name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pharmacist that = (Pharmacist) o;
        return this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, jobTitle);
    }

    @Override
    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}
