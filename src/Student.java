import java.util.Scanner;
 class SMSApplication {
    public static void main(String s[]) {
        StudentMainentance sm = new StudentMainentance();
        sm.process();
    }
}
class StudentMainentance {

    Student[] allStudents = new Student[50];
    int nextStudentIndex = 0;
    Scanner scanner = new Scanner(System.in);

    public void process() {
        printHelp();
        setupSample();
        System.out.println("Enter your choice:");
        while (true) {
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    showStudents();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    modifyStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    searchByStudentName();
                    break;
                case 6:
                    searchBySection();
                    break;
                case 7:
                    searchByGreaterThanMarks();
                    break;
                case 8:
                    sortByName();
                    break;
                case 9:
                    sortByMarksAsc();
                    break;
                case 10:
                    sortByMarksDesc();
                    break;
                case 11:
                    top3toppers();
                    break;
                case 12:
                    printHelp();
                    break;
                case 13:
                    System.exit(0);
            }
            System.out.println("Enter your choice:");
        }
    }
    private void setupSample()
    {

        allStudents[nextStudentIndex++] = new Student("Siva Nookala", 1, 'A', 35);
        allStudents[nextStudentIndex++] = new Student("Siva Kumar", 2, 'B', 50);
        allStudents[nextStudentIndex++] = new Student("Venkata Siva", 3, 'B', 70);
        allStudents[nextStudentIndex++] = new Student("Krishna Sai", 4, 'A', 55);
    }
    void showStudents()
    {
        boolean found = false;
        for (int i = 0; i < allStudents.length; i++) {
            if (allStudents[i] != null) {
                allStudents[i].print();
                found = true;
            }
        }
        if (!found)
            System.out.println("No Records found");
    }

    void addStudent()
    {
        Student student = new Student();
        System.out.println("Enter name :");
        student.name = scanner.next();
        System.out.println("Enter rollNumber :");
        student.rollNumber = scanner.nextInt();
        System.out.println("Enter section :");
        student.section = scanner.next().charAt(0);
        System.out.println("Enter marks :");
        student.marks = scanner.nextInt();
        allStudents[nextStudentIndex] = student;
        nextStudentIndex++;
    }
    void deleteStudent()
    {
        System.out.println("Enter the Which element ");
        int rollno = scanner.nextInt();
        int count=0;
        for (int i = 0; i < allStudents.length; i++)
        {
            if (allStudents[i] != null) {
                if (allStudents[i].rollNumber == rollno)
                {
                    allStudents[i] = null;
                    count++;
                }
            }
        }
        if(count==0)
        {
            System.out.println("No Records Deleted");
        }
        else
        {
            System.out.println(count+"Records Deleted");
        }
    }

    void modifyStudent()
    {
        System.out.println("Enter rollNumber :");
        int rollno = scanner.nextInt();
        for (int i = 0; i < allStudents.length; i++)
        {
            if (allStudents[i] != null) {
                if (allStudents[i].rollNumber == rollno)
                {
                    System.out.println("Enter name :");
                    allStudents[i].name = scanner.next();
                    System.out.println("Enter section :");
                    allStudents[i].section = scanner.next().charAt(0);
                    System.out.println("Enter marks :");
                    allStudents[i].marks = scanner.nextInt();
                }
            }
        }
    }

    void searchByStudentName()
    {
        System.out.println("Enter student name :");
        String query = scanner.next();
        boolean found = false;
        for (int i = 0; i < allStudents.length; i++) {
            if (allStudents[i] != null && allStudents[i].name.contains(query)) {
                allStudents[i].print();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No records found with name like " + query);
        }

    }

    void searchBySection()
    {
        System.out.println("Enter student Section :");
        char section = scanner.next().charAt(0);
        boolean found = false;
        for (int i = 0; i < allStudents.length; i++)
        {
            if (allStudents[i] != null && allStudents[i].section == section)
            {
                allStudents[i].print();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No records found with Section like " + section);
        }

    }
    void searchByGreaterThanMarks() {
        System.out.println("Enter student marks :");
        int marks = scanner.nextInt();
        boolean found = false;
        for (int i = 0; i < allStudents.length; i++) {
            if (allStudents[i] != null && allStudents[i].marks > marks) {
                allStudents[i].print();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No records found with Greater than " + marks + " marks");
        }
    }

    void top3toppers()
    {
        int topper1 = allStudents[0].marks;
        int topper2 = allStudents[0].marks;
        int topper3 = allStudents[0].marks;
        int j=0,s=0,t=0;
        for (int i = 0; i < allStudents.length; i++)
        {
            if (allStudents[i] != null&&allStudents[i].marks > topper1)
            {
                topper1 = allStudents[i].marks;
                j = i;
            }
        }
        for (int i = 0; i < allStudents.length; i++) {
            if (allStudents[i] != null&&(allStudents[i].marks > topper2 && allStudents[i].marks < topper1))
            {
                topper2 = allStudents[i].marks;
                s = i;
            }
        }
        for (int i = 0; i < allStudents.length; i++)
        {
            if (allStudents[i] != null&&(allStudents[i].marks > topper3 && allStudents[i].marks < topper2))
            {
                topper3 = allStudents[i].marks;
                t=i;
            }
        }
        allStudents[j].print();
        allStudents[s].print();
        allStudents[t].print();
    }
    void sortByName()
    {
        String temp;
        for (int i = 0; i < nextStudentIndex; i++) {
            for (int j = i + 1; j < nextStudentIndex; j++) {

                if (allStudents[i] != null&&(allStudents[i].name.compareTo(allStudents[j].name) > 0)) {
                    temp = allStudents[i].name;
                    allStudents[i].name = allStudents[j].name;
                    allStudents[j].name = temp;
                }
            }
        }
        for (int i=0;i<allStudents.length;i++)
        {
            if (allStudents[i]!=null)
                allStudents[i].print();
        }
    }
    void sortByMarksAsc()
    {
        int temp;

        for (int i = 0; i < nextStudentIndex; i++)
        {
            for (int j=i+1;j<nextStudentIndex;j++)
            {
                if (allStudents[i]!=null&&allStudents[i].marks > allStudents[j].marks)
                {
                    temp = allStudents[i].marks;
                    allStudents[i].marks = allStudents[j].marks;
                    allStudents[j].marks = temp;
                }
            }
        }
        for (int i=0;i<allStudents.length;i++)
        {
            if (allStudents[i]!=null)
                allStudents[i].print();
        }

    }
    void sortByMarksDesc()
    {
        int temp;

        for (int i = 0; i < nextStudentIndex; i++)
        {
            for (int j=i+1;j<nextStudentIndex;j++)
            {
                if (allStudents[i]!=null&&(allStudents[i].marks < allStudents[j].marks))
                {
                    temp = allStudents[i].marks;
                    allStudents[i].marks = allStudents[j].marks;
                    allStudents[j].marks = temp;
                }
            }
        }
        for (int i=0;i<allStudents.length;i++)
        {
            if (allStudents[i]!=null)
                allStudents[i].print();
        }

    }
    void printHelp()
    {
        System.out.println("Please use the following commands.");
        System.out.println("1. List");
        System.out.println("2. Add");
        System.out.println("3. Modify");
        System.out.println("4. Delete");
        System.out.println("5. Search By Name");
        System.out.println("6. Search By Section");
        System.out.println("7. Search By Greather than marks");
        System.out.println("8. Sort By Name");
        System.out.println("9. Sort By Marks Ascending Order");
        System.out.println("10. Sort By Marks Descending Order");
        System.out.println("11. Top 3 Toppers");
        System.out.println("12. Help");
        System.out.println("13. Exit");
    }
}
class Student
{
    String name;
    int rollNumber;
    char section;
    int marks;
    public Student()
    {
    }

    public Student(String name, int rollNumber, char section, int marks) {

        this.name = name;
        this.rollNumber = rollNumber;
        this.section = section;
        this.marks = marks;
    }
    void print()
    {
        System.out.println(rollNumber + " " + name + " " + section + " " + marks);
    }
}