package org.example;



import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WelcomeInterface {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        while (true) {
            System.out.println("-----------WELCOME TO STUDENTS MANAGEMENT SYSTEM----------------");
            System.out.println("1: login");
            System.out.println("2: register");
            System.out.println("3: forget password");
            System.out.println("4: exit");
            System.out.println("please input your choice: ");

            Scanner sc = new Scanner(System.in);
            String choose = sc.next();

            switch (choose){
                case "1" -> login(list);
                case "2" -> register(list);
                case "3" -> forgetPassword(list);
                case "4" -> {
                    System.out.println("exit");
                    System.exit(0);
                }
                default -> System.out.println("wrong input, please input again");
            }
        }


    }

    public static void login(ArrayList<User> list){

        Scanner sc = new Scanner(System.in);
        System.out.println("input your username please");
        String name = sc.next();
        if (!containsUsername(list,name)){
            System.out.println("username does not exist, back to welcome interface");
            return;
        }
        int attemp = 0;
        while (attemp<=3){
            System.out.println("input your password please");
            String password = sc.next();
            int index = getIndex(list,name);
            if (list.get(index).getPassword().equals(password)){
                attemp = 4;
            }
            else {
                attemp++;
                System.out.println("wrong password , try again ," + (3-attemp) + "times chance left");
                if (attemp == 4){
                    System.out.println("try too many times, back to welcome interface");
                    return;
                }
            }
        }
        String verifiedCode;
        String inputCode;
        while (true) {
            verifiedCode = captcha();
            System.out.println("please input the code you see :" + verifiedCode);
            inputCode = sc.next();
            if (inputCode.equals(verifiedCode)){
                break;
            }
        }

            ManagementSystem user1 = new ManagementSystem();
            user1.manageInterface();

    }

    public static void register(ArrayList<User> list){
        System.out.println("register");
        Scanner sc = new Scanner(System.in);
        User user = new User();

        // deal with username
        while (true) {
            System.out.println("please input username");
            String name = sc.next();
            if (user.isCorrectName(name)){
                //if name is unique!!!!!!!!!
                if (!containsUsername(list,name)){
                    user.setName(name);
                    break;
                }
                else {
                    System.out.println("username already exist , try another one");
                }

            }
            else {
                System.out.println("input username is invalid, please input another one");
            }
        }

        //deal with password
        while (true) {
            System.out.println("please input password");
            String password1 = sc.next();
            System.out.println("please input the same password again");
            String password2 = sc.next();
            if (password1.equals(password2)){
                user.setPassword(password1);
                break;
            }
            else {
                System.out.println("the password you input two times are different, please try again");
            }
        }


        //deal with id
        while (true) {
            System.out.println("please input id");
            String id = sc.next();
            if (user.isCorrectId(id)){
                user.setId(id);
                break;
            }
            else {
                System.out.println("the id you input is invalid, please try again");
            }
        }

        //deal with email address
        while (true) {
            System.out.println("please input email");
            String email = sc.next();
            if (user.isCorrectEmail(email)){
                user.setEmailAddress(email);
                break;
            }
            else {
                System.out.println("the email address you input is invalid, please try again");
            }
        }

        list.add(user);
        System.out.println("register successfully");

    }

    public static void forgetPassword(ArrayList<User> list){
        Scanner sc = new Scanner(System.in);
        System.out.println("please input your username");
        String name = sc.next();
        if (!containsUsername(list,name)){
            System.out.println("the username does not exist , back to welcome interface");
            return;
        }
        int index = getIndex(list,name);
        User user;
        user = list.get(index);
        System.out.println("please input your id ");
        String id = sc.next();
        System.out.println("please input your email");
        String email = sc.next();
        if (user.getId().equals(id) && user.getEmailAddress().equals(email)){
            while (true) {
                System.out.println("input your new password");
                String newPassword1 = sc.next();
                System.out.println("input your new password again");
                String newPassword2 = sc.next();
                if (newPassword1.equals(newPassword2)){
                    user.setPassword(newPassword1);
                    break;
                }
                else {
                    System.out.println("the password you input two times are different, try again");
                }
            }
        }

    }

    public static boolean containsUsername(ArrayList<User> list , String name) {
        return getIndex(list,name)>=0 ;
    }

    public static int getIndex(ArrayList<User> list , String name){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public static String captcha(){
        String code = "";
        String alpha = "abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        System.out.println(alpha.length());
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            code = code + alpha.charAt(random.nextInt(alpha.length()));
        }
        int index = random.nextInt(5);
        char oldChar = code.charAt(index);
        char newChar = "0123456789".charAt(random.nextInt(0,10));
        code = code.replace(oldChar, newChar);
        return code;
    }


}
