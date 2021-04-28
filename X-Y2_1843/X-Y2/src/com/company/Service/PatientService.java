package com.company.Service;

import com.company.Repo.CSVRepo;
import com.company.Repo.IRepo;
import com.company.Repo.InMemoryRepo;
import com.company.models.Patient;

import java.util.ArrayList;

public class PatientService implements IService<Patient> {
    private final IRepo<Patient> patientIRepo;

    public PatientService(IRepo<Patient> patientIRepo) { this.patientIRepo = patientIRepo;}

    public PatientService() { this.patientIRepo = new CSVRepo<>("patients.csv", new Patient());
    }

    @Override
    public boolean contains(Patient object) { return patientIRepo.contains(object);}

    @Override
    public boolean remove(Patient object) { return patientIRepo.remove(object);}

    @Override
    public boolean add(Patient object) { return patientIRepo.add(object);}

    @Override
    public boolean update(Patient object) { return patientIRepo.update(object);}

    @Override
    public void remove(int index) { patientIRepo.remove(index);}

    @Override
    public ArrayList<Patient> getAll() { return patientIRepo.getAll();}
}
