package com.company.Service;

import com.company.Repo.CSVRepo;
import com.company.Repo.IRepo;
import com.company.Repo.InMemoryRepo;
import com.company.models.Department;

import java.util.ArrayList;

public class DepartmentService implements  IService<Department>{
    private final IRepo<Department> departmentIRepo;

    public DepartmentService(IRepo<Department> departmentIRepo) { this.departmentIRepo = departmentIRepo;}

    public DepartmentService() { this.departmentIRepo = new CSVRepo<>("departments.csv", new Department());}

    @Override
    public boolean contains(Department object) { return departmentIRepo.contains(object);}

    @Override
    public boolean remove(Department object) { return departmentIRepo.remove(object);}

    @Override
    public boolean add(Department object) { return departmentIRepo.add(object);}

    @Override
    public boolean update(Department object) {return departmentIRepo.update(object);}

    @Override
    public void remove(int index) {departmentIRepo.remove(index);}

    @Override
    public ArrayList<Department> getAll() { return departmentIRepo.getAll();}
}
