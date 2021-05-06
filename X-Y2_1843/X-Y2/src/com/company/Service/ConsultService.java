package com.company.Service;

import com.company.Repo.CSVRepo;
import com.company.Repo.IRepo;
import com.company.Repo.InMemoryRepo;
import com.company.models.Consult;
import com.company.models.Doctor;
import com.company.models.Patient;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ConsultService implements IService<Consult>{
    private final IRepo<Consult> consultIRepo;

    public ConsultService(IRepo<Consult> consultIRepo) { this.consultIRepo = consultIRepo;}
    public ConsultService() {
        this.consultIRepo = new CSVRepo<>("consults.csv", new Consult(-1));
    }

    @Override
    public boolean contains(Consult object) {
        return consultIRepo.contains(object);
    }

    @Override
    public boolean remove(Consult object) {
        return consultIRepo.remove(object);
    }

    @Override
    public boolean add(Consult object) {
        return consultIRepo.add(object);
    }

    @Override
    public boolean update(Consult object) {
        return consultIRepo.update(object);
    }

    @Override
    public void remove(int id) {
        consultIRepo.remove(new Consult((long) id));
    }

    @Override
    public ArrayList<Consult> getAll() {
        return consultIRepo.getAll();
    }

    public ArrayList<Consult> filterbyDoctor(Long doctorID){
        return consultIRepo.getAll().stream()
                .filter(e -> e.getDoctorID().equals(doctorID))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Consult> filterbyPatient(Long patientID){
        return consultIRepo.getAll().stream()
                .filter(e -> e.getPatientID().equals(patientID))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Consult> filterbyRoom(Long roomID){
        return consultIRepo.getAll().stream()
                .filter(e -> e.getRoomID().equals(roomID))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Consult> filterByPatientAgeRange(Integer lower_age, Integer higher_age){
//        Predicate<Consult> agePredicate = patient -> patient.getPatientID() == consult.getPatientID();
//        return consultIRepo.getAll().stream()
//                .filter(
//                        e-> this.patientIRepo.getAll()
//                )
//                .collect(Collectors.toCollection(ArrayList::new));
        return this.consultIRepo.getAll();
    }

}
