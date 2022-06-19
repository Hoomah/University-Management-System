import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Admin {

    private String name;
    private String passcode;

    private static void welcome(){
        Main.clearScreen();
        System.out.println("+ --------------------------- +");
        System.out.println("+ WELCOME TO THE ADMIN PANEL  +");
        System.out.println("+ --------------------------- +");
    }

    public Admin(String _name, String _passcode){
        this.name = _name;
        this.passcode = _passcode;
    }

    public void start(){
        welcome();
        Scanner input = new Scanner(System.in);

        boolean loginAdminSuccess = false;
        
        // Opening admin's file
        String[] adminData = new String[2];
        try {
        
            File adminFile = new File("src/"+this.name+".txt");
            Scanner adminFileReader = new Scanner(adminFile);

            try{
                for (int i = 0; i < adminData.length; i++) {
                    adminData[i] = adminFileReader.nextLine();
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Something went wrong!");
            }

            adminFileReader.close();
            
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }

        // Authentication

        try{
            if(adminData[0].equals(this.passcode)){
                loginAdminSuccess = true;
            }
        } catch (NullPointerException e){
            System.out.println("File does not exists or is empty.");
        }

        if(loginAdminSuccess){

            while (true) {
                Main.clearScreen();
                System.out.println("Choose an operation");
                System.out.println("1. Add a new Employee");
                System.out.println("2. Add a new Student");
                System.out.println("3. Access Teacher's info");
                System.out.println("4. Access Student's info");
                System.out.println("5. Delete an Employee's record");
                System.out.println("6. Delete a student's record");
                System.out.println("0. Exit");
                byte operation = input.nextByte();
                input.nextLine();
                if(operation == 1){
                    try {
                        
                        System.out.print("Enter Employee Name: ");
                        String employeeName = input.nextLine();
                        File newEmployee = new File("src/"+employeeName+".txt");
                        Boolean is_newFile = false;
    
                        if(newEmployee.createNewFile()){
                            System.out.println(employeeName + ".txt created");
                            is_newFile = true;
                        } else {
                            System.out.println("This name already exists. Please try another name");
                        }
    
                        if(is_newFile) {
                            String questions[] = {
                                                "Set a password for the employee: ",
                                                "Enter Employee's Name: ",
                                                "Enter Employee's Gender: ",
                                                "Enter Employee's Age: ",
                                                "Set a salary: ",
                                                "Enter Employee's email: ",
                                                "Enter the job/subjects: " 
                                                };
                            String answers[] = new String[questions.length];
    
                            for (int i = 0; i < questions.length; i++) {
                                System.out.print(questions[i]);
                                answers[i] = input.nextLine();
                                answers[i] = answers[i]+"\n"; // To move the to the next line
                            }
    
                            // Now writing the data
                            FileWriter writer = new FileWriter(newEmployee);
                            for (int i = 0; i < answers.length; i++) {
                                writer.write(answers[i]);
                            }
    
                            System.out.println("New Record was created succesfully.");
                            writer.close();
                    }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                else if (operation == 2){
                    // ADD a new student

                    System.out.print("Enter student's registration number: ");
                    String std_regNo = input.nextLine();
                    System.out.print("Assign student a password: ");
                    String std_pswd = input.nextLine();
                    System.out.print("Enter Student's name: ");
                    String std_name = input.nextLine();
                    System.out.print("Enter Student's CGPA: ");
                    String std_cgpa = input.nextLine();
                    System.out.print("Enter student's SPGA: ");
                    String std_sgpa = input.nextLine();
                    System.out.print("Enter student's section: ");
                    String std_section = input.nextLine();
                    System.out.print("Enter Student's Batch: ");
                    String std_batch = input.nextLine();
                    System.out.print("Enter Student's Father's name: ");
                    String std_fatherName = input.nextLine();
                    System.out.print("Enter Student's email: ");
                    String std_email = input.nextLine();
                    System.out.print("Enter Student's phone number: ");
                    String std_phone = input.nextLine();

                    String std_data_sorted[] = {
                        std_pswd, std_name, std_batch,
                        std_cgpa, std_sgpa, std_phone,
                        std_email, std_section, std_fatherName
                    };

                    try{
                        // Creating the file
                        File registerStudent = new File("src/StudentsData/"+std_regNo+"-personal.txt");
                        if(registerStudent.createNewFile()){
                            System.out.println("File created successfully: "+registerStudent.getName());
                        } else {
                            System.out.println("The file"+ registerStudent.getName() +"exists already.");
                        }

                        // Adding data to the file

                        FileWriter stdDataWriter = new FileWriter(registerStudent);

                        for (String string : std_data_sorted) {
                            stdDataWriter.write(string+"\n");
                        }

                        stdDataWriter.close();


                    } catch (IOException e) { System.out.println("Could not register the student!"); }

                }

                else if(operation == 3){


                    // Accessing Teacher's information

                    // Get the teacher's name to open the relative file

                    try{
                        System.out.println("Enter Teacher's name: ");
                        String teacherName = input.nextLine();
                        File teachersDataFile = new File("src/"+teacherName+".txt");
                        Scanner teacherDataReader = new Scanner(teachersDataFile);
    
                        // Fetch the data into an array
                        String teacherData[] = new String[7];
                        byte counter = 0;
                        while(teacherDataReader.hasNextLine()){
                            teacherData[counter] = teacherDataReader.nextLine();
                            counter++;
                        }

                        teacherDataReader.close();

                        // Display the data to the admin
                        Main.clearScreen();

                        for (String string : teacherData) {
                            System.out.println(string);
                        }

                        input.nextLine();


                    } catch (IOException e) { System.out.println("Could Not Access The Data."); }



                }

                else if(operation == 4){

                    // Ask for registration number

                    System.out.print("Enter the student's registration number: ");
                    String std_regNo = input.nextLine();

                    //  Access both personal and academic files

                    String[] academicData = new String[6];
                    String[] personalData = new String[9];

                    // Fetch the data into two different arrays

                    
                    try{

                        File studentAcademicFile = new File("src/StudentsData/"+std_regNo+"-academic.txt");
                        File studentPersoanalFile = new File("src/StudentsData/"+std_regNo+"-personal.txt");

                        Scanner academicReader = new Scanner(studentAcademicFile);
                        Scanner personalReader = new Scanner(studentPersoanalFile);

                        byte counter = 0;
                        while(academicReader.hasNextLine()){
                            academicData[counter] = academicReader.nextLine();
                            counter ++;
                        }
                        academicReader.close();
                        counter = 0;
                        while(personalReader.hasNextLine()){
                            personalData[counter] = personalReader.nextLine();
                            counter ++;
                        }
                        personalReader.close();

                    } catch (IOException e) { System.out.println("Something went wrong here! Can't access data at the moment."); }

                    // display the data to the admin

                    System.out.println("++++++ PERSONAL DATA OF "+std_regNo+" ++++++");
                    for (String string : personalData) {
                        System.out.println(string);
                    }
                    System.out.println("++++++++++++++++++++++++++++++++++++++\n");

                    System.out.println("++++++ ACADEMIC DATA OF "+std_regNo+"++++++");
                    
                    for (String string : academicData) {
                        System.out.println(string);
                    }

                    System.out.println("++++++++++++++++++++++++++++++++++++++\n");
                    input.nextLine();

                }

                else if(operation == 0){
                    break;
                }

                else {
                    System.out.println("Invalid input!");
                }
    
                            
            }
        }
        else{
            System.out.println("Could not login!");
        }
        input.close();
        
    }
}