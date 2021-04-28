package com.company.models;

import java.util.Objects;

public abstract class MedicalStaff extends BaseEntity<Long> {
    protected String typeOfJob;
    protected String address;
    protected Double salary;

    public MedicalStaff(Long id, String typeOfJob, String address, Double salary) {

        this.typeOfJob = typeOfJob;
        this.address = address;
        this.salary = salary;
        this.setId(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalStaff that = (MedicalStaff) o;
        return this.getId().equals(that.getId());

    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfJob, address, salary);
    }

    @Override
    public String toString() {
        return "MedicalStaff{" + super.toString() +
                ", typeOfJob='" + typeOfJob + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }

    public abstract String getName();

    public String getTypeOfJob() {
        return typeOfJob;
    }

    public void setTypeOfJob(String typeOfJob) {
        this.typeOfJob = typeOfJob;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}