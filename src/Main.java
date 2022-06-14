import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    private static void welcome(){
        System.out.println("|-------------------------------------------------------------|");
        System.out.println("|-----------WELCOME TO UNIVERSITY MANAGEMENT SYSTEM-----------|");
        System.out.println("|----------- Developed By Huma Laila and Wasif Ali  ----------|");
        System.out.println("|-------------------------------------------------------------|\n");


        System.out.println("Select Your Designation");
        System.out.println("""
                1. Student
                2. Teacher
                3. Administration
                0. Quit""");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public static void main(String[] args) throws InterruptedException {

        // Welcoming the user
        clearScreen();
        welcome();
        byte resignation;

        // Taking input for the relative portal
        Scanner input = new Scanner(System.in);

        // Opening the relative Portal

        // Asking for the resignation
        System.out.print("> ");
        resignation = input.nextByte();

        
        
        // For Students portal

        if (resignation == 1)
        {

            clearScreen();
            System.out.println("+--------------------------------------+");
            System.out.println("+-----WELCOME TO THE STUDENT PORTAL----+");
            System.out.println("+--------------------------------------+\n");

            // Getting the student's data
            System.out.print("Enter your registration number: ");
            String regNo = input.next();

            // Array to store the data in program from file
            String[] studentData = new String[10];

            // Opening the relative file for personal data
            try {
                File studentFile = new File("src/StudentsData/"+ regNo +"-personal.txt");
                Scanner studentDataReader = new Scanner(studentFile);

                // Reading the lines one by one
                int counter = 0;
                while (studentDataReader.hasNextLine()) {
                    String dataLine = studentDataReader.nextLine();
                    studentData[counter] = dataLine;
                    counter++;
                }
                // Closing the reader after the lines has ended
                studentDataReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("Student Not Found! Try again!");
                System.exit(1);
            }


            /* 
            0 -> password
            1 -> name
            2 -> batch
            3 -> cgpa
            4 -> sgpa
            5 -> phone number
            6 -> email
            7 -> section
            8 -> Father Name
            */

            // Opening the relative file for academic data

            String[] academicData = new String[5];// Array for the data of academic records

            // fetching the data from the file


            try {

                File academicDataFile = new File("src/StudentsData/"+ regNo +"-academic.txt");
                try (Scanner academic_fileReader = new Scanner(academicDataFile)) {
                    String currentLine;
                    int counter = 0;

                    while(academic_fileReader.hasNextLine()){
                        currentLine = academic_fileReader.nextLine();
                        academicData[counter] = currentLine;
                        counter ++;
                    }
                }
                
            } catch (FileNotFoundException e) {
                System.out.println("No academic record found.");
            }

           
            Student student = new Student(studentData[1], studentData[8],
            regNo, studentData[7], studentData[2], studentData[3],
            studentData[4], studentData[5], studentData[6], academicData);


            // Authenticating the login session

            int wrng_pswd_lmt = 5;
            boolean login_successful = false;

            while(true) { // Taking passwords as long as the user
                        // does not enter the right password or exceeds the limit

                System.out.print("Enter your password: ");
                String stdPassword = input.next();
                wrng_pswd_lmt --;

                if ((studentData[0].equals(stdPassword))) {

                    clearScreen();

                    System.out.print("Logging in");
                    for (int i = 0; i < 4 ; i++) {
                        Thread.sleep(60); // Adding a delaying effect
                        System.out.print(".");
                    }
                    Thread.sleep(1500);
                    System.out.println("\n+-------------------------------+");
                    System.out.println("+----- Welcome "+student.getName()+" :)-----+");
                    System.out.println("+-------------------------------+");

                    Thread.sleep(1000);
                    clearScreen();
                    login_successful = true;

                    break;

                } 

                else if (wrng_pswd_lmt <= 0){
                    clearScreen();
                    System.out.println("Password attempts limit exceeded!");
                    break;
                }
                
                else 
                {
                    System.out.println("Incorrect Password! Try again. \n");
                    System.out.println("Remaining tries: "+wrng_pswd_lmt);
                }
            

            
            }

            // starting the main section

            if(login_successful)
                student.start();
            else
                System.out.println("Could not start the user session!");

        }

        // Teachers

        else if (resignation == 2){
            Teacher teacher = new Teacher("Taimoor Sajjad", "male",
                    35, 150000, "taimoorsajjad@ciitwah.com",
                    "Programming Fundamentals");
            teacher.start();
        }

        else if(resignation == 0)
        {
            System.out.println("See you again!");
        }


        else 
        {
            System.out.println("Invalid Input!");
        }


    }

}