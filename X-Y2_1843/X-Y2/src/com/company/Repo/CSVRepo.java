package com.company.Repo;

import com.company.models.BaseEntity;

import java.io.*;
import java.util.ArrayList;

public class CSVRepo<T extends BaseEntity<Long>> implements IRepo<T> {
    private final String filepath;
    public static final String delimiter = ",";
    private final T elem;

    public CSVRepo(String filepath, T elem) {
        this.filepath = filepath;
        this.elem = elem;
    }

    private ArrayList<T> read() {
        ArrayList<T> elems = new ArrayList<T>();
        try {
            File file = new File(this.filepath);
            var ignored = file.createNewFile();
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            while ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                var new_elem = elem.extractEntity(tempArr);
                elems.add((T) new_elem);
            }
            br.close();
        }
        catch (IOException ignored) {
        }
        return elems;
    }
    private void write(ArrayList<T> elems){
        try {
            FileWriter csvWriter = new FileWriter(getFilepath());
            for(var line_elem: elems){
                csvWriter.append(line_elem.toCSVString());
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int size() {
        return read().size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(T object) {
        return read().contains(object);
    }

    @Override
    public boolean add(T object) {
        var elems = read();
        if (indexOf(object) != -1)
            return false;
        elems.add(object);
        write(elems);
        return true;
    }

    @Override
    public boolean add(int index, T element) {
        if (contains(element))
            return false;
        var elems = read();
        elems.add(index, element);
        write(elems);
        return (indexOf(element) == index);
    }

    @Override
    public boolean remove(T object) {
        var elems = read();
        var bool = elems.remove(object);
        write(elems);
        return bool;
    }

    @Override
    public boolean remove(int index) {
        var elems = read();
        if (0 <= index && index < size()) {
            elems.remove(index);
            write(elems);
            return true;
        }
        write(elems);
        return false;
    }

    @Override
    public boolean update(T object) {
        var pos = indexOf(object);
        if (pos == -1)
            return false;
        this.set(pos, object);
        return true;
    }

    @Override
    public ArrayList<T> getAll() {
        return read();
    }


    @Override
    public T get(int index) {
        var elems = read();
        return elems.get(index);
    }

    @Override
    public T set(int index, T element) {
        var elems = read();
        var elem = elems.set(index, element);
        write(elems);
        return elem;
    }

    @Override
    public int indexOf(T object) {
        var elems = read();
        return elems.indexOf(object);
    }

    @Override
    public String toString() {
        var elems = read();
        return elems.stream().map(Object::toString).reduce("\n", String::concat);
    }

    public String getFilepath() {
        return filepath;
    }
}
