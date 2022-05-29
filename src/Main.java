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

    public static void main(String[] args) {

        // Welcoming the user
        clearScreen();
        welcome();
        byte resignation = 1;

        // Taking input for the relative portal
        Scanner input = new Scanner(System.in);

        // Opening the relative Portal

        while(resignation > 4 && resignation < 0) {
            // Asking for the resignation
            System.out.print("> ");
            resignation = input.nextByte();
            switch (resignation) {

                case 1:
                    System.out.println("Student");
                    break;
                case 2:
                    System.out.println("Teacher");
                    break;
                case 3:
                    System.out.println("Admin");
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Please Select a valid command");
                    break;

            }
        }





    }
}