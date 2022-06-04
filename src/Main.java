import java.util.Scanner;

public class Main {

    private static void welcome(){
        System.out.println("|---------------------------------------------------------------|");
        System.out.println("|--------------WELCOME UNIVERSITY MANAGEMENT SYSTEM-------------|");
        System.out.println("|------------ Developed By Humma Laila and Wasif Ali -----------|");
        System.out.println("|---------------------------------------------------------------|\n");


        System.out.println("Select Your Designation");
        System.out.println("1. Student\n"+ "2. Teacher\n"+ "3. Administration\n" + "0. Quit");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void studentLogin(String regNo, String password){
        // Access the private txt file with the regNo as file name and return the data from it in an array
        // Then pass it down to the student object
    }

    public static void main(String[] args) {

        // Welcoming the user
        clearScreen();
        welcome();
        byte resignation = 1;

        // Taking input for the relative portal
        Scanner input = new Scanner(System.in);

        // Opening the relative Portal

        while(resignation < 4 && resignation > 0) {
            // Asking for the resignation
            System.out.print("> ");
            resignation = input.nextByte();

            // For Students portal
            if (resignation == 1){
                clearScreen();
                System.out.println("+--------------------------------------+");
                System.out.println("+-----WELCOME TO THE STUDENT PORTAL----+");
                System.out.println("+--------------------------------------+\n");

                System.out.print("Enter your registration number: ");
                String regNo = input.nextLine();
                System.out.println("\nEnter your password: ");
                String password = input.nextLine();

            }

        }





    }
}