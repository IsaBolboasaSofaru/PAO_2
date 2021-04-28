package com.company.Service;

import com.company.Repo.CSVRepo;
import com.company.Repo.IRepo;
import com.company.Repo.InMemoryRepo;
import com.company.models.Room;

import java.util.ArrayList;

public class RoomService implements IService<Room> {
    private final IRepo<Room> roomIRepo;

    public RoomService(IRepo<Room> roomIRepo) { this.roomIRepo = roomIRepo;}
    public RoomService() {
        this.roomIRepo = new CSVRepo<>("rooms.csv", new Room());
    }

    @Override
    public boolean contains(Room object) { return roomIRepo.contains(object);}

    @Override
    public boolean remove(Room object) { return roomIRepo.remove(object);}

    @Override
    public boolean add(Room object) { return roomIRepo.add(object);}

    @Override
    public boolean update(Room object) { return roomIRepo.update(object);}

    @Override
    public void remove(int index) { roomIRepo.remove(index);}

    @Override
    public ArrayList<Room> getAll() { return roomIRepo.getAll();}
}
