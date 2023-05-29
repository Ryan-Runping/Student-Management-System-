package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagementSystem {

    public static void manageInterface() {
        ArrayList<Student> list = new ArrayList<>();

       loop: while (true) {

            System.out.println("1: add student");
            System.out.println("2: delete student");
            System.out.println("3: update student");
            System.out.println("4: query student");
            System.out.println("5: exit");
            System.out.println("please input your choice: ");
            Scanner sc = new Scanner(java.lang.System.in);
            String choose =  sc.next();
            switch (choose){
                case "1" -> addStudent(list);
                case "2" -> deleteStudent(list);
                case "3" -> updateStudent(list);
                case "4" -> queryStudent(list);
                case "5" -> {
                    System.out.println("exit");
                              break loop;}
                default -> System.out.println("the number you input is wrong");
            }
        }
    }

    public static void addStudent(ArrayList<Student> list){
        System.out.println("add student");
        //add new student
        Scanner sc = new Scanner(System.in);
        String id = null;
        while (true) {
            System.out.println("Please input student ID");
            id = sc.next();
            if (contains(list,id)){
                System.out.println("The ID you input has already existed , please input another");
            }
            else {
                break;
            }
        }

        System.out.println("Please input student name");
        String name = sc.next();
        System.out.println("Please input student age");
        String age = sc.next();
        System.out.println("Please input student address");
        String address = sc.next();

        Student stu = new Student(id,name,age,address);
        list.add(stu);
        System.out.println("Added successfully !");


    }

    public static void deleteStudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        System.out.println("please input the student's ID you want to delete");
        String id = sc.next();
        if (contains(list,id)){
            int index = getIndex(list,id);
            list.remove(index);
            System.out.println("removed successfully");
        }
        else {
            System.out.println("ID you input is not exist, back to main interface");
        }


    }

    public static void updateStudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        System.out.println("please input the student's ID you want to update");
        String id = sc.next();
        if (contains(list , id)){
            int index = getIndex(list,id);
            System.out.println("input new name please");
            String newName = sc.next();
            System.out.println("input new age please");
            String newAge = sc.next();
            System.out.println("input new address please");
            String newAddress = sc.next();
            list.get(index).setName(newName);
            list.get(index).setAge(newAge);
            list.get(index).setAddress(newAddress);
            System.out.println("updated successfully");

        }
        else {
            System.out.println("ID you input is not exist,  back to the main interface");
        }
    }

    public static void queryStudent(ArrayList<Student> list){
        System.out.println("query student");
        if (list.size() == 0){
            System.out.println("There is no student currently! Please add students first ");
            return;
        }
        // print form head
        System.out.println("id\t\tname\t\tage\t\taddress");
        for (int i = 0; i < list.size(); i++) {
            Student stu = new Student();
            stu = list.get(i);
            System.out.println(stu.getId()+ "\t\t"+ stu.getName()+"\t\t"+stu.getAge()+"\t\t"+stu.getAddress());
        }
    }

    //detect if id is unique
    public static boolean contains(ArrayList<Student> list, String id){
        boolean result;
        result = getIndex(list,id) >= 0 ;
        return result;
    }

    //get list index by student id, if not exist ,return -1
    public static int getIndex (ArrayList<Student> list, String id){
        Student stu = new Student();
        for (int i = 0; i < list.size(); i++) {
            stu = list.get(i);
            if (stu.getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
}