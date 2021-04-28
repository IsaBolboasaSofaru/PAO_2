package com.company.Service;

import com.company.Repo.CSVRepo;
import com.company.Repo.IRepo;
import com.company.Repo.InMemoryRepo;
import com.company.models.Doctor;

import java.util.ArrayList;

public class DoctorService implements IService<Doctor>{
    private final IRepo<Doctor> doctorIRepo;

    public DoctorService(IRepo<Doctor> doctorIRepo) {
        this.doctorIRepo = doctorIRepo;
    }
    public DoctorService() {
        this.doctorIRepo = new CSVRepo<>("doctors.csv", new Doctor());
    }

    @Override
    public boolean contains(Doctor object) {
        return doctorIRepo.contains(object);
    }

    @Override
    public boolean remove(Doctor object) {
        return doctorIRepo.remove(object);
    }

    @Override
    public boolean add(Doctor object) {
        return doctorIRepo.add(object);
    }

    @Override
    public boolean update(Doctor object) {
        return doctorIRepo.update(object);
    }

    @Override
    public void remove(int id) {
        doctorIRepo.remove(new Doctor((long) id));
    }

    @Override
    public ArrayList<Doctor> getAll() {
        return doctorIRepo.getAll();
    }
}
