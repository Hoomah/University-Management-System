import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;
import java.io.File;

public class Teacher {
    Scanner input = new Scanner(System.in);

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
        
        try {Thread.sleep(1000);} 
        catch (InterruptedException e) {}
    }

    public void start(){

        welcomeTeacher();
        
        while(true){

            Main.clearScreen();

            byte operation;
            Main.clearScreen();
            System.out.println("PLEASE SELECT AN OPERATION");
            System.out.println("+-----------------------------------------+");
            System.out.println("1. Send a message to the administration");
            System.out.println("2. See the personal information");
            System.out.println("3. Update student's marks");
            System.out.println("0. Quit Application");
            System.out.println("+-----------------------------------------+");

            System.out.print("> ");
            operation = input.nextByte();
            input.nextLine();
            if(operation == 1){

                try(FileWriter tcw = new FileWriter("./src/TeachersComplaints.txt")){

                    System.out.print("Please Enter Your Message: ");
                    String complaint = input.nextLine();

                    tcw.write("+------------------------------------------------------+\n");
                    tcw.write("+---------COMPLAIN FROM "+this.name.toUpperCase()+"---------+\n");
                    tcw.write(complaint);
                    tcw.write("\n+-----------------------------------------------------+");
                } catch (IOException e) {e.printStackTrace();}
            }

            else if (operation == 2){
                Main.clearScreen();
                System.out.println("+---- Name: "+this.name);
                System.out.println("+---- Age: "+this.age);
                System.out.println("+---- Gender: "+ this.gender);
                System.out.println("+---- Salary: "+this.salary);
                System.out.println("+---- Email: "+this.email);
                System.out.println("+---- Subject: "+this.subject);
                input.nextByte();
            }

            else if (operation == 3){
                System.out.print("Enter Student's Reg #: ");
                String regNo = input.nextLine();
                System.out.print("Enter Subject: ");
                String subject = input.nextLine();
                System.out.print("Enter New Marks: ");
                String marks = input.nextLine();

                File studentFile = new File("src/StudentsData/"+regNo+"-academic.txt");
                try(PrintWriter writer = new PrintWriter( new FileWriter(studentFile, true) )){

                    writer.append("\n+--------NEW MARKS ADDED BY "+ this.name +"---------+\n");
                    writer.append("+Marks: "+marks);
                    writer.append("\nAdded on:"+ LocalDate.now()+"for "+subject);

                } catch (IOException e) { System.out.println("Something went wrong!"); }
            }

            else if (operation == 0)
                break;
                
        }

    }



}

