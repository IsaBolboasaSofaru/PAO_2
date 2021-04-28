package com.company.models;

import java.util.Objects;

public class Room extends BaseEntity<Long> {
    private final Long departmentID;
    private Boolean isAvailable;

    public Room(){
        this.departmentID = (long) -1;
    }

    public Room(Long id, Long department) {
        this.isAvailable = Boolean.TRUE;
        this.departmentID = department;
        this.setId(id);
    }
    public Room(Long id, Long department, Boolean isAvailable) {
        this.isAvailable = isAvailable;
        this.departmentID = department;
        this.setId(id);
    }


    @Override
    public BaseEntity<Long> extractEntity(String[] entityArray) {
        try {
            Long id = Long.valueOf(entityArray[0]);
            Long Depid = Long.valueOf(entityArray[1]);
            Boolean isAvailable = Boolean.valueOf(entityArray[2]);
            return new Room(id, Depid, isAvailable);
        }
        catch (Exception ignored) {
            return null;
        }
    }

    @Override
    public String toCSVString() {
        return this.getId() + "," +
                this.departmentID + "," +
                this.isAvailable;
    }

    @Override
    public String toString() {
        return "Room{" + super.toString() +
                ", departmentID=" + departmentID +
                ", isAvailable=" + isAvailable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return this.getId().equals(room.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentID, isAvailable);
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Long getDepartmentID() {
        return departmentID;
    }

}
