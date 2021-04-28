package com.company.Service;


import java.util.ArrayList;

public interface IService<T> {
    boolean contains(T object);
    boolean remove(T object);
    boolean add(T object);
    boolean update(T object);
    void remove(int index);
    ArrayList<T> getAll();
}
