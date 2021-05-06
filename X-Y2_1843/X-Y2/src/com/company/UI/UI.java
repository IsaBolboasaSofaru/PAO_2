package com.company.UI;

import com.company.Service.*;
import com.company.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UI {
    private final ConsultService consultService;
    private final DoctorService doctorService;
    private final RoomService roomService;
    private final DepartmentService departmentService;
    private final PatientService patientService;

    public UI(ConsultService consultService, DoctorService doctorService, RoomService roomService, DepartmentService departmentService, PatientService patientService) {
        this.consultService = consultService;
        this.doctorService = doctorService;
        this.roomService = roomService;
        this.departmentService = departmentService;
        this.patientService = patientService;
    }

    public UI() {
        this.consultService = new ConsultService();
        this.doctorService = new DoctorService();
        this.roomService = new RoomService();
        this.departmentService = new DepartmentService();
        this.patientService = new PatientService();
    }

    private void printMenu() {
        //todo add the menu options
        System.out.println("Welcome to the menu");
        System.out.println("1. Add a new doctor");
        System.out.println("2. Update a doctor");
        System.out.println("3. Delete a doctor");
        System.out.println("4. List the doctors");
        System.out.println("5. Add a new room");
        System.out.println("6. Update a room");
        System.out.println("7. Delete a room");
        System.out.println("8. List the rooms");
        System.out.println("9. Add a new department");
        System.out.println("10. Update a department");
        System.out.println("11. Delete a department");
        System.out.println("12. List the departments");
        System.out.println("13. Add a new patient");
        System.out.println("14. Update a patient");
        System.out.println("15. Delete a patient");
        System.out.println("16. List the patients");
        System.out.println("17. Add a new consult");
        System.out.println("18. Update a consult");
        System.out.println("19. Delete a consult");
        System.out.println("20. List the consults");
        System.out.println("21. Filter consults by doctorID");
        System.out.println("22. Filter consults by roomID");
        System.out.println("23. Filter consults by patientID");

        System.out.println("0. Exit");
    }

    private Integer getValidCommand(Scanner keyboard) {
        //todo make sure you add the options in the arr list as well
        Integer command = 0;
        List<Integer> arr = IntStream.range(0, 24).boxed().collect(Collectors.toList());

        do {
            System.out.println("Choose a valid option: ");
            try {
                command = Integer.valueOf(keyboard.next());
            } catch (RuntimeException e) {
                System.out.println("Program stopped! error:" + e.getMessage());
            }
        }
        while (!arr.contains(command));
        return command;
    }

    private Integer readInteger(String parameter) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(parameter + ": ");
            return Integer.valueOf(bufferedReader.readLine());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void runConsole() {
        //todo change here the switch
        Scanner keyboard = new Scanner(System.in);
        int running = 1;
        while (running == 1) {
            printMenu();
            var command = getValidCommand(keyboard);
            switch (command) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    updateDoctor();
                    break;
                case 3:
                    deleteDoctor();
                    break;

                case 4:
                    listDoctor();
                    break;

                case 5:
                    addRoom();
                    break;

                case 6:
                    updateRoom();
                    break;

                case 7:
                    deleteRoom();
                    break;

                case 8:
                    listRoom();
                    break;

                case 9:
                    addDepartment();
                    break;

                case 10:
                    updateDepartment();
                    break;

                case 11:
                    deleteDepartment();
                    break;

                case 12:
                    listDepartment();
                    break;

                case 13:
                    addPatient();
                    break;

                case 14:
                    updatePatient();
                    break;

                case 15:
                    deletePatient();
                    break;

                case 16:
                    listPatient();
                    break;

                case 17:
                    addConsult();
                    break;

                case 18:
                    updateConsult();
                    break;

                case 19:
                    deleteConsult();
                    break;

                case 20:
                    listConsult();
                    break;

                case 21:
                    filterConsultDoctor();
                    break;

                case 22:
                    filterConsultRoom();
                    break;

                case 23:
                    filterConsultPatient();
                    break;


                default : running = 0;
                    break;
            }
        }
    }

    void filterConsultDoctor() {
        Integer id = readInteger("DoctorID: ");
        System.out.println(consultService.filterbyDoctor(Long.valueOf(id)));
    }

    void filterConsultPatient() {
        Integer id = readInteger("PatientID: ");
        System.out.println(consultService.filterbyPatient(Long.valueOf(id)));
    }

    void filterConsultRoom() {
        Integer id = readInteger("RoomID: ");
        System.out.println(consultService.filterbyRoom(Long.valueOf(id)));
    }

    private Consult readConsult() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("id: ");
            Long id = Long.valueOf(bufferedReader.readLine());
            System.out.println("DoctorID: ");
            Long doctorID = Long.valueOf(bufferedReader.readLine());
            System.out.println("RoomID: ");
            Long roomID = Long.valueOf(bufferedReader.readLine());
            System.out.println("patientID: ");
            Long patientID = Long.valueOf(bufferedReader.readLine());
            System.out.println("Notes: ");
            String notes = bufferedReader.readLine();

            return new Consult(id, doctorID, roomID, patientID, notes);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;

    }

    void addConsult() {
        var room = readConsult();
        if (room != null) {
            var bool = consultService.add(room);
            if (bool)
                System.out.println("Consult added");
            else System.out.println("Consult couldn't be added");
        }
    }

    void updateConsult() {
        var room = readConsult();
        if (room != null) {
            if (consultService.update(room))
                System.out.println("Consult updated");
            else System.out.println("Consult couldn't be updated");
        }
    }

    void deleteConsult() {
        Integer id = readInteger("id");
        if (id != null) {
            this.consultService.remove(id);
            System.out.println("Consult deleted");
        }

    }

    void listConsult() {
//        System.out.println(Arrays.toString(this.consultService.getAll().toArray()));
        var obj = this.consultService.getAll()
                .stream().map(Object::toString)
                .reduce("\n", String::concat);
        System.out.println(obj);
    }

    private Patient readPatient() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("id: ");
            Long id = Long.valueOf(bufferedReader.readLine());
            System.out.println("Patient name: ");
            String departmentID = bufferedReader.readLine();
            System.out.println("Age: ");
            Integer age = Integer.valueOf(bufferedReader.readLine());

            return new Patient(id, departmentID, age);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;

    }

    void addPatient() {
        var room = readPatient();
        if (room != null) {
            var bool = patientService.add(room);
            if (bool)
                System.out.println("Patient added");
            else System.out.println("Patient couldn't be added");
        }
    }

    void updatePatient() {
        var room = readPatient();
        if (room != null) {
            if (patientService.update(room))
                System.out.println("Patient updated");
            else System.out.println("Patient couldn't be updated");
        }
    }

    void deletePatient() {
        Integer id = readInteger("id");
        if (id != null) {
            this.patientService.remove(id);
            System.out.println("Patient deleted");
        }

    }

    void listPatient() {
        System.out.println(this.patientService.getAll());
    }

    private Department readDepartment() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("id: ");
            Long id = Long.valueOf(bufferedReader.readLine());
            System.out.println("Department name: ");
            String departmentID = bufferedReader.readLine();

            return new Department(id, departmentID);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;

    }

    void addDepartment() {
        var room = readDepartment();
        if (room != null) {
            var bool = departmentService.add(room);
            if (bool)
                System.out.println("Department added");
            else System.out.println("Department couldn't be added");
        }
    }

    void updateDepartment() {
        var room = readDepartment();
        if (room != null) {
            if (departmentService.update(room))
                System.out.println("Department updated");
            else System.out.println("Department couldn't be updated");
        }
    }

    void deleteDepartment() {
        Integer id = readInteger("id");
        if (id != null) {
            this.departmentService.remove(id);
            System.out.println("Department deleted");
        }

    }

    void listDepartment() {
        System.out.println(this.departmentService.getAll());
    }

    private Room readRoom() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("id: ");
            Long id = Long.valueOf(bufferedReader.readLine());
            System.out.println("DepartmentID: ");
            Long departmentID = Long.valueOf(bufferedReader.readLine());

            return new Room(id, departmentID);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;

    }

    void addRoom() {
        Room room = readRoom();
        if (room != null) {
            var bool = roomService.add(room);
            if (bool)
                System.out.println("Room added");
            else System.out.println("Room couldn't be added");
        }
    }

    void updateRoom() {
        Room room = readRoom();
        if (room != null) {
            if (roomService.update(room))
                System.out.println("Room updated");
            else System.out.println("Room couldn't be updated");
        }
    }

    void deleteRoom() {
        Integer id = readInteger("id");
        if (id != null) {
            this.roomService.remove(id);
            System.out.println("Room deleted");
        }

    }

    void listRoom() {
        System.out.println(this.roomService.getAll());
    }

    private Doctor readDoctor() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("id: ");
            Long id = Long.valueOf(bufferedReader.readLine());
            System.out.println("Name: ");
            String name = bufferedReader.readLine();
            System.out.println("Adress: ");
            String address = bufferedReader.readLine();
            System.out.println("Job Type: ");
            String typeOfJob = bufferedReader.readLine();
            System.out.println("Years of experience: ");
            Integer yearsOfExperience = Integer.valueOf(bufferedReader.readLine());

            return new Doctor(id, typeOfJob, name, yearsOfExperience, address);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    void addDoctor() {
        Doctor doctor = readDoctor();
        if (doctor != null) {
            var bool = doctorService.add(doctor);
            if (bool)
                System.out.println("Doctor added");
            else System.out.println("Doctor couldn't be added");
        }
    }

    void updateDoctor() {
        Doctor doctor = readDoctor();
        if (doctor != null) {
            if (doctorService.update(doctor))
                System.out.println("Doctor updated");
            else System.out.println("Doctor couldn't be updated");
        }
    }

    void deleteDoctor() {
        Integer id = readInteger("id");
        if (id != null) {
            this.doctorService.remove(id);
            System.out.println("Doctor deleted");
        }

    }

    void listDoctor() {
        System.out.println(this.doctorService.getAll());
    }
}
