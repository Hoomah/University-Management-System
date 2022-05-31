public class Student {
    private String studentName;
    private String regNo;
    private String batch;
    private float c_gpa;
    private float s_gpa;
    private String phoneNumber;
    private String email;

    public void Student(String student_name, String reg_no , String Batch , float cGpa, float sGpa , String phone_number , String Email  ){

            studentName = student_name;
            regNo = reg_no;
            batch = Batch;
            c_gpa = cGpa;
            s_gpa  = sGpa;
            phoneNumber = phone_number;
            email = Email;

    }
    public void setEmail=(String email ){
        String a ;
        if( a = ".com" )
            this.email = newEmail;
        else
            System.out.println("");
    }
    public float getEmail() {
        return this.email;
    }
    public void setregNo(float newregno){
        if(  )
            this.regNo = newregNo;
        else
            System.out.println("CGPA can not be more than 4");
    }
    public float getC_gpa(){
        return this.c_gpa;









    public void setC_gpa(float newCgpa){
        if(newCgpa <= 4)
            this.c_gpa = newCgpa;
        else
            System.out.println("CGPA can not be more than 4");
    }
    public float getC_gpa(){
        return this.c_gpa;
    }
    public void setS_gpa(float newSgpa){
        if(newSgpa <= 4)
            this.s_gpa = newSgpa;
        else
            System.out.println("SGPA can not be more than 4");
    }
    public float getS_gpa_gpa(){
        return this.s_gpa;
    }
    public void Batch(String newbatch){
        if(length = 12)
            this.batch  = newbatch;
        else
            System.out.println("CGPA can not be more than 4");
    }
    public String getBatch(){
        return this.batch;
    }

}