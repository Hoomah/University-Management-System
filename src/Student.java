import java.util.Scanner;

public class Student {
    private String studentName;
    private String regNo;
    private String batch;
    private String cGpa;
    private String sGpa;
    private String phoneNumber;
    private String email;
    private String section;
    private String fatherName;

    public Student(String student_name, String father_name, String reg_no , String _section , String _batch , String c_gpa, String s_gpa , String phone_number , String _email  ){

            studentName = student_name;
            section = _section;
            regNo = reg_no;
            batch = _batch;
            cGpa = c_gpa;
            sGpa  = s_gpa;
            phoneNumber = phone_number;
            email = _email;
            fatherName = father_name;

    }

    // Getters

    public String getName(){
        return this.studentName;
    }

    public String getFatherName(){
        return this.fatherName;
    }

    public String getRegNo(){
        return this.regNo;
    }

    public String getSection(){
        return this.section;
    }

    public String getPhoneNo(){
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }
 
    public String getC_gpa() {
        return this.cGpa;
    }

    public String getS_gpa(){
        return this.sGpa;
    }

    public String getBatch(){
        return this.batch;
    }



    // Taking the commands input and showing the results
    public void start(){
    
        while(true) {

            Main.clearScreen();
            System.out.println("+------------------------------------------+");
            System.out.println("+-----ENTER A NUMBER TO PERFORM A TASK-----+");
            System.out.println("+------------------------------------------+\n");

            System.out.println("1. Check Your Personal Information.");
            System.out.println("2. Check Your Academic Performance.");
            System.out.println("3. Send a message to the administration");
            System.out.println("0. Quit");

            Scanner input = new Scanner(System.in);
            System.out.print(">>> ");
            int command = input.nextInt();
            
            Main.clearScreen();

            if(command == 1){
                System.out.println("+-----------------------------------+");
                System.out.println("+---- YOUR PERSONAL INFORMATION ----+");
                System.out.println("+-----------------------------------+\n");

                System.out.println("Full Name: "+this.getName());
                System.out.println("Father Name: "+this.getFatherName());
                System.out.println("Email: "+this.getEmail());
                System.out.println("Phone No: "+this.getPhoneNo());
                System.out.println("Section: "+this.getSection());
                System.out.println("Batch: "+this.getBatch());

                System.out.print("\nEnter any number to continue...");
                input.nextByte();
                


            }

            else if(command == 2) {
                System.out.println("+-----------------------------------+");
                System.out.println("+---- YOUR ACADEMIC INFORMATION ----+");
                System.out.println("+-----------------------------------+\n");

            }

            else if(command == 0){
                System.out.println("See you later.");
                break;
            }

            


        }
    }
}