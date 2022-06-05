import javax.security.auth.Subject;

public class Teacher {
        private String teacherName;
        private String phoneNumber;
        private String email;
        private Double Salary;
        private String subject ;
        private Double advance ;

    public Teacher (String teacher_name, String phone_number , String Email , Double salary , String subject , Double advance ){

        teacherName = teacher_name;
        phoneNumber = phone_number;
        email = Email;
        String Subject = subject;
        advance = advance ;

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

    }

