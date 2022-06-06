
public class Teacher {
        private String teacherName;
        private String phoneNumber;
        private String email;
        private double salary;
        private String subject ;
        private double advance ;

    public Teacher (String teacher_name, String phone_number , String _email , double _salary , String _subject , double _advance ){

        teacherName = teacher_name;
        phoneNumber = phone_number;
        email = _email;
        subject = _subject;
        salary = _salary;
        advance = _advance;

    }
    
    public String getEmail() {
        return this.email;
    }

    }

