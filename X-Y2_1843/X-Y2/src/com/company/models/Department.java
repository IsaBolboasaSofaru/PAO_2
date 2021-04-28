package com.company.models;

public class Department extends BaseEntity<Long> {
    private String name;

    public Department(Long id, String name) {
        this.name = name;
        this.setId(id);
    }
    public Department() {
        this.name = "";
        this.setId((long) -1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + "' " + super.toString() +
                '}';
    }

    @Override
    public BaseEntity<Long> extractEntity(String[] entityArray) {
        try {
            Long id = Long.valueOf(entityArray[0]);
            String name = entityArray[1];
            return new Department(id, name);
        }
        catch (Exception ignored) {
            return null;
        }
    }

    @Override
    public String toCSVString() {
        return this.getId() + "," +
                this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return this.getId().equals(that.getId());

    }

}
