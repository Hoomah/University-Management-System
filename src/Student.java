import javax.swing.*;

public class Student {
    private String studentName;
    private String regNo;
    private String batch;
    private double c_gpa;
    private double s_gpa;
    private String phoneNumber;
    private String email;
    private String section;

    public Student(String student_name, String reg_no , String Section , String Batch , double cGpa, double sGpa , String phone_number , String Email  ){

            studentName = student_name;
            section = Section;
            regNo = reg_no;
            batch = Batch;
            c_gpa = cGpa;
            s_gpa  = sGpa;
            phoneNumber = phone_number;
            email = Email;

    }

    public void setEmail(String email) {
        if ((this.email.substring(this.email.length() - 4, this.email.length()).equals(".com")))
            this.email = email;
        else
            System.out.println("Email must be valid.");
    }
    public String getEmail() {
        return this.email;
    }
    public void setRegNo(String newRegNo){
            this.regNo = newRegNo;
    }
    public double getC_gpa() {
        return this.c_gpa;
    }

    public void setC_gpa(float newCgpa){
        if(newCgpa <= 4 && newCgpa > 0)
            this.c_gpa = newCgpa;
        else
            System.out.println("CGPA can not be more than 4 or negative");
    }

    public void setS_gpa(float newSgpa){
        if(newSgpa <= 4 && newSgpa > 0)
            this.s_gpa = newSgpa;
        else
            System.out.println("SGPA can not be more than 4 or negative");
    }

    public double getS_gpa(){
        return this.s_gpa;
    }

    public String getBatch(){
        return this.batch;
    }

}