package com.company.models;

import java.util.Objects;

public class Consult extends BaseEntity<Long> {

    private Long doctorID;
    private Long roomID;
    private Long patientID;
    private String notes;

    public Consult(Long id, Long doctor, Long room, Long patient, String notes) {
        this.doctorID = doctor;
        this.roomID = room;
        this.patientID = patient;
        this.notes = notes;
        this.setId(id);
    }


    public Consult(long id) {
        this.doctorID = (long) -1;
        this.roomID = (long) -1;
        this.patientID = (long) -1;
        this.notes = "";
        this.setId((long) -1);
    }

    public Long getDoctorID() {
        return doctorID;
    }

    public Long getPatientID() {
        return patientID;
    }

    public Long getRoomID() {
        return roomID;
    }

    public void setDoctorID(Long doctorID) {
        this.doctorID = doctorID;
    }

    public void setPatientID(Long patientID) {
        this.patientID = patientID;
    }

    public void setRoomID(Long roomID) {
        this.roomID = roomID;
    }

    @Override
    public String toString() {
        return "Consult{" +
                "doctor=" + doctorID +
                ", room=" + roomID +
                ", patient=" + patientID +
                ", notes='" + notes + "' " + super.toString() +
                '}';
    }

    @Override
    public BaseEntity<Long> extractEntity(String[] entityArray) {
        try {
            Long id = Long.valueOf(entityArray[0]);
            Long doctor = Long.valueOf(entityArray[1]);
            Long room = Long.valueOf(entityArray[2]);
            Long patient = Long.valueOf(entityArray[3]);
            String notes = entityArray[4];
            return new Consult(id, doctor, patient, room, notes);
        }
        catch (Exception ignored) {
            return null;
        }
    }

    @Override
    public String toCSVString() {
        return this.getId() + "," +
                this.doctorID + "," +
                this.roomID + "," +
                this.patientID + "," +
                this.notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consult consult = (Consult) o;
        return this.getId().equals(consult.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorID, roomID, patientID, notes);
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
