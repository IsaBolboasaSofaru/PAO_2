package com.company.Repo;

import com.company.models.Doctor;

import java.util.ArrayList;

public class InMemoryRepo<T> implements IRepo<T> {
    ArrayList<T> elems;

    public InMemoryRepo() {
        elems = new ArrayList<>();
    }

    public InMemoryRepo(ArrayList<T> elems) {
        this.elems = elems;
    }

    @Override
    public int size() {
        return elems.size();
    }

    @Override
    public boolean isEmpty() {
        return elems.size() == 0;
    }

    @Override
    public boolean contains(T object) {
        return elems.contains(object);
    }

    @Override
    public boolean add(T object) {
        if (contains(object))
            return false;
        elems.add(object);
        return true;
    }

    @Override
    public boolean add(int index, T element) {
        if (contains(element))
            return false;
        elems.add(index, element);
        return (indexOf(element) == index);
    }

    @Override
    public boolean remove(T object) {
        return elems.remove(object);
    }

    @Override
    public boolean remove(int index) {
        if (0 <= index && index < size()) {
            elems.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(T object) {
        var pos = indexOf(object);
        if (pos == -1)
            return false;
        set(pos, object);
        return true;
    }

    @Override
    public ArrayList<T> getAll() {
        return elems;
    }


    @Override
    public T get(int index) {
        return elems.get(index);
    }

    @Override
    public T set(int index, T element) {
        return elems.set(index, element);
    }

    @Override
    public int indexOf(T object) {
        return elems.indexOf(object);
    }

    @Override
    public String toString() {
        return elems.stream().map(Object::toString).reduce("\n", String::concat);
    }
}
