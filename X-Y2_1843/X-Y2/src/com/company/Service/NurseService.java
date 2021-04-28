package com.company.Service;

import com.company.Repo.CSVRepo;
import com.company.Repo.IRepo;
import com.company.Repo.InMemoryRepo;
import com.company.models.Nurse;

import java.util.ArrayList;

public class NurseService implements IService<Nurse> {
    private final IRepo<Nurse> nurseIRepo;

    public NurseService(IRepo<Nurse> nurseIRepo) { this.nurseIRepo = nurseIRepo;}

    public NurseService() { this.nurseIRepo = new CSVRepo<>("nurses.csv", new Nurse());}

    @Override
    public boolean contains(Nurse object) { return nurseIRepo.contains(object);}

    @Override
    public boolean remove(Nurse object) {return nurseIRepo.remove(object);}

    @Override
    public boolean add(Nurse object) {return nurseIRepo.add(object);}

    @Override
    public boolean update(Nurse object) {return nurseIRepo.update(object);}

    @Override
    public void remove(int index) { nurseIRepo.remove(index);}

    @Override
    public ArrayList<Nurse> getAll() { return nurseIRepo.getAll();}
}
