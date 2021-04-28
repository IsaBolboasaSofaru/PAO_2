package com.company;

/*
Todo: a service for each type of object and implement special functionalities for each of them

TODO: create SortedRepo

TODO: Extra functionalities ideas
    - filter patients by age
    - filter consults by doctor, patient and room

TODO: make the UI prettier; change the toString functions so that the console looks better
*/

import com.company.UI.UI;


public class Main {

    public static void main(String[] args) {

        UI console = new UI();
        console.runConsole();


//        //ArrayList<String> departmentNames = new ArrayList<>()["Cardiologie", "Stomatologie", "Generala", "Neurologie"];
//      //  Vector<String> vec_tor = new Vector<String>()
//        String[] departmentNames ={"Cardiologie", "Stomatologie", "Generala", "Neurologie"};
//        List<Department> departments = new ArrayList<Department>();
//
//        for(int departNr = 0; departNr < 4; ++departNr) {
//            ArrayList<Room> roomsList = new ArrayList<Room>();
//            for(int roomId = 0; roomId < 5; ++roomId){
//                Room room = new Room();
//                roomsList.add(room);
//            }
//            Department department = new Department(departmentNames[departNr], roomsList);
//            departments.add(department);
//        }
//
//
//        ClinicSystem clinicSystem = new ClinicSystem("Aici 2",departments);
//
//        System.out.println("Numele clinii este: " + clinicSystem.name + " Si are urmatoarele departamente: ");
//
//        for(int i =0; i < clinicSystem.departments.size(); ++i)
//        {
//            System.out.println(clinicSystem.departments.get(i).checkDepartmentName());
//        }
//
//        Patient adrian = new Patient("Adrian", 22);
//        clinicSystem.updatePatients(adrian);
//
//        Doctor d1 = new Doctor("Doctor","Ionescu", 10, 40, "Str. Locotenent N. Pascu");
//        Doctor d2 = new Doctor("Doctor","Marinescu", 20, 40, "Blv. Chisinau");
//        Doctor d3 = new Doctor("Doctor","Popescu", 5, 40, "Str. Mihai Bravu");
//        clinicSystem.doctors.add(d1);
//        clinicSystem.doctors.add(d2);
//        clinicSystem.doctors.add(d3);
//
//        Nurse n1 = new Nurse("Nurse", "Gina", "Cardiologie", "Something1");
//        Nurse n2 = new Nurse("Nurse","Ioana", "Stomatologie", "some2");
//        Nurse n3 = new Nurse("Nurse","Mihai", "Cardiologie", "Something3");
//        clinicSystem.nurses.add(n1);
//        clinicSystem.nurses.add(n2);
//        clinicSystem.nurses.add(n3);
//
//        Pharmacist p1 = new Pharmacist("Pharmacist",  "Obloja", "Manager", "MegaMall");
//        Pharmacist p2 = new Pharmacist("Pharmacist",  "Mara", "Researcher", "Unirii");
//        clinicSystem.pharmacists.add(p1);
//        clinicSystem.pharmacists.add(p2);
//
//
//        for(int i = 0; i < clinicSystem.doctors.size(); ++i)
//        {
//            System.out.println(clinicSystem.doctors.get(i).getYearsOfExperience());
//        }
//
//        System.out.println(clinicSystem.numberOfEmployees());
//
//
    }
}
