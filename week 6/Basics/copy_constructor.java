public class copy_constructor {
    public static void main(String[] args) {
        Student s1=new Student();
        s1.name="Ayushman";
        s1.roll=37;
        s1.password="abcd";
        s1.marks[0]=94;
        s1.marks[1]=94;
        s1.marks[2]=88;
        Student s2=new Student(s1);
        s2.password="xyz";
        s1.marks[2]=87;
        for(int i=0;i<s2.marks.length;i++){
            System.out.println(s2.marks[i]);
        }
    }
}
class Student{
    String name;
    int roll;
    String password;
    int marks[];
    //shallow copy constructor
    // Student(Student s1){
    //     marks=new int[3];
    //     this.name=s1.name;
    //     this.roll=s1.roll;
    //     this.marks=s1.marks;
    // }
    //deep copy constructor
    Student(Student s1){
        marks=new int[3];
        this.name=s1.name;
        this.roll=s1.roll;
        for(int i=0;i<marks.length;i++){
            this.marks[i]=s1.marks[i];
        }
    }

    Student(){//non-parameterized constructor;
        this.marks=new int[3];
        System.out.println("This is constructor..");
    }

    Student(String name){ //parameterized constructor
        this.marks=new int[3];
        this.name=name;
    }
    Student(int roll){
        this.marks=new int[3];
        this.roll=roll;
    }
}
