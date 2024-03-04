public class constructor {
    public static void main(String[] args) {
        Student s2=new Student("Ayush");
        Student s1=new Student();
        Student s3=new Student(18);
        System.out.println(s2.name);
        System.out.println(s3.roll);
    }
}
class Student{
    String name;
    int roll;

    Student(){//non-parameterized constructor;
        System.out.println("This is constructor..");
    }

    Student(String name){ //parameterized constructor
        this.name=name;
    }
    Student(int roll){
        this.roll=roll;
    }
}