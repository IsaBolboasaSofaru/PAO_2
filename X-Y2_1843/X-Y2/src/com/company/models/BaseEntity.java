package com.company.models;

public abstract class BaseEntity<ID> {
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id=" + id;
    }
    public abstract BaseEntity<ID> extractEntity(String[] entityArray);
    public abstract String toCSVString();
}

