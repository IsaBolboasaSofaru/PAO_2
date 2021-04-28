package com.company.Service;

import com.company.Repo.CSVRepo;
import com.company.Repo.IRepo;
import com.company.Repo.InMemoryRepo;
import com.company.models.Consult;
import com.company.models.Pharmacist;

import java.util.ArrayList;

public class PharmacistService implements IService<Pharmacist> {
    private final IRepo<Pharmacist> pharmacistIRepo;

    public PharmacistService(IRepo<Pharmacist> pharmacistIRepo){this.pharmacistIRepo = pharmacistIRepo;}

    public PharmacistService() { this.pharmacistIRepo = new CSVRepo<>("pharmacists.csv", new Pharmacist());}

    @Override
    public boolean contains(Pharmacist object) { return pharmacistIRepo.contains(object);}

    @Override
    public boolean remove(Pharmacist object) { return pharmacistIRepo.remove(object);}

    @Override
    public boolean add(Pharmacist object) { return pharmacistIRepo.add(object);}

    @Override
    public boolean update(Pharmacist object) { return pharmacistIRepo.update(object);}

    @Override
    public void remove(int index) { pharmacistIRepo.remove(index);}

    @Override
    public ArrayList<Pharmacist> getAll() { return pharmacistIRepo.getAll();}
}
