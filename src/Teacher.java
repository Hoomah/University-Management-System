

import java.util.Scanner;

public class Teacher {

    private String name;
    private String gender;
    private int age;
    private int salary;
    private String email;
    private String subject;

    public Teacher(String _name, String _gender, int _age, int _salary, String _email, String _subject){
        this.name = _name;
        this.gender = _gender;
        this.age = _age;
        this.salary = _salary;
        this.email = _email;
        this.subject = _subject;
    }

    private void welcomeTeacher(){
        Main.clearScreen();
        String mr_mrs = this.gender.equals("male") ? "Mr. " : "Mrs. ";
        System.out.println("+--------------------------------+");
        System.out.println("+ Greetings "+mr_mrs+this.name+" +");
        System.out.println("+-WELCOME TO THE TEACHERS PORTAL-+");
        System.out.println("+--------------------------------+");
        System.out.println();
    }

    public void start(){

        welcomeTeacher();

    }


}

